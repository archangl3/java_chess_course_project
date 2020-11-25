package chess.board;

import chess.piece.Piece;
import chess.piece.PiecesFactory;
import chess.piece.Side;

public class Board {
	final static int COL_NUM = 8;
	final static int ROW_NUM = 8;
	private final static String INDEXES = "abcdefgh";
	private final static String[] STD_POSITIONS = {
			"ROCK", "KNIGHT", "BISHOP", "QUEEN", "KING", "BISHOP", "KNIGHT", "ROCK" 
	};
	
	private Spot[][] cells;

	public Board() {
		cells = new Spot[COL_NUM][ROW_NUM];
		reset();
	}
	
	public void reset() {
		for (int i = 0; i < ROW_NUM; i++) {
			for (int j = 0; j < COL_NUM; j++) {
				cells[i][j] = new Spot(i, j, null);
			}
		}
		
		for (int i = 0; i < COL_NUM; i++) {
			cells[0][i].setPiece(PiecesFactory.getPiece(STD_POSITIONS[i], Side.BLACK));;
			cells[1][i].setPiece(PiecesFactory.getPiece("PAWN", Side.BLACK));
			cells[6][i].setPiece(PiecesFactory.getPiece("PAWN", Side.WHITE));
			cells[7][i].setPiece(PiecesFactory.getPiece(STD_POSITIONS[i], Side.WHITE));
		}

	}
	
	public void print() {
		printIndexes();
		printSep();
		for (int i = 0; i < ROW_NUM; i++) {
			System.out.printf(" %d |",i+1);
			for (int j = 0; j < COL_NUM; j++) {
				Piece piece = cells[i][j].getPiece();
				System.out.printf(" %s |", piece == null ? "  " : piece);
			}
			System.out.printf(" %d\n",i+1);
			printSep();
		}
		printIndexes();
	}
	
	private void printSep() {
		System.out.print("   *");
		for (int i = 0; i < COL_NUM; i++) {
			System.out.print("----*");
		}
		System.out.print("\n");
	}
	
	private void printIndexes() {
		System.out.print("   ");
		for (int i = 0; i < COL_NUM; i++) {
			System.out.printf("  %s  ", INDEXES.charAt(i));
		}
		System.out.print("\n");
	}
}
