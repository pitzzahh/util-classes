package lib.games.guessingGames.guessTheWords;

import lib.utilities.inputChecker.InputChecker;
import java.util.Scanner;
import java.util.Arrays;

public final class GuessTheWord {
    private GuessTheWord() {}

    private static String[] wordsToGuess;

    private void addGuessingWords () {
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
    public void runGuess() {
        addGuessingWords();
        System.out.println("WORDS: " + Arrays.toString(wordsToGuess));
        String choice;
        boolean userRecognized = false;
        boolean wholeCondition = true;
        boolean switchCondition;
        boolean check = true;
        while (wholeCondition) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("GUESS SOME OF THE SECRET WORDS");
            System.out.print("ENTER HERE: ");
            choice = userInput.nextLine().trim();
            while(check) {
                for(String i : wordsToGuess) {
                    if (choice.equals(i)) {
                        userRecognized = true;
                    }
                    check = false;
                }
            }
            if (userRecognized) {
                System.out.println("I LOVE THAT WORD!");
            } 
            else {
                System.out.println("THAT IS NOT THE WORD!");
            }
            switchCondition = true;
            while (switchCondition) {
                System.out.print("Would you like to try again?(Yes) or (No): ");
                String response = userInput.next().toUpperCase().trim();

                switch (response) {
                    case "YES" -> {
                        System.out.println(":-----------------------------------:");
                        System.out.println(":            HAVE FUN!              :");
                        System.out.println(":-----------------------------------:");
                        userRecognized = false;
                        check = true;
                        switchCondition = false;
                    }
                    case "NO" -> {
                        System.out.println(":--------------------------------:");
                        System.out.println(": THANK YOU FOR USING MY PROGRAM :");
                        System.out.println(":--------------------------------:");
                        wholeCondition = false;
                        switchCondition = false;
                        userInput.close();
                    }
                    default -> System.out.println("Invalid Choice!\n");
                }
            }
        }
    }
}

