package lib.utilities.quadrantAnalyzer;

import java.util.Scanner;

public final class QuadrantAnalyzer {
	//cannot instantiate this class
	private QuadrantAnalyzer() {}
	public static void run() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter value of x: ");
		byte x = scanner.nextByte();
		System.out.print("Enter value of y: ");
		byte y = scanner.nextByte();

		whichQuadrant(x,y);
		// closes tha scanner
		scanner.close();
	}
	/**
	 * Method that identifies which quadrant the point is.
	 * @param x the x position on the board
	 * @param y the y position on the board
	 */
	private static void whichQuadrant(byte x, byte y) {
		if (x > 0 && y > 0) {
			System.out.println("lies in First quadrant");
		}
	    else if (x < 0 && y > 0) {
	    	System.out.println("lies in Second quadrant");
	    }
	    else if (x < 0 && y < 0) {
	    	System.out.println("lies in Third quadrant");
	    }
	    else if (x > 0 && y < 0) {
	    	System.out.println("lies in Fourth quadrant");
	    }
	    else {
	    	System.out.println("Lies at the origin");
	    }
	}
}
