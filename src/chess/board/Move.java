package chess.board;

import chess.game.Game;
import chess.piece.Piece;

public class Move {
	private Game game;
	private Cell start, end;
	
	public Move(Game game, Cell start, Cell end) {
		this.game = game;
		this.start = start;
		this.end = end;
	}
	

	public boolean go() {
		Piece pieceToMove = start.getPiece();
		
		
		if (pieceToMove == null) {
			System.out.println("Cell is empty");
		}
		else if (pieceToMove.canMove(game, start, end)) {
			System.out.println("OK.");
			start.setPiece(null);
			end.setPiece(pieceToMove);
			return true;
		}
		else {
			System.out.println("You cann't move like that!");
		}

		return false;
	}
}
