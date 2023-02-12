package com.main;

public class Main {
    public static void main(String[] args) {
        String program_original = "class Test { public static void main(String[] args) /*teste*/{ int x = 5*5; x = x/5; System.out.println(x); /*while while while */} }";
        Lexer lexer = new Lexer();
        lexer.analyze(program_original);
        lexer.printTokens();
    }
    /*teste */
}
