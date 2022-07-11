package com.github.pitzzahh.utilities.misc;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.function.Predicate;
import com.github.pitzzahh.utilities.validation.Validator;

public final class Prompt {
    /**
     * Outputs Press Enter To Continue in green color, and blue text color.
     */
    public void pressEnterToContinue() {
        System.out.println(Decorations.Color.GREEN.getColor() + "=========================" + Decorations.Color.RESET.getColor());
        System.out.println(Decorations.Color.GREEN.getColor() + "|" + Decorations.Color.BLUE.getColor() + "PRESS ENTER TO CONTINUE" + Decorations.Color.GREEN.getColor() + "|" + Decorations.Color.RESET.getColor());
        System.out.println(Decorations.Color.GREEN.getColor() + "=========================" + Decorations.Color.RESET.getColor());
    }

    /**
     * Supplies invalid choice in red color if the user did not input the required fields.
     */
    public Supplier<String> invalidChoice = () ->
            Decorations.Color.RED.getColor() +
                    " ┬ ┌┐┌ ┬  ┬┌─┐┬  ┬┌┬┐  ┌─┐┬ ┬┌─┐┬┌─┐┌─┐  ┬\n" +
                    " │ │││ └┐┌┘├─┤│  │ ││  │  ├─┤│ │││  ├┤   │\n" +
                    " ┴ ┘└┘  └┘ ┴ ┴┴─┘┴─┴┘  └─┘┴ ┴└─┘┴└─┘└─┘  o"   +
                    Decorations.Color.RESET.getColor();
    /**
     * Supplies error in red color if an exception occurred.
     */
    public Supplier<String> error = () -> Decorations.Color.RED.getColor() +
            " ╔═╗╦═╗╦═╗╔═╗╦═╗\n" +
            " ║╣ ╠╦╝╠╦╝║ ║╠╦╝\n" +
            " ╚═╝╩╚═╩╚═╚═╝╩╚═"   +
            Decorations.Color.RESET.getColor();

    /**
     * Simple prompt to ask the user to try again or not.
     * @throws InterruptedException if something went wrong.
     */
    public boolean tryAgain() throws InterruptedException {
        boolean check = true;
        while (check) {
            System.out.println(Decorations.Color.YELLOW.getColor() +
                    " ┌┬┐┌─┐  ┬ ┬┌─┐┬ ┬  ┬ ┬┌─┐┌┐┌┌┬┐  ┌┬┐┌─┐  ┌┬┐┬─┐┬ ┬  ┌─┐┌─┐┌─┐┬┌┐┌┌─┐\n" +
                    "  │││ │  └┬┘│ ││ │  │││├─┤│││ │    │ │ │   │ ├┬┘└┬┘  ├─┤│ ┬├─┤││││ ┌┘\n" +
                    " ─┴┘└─┘   ┴ └─┘└─┘  └┴┘┴ ┴┘└┘ ┴    ┴ └─┘   ┴ ┴└─ ┴   ┴ ┴└─┘┴ ┴┴┘└┘ o ");
            System.out.println(Decorations.Color.GREEN.getColor() + ": Y : Yes");
            System.out.println(Decorations.Color.RED.getColor()   + ": N : No");
            System.out.println(Decorations.Color.PURPLE.getColor() + ">>>: ");
            String choice = new Scanner(System.in).nextLine().trim();
            if (Validator.isLetter().apply(choice)) {
                if (Validator.isYes().apply(choice)) return true;
                if (Validator.isNo().apply(choice)) return false;
            }
            else System.out.println("Y or N only");
        }
        return false;
    }

}
