package lib.games.ticTacToe.simpleTicTacToe;

import java.util.*;
import java.util.concurrent.TimeUnit;

public final class SimpleTicTacToeGame {
    static byte playTypeChoice;
    static byte response;
    static byte lossCount;
    static byte winCount;
    static byte playCount = 1;
    static byte tieCount;
    static byte playerOneWinCount;
    static byte playerTwoWinCount;
    static byte whichBoard;
    static boolean playerNameInVsComputer = true;
    static boolean playerOneNameLoop = true;
    static boolean playerTwoNameLoop = true;
    static boolean humanNameInput = true;
    static boolean mainChoices = true;
    static boolean playerNames = true;
    static boolean boardSelect = true;
    static boolean playChoice = true;
    static boolean isNotExit = true;
    static boolean mainMenu = true;
    static boolean playerOneWon = false;
    static boolean playerTwoWon = false;
    static boolean computerWon = false;
    static boolean isQuitting = false;
    static boolean humanWon = false;
    static boolean tie = false;
    static Random randomComputerChoice;
    static String humanName = "";
    static String playerOneName = "";
    static String playerTwoName = "";
    static final Scanner scannerInput = new Scanner(System.in);
    static final ArrayList<Integer> humanPositionsOnTheBoard = new ArrayList<>();
    static final ArrayList<Integer> computerPositionsOnTheBoard = new ArrayList<>();
    static final ArrayList<Integer> playerOnePositionsOnTheBoard = new ArrayList<>();
    static final ArrayList<Integer> playerTwoPositionsOnTheBoard = new ArrayList<>();

    // INDEX: row = 22 column = 40
    static final char[][] threeByThreeBoard = {
    //        0    1    2    3    4    5    6    7    8    9   10    11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30   31   32   33   34   35   36   37   38   39   40
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 0
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 1
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 2
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 3
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 4
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 5
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 6
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', }, // 7
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 8
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 9
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 10
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 11
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 12
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 13
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 14
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', }, // 15
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 16
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 17
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 18
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 19
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 20
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 21
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 22
                                    };
    // INDEX: row = 30 column = 54
    static final char[][] fourByFourBoard = {
        //    0    1    2    3    4    5    6    7    8    9   10    11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30   31   32   33   34   35   36   37   38   39   40   41   42   43   44   45   46   47   48   49   50   51   52   53   54
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 0
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 1
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 2
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 3
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 4
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 5
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 6
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', }, // 7
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 8
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 9
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 10
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 11
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 12
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 13
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 14
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', }, // 15
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 16
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 17
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 18
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 19
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 20
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 21
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 22
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', }, // 23
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 24
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 25
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 26
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 27
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 28
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 29
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, // 30
                                      };
    public void run() throws InterruptedException {
        while (isNotExit) {
            if ( mainMenu ) {
                mainChoices();
            }
            if(!mainMenu) {
                switch (playTypeChoice) {
                    case 1 -> playWithAFriend();
                    case 2 -> playWithTheComputerVersionTwo();
                }
            }
            while (isQuitting) {
                response = 0;
                try {
                    System.out.println("DO YOU STILL WANT TO PLAY OR CHOOSE HOW YOU WANT TO PLAY?");
                    System.out.println(": 1 : for yes (CONTINUE PLAYING)");
                    System.out.println(": 2 : for no (EXIT THE GAME)");
                    System.out.println(": 3 : to go back to main menu (CHOOSE YOUR OPPONENT)");
                    System.out.print(">>> ");
                    response = scannerInput.nextByte();
                    switch (response) {
                        case 1 -> {
                            switch (whichBoard) {
                                case 1 -> resetThreeByThreeBoard();
                                case 2 -> resetFourByFourBoard();
                            }
                            ++playCount;
                            resetFields();
                            isQuitting = false;
                        }
                        case 2 -> {
                            switch (playTypeChoice) {
                                case 1 -> {
                                    System.out.println("THANK YOU ALL FOR PLAYING");
                                    System.out.printf("%s WIN COUNT  : %d times", playerOneName, playerOneWinCount);
                                    System.out.printf("\n%s WIN COUNT  : %d times", playerTwoName, playerTwoWinCount);
                                    System.out.printf("\nTIE COUNT: %d", tieCount);
                                }
                                case 2 -> {
                                    System.out.println("THANK YOU FOR PLAYING");
                                    System.out.printf("HELLO %s , YOU WON  : %d times", humanName, winCount);
                                    System.out.printf("\nYOU LOSS : %d times", lossCount);
                                    System.out.printf("\nTIE COUNT: %d", tieCount);
                                    System.out.printf("\nYOUR PLAY COUNT IS : %d", playCount);
                                }
                            }
                            isQuitting = false;
                            isNotExit = false;
                        }
                        case 3 -> {
                            System.out.print("RETURNING TO MAIN MENU");
                            loading();
                            mainChoices = true;
                            mainMenu = true;
                            playChoice = true;
                            boardSelect = true;
                            isQuitting = false;
                            playTypeChoice = 0;
                            playCount = 1;
                            resetFields();
                            switch (whichBoard) {
                                case 1 -> resetThreeByThreeBoard();
                                case 2 -> resetFourByFourBoard();
                            }
                        }
                        default -> {
                            switch (whichBoard) {
                                case 1 -> printBoard(threeByThreeBoard);
                                case 2 -> printBoard(fourByFourBoard);
                            }
                            System.out.println("INVALID INPUT");
                        }
                    }
                } 
                catch (InputMismatchException e) {
                    System.out.println("PLEASE CHOOSE FROM THE SELECTION");
                    response = 0;
                    scannerInput.nextLine();
                }
            }
        }
    }
    private static void mainChoices() throws InterruptedException {
        while (mainChoices) {
            while (playChoice) {
                try {
                    welcome();
                    System.out.println("HOW WOULD YOU LIKE TO PLAY?");
                    System.out.println(":1: PLAY WITH A FRIEND");
                    System.out.println(":2: PLAY WITH THE COMPUTER");
                    System.out.println(":3: EXIT");
                    System.out.print(">>> ");
                    playTypeChoice = scannerInput.nextByte();
                    switch (playTypeChoice) {
                        case 1 -> {
                            System.out.println("PLAY WITH A FRIEND IS SELECTED");
                            playChoice = false;
                            mainChoices = false;
                            boardSelect = true;
                        }
                        case 2 -> {
                            System.out.println("PLAY WITH A COMPUTER IS SELECTED");
                            playChoice = false;
                            mainChoices = false;
                            boardSelect = true;
                        }
                        case 3 -> {
                            System.out.print("EXITING THE PROGRAM");
                            loading();
                            isNotExit = false;
                            isQuitting = false;
                            boardSelect = false;
                            playChoice = false;
                            mainChoices = false;
                        }
                        default -> System.out.println("INVALID CHOICE!, CHOOSE ONLY >> 1 or 2 or 3 <<");
                    }
                    mainMenu = false;
                    scannerInput.nextLine();
                } 
                catch (InputMismatchException e) {
                    System.out.println("INVALID CHOICE!, ONLY >> 1 or 2 or 3 << is ALLOWED");
                    playTypeChoice = 0;
                    scannerInput.nextLine();
                }
                catch(NoSuchElementException e) {
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
                    System.out.print(">>> ");
                    response = scannerInput.nextByte();
                    switch (response) {
                        case 1 -> {
                            System.out.println("3 X 3 BOARD IS SELECTED");
                            whichBoard = 1;
                            boardSelect = false;
                        }
                        case 2 -> {
                            System.out.println("4 X 4 BOARD IS SELECTED");
                            whichBoard = 2;
                            boardSelect = false;
                        }
                        case 3 -> {
                            System.out.print("RETURNING TO MAIN MENU");
                            loading();
                            boardSelect = false;
                            playChoice = true;
                            mainChoices = true;
                        }
                        default -> System.out.println("INVALID CHOICE!, CHOOSE ONLY >> 1 or 2 or 3 <<");
                    }
                    scannerInput.nextLine();
                } 
                catch (InputMismatchException e) {
                    System.out.println("INVALID CHOICE!, ONLY >> 1 or 2 or 3 << is ALLOWED");
                    response = 0;
                    scannerInput.nextLine();
                }
                catch(NoSuchElementException e) {
                    System.out.println("PLEASE CHOOSE WHICH BOARD YOU WANT TO USE");
                    response = 0;
                    scannerInput.nextLine();
                }
            }
            if (mainChoices && response == 3) {
                boardSelect = true;
            } 
        }
    }

