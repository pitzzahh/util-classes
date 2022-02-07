package lib.games.ticTacToe.ticTacToeWithMiniMaxAlgorithm;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

final class Game {
    private Game() {}
    static final ArrayList<Point> choicesLogs = new ArrayList<>(16);
    static class Boards {
        private Boards() {}
        static final char HUMAN = 'X';
        static final char COMPUTER = 'O';
        static final char NO_PLAYER = ' ';
        static Point computerMove;
        static final char[][] threeByThreeBoard = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        static final char[][] fourByFourBoard = {{' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '}};
        protected static char[][] boardCopy;

    } // end of Boards class

    public static class Point {
        public final byte x;
        public final byte y;
        protected Point(byte row, byte column) {
            this.x = row;
            this.y = column;
        }
        @Override
        public String toString() {
            switch (TicTacToe.whichBoard) {
                case "3x3":
                    if (x == 0 && y == 0) {
                        return "1";
                    } else if (x == 0 && y == 1) {
                        return "2";
                    } else if (x == 0 && y == 2) {
                        return "3";
                    } else if (x == 1 && y == 0) {
                        return "4";
                    } else if (x == 1 && y == 1) {
                        return "5";
                    } else if (x == 1 && y == 2) {
                        return "6";
                    } else if (x == 2 && y == 0) {
                        return "7";
                    } else if (x == 2 && y == 1) {
                        return "8";
                    } else if (x == 2 && y == 2) {
                        return "9";
                    }
                    break;
                case "4x4":
                    if (x == 0 && y == 0) {
                        return "1";
                    } else if (x == 0 && y == 1) {
                        return "2";
                    } else if (x == 0 && y == 2) {
                        return "3";
                    } else if (x == 0 && y == 3) {
                        return "4";
                    } else if (x == 1 && y == 0) {
                        return "5";
                    } else if (x == 1 && y == 1) {
                        return "6";
                    } else if (x == 1 && y == 2) {
                        return "7";
                    } else if (x == 1 && y == 3) {
                        return "8";
                    } else if (x == 2 && y == 0) {
                        return "9";
                    } else if (x == 2 && y == 1) {
                        return "10";
                    } else if (x == 2 && y == 2) {
                        return "11";
                    } else if (x == 2 && y == 3) {
                        return "12";
                    } else if (x == 3 && y == 0) {
                        return "13";
                    } else if (x == 3 && y == 1) {
                        return "14";
                    } else if (x == 3 && y == 2) {
                        return "15";
                    } else if (x == 3 && y == 3) {
                        return "16";
                    }
                    break;
            }
            return "O";
        }
    } // end of Point class

    public static void resetFields() {
        TicTacToe.whichBoard = "";
        TicTacToe.humanNameInput = true;
        TicTacToe.isExit = false;
        TicTacToe.mainChoices = true;
        TicTacToe.playChoice = true;
        TicTacToe.boardSelect = true;
        TicTacToe.difficulty = true;
        TicTacToe.playTypeChoice = 0;
        TicTacToe.playerName = "";
        TicTacToe.gameDifficulty = "";
        choicesLogs.clear();
    } // end of restFields method

