package chess.piece;

import chess.board.Cell;
import chess.game.Game;

public class Queen extends Piece {

	public Queen(Side side) {
		super("Q", side);
	}

	@Override
	public boolean specificChecks(Game game, Cell start, Cell end) {
		int iDist = end.getI() - start.getI(); 
        int jDist = end.getJ() - start.getJ();

		int iDistAbs = Math.abs(iDist); 
        int jDistAbs = Math.abs(jDist);
        
        if (Math.abs(jDist) - Math.abs(iDist) == 0 ) {
        	if (jDist < 0) {
        		if (iDist < 0) {
        			for (int i = 1; i < Math.abs(jDist); i++) {
                		if (game.getBoard().getCell(start.getI() - i, start.getJ() - i).getPiece() != null) {
                			return false;
                		}
                	}
        		} else {
        			for (int i = 1; i < Math.abs(jDist); i++) {
                		if (game.getBoard().getCell(start.getI() + i, start.getJ() - i).getPiece() != null) {
                			return false;
                		}
                	}
        		}
        	} else if (jDist > 0) {
        		
        		if (iDist < 0) {
        			for (int i = 1; i < Math.abs(jDist); i++) {
                		if (game.getBoard().getCell(start.getI() - i, start.getJ() + i).getPiece() != null) {
                			return false;
                		}
                	}
        			
        			
        		} else {
        			for (int i = 1; i < Math.abs(jDist); i++) {
                		if (game.getBoard().getCell(start.getI() + i, start.getJ() + i).getPiece() != null) {
                			return false;
                		}
                	}
        		}
        	}
        	
        	return true;
        } else if (jDistAbs == 0) {        	
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
