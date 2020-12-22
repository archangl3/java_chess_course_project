package chess.board;

import chess.piece.Piece;
import chess.piece.PiecesFactory;
import chess.piece.Side;

public class Board {
	final static int COL_NUM = 8;
	final static int ROW_NUM = 8;
	public final static String INDEXES = "abcdefgh";
	private final static String[] STD_POSITIONS = {
			"ROCK", "KNIGHT", "BISHOP", "QUEEN", "KING", "BISHOP", "KNIGHT", "ROCK" 
	};
	
	private Cell[][] cells;

	public Board() {
		cells = new Cell[COL_NUM][ROW_NUM];
		reset();
	}
	
	public void reset() {
		for (int i = 0; i < ROW_NUM; i++) {
			for (int j = 0; j < COL_NUM; j++) {
				cells[i][j] = new Cell(i, j, null);
			}
		}
		
		for (int i = 0; i < COL_NUM; i++) {
			cells[0][i].setPiece(PiecesFactory.getPiece(STD_POSITIONS[i], Side.BLACK));;
			cells[1][i].setPiece(PiecesFactory.getPiece("PAWN", Side.BLACK));
			cells[6][i].setPiece(PiecesFactory.getPiece("PAWN", Side.WHITE));
			cells[7][i].setPiece(PiecesFactory.getPiece(STD_POSITIONS[i], Side.WHITE));
		}

	}
	
	public Cell getCell(int i, int j) {
		return cells[i][j];
	}
	
	public void print() {
		printIndexes();
		printSep();
		for (int i = 0; i < ROW_NUM; i++) {
			System.out.printf(" %d |", 8 - i);
			for (int j = 0; j < COL_NUM; j++) {
				Piece piece = cells[i][j].getPiece();
				System.out.printf(" %s |", piece == null ? "  " : piece);
			}
			System.out.printf(" %d\n", 8 - i);
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
