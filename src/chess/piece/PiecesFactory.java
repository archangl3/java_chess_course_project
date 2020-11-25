package chess.piece;

public class PiecesFactory {
	
	public static Piece getPiece(String pieceId, Side side) {
		PieceKind kind = PieceKind.valueOf(pieceId);
		return kind.getPiece(side);
	}
}
