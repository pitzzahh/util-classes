package lib.computing.calculateHypotenuse;

import java.util.Scanner;

public final class HypotenuseComputer {
	// Cannot instantiate this class
	private HypotenuseComputer() {}
	public static void runComputeHypotenuse() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter side x: ");
		double x = scanner.nextDouble();
		System.out.print("Enter side y: ");
		double y = scanner.nextDouble();

		double z = Math.sqrt((x * x) + (y * y));
		
		System.out.println("The hypotenuse is " + z);
		scanner.close();
	}
}
