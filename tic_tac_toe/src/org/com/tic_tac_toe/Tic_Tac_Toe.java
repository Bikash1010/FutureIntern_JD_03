package org.com.tic_tac_toe;


import java.util.Scanner;



public class Tic_Tac_Toe {

	 private static char[][] board = new char[3][3];
	    private static char currentPlayer = 'X';
	    private static boolean gameEnded = false;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Main game loop
	        do {
	            // Initialize the board for each new game
	            initializeBoard();
	            gameEnded = false;

	            // Print the board and start the game
	            while (!gameEnded) {
	                printBoard();
	                playerMove();
	                checkWin();
	                checkDraw();
	                switchPlayer();
	            }

	            // Ask the players if they want to play again
	            System.out.println("Game Over! Would you like to play again? (y/n): ");
	        } while (scanner.next().equalsIgnoreCase("y"));

	        scanner.close();
	        System.out.println("Thank you for playing!");
	    }

	    // Initialize the board to empty cells
	    private static void initializeBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = ' ';
	            }
	        }
	    }

	    // Print the current state of the board
	    private static void printBoard() {
	        System.out.println("  0   1   2");
	        for (int i = 0; i < 3; i++) {
	            System.out.print(i);
	            for (int j = 0; j < 3; j++) {
	                System.out.print(" " + board[i][j]);
	                if (j < 2) System.out.print(" |");
	            }
	            System.out.println();
	            if (i < 2) System.out.println(" ---|---|---");
	        }
	        System.out.println();
	    }

	    // Handle the current player's move
	    private static void playerMove() {
	        Scanner scanner = new Scanner(System.in);
	        int row, col;

	        while (true) {
	            System.out.println("Player " + currentPlayer + ", enter your move (row space column): ");
	            row = scanner.nextInt();
	            col = scanner.nextInt();

	            // Check if the move is valid
	            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
	                board[row][col] = currentPlayer;
	                break;
	            } else {
	                System.out.println("Invalid move. Try again.");
	            }
	        }
	    }

	    // Check if the current player has won
	    private static void checkWin() {
	        // Check rows, columns, and diagonals
	        for (int i = 0; i < 3; i++) {
	            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
	                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
	                System.out.println("Player " + currentPlayer + " wins!");
	                gameEnded = true;
	                return;
	            }
	        }

	        // Check diagonals
	        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
	            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
	            System.out.println("Player " + currentPlayer + " wins!");
	            gameEnded = true;
	            return;
	        }
	    }

	    // Check if the game is a draw
	    private static void checkDraw() {
	        boolean fullBoard = true;
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == ' ') {
	                    fullBoard = false;
	                    break;
	                }
	            }
	        }
	        if (fullBoard) {
	            System.out.println("It's a draw!");
	            gameEnded = true;
	        }
	    }

	    // Switch the current player
	    private static void switchPlayer() {
	        if (currentPlayer == 'X') {
	            currentPlayer = 'O';
	        } else {
	            currentPlayer = 'X';
	        }
	    }
}
