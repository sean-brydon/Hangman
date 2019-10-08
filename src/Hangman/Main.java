package Hangman;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //    private static RectangularShape Chars;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Character> Chars;
    int lives=0;


    public static void main(String[] args) {
        Main m = new Main();
        m.Chars = m.charArray();
        m.start();
//        m.hideWord("The Dark");
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
        String name1 = scanner.nextLine();
        System.out.printf("Welcome to Hangman %s\n", name1);
        System.out.println("Player Two Please Enter your name");
        String name2 = scanner.nextLine();
        System.out.printf("Welcome to Hangman %s\n", name2);
        HangmanInit hang = new HangmanInit();
        System.out.printf("Please Enter the word you would like to pick %s!  ",name1);
        String word = scanner.nextLine().toUpperCase();
        word = hideWord(word);
        char[] wordLetters = word.toCharArray();
        System.out.printf("The word you have chosen is %s",word);
        letterGuess(wordLetters,name1,name2);

    }

    private void letterGuess(char[] wordLetters,String name1,String name2) {
        System.out.printf("%s[ please guess a letter", name2);
        String guess = scanner.nextLine().toUpperCase();
        int count = 0;
        for (int i = 0; i < wordLetters.length; i++) {
            if (guess.equals(wordLetters[i])){
                System.out.printf("Well done %s! %s is present in %s's word",name2,guess,name1);
                showLetter(wordLetters,guess);

            }else{
                count++;
                if (count == wordLetters.length){
                    System.out.printf("%s is not present in %s's word",guess,name1);
                    lives++;
                    HangmanInit hang = new HangmanInit();
                    System.out.println(hang.hangman[lives]);
                    if(lives == 8){
                        System.out.println("You are DEAD!");
                        Main main = new Main();
                        main.start();
                    }
                }

            }
        }
    }

    private String showLetter(char[] wordLetters, String guess) {
        StringBuilder sb = new StringBuilder();
//        String hiddenword = "";
        for (char c : wordLetters) {
            if (Chars.contains(guess)) {
                sb.append(guess);
//                hiddenword += "_ ";
            } else {
                if (Chars.contains(" ")) {
                    sb.append("_ ");
//                hiddenword += "_ ";
                } else {
                    sb.append("/ ");
//                hiddenword += "/ ";
                }
            }
        }
        return sb.toString();
    }



    private String hideWord(String word) {
        char[] wordLetters = word.toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        String hiddenword = "";
        for (char c : wordLetters) {
            if (Chars.contains(c)) {
                sb.append("_ ");
//                hiddenword += "_ ";
            } else {
                sb.append("/ ");
//                hiddenword += "/ ";
            }
        }
        return sb.toString();
//        System.out.println(sb.toString());
//        System.out.println(hiddenword);
    }


}
