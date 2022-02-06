package lib.games.guessingGames.myFirstGuessingGame;

import java.util.Scanner;

public final class MyFirstGuessingGame {
	private MyFirstGuessingGame() {}
	public static void run() {
		Scanner keyboardInput = new Scanner(System.in);
		String correctAnswer1 =  "20";
		String correctAnswer2 = "twenty";
		String guess;
		byte guessCount = 0;
		byte guessLimit = 5;

		
		// This is a loop to make users guess again if their guess is wrong
		while (true) {
			System.out.println(":--------------------:");
			System.out.println("Guess, 10 + 5 x 2 = ?");
			System.out.println(":--------------------:");
			System.out.print("Enter your guess myFriend: ");
			guess = keyboardInput.nextLine().toLowerCase();
			guessCount++;
			// What happens in the following lines is, the user is prompted on how many guesses he/she had left.
			if ( guess.equals( correctAnswer1 ) || guess.equals( correctAnswer2 )) {
				System.out.println();
				System.out.println(":--------------------:");
				System.out.println("YOU WIN , SO SO SMART!");
				System.out.println(":--------------------:");
				break;
			}
			else  {
				System.out.println();
				System.out.println(":---------------------:");
				System.out.println("         WRONG        ");
				System.out.println("   " + ( guessLimit - guessCount ) + " more guesses");
				System.out.println("Are you tired guessing?");
			}
			if ( guessCount == guessLimit ) {
				System.out.println(":---------------:");
				System.out.println(" OUT OF GUESSES!");
				System.out.println("     BYE-BYE");
				System.out.println(":---------------:");
				keyboardInput.close();
				break;
			}
		}
	}
}