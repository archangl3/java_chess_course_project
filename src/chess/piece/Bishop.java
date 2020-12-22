package chess.piece;

import chess.board.Cell;
import chess.game.Game;

public class Bishop extends Piece {

	public Bishop(Side side) {
		super("B", side);
	}

	@Override
	public boolean specificChecks(Game game, Cell start, Cell end) {
		int iDist = end.getI() - start.getI(); 
        int jDist = end.getJ() - start.getJ();
        
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
        } else {
        	return false;
        }
	}

}
