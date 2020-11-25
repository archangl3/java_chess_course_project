package chess.piece;

public abstract class Piece {
	private final String NAME;
	private Side side;
	private boolean killed;
	
	public Piece(String name, Side side) {
		this.NAME = name;
		this.side = side;
		this.killed = false;
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

	public boolean isKilled() {
		return killed;
	}

	public void setKilled(boolean killed) {
		this.killed = killed;
	}

	@Override
	public String toString() {
		return side.name().toLowerCase().charAt(0) + NAME;
	}
	
//	public abstract boolean canMove(Board board, Spot start, Spot end);
}
