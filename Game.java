public class Game {

    public static void main(String [] args) {
    	Board brd =  new Board(new Player("X"), new Player("O"));
    	brd.printWelcome();
    }
}
