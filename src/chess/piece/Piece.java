package chess.piece;

import chess.board.Cell;
import chess.game.Game;

public abstract class Piece {
	private final String NAME;
	private Side side;
	
	public Piece(String name, Side side) {
		this.NAME = name;
		this.side = side;
	}

	public String getNAME() {
		return NAME;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return side.name().toLowerCase().charAt(0) + NAME;
	}
	
	public boolean canMove(Game game, Cell start, Cell end) {
		return deafualtChecks(game, start, end) & specificChecks(game, start, end);
	}

	private boolean deafualtChecks(Game game, Cell start, Cell end) {
		
		if (end.getPiece() != null) {
			if (end.getPiece().getSide() == this.getSide()) {
				System.out.println("You cann't attact your pieces!");
	            return false; 
			}
        }
		
		if (this.getSide() != game.getCurrentTurn().getSide()) {
			System.out.println("This is not your piece!");
        	return false;
        }
		
		return true;
	};
	
	protected abstract boolean specificChecks(Game game, Cell start, Cell end);
}
