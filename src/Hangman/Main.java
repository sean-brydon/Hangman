package Hangman;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //    private static RectangularShape Chars;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Character> Chars;

    public static void main(String[] args) {
        Main m = new Main();
        m.Chars = m.charArray();
        m.start();
    }

    private ArrayList<Character> charArray() {
        char c;
        ArrayList<Character> temp = new ArrayList();
        for (c = 'A'; c <= 'Z'; ++c) temp.add(c);
        return temp;

    }

    private void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to hangman!");
        System.out.println("Please enter your name>");
        String name = scanner.nextLine();
        System.out.printf("Welcome to Hangman %s\n", name);
        HangmanInit hang = new HangmanInit();
        System.out.println("Please Enter the word you would like to pick!");
        String word = scanner.nextLine();
        char[] charWords = word.toCharArray();
        String newWord = "";
        for (char c : charWords) {

            newWord = word.replaceAll(String.valueOf(c), "_");
            System.out.println(newWord);
        }
        System.out.printf("The word you have chosen is %s", newWord);


    }
}
