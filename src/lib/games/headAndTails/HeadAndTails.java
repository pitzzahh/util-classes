package lib.games.headAndTails;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class HeadAndTails {
	private HeadAndTails() {}
		// Head Tails, lmao Warang maisip hahhahhahha
	public static void run() {
		try {
			int number;
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Number: ");
			number = keyboard.nextInt();

			if (number > 0) {
				if (number % 5 == 0) {
					if (number % 3 == 0) {
						System.out.println("HeadTail");
					// HeadTails if number is divisible by 5 and 3.
					}
					else {
						System.out.println("Head");
					}
					// Head if number is divisible by 5.
				}
				else if (number % 3 == 0) {
					System.out.println("Tail");
					// Tail if number is divisible by 3.
				}
				else {
					System.out.println(number);
					// if not, inserted number will be printed out.
				}
			}
			keyboard.close();
		}
		catch (InputMismatchException e) {
			System.out.println("NUMBERS ONLY");
		}
	}
}

		





