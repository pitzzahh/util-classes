package lib.games.ticTacToe.simpleTicTacToe;

final class PositionSelector {
    private PositionSelector() {}
    public static void selectPosition(char[][] board, byte positionChoice, String player) {
        char playerSymbol = ' ';
        switch (player) {
            case "HUMAN", "PLAYER 1" -> {
                playerSymbol = 'X';
                switch (SimpleTicTacToeGame.playTypeChoice) {
                    case 1 -> // PLAY WITH A FRIEND
                            SimpleTicTacToeGame.playerOnePositionsOnTheBoard.add((int) positionChoice);
                    case 2 -> // PLAY WITH A COMPUTER
                            SimpleTicTacToeGame.humanPositionsOnTheBoard.add((int) positionChoice);
                }
            }
            case "COMPUTER", "PLAYER 2" -> {
                playerSymbol = 'O';
                switch (SimpleTicTacToeGame.playTypeChoice) {
                    case 1 -> // PLAY WITH A FRIEND
                            SimpleTicTacToeGame.playerTwoPositionsOnTheBoard.add((int) positionChoice);
                    case 2 -> // PLAY WITH A COMPUTER
                            SimpleTicTacToeGame.computerPositionsOnTheBoard.add((int) positionChoice);
                }
            }
        }
        switch(positionChoice) {
            case 1 -> {
                switch (SimpleTicTacToeGame.whichBoard) {
                    case 1, 2 -> {
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[0][3] = playerSymbol;
                                board[0][9] = playerSymbol;
                                board[1][4] = playerSymbol;
                                board[1][8] = playerSymbol;
                                board[2][5] = playerSymbol;
                                board[2][7] = playerSymbol;
                                board[3][6] = playerSymbol;
                                board[4][7] = playerSymbol;
                                board[4][5] = playerSymbol;
                                board[5][8] = playerSymbol;
                                board[5][4] = playerSymbol;
                                board[6][9] = playerSymbol;
                                board[6][3] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[0][4] = playerSymbol;
                                board[0][6] = playerSymbol;
                                board[0][8] = playerSymbol;
                                board[1][2] = playerSymbol;
                                board[1][10] = playerSymbol;
                                board[2][1] = playerSymbol;
                                board[2][11] = playerSymbol;
                                board[3][0] = playerSymbol;
                                board[3][12] = playerSymbol;
                                board[4][1] = playerSymbol;
                                board[4][11] = playerSymbol;
                                board[5][2] = playerSymbol;
                                board[5][10] = playerSymbol;
                                board[6][4] = playerSymbol;
                                board[6][6] = playerSymbol;
                                board[6][8] = playerSymbol;
                            }
                        }
                    }
                }
            }
            case 2 -> {
                switch (SimpleTicTacToeGame.whichBoard) {
                    case 1, 2 -> {
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[0][17] = playerSymbol;
                                board[0][23] = playerSymbol;
                                board[1][18] = playerSymbol;
                                board[1][22] = playerSymbol;
                                board[2][19] = playerSymbol;
                                board[2][21] = playerSymbol;
                                board[3][20] = playerSymbol;
                                board[4][21] = playerSymbol;
                                board[4][19] = playerSymbol;
                                board[5][22] = playerSymbol;
                                board[5][18] = playerSymbol;
                                board[6][23] = playerSymbol;
                                board[6][17] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[0][18] = playerSymbol;
                                board[0][20] = playerSymbol;
                                board[0][22] = playerSymbol;
                                board[1][16] = playerSymbol;
                                board[1][24] = playerSymbol;
                                board[2][15] = playerSymbol;
                                board[2][25] = playerSymbol;
                                board[3][14] = playerSymbol;
                                board[3][26] = playerSymbol;
                                board[4][15] = playerSymbol;
                                board[4][25] = playerSymbol;
                                board[5][16] = playerSymbol;
                                board[5][24] = playerSymbol;
                                board[6][18] = playerSymbol;
                                board[6][20] = playerSymbol;
                                board[6][22] = playerSymbol;
                            }
                        }
                    }
                }
            }
            case 3 -> {
                switch (SimpleTicTacToeGame.whichBoard) {
                    case 1, 2 -> {
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[0][31] = playerSymbol;
                                board[0][37] = playerSymbol;
                                board[1][32] = playerSymbol;
                                board[1][36] = playerSymbol;
                                board[2][33] = playerSymbol;
                                board[2][35] = playerSymbol;
                                board[3][34] = playerSymbol;
                                board[4][35] = playerSymbol;
                                board[4][33] = playerSymbol;
                                board[5][36] = playerSymbol;
                                board[5][32] = playerSymbol;
                                board[6][37] = playerSymbol;
                                board[6][31] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[0][32] = playerSymbol;
                                board[0][34] = playerSymbol;
                                board[0][36] = playerSymbol;
                                board[1][30] = playerSymbol;
                                board[1][38] = playerSymbol;
                                board[2][29] = playerSymbol;
                                board[2][39] = playerSymbol;
                                board[3][28] = playerSymbol;
                                board[3][40] = playerSymbol;
                                board[4][29] = playerSymbol;
                                board[4][39] = playerSymbol;
                                board[5][30] = playerSymbol;
                                board[5][38] = playerSymbol;
                                board[6][32] = playerSymbol;
                                board[6][34] = playerSymbol;
                                board[6][36] = playerSymbol;
                            }
                        }
                    }
                }
            }
            case 4 -> {
                switch (SimpleTicTacToeGame.whichBoard) {
                    case 1 -> {
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[8][3] = playerSymbol;
                                board[8][9] = playerSymbol;
                                board[9][4] = playerSymbol;
                                board[9][8] = playerSymbol;
                                board[10][5] = playerSymbol;
                                board[10][7] = playerSymbol;
                                board[11][6] = playerSymbol;
                                board[12][5] = playerSymbol;
                                board[12][7] = playerSymbol;
                                board[13][4] = playerSymbol;
                                board[13][8] = playerSymbol;
                                board[14][3] = playerSymbol;
                                board[14][9] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[8][4] = playerSymbol;
                                board[8][6] = playerSymbol;
                                board[8][8] = playerSymbol;
                                board[9][2] = playerSymbol;
                                board[9][10] = playerSymbol;
                                board[10][1] = playerSymbol;
                                board[10][11] = playerSymbol;
                                board[11][0] = playerSymbol;
                                board[11][12] = playerSymbol;
                                board[12][1] = playerSymbol;
                                board[12][11] = playerSymbol;
                                board[13][2] = playerSymbol;
                                board[13][10] = playerSymbol;
                                board[14][4] = playerSymbol;
                                board[14][6] = playerSymbol;
                                board[14][8] = playerSymbol;
                            }
                        }
                    }
                    case 2 -> {
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[0][45] = playerSymbol;
                                board[0][51] = playerSymbol;
                                board[1][46] = playerSymbol;
                                board[1][50] = playerSymbol;
                                board[2][47] = playerSymbol;
                                board[2][49] = playerSymbol;
                                board[3][48] = playerSymbol;
                                board[4][47] = playerSymbol;
                                board[4][49] = playerSymbol;
                                board[5][46] = playerSymbol;
                                board[5][50] = playerSymbol;
                                board[6][45] = playerSymbol;
                                board[6][51] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[0][46] = playerSymbol;
                                board[0][48] = playerSymbol;
                                board[0][50] = playerSymbol;
                                board[1][44] = playerSymbol;
                                board[1][52] = playerSymbol;
                                board[2][43] = playerSymbol;
                                board[2][53] = playerSymbol;
                                board[3][42] = playerSymbol;
                                board[3][54] = playerSymbol;
                                board[4][43] = playerSymbol;
                                board[4][53] = playerSymbol;
                                board[5][44] = playerSymbol;
                                board[5][52] = playerSymbol;
                                board[6][46] = playerSymbol;
                                board[6][48] = playerSymbol;
                                board[6][50] = playerSymbol;
                            }
                        }
                    }
                }
            }
            case 5 -> {
                switch (SimpleTicTacToeGame.whichBoard) {
                    case 1 -> {
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[8][24] = playerSymbol;
                                board[9][23] = playerSymbol;
                                board[10][22] = playerSymbol;
                                board[11][21] = playerSymbol;
                                board[12][20] = playerSymbol;
                                board[13][19] = playerSymbol;
                                board[14][18] = playerSymbol;
                                board[8][18] = playerSymbol;
                                board[9][19] = playerSymbol;
                                board[10][20] = playerSymbol;
                                board[12][22] = playerSymbol;
                                board[13][23] = playerSymbol;
                                board[14][24] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[8][18] = playerSymbol;
                                board[8][20] = playerSymbol;
                                board[8][22] = playerSymbol;
                                board[9][16] = playerSymbol;
                                board[9][24] = playerSymbol;
                                board[10][15] = playerSymbol;
                                board[10][25] = playerSymbol;
                                board[11][14] = playerSymbol;
                                board[11][26] = playerSymbol;
                                board[12][15] = playerSymbol;
                                board[12][25] = playerSymbol;
                                board[13][16] = playerSymbol;
                                board[13][24] = playerSymbol;
                                board[14][18] = playerSymbol;
                                board[14][20] = playerSymbol;
                                board[14][22] = playerSymbol;
                            }
                        }
                    }
                    case 2 -> {
                        // FOUR BY FOUR HERE, number 5
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[8][3] = playerSymbol;
                                board[8][9] = playerSymbol;
                                board[9][4] = playerSymbol;
                                board[9][8] = playerSymbol;
                                board[10][5] = playerSymbol;
                                board[10][7] = playerSymbol;
                                board[11][6] = playerSymbol;
                                board[12][7] = playerSymbol;
                                board[12][5] = playerSymbol;
                                board[13][8] = playerSymbol;
                                board[13][4] = playerSymbol;
                                board[14][9] = playerSymbol;
                                board[14][3] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[8][4] = playerSymbol;
                                board[8][6] = playerSymbol;
                                board[8][8] = playerSymbol;
                                board[9][2] = playerSymbol;
                                board[9][10] = playerSymbol;
                                board[10][1] = playerSymbol;
                                board[10][11] = playerSymbol;
                                board[11][0] = playerSymbol;
                                board[11][12] = playerSymbol;
                                board[12][1] = playerSymbol;
                                board[12][11] = playerSymbol;
                                board[13][2] = playerSymbol;
                                board[13][10] = playerSymbol;
                                board[14][4] = playerSymbol;
                                board[14][6] = playerSymbol;
                                board[14][8] = playerSymbol;
                            }
                        }
                    }
                }
            }
            case 6 -> {
                switch (SimpleTicTacToeGame.whichBoard) {
                    case 1 -> {
                        // THREE BY THREE BOARD
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[8][31] = playerSymbol;
                                board[8][37] = playerSymbol;
                                board[9][32] = playerSymbol;
                                board[9][36] = playerSymbol;
                                board[10][33] = playerSymbol;
                                board[10][35] = playerSymbol;
                                board[11][34] = playerSymbol;
                                board[12][35] = playerSymbol;
                                board[12][33] = playerSymbol;
                                board[13][32] = playerSymbol;
                                board[13][36] = playerSymbol;
                                board[14][31] = playerSymbol;
                                board[14][37] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[8][32] = playerSymbol;
                                board[8][34] = playerSymbol;
                                board[8][36] = playerSymbol;
                                board[9][30] = playerSymbol;
                                board[9][38] = playerSymbol;
                                board[10][29] = playerSymbol;
                                board[10][39] = playerSymbol;
                                board[11][28] = playerSymbol;
                                board[11][40] = playerSymbol;
                                board[12][29] = playerSymbol;
                                board[12][39] = playerSymbol;
                                board[13][30] = playerSymbol;
                                board[13][38] = playerSymbol;
                                board[14][32] = playerSymbol;
                                board[14][34] = playerSymbol;
                                board[14][36] = playerSymbol;
                            }
                        }
                    }
                    case 2 -> {
                        // FOUR BY FOUR BOARD
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[8][17] = playerSymbol;
                                board[8][23] = playerSymbol;
                                board[9][18] = playerSymbol;
                                board[9][22] = playerSymbol;
                                board[10][19] = playerSymbol;
                                board[10][21] = playerSymbol;
                                board[11][20] = playerSymbol;
                                board[12][21] = playerSymbol;
                                board[12][19] = playerSymbol;
                                board[13][22] = playerSymbol;
                                board[13][18] = playerSymbol;
                                board[14][23] = playerSymbol;
                                board[14][17] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[8][18] = playerSymbol;
                                board[8][20] = playerSymbol;
                                board[8][22] = playerSymbol;
                                board[9][16] = playerSymbol;
                                board[9][24] = playerSymbol;
                                board[10][15] = playerSymbol;
                                board[10][25] = playerSymbol;
                                board[11][14] = playerSymbol;
                                board[11][26] = playerSymbol;
                                board[12][15] = playerSymbol;
                                board[12][25] = playerSymbol;
                                board[13][16] = playerSymbol;
                                board[13][24] = playerSymbol;
                                board[14][18] = playerSymbol;
                                board[14][20] = playerSymbol;
                                board[14][22] = playerSymbol;
                            }
                        }
                    }
                }
            }
            case 7 -> {
                switch (SimpleTicTacToeGame.whichBoard) {
                    case 1 -> {
                        // THREE BY THREE BOARD 
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[16][9] = playerSymbol;
                                board[17][8] = playerSymbol;
                                board[18][7] = playerSymbol;
                                board[19][6] = playerSymbol;
                                board[20][5] = playerSymbol;
                                board[21][4] = playerSymbol;
                                board[22][3] = playerSymbol;
                                board[16][3] = playerSymbol;
                                board[17][4] = playerSymbol;
                                board[18][5] = playerSymbol;
                                board[20][7] = playerSymbol;
                                board[21][8] = playerSymbol;
                                board[22][9] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[16][4] = playerSymbol;
                                board[16][6] = playerSymbol;
                                board[16][8] = playerSymbol;
                                board[17][2] = playerSymbol;
                                board[17][10] = playerSymbol;
                                board[18][1] = playerSymbol;
                                board[18][11] = playerSymbol;
                                board[19][0] = playerSymbol;
                                board[19][12] = playerSymbol;
                                board[20][1] = playerSymbol;
                                board[20][11] = playerSymbol;
                                board[21][2] = playerSymbol;
                                board[21][10] = playerSymbol;
                                board[22][4] = playerSymbol;
                                board[22][6] = playerSymbol;
                                board[22][8] = playerSymbol;
                            }
                        }
                    }
                    case 2 -> {
                        // FOUR BY FOUR HERE
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[8][31] = playerSymbol;
                                board[8][37] = playerSymbol;
                                board[9][32] = playerSymbol;
                                board[9][36] = playerSymbol;
                                board[10][33] = playerSymbol;
                                board[10][35] = playerSymbol;
                                board[11][34] = playerSymbol;
                                board[12][35] = playerSymbol;
                                board[12][33] = playerSymbol;
                                board[13][36] = playerSymbol;
                                board[13][32] = playerSymbol;
                                board[14][37] = playerSymbol;
                                board[14][31] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[8][32] = playerSymbol;
                                board[8][34] = playerSymbol;
                                board[8][36] = playerSymbol;
                                board[9][30] = playerSymbol;
                                board[9][38] = playerSymbol;
                                board[10][29] = playerSymbol;
                                board[10][39] = playerSymbol;
                                board[11][28] = playerSymbol;
                                board[11][40] = playerSymbol;
                                board[12][29] = playerSymbol;
                                board[12][39] = playerSymbol;
                                board[13][30] = playerSymbol;
                                board[13][38] = playerSymbol;
                                board[14][32] = playerSymbol;
                                board[14][34] = playerSymbol;
                                board[14][36] = playerSymbol;
                            }
                        }
                    }
                }
            }
            case 8 -> {
                switch (SimpleTicTacToeGame.whichBoard) {
                    case 1 -> {
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[16][24] = playerSymbol;
                                board[17][23] = playerSymbol;
                                board[18][22] = playerSymbol;
                                board[19][21] = playerSymbol;
                                board[20][20] = playerSymbol;
                                board[21][19] = playerSymbol;
                                board[22][18] = playerSymbol;
                                board[16][18] = playerSymbol;
                                board[17][19] = playerSymbol;
                                board[18][20] = playerSymbol;
                                board[20][22] = playerSymbol;
                                board[21][23] = playerSymbol;
                                board[22][24] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[16][18] = playerSymbol;
                                board[16][20] = playerSymbol;
                                board[16][22] = playerSymbol;
                                board[17][16] = playerSymbol;
                                board[17][24] = playerSymbol;
                                board[18][15] = playerSymbol;
                                board[18][25] = playerSymbol;
                                board[19][14] = playerSymbol;
                                board[19][26] = playerSymbol;
                                board[20][15] = playerSymbol;
                                board[20][25] = playerSymbol;
                                board[21][16] = playerSymbol;
                                board[21][24] = playerSymbol;
                                board[22][18] = playerSymbol;
                                board[22][20] = playerSymbol;
                                board[22][22] = playerSymbol;
                            }
                        }
                    }
                    case 2 -> {
                        // FOUR BY FOUR HERE
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[8][45] = playerSymbol;
                                board[8][51] = playerSymbol;
                                board[9][46] = playerSymbol;
                                board[9][50] = playerSymbol;
                                board[10][47] = playerSymbol;
                                board[10][49] = playerSymbol;
                                board[11][48] = playerSymbol;
                                board[12][47] = playerSymbol;
                                board[12][49] = playerSymbol;
                                board[13][46] = playerSymbol;
                                board[13][50] = playerSymbol;
                                board[14][45] = playerSymbol;
                                board[14][51] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[8][46] = playerSymbol;
                                board[8][48] = playerSymbol;
                                board[8][50] = playerSymbol;
                                board[9][44] = playerSymbol;
                                board[9][52] = playerSymbol;
                                board[10][43] = playerSymbol;
                                board[10][53] = playerSymbol;
                                board[11][42] = playerSymbol;
                                board[11][54] = playerSymbol;
                                board[12][43] = playerSymbol;
                                board[12][53] = playerSymbol;
                                board[13][44] = playerSymbol;
                                board[13][52] = playerSymbol;
                                board[14][46] = playerSymbol;
                                board[14][48] = playerSymbol;
                                board[14][50] = playerSymbol;
                            }
                        }
                    }
                }
            }
            case 9 -> {
                switch (SimpleTicTacToeGame.whichBoard) {
                    case 1 -> {
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[16][37] = playerSymbol;
                                board[17][36] = playerSymbol;
                                board[18][35] = playerSymbol;
                                board[19][34] = playerSymbol;
                                board[20][33] = playerSymbol;
                                board[21][32] = playerSymbol;
                                board[22][31] = playerSymbol;
                                board[16][31] = playerSymbol;
                                board[17][32] = playerSymbol;
                                board[18][33] = playerSymbol;
                                board[20][35] = playerSymbol;
                                board[21][36] = playerSymbol;
                                board[22][37] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[16][32] = playerSymbol;
                                board[16][34] = playerSymbol;
                                board[16][36] = playerSymbol;
                                board[17][30] = playerSymbol;
                                board[17][38] = playerSymbol;
                                board[18][29] = playerSymbol;
                                board[18][39] = playerSymbol;
                                board[19][28] = playerSymbol;
                                board[19][40] = playerSymbol;
                                board[20][29] = playerSymbol;
                                board[20][39] = playerSymbol;
                                board[21][30] = playerSymbol;
                                board[21][38] = playerSymbol;
                                board[22][32] = playerSymbol;
                                board[22][34] = playerSymbol;
                                board[22][36] = playerSymbol;
                            }
                        }
                    }
                    case 2 -> {
                        // FOUR BY FOUR HERE
                        switch (player) {
                            case "HUMAN", "PLAYER 1" -> {
                                board[16][3] = playerSymbol;
                                board[16][9] = playerSymbol;
                                board[17][4] = playerSymbol;
                                board[17][8] = playerSymbol;
                                board[18][5] = playerSymbol;
                                board[18][7] = playerSymbol;
                                board[19][6] = playerSymbol;
                                board[20][7] = playerSymbol;
                                board[20][5] = playerSymbol;
                                board[21][8] = playerSymbol;
                                board[21][4] = playerSymbol;
                                board[22][9] = playerSymbol;
                                board[22][3] = playerSymbol;
                            }
                            case "COMPUTER", "PLAYER 2" -> {
                                board[16][4] = playerSymbol;
                                board[16][6] = playerSymbol;
                                board[16][8] = playerSymbol;
                                board[17][2] = playerSymbol;
                                board[17][10] = playerSymbol;
                                board[18][1] = playerSymbol;
                                board[18][11] = playerSymbol;
                                board[19][0] = playerSymbol;
                                board[19][12] = playerSymbol;
                                board[20][1] = playerSymbol;
                                board[20][11] = playerSymbol;
                                board[21][2] = playerSymbol;
                                board[21][10] = playerSymbol;
                                board[22][4] = playerSymbol;
                                board[22][6] = playerSymbol;
                                board[22][8] = playerSymbol;
                            }
                        }
                    }
                }
            }
            case 10 -> {
                if (SimpleTicTacToeGame.whichBoard == 2) {
                    switch (player) {
                        case "HUMAN", "PLAYER 1" -> {
                            board[16][17] = playerSymbol;
                            board[16][23] = playerSymbol;
                            board[17][18] = playerSymbol;
                            board[17][22] = playerSymbol;
                            board[18][19] = playerSymbol;
                            board[18][21] = playerSymbol;
                            board[19][20] = playerSymbol;
                            board[20][21] = playerSymbol;
                            board[20][19] = playerSymbol;
                            board[21][22] = playerSymbol;
                            board[21][18] = playerSymbol;
                            board[22][23] = playerSymbol;
                            board[22][17] = playerSymbol;
                        }
                        case "COMPUTER", "PLAYER 2" -> {
                            board[16][18] = playerSymbol;
                            board[16][20] = playerSymbol;
                            board[16][22] = playerSymbol;
                            board[17][16] = playerSymbol;
                            board[17][24] = playerSymbol;
                            board[18][15] = playerSymbol;
                            board[18][25] = playerSymbol;
                            board[19][14] = playerSymbol;
                            board[19][26] = playerSymbol;
                            board[20][15] = playerSymbol;
                            board[20][25] = playerSymbol;
                            board[21][16] = playerSymbol;
                            board[21][24] = playerSymbol;
                            board[22][18] = playerSymbol;
                            board[22][20] = playerSymbol;
                            board[22][22] = playerSymbol;
                        }
                    }
                }
            }
            case 11 -> {
                if (SimpleTicTacToeGame.whichBoard == 2) {
                    switch (player) {
                        case "HUMAN", "PLAYER 1" -> {
                            board[16][31] = playerSymbol;
                            board[16][37] = playerSymbol;
                            board[17][32] = playerSymbol;
                            board[17][36] = playerSymbol;
                            board[18][33] = playerSymbol;
                            board[18][35] = playerSymbol;
                            board[19][34] = playerSymbol;
                            board[20][35] = playerSymbol;
                            board[20][33] = playerSymbol;
                            board[21][36] = playerSymbol;
                            board[21][32] = playerSymbol;
                            board[22][37] = playerSymbol;
                            board[22][31] = playerSymbol;
                        }
                        case "COMPUTER", "PLAYER 2" -> {
                            board[16][32] = playerSymbol;
                            board[16][34] = playerSymbol;
                            board[16][36] = playerSymbol;
                            board[17][30] = playerSymbol;
                            board[17][38] = playerSymbol;
                            board[18][29] = playerSymbol;
                            board[18][39] = playerSymbol;
                            board[19][28] = playerSymbol;
                            board[19][40] = playerSymbol;
                            board[20][29] = playerSymbol;
                            board[20][39] = playerSymbol;
                            board[21][30] = playerSymbol;
                            board[21][38] = playerSymbol;
                            board[22][32] = playerSymbol;
                            board[22][34] = playerSymbol;
                            board[22][36] = playerSymbol;
                        }
                    }
                }
            }
            case 12 -> {
                if (SimpleTicTacToeGame.whichBoard == 2) {
                    switch (player) {
                        case "HUMAN", "PLAYER 1" -> {
                            board[16][45] = playerSymbol;
                            board[16][51] = playerSymbol;
                            board[17][46] = playerSymbol;
                            board[17][50] = playerSymbol;
                            board[18][47] = playerSymbol;
                            board[18][49] = playerSymbol;
                            board[19][48] = playerSymbol;
                            board[20][47] = playerSymbol;
                            board[20][49] = playerSymbol;
                            board[21][46] = playerSymbol;
                            board[21][50] = playerSymbol;
                            board[22][45] = playerSymbol;
                            board[22][51] = playerSymbol;
                        }
                        case "COMPUTER", "PLAYER 2" -> {
                            board[16][46] = playerSymbol;
                            board[16][48] = playerSymbol;
                            board[16][50] = playerSymbol;
                            board[17][44] = playerSymbol;
                            board[17][52] = playerSymbol;
                            board[18][43] = playerSymbol;
                            board[18][53] = playerSymbol;
                            board[19][42] = playerSymbol;
                            board[19][54] = playerSymbol;
                            board[20][43] = playerSymbol;
                            board[20][53] = playerSymbol;
                            board[21][44] = playerSymbol;
                            board[21][52] = playerSymbol;
                            board[22][46] = playerSymbol;
                            board[22][48] = playerSymbol;
                            board[22][50] = playerSymbol;
                        }
                    }
                }
            }
            case 13 -> {
                if (SimpleTicTacToeGame.whichBoard == 2) {
                    switch (player) {
                        case "HUMAN", "PLAYER 1" -> {
                            board[24][3] = playerSymbol;
                            board[24][9] = playerSymbol;
                            board[25][4] = playerSymbol;
                            board[25][8] = playerSymbol;
                            board[26][5] = playerSymbol;
                            board[26][7] = playerSymbol;
                            board[27][6] = playerSymbol;
                            board[28][7] = playerSymbol;
                            board[28][5] = playerSymbol;
                            board[29][8] = playerSymbol;
                            board[29][4] = playerSymbol;
                            board[30][9] = playerSymbol;
                            board[30][3] = playerSymbol;
                        }
                        case "COMPUTER", "PLAYER 2" -> {
                            board[24][4] = playerSymbol;
                            board[24][6] = playerSymbol;
                            board[24][8] = playerSymbol;
                            board[25][2] = playerSymbol;
                            board[25][10] = playerSymbol;
                            board[26][1] = playerSymbol;
                            board[26][11] = playerSymbol;
                            board[27][0] = playerSymbol;
                            board[27][12] = playerSymbol;
                            board[28][1] = playerSymbol;
                            board[28][11] = playerSymbol;
                            board[29][2] = playerSymbol;
                            board[29][10] = playerSymbol;
                            board[30][4] = playerSymbol;
                            board[30][6] = playerSymbol;
                            board[30][8] = playerSymbol;
                        }
                    }
                }
            }
            case 14 -> {
                if (SimpleTicTacToeGame.whichBoard == 2) {
                    switch (player) {
                        case "HUMAN", "PLAYER 1" -> {
                            board[24][17] = playerSymbol;
                            board[24][23] = playerSymbol;
                            board[25][18] = playerSymbol;
                            board[25][22] = playerSymbol;
                            board[26][19] = playerSymbol;
                            board[26][21] = playerSymbol;
                            board[27][20] = playerSymbol;
                            board[28][21] = playerSymbol;
                            board[28][19] = playerSymbol;
                            board[29][22] = playerSymbol;
                            board[29][18] = playerSymbol;
                            board[30][23] = playerSymbol;
                            board[30][17] = playerSymbol;
                        }
                        case "COMPUTER", "PLAYER 2" -> {
                            board[24][18] = playerSymbol;
                            board[24][20] = playerSymbol;
                            board[24][22] = playerSymbol;
                            board[25][16] = playerSymbol;
                            board[25][24] = playerSymbol;
                            board[26][15] = playerSymbol;
                            board[26][25] = playerSymbol;
                            board[27][14] = playerSymbol;
                            board[27][26] = playerSymbol;
                            board[28][15] = playerSymbol;
                            board[28][25] = playerSymbol;
                            board[29][16] = playerSymbol;
                            board[29][24] = playerSymbol;
                            board[30][18] = playerSymbol;
                            board[30][20] = playerSymbol;
                            board[30][22] = playerSymbol;
                        }
                    }
                }
            }
            case 15 -> {
                if (SimpleTicTacToeGame.whichBoard == 2) {
                    switch (player) {
                        case "HUMAN", "PLAYER 1" -> {
                            board[24][31] = playerSymbol;
                            board[24][37] = playerSymbol;
                            board[25][32] = playerSymbol;
                            board[25][36] = playerSymbol;
                            board[26][33] = playerSymbol;
                            board[26][35] = playerSymbol;
                            board[27][34] = playerSymbol;
                            board[28][35] = playerSymbol;
                            board[28][33] = playerSymbol;
                            board[29][36] = playerSymbol;
                            board[29][32] = playerSymbol;
                            board[30][37] = playerSymbol;
                            board[30][31] = playerSymbol;
                        }
                        case "COMPUTER", "PLAYER 2" -> {
                            board[24][32] = playerSymbol;
                            board[24][34] = playerSymbol;
                            board[24][36] = playerSymbol;
                            board[25][30] = playerSymbol;
                            board[25][38] = playerSymbol;
                            board[26][29] = playerSymbol;
                            board[26][39] = playerSymbol;
                            board[27][28] = playerSymbol;
                            board[27][40] = playerSymbol;
                            board[28][29] = playerSymbol;
                            board[28][39] = playerSymbol;
                            board[29][30] = playerSymbol;
                            board[29][38] = playerSymbol;
                            board[30][32] = playerSymbol;
                            board[30][34] = playerSymbol;
                            board[30][36] = playerSymbol;
                        }
                    }
                }
            }
            case 16 -> {
                if (SimpleTicTacToeGame.whichBoard == 2) {
                    switch (player) {
                        case "HUMAN", "PLAYER 1" -> {
                            board[24][45] = playerSymbol;
                            board[24][51] = playerSymbol;
                            board[25][46] = playerSymbol;
                            board[25][50] = playerSymbol;
                            board[26][47] = playerSymbol;
                            board[26][49] = playerSymbol;
                            board[27][48] = playerSymbol;
                            board[28][47] = playerSymbol;
                            board[28][49] = playerSymbol;
                            board[29][46] = playerSymbol;
                            board[29][50] = playerSymbol;
                            board[30][45] = playerSymbol;
                            board[30][51] = playerSymbol;
                        }
                        case "COMPUTER", "PLAYER 2" -> {
                            board[24][46] = playerSymbol;
                            board[24][48] = playerSymbol;
                            board[24][50] = playerSymbol;
                            board[25][44] = playerSymbol;
                            board[25][52] = playerSymbol;
                            board[26][43] = playerSymbol;
                            board[26][53] = playerSymbol;
                            board[27][42] = playerSymbol;
                            board[27][54] = playerSymbol;
                            board[28][43] = playerSymbol;
                            board[28][53] = playerSymbol;
                            board[29][44] = playerSymbol;
                            board[29][52] = playerSymbol;
                            board[30][46] = playerSymbol;
                            board[30][48] = playerSymbol;
                            board[30][50] = playerSymbol;
                        }
                    }
                }
            }
        }
    }
}
