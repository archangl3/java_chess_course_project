package chess.game;

import chess.piece.Side;

public class Player {
	private String name;
	private Side side;
	
	public Player(String name, Side side) {
		this.name = name;
		this.side = side;
	}

	public String getName() {
		return name;
	}

	public Side getSide() {
		return side;
	}

	@Override
	public String toString() {
		return String.format("%s (%s side)", name, side);
	}
	
	
	
}
