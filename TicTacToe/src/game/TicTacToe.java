package game;

public class TicTacToe {
	private String[][] board;		
	public TicTacToe() {
		this.board = new String[3][3];
		fillEmptyBoard();
	}
	
	
	public void makeMove(int i, int j, int playerMove) {
		try {
			switch(playerMove) {
				case 0:
					board[i][j] = "X";
					break;
				case 1:
					board[i][j] = "O";
					break;
				default:
					System.out.println("Illegal movement attempt.");
					break;
			}
			
		}	
		catch(ArrayIndexOutOfBoundsException aiobe) {
			System.out.println();
			System.out.println("Illegal index");
		}
	}
	
	
	public boolean checkWin() {
		int upLeftToRight = 0;
		int mainDiagonal = 0;
		int midLeftToRight = 0;
		int downLeftToRight = 0;
		for(int i = 0; i < this.board.length-1; i ++) {
			if(board[0][i].equals(board[0][i+1]) && !board[0][i].trim().equals("")) 
				upLeftToRight++;						
			if(board[i][i].equals(board[i+1][i+1]) && !board[i][i].trim().equals(""))
				mainDiagonal++;				
			if(board[1][i].equals(board[i][i+1]) && !board[1][i].trim().equals(""))
				midLeftToRight++;
			if(board[2][i].equals(board[2][i+1]) && !board[2][i].trim().equals(""))
				downLeftToRight++;
		}
		
		if(upLeftToRight == 2 || mainDiagonal == 2 || midLeftToRight == 2 || downLeftToRight == 2) {
			System.out.println("it was here");
			return true;
		}
		if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[2][0].trim().equals(""))
			return true;
		
		return false;
	}
	
	private void fillEmptyBoard() {
		for(int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board.length; j++) {
				this.board[i][j] = "";
			}
		}
	}
	
	public String[][] getBoard() {
		return this.board;
	}
	

}
