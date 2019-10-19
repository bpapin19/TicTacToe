package tictactoedraft;

import java.util.Scanner;

public class tttMain {
	
	static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		Game_Board board = new Game_Board();
		int row, col;

		System.out.println("Welcome to Tic Tac Toe.");
		System.out.println("=======================");
		
		
		//end the game when there is a winner or a cats game
		while (!(board.checkWinner('X') || board.checkWinner('O') || board.checkCats())) {
			
			boolean loop = true;
			boolean loop2 = true;

			//X's turn
			while (loop) {
				System.out.println("Player 1 turn 'X'");
				board.printBoard();
				System.out.println("Which row would you like");
				row = in.nextInt();
				System.out.println("Which column would you like");
				col = in.nextInt();
					if (board.checkOccupied(row, col) == false) {
						loop = false;
						board.populateBoard(row, col, 'X');
					}
			}
			
			//O's turn
			//check if there is a cats game after X's turn to set loop to false
			loop2 = !board.checkCats();
			while (loop2) {
				if (!(board.checkWinner('X') || board.checkWinner('O')) || board.checkCats()) {					
					System.out.println("Player 2 turn 'O'");
					board.printBoard();
					System.out.println("Which row would you like");
					row = in.nextInt();	
					System.out.println("Which column would you like");				
					col = in.nextInt();
					if (board.checkOccupied(row, col) == false) {
						loop2 = false;
						board.populateBoard(row, col, 'O');
					}
				} else {
					loop2 = false;
				}

			}
		}
		board.printBoard();
		if (board.checkCats() == true) {
			System.out.println("Cat's Game!");
		} else {
		System.out.println(board.winningChar + " player wins!");
		}
	}
}
		
		
	
