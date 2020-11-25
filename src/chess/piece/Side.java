package chess.piece;

public enum Side {
	WHITE,
	BLACK;
	
	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
}
