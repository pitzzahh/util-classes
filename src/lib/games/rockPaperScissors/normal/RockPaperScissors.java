package lib.games.rockPaperScissors.normal;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Peter John Arao
 * @date November 13, 2021
 */
public final class RockPaperScissors {

    static boolean playerOne = true;
    static boolean playerTwo = true;
    static String playerOneAnswer = "";
    static String computerAnswer = "";
    static char playerOneInput = 0;
    static int playerTwoInput = 0;
    static byte playerOneWinCount = 0;
    static byte computerWinCount = 0;
    static byte count = 0;
    static byte winCount = 5;
    
    public void run() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		resetConditions();
		resetCounts();
		System.out.println("#####################");
		System.out.println(" ROCK PAPER SCISSORS ");
		System.out.println("#####################");
		do {
			while (playerOne) {
				System.out.println("\"R\" for ROCK, \"P\" for PAPER, \"S\" for SCISSORS");
				System.out.print("Enter yours: ");
				playerOneInput = scanner.next().toUpperCase().charAt(0);
				if (playerOneInput == 'R' || playerOneInput == 'P' || playerOneInput == 'S') {
					playerOne = false;
				} else {
					System.out.println(":--------------------------------:");
					System.out.println(":      CHOOSE ONLY: R, P, S      :");
					System.out.println(":--------------------------------:");
				}
				//here
			}
			//here
			System.out.println(":-----------------------------------:");
			while (playerTwo) {
				playerTwoInput = random.nextInt(3) + 1;
				playerTwo = false;
			}
			// solving
			switch (playerOneInput) {
				case 'R' -> playerOneAnswer = "Rock";
				case 'P' -> playerOneAnswer = "Paper";
				case 'S' -> playerOneAnswer = "Scissors";
				default -> System.out.println("INVALID!");
			}
			System.out.println("PLAYER 1 : " + playerOneAnswer);
			switch (playerTwoInput) {
				case 1 -> computerAnswer = "Rock";
				case 2 -> computerAnswer = "Paper";
				case 3 -> computerAnswer = "Scissors";
			}
			System.out.println("COMPUTER : " + computerAnswer);
			if (playerOneAnswer.equals("Rock")) {
				switch (computerAnswer) {
					case "Rock" -> System.out.println("\n: TIE :");
					case "Paper" -> computerWinCount++;
					case "Scissors" -> playerOneWinCount++;
					default -> System.out.println();
				}
			}
			if (playerOneAnswer.equals("Paper")) {
				switch (computerAnswer) {
					case "Rock" -> playerOneWinCount++;
					case "Paper" -> System.out.println("\n: TIE :");
					case "Scissors" -> computerWinCount++;
					default -> System.out.println();
				}
			}
			if (playerOneAnswer.equals("Scissors")) {
				switch (computerAnswer) {
					case "Rock" -> computerWinCount++;
					case "Paper" -> playerOneWinCount++;
					case "Scissors" -> System.out.println("\n: TIE :");
					default -> System.out.println();
				}
			}
			if (count <= 5) {
				if (playerOneWinCount > computerWinCount) {
					count++;
				} else if (computerWinCount > playerOneWinCount) {
					count++;
				} else {
					System.out.println();
				}
			}
			if (playerOneWinCount == 5) {
				System.out.println();
				System.out.println("PLAYER 1 WON," + " SCORE: " + playerOneWinCount + "/" + winCount);
				break;
			}
			if (computerWinCount == 5) {
				System.out.println();
				System.out.println("COMPUTER WON," + " SCORE: " + computerWinCount + "/" + winCount);
				break;
			}
			System.out.println();
			System.out.println("PLAYER 1 SCORE: " + playerOneWinCount + "/" + winCount);
			System.out.println("COMPUTER SCORE: " + computerWinCount + "/" + winCount);
			System.out.println(":-----------------------------------:");
		} while (playerOneWinCount != 5 || computerWinCount != 5 && count <= winCount);
		System.out.println(":--------------------------------:");
		System.out.println(": THANK YOU FOR USING MY PROGRAM :");
		System.out.println(":--------------------------------:");
	}
    static void resetConditions() {
		playerOne = true;
		playerTwo = true;
    }
    static void resetCounts() {
		playerOneAnswer = "";
		computerAnswer = "";
		playerOneInput = 0;
		playerTwoInput = 0;
		playerOneWinCount = 0;
		computerWinCount = 0;
		count = 0;
		winCount = 5;
    }
}
