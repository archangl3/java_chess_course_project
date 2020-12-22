package chess.game;

//import java.util.ArrayList;
import java.util.Scanner;

import chess.board.Board;
import chess.board.Cell;
import chess.board.Move;
import chess.piece.Side;

public class Game {
	private Player[] players;
	private Board board;
	private Player currentTurn;
	private GameStatus status;
//	private ArrayList<Move> movesHistory = new ArrayList<>();
	
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
		
		while (status == GameStatus.ACTIVE) {
			board.print();
			System.out.printf("\n%s to move!\n", currentTurn);
			// input command
			Scanner sc = new Scanner(System.in);
			String commandStr = sc.next();
			
			// execute command
			switch (commandStr) {
				case "exit" :
					System.out.println("Exit...");
					System.exit(0);
					break;
				case "pass" :
					System.out.println(currentTurn + " passed!");
					return;
//				case "undo":
//					System.out.println("Undo.");
//					break;
				case "move":
					String step = sc.next();
					
					if (step.length() == 4) {
						Cell[] stepCells = new Cell[2];
						
						for (int i = 0; i < 2; i++) {
							int x = 8 - Integer.parseInt(step.substring(i*2+1, i*2+2));
							int y = Board.INDEXES.indexOf(step.charAt(i*2));
							stepCells[i] = board.getCell(x, y);
						};
						
						Move move = new Move(this, stepCells[0], stepCells[1]);
						boolean moved = move.go();
						
						if (moved) {
							currentTurn = currentTurn == players[0] ? players[1] : players[0];
						} 

						break;
					}
				default :
					System.out.println("Command not found");
					
			}
		}
	}

	public Board getBoard() {
		return board;
	}

	public Player getCurrentTurn() {
		return currentTurn;
	}
}
