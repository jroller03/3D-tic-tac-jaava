public class Player {

	private String symbol;
	private int score = 0;
	public Player(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public int getScore(){
		return score;
	}

	public void incrementScore() { score++; }

	public boolean checkWin(Grid check){
		if(check.checkWin(symbol)){
			incrementScore();
			return true;
		} else {
			return false;
		}
	}

}
