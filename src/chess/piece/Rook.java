package chess.piece;

import chess.board.Cell;
import chess.game.Game;

public class Rook extends Piece {

	public Rook(Side side) {
		super("R", side);
	}

	@Override
	public boolean specificChecks(Game game, Cell start, Cell end) {
		int iDistAbs = Math.abs(start.getI() - end.getI()); 
        int jDistAbs = Math.abs(start.getJ() - end.getJ());
        
        if (jDistAbs == 0) {        	
        	int min_j = Math.min(start.getI(), end.getI());
        	int max_j = Math.max(start.getI(), end.getI());
        	
        	for (int i = min_j + 1; i <  max_j; i++) {
        		if (game.getBoard().getCell(i, start.getJ()).getPiece() != null) {
        			return false;
        		}
        	}
        	
        	return true;
        } else if (iDistAbs == 0) {
        	int min_j = Math.min(start.getJ(), end.getJ());
        	int max_j = Math.max(start.getJ(), end.getJ());
        	
        	for (int i = min_j + 1; i <  max_j; i++) {
        		if (game.getBoard().getCell(start.getI(), i).getPiece() != null) {
        			return false;
        		}
        	}
        	
        	return true;
        } else {
        	return false;
        }
	}

}
