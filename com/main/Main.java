package com.main;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String programa = "";

        try{
            File file = new File("arquivo.txt");
            Scanner sc = new Scanner(file);
            sc.useDelimiter("\\n");

            while(sc.hasNextLine()){
                programa += sc.next() + "\n";
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Erro ao abrir o arquivo");
        }

        Lexer lexer = new Lexer();
        lexer.analyze(programa);
        lexer.printTokens();
    }
}
