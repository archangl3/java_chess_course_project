package chess.game;

import java.util.Scanner;

import chess.board.Board;
import chess.piece.Side;

public class Game {
	private Player[] players;
	private Board board;
	private Player currentTurn;
	private GameStatus status;
	
	public Game(Player player1, Player player2) {
		this.players = new Player[2];
		this.players[0] = player1;
		this.players[1] = player2;
		this.board = new Board();		
		this.status = GameStatus.ACTIVE;
		this.currentTurn = player1.getSide() == Side.WHITE ? player1 : player2;
	}
	
	public void play() {
		System.out.printf("%s vs %s\n\n", players[0], players[1]);
		board.print();
		
		while (status == GameStatus.ACTIVE) {
			// input command
			Scanner sc = new Scanner(System.in);
			String commandStr = sc.next();
			
			// execute command
			switch (commandStr) {
				case "exit" :
					System.out.println("Exit...");
					System.exit(0);
					break;
				case "undo":
					System.out.println("Undo.");
					break;
				case "move":
					break;
				default :
					System.out.println("Command not found");
			}
		}
	}
}
