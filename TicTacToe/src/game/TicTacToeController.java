package game;

public class TicTacToeController {
	private TicTacToe ttt;
	private Player p1;
	private Player p2;
	
	public TicTacToeController() {
		this.ttt = new TicTacToe();
	}
	
	public void setUpPlayers(String playersInfo[]) {
		this.p1 = new Player(playersInfo[0], playersInfo[1]);
		this.p2 = new Player(playersInfo[2], playersInfo[3]);
	}
	
	public String[][] getBoard(){
		return this.ttt.getBoard();
	}
	
	public String getTurn() {
		if(p1.getTurn()) return "1st player";
		
		return "2nd player";
	}
	
	public String makeMove(int line, int column) {
		Player currentPlayer;
		Player otherPlayer;
		if(p1.getTurn() == true){
			currentPlayer = p1;
			otherPlayer = p2;
		}
		else {
			currentPlayer = p2;
			otherPlayer = p1;
		}
		
		this.ttt.makeMove(line, column, currentPlayer.getMove());
		currentPlayer.setTurn(false);
		otherPlayer.setTurn(true);
		if(ttt.checkWin()) {
			currentPlayer.increasetWins();
			currentPlayer.setTurn(true);
			otherPlayer.setTurn(false);
			otherPlayer.increaseLosses();
			return "w";
		}

		if(ttt.checkDraw()){
			return "d";
		}
		return "c";

	}
	
	public void reset() {
		this.ttt = new TicTacToe();
	}
	
	public int[] getScore() {
		return new int[] {this.p1.getWins(), this.p1.getLosses(), this.p2.getWins(),
				this.p2.getLosses()};
		
	}
	

}
