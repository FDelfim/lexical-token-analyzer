package com.main;

public class Main {
    public static void main(String[] args) {
        String program = "class Test { public static void main(String[] args) { int x = 5; System.out.println(x); } }";
        Lexer lexer = new Lexer();
        lexer.analyze(program);
        lexer.printTokens();
    }
}