    static void printBoard(String whichBoard) {
        byte row = 0;
        byte column = 0;
        if ("3x3".equals(whichBoard)) {
            System.out.print("\t" + Boards.threeByThreeBoard[0][0] + " | " + Boards.threeByThreeBoard[0][1] + " | " + Boards.threeByThreeBoard[0][2] +
                    "\n\t--+---+--\n\t" +
                    Boards.threeByThreeBoard[1][0] + " | " + Boards.threeByThreeBoard[1][1] + " | " + Boards.threeByThreeBoard[1][2] +
                    "\n\t--+---+--\n\t" +
                    Boards.threeByThreeBoard[2][0] + " | " + Boards.threeByThreeBoard[2][1] + " | " + Boards.threeByThreeBoard[2][2]);
        } else if ("4x4".equals(whichBoard)) {
            System.out.print("\t" + Boards.fourByFourBoard[0][0] + " | " + Boards.fourByFourBoard[0][1] + " | " + Boards.fourByFourBoard[0][2] + " | " + Boards.fourByFourBoard[0][3] +
                    "\n\t--+---+---+--\n\t" +
                    Boards.fourByFourBoard[1][0] + " | " + Boards.fourByFourBoard[1][1] + " | " + Boards.fourByFourBoard[1][2] + " | " + Boards.fourByFourBoard[1][3] +
                    "\n\t--+---+---+--\n\t" +
                    Boards.fourByFourBoard[2][0] + " | " + Boards.fourByFourBoard[2][1] + " | " + Boards.fourByFourBoard[2][2] + " | " + Boards.fourByFourBoard[2][3] +
                    "\n\t--+---+---+--\n\t" +
                    Boards.fourByFourBoard[3][0] + " | " + Boards.fourByFourBoard[3][1] + " | " + Boards.fourByFourBoard[3][2] + " | " + Boards.fourByFourBoard[3][3]);
        } else if ("copy".equals(whichBoard)) {
            if (Boards.boardCopy.length == 2) {
                row = 2;
                column = 2;
            } else if (Boards.boardCopy.length == 3) {
                row = 3;
                column = 3;
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(Boards.boardCopy[i][j] + " | ");
                }
                if (Boards.boardCopy.length == 2) {
                    System.out.println("\n--+---+--\n");
                } else if (Boards.boardCopy.length == 3) {
                    System.out.println("\n--+---+---+--\n");
                }
            }
        }
        System.out.println();
    } // end of printBoard method

    static void resetThreeByThreeBoard() {
        for (byte row = 0; row < Boards.threeByThreeBoard.length; row++) {
            for (byte column = 0; column < Boards.threeByThreeBoard[0].length; column++) {
                Boards.threeByThreeBoard[row][column] = ' ';
            }
        }
    } // end of resetThreeByThree method

    static void resetFourByFourBoard() {
        for (byte row = 0; row < Boards.fourByFourBoard.length; row++) {
            for (byte column = 0; column < Boards.fourByFourBoard[0].length; column++) {
                Boards.fourByFourBoard[row][column] = ' ';
            }
        }
    } // end of resetFourByFourBoard method

    static void threeByThreeBoardGuide() {
        System.out.println("            :GUIDE:");
        System.out.println("           1 | 2 | 3 ");
        System.out.println("          ---+---+---");
        System.out.println("           4 | 5 | 6 ");
        System.out.println("          ---+---+---");
        System.out.println("           7 | 8 | 9 ");
    } // end of threeByThreeGuide method

    static void fourByFourBoardGuide() {
        System.out.println("            :GUIDE:");
        System.out.println("          1 |  2 | 3  | 4 ");
        System.out.println("        ----+----+---+----");
        System.out.println("          5 |  6 | 7  | 8");
        System.out.println("        ----+----+---+----");
        System.out.println("          9 | 10 | 11 | 12 ");
        System.out.println("        ----+----+----+----");
        System.out.println("         13 | 14 | 15 | 16");

    } // end of fourByFourGuide method

    static boolean placeChoice(Point point, char player) {
        if ("3x3".equals(TicTacToe.whichBoard)) {
            if (Boards.threeByThreeBoard[point.x][point.y] != Boards.NO_PLAYER) {
                return false;
            }
            Boards.threeByThreeBoard[point.x][point.y] = player;
        } else if ("4x4".equals(TicTacToe.whichBoard)) {
            if (Boards.fourByFourBoard[point.x][point.y] != Boards.NO_PLAYER) {
                return false;
            }
            Boards.fourByFourBoard[point.x][point.y] = player;
        }
        return true;
    } // end of placeChoice method

    static List<Point> choices() {
        byte rowCount = 0;
        byte columnCount = 0;
        byte size = 0;
        if ("3x3".equals(TicTacToe.whichBoard)) {
            size = 9;
            rowCount = (byte) Boards.threeByThreeBoard.length;
            columnCount = (byte) Boards.threeByThreeBoard[0].length;
        } else if ("4x4".equals(TicTacToe.whichBoard)) {
            size = 16;
            rowCount = (byte) Boards.fourByFourBoard.length;
            columnCount = (byte) Boards.fourByFourBoard[0].length;
        }
        List<Point> availableChoices = new ArrayList<>(size);
        for (byte row = 0; row < rowCount; row++) {
            for (byte column = 0; column < columnCount; column++) {
                switch (TicTacToe.whichBoard) {
                    case "3x3" :
                        if (Boards.threeByThreeBoard[row][column] == Boards.NO_PLAYER) {
                            availableChoices.add(new Point(row, column));
                        }
                        break;
                    case "4x4" :
                        if (Boards.fourByFourBoard[row][column] == Boards.NO_PLAYER) {
                            availableChoices.add(new Point(row, column));
                        }
                        break;
                }
            }
        }
        return availableChoices;
    } // end of choices method

    static boolean isThereAWinner(char player, String whatBoard) {
        if ("3x3".equals(whatBoard)) {// slanting winning conditions
            if ((Boards.threeByThreeBoard[0][0] == Boards.threeByThreeBoard[1][1] &&
                    Boards.threeByThreeBoard[0][0] == Boards.threeByThreeBoard[2][2] &&
                    Boards.threeByThreeBoard[0][0] == player) ||
                    (Boards.threeByThreeBoard[0][2] == Boards.threeByThreeBoard[1][1] &&
                            Boards.threeByThreeBoard[0][2] == Boards.threeByThreeBoard[2][0] &&
                            Boards.threeByThreeBoard[0][2] == player)) {
                return true;
            }
            // horizontal and vertical winning conditions
            for (int i = 0; i < 3; i++) {
                if ((Boards.threeByThreeBoard[i][0] == Boards.threeByThreeBoard[i][1] &&
                        Boards.threeByThreeBoard[i][0] == Boards.threeByThreeBoard[i][2] &&
                        Boards.threeByThreeBoard[i][0] == player) ||
                        (Boards.threeByThreeBoard[0][i] == Boards.threeByThreeBoard[1][i] &&
                                Boards.threeByThreeBoard[0][i] == Boards.threeByThreeBoard[2][i] &&
                                Boards.threeByThreeBoard[0][i] == player)) {
                    return true;
                }
            }
        } else if ("4x4".equals(whatBoard)) {// slanting winning conditions
            if ((Boards.fourByFourBoard[0][0] == Boards.fourByFourBoard[1][1] && Boards.fourByFourBoard[1][1] == Boards.fourByFourBoard[2][2] &&
                    Boards.fourByFourBoard[2][2] == Boards.fourByFourBoard[3][3] && Boards.fourByFourBoard[3][3] == player) ||
                    (Boards.fourByFourBoard[0][1] == Boards.fourByFourBoard[1][2] && Boards.fourByFourBoard[1][2] == Boards.fourByFourBoard[2][3] &&
                            Boards.fourByFourBoard[2][3] == player) ||
                    (Boards.fourByFourBoard[1][0] == Boards.fourByFourBoard[2][1] && Boards.fourByFourBoard[2][1] == Boards.fourByFourBoard[3][2] &&
                            Boards.fourByFourBoard[3][2] == player) ||
                    (Boards.fourByFourBoard[0][3] == Boards.fourByFourBoard[1][2] && Boards.fourByFourBoard[1][2] == Boards.fourByFourBoard[2][1] &&
                            Boards.fourByFourBoard[2][1] == Boards.fourByFourBoard[3][0] && Boards.fourByFourBoard[3][0] == player) ||
                    (Boards.fourByFourBoard[0][2] == Boards.fourByFourBoard[1][1] && Boards.fourByFourBoard[1][1] == Boards.fourByFourBoard[2][0] &&
                            Boards.fourByFourBoard[2][0] == player) ||
                    (Boards.fourByFourBoard[1][3] == Boards.fourByFourBoard[2][2] && Boards.fourByFourBoard[2][2] == Boards.fourByFourBoard[3][1] &&
                            Boards.fourByFourBoard[3][1] == player)) {
                return true;
            }
            // horizontal and vertical winning conditions
            for (int i = 0; i < 4; i++) {
                if ((Boards.fourByFourBoard[0][i] == Boards.fourByFourBoard[1][i] &&
                        Boards.fourByFourBoard[0][i] == Boards.fourByFourBoard[2][i] &&
                        Boards.fourByFourBoard[0][i] == Boards.fourByFourBoard[3][i] &&
                        Boards.fourByFourBoard[0][i] == player) ||
                        (Boards.fourByFourBoard[i][0] == Boards.fourByFourBoard[i][1] &&
                                Boards.fourByFourBoard[i][0] == Boards.fourByFourBoard[i][2] &&
                                Boards.fourByFourBoard[i][0] == Boards.fourByFourBoard[i][3] &&
                                Boards.fourByFourBoard[i][0] == player)) {
                    return true;
                }
            }
        } else if ("copy".equals(whatBoard)) {
            if (Boards.boardCopy.length == 3) {
                // slanting winning conditions
                if ((Boards.boardCopy[0][0] == Boards.boardCopy[1][1] &&
                        Boards.boardCopy[0][0] == Boards.boardCopy[2][2] &&
                        Boards.boardCopy[0][0] == player) ||
                        (Boards.boardCopy[0][2] == Boards.boardCopy[1][1] &&
                                Boards.boardCopy[0][2] == Boards.boardCopy[2][0] &&
                                Boards.boardCopy[0][2] == player)) {
                    return true;
                }
                // horizontal and vertical winning conditions
                for (int i = 0; i < 3; i++) {
                    if ((Boards.boardCopy[i][0] == Boards.boardCopy[i][1] &&
                            Boards.boardCopy[i][0] == Boards.boardCopy[i][2] &&
                            Boards.boardCopy[i][0] == player) ||
                            (Boards.boardCopy[0][i] == Boards.boardCopy[1][i] &&
                                    Boards.boardCopy[0][i] == Boards.boardCopy[2][i] &&
                                    Boards.boardCopy[0][i] == player)) {
                        return true;
                    }
                }
            }
            if (Boards.boardCopy.length == 4) {
                // slanting winning conditions
                if ((Boards.boardCopy[0][0] == Boards.boardCopy[1][1] && Boards.boardCopy[1][1] == Boards.boardCopy[2][2] &&
                        Boards.boardCopy[2][2] == Boards.boardCopy[3][3] && Boards.boardCopy[3][3] == player) ||
                        (Boards.boardCopy[0][1] == Boards.boardCopy[1][2] && Boards.boardCopy[1][2] == Boards.boardCopy[2][3] &&
                                Boards.boardCopy[2][3] == player) ||
                        (Boards.boardCopy[1][0] == Boards.boardCopy[2][1] && Boards.boardCopy[2][1] == Boards.boardCopy[3][2] &&
                                Boards.boardCopy[3][2] == player) ||
                        (Boards.boardCopy[0][3] == Boards.boardCopy[1][2] && Boards.boardCopy[1][2] == Boards.boardCopy[2][1] &&
                                Boards.boardCopy[2][1] == Boards.boardCopy[3][0] && Boards.boardCopy[3][0] == player) ||
                        (Boards.boardCopy[0][2] == Boards.boardCopy[1][1] && Boards.boardCopy[1][1] == Boards.boardCopy[2][0] &&
                                Boards.boardCopy[2][0] == player) ||
                        (Boards.boardCopy[1][3] == Boards.boardCopy[2][2] && Boards.boardCopy[2][2] == Boards.boardCopy[3][1] &&
                                Boards.boardCopy[3][1] == player)) {
                    return true;
                }
                // horizontal and vertical winning conditions
                for (int i = 0; i < 4; i++) {
                    if ((Boards.boardCopy[0][i] == Boards.boardCopy[1][i] &&
                            Boards.boardCopy[0][i] == Boards.boardCopy[2][i] &&
                            Boards.boardCopy[0][i] == Boards.boardCopy[3][i] &&
                            Boards.boardCopy[0][i] == player) ||
                            (Boards.boardCopy[i][0] == Boards.boardCopy[i][1] &&
                                    Boards.boardCopy[i][0] == Boards.boardCopy[i][2] &&
                                    Boards.boardCopy[i][0] == Boards.boardCopy[i][3] &&
                                    Boards.boardCopy[i][0] == player)) {
                        return true;
                    }
                }
            }
        }
        return false;
    } // end of whoWon method

    static void easy () throws InterruptedException {
        Random randomNumber = new Random();
        List<Point> availablePoints = choices();
        Point choice = null;
        for (int i = 0; i < availablePoints.size(); i++) {
            choice = availablePoints.get(randomNumber.nextInt(availablePoints.size()));
        }
        if (!isGameOver()) {
            assert choice != null;
            placeChoice(choice, Boards.COMPUTER);
            System.out.print("PICKING");
            TicTacToe.loading();
            System.out.println("COMPUTER CHOICE: " + choice);
        }
        TicTacToe.playCount++;
    } // end of easy method

    /*
     *  IF THERE IS A POSSIBLE WINNING CONDITION, THE COMPUTER CHOOSES THAT POSITION
     */
    static void medium() throws InterruptedException {
        List<Point> emptyPlaces = choices(); // gets the empty positions
        boolean isPossibleToWin = false;
        System.out.print("PICKING");
        TicTacToe.loading();
        // checks which board the user chose, and copy that board.
        if ("3x3".equals(TicTacToe.whichBoard)) {
            Boards.boardCopy = TicTacToe.copy(Boards.threeByThreeBoard);
        } else if ("4x4".equals(TicTacToe.whichBoard)) {
            Boards.boardCopy = TicTacToe.copy(Boards.fourByFourBoard);
        }
        for (Point emptyPlace : emptyPlaces) {
            Boards.boardCopy[emptyPlace.x][emptyPlace.y] = Boards.COMPUTER;
            isPossibleToWin = isThereAWinner(Boards.COMPUTER, "copy");
            if (isPossibleToWin) {
                choicesLogs.add(emptyPlace);
            }
        }
        if (isPossibleToWin) {
            for (Point possible : choicesLogs) {
                Boards.boardCopy[possible.x][possible.y] = Boards.COMPUTER;
                isPossibleToWin = isThereAWinner(Boards.COMPUTER, "copy");
                if(isPossibleToWin) {
                    placeChoice(possible, Boards.COMPUTER);
                    break;
                }
                else {
                    Boards.boardCopy[possible.x][possible.y] = Boards.NO_PLAYER;
                }
            }
        }
        if (!isPossibleToWin) {
            System.out.println("OUT OF CHOICES, ATTEMPTING EASY CHOICE");
            easy();
        }
        choicesLogs.clear();
        TicTacToe.playCount++;
    } // end of medium method

    static void hard() throws InterruptedException {
        miniMaxAlphaBeta(0, true);
        System.out.print("PICKING");
        TicTacToe.loading();
        System.out.println("COMPUTER CHOICE: " + Boards.computerMove);
        placeChoice(Boards.computerMove, Boards.COMPUTER);
        TicTacToe.playCount++;
    } // end of hard method

    static boolean isGameOver() {
        return isThereAWinner(Boards.HUMAN, TicTacToe.whichBoard) || isThereAWinner(Boards.COMPUTER, TicTacToe.whichBoard) || choices().isEmpty();
    } // end of isGameOver method
    /*
     *  HAS PROBLEMS WHEN PLAYING 4x4 hard difficulty, IT TAKES SO LONG FINDING MOVE
     */
    static int miniMaxAlphaBeta(int depth, boolean isMaximizing) {
        List<Point> availablePositions = choices();
        if (isThereAWinner(Boards.HUMAN, TicTacToe.whichBoard)) {
            return -1;
        }
        if (isThereAWinner(Boards.COMPUTER, TicTacToe.whichBoard)) {
            return 1;
        }
        if (availablePositions.isEmpty()) {
            return 0;
        }
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < availablePositions.size(); i++) {
            Point position = availablePositions.get(i);
            if (isMaximizing) {
                placeChoice(position, Boards.COMPUTER);
                int score = miniMaxAlphaBeta(depth + 1, false);
                maximum = Math.max(score, maximum);
                if (score >= 0) {
                    if (depth == 0) {
                        Boards.computerMove = position;
                    }
                }
                if (score == 1) {
                    if ("3x3".equals(TicTacToe.whichBoard)) {
                        Boards.threeByThreeBoard[position.x][position.y] = Boards.NO_PLAYER;
                    } else if ("4x4".equals(TicTacToe.whichBoard)) {
                        Boards.fourByFourBoard[position.x][position.y] = Boards.NO_PLAYER;
                    }
                    break;
                }
                if (i == availablePositions.size() + 1 && maximum < 0) {
                    if (depth == 0) {
                        Boards.computerMove = position;
                    }
                }
            }
            else {
                placeChoice(position, Boards.HUMAN);
                int score = miniMaxAlphaBeta(depth + 1, true);
                minimum = Math.min(score, minimum);

                if (minimum == -1) {
                    if ("3x3".equals(TicTacToe.whichBoard)) {
                        Boards.threeByThreeBoard[position.x][position.y] = Boards.NO_PLAYER;
                    } else if ("4x4".equals(TicTacToe.whichBoard)) {
                        Boards.fourByFourBoard[position.x][position.y] = Boards.NO_PLAYER;
                    }
                    break;
                }
            }
            if ("3x3".equals(TicTacToe.whichBoard)) {
                Boards.threeByThreeBoard[position.x][position.y] = Boards.NO_PLAYER;
            } else if ("4x4".equals(TicTacToe.whichBoard)) {
                Boards.fourByFourBoard[position.x][position.y] = Boards.NO_PLAYER;
            }
        }
        return isMaximizing ? maximum : minimum;
    } // end of miniMaxAlphaBeta method

} // end of Game class
