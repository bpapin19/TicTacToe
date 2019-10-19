package tictactoedraft;

public class Game_Board {
	static char[][] board;
    char winningChar;
	static boolean cats = false;
	
	//constructor to populate board with empty space
	public Game_Board() {
			board = new char[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = ' ';
				}
			}
	}
	
	
	 // =======METHODS=======
	 
	
	//check to see if space is filled yet
public boolean checkOccupied(int row1, int col1) {
	if (board[row1][col1] != ' ') {
		System.out.println("Illegal move. Go again.");
		return true;
		} else {
			return false;
		}
	}

	//add X or O to board
public void populateBoard(int row1, int col1, char p) {
				board[row1][col1] = p;
			}
		
//check to see if there is a winner
public boolean checkWinner(char p) {
	
	boolean winner = false;
	
	//3 in a row
	for (int n = 0; n < 3; n++) {
		if ((board[n][0] == p) && (board[n][1] == p) && (board[n][2] == p)){
			winningChar = p;
			winner = true;
		} 
	}
			
	//3 in a column
	for (int n = 0; n < 3; n++) {	
		if ((board[0][n] == p) && (board[1][n] == p) && (board[2][n] == p)){
			winningChar = p;
			winner = true;
		} 
	}
			
	//diagonal left to right down
	if ((board[0][0] == p) && (board[1][1] == p) && (board[2][2] == p)){
		winningChar = p;
			winner = true;
	} 
	
	//diagonal left to right up
	if ((board[2][0] == p) && (board[1][1] == p) && (board[0][2] == p)) {
		winningChar = p;
		winner = true;
	} 
	return winner;
}

//check for a cats game
 boolean checkCats() {
	int count = 0;
	for (int i=0; i < 3; i++) {
		for (int j=0; j < 3; j++) {
			if (board[i][j] != ' ') {
				count ++;
			}
		}
	}
	//if all spaces are filled and there is no winner, set cats to true
	if ((count == 9) && (checkWinner('X') == false) && (checkWinner('O') == false)) {
		cats = true;
	}
	return cats;
}

//print the board to the screen
void printBoard() {
	for (int i=0; i < 3; i++) {
		for (int j=0; j < 3; j++) {
			System.out.print(board[i][j]);
			if (j!=2) {
				System.out.print("|");
			}
		}
		System.out.println();
		if (i!=2) {
			System.out.println("-----");
		}
	}
		
}
}
