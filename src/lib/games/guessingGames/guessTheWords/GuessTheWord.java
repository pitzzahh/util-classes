package lib.games.guessingGames.guessTheWords;

import lib.utilities.misc.InputChecker;
import java.util.Scanner;

public final class GuessTheWord {
    private GuessTheWord() {}

    private static String[] wordsToGuess;

    private static void addGuessingWords() {
        String word;
        byte numberOfWordsToGuess = 0;
        String temporaryString;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("HOW MANY WORDS YOU WANT TO ADD?: ");
            temporaryString = scanner.nextLine().trim();
            if (InputChecker.isByte(temporaryString)) {
                numberOfWordsToGuess = Byte.parseByte(temporaryString);
                wordsToGuess = new String[numberOfWordsToGuess];
            }
            else {
                System.out.println("WRONG PLEASE INPUT HOW MANY IS THE WORDS OR NUMBERS YOU WANT TO GUESS");
            }
        } while (!InputChecker.isByte(temporaryString));
        for (int i = 0; i < numberOfWordsToGuess; i++) {
            System.out.print("TYPE THE WORDS OR NUMBERS YOU WANT TO ADD TO THE GUESS: ");
            word = scanner.nextLine().trim();
            wordsToGuess[i] = word;
        }
    }
    public static void runGuess() {
        addGuessingWords();
        String choice;
        boolean userRecognized = false;
        Scanner userInput = new Scanner(System.in);
        System.out.println("GUESS SOME OF THE SECRET WORDS");
        System.out.print("ENTER HERE: ");
        choice = userInput.nextLine().trim();
        for(String i : wordsToGuess) {
            if (choice.equals(i)) {
                userRecognized = true;
                break;
            }
        }
        if (userRecognized) {
            System.out.println("CORRECT WORD!");
        }
        else {
            System.out.println("THAT IS NOT THE WORD!");
        }
        System.out.println(":--------------------------------:");
        System.out.println(": THANK YOU FOR USING MY PROGRAM :");
        System.out.println(":--------------------------------:");

    }
}

