package lib.utilities.misc;

import java.util.Scanner;

public final class Prompt {

    /**
     * Outputs Press Enter To Continue in green color, and blue text color.
     */
    public void pressEnterToContinue() {
        System.out.println(Decorations.TEXT_GREEN + "=========================" + Decorations.TEXT_RESET);
        System.out.println(Decorations.TEXT_GREEN + "|" + Decorations.TEXT_BLUE + "PRESS ENTER TO CONTINUE" + Decorations.TEXT_GREEN + "|" + Decorations.TEXT_RESET);
        System.out.println(Decorations.TEXT_GREEN + "=========================" + Decorations.TEXT_RESET);
    }
    /**
     * Outputs invalid choice in red color if the user did not input the required fields.
     */
    public void invalidChoice() {
        System.out.println(
                Decorations.TEXT_RED +
                " ┬ ┌┐┌ ┬  ┬┌─┐┬  ┬┌┬┐  ┌─┐┬ ┬┌─┐┬┌─┐┌─┐  ┬\n" +
                " │ │││ └┐┌┘├─┤│  │ ││  │  ├─┤│ │││  ├┤   │\n" +
                " ┴ ┘└┘  └┘ ┴ ┴┴─┘┴─┴┘  └─┘┴ ┴└─┘┴└─┘└─┘  o"   +
                Decorations.TEXT_RESET);
    }
    /**
     * Outputs error in red color if an exception occurred.
     */
    public void error() {
        System.out.println(
                Decorations.TEXT_RED +
                " ╔═╗╦═╗╦═╗╔═╗╦═╗\n" +
                " ║╣ ╠╦╝╠╦╝║ ║╠╦╝\n" +
                " ╚═╝╩╚═╩╚═╚═╝╩╚═"   +
                Decorations.TEXT_RESET);
    }
    /**
     * Simple prompt to ask the user to try again or not.
     * @throws InterruptedException if something went wrong.
     */
    public void simpleTryAgain() throws InterruptedException {
        boolean check = true;
        while (check) {
            System.out.println(Decorations.TEXT_YELLOW +
                    " ┌┬┐┌─┐  ┬ ┬┌─┐┬ ┬  ┬ ┬┌─┐┌┐┌┌┬┐  ┌┬┐┌─┐  ┌┬┐┬─┐┬ ┬  ┌─┐┌─┐┌─┐┬┌┐┌┌─┐\n" +
                    "  │││ │  └┬┘│ ││ │  │││├─┤│││ │    │ │ │   │ ├┬┘└┬┘  ├─┤│ ┬├─┤││││ ┌┘\n" +
                    " ─┴┘└─┘   ┴ └─┘└─┘  └┴┘┴ ┴┘└┘ ┴    ┴ └─┘   ┴ ┴└─ ┴   ┴ ┴└─┘┴ ┴┴┘└┘ o ");
            System.out.println(Decorations.TEXT_GREEN + ": 1 : Yes");
            System.out.println(Decorations.TEXT_RED   + ": 2 : No");
            System.out.println(Decorations.TEXT_PURPLE + ">>>: ");
            String choice = new Scanner(System.in).nextLine().trim();
            switch (choice) {
                case "1" -> {
                    Decorations.printLoading();
                    Delay.dotLoading("short");
                }
                case "2" -> check = false;
            }
        }
    }
}
