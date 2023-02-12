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
    public void analyze(String program_original) {
        // Padrões de expressão regular para cada token
        String opRegex = "[+\\-*/<!.,=&&]";
        String delimRegex = "[(){}\\[\\];]";
        String declRegex = "class|extends|public|static|void|main|length|this|new";
        String fluxoRegex = "if|else|while|return|System\\.out\\.println";
        String tipoRegex = "boolean|int |true|false|String";
        String idRegex = "[a-zA-Z][a-zA-Z0-9]*";
        String commentRegex = "/\\*.*?\\*/";
        String stringRegex = "\".*?\"";
        // Compila os padrões de expressão regular
        Pattern opPattern = Pattern.compile(opRegex);
        Pattern delimPattern = Pattern.compile(delimRegex);
        Pattern declPattern = Pattern.compile(declRegex);
        Pattern fluxoPattern = Pattern.compile(fluxoRegex);
        Pattern tipoPattern = Pattern.compile(tipoRegex);
        Pattern idPattern = Pattern.compile(idRegex);
        Pattern commentPattern = Pattern.compile(commentRegex);
        // Procurar e analisar cada token no programa
        String program = program_original.replaceAll(commentRegex, "/* */").replaceAll(stringRegex, "\" \"");
        System.out.println(program); 
        // retira o conteudo de todos comentários.
        Matcher matcher = commentPattern.matcher(program);
        while (matcher.find()) {
            String word = matcher.group();
            addOccurrence("Coment", word);
        }
        program = program.replaceAll(commentRegex, " ").replaceAll(stringRegex, ""); 
        // retira todos comentários com /* */.

        matcher = opPattern.matcher(program);
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

        /* Retira todos os tokens das analises passadas o que sobrar provavelmente é identificador*/
        program = program.replaceAll(declRegex, " ");
        program = program.replaceAll(delimRegex, " ");
        program = program.replaceAll(fluxoRegex, " ");
        program = program.replaceAll(opRegex, " ");
        program = program.replaceAll(tipoRegex, " ");

        matcher = idPattern.matcher(program);
        while (matcher.find()) {
            String word = matcher.group();
            addOccurrence("ID", word);
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
            System.out.println("<" + token + " => número de ocorrências " + occurrences.get(token));
        }
    }
}