package lib.games.ticTacToe.ticTacToeWithMiniMaxAlgorithm;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public final class TicTacToe {
    static boolean humanNameInput = true;
    static boolean isExit = false;
    static boolean mainChoices = true;
    static boolean playChoice = true;
    static boolean boardSelect = true;
    static boolean prompt = true;
    static boolean difficulty = true;
    static boolean mainMenu = true;
    static boolean chooseBoardAgain = false;
    static boolean chooseDifficultyAgain = false;
    static byte playTypeChoice = 0;
    static byte winCount = 0;
    static byte lossCount = 0;
    static byte tieCount = 0;
    static byte playCount = 1;
    static String playerName = "";
    static String gameDifficulty = "";
    static String whichBoard = "";
    static final Scanner scannerInput = new Scanner(System.in);
    static Game.Point humanMove;
    public void run() throws InterruptedException {
        while (!isExit) {
            if ( mainMenu ) {
                mainChoices();
            }
            if( !isExit ) {
                if (playTypeChoice == 1) {
                    playWithAFriend();
                } else if (playTypeChoice == 2) {
                    playWithArtificialIntelligence();
                }
            }
            // end of name input
            while (prompt) {
                byte response;
                try {
                    System.out.println("DO YOU STILL WANT TO PLAY OR CHOOSE HOW YOU WANT TO PLAY?");
                    System.out.println(": 1 : (CONTINUE PLAYING)");
                    System.out.println(": 2 : to go back to main menu (CHOOSE YOUR OPPONENT)");
                    System.out.println(": 3 : to go back to board selection menu (CHOOSE WHAT BOARD TO USE)");
                    System.out.println(": 4 : to go back to difficulty selection menu (CHOOSE WHAT DIFFICULTY TO PLAY)");
                    System.out.println(": 5 : (EXIT THE GAME)");
                    System.out.print(">>>: ");
                    response = scannerInput.nextByte();
                    if (response == 1) {
                        if ("3x3".equals(whichBoard)) {
                            Game.resetThreeByThreeBoard();
                        } else if ("4x4".equals(whichBoard)) {
                            Game.resetFourByFourBoard();
                        }
                        prompt = false;
                    } else if (response == 2) {
                        System.out.print("RETURNING TO MAIN MENU");
                        loading();
                        prompt = false;
                        mainMenu = true;
                        Game.resetFields();
                        if ("3x3".equals(whichBoard)) {
                            Game.resetThreeByThreeBoard();
                        } else if ("4x4".equals(whichBoard)) {
                            Game.resetFourByFourBoard();
                        }
                    }
                    else if (response == 3) {
                        System.out.print("RETURNING TO BOARD SELECTION MENU");
                        loading();
                        mainMenu = true;
                        mainChoices = true;
                        playChoice = false;
                        boardSelect = true;
                        difficulty = true;
                        chooseBoardAgain = true;
                        chooseDifficultyAgain = false;
                        prompt = false;
                        if ("3x3".equals(whichBoard)) {
                            Game.resetThreeByThreeBoard();
                        } else if ("4x4".equals(whichBoard)) {
                            Game.resetFourByFourBoard();
                        }
                        scannerInput.nextLine();
                    } else if (response == 4) {
                        System.out.print("RETURNING TO DIFFICULTY SELECTION MENU");
                        loading();
                        mainMenu = true;
                        mainChoices = true;
                        playChoice = false;
                        boardSelect = false;
                        difficulty = true;
                        chooseDifficultyAgain = true;
                        prompt = false;
                        if ("3x3".equals(whichBoard)) {
                            Game.resetThreeByThreeBoard();
                        } else if ("4x4".equals(whichBoard)) {
                            Game.resetFourByFourBoard();
                        }
                        scannerInput.nextLine();
                    }
                    else if (response == 5) {
                        System.out.print("EXITING THE PROGRAM");
                        loading();
                        if (playTypeChoice == 1) {
                            System.out.println("THANK YOU ALL FOR PLAYING");
                            System.out.printf("%s WIN COUNT  : %d times", playerName, winCount);
                            System.out.printf("\n%s WIN COUNT  : %d times", playerName, winCount);
                            System.out.printf("\nTIE COUNT: %d\n", tieCount);
                        } else if (playTypeChoice == 2) {
                            System.out.println("THANK YOU FOR PLAYING");
                            System.out.printf("HELLO %s, YOU WON  : %d times", playerName, winCount);
                            System.out.printf("\nYOU LOSS : %d times", lossCount);
                            System.out.printf("\nTIE COUNT: %d", tieCount);
                            System.out.printf("\nYOUR PLAY COUNT IS : %d\n", playCount);
                        }
                        prompt = false;
                        isExit = true;
                    }
                    else {
                        Game.printBoard(whichBoard);
                        System.out.println("INVALID INPUT");
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("PLEASE CHOOSE FROM THE SELECTION");
                    scannerInput.nextLine();
                }
            }
        } // end of while loop statement
    } // end of main method

    static void playWithAFriend() throws InterruptedException {
        String message = "THIS PLAY TYPE IS STILL IN MAKING\nVERSUS AI IS ONLY AVAILABLE AT THE MOMENT";
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            TimeUnit.MILLISECONDS.sleep(100);
        }
        prompt = true;
        System.out.println();
    } // end of playWithAFriend method

    static void playWithArtificialIntelligence() throws InterruptedException {
        while (humanNameInput) {
            System.out.println("ENTER YOUR NAME");
            System.out.print(">>>: ");
            playerName = scannerInput.nextLine().toUpperCase().trim();
            if (isNumber(playerName)) {
                System.out.println("YOUR NAME IS NOT A NUMBER");
            }
            else {
                System.out.println("HELLO " + playerName + " HAVE FUN!");
                humanNameInput = false;
            }
        }
        if (!chooseDifficultyAgain && !chooseBoardAgain) {
            while (!Game.isGameOver()) {
                boolean isCorrectInput = false;
                do {
                    try {
                        byte x = 0;
                        byte y = 0;
                        if ("3x3".equals(whichBoard)) {
                            Game.threeByThreeBoardGuide();
                        } else if ("4x4".equals(whichBoard)) {
                            Game.fourByFourBoardGuide();
                        }
                        Game.printBoard(whichBoard);
                        System.out.print("ENTER YOUR CHOICE: ");
                        byte humanChoice = scannerInput.nextByte();
                        switch (whichBoard) {
                            case "3x3":
                                switch (humanChoice) {
                                    case 1:
                                        break;
                                    case 2:
                                        y = 1;
                                        break;
                                    case 3:
                                        y = 2;
                                        break;
                                    case 4:
                                        x = 1;
                                        break;
                                    case 5:
                                        x = 1;
                                        y = 1;
                                        break;
                                    case 6:
                                        x = 1;
                                        y = 2;
                                        break;
                                    case 7:
                                        x = 2;
                                        break;
                                    case 8:
                                        x = 2;
                                        y = 1;
                                        break;
                                    case 9:
                                        x = 2;
                                        y = 2;
                                        break;
                                    default: System.out.println("PLEASE ONLY CHOOSE FROM 1 to 9");
                                }
                                break;
                            case "4x4":
                                switch (humanChoice) {
                                    case 1:
                                        break;
                                    case 2:
                                        y = 1;
                                        break;
                                    case 3:
                                        y = 2;
                                        break;
                                    case 4:
                                        y = 3;
                                        break;
                                    case 5:
                                        x = 1;
                                        break;
                                    case 6:
                                        x = 1;
                                        y = 1;
                                        break;
                                    case 7:
                                        x = 1;
                                        y = 2;
                                        break;
                                    case 8:
                                        x = 1;
                                        y = 3;
                                        break;
                                    case 9:
                                        x = 2;
                                        break;
                                    case 10:
                                        x = 2;
                                        y = 1;
                                        break;
                                    case 11:
                                        x = 2;
                                        y = 2;
                                        break;
                                    case 12:
                                        x = 2;
                                        y = 3;
                                        break;
                                    case 13:
                                        x = 3;
                                        break;
                                    case 14:
                                        x = 3;
                                        y = 1;
                                        break;
                                    case 15:
                                        x = 3;
                                        y = 2;
                                        break;
                                    case 16:
                                        x = 3;
                                        y = 3;
                                        break;
                                    default: System.out.println("PLEASE ONLY CHOOSE FROM 1 to 16");
                                }
                                break;
                        }
                        humanMove = new Game.Point(x, y);
                        isCorrectInput = Game.placeChoice(humanMove, Game.Boards.HUMAN);
                        if (!isCorrectInput){
                            System.out.println("PLEASE CHOOSE ANOTHER POSITION ON THE BOARD");
                        }
                    }
                    catch (InputMismatchException ime) {
                        if ("3x3".equals(whichBoard)) {
                            System.out.println("PLEASE ENTER 1 to 9");
                        } else if ("4x4".equals(whichBoard)) {
                            System.out.println("PLEASE ENTER 1 to 16");
                        }
                        scannerInput.nextLine();
                    }
                } while (!isCorrectInput);
                Game.isGameOver();

                System.out.println("LEVEL \"" + gameDifficulty + "\"");
                if ("EASY".equals(gameDifficulty)) {
                    Game.easy();
                } else if ("MEDIUM".equals(gameDifficulty)) {
                    Game.medium(); // may problems
                } else if ("HARD".equals(gameDifficulty)) {
                    Game.hard();
                }
            }
            if (Game.isThereAWinner(Game.Boards.HUMAN, whichBoard)) {
                Game.printBoard(whichBoard);
                System.out.println("==================================\n         " + playerName + " YOU WON!\n==================================");
                winCount++;
                prompt = true;
            }
            else if (Game.isThereAWinner(Game.Boards.COMPUTER, whichBoard)) {
                Game.printBoard(whichBoard);
                System.out.println("==================================\n         " + playerName + " YOU LOSE!\n==================================");
                lossCount++;
                prompt = true;
            }
            else {
                Game.printBoard(whichBoard);
                System.out.println("==================================\n              TIE\n==================================");
                tieCount++;
                prompt = true;
            }
        }
    } // end of playWithArtificialIntelligence method

    static void mainChoices () throws InterruptedException {
        while (mainChoices) {
            byte response;
            while (playChoice) {
                try {
                    welcome();
                    System.out.println("HOW WOULD YOU LIKE TO PLAY?");
                    System.out.println(":1: PLAY WITH A FRIEND");
                    System.out.println(":2: PLAY WITH THE COMPUTER");
                    System.out.println(":3: EXIT");
                    System.out.print(">>>: ");
                    playTypeChoice = scannerInput.nextByte();
                    if (playTypeChoice == 1) {
                        System.out.println("PLAY WITH A FRIEND IS SELECTED");
                        playChoice = false;
                        boardSelect = false;
                        difficulty = false;
                        mainChoices = false;
                    } else if (playTypeChoice == 2) {
                        System.out.println("PLAY WITH A COMPUTER IS SELECTED");
                        playChoice = false;
                        boardSelect = true;
                        mainMenu = false;
                    } else if (playTypeChoice == 3) {
                        System.out.print("EXITING THE PROGRAM");
                        loading();
                        playChoice = false;
                        boardSelect = false;
                        difficulty = false;
                        mainChoices = false;
                        prompt = false;
                        isExit = true;
                        humanNameInput = false;
                        mainMenu = false;
                    } else {
                        System.out.println("INVALID CHOICE!, CHOOSE ONLY >> 1 or 2 or 3 <<");
                    }
                    scannerInput.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("INVALID CHOICE!, ONLY >> 1 or 2 or 3 << is ALLOWED");
                    playTypeChoice = 0;
                    scannerInput.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("PLEASE CHOOSE HOW WOULD YOU LIKE TO PLAY OR IF YOU WANT TO EXIT THE GAME");
                    playTypeChoice = 0;
                    scannerInput.nextLine();
                }
            }
            while (boardSelect) {
                try {
                    System.out.println("CHOOSE WHAT BOARD YOU WANT TO USE");
                    System.out.println(": 1 : (3 x 3) Board");
                    System.out.println(": 2 : (4 x 4) Board");
                    System.out.println(": 3 : go back to main menu");
                    System.out.print(">>>: ");
                    response = scannerInput.nextByte();
                    if (response == 1) {
                        System.out.println("3 X 3 BOARD IS SELECTED");
                        whichBoard = "3x3";
                        boardSelect = false;
                        difficulty = true;
                        chooseBoardAgain = false;
                    } else if (response == 2) {
                        System.out.println("4 X 4 BOARD IS SELECTED");
                        whichBoard = "4x4";
                        boardSelect = false;
                        difficulty = true;
                        chooseBoardAgain = false;
                    } else if (response == 3) {
                        System.out.print("RETURNING TO MAIN MENU");
                        loading();
                        boardSelect = false;
                        difficulty = false;
                        playChoice = true;
                        mainMenu = true;
                        chooseBoardAgain = false;
                    }
                    else {
                        System.out.println("INVALID CHOICE!, CHOOSE ONLY >> 1 or 2 or 3 <<");
                    }
                    scannerInput.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("INVALID CHOICE!, ONLY >> 1 or 2 or 3 << is ALLOWED");
                    scannerInput.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("PLEASE CHOOSE WHICH BOARD YOU WANT TO USE");
                    scannerInput.nextLine();
                }
            }
            while (difficulty) {
                System.out.println("WHAT LEVEL DO YOU WANT TO PLAY? ( easy | medium | hard )");
                System.out.print(">>>: ");
                gameDifficulty = scannerInput.nextLine().toUpperCase().trim();
                if ("EASY".equals(gameDifficulty) || "MEDIUM".equals(gameDifficulty) || "HARD".equals(gameDifficulty)) {
                    difficulty = false;
                    mainChoices = false;
                    chooseDifficultyAgain = false;
                } else {
                    System.out.println("PLEASE CHOOSE LEVEL PROPERLY!");
                }
            }
        }
    } // end of main choices method

    static void loading() throws InterruptedException {
        for (int i = 1; i <= 3; i++) {
            TimeUnit.MILLISECONDS.sleep(400);
            System.out.print('.');
        }
        System.out.println();
    } // end of loading method

    static void welcome() {
        System.out.println("        ________________________");
        System.out.println("       |                        |");
        System.out.println("       | Welcome to TIC-TAC-TOE |");
        System.out.println("       |________________________|");
    } // end of welcome method

    static boolean isNumber (String input){
        try {
            Byte.parseByte(input);
            return true;
        } catch (Exception e) {
            System.out.print(' ');
        }
        return false;
    } // end of isNumber method

    static char[][] copy(char[][] src) {
        if (src == null) {
            return null;
        }
        char[][] copy = new char[src.length][];
        for (int i = 0; i < src.length; i++) {
            copy[i] = src[i].clone();
        }
        return copy;
    } // end of copy method
} // end of TicTacToe class
