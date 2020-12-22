package chess.piece;

import chess.board.Cell;
import chess.game.Game;

public class Knight extends Piece {

	public Knight(Side side) {
		super("N", side);
	}

	@Override
	public boolean specificChecks(Game game, Cell start, Cell end) {
		int iDist = Math.abs(start.getI() - end.getI());
        int jDist = Math.abs(start.getJ() - end.getJ());
        
        return iDist * jDist == 2; 
	}
}
