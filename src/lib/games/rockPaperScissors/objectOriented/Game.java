package lib.games.rockPaperScissors.objectOriented;

import java.util.Scanner;

final class Game {
    private static byte HumanWinCount;
    private static byte ComputerWinCount;
    private static byte HumanLossCount;
    private static byte ComputerLossCount;
    private static byte tieCount;
    static Scanner scanner;
    static Human human;
    static Computer computer;
    private static byte whoReallyWon;

    private Game() {
    }

    static void startTheGameFellas() {
        System.out.println("==================================");
        System.out.println("      #####################       ");
	    System.out.println("       ROCK PAPER SCISSORS        ");
	    System.out.println("      #####################       ");
        System.out.println("==================================");
        System.out.print("PLEASE ENTER YOUR NAME: ");
        String humanName = scanner.nextLine().trim();
        whoReallyWon = 0;
        human.setPlayerName(humanName);
        human.selectChoice();
        computer.selectChoice();
        whoWon();
        displayPlayerChoices();
        displayWinner(whoReallyWon);
        updatePlayerScores(whoReallyWon);
        switch (whoReallyWon) {
            case 1 -> displayPlayerOneScore();
            case 2 -> displayComputerScore();
            case 3 -> {
                System.out.println("TIE COUNT: " + tieCount);
                displayPlayerOneScore();
                displayComputerScore();
            }
        }
    }
    // displays the human player score
    private static void displayPlayerOneScore() {
        System.out.println("==================================");
        System.out.println("NAME OF PLAYER: " + human.getPlayerName());
        System.out.println("NUMBER OF WINS: " + HumanWinCount);
        System.out.println("NUMBER OF LOSS: " + HumanLossCount);
        System.out.println("==================================");

    }
    // displays the computer score
    private static void displayComputerScore() {
        System.out.println("==================================");
        System.out.println("NAME OF PLAYER: " + computer.getPlayerName());
        System.out.println("NUMBER OF WINS: " + ComputerWinCount);
        System.out.println("NUMBER OF LOSS: " + ComputerLossCount);
        System.out.println("==================================");
    }

    private static void displayPlayerChoices() {
        System.out.println("HUMAN SELECTED   : " + human.getPlayerChoice());
        System.out.println("COMPUTER SELECTED: " + computer.getPlayerChoice());
    }

    private static void displayWinner(byte whoIsIT) {
        System.out.print("RESULT: ");
        switch (whoIsIT) {
            case 1 -> System.out.print("HUMAN WON\n");
            case 2 -> System.out.print("COMPUTER WON\n");
            case 3 -> System.out.print("TIE\n");
        }
    }
    private static void whoWon() {

        /* 1 = human wins
         * 2 = computer wins
         * 3 = tie
         */
        
		if(human.getPlayerChoice().equals("ROCK")) {
            switch (computer.getPlayerChoice()) {
                case "ROCK" -> whoReallyWon = 3;
                case "PAPER" -> whoReallyWon = 2;
                case "SCISSORS" -> whoReallyWon = 1;
            }
		}
        if(human.getPlayerChoice().equals("PAPER")) {
            switch (computer.getPlayerChoice()) {
                case "ROCK" -> whoReallyWon = 1;
                case "PAPER" -> whoReallyWon = 3;
                case "SCISSORS" -> whoReallyWon = 2;
            }
		}
        if(human.getPlayerChoice().equals("SCISSORS")) {
            switch (computer.getPlayerChoice()) {
                case "ROCK" -> whoReallyWon = 2;
                case "PAPER" -> whoReallyWon = 1;
                case "SCISSORS" -> whoReallyWon = 3;
            }
		}
    }
    public static void updatePlayerScores(byte whoIsTheWinner) {
        /*
         * 1 = human
         * 2 = computer
         * 3 = tie
         */
        switch (whoIsTheWinner) {
            case 1 -> {
                HumanWinCount++;
                ComputerLossCount++;
            }
            case 2 -> {
                ComputerWinCount++;
                HumanLossCount++;
            }
            case 3 -> tieCount++;
        }
    }
}