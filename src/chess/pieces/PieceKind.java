package chess.pieces;

public enum PieceKind {
	KING {
		Piece getPiece(Side side) {
			return new King(side);
		}
	},
	QUEEN {
		Piece getPiece(Side side) {
			return new Queen(side);
		}
	},
	KNIGHT {
		Piece getPiece(Side side) {
			return new Knight(side);
		}
	},
	BISHOP {
		Piece getPiece(Side side) {
			return new Bishop(side);
		}
	},
	ROCK {
		Piece getPiece(Side side) {
			return new Rook(side);
		}
	},
	PAWN {
		Piece getPiece(Side side) {
			return new Pawn(side);
		}
	};
	
	abstract Piece getPiece(Side side);
}
