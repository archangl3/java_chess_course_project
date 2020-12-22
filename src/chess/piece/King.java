package chess.piece;

import chess.board.Cell;
import chess.game.Game;

public class King extends Piece {

	public King(Side side) {
		super("K", side);
	}

	@Override
	public boolean specificChecks(Game game, Cell start, Cell end) {
		int iDist = end.getI() - start.getI(); 
        int jDist = end.getJ() - start.getJ();

		int iDistAbs = Math.abs(iDist); 
        int jDistAbs = Math.abs(jDist);
        
        if (jDistAbs - iDistAbs == 0  & iDistAbs == 1) {  
        	return true;
        } else if ((jDistAbs == 0 & iDistAbs == 1) | iDistAbs == 0  & jDistAbs == 1) {  
        	return true;
        } else {
        	return false;
        }
        
        // check cell under attack
	}

}
