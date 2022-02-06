package lib.games.mathProblemGenerator;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public final class MathProblemGenerator extends Methods {
    static Scanner userInput;
    static byte correctCount = 0;
    static byte wrongCount = 0;
    static byte playCount = 0;
    static byte level = 1;
    static byte oldPlayCount;
    static byte newPromptCount = 10; // if the user solved 5 times, the user will be prompt if he/she wants to continue solving or not
    static final byte newPromptCountAdd = 5; // if the user continues to solve, this will be added to the newPromptCount
    static final byte maxPlayCount = 60; // if the play count is the same as max play count, you will be forced to go back to level 1
    static byte levelCount = 1;     // level count 1 to 5 // this resets to 0
    static byte levelFourTimeOut; // change the timeout for user to input (in seconds)
    static byte levelFiveTimeOut; // if the timeout is done, the user will not be able to answer the said problem
    static byte number = 0;
    static byte correctCountTimeOutAdd = 0; // we will use this to add to time out if the user answers correct 5 times in a row
    static short response = 0;
    static short firstNumber;
    static short secondNumber;
    static short operation;
    static short wholeDecimal = 0;
    static int multiplicationResult;
    static double divisionResult;
    static int additionResult;
    static int subtractionResult;
    static char operator;
    static boolean isNotExit = false;
    static boolean wholeCondition = true;
    static boolean isCorrect = false;
    static boolean isWrong = false;
    static boolean somethingWentWrong = false;
    static double responseForDivision = 0.0;
    static double roundedDivisionResult = 0.00;
    static String answer = "";
    // correct numbers
    static final ArrayList<Short> correctFirstNumber = new ArrayList<>();
    static final ArrayList<Short> correctSecondNumber = new ArrayList<>();
    // correct operator
    static final ArrayList<Character> correctOperator = new ArrayList<>();
    // correct whole number result
    static final ArrayList<Short> correctWholeNumberResult = new ArrayList<>();
    // correct decimal result
    static final ArrayList<Double> correctDivisionResult = new ArrayList<>();
    // wrong numbers
    static final ArrayList<Short> wrongFirstNumber = new ArrayList<>();
    static final ArrayList<Short> wrongSecondNumber = new ArrayList<>();
    // wrong operator
    static final ArrayList<Character> wrongOperator = new ArrayList<>();
    // wrong wholeNumberResult
    static final ArrayList<Short> wrongWholeNumberResult = new ArrayList<>();
    // wrong decimal result
    static final ArrayList<Double> wrongDivisionResult = new ArrayList<>();
    // correct answers in wrong input decimals
    static final ArrayList<Double> correctAnswerDivision = new ArrayList<>();
    // correct answers in wrong whole number inputs
    static final ArrayList<Short> correctAnswerWhole = new ArrayList<>();
    static boolean intro = true;

    public void run() throws InterruptedException {

        userInput = new Scanner(System.in);
        Random random = new Random();
        Random operatorRandom = new Random();
        Methods.greet();
        while (intro) {
            Methods.beginning();
        }
        while(wholeCondition) {
            String goodLuck = "GOODLUCK!";
            String first = "WELCOME TO LEVEL " + level;
            String second = "THE NUMBER YOU ENTERED WILL NOW BE: " + number;
            String third = "THE RANGE OF OPERANDS ARE NOW FROM 1 to " + number;
            switch (levelCount) {
                case 1 -> {
                    if (playCount == 0 && oldPlayCount != 0) {
                        Methods.greet();
                        System.out.println();
                        for (int i = 0; i < first.length(); i++) {
                            TimeUnit.MILLISECONDS.sleep(100);
                            System.out.print(first.charAt(i));
                        }
                        System.out.println();
                        Methods.beginning();
                    } else {
                        System.out.println();
                        for (int i = 0; i < first.length(); i++) {
                            TimeUnit.MILLISECONDS.sleep(100);
                            System.out.print(first.charAt(i));
                        }
                        System.out.println();
                    }
                }
                case 2, 3 -> {
                    System.out.println();
                    for (int i = 0; i < first.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(first.charAt(i));
                    }
                    System.out.println();
                    for (int i = 0; i < second.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(second.charAt(i));
                    }
                    System.out.println();
                    for (int i = 0; i < third.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(third.charAt(i));
                    }
                    System.out.println();
                }
                case 4 -> {
                    levelFourTimeOut = 10;
                    System.out.println();
                    for (int i = 0; i < first.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(first.charAt(i));
                    }
                    System.out.println();
                    for (int i = 0; i < second.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(second.charAt(i));
                    }
                    System.out.println();
                    for (int i = 0; i < third.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(third.charAt(i));
                    }
                    System.out.println();
                    String remainingTimeOutLevelFour = "YOU ONLY HAVE " + levelFourTimeOut + " SECONDS TO ANSWER";
                    for (int i = 0; i < remainingTimeOutLevelFour.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(remainingTimeOutLevelFour.charAt(i));
                    }
                    System.out.println();
                    System.out.println("IF YOU ANSWERED CORRECTLY 5 TIMES IN A ROW\nYOUR TIME LIMIT WILL INCREASE BY 3");
                    System.out.println();
                    boolean exitLoopForLevelFour = true;
                    String responseForLevelFour;
                    while (exitLoopForLevelFour) {
                        System.out.println(" ::ARE YOU READY?::");
                        System.out.println(" type >> READY << if you are ready");
                        System.out.print(">>> ");
                        responseForLevelFour = userInput.next().toUpperCase().trim();

                        if (responseForLevelFour.equals("READY")) {
                            System.out.println();
                            for (int i = 0; i < goodLuck.length(); i++) {
                                TimeUnit.MILLISECONDS.sleep(100);
                                System.out.print(goodLuck.charAt(i));
                            }
                            System.out.println();
                            exitLoopForLevelFour = false;
                        } else {
                            boolean leave = true;
                            while (leave) {
                                String iWantToLeave;
                                System.out.println("IT LOOKS LIKE YOU ARE NOT YET READY");
                                System.out.println("DO YOU WANT TO CONTINUE OR NOT?");
                                System.out.println(" type >> QUIT << if you want to quit");
                                System.out.println(" type >> CONTINUE << if you want to continue");
                                System.out.print(">>> ");
                                iWantToLeave = userInput.next().toUpperCase().trim();

                                if (iWantToLeave.equals("QUIT")) {
                                    System.out.print(" EXITING");
                                    Methods.loading();
                                    exitLoopForLevelFour = false;
                                    isNotExit = false;
                                    wholeCondition = false;
                                    leave = false;
                                } else if (iWantToLeave.equals("CONTINUE")) {
                                    System.out.println("TYPE READY AGAIN IF YOU ARE READY");
                                    leave = false;
                                } else {
                                    String annoyed = "I ASKED YOU TO >> :QUIT: << or >> :CONTINUE: <<";
                                    System.out.println();
                                    for (int i = 0; i < annoyed.length(); i++) {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                        System.out.print(annoyed.charAt(i));
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                case 5 -> {
                    levelFiveTimeOut = 5;
                    correctCountTimeOutAdd = 0;
                    System.out.println();
                    for (int i = 0; i < first.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(first.charAt(i));
                    }
                    System.out.println();
                    for (int i = 0; i < second.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(second.charAt(i));
                    }
                    System.out.println();
                    for (int i = 0; i < third.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(third.charAt(i));
                    }
                    System.out.println();
                    String remainingTimeOutLevelFive = "YOU ONLY HAVE " + levelFiveTimeOut + " SECONDS TO ANSWER";
                    for (int i = 0; i < remainingTimeOutLevelFive.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(remainingTimeOutLevelFive.charAt(i));
                    }
                    System.out.println();
                    System.out.println("IF YOU ANSWERED CORRECTLY 5 TIMES IN A ROW\nYOUR TIME LIMIT WILL INCREASE BY 5");
                    System.out.println();
                    boolean exitLoopForLevelFive = true;
                    String responseForLevelFive;
                    while (exitLoopForLevelFive) {
                        System.out.println(" ::ARE YOU READY?::");
                        System.out.println(" type >> READY << if you are ready");
                        System.out.print(">>> ");
                        responseForLevelFive = userInput.next().toUpperCase().trim();
                        if (responseForLevelFive.equals("READY")) {
                            System.out.println();
                            for (int i = 0; i < goodLuck.length(); i++) {
                                TimeUnit.MILLISECONDS.sleep(100);
                                System.out.print(goodLuck.charAt(i));
                            }
                            System.out.println();
                            exitLoopForLevelFive = false;
                        } else {
                            boolean leave = true;
                            while (leave) {
                                String iWantToLeave;
                                System.out.println("IT LOOKS LIKE YOU ARE NOT YET READY");
                                System.out.println("DO YOU WANT TO CONTINUE OR NOT?");
                                System.out.println(" type >> QUIT << if you want to quit");
                                System.out.println(" type >> CONTINUE << if you want to continue");
                                System.out.print(">>> ");
                                iWantToLeave = userInput.next().toUpperCase().trim();

                                if (iWantToLeave.equals("QUIT")) {
                                    System.out.print(" EXITING");
                                    Methods.loading();
                                    isNotExit = false;
                                    wholeCondition = false;
                                    leave = false;
                                } else if (iWantToLeave.equals("CONTINUE")) {
                                    System.out.println("TYPE READY AGAIN IF YOU ARE READY");
                                    leave = false;
                                } else {
                                    String annoyed = "I ASKED YOU TO >> :QUIT: << or >> :CONTINUE: <<";
                                    System.out.println();
                                    for (int i = 0; i < annoyed.length(); i++) {
                                        TimeUnit.MILLISECONDS.sleep(100);
                                        System.out.print(annoyed.charAt(i));
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    }
                    System.out.println();
                }
            }
            if (isNotExit) {
                levelCount = 0;
                Methods.reset();
                System.out.print("GENERATING MATH PROBLEM");
                Methods.loading();
                firstNumber = (short) (random.nextInt(number)+1);
                secondNumber = (short) (random.nextInt(number)+1);

                multiplicationResult = firstNumber * secondNumber;
                divisionResult = (double)firstNumber / (double)secondNumber;
                additionResult = firstNumber + secondNumber;
                subtractionResult = firstNumber - secondNumber;

                operation = (short) (operatorRandom.nextInt(4)+1);

                switch (operation) {
                    case 1 -> {
                        operator = '*';
                        if (level == 5) {
                            System.out.println("MULTIPLICATION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            Methods.getChoiceWithTimeout(levelFiveTimeOut);
                            Methods.multiply();
                        } else if (level == 4) {
                            System.out.println("MULTIPLICATION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            Methods.getChoiceWithTimeout(levelFourTimeOut);
                            Methods.multiply();
                        } else {
                            System.out.println("MULTIPLICATION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            System.out.print(">>> ");
                            answer = userInput.next().trim();
                            Methods.multiply();
                        }
                    }
                    case 2 -> {
                        while (firstNumber < secondNumber) {
                            firstNumber = (short) (random.nextInt(number) + 1);
                            secondNumber = (short) (random.nextInt(number) + 1);
                            divisionResult = (double) firstNumber / (double) secondNumber;
                        }
                        operator = '/';
                        if (level == 5) {
                            System.out.println("DIVISION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            Methods.getChoiceWithTimeout(levelFiveTimeOut);
                            Methods.divide(divisionResult);
                        } else if (level == 4) {
                            System.out.println("DIVISION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            Methods.getChoiceWithTimeout(levelFourTimeOut);
                            Methods.divide(divisionResult);
                        } else {
                            System.out.println("DIVISION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            System.out.print(">>> ");
                            answer = userInput.next().trim();
                            Methods.divide(divisionResult);
                        }
                    }
                    case 3 -> {
                        operator = '+';
                        if (level == 5) {
                            System.out.println("ADDITION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            Methods.getChoiceWithTimeout(levelFiveTimeOut);
                            Methods.add();
                        } else if (level == 4) {
                            System.out.println("ADDITION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            Methods.getChoiceWithTimeout(levelFourTimeOut);
                            Methods.add();
                        } else {
                            System.out.println("ADDITION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            System.out.print(">>> ");
                            answer = userInput.next().trim();
                            Methods.add();
                        }
                    }
                    case 4 -> {
                        operator = '-';
                        if (level == 5) {
                            System.out.println("SUBTRACTION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            Methods.getChoiceWithTimeout(levelFiveTimeOut);
                            Methods.subtract();
                        } else if (level == 4) {
                            System.out.println("SUBTRACTION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            Methods.getChoiceWithTimeout(levelFourTimeOut);
                            Methods.subtract();
                        } else {
                            System.out.println("SUBTRACTION");
                            System.out.println(firstNumber + " " + operator + " " + secondNumber + " =");
                            System.out.print(">>> ");
                            answer = userInput.next().trim();
                            Methods.subtract();
                        }
                    }
                }
                // adding values to the array
                if(isCorrect) {
                    switch (operation) {
                        case 1 -> {
                            correctFirstNumber.add(firstNumber);
                            correctOperator.add(operator);
                            correctSecondNumber.add(secondNumber);
                            correctWholeNumberResult.add((short) multiplicationResult);
                        }
                        case 2 -> {
                            // new revised
                            if (responseForDivision == roundedDivisionResult) {
                                if (firstNumber == secondNumber || firstNumber % secondNumber == 0 || secondNumber == 1) {
                                    wholeDecimal = (short) Math.floor(roundedDivisionResult);
                                    if (secondNumber % 3 != 0) {
                                        if (responseForDivision == wholeDecimal) {
                                            wholeDecimal = (short) roundedDivisionResult;
                                            correctFirstNumber.add(firstNumber);
                                            correctOperator.add(operator);
                                            correctSecondNumber.add(secondNumber);
                                            correctWholeNumberResult.add(wholeDecimal);
                                        } else {
                                            correctFirstNumber.add(firstNumber);
                                            correctOperator.add(operator);
                                            correctSecondNumber.add(secondNumber);
                                            correctDivisionResult.add(roundedDivisionResult);
                                        }
                                    } else if (responseForDivision != wholeDecimal) {
                                        correctFirstNumber.add(firstNumber);
                                        correctOperator.add(operator);
                                        correctSecondNumber.add(secondNumber);
                                        correctDivisionResult.add(roundedDivisionResult);
                                    } else {
                                        wholeDecimal = (short) roundedDivisionResult;
                                        correctFirstNumber.add(firstNumber);
                                        correctOperator.add(operator);
                                        correctSecondNumber.add(secondNumber);
                                        correctWholeNumberResult.add(wholeDecimal);
                                    }
                                } else {
                                    if (responseForDivision == wholeDecimal) {
                                        wholeDecimal = (short) roundedDivisionResult;
                                        correctFirstNumber.add(firstNumber);
                                        correctOperator.add(operator);
                                        correctSecondNumber.add(secondNumber);
                                        correctWholeNumberResult.add(wholeDecimal);
                                    } else {
                                        correctFirstNumber.add(firstNumber);
                                        correctOperator.add(operator);
                                        correctSecondNumber.add(secondNumber);
                                        correctDivisionResult.add(roundedDivisionResult);
                                    }
                                }
                            } else {
                                if (firstNumber == secondNumber || firstNumber % secondNumber == 0 || secondNumber == 1) {
                                    if (secondNumber % 3 != 0) {
                                        wholeDecimal = (short) roundedDivisionResult;
                                        correctFirstNumber.add(firstNumber);
                                        correctOperator.add(operator);
                                        correctSecondNumber.add(secondNumber);
                                        correctWholeNumberResult.add(wholeDecimal);
                                    }
                                } else {
                                    correctFirstNumber.add(firstNumber);
                                    correctOperator.add(operator);
                                    correctSecondNumber.add(secondNumber);
                                    correctDivisionResult.add(roundedDivisionResult);
                                }
                            }
                        }
                        case 3 -> {
                            correctFirstNumber.add(firstNumber);
                            correctOperator.add(operator);
                            correctSecondNumber.add(secondNumber);
                            correctWholeNumberResult.add((short) additionResult);
                        }
                        case 4 -> {
                            correctFirstNumber.add(firstNumber);
                            correctOperator.add(operator);
                            correctSecondNumber.add(secondNumber);
                            correctWholeNumberResult.add((short) subtractionResult);
                        }
                    }
                }
                if(isWrong) {
                    switch (operation) {
                        case 1 -> {
                            wrongFirstNumber.add(firstNumber);
                            wrongOperator.add(operator);
                            wrongSecondNumber.add(secondNumber);
                            wrongWholeNumberResult.add(response);
                            correctAnswerWhole.add((short) multiplicationResult);
                        }
                        case 2 -> {
                            // new revised
                            if (responseForDivision == roundedDivisionResult) {
                                if (firstNumber == secondNumber || firstNumber % secondNumber == 0 || secondNumber == 1) {
                                    wholeDecimal = (short) Math.floor(roundedDivisionResult);
                                    if (secondNumber % 3 != 0) {
                                        if (responseForDivision == wholeDecimal) {
                                            wholeDecimal = (short) roundedDivisionResult;
                                            wrongFirstNumber.add(firstNumber);
                                            wrongOperator.add(operator);
                                            wrongSecondNumber.add(secondNumber);
                                            wrongWholeNumberResult.add((short) responseForDivision);
                                            correctAnswerWhole.add(wholeDecimal);
                                        } else {
                                            wrongFirstNumber.add(firstNumber);
                                            wrongOperator.add(operator);
                                            wrongSecondNumber.add(secondNumber);
                                            wrongDivisionResult.add(responseForDivision);
                                            correctAnswerDivision.add(roundedDivisionResult);
                                        }
                                    } else if (responseForDivision != wholeDecimal) {
                                        wrongFirstNumber.add(firstNumber);
                                        wrongOperator.add(operator);
                                        wrongSecondNumber.add(secondNumber);
                                        wrongDivisionResult.add(responseForDivision);
                                        correctAnswerDivision.add(roundedDivisionResult);
                                    } else {
                                        wholeDecimal = (short) roundedDivisionResult;
                                        wrongFirstNumber.add(firstNumber);
                                        wrongOperator.add(operator);
                                        wrongSecondNumber.add(secondNumber);
                                        wrongWholeNumberResult.add((short) responseForDivision);
                                        correctAnswerWhole.add(wholeDecimal);
                                    }
                                } else {
                                    if (responseForDivision == wholeDecimal) {
                                        wholeDecimal = (short) roundedDivisionResult;
                                        wrongFirstNumber.add(firstNumber);
                                        wrongOperator.add(operator);
                                        wrongSecondNumber.add(secondNumber);
                                        wrongWholeNumberResult.add((short) responseForDivision);
                                        correctAnswerWhole.add(wholeDecimal);
                                    } else {
                                        wrongFirstNumber.add(firstNumber);
                                        wrongOperator.add(operator);
                                        wrongSecondNumber.add(secondNumber);
                                        wrongDivisionResult.add(responseForDivision);
                                        correctAnswerDivision.add(roundedDivisionResult);
                                    }
                                }
                            } else {
                                if (firstNumber == secondNumber || firstNumber % secondNumber == 0 || secondNumber == 1) {
                                    if (secondNumber % 3 != 0) {
                                        wholeDecimal = (short) roundedDivisionResult;
                                        wrongFirstNumber.add(firstNumber);
                                        wrongOperator.add(operator);
                                        wrongSecondNumber.add(secondNumber);
                                        wrongWholeNumberResult.add((short) responseForDivision);
                                        correctAnswerWhole.add(wholeDecimal);
                                    }
                                } else {
                                    wrongFirstNumber.add(firstNumber);
                                    wrongOperator.add(operator);
                                    wrongSecondNumber.add(secondNumber);
                                    wrongDivisionResult.add(responseForDivision);
                                    correctAnswerDivision.add(roundedDivisionResult);
                                }
                            }
                        }
                        case 3 -> {
                            wrongFirstNumber.add(firstNumber);
                            wrongOperator.add(operator);
                            wrongSecondNumber.add(secondNumber);
                            wrongWholeNumberResult.add(response);
                            correctAnswerWhole.add((short) additionResult);
                        }
                        case 4 -> {
                            wrongFirstNumber.add(firstNumber);
                            wrongOperator.add(operator);
                            wrongSecondNumber.add(secondNumber);
                            wrongWholeNumberResult.add(response);
                            correctAnswerWhole.add((short) subtractionResult);
                        }
                    }
                }
                System.out.println("=================================");
                if (isWrong) {
                    Methods.checkPoint();
                }
                if(playCount == newPromptCount){
                    Methods.doNotLeaveMe();
                    newPromptCount += newPromptCountAdd;
                }
                if (playCount == maxPlayCount) {
                    oldPlayCount = playCount;
                    String firstSign = "OOPS..";
                    String secondSign = "TOO MUCH PLAY COUNT";
                    String thirdSign = "LET US GO BACK TO LEVEL 1 ";
                    String fourthSign = "THIS LEVEL SEEMS HARD";
                    for (int i = 0; i < firstSign.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(firstSign.charAt(i));
                    }
                    System.out.println();
                    for (int i = 0; i < secondSign.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(secondSign.charAt(i));
                    }
                    System.out.println();
                    for (int i = 0; i < thirdSign.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(thirdSign.charAt(i));
                    }
                    System.out.println();
                    for (int i = 0; i < fourthSign.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(fourthSign.charAt(i));
                    }
                    System.out.println();
                    newPromptCount = 10;
                    playCount = 0;
                    levelCount = 1;
                    level = 1;
                    correctCountTimeOutAdd = 0;
                }
                switch (playCount) {
                    case 47 -> {
                        level = 5;
                        number += 5;
                        levelCount = 5;
                    }
                    case 35 -> {
                        level = 4;
                        number += 4;
                        levelCount = 4;
                    }
                    case 20 -> {
                        level = 3;
                        number += 3;
                        levelCount = 3;
                    }
                    case 7 -> {
                        level = 2;
                        number += 2;
                        levelCount = 2;
                    }
                }
            }
            // end
        }
        if ((playCount > 0 || oldPlayCount > 0) && !somethingWentWrong) {
            System.out.print("\nGENERATING RESULTS");
            Methods.loading();
            System.out.println("=================================================");
            System.out.printf("     You got >>>  %d  <<< correct answers", correctCount);
            System.out.printf("\n     You got >>>  %d  <<< wrong answers\n", wrongCount);
            System.out.println("=================================================");
            Methods.output();
            System.out.println("=======================================================================");
            if (correctCount > wrongCount) {
                if(correctCount >= 20) {
                    String firstMessage = "YOOHOOO, YOU ARE SO...SO.. SMART!\nPLEASE ANSWER MY MATH ACTIVITIES";
                    System.out.println();
                    for (int i = 0; i < firstMessage.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.print(firstMessage.charAt(i));
                    }
                    System.out.println();
                }
            } 
            else if (wrongCount > correctCount) {
                String secondMessage = "IT LOOKS LIKE YOU NEED TO STUDY";
                System.out.println();
                for (int i = 0; i < secondMessage.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.print(secondMessage.charAt(i));
                }
                System.out.println();
            }
            Methods.end();
        }
        else if (playCount == 0 || somethingWentWrong) {
            userInput.nextLine();
            if (oldPlayCount > 0) {
                char exitChoice;
                System.out.println("DO YOU WANT TO SEE YOUR PREVIOUS ANSWERS? ");
                System.out.println("Yes <Y> No <N>");
                System.out.print(">>> ");
                exitChoice = userInput.next().toUpperCase().charAt(0);
                switch (exitChoice) {
                    case 'Y' -> {
                        System.out.print("\nGENERATING RESULTS");
                        Methods.loading();
                        Methods.output();
                        System.out.println("=======================================================================");
                        if (correctCount > wrongCount) {
                            if (correctCount >= 20) {
                                String firstMessage = "YOOHOOO, YOU ARE SO...SO.. SMART!\nPLEASE ANSWER MY MATH ACTIVITIES";
                                System.out.println();
                                for (int i = 0; i < firstMessage.length(); i++) {
                                    TimeUnit.MILLISECONDS.sleep(100);
                                    System.out.print(firstMessage.charAt(i));
                                }
                                System.out.println();
                            }
                        } else if (wrongCount > correctCount) {
                            String secondMessage = "IT LOOKS LIKE YOU NEED TO STUDY";
                            System.out.println();
                            for (int i = 0; i < secondMessage.length(); i++) {
                                TimeUnit.MILLISECONDS.sleep(100);
                                System.out.print(secondMessage.charAt(i));
                            }
                            System.out.println();
                        }
                        Methods.end();
                    }
                    case 'N' -> Methods.end();
                    default -> {
                        System.out.println("<INVALID CHOICE> : Y or N only :");
                        System.out.print("EXITING THE PROGRAM");
                        Methods.loading();
                        Methods.end();
                    }
                }
                }
            else {
                Methods.end();
            }
        }
        else {
            Methods.end();
        }
    Methods.clearArrayList();
    userInput.close();
    }
}
