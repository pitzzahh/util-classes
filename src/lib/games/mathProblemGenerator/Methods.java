package lib.games.mathProblemGenerator;

import lib.utilities.inputChecker.InputChecker;
import java.util.concurrent.*;
import java.util.Scanner;

public class Methods {
    // cannot instantiate this class
    protected Methods() {}
    static final String correctAnswer = " CORRECT ANSWER!";
    static final String wrongAnswer = " WRONG ANSWER";
    static final String success = "SUCCESS!";
    protected static void greet() {
        System.out.println("#####################################################");
        System.out.println("|===================================================|");
        System.out.println("|       #######################################     |");
        System.out.println("|       ## WELCOME TO MATH PROBLEM GENERATOR ##     |");
        System.out.println("|       #######################################     |");
        System.out.println("|===================================================|");
        System.out.println("|: ENTER YOUR DESIRED RANGE OF NUMBERS OF OPERANDS :|");
        System.out.println("|      : THE NUMBER SHOULD NOT BE LESS THAN 1 :     |");
        System.out.println("|===================================================|");
        System.out.println("| THE NUMBER YOU ENTERED WILL INCREASE EVERY LEVEL  |");
        System.out.println("|===================================================|");
        System.out.println("#####################################################");
    }
    protected static void beginning() {
        try {
            System.out.print("ENTER HERE >>> ");
            byte num = MathProblemGenerator.userInput.nextByte();
            if (num >= 60 && num <= 100) {
                String overlap = "TRY AGAIN, THIS IS SO HARD FOR YOU";
                for (int i = 0; i < overlap.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.print(overlap.charAt(i));
                }
                System.out.println();
            }
            if (num >= 20 && num <= 50) {
                System.out.println("THAT IS TOO HARD, GOOD LUCK!");
                MathProblemGenerator.number = num;
                MathProblemGenerator.isNotExit = true;
                MathProblemGenerator.intro = false;
            }
            else if (num >= 10 && num <= 20) {
                System.out.println("THIS IS GOOD ENOUGH, GOOD LUCK!");
                MathProblemGenerator.number = num;
                MathProblemGenerator.isNotExit = true;
                MathProblemGenerator.intro = false;
            }
            else if (num > 0 && num <= 10) {
                System.out.println("THIS IS TOO EASY, NICE!");
                MathProblemGenerator.number = num;
                MathProblemGenerator.isNotExit = true;
                MathProblemGenerator.intro = false;
            }
            else if (num <= 0) {
                String errorString = "TRY AGAIN, I TOLD YOU THE NUMBER SHOULD NOT BE LESS THAN 1";
                for (int i = 0; i < errorString.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.print(errorString.charAt(i));
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            System.out.println("==================================");
            System.out.println("   ##SOMETHING WENT WRONG##");
            MathProblemGenerator.somethingWentWrong = true;
            MathProblemGenerator.wholeCondition = false;
            MathProblemGenerator.intro = false;
        }
    }
    protected static void multiply() throws InterruptedException {
        if (!MathProblemGenerator.answer.isEmpty()) {
            if (InputChecker.isInteger(MathProblemGenerator.answer)) {
                MathProblemGenerator.playCount++;
                MathProblemGenerator.response = Short.parseShort(MathProblemGenerator.answer);
                if (MathProblemGenerator.response == MathProblemGenerator.multiplicationResult) {
                    for (int i = 0; i < correctAnswer.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(correctAnswer.charAt(i));
                    }
                    System.out.println("\n=================================");
                    System.out.println("\t   " + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.response);
                    MathProblemGenerator.isCorrect = true;
                    MathProblemGenerator.correctCount++;
                    if(MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5) {
                        ++MathProblemGenerator.correctCountTimeOutAdd;
                        if(MathProblemGenerator.correctCountTimeOutAdd == 5) {
                            System.out.println("=================================");
                        }
                    }
                } 
                else {
                    for (int i = 0; i < wrongAnswer.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(wrongAnswer.charAt(i));
                    }
                    System.out.println("\n=================================");
                    System.out.println("ANSWER: \t" + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.multiplicationResult);
                    MathProblemGenerator.isWrong = true;
                    MathProblemGenerator.wrongCount++;
                }
            }
            else {
                System.out.println("INVALID INPUT");
                doNotLeaveMe();
            }
            if (MathProblemGenerator.level == 5) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    for (int i = 1; i <= 5; i++) {
                        ++MathProblemGenerator.levelFiveTimeOut;
                    }
                }
            }
            if (MathProblemGenerator.level == 4) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    for (int i = 1; i <= 3; i++) {
                        ++MathProblemGenerator.levelFourTimeOut;
                    }
                }
            }
            String congratulateLevelFourDivide = "CONGRATULATIONS FOR HAVING " + MathProblemGenerator.correctCountTimeOutAdd + " CORRECT ANSWERS IN A ROW \nTHE TIME LIMIT IS NOW " + MathProblemGenerator.levelFourTimeOut;
            String congratulateLevelFiveDivide = "CONGRATULATIONS FOR HAVING " + MathProblemGenerator.correctCountTimeOutAdd + " CORRECT ANSWERS IN A ROW \nTHE TIME LIMIT IS NOW " + MathProblemGenerator.levelFiveTimeOut;
            if (MathProblemGenerator.level == 5) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    System.out.println();
                    for (int i = 0; i < congratulateLevelFiveDivide.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(congratulateLevelFiveDivide.charAt(i));
                    }
                    System.out.println();
                }
            }
            if (MathProblemGenerator.level == 4) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    System.out.println();
                    for (int i = 0; i < congratulateLevelFourDivide.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(congratulateLevelFourDivide.charAt(i));
                    }
                    System.out.println();
                }
            }
            if (MathProblemGenerator.correctCountTimeOutAdd == 10 && (MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5)){
                String one = "THE TIME LIMIT IS ENOUGH, LET ME JUST RESET IT";
                String two = "RESETTING TIME LIMITS";
                System.out.println();
                for (int i = 0; i < one.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(60);
                    System.out.print(one.charAt(i));
                }
                System.out.println();
                for (int i = 0; i < two.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(60);
                    System.out.print(two.charAt(i));
                }
                loading();
                System.out.println();
                MathProblemGenerator.correctCountTimeOutAdd = 0;
                MathProblemGenerator.levelFourTimeOut = 10;
                MathProblemGenerator.levelFiveTimeOut = 5;
                System.out.println();
                for (int index = 0; index < success.length(); index++) {
                    TimeUnit.MILLISECONDS.sleep(40);
                    System.out.print(success.charAt(index));
                }
                System.out.println();
            }
        }
        else {
            System.out.println("YOU DID NOT ANSWER");
            System.out.println("DUE TO TECHNICAL DIFFICULTIES");
            System.out.println("YOU NEED TO TYPE AGAIN YOUR RESPONSE HERE 2x (Y or N)");
            doNotLeaveMe();
        }
    }
    protected static void divide(double divisionResult) throws InterruptedException {
        if (!MathProblemGenerator.answer.isEmpty()) {
            if (InputChecker.isDouble(MathProblemGenerator.answer)) {
                MathProblemGenerator.roundedDivisionResult = Math.round(divisionResult * 100.0) / 100.0;
                MathProblemGenerator.responseForDivision = Double.parseDouble(MathProblemGenerator.answer);
                if (MathProblemGenerator.responseForDivision == MathProblemGenerator.roundedDivisionResult) {
                    if (MathProblemGenerator.firstNumber == MathProblemGenerator.secondNumber || MathProblemGenerator.firstNumber % MathProblemGenerator.secondNumber == 0 || MathProblemGenerator.secondNumber == 1) {
                        MathProblemGenerator.wholeDecimal = (short) Math.floor(MathProblemGenerator.roundedDivisionResult);
                        if (MathProblemGenerator.secondNumber % 3 != 0) {
                            if (MathProblemGenerator.responseForDivision == MathProblemGenerator.wholeDecimal) {
                                MathProblemGenerator.wholeDecimal = (short) MathProblemGenerator.roundedDivisionResult;
                                //
                                for (int i = 0; i < correctAnswer.length(); i++) {
                                    TimeUnit.MILLISECONDS.sleep(70);
                                    System.out.print(correctAnswer.charAt(i));
                                }
                                System.out.println("\n=================================");
                                System.out.println("\t   " + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.wholeDecimal);
                            }
                            else {
                                for (int i = 0; i < correctAnswer.length(); i++) {
                                    TimeUnit.MILLISECONDS.sleep(70);
                                    System.out.print(correctAnswer.charAt(i));
                                }
                                System.out.println("\n=================================");
                                System.out.println("\t   " + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.roundedDivisionResult);
                            }
                            MathProblemGenerator.playCount++;
                            MathProblemGenerator.isCorrect = true;
                            MathProblemGenerator.correctCount++;
                            if(MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5) {
                                ++MathProblemGenerator.correctCountTimeOutAdd;
                                if(MathProblemGenerator.correctCountTimeOutAdd == 5) {
                                    System.out.println("=================================");
                                }
                            }
                        }
                        else if (MathProblemGenerator.responseForDivision != MathProblemGenerator.wholeDecimal) {
                            //
                            for (int i = 0; i < correctAnswer.length(); i++) {
                                TimeUnit.MILLISECONDS.sleep(70);
                                System.out.print(correctAnswer.charAt(i));
                            }
                            System.out.println("\n=================================");
                            System.out.println("\t   " + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.roundedDivisionResult);
                            MathProblemGenerator.playCount++;
                            MathProblemGenerator.isCorrect = true;
                            MathProblemGenerator.correctCount++;
                            if(MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5) {
                                ++MathProblemGenerator.correctCountTimeOutAdd;
                                if(MathProblemGenerator.correctCountTimeOutAdd == 5) {
                                    System.out.println("=================================");
                                }
                            }
                        }
                        else {
                            MathProblemGenerator.wholeDecimal = (short) MathProblemGenerator.roundedDivisionResult;
                            //
                            for (int i = 0; i < correctAnswer.length(); i++) {
                                TimeUnit.MILLISECONDS.sleep(70);
                                System.out.print(correctAnswer.charAt(i));
                            }
                            System.out.println("\n=================================");
                            System.out.println("\t   " + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.wholeDecimal);
                            MathProblemGenerator.playCount++;
                            MathProblemGenerator.isCorrect = true;
                            MathProblemGenerator.correctCount++;
                            if(MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5) {
                                ++MathProblemGenerator.correctCountTimeOutAdd;
                                if(MathProblemGenerator.correctCountTimeOutAdd == 5) {
                                    System.out.println("=================================");
                                }
                            }
                        }
                    }
                    else {
                        //
                        for (int i = 0; i < correctAnswer.length(); i++) {
                            TimeUnit.MILLISECONDS.sleep(70);
                            System.out.print(correctAnswer.charAt(i));
                        }
                        System.out.println("\n=================================");
                        System.out.println("\t   " + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.roundedDivisionResult);
                        MathProblemGenerator.playCount++;
                        MathProblemGenerator.isCorrect = true;
                        MathProblemGenerator.correctCount++;
                        if(MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5) {
                            ++MathProblemGenerator.correctCountTimeOutAdd;
                            if(MathProblemGenerator.correctCountTimeOutAdd == 5) {
                                System.out.println("=================================");
                            }
                        }
                    }

                }
                else {
                    if (MathProblemGenerator.firstNumber == MathProblemGenerator.secondNumber || MathProblemGenerator.firstNumber % MathProblemGenerator.secondNumber == 0 || MathProblemGenerator.secondNumber == 1) {
                        if (MathProblemGenerator.secondNumber % 3 != 0) {
                            MathProblemGenerator.wholeDecimal = (short) Math.floor(MathProblemGenerator.roundedDivisionResult);
                            for (int i = 0; i < wrongAnswer.length(); i++) {
                                TimeUnit.MILLISECONDS.sleep(70);
                                System.out.print(wrongAnswer.charAt(i));
                            }
                            System.out.println("\n=================================");
                            System.out.println("ANSWER: \t" + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.wholeDecimal);
                            MathProblemGenerator.playCount++;
                            MathProblemGenerator.wrongCount++;
                            MathProblemGenerator.isWrong = true;
                        }
                    }
                    else {
                        //
                        for (int i = 0; i < wrongAnswer.length(); i++) {
                            TimeUnit.MILLISECONDS.sleep(70);
                            System.out.print(wrongAnswer.charAt(i));
                        }
                        System.out.println("\n=================================");
                        System.out.println("ANSWER: \t" + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.roundedDivisionResult);
                        MathProblemGenerator.playCount++;
                        MathProblemGenerator.wrongCount++;
                        MathProblemGenerator.isWrong = true;
                    }
                }
            }
            else if (InputChecker.isInteger(MathProblemGenerator.answer)) {
                MathProblemGenerator.roundedDivisionResult = Math.round(MathProblemGenerator.divisionResult * 100.0) / 100.0;
                MathProblemGenerator.responseForDivision = Double.parseDouble(MathProblemGenerator.answer);
                MathProblemGenerator.wholeDecimal = (short) Math.floor(MathProblemGenerator.roundedDivisionResult);
                for (int i = 0; i < correctAnswer.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(70);
                    System.out.print(correctAnswer.charAt(i));
                }
                System.out.println("\n=================================");
                System.out.println("\t   " + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.wholeDecimal);
                MathProblemGenerator.playCount++;
                MathProblemGenerator.isCorrect = true;
                MathProblemGenerator.correctCount++;
                if(MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5) {
                    ++MathProblemGenerator.correctCountTimeOutAdd;
                    if(MathProblemGenerator.correctCountTimeOutAdd == 5) {
                        System.out.println("=================================");
                    }
                }
            }
            else {
                System.out.println("INVALID INPUT");
                doNotLeaveMe();
            }
            if (MathProblemGenerator.level == 5) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    for (int i = 1; i <= 5; i++) {
                        ++MathProblemGenerator.levelFiveTimeOut;
                    }
                }
            }
            if (MathProblemGenerator.level == 4) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    for (int i = 1; i <= 3; i++) {
                        ++MathProblemGenerator.levelFourTimeOut;
                    }
                }
            }
            String congratulateLevelFourDivide = "CONGRATULATIONS FOR HAVING " + MathProblemGenerator.correctCountTimeOutAdd + " CORRECT ANSWERS IN A ROW \nTHE TIME LIMIT IS NOW " + MathProblemGenerator.levelFourTimeOut;
            String congratulateLevelFiveDivide = "CONGRATULATIONS FOR HAVING " + MathProblemGenerator.correctCountTimeOutAdd + " CORRECT ANSWERS IN A ROW \nTHE TIME LIMIT IS NOW " + MathProblemGenerator.levelFiveTimeOut;
            if (MathProblemGenerator.level == 5) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    System.out.println();
                    for (int i = 0; i < congratulateLevelFiveDivide.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(congratulateLevelFiveDivide.charAt(i));
                    }
                    System.out.println();
                }
            }
            if (MathProblemGenerator.level == 4) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    System.out.println();
                    for (int i = 0; i < congratulateLevelFourDivide.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(congratulateLevelFourDivide.charAt(i));
                    }
                    System.out.println();
                }
            }
            if (MathProblemGenerator.correctCountTimeOutAdd == 10 && (MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5)){
                String one = "THE TIME LIMIT IS ENOUGH, LET ME JUST RESET IT";
                String two = "RESETTING TIME LIMITS";
                System.out.println();
                for (int i = 0; i < one.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(60);
                    System.out.print(one.charAt(i));
                }
                System.out.println();
                for (int i = 0; i < two.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(60);
                    System.out.print(two.charAt(i));
                }
                loading();
                System.out.println();
                MathProblemGenerator.correctCountTimeOutAdd = 0;
                MathProblemGenerator.levelFourTimeOut = 10;
                MathProblemGenerator.levelFiveTimeOut = 5;
                System.out.println();
                for (int index = 0; index < success.length(); index++) {
                    TimeUnit.MILLISECONDS.sleep(40);
                    System.out.print(success.charAt(index));
                }
                System.out.println();
            }
        }
        else {
            System.out.println("YOU DID NOT ANSWER");
            System.out.println("DUE TO TECHNICAL DIFFICULTIES");
            System.out.println("YOU NEED TO TYPE AGAIN YOUR RESPONSE HERE 2x (Y or N)");
            doNotLeaveMe();
        }
    }
    protected static void add() throws InterruptedException {
        if (!MathProblemGenerator.answer.isEmpty()) {
            if (InputChecker.isInteger(MathProblemGenerator.answer)) {
                MathProblemGenerator.playCount++;
                MathProblemGenerator.response = (short) Integer.parseInt(MathProblemGenerator.answer);
                if (MathProblemGenerator.response == MathProblemGenerator.additionResult) {
                    for (int i = 0; i < correctAnswer.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(correctAnswer.charAt(i));
                    }
                    System.out.println("\n=================================");
                    System.out.println("\t   " + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.response);
                    MathProblemGenerator.correctCount++;
                    MathProblemGenerator.isCorrect = true;
                    if(MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5) {
                        ++MathProblemGenerator.correctCountTimeOutAdd;
                        if(MathProblemGenerator.correctCountTimeOutAdd == 5) {
                            System.out.println("=================================");
                        }
                    }
                } 
                else {
                    //
                    for (int i = 0; i < wrongAnswer.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(wrongAnswer.charAt(i));
                    }
                    System.out.println("\n=================================");
                    System.out.println("ANSWER: \t" + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.additionResult);
                    MathProblemGenerator.wrongCount++;
                    MathProblemGenerator.isWrong = true;
                }
            }
            else {
                System.out.println("INVALID INPUT");
                doNotLeaveMe();
            }
            if (MathProblemGenerator.level == 5) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    for (int i = 1; i <= 5; i++) {
                        ++MathProblemGenerator.levelFiveTimeOut;
                    }
                }
            }
            if (MathProblemGenerator.level == 4) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    for (int i = 1; i <= 3; i++) {
                        ++MathProblemGenerator.levelFourTimeOut;
                    }
                }
            }
            String congratulateLevelFourDivide = "CONGRATULATIONS FOR HAVING " + MathProblemGenerator.correctCountTimeOutAdd + " CORRECT ANSWERS IN A ROW \nTHE TIME LIMIT IS NOW " + MathProblemGenerator.levelFourTimeOut;
            String congratulateLevelFiveDivide = "CONGRATULATIONS FOR HAVING " + MathProblemGenerator.correctCountTimeOutAdd + " CORRECT ANSWERS IN A ROW \nTHE TIME LIMIT IS NOW " + MathProblemGenerator.levelFiveTimeOut;
            if (MathProblemGenerator.level == 5) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    System.out.println();
                    for (int i = 0; i < congratulateLevelFiveDivide.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(congratulateLevelFiveDivide.charAt(i));
                    }
                    System.out.println();
                }
            }
            if (MathProblemGenerator.level == 4) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    System.out.println();
                    for (int i = 0; i < congratulateLevelFourDivide.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(congratulateLevelFourDivide.charAt(i));
                    }
                    System.out.println();
                }
            }
            if (MathProblemGenerator.correctCountTimeOutAdd == 10 && (MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5)){
                String one = "THE TIME LIMIT IS ENOUGH, LET ME JUST RESET IT";
                String two = "RESETTING TIME LIMITS";
                System.out.println();
                for (int i = 0; i < one.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(60);
                    System.out.print(one.charAt(i));
                }
                System.out.println();
                for (int i = 0; i < two.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(60);
                    System.out.print(two.charAt(i));
                }
                loading();
                System.out.println();
                MathProblemGenerator.correctCountTimeOutAdd = 0;
                MathProblemGenerator.levelFourTimeOut = 10;
                MathProblemGenerator.levelFiveTimeOut = 5;
                System.out.println();
                for (int index = 0; index < success.length(); index++) {
                    TimeUnit.MILLISECONDS.sleep(40);
                    System.out.print(success.charAt(index));
                }
                System.out.println();
            }
        }
        else {
            System.out.println("YOU DID NOT ANSWER");
            System.out.println("DUE TO TECHNICAL DIFFICULTIES");
            System.out.println("YOU NEED TO TYPE AGAIN YOUR RESPONSE HERE 2x (Y or N)");
            doNotLeaveMe();
        }
    }
    protected static void subtract() throws InterruptedException {
        if (!MathProblemGenerator.answer.isEmpty()) {
            if (InputChecker.isInteger(MathProblemGenerator.answer)) {
                MathProblemGenerator.playCount++;
                MathProblemGenerator.response = (short) Integer.parseInt(MathProblemGenerator.answer);
                if (MathProblemGenerator.response == MathProblemGenerator.subtractionResult) {
                    for (int i = 0; i < correctAnswer.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(correctAnswer.charAt(i));
                    }
                    System.out.println("\n=================================");
                    System.out.println("\t   " + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.response);
                    MathProblemGenerator.correctCount++;
                    MathProblemGenerator.isCorrect = true;
                    if(MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5) {
                        ++MathProblemGenerator.correctCountTimeOutAdd;
                        if(MathProblemGenerator.correctCountTimeOutAdd == 5) {
                            System.out.println("=================================");
                        }
                    }
                }
                else {
                    //
                    for (int i = 0; i < wrongAnswer.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(wrongAnswer.charAt(i));
                    }
                    System.out.println("\n=================================");
                    System.out.println("ANSWER: \t" + MathProblemGenerator.firstNumber + " " + MathProblemGenerator.operator + " " + MathProblemGenerator.secondNumber + " = " + MathProblemGenerator.subtractionResult);
                    MathProblemGenerator.wrongCount++;
                    MathProblemGenerator.isWrong = true;
                }
            }
            else {
                System.out.println("INVALID INPUT");
                doNotLeaveMe();
            }
            if (MathProblemGenerator.level == 5) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    for (int i = 1; i <= 5; i++) {
                        ++MathProblemGenerator.levelFiveTimeOut;
                    }
                }
            }
            if (MathProblemGenerator.level == 4) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    for (int i = 1; i <= 3; i++) {
                        ++MathProblemGenerator.levelFourTimeOut;
                    }
                }
            }
            String congratulateLevelFourDivide = "CONGRATULATIONS FOR HAVING " + MathProblemGenerator.correctCountTimeOutAdd + " CORRECT ANSWERS IN A ROW \nTHE TIME LIMIT IS NOW " + MathProblemGenerator.levelFourTimeOut;
            String congratulateLevelFiveDivide = "CONGRATULATIONS FOR HAVING " + MathProblemGenerator.correctCountTimeOutAdd + " CORRECT ANSWERS IN A ROW \nTHE TIME LIMIT IS NOW " + MathProblemGenerator.levelFiveTimeOut;
            if (MathProblemGenerator.level == 5) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    System.out.println();
                    for (int i = 0; i < congratulateLevelFiveDivide.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(congratulateLevelFiveDivide.charAt(i));
                    }
                    System.out.println();
                }
            }
            if (MathProblemGenerator.level == 4) {
                if (MathProblemGenerator.correctCountTimeOutAdd == 5) {
                    System.out.println();
                    for (int i = 0; i < congratulateLevelFourDivide.length(); i++) {
                        TimeUnit.MILLISECONDS.sleep(70);
                        System.out.print(congratulateLevelFourDivide.charAt(i));
                    }
                    System.out.println();
                }
            }
            if (MathProblemGenerator.correctCountTimeOutAdd == 10 && (MathProblemGenerator.level == 4 || MathProblemGenerator.level == 5)){
                String one = "THE TIME LIMIT IS ENOUGH, LET ME JUST RESET IT";
                String two = "RESETTING TIME LIMITS";
                System.out.println();
                for (int i = 0; i < one.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(60);
                    System.out.print(one.charAt(i));
                }
                System.out.println();
                for (int i = 0; i < two.length(); i++) {
                    TimeUnit.MILLISECONDS.sleep(60);
                    System.out.print(two.charAt(i));
                }
                loading();
                System.out.println();
                MathProblemGenerator.correctCountTimeOutAdd = 0;
                MathProblemGenerator.levelFourTimeOut = 10;
                MathProblemGenerator.levelFiveTimeOut = 5;
                System.out.println();
                for (int index = 0; index < success.length(); index++) {
                    TimeUnit.MILLISECONDS.sleep(40);
                    System.out.print(success.charAt(index));
                }
                System.out.println();
            }
        }
        else {
            System.out.println("YOU DID NOT ANSWER");
            System.out.println("DUE TO TECHNICAL DIFFICULTIES");
            System.out.println("YOU NEED TO TYPE AGAIN YOUR RESPONSE HERE 2x (Y or N)");
            doNotLeaveMe();
        }
    }
    protected static void reset() {
        MathProblemGenerator.answer = "";
        MathProblemGenerator.wholeDecimal = 0;
        MathProblemGenerator.responseForDivision = 0.0;
        MathProblemGenerator.roundedDivisionResult = 0.00;
        MathProblemGenerator.operator = ' ';
        MathProblemGenerator.isNotExit = true;
        MathProblemGenerator.isCorrect = false;
        MathProblemGenerator.isWrong = false;
        MathProblemGenerator.response = 0;
    }
    protected static void clearArrayList() {
        // correct numbers
        MathProblemGenerator.correctFirstNumber.clear();
        MathProblemGenerator.correctSecondNumber.clear();
        // correct operator
        MathProblemGenerator.correctOperator.clear();
        // correct whole number result
        MathProblemGenerator.correctWholeNumberResult.clear();
        // correct decimal result
        MathProblemGenerator.correctDivisionResult.clear();
        // wrong numbers
        MathProblemGenerator.wrongFirstNumber.clear();
        MathProblemGenerator.wrongSecondNumber.clear();
        // wrong operator
        MathProblemGenerator.wrongOperator.clear();
        // wrong wholeNumberResult
        MathProblemGenerator.wrongWholeNumberResult.clear();
        // wrong decimal result
        MathProblemGenerator.wrongDivisionResult.clear();
        // correct answers in wrong input decimals
        MathProblemGenerator.correctAnswerDivision.clear();
        // correct answers in wrong whole number inputs
        MathProblemGenerator.correctAnswerWhole.clear();
    }

    protected static void loading() throws InterruptedException {
        for (int index = 1 ; index <= 3 ; index++) {
            TimeUnit.MILLISECONDS.sleep(400);
            System.out.print('.');
        }
        TimeUnit.MILLISECONDS.sleep(400);
        System.out.println();
    }
    protected static void end() throws InterruptedException {
        String one = "==================================";
        String two = ": THANK YOU FOR USING MY PROGRAM :";
        String three = "==================================";
        for (int i = 0; i < one.length(); i++) {
            TimeUnit.MILLISECONDS.sleep(30);
            System.out.print(one.charAt(i));
        }
        System.out.println();
        for (int i = 0; i < two.length(); i++) {
            TimeUnit.MILLISECONDS.sleep(30);
            System.out.print(two.charAt(i));
        }
        System.out.println();
        for (int i = 0; i < three.length(); i++) {
            TimeUnit.MILLISECONDS.sleep(30);
            System.out.print(three.charAt(i));
        }
        System.out.println();
    }
    protected static void getChoiceWithTimeout(byte range) throws InterruptedException {
        Callable<String> k = () -> new Scanner(System.in).next();
        long start = System.currentTimeMillis();
        String choice = "";
        ExecutorService l = Executors.newFixedThreadPool(1);
        Future<String> g;
        System.out.println("YOU GOT: " + range + " SECONDS TO ANSWER");
        System.out.print(">>> ");
        g = l.submit(k);
        while (System.currentTimeMillis() - start < range * 1000L) {
            if (g.isDone()) {
                try {
                    choice = g.get();
                    if (!choice.isEmpty()) {
                        if (InputChecker.isInteger(choice)) {
                            MathProblemGenerator.answer = choice;
                            break;
                        }
                        if (InputChecker.isDouble(choice)) {
                            MathProblemGenerator.answer = choice;
                            break;
                        }
                        else {
                            throw new IllegalArgumentException();
                        }
                    }
                }
                catch (InterruptedException | ExecutionException | IllegalArgumentException e) {
                    break;
                }
            }
        }
        if (choice.isEmpty()) {
            System.out.println();
            String outOfTime = "OUT OF TIME!";
            for (int i = 0; i <outOfTime.length() ; i++) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.print(outOfTime.charAt(i));
            }
            MathProblemGenerator.levelCount = 0;
            System.out.println();
        }
        g.cancel(true);
        l.shutdown();
    }
    protected static void doNotLeaveMe() {
        boolean getMeOutOfHere = true;
        char responseHere;
        while(getMeOutOfHere) {
            System.out.println("DO YOU STILL WANT TO PLAY?");
            System.out.println(": Y : for yes : N : for no");
            System.out.print(">>> ");
            responseHere = MathProblemGenerator.userInput.next().toUpperCase().charAt(0);
            switch (responseHere) {
                case 'Y' -> {
                    getMeOutOfHere = false;
                    System.out.println("=================================");
                }
                case 'N' -> {
                    getMeOutOfHere = false;
                    MathProblemGenerator.wholeCondition = false;
                    MathProblemGenerator.isNotExit = false;
                }
                default -> System.out.println("INVALID INPUT");
            }
        }
    }
    protected static void checkPoint() {
        boolean getMeOutOfHere = true;
        char exitResponse;
        while(getMeOutOfHere) {
            System.out.println("DO YOU WANT TO TRY AGAIN?");
            System.out.println(": Y : for yes : N : for no");
            System.out.print(">>> ");
            exitResponse = MathProblemGenerator.userInput.next().toUpperCase().charAt(0);
            switch (exitResponse) {
                case 'Y' -> {
                    getMeOutOfHere = false;
                    System.out.println("=================================");
                }
                case 'N' -> {
                    getMeOutOfHere = false;
                    MathProblemGenerator.wholeCondition = false;
                    MathProblemGenerator.isNotExit = false;
                }
                default -> System.out.println("INVALID INPUT");
            }
        }
    }
    protected static void correctAnswers() { // correct answers
        byte i = 0;
        byte wholeNumber = 0;
        byte decimalNumber = 0;
        if (MathProblemGenerator.correctCount == 0) {
            System.out.println("\t  "+ 0 + " CORRECT ANSWERS");
        }
        else {
            while (i < MathProblemGenerator.correctCount) {
                System.out.print("\t" + MathProblemGenerator.correctFirstNumber.get(i) + "  " + MathProblemGenerator.correctOperator.get(i) + "  " + MathProblemGenerator.correctSecondNumber.get(i));
                System.out.print(" = ");
                switch (MathProblemGenerator.correctOperator.get(i)) {
                    case '*', '+', '-' -> {
                        System.out.println(MathProblemGenerator.correctWholeNumberResult.get(wholeNumber));
                        if (wholeNumber < MathProblemGenerator.correctWholeNumberResult.size()) {
                            wholeNumber++;
                        }
                    }
                    case '/' -> {
                        // new revised:: edited
                        if (MathProblemGenerator.correctFirstNumber.get(i).equals(MathProblemGenerator.correctSecondNumber.get(i)) || MathProblemGenerator.correctFirstNumber.get(i) % MathProblemGenerator.correctSecondNumber.get(i) == 0 || MathProblemGenerator.correctSecondNumber.get(i) == 1) {
                            if (MathProblemGenerator.correctFirstNumber.get(i) % 3 != 0) {
                                if (MathProblemGenerator.correctFirstNumber.get(i).equals(MathProblemGenerator.correctSecondNumber.get(i)) || MathProblemGenerator.correctFirstNumber.get(i) % MathProblemGenerator.correctSecondNumber.get(i) == 0) {
                                    if (MathProblemGenerator.correctFirstNumber.get(i).equals(MathProblemGenerator.correctSecondNumber.get(i)) || MathProblemGenerator.correctFirstNumber.get(i) % MathProblemGenerator.correctSecondNumber.get(i) == 0 || MathProblemGenerator.correctSecondNumber.get(i) == 1) {
                                        System.out.println(MathProblemGenerator.correctWholeNumberResult.get(wholeNumber));
                                        if (wholeNumber < MathProblemGenerator.correctWholeNumberResult.size()) {
                                            wholeNumber++;
                                        }
                                    } else {
                                        System.out.println(MathProblemGenerator.correctDivisionResult.get(decimalNumber));
                                        if (decimalNumber < MathProblemGenerator.correctDivisionResult.size()) {
                                            decimalNumber++;
                                        }
                                    }
                                } else {
                                    System.out.println(MathProblemGenerator.correctDivisionResult.get(decimalNumber));
                                    if (decimalNumber < MathProblemGenerator.correctDivisionResult.size()) {
                                        decimalNumber++;
                                    }
                                }
                            } else if (MathProblemGenerator.correctFirstNumber.get(i).equals(MathProblemGenerator.correctSecondNumber.get(i)) || MathProblemGenerator.correctFirstNumber.get(i) % MathProblemGenerator.correctSecondNumber.get(i) == 0) {
                                if (MathProblemGenerator.correctFirstNumber.get(i).equals(MathProblemGenerator.correctSecondNumber.get(i)) || MathProblemGenerator.correctFirstNumber.get(i) % MathProblemGenerator.correctSecondNumber.get(i) == 0 || MathProblemGenerator.correctSecondNumber.get(i) == 1) {
                                    System.out.println(MathProblemGenerator.correctWholeNumberResult.get(wholeNumber));
                                    if (wholeNumber < MathProblemGenerator.correctWholeNumberResult.size()) {
                                        wholeNumber++;
                                    }
                                } else {
                                    System.out.println(MathProblemGenerator.correctDivisionResult.get(decimalNumber));
                                    if (decimalNumber < MathProblemGenerator.correctDivisionResult.size()) {
                                        decimalNumber++;
                                    }
                                }
                            } else {
                                System.out.println(MathProblemGenerator.correctWholeNumberResult.get(wholeNumber));
                                if (wholeNumber < MathProblemGenerator.correctWholeNumberResult.size()) {
                                    wholeNumber++;
                                }
                            }
                        } else {
                            if (MathProblemGenerator.correctFirstNumber.get(i).equals(MathProblemGenerator.correctSecondNumber.get(i)) || MathProblemGenerator.correctFirstNumber.get(i) % MathProblemGenerator.correctSecondNumber.get(i) == 0) {
                                if (MathProblemGenerator.correctFirstNumber.get(i).equals(MathProblemGenerator.correctSecondNumber.get(i)) || MathProblemGenerator.correctFirstNumber.get(i) % MathProblemGenerator.correctSecondNumber.get(i) == 0 || MathProblemGenerator.correctSecondNumber.get(i) == 1) {
                                    System.out.println(MathProblemGenerator.correctWholeNumberResult.get(wholeNumber));
                                    if (wholeNumber < MathProblemGenerator.correctWholeNumberResult.size()) {
                                        wholeNumber++;
                                    }
                                } else {
                                    System.out.println(MathProblemGenerator.correctDivisionResult.get(decimalNumber));
                                    if (decimalNumber < MathProblemGenerator.correctDivisionResult.size()) {
                                        decimalNumber++;
                                    }
                                }
                            } else {
                                System.out.println(MathProblemGenerator.correctDivisionResult.get(decimalNumber));
                                if (decimalNumber < MathProblemGenerator.correctDivisionResult.size()) {
                                    decimalNumber++;
                                }
                            }
                        }
                    }
                }
                if (i == MathProblemGenerator.correctCount) {
                    break;
                }
                else {
                    i++;
                }
            }
        }
    }
    protected static void wrongAnswers() { // wrong answers
        byte i = 0;
        byte wholeNumber = 0;
        byte decimalNumber = 0;
        if (MathProblemGenerator.wrongCount == 0) {
            System.out.println("\t  "+ 0 + " WRONG ANSWERS");
        }
        else {
            while (i < MathProblemGenerator.wrongCount) {
                System.out.print("\t" + MathProblemGenerator.wrongFirstNumber.get(i) + "  " + MathProblemGenerator.wrongOperator.get(i) + "  " + MathProblemGenerator.wrongSecondNumber.get(i));
                System.out.print(" = ");
                switch (MathProblemGenerator.wrongOperator.get(i)) {
                    case '*', '+', '-' -> {
                        System.out.println(MathProblemGenerator.wrongWholeNumberResult.get(wholeNumber));
                        if (wholeNumber < MathProblemGenerator.wrongWholeNumberResult.size()) {
                            wholeNumber++;
                        }
                    }
                    case '/' -> {
                        // new revised:: edited
                        if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0 || MathProblemGenerator.wrongSecondNumber.get(i) == 1) {
                            if (MathProblemGenerator.wrongFirstNumber.get(i) % 3 != 0) {
                                if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0) {
                                    if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0 || MathProblemGenerator.wrongSecondNumber.get(i) == 1) {
                                        System.out.println(MathProblemGenerator.wrongWholeNumberResult.get(wholeNumber));
                                        if (wholeNumber < MathProblemGenerator.wrongWholeNumberResult.size()) {
                                            wholeNumber++;
                                        }
                                    } else {
                                        System.out.println(MathProblemGenerator.wrongDivisionResult.get(decimalNumber));
                                        if (decimalNumber < MathProblemGenerator.wrongDivisionResult.size()) {
                                            decimalNumber++;
                                        }
                                    }
                                } else {
                                    System.out.println(MathProblemGenerator.wrongDivisionResult.get(decimalNumber));
                                    if (decimalNumber < MathProblemGenerator.wrongDivisionResult.size()) {
                                        decimalNumber++;
                                    }
                                }
                            } else if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0) {
                                if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0 || MathProblemGenerator.wrongSecondNumber.get(i) == 1) {
                                    System.out.println(MathProblemGenerator.wrongWholeNumberResult.get(wholeNumber));
                                    if (wholeNumber < MathProblemGenerator.wrongWholeNumberResult.size()) {
                                        wholeNumber++;
                                    }
                                } else {
                                    System.out.println(MathProblemGenerator.wrongDivisionResult.get(decimalNumber));
                                    if (decimalNumber < MathProblemGenerator.wrongDivisionResult.size()) {
                                        decimalNumber++;
                                    }
                                }
                            } else {
                                System.out.println(MathProblemGenerator.wrongWholeNumberResult.get(wholeNumber));
                                if (wholeNumber < MathProblemGenerator.wrongWholeNumberResult.size()) {
                                    wholeNumber++;
                                }
                            }
                        } else {
                            if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0) {
                                if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0 || MathProblemGenerator.wrongSecondNumber.get(i) == 1) {
                                    System.out.println(MathProblemGenerator.wrongWholeNumberResult.get(wholeNumber));
                                    if (wholeNumber < MathProblemGenerator.wrongWholeNumberResult.size()) {
                                        wholeNumber++;
                                    }
                                } else {
                                    System.out.println(MathProblemGenerator.wrongDivisionResult.get(decimalNumber));
                                    if (decimalNumber < MathProblemGenerator.wrongDivisionResult.size()) {
                                        decimalNumber++;
                                    }
                                }
                            }
                            else {
                                System.out.println(MathProblemGenerator.wrongDivisionResult.get(decimalNumber));
                                if (decimalNumber < MathProblemGenerator.wrongDivisionResult.size()) {
                                    decimalNumber++;
                                }
                            }
                        }
                    }
                }
                if (i == MathProblemGenerator.wrongCount) {
                    break;
                }
                else {
                    i++;
                }
            }
        }
    }
    protected static void correctionInWrongAnswers() { // correction in wrong answers
        byte i = 0;
        byte wholeNumber = 0;
        byte decimalNumber = 0;
        while (i < MathProblemGenerator.wrongCount) {
            System.out.print("\t" + MathProblemGenerator.wrongFirstNumber.get(i) + "  " + MathProblemGenerator.wrongOperator.get(i) + "  " + MathProblemGenerator.wrongSecondNumber.get(i));
            System.out.print(" = ");
            switch (MathProblemGenerator.wrongOperator.get(i)) {
                case '*', '+', '-' -> {
                    System.out.println(MathProblemGenerator.correctAnswerWhole.get(wholeNumber));
                    if (wholeNumber < MathProblemGenerator.correctAnswerWhole.size()) {
                        wholeNumber++;
                    }
                }
                case '/' -> {
                    // new revised:: edited
                    if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0 || MathProblemGenerator.wrongSecondNumber.get(i) == 1) {
                        if (MathProblemGenerator.wrongFirstNumber.get(i) % 3 != 0) {
                            if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0) {
                                if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0 || MathProblemGenerator.wrongSecondNumber.get(i) == 1) {
                                    System.out.println(MathProblemGenerator.correctAnswerWhole.get(wholeNumber));
                                    if (wholeNumber < MathProblemGenerator.correctAnswerWhole.size()) {
                                        wholeNumber++;
                                    }
                                } else {
                                    System.out.println(MathProblemGenerator.correctAnswerDivision.get(decimalNumber));
                                    if (decimalNumber < MathProblemGenerator.correctAnswerDivision.size()) {
                                        decimalNumber++;
                                    }
                                }
                            } else {
                                System.out.println(MathProblemGenerator.correctAnswerDivision.get(decimalNumber));
                                if (decimalNumber < MathProblemGenerator.correctAnswerDivision.size()) {
                                    decimalNumber++;
                                }
                            }
                        } else if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0) {
                            if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0 || MathProblemGenerator.wrongSecondNumber.get(i) == 1) {
                                System.out.println(MathProblemGenerator.correctAnswerWhole.get(wholeNumber));
                                if (wholeNumber < MathProblemGenerator.correctAnswerWhole.size()) {
                                    wholeNumber++;
                                }
                            } else {
                                System.out.println(MathProblemGenerator.correctAnswerDivision.get(decimalNumber));
                                if (decimalNumber < MathProblemGenerator.correctAnswerDivision.size()) {
                                    decimalNumber++;
                                }
                            }
                        } else {
                            System.out.println(MathProblemGenerator.correctAnswerWhole.get(wholeNumber));
                            if (wholeNumber < MathProblemGenerator.correctAnswerWhole.size()) {
                                wholeNumber++;
                            }
                        }
                    } else {
                        if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0) {
                            if (MathProblemGenerator.wrongFirstNumber.get(i).equals(MathProblemGenerator.wrongSecondNumber.get(i)) || MathProblemGenerator.wrongFirstNumber.get(i) % MathProblemGenerator.wrongSecondNumber.get(i) == 0 || MathProblemGenerator.wrongSecondNumber.get(i) == 1) {
                                System.out.println(MathProblemGenerator.correctAnswerWhole.get(wholeNumber));
                                if (wholeNumber < MathProblemGenerator.correctAnswerWhole.size()) {
                                    wholeNumber++;
                                }
                            } else {
                                System.out.println(MathProblemGenerator.correctAnswerDivision.get(decimalNumber));
                                if (decimalNumber < MathProblemGenerator.correctAnswerDivision.size()) {
                                    decimalNumber++;
                                }
                            }
                        } else {
                            System.out.println(MathProblemGenerator.correctAnswerDivision.get(decimalNumber));
                            if (decimalNumber < MathProblemGenerator.correctAnswerDivision.size()) {
                                decimalNumber++;
                            }
                        }
                    }
                }
            }
            if (i == MathProblemGenerator.wrongCount) {
                break;
            }
            else {
                i++;
            }
        }
    }
    protected static void output() {
        System.out.println("\n=======================================================================");
        System.out.print("CORRECT WHOLE NUMBERS : ");
        byte indexCorrectWholeNumberResult = 1;
        for (int i : MathProblemGenerator.correctWholeNumberResult) {
            System.out.print(i);
            if (indexCorrectWholeNumberResult < MathProblemGenerator.correctWholeNumberResult.size()) {
                System.out.print(", ");
            }
            indexCorrectWholeNumberResult++;
        }
        System.out.println("\n=======================================================================");
        System.out.print("CORRECT DECIMAL NUMBERS : ");
        byte indexCorrectDivisionResult = 1;
        for (double j : MathProblemGenerator.correctDivisionResult) {
            System.out.print(j);
            if(indexCorrectDivisionResult < MathProblemGenerator.correctDivisionResult.size()) {
                System.out.print(", ");
            }
            indexCorrectDivisionResult++;
        }
        System.out.println("\n=======================================================================");
        System.out.print("WRONG WHOLE NUMBERS : ");
        byte indexWrongWholeNumberResult = 1;
        for (int k : MathProblemGenerator.wrongWholeNumberResult) {
            System.out.print(k);
            if (indexWrongWholeNumberResult < MathProblemGenerator.wrongWholeNumberResult.size()) {
                System.out.print(", ");
            }
            indexWrongWholeNumberResult++;
        }
        System.out.println("\n=======================================================================");
        System.out.print("WRONG DECIMAL NUMBERS : ");
        byte indexWrongDivisionResult = 1;
        for (double l : MathProblemGenerator.wrongDivisionResult) {
            System.out.print(l);
            if (indexWrongDivisionResult < MathProblemGenerator.wrongDivisionResult.size()) {
                System.out.print(", ");
                indexWrongDivisionResult++;
            }
        }
        System.out.println("\n=======================================================================");
        System.out.print("CORRECTIONS IN WRONG WHOLE NUMBERS : ");
        byte indexCorrectAnswerWhole = 1;
        for (int m : MathProblemGenerator.correctAnswerWhole) {
            System.out.print(m);
            if (indexCorrectAnswerWhole < MathProblemGenerator.correctAnswerWhole.size()) {
                System.out.print(", ");
            }
            indexCorrectAnswerWhole++;
        }
        System.out.println("\n=======================================================================");
        System.out.print("CORRECTIONS IN WRONG DECIMAL NUMBERS : ");
        byte indexCorrectAnswerDivision = 1;
        for (double n : MathProblemGenerator.correctAnswerDivision) {
            System.out.print(n);
            if (indexCorrectAnswerDivision < MathProblemGenerator.correctAnswerDivision.size()) {
                System.out.print(", ");
            }
            indexCorrectAnswerDivision++;
        }
        System.out.println("\n=======================================================================");

        if (MathProblemGenerator.playCount > 0) {
            int totalPlayCount = MathProblemGenerator.oldPlayCount + MathProblemGenerator.playCount;
            System.out.println("PLAY COUNT   : " + totalPlayCount);
        }
        else {
            System.out.println("PLAY COUNT   : " + MathProblemGenerator.oldPlayCount);
        }
        System.out.println("CORRECT ANSWERS COUNT: " + MathProblemGenerator.correctCount);
        System.out.println("WRONG   ANSWERS COUNT: " + MathProblemGenerator.wrongCount);
        System.out.println("================================");
        System.out.println("COUNT OF CORRECT WHOLE NUMBERS  : " + MathProblemGenerator.correctWholeNumberResult.size());
        System.out.println("COUNT OF CORRECT DECIMAL NUMBERS: " + MathProblemGenerator.correctDivisionResult.size());
        if (MathProblemGenerator.correctCount != 0) {
            System.out.println("================================");
            System.out.println("     : CORRECT ANSWERS : ");
            correctAnswers();
            System.out.println("================================");
        }
        System.out.println("================================");
        System.out.println("COUNT OF WRONG WHOLE NUMBERS  : " + MathProblemGenerator.wrongWholeNumberResult.size());
        System.out.println("COUNT OF WRONG DECIMAL NUMBERS: " + MathProblemGenerator.wrongDivisionResult.size());
        if (MathProblemGenerator.wrongCount != 0) {
            System.out.println("================================");
            System.out.println("      : YOUR ANSWERS :  ");
            wrongAnswers();
            System.out.println("================================");
            System.out.println("     : CORRECT ANSWERS :  ");
            correctionInWrongAnswers();
        }
    }
}
