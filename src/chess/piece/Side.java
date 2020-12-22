package chess.piece;

public enum Side {
	WHITE,
	BLACK;
	
	public Side getOpposite() {
		return this == Side.WHITE ? Side.BLACK : Side.WHITE;  
	}
	
	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
}
