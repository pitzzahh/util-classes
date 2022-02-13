package lib.computing.calculateHypotenuse;

import lib.utilities.misc.Decorations;
import lib.utilities.misc.InputChecker;
import java.util.Scanner;

public final class HypotenuseComputer {
	/**
	 * Cannot instantiate this class.
	 */
	private HypotenuseComputer() {}
	public static void runComputeHypotenuse() {
		Scanner scanner = new Scanner(System.in);
		double x;
		double y;
		while (true) {
			System.out.print("Enter side x: ");
			String x_axis = scanner.nextLine().trim();
			if (InputChecker.isDouble(x_axis)) {
				x = Double.parseDouble(x_axis);
				break;
			}
			else {
				Decorations.show.notANumber();
			}
		}
		while (true) {
			System.out.print("Enter side y: ");
			String y_axis = scanner.nextLine().trim();
			if (InputChecker.isDouble(y_axis)) {
				y = Double.parseDouble(y_axis);
				break;
			}
			else {
				Decorations.show.notANumber();
			}
		}

		double z = Math.sqrt((x * x) + (y * y));
		
		System.out.println("The hypotenuse is " + z);
		scanner.close();
	}
}
