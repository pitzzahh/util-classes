package lib.utilities.misc;

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;
/**
 * Utility class used in making pins or passwords.
 * Available choices:
 * <p>1. Random Numbers
 * <p>2. Random Letters
 * <p>3. User defined
 */
public final class PinGenerator {
    // Cannot instantiate this class
    private PinGenerator() {}

    // Random class object
    private static final Random random = new Random();
    private static char[] pin;

    /**
     * Method that generates a pin.
     * random pin or user defined pin.
     * If the user did not follow the flow of the code, the program will return a pin that contains with mixed
     * of numbers and letters.
     * @throws InterruptedException if the thread is interrupted
     * @return oneTimePin the pin in a char array
     */
    public static char[] generatePin() throws InterruptedException {
        // dito pipili ng random numbers,letters or mixed
        String numbers = "1234567890";
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String mixed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVYXYZ1234567890";

        Scanner scanner = new Scanner(System.in);
        String response;
        String pinType = "";
        System.out.println(Decorations.Color.YELLOW.getColor() + "WHAT TYPE OF PIN YOU WANT TO USE?");
        System.out.println(Decorations.Color.GREEN.getColor() + ": 1 : random numbers");
        System.out.println(Decorations.Color.GREEN.getColor() + ": 2 : random letters");
        System.out.println(Decorations.Color.GREEN.getColor() + ": 3 : choose your own pin");
        System.out.print(Decorations.Color.YELLOW.getColor() + ">>>: ");
        response = scanner.nextLine().trim();
        // dito i check if yung laman ng inputs it nandun sa char array na oneTimePin

        // field on how long the pin is
        byte lengthOfPin;
        if (response.equals("1") || response.equals("2")) {
            switch (response) {
                case "1" -> pinType = "NUMBERS";
                case "2" -> pinType = "LETTERS";
                default -> {
                    lengthOfPin = 6;
                    Decorations.show.invalidChoice();
                    System.out.println(Decorations.Color.YELLOW.getColor() + "THE TYPE OF PIN WILL BE A MIXED OF LETTERS AND NUMBERS");
                    System.out.printf(Decorations.Color.YELLOW.getColor() + "YOUR PIN LENGTH WILL BE %d characters long\n", lengthOfPin);
                }
            }
            while (true) {
                System.out.println(Decorations.Color.GREEN.getColor() + "HOW LONG YOU WANT YOUR PIN TO BE?");
                System.out.print(Decorations.Color.YELLOW.getColor() + ">>>: ");
                response = scanner.nextLine().trim();
                if (InputChecker.isByte(response)) {
                    lengthOfPin = Byte.parseByte(response);
                    if (lengthOfPin >= 1 && lengthOfPin <= 3) {
                        System.out.println(Decorations.Color.YELLOW.getColor() + "PIN LENGTH IS TOO SHORT\nPLEASE TRY LONGER PIN LENGTH");
                    } else if (lengthOfPin >= 4 && lengthOfPin <= 6) {
                        break;
                    } else {
                        if (lengthOfPin >= 7) {
                            System.out.println(Decorations.Color.YELLOW.getColor() + "PIN LENGTH IS TOO LONG");
                        }
                        if (lengthOfPin == 0) {
                            System.out.println(Decorations.Color.YELLOW.getColor() + "PIN LENGTH CANNOT BE 0");
                        }
                    }
                } else {
                    lengthOfPin = 6;
                    Decorations.show.invalidChoice();
                    System.out.println(Decorations.Color.RED.getColor() + "YOUR PIN LENGTH SHOULD BE A NUMBER");
                    System.out.printf(Decorations.Color.RESET.getColor() + "YOUR PIN LENGTH WILL BE %d characters long\n", lengthOfPin);
                    pin = new char[lengthOfPin];
                    for (int index = 0; index < lengthOfPin; index++) {
                        // dito i store niya lang sa listahan yung 10 numbers na generated
                        pin[index] = mixed.charAt(random.nextInt(mixed.length()));
                    }
                    break;
                }
            }
            // storing each randomly generated characters into this char array
            pin = new char[lengthOfPin];
            // checks which type of pin is it
            switch (pinType) {
                case "NUMBERS" -> {
                    // generates random numbers regarding
                    for (int index = 0; index < lengthOfPin; index++) {
                        // dito i store niya lang sa listahan yung 4 numbers na generated
                        pin[index] = numbers.charAt(random.nextInt(numbers.length()));
                    }
                }
                case "LETTERS" -> {
                    for (int index = 0; index < lengthOfPin; index++) {
                        // dito i store niya lang sa listahan yung 6 numbers na generated
                        pin[index] = letters.charAt(random.nextInt(letters.length()));
                    }
                }
                default -> {
                    for (int index = 0; index < lengthOfPin; index++) {
                        // dito i store niya lang sa listahan yung 10 numbers na generated
                        pin[index] = mixed.charAt(random.nextInt(mixed.length()));
                    }
                }
            }
        }
        else if (response.equals("3")) {
            System.out.print(Decorations.Color.GREEN.getColor() + "ENTER YOUR OWN PIN: ");
            String pin = scanner.nextLine();
            PinGenerator.pin = pin.toCharArray();
            TimeUnit.MILLISECONDS.sleep(400);
        }
        else {
            lengthOfPin = 6;
            Decorations.show.invalidChoice();
            System.out.println(Decorations.Color.RED.getColor() + "THE TYPE OF PIN WILL BE A MIXED OF LETTERS AND NUMBERS");
            System.out.printf(Decorations.Color.RESET.getColor() + "YOUR PIN LENGTH WILL BE %d characters long\n", lengthOfPin);
            pin = new char[lengthOfPin];
            for (int index = 0; index < lengthOfPin; index++) {
                // dito i store niya lang sa listahan yung 10 numbers na generated
                pin[index] = mixed.charAt(random.nextInt(mixed.length()));
            }
        }
        return pin;
    }

    /**
     * Prints the user pin.
     * @param pin the {@code char[]} array containing the pin.
     */
    public static void printPin(char[] pin) {
        System.out.println(Decorations.Color.GREEN.getColor() + "=========================");
        System.out.print(Decorations.Color.YELLOW.getColor() + "YOUR PIN: ");
        for (char c : pin) {
            System.out.print(Decorations.Color.PURPLE.getColor() + c);
        }
        System.out.println(Decorations.Color.GREEN.getColor() + "\n=========================");
    }
}
