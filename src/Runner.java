import chess.game.Game;
import chess.game.Player;
import chess.piece.Side;

public class Runner {

	public static void main(String[] args) {
		
		Player[] players = {
				new Player("Player 1", Side.WHITE),
				new Player("Player 2", Side.BLACK)
		};
		
		Game game = new Game(players[0], players[1]);
		game.play();
	}

}
