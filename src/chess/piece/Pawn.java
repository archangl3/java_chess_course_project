package chess.piece;

import chess.board.Cell;
import chess.game.Game;

public class Pawn extends Piece {

	public Pawn(Side side) {
		super("P", side);
	}

	@Override
	public boolean specificChecks(Game game, Cell start, Cell end) {
		int iDist = end.getI() - start.getI(); 
        int jDist = Math.abs(start.getJ() - end.getJ()); 
		
        // pawn attack
        // pawn first move
        // pawn special move
        
        return iDist == (this.getSide() == Side.WHITE ? -1 : 1) & jDist == 0;
	}
	
}