    private static void loading() throws InterruptedException {
        for (int i = 1; i <= 3; i++) {
            TimeUnit.MILLISECONDS.sleep(400);
            System.out.print('.');
        }
        System.out.println();
    }
    // method for vs a person
    private static void playWithAFriend() {
        if (!playerOneWon || !playerTwoWon) {
            while (playerNames) {
                while(playerOneNameLoop) {
                    System.out.println("ENTER PLAYER 1 NAME");
                    System.out.print(">>> ");
                    playerOneName = scannerInput.nextLine().toUpperCase().trim();
                    if (playerOneName.isEmpty()) {
                        System.out.println("PLEASE ENTER YOUR NAME");
                    } 
                    else if (isNumber(playerOneName)) {
                        System.out.println("PLEASE ENTER YOUR NAME PROPERLY");
                        playerOneName = "";
                    }
                    else {
                        playerOneNameLoop = false;
                    }
                }
                while(playerTwoNameLoop) {
                    System.out.println("\nENTER PLAYER 2 NAME");
                    System.out.print(">>> ");
                    playerTwoName = scannerInput.nextLine().toUpperCase().trim();
                    if (playerTwoName.isEmpty()) {
                        System.out.println("PLEASE ENTER YOUR NAME");
                    } 
                    else if (isNumber(playerTwoName)) {
                        System.out.println("PLEASE ENTER YOUR NAME PROPERLY");
                        playerTwoName = ""; 
                    }
                    else {
                        playerTwoNameLoop = false;
                    }
                }
                playerNames = false;
                welcome();
                switch (whichBoard) {
                    case 1 -> printBoard(threeByThreeBoard);
                    case 2 -> printBoard(fourByFourBoard);
                }
                System.out.println();
            }
            String threeByThreeBoardWinnerInVsFriend = threeByThreeBoardCheckWhoWon();
            String fourByFourBoardWinnerInVsFriend = fourByFourBoardCheckWhoWon();
            if (playerOneWon) {
                ++playerOneWinCount;
                switch (whichBoard) {
                    case 1 -> {
                        printBoard(threeByThreeBoard);
                        System.out.println(threeByThreeBoardWinnerInVsFriend);
                    }
                    case 2 -> {
                        printBoard(fourByFourBoard);
                        System.out.println(fourByFourBoardWinnerInVsFriend);
                    }
                }
                isQuitting = true;
            }
            else if (playerTwoWon) {
                ++playerOneWinCount;
                switch (whichBoard) {
                    case 1 -> {
                        printBoard(threeByThreeBoard);
                        System.out.println(threeByThreeBoardWinnerInVsFriend);
                    }
                    case 2 -> {
                        printBoard(fourByFourBoard);
                        System.out.println(fourByFourBoardWinnerInVsFriend);
                    }
                }
                isQuitting = true;
            }
            else if (tie) {
                ++tieCount;
                switch (whichBoard) {
                    case 1 -> {
                        printBoard(threeByThreeBoard);
                        System.out.println(threeByThreeBoardWinnerInVsFriend);
                    }
                    case 2 -> {
                        printBoard(fourByFourBoard);
                        System.out.println(fourByFourBoardWinnerInVsFriend);
                    }
                }
                isQuitting = true;
            }
            else {
                boolean stillPlaying = true;
                while (stillPlaying) {

                    byte playerOneChoice = 0;
                    byte playerTwoChoice = 0;

                    boolean playerOneChoiceLoop = true;
                    boolean playerTwoChoiceLoop = true;

                    while(playerOneChoiceLoop) {
                        if (playerOneWon || playerTwoWon || tie) {
                            playerOneChoiceLoop = false;
                            playerTwoChoiceLoop = false;
                            stillPlaying = false;
                        } 
                        else {
                            switch (whichBoard) {
                                case 1 -> threeByThreeBoardGuide();
                                case 2 -> fourByFourBoardGuide();
                            }
                            System.out.printf("ENTER %s's POSITION: ", playerOneName);
                            System.out.print(">>> ");
                            String playerOneBoardPosition = scannerInput.next().trim();
                            if (isNumber(playerOneBoardPosition)) {
                                playerOneChoice = Byte.parseByte(playerOneBoardPosition); 
                                switch (whichBoard) {
                                    case 1 -> {
                                        if (playerOneChoice >= 1 && playerOneChoice <= 9) {
                                            playerOneChoiceLoop = false;
                                        }
                                        else {
                                            System.out.println();
                                            printBoard(threeByThreeBoard);
                                            System.out.println("CHOOSE ONLY FROM 1 to 9");
                                            playerOneChoice = 0;
                                        }
                                    }
                                    case 2 -> {
                                        if (playerOneChoice >= 1 && playerOneChoice <= 16) {
                                            playerOneChoiceLoop = false;
                                        }
                                        else {
                                            System.out.println();
                                            printBoard(fourByFourBoard);
                                            System.out.println("CHOOSE ONLY FROM 1 to 16");
                                            playerOneChoice = 0;
                                        }
                                    }
                                }
                            }
                            else if (playerOneBoardPosition.isEmpty()) {
                                System.out.println("PLEASE INPUT YOUR CHOICE : REFER TO GUIDE :");
                            }
                            else {
                                System.out.println();
                                switch (whichBoard) {
                                    case 1 -> printBoard(threeByThreeBoard);
                                    case 2 -> printBoard(fourByFourBoard);
                                }
                                System.out.println("INVALID INPUT > ONLY NUMBERS ARE ALLOWED <");
                                scannerInput.nextLine();
                            }
                        }
                    }
                    switch (whichBoard) {
                        case 1 -> {
                            if (playerOneChoice >= 1 && playerOneChoice <= 9) {
                                checkPlayerOneInput(playerOneChoice);
                                threeByThreeBoardWinnerInVsFriend = threeByThreeBoardCheckWhoWon();
                                if (playerOneWon) {
                                    ++playerOneWinCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsFriend);
                                    isQuitting = true;
                                    playerTwoChoiceLoop = false;
                                } else if (playerTwoWon) {
                                    ++playerTwoWinCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsFriend);
                                    isQuitting = true;
                                    playerTwoChoiceLoop = false;
                                } else if (tie) {
                                    ++tieCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsFriend);
                                    isQuitting = true;
                                    playerTwoChoiceLoop = false;
                                } else {
                                    printBoard(threeByThreeBoard);
                                }
                            }
                        }
                        case 2 -> {
                            if (playerOneChoice >= 1 && playerOneChoice <= 16) {
                                checkPlayerOneInput(playerOneChoice);
                                fourByFourBoardWinnerInVsFriend = fourByFourBoardCheckWhoWon();
                                if (playerOneWon) {
                                    ++playerOneWinCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsFriend);
                                    isQuitting = true;
                                    playerTwoChoiceLoop = false;
                                } else if (playerTwoWon) {
                                    ++playerTwoWinCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsFriend);
                                    isQuitting = true;
                                    playerTwoChoiceLoop = false;
                                } else if (tie) {
                                    ++tieCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsFriend);
                                    isQuitting = true;
                                    playerTwoChoiceLoop = false;
                                } else {
                                    printBoard(fourByFourBoard);
                                }
                            }
                        }
                    }
                    while (playerTwoChoiceLoop) {
                        if (playerOneWon || playerTwoWon || tie) {
                            playerTwoChoiceLoop = false;
                            stillPlaying = false;
                        }
                        else {
                            switch (whichBoard) {
                                case 1 -> threeByThreeBoardGuide();
                                case 2 -> fourByFourBoardGuide();
                            }
                            System.out.printf("ENTER %s's POSITION: ", playerTwoName);
                            System.out.print(">>> ");
                            String playerTwoBoardPosition = scannerInput.next().trim();
                            if (isNumber(playerTwoBoardPosition)) {
                                playerTwoChoice = Byte.parseByte(playerTwoBoardPosition);
                                switch (whichBoard) {
                                    case 1:
                                        if (playerTwoChoice >= 1 && playerTwoChoice <= 9) {
                                            playerTwoChoiceLoop = false;
                                        } 
                                        else {
                                            System.out.println();
                                            printBoard(threeByThreeBoard);
                                            System.out.println("CHOOSE ONLY FROM 1 to 9");
                                            playerTwoChoice = 0;
                                        }
                                        break;
                                    case 2:
                                        if (playerTwoChoice >= 1 && playerTwoChoice <= 16) {
                                            playerTwoChoiceLoop = false;
                                        } 
                                        else {
                                            System.out.println();
                                            printBoard(fourByFourBoard);
                                            System.out.println("CHOOSE ONLY FROM 1 to 16");
                                            playerTwoChoice = 0;
                                        }
                                    break;
                                }
                            }
                            else if (playerTwoBoardPosition.isEmpty()) {
                                System.out.println("PLEASE INPUT YOUR CHOICE : REFER TO GUIDE :");
                            }
                            else {
                                System.out.println();
                                switch (whichBoard) {
                                    case 1 -> printBoard(threeByThreeBoard);
                                    case 2 -> printBoard(fourByFourBoard);
                                }
                                System.out.println("INVALID INPUT > ONLY NUMBERS ARE ALLOWED <");
                                scannerInput.nextLine();
                            }
                        }
                    }
                    switch (whichBoard) {
                        case 1-> { // 3 x 3 BOARD
                            if (playerTwoChoice >= 1 && playerTwoChoice <= 9) {
                                checkPlayerTwoInput(playerTwoChoice);
                                threeByThreeBoardWinnerInVsFriend = threeByThreeBoardCheckWhoWon();
                                if (playerOneWon) {
                                    ++playerOneWinCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsFriend);
                                    isQuitting = true;
                                }
                                else if (playerTwoWon) {
                                    ++playerTwoWinCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsFriend);
                                    isQuitting = true;
                                }
                                else if (tie) {
                                    ++tieCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsFriend);
                                    isQuitting = true;
                                }
                                else {
                                    printBoard(threeByThreeBoard);
                                }
                            }
                        }
                        case 2 -> { // 4 x 4 BOARD
                            if (playerTwoChoice >= 1 && playerTwoChoice <= 16) {
                                checkPlayerTwoInput(playerTwoChoice);
                                fourByFourBoardWinnerInVsFriend = fourByFourBoardCheckWhoWon();
                                if (playerOneWon) {
                                    ++playerOneWinCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsFriend);
                                    isQuitting = true;
                                }
                                else if (playerTwoWon) {
                                    ++playerTwoWinCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsFriend);
                                    isQuitting = true;
                                }
                                else if (tie) {
                                    ++tieCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsFriend);
                                    isQuitting = true;
                                }
                                else {
                                    printBoard(fourByFourBoard);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    // method for versus computer
    /**
     * New method
     */
    private static void playWithTheComputerVersionTwo() {
        if (!humanWon || !computerWon) {

            while (playerNameInVsComputer) {

                while (humanNameInput) {
                    System.out.println("ENTER YOUR NAME");
                    System.out.print(">>> ");
                    humanName = scannerInput.nextLine().toUpperCase().trim();
                    if (isNumber(humanName)) {
                        System.out.println("YOUR NAME IS NOT A NUMBER");
                    }
                    else {
                        System.out.println("HELLO " + humanName + " HAVE FUN!");
                        humanNameInput = false;
                    }
                }
                playerNameInVsComputer = false;
                welcome();
                switch (whichBoard) {
                    case 1 -> printBoard(threeByThreeBoard);
                    case 2 -> printBoard(fourByFourBoard);
                }
                System.out.println();
            } // end of name input loop
            String threeByThreeBoardWinnerInVsComputer = threeByThreeBoardCheckWhoWon();
            String fourByFourBoardWinnerInVsComputer = fourByFourBoardCheckWhoWon();
            if (humanWon) {
                ++winCount;
                switch (whichBoard) {
                    case 1 -> {
                        printBoard(threeByThreeBoard);
                        System.out.println(threeByThreeBoardWinnerInVsComputer);
                    }
                    case 2 -> {
                        printBoard(fourByFourBoard);
                        System.out.println(fourByFourBoardWinnerInVsComputer);
                    }
                }
                isQuitting = true;
            }
            else if (computerWon) {
                ++lossCount;
                switch (whichBoard) {
                    case 1 -> {
                        printBoard(threeByThreeBoard);
                        System.out.println(threeByThreeBoardWinnerInVsComputer);
                    }
                    case 2 -> {
                        printBoard(fourByFourBoard);
                        System.out.println(fourByFourBoardWinnerInVsComputer);
                    }
                }
                isQuitting = true;
            }
            else if (tie) {
                ++tieCount;
                switch (whichBoard) {
                    case 1 -> {
                        printBoard(threeByThreeBoard);
                        System.out.println(threeByThreeBoardWinnerInVsComputer);
                    }
                    case 2 -> {
                        printBoard(fourByFourBoard);
                        System.out.println(fourByFourBoardWinnerInVsComputer);
                    }
                }
                isQuitting = true;
            }
            else {
                boolean isStillPlaying = true;
                while (isStillPlaying) {
                    byte humanChoice = 0;
                    byte computerChoice = 0;

                    boolean humanChoiceLoop = true;
                    boolean computerChoiceLoop = true;

                    while(humanChoiceLoop) {
                        if (humanWon || computerWon || tie) {
                            humanChoiceLoop = false;
                            isStillPlaying = false;
                        }
                        else {
                            switch (whichBoard) {
                                case 1 -> threeByThreeBoardGuide();
                                case 2 -> fourByFourBoardGuide();
                            }
                            System.out.printf("ENTER YOUR POSITION %s: ", humanName);
                            System.out.print(">>> ");
                            String humanBoardPosition = scannerInput.next().trim();
                            if (isNumber(humanBoardPosition)) {
                                humanChoice = Byte.parseByte(humanBoardPosition);
                                switch (whichBoard) {
                                    case 1 -> {
                                        if (humanChoice >= 1 && humanChoice <= 9) {
                                            humanChoiceLoop = false;
                                        }
                                        else {
                                            System.out.println();
                                            printBoard(threeByThreeBoard);
                                            System.out.println("CHOOSE ONLY FROM 1 to 9");
                                            humanChoice = 0;
                                        }
                                    }
                                    case 2 -> {
                                        if (humanChoice >= 1 && humanChoice <= 16) {
                                            humanChoiceLoop = false;
                                        }
                                        else {
                                            System.out.println();
                                            printBoard(fourByFourBoard);
                                            System.out.println("CHOOSE ONLY FROM 1 to 16");
                                            humanChoice = 0;
                                        }
                                    }
                                }
                            }
                            else if (humanBoardPosition.isEmpty()) {
                                System.out.println("PLEASE INPUT YOUR CHOICE : REFER TO GUIDE :");
                            }
                            else {
                                System.out.println();
                                switch (whichBoard) {
                                    case 1 -> printBoard(threeByThreeBoard);
                                    case 2 -> printBoard(fourByFourBoard);
                                }
                                System.out.println("INVALID INPUT > ONLY NUMBERS ARE ALLOWED <");
                                scannerInput.nextLine();
                            }
                        }
                    }
                    switch (whichBoard) {
                        case 1 -> {
                            if (humanChoice >= 1 && humanChoice <= 9) {
                                checkHumanInput(humanChoice);
                                threeByThreeBoardWinnerInVsComputer = threeByThreeBoardCheckWhoWon();
                                if (humanWon) {
                                    ++winCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else if (computerWon) {
                                    ++lossCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else if (tie) {
                                    ++tieCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else {
                                    printBoard(threeByThreeBoard);
                                }
                            }
                        }
                        case 2 -> {
                            if (humanChoice >= 1 && humanChoice <= 16) {
                                checkHumanInput(humanChoice);
                                fourByFourBoardWinnerInVsComputer = fourByFourBoardCheckWhoWon();
                                if (humanWon) {
                                    ++winCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else if (computerWon) {
                                    ++lossCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else if (tie) {
                                    ++tieCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else {
                                    printBoard(fourByFourBoard);
                                }
                            }
                        }
                    }
                    if (humanWon || computerWon || tie) {
                        computerChoiceLoop = false;
                        isStillPlaying = false;
                    }
                    else {
                        switch (whichBoard) {
                            case 1 -> threeByThreeBoardGuide();
                            case 2 -> fourByFourBoardGuide();
                        }
                        randomComputerChoice = new Random();
                        if (whichBoard == 1) {
                            computerChoice = (byte) (randomComputerChoice.nextInt(9) + 1);
                        }
                        else if (whichBoard == 2) {
                            computerChoice = (byte) (randomComputerChoice.nextInt(16) + 1);
                        }
                    }
                    while(computerChoiceLoop) {
                        switch (whichBoard) {
                            case 1-> { // 3 x 3 BOARD
                                checkComputerInput(computerChoice);
                                threeByThreeBoardWinnerInVsComputer = threeByThreeBoardCheckWhoWon();
                                if (humanWon) {
                                    System.out.println("I WON AGAIN");
                                    ++winCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsComputer);
                                    isQuitting = true;

                                }
                                else if (computerWon) {
                                    ++lossCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else if (tie) {
                                    ++tieCount;
                                    printBoard(threeByThreeBoard);
                                    System.out.println(threeByThreeBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else {
                                    printBoard(threeByThreeBoard);
                                }
                                computerChoiceLoop = false;
                            }
                            case 2 -> { // 4 x 4 BOARD
                                checkComputerInput(computerChoice);
                                fourByFourBoardWinnerInVsComputer = fourByFourBoardCheckWhoWon();
                                if (humanWon) {
                                    System.out.println("I WON AGAIN");
                                    ++winCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else if (computerWon) {
                                    ++lossCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else if (tie) {
                                    ++tieCount;
                                    printBoard(fourByFourBoard);
                                    System.out.println(fourByFourBoardWinnerInVsComputer);
                                    isQuitting = true;
                                }
                                else {
                                    printBoard(fourByFourBoard);
                                }
                                computerChoiceLoop = false;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void welcome() {
        System.out.println("        ________________________");
        System.out.println("       |                        |");
        System.out.println("       | Welcome to TIC-TAC-TOE |");
        System.out.println("       |________________________|");
    }

    private static void checkPlayerOneInput(byte playerOneInput) {
        while(playerOnePositionsOnTheBoard.contains((int)playerOneInput) || playerTwoPositionsOnTheBoard.contains((int)playerOneInput)) {
            System.out.print("ENTER ANOTHER PLACE IN THE BOARD: ");
            playerOneInput = SimpleTicTacToeGame.scannerInput.nextByte();
        }
        switch (whichBoard) {
            case 1 -> {// 3 x 3 BOARD
                if (playerOneInput >= 1 && playerOneInput <= 9) {
                    System.out.println("--------------------------------------");
                    PositionSelector.selectPosition(threeByThreeBoard, playerOneInput, "PLAYER 1");
                }
                else {
                    System.out.println("INVALID");
                }
            }
            case 2 -> { // 4 x 4 BOARD
                if (playerOneInput >= 1 && playerOneInput <= 16) {
                    System.out.println("-------------------------------------------------------------------------------");
                    PositionSelector.selectPosition(fourByFourBoard, playerOneInput, "PLAYER 1");
                } else {
                    System.out.println("INVALID");
                }
            }
        }
    }

    private static void checkPlayerTwoInput(byte playerTwoInput) {
        while(playerOnePositionsOnTheBoard.contains((int)playerTwoInput) || playerTwoPositionsOnTheBoard.contains((int)playerTwoInput)) {
            System.out.print("ENTER ANOTHER PLACE IN THE BOARD: ");
            playerTwoInput = SimpleTicTacToeGame.scannerInput.nextByte();
        }
        switch (whichBoard) {
            case 1:
                if (playerTwoInput >= 1 && playerTwoInput <= 9) {
                    System.out.println("--------------------------------------");
                    PositionSelector.selectPosition(threeByThreeBoard, playerTwoInput, "PLAYER 2");
                }
                else {
                    System.out.println("INVALID");
                }
                break;
            case 2:
                if (playerTwoInput >= 1 && playerTwoInput <= 16) {
                    System.out.println("-------------------------------------------------------------------------------");
                    PositionSelector.selectPosition(fourByFourBoard, playerTwoInput, "PLAYER 2");
                }
                else {
                    System.out.println("INVALID");
                }
            break;
        }
    }

    private static void checkHumanInput(byte humanBoardPosition) {
        while(humanPositionsOnTheBoard.contains((int)humanBoardPosition) || computerPositionsOnTheBoard.contains((int)humanBoardPosition)) {
            System.out.print("ENTER ANOTHER PLACE IN THE BOARD: ");
            humanBoardPosition = SimpleTicTacToeGame.scannerInput.nextByte();
        }
        switch (whichBoard) {
            case 1 -> {
                if (humanBoardPosition >= 1 && humanBoardPosition <= 9) {
                    System.out.println("--------------------------------------");
                    PositionSelector.selectPosition(threeByThreeBoard, humanBoardPosition, "HUMAN");
                } else {
                    System.out.println("INVALID");
                }
            }
            case 2 -> {
                if (humanBoardPosition >= 1 && humanBoardPosition <= 16) {
                    System.out.println("--------------------------------------");
                    PositionSelector.selectPosition(fourByFourBoard, humanBoardPosition, "HUMAN");
                } else {
                    System.out.println("INVALID");
                }
            }
            default -> System.out.println("HUMAN INPUT ERROR");
        }
    }

    private static void checkComputerInput(byte computerBoardPosition) {
        while(humanPositionsOnTheBoard.contains((int)computerBoardPosition) || computerPositionsOnTheBoard.contains((int)computerBoardPosition)) {
            switch (whichBoard) {
                case 1 -> {
                    if (!humanWon || !tie) {
                        randomComputerChoice = new Random();
                        computerBoardPosition = (byte) (randomComputerChoice.nextInt(9) + 1);
                    }
                }
                case 2 -> {
                    if (!humanWon || !tie) {
                        randomComputerChoice = new Random();
                        computerBoardPosition = (byte) (randomComputerChoice.nextInt(16) + 1);
                    }
                }
                default -> System.out.println("COMPUTER INPUT ERROR");
            }
        }
        switch (whichBoard) {
            case 1 -> {
                if (computerBoardPosition >= 1 && computerBoardPosition <= 9) {
                    System.out.println("--------------------------------------");
                    PositionSelector.selectPosition(threeByThreeBoard, computerBoardPosition, "COMPUTER");
                }
                else {
                    System.out.println("INVALID");
                }
            }
            case 2 -> {
                if (computerBoardPosition >= 1 && computerBoardPosition <= 16) {
                    System.out.println("--------------------------------------");
                    PositionSelector.selectPosition(fourByFourBoard, computerBoardPosition, "COMPUTER");
                }
                else {
                    System.out.println("INVALID");
                }
            }
        }
    }

    private static void threeByThreeBoardGuide() {
        System.out.println("            :GUIDE:");
        System.out.println("           1 | 2 | 3 ");
        System.out.println("          ---+---+---");
        System.out.println("           4 | 5 | 6 ");
        System.out.println("          ---+---+---");
        System.out.println("           7 | 8 | 9 ");
    }

    private static void fourByFourBoardGuide() {
        System.out.println("            :GUIDE:");    
        System.out.println("          1 |  2 | 3  | 4 ");
        System.out.println("        ----+----+---+----");
        System.out.println("          5 |  6 | 7  | 8");
        System.out.println("        ----+----+---+----");
        System.out.println("          9 | 10 | 11 | 12 ");
        System.out.println("        ----+----+----+----");
        System.out.println("         13 | 14 | 15 | 16");
        
    }

    private static void printBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

    private static void resetFields() {

        playerTwoPositionsOnTheBoard.clear();
        playerOnePositionsOnTheBoard.clear();
        computerPositionsOnTheBoard.clear();
        humanPositionsOnTheBoard.clear();
        playerNameInVsComputer = true;
        humanNameInput = true;
        playerTwoWon = false;
        playerOneWon = false;
        computerWon = false;
        playChoice = true;
        humanWon = false;
        tie = false;
        playerOneName = "";
        playerTwoName = "";
        humanName = "";
        lossCount = 0;
        winCount = 0;
        tieCount = 0;
    }

    private static boolean isNumber(String input) {
        try {
            Byte.parseByte(input);
            return true;
        } 
        catch (Exception e) {
            System.out.print(' ');
        }
        return false;
    }

    private static String threeByThreeBoardCheckWhoWon() {

        List<Integer> threeByThreeBoardTopRowCondition = Arrays.asList(1, 2, 3);
        List<Integer> threeByThreeBoardMiddleRowCondition = Arrays.asList(4, 5, 6);
        List<Integer> threeByThreeBoardBottomRowCondition = Arrays.asList(7, 8, 9);

        List<Integer> threeByThreeBoardTopColumnCondition = Arrays.asList(1, 4, 7);
        List<Integer> threeByThreeBoardMiddleColumnCondition = Arrays.asList(2, 5, 8);
        List<Integer> threeByThreeBoardBottomColumnCondition = Arrays.asList(3, 6, 9);

        List<Integer> threeByThreeBoardFrontSlashCondition = Arrays.asList(7, 5, 3);
        List<Integer> threeByThreeBoardBackSlashCondition = Arrays.asList(1, 5, 9);

        List<List<Integer>> threeByThreeBoardAllWinningConditions = new ArrayList<>();

        threeByThreeBoardAllWinningConditions.add(threeByThreeBoardTopRowCondition);
        threeByThreeBoardAllWinningConditions.add(threeByThreeBoardMiddleRowCondition);
        threeByThreeBoardAllWinningConditions.add(threeByThreeBoardBottomRowCondition);

        threeByThreeBoardAllWinningConditions.add(threeByThreeBoardTopColumnCondition);
        threeByThreeBoardAllWinningConditions.add(threeByThreeBoardMiddleColumnCondition);
        threeByThreeBoardAllWinningConditions.add(threeByThreeBoardBottomColumnCondition);

        threeByThreeBoardAllWinningConditions.add(threeByThreeBoardFrontSlashCondition);
        threeByThreeBoardAllWinningConditions.add(threeByThreeBoardBackSlashCondition);

        for (List<Integer>  listOfThreeByThreeWinConditions : threeByThreeBoardAllWinningConditions) {
            switch (playTypeChoice) {
                case 1 -> {
                    if (playerOnePositionsOnTheBoard.containsAll(listOfThreeByThreeWinConditions)) {
                        playerOneWon = true;
                        return "==================================\n            " + playerOneName + " WON\n==================================";
                    }
                    else if (playerTwoPositionsOnTheBoard.containsAll(listOfThreeByThreeWinConditions)) {
                        playerTwoWon = true;
                        return "==================================\n            " + playerTwoName + " WON\n==================================";
                    }
                }
                case 2 -> {
                    if (humanPositionsOnTheBoard.containsAll(listOfThreeByThreeWinConditions)) {
                        humanWon = true;
                        return "==================================\nHELLO! " + humanName + " YOU WON!\n==================================";
                    }
                    else if (computerPositionsOnTheBoard.containsAll(listOfThreeByThreeWinConditions)) {
                        computerWon = true;
                        return "==================================\n             YOU LOSE\n==================================";
                    }
                }
            }
        }
        if ( playerOnePositionsOnTheBoard.size() + playerTwoPositionsOnTheBoard.size() == 9 || humanPositionsOnTheBoard.size() + computerPositionsOnTheBoard.size() == 9 ) {
            tie = true;
            return "==================================\n             TIE\n==================================";
        }
        return "ERROR";
    }

    private static String fourByFourBoardCheckWhoWon() {

        List<Integer> fourByFourBoardFirstRowCondition = Arrays.asList(1, 2, 3, 4);
        List<Integer> fourByFourBoardSecondRowCondition = Arrays.asList(5, 6, 7, 8);
        List<Integer> fourByFourBoardThirdRowCondition = Arrays.asList(9, 10, 11, 12);
        List<Integer> fourByFourFourthRowCondition = Arrays.asList(13, 14, 15, 16);

        List<Integer> fourByFourBoardFirstColumnCondition = Arrays.asList(1, 5, 9, 13);
        List<Integer> fourByFourBoardSecondColumnCondition = Arrays.asList(2, 6, 10, 14);
        List<Integer> fourByFourBoardThirdColumnCondition = Arrays.asList(3, 7, 11, 15);
        List<Integer> fourByFourBoardFourthColumnCondition = Arrays.asList(4, 8, 12, 16);

        List<Integer> fourByFourBoardThreeFirstFrontSlashCondition = Arrays.asList(9, 6, 3);
        List<Integer> fourByFourBoardFourMiddleFirstFrontSlashCondition = Arrays.asList(13, 10, 7, 4);
        List<Integer> fourByFourBoardThreeSecondFrontSlashCondition = Arrays.asList(14, 11, 8);

        List<Integer> fourByFourBoardThreeFirstBackSlashCondition = Arrays.asList(5, 10, 13);
        List<Integer> fourByFourBoardFourMiddleFirstBackSlashCondition = Arrays.asList(1, 6, 11, 16);
        List<Integer> fourByFourBoardThreeSecondBackSlashCondition = Arrays.asList(2, 7, 12);

        List<List<Integer>> fourByFourBoardAllWinningConditions = new ArrayList<>();

        fourByFourBoardAllWinningConditions.add(fourByFourBoardFirstRowCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourBoardSecondRowCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourBoardThirdRowCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourFourthRowCondition);

        fourByFourBoardAllWinningConditions.add(fourByFourBoardFirstColumnCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourBoardSecondColumnCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourBoardThirdColumnCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourBoardFourthColumnCondition);

        fourByFourBoardAllWinningConditions.add(fourByFourBoardThreeFirstFrontSlashCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourBoardFourMiddleFirstFrontSlashCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourBoardThreeSecondFrontSlashCondition);

        fourByFourBoardAllWinningConditions.add(fourByFourBoardThreeFirstBackSlashCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourBoardFourMiddleFirstBackSlashCondition);
        fourByFourBoardAllWinningConditions.add(fourByFourBoardThreeSecondBackSlashCondition);

        for (List<Integer>  listOfFourByFourWinConditions : fourByFourBoardAllWinningConditions) {
            switch (playTypeChoice) {
                case 1 -> {
                    if (playerOnePositionsOnTheBoard.containsAll(listOfFourByFourWinConditions)) {
                        playerOneWon = true;
                        return "==================================\n            " + playerOneName + " WON\n==================================";
                    }
                    else if (playerTwoPositionsOnTheBoard.containsAll(listOfFourByFourWinConditions)) {
                        playerTwoWon = true;
                        return "==================================\n            " + playerTwoName + " WON\n==================================";
                    }
                }
                case 2 -> {
                    if (humanPositionsOnTheBoard.containsAll(listOfFourByFourWinConditions)) {
                        System.out.println("I WON IN CHECK");
                        humanWon = true;
                        return "==================================\nHELLO! " + humanName + " YOU WON!\n==================================";
                    }
                    else if (computerPositionsOnTheBoard.containsAll(listOfFourByFourWinConditions)) {
                        computerWon = true;
                        return "==================================\n             YOU LOSE\n==================================";
                    }
                }
            }
        }
        if ( playerOnePositionsOnTheBoard.size() + playerTwoPositionsOnTheBoard.size() == 16 || humanPositionsOnTheBoard.size() + computerPositionsOnTheBoard.size() == 16 ){
            tie = true;
            return "==================================\n             TIE\n==================================";
        }
        return "ERROR";
    }

    private static void resetThreeByThreeBoard() {

        char pipe = '|';
        char plus = '+';
        char equal = '=';
        char space = ' ';

        byte boardRow = 22;
        byte boardColumn = 40;
        
        for (byte i = 0; i <= boardRow; i++) {
            for (byte j = 0; j <= boardColumn ; j++) {
                SimpleTicTacToeGame.threeByThreeBoard[i][j] = space;
                if (j == 13 || j == 27) {
                    SimpleTicTacToeGame.threeByThreeBoard[i][j] = pipe;
                }
                if ((i == 7 && j == 13) || (i == 15 && j == 27)) {
                    SimpleTicTacToeGame.threeByThreeBoard[i][j] = plus;
                }
                else if (i == 7 || i == 15) {
                    SimpleTicTacToeGame.threeByThreeBoard[i][j] = equal;
                }
            }
            // end of inner loop
        }
        // end of outer loop
    }

    private static void resetFourByFourBoard() {

        char pipe = '|';
        char plus = '+';
        char equal = '=';
        char space = ' ';
        
        byte boardRow = 30;
        byte boardColumn = 54;

        for (byte i = 0; i <= boardRow; i++) {
            for (byte j = 0; j <= boardColumn ; j++) {
                SimpleTicTacToeGame.fourByFourBoard[i][j] = space;
                if (j == 13 || j == 27 || j == 41) {
                    SimpleTicTacToeGame.fourByFourBoard[i][j] = pipe;
                }
                if ((i == 7 && j == 13) || (i == 15 && j == 27) || (i == 23 && j == 41)) {
                    SimpleTicTacToeGame.fourByFourBoard[i][j] = plus;
                }
                else if (i == 7 || i == 15 || i == 23) {
                    SimpleTicTacToeGame.fourByFourBoard[i][j] = equal;
                }
            }
            // end of inner loop
        }
        // end of outer loop
    }
}