package com.main;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    // Ocorrências de cada token
    private HashMap<String, Integer> occurrences;

    // Construtor
    public Lexer() {
        occurrences = new HashMap<>();
    }

    // Analisador léxico
    public void analyze(String program) {
        // Padrões de expressão regular para cada token
        String opRegex = "[+\\-*/<!.,=&&]";
        String delimRegex = "[(){}\\[\\];]";
        String declRegex = "class|extends|public|static|void|main|length|this|new";
        String fluxoRegex = "if|else|while|return|System\\.out\\.println";
        String tipoRegex = "boolean|int|true|false|String";
        String idRegex = "[a-zA-Z][a-zA-Z0-9]*";
        String commentRegex = "/\\*.*?\\*/";
        // Compila os padrões de expressão regular
        Pattern opPattern = Pattern.compile(opRegex);
        Pattern delimPattern = Pattern.compile(delimRegex);
        Pattern declPattern = Pattern.compile(declRegex);
        Pattern fluxoPattern = Pattern.compile(fluxoRegex);
        Pattern tipoPattern = Pattern.compile(tipoRegex);
        Pattern idPattern = Pattern.compile(idRegex);
        Pattern commentPattern = Pattern.compile(commentRegex);
        // Procurar e analisar cada token no programa
        Matcher matcher = opPattern.matcher(program);
        while (matcher.find()) {
            String word = matcher.group();
            addOccurrence("OP", word);
        }
        matcher = delimPattern.matcher(program);
        while (matcher.find()) {
            String word = matcher.group();
            addOccurrence("DELIM", word);
        }
        matcher = declPattern.matcher(program);
        while (matcher.find()) {
            String word = matcher.group();
            addOccurrence("DECL", word);
        }
        matcher = fluxoPattern.matcher(program);
        while (matcher.find()) {
            String word = matcher.group();
            addOccurrence("FLUXO", word);
        }
        matcher = tipoPattern.matcher(program);
        while (matcher.find()) {
            String word = matcher.group();
            addOccurrence("TIPO", word);
        }
        matcher = idPattern.matcher(program);
        while (matcher.find()) {
            String word = matcher.group();
            addOccurrence("ID", word);
        }
        matcher = commentPattern.matcher(program);
        while (matcher.find()) {
            String word = matcher.group();
            // Ignorando comentários
        }
    }

    // Adiciona o token à lista de ocorrências
    private void addOccurrence(String token, String word) {
        if (occurrences.containsKey(token + ":" + word)) {
            occurrences.put(token + ":" + word, occurrences.get(token + ":" + word) + 1);
        } else {
            occurrences.put(token + ":" + word, 1);
        }
    }

    // Imprime a lista de ocorrências de cada token
    public void printTokens() {
        for (String token : occurrences.keySet()) {
            System.out.println("<" + token + ", " + occurrences.get(token) + ">");
        }
    }
}