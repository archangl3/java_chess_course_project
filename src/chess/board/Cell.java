package chess.board;

import chess.piece.Piece;

public class Cell {
	private Piece piece; 
    private int i; 
    private int j; 
  
    public Cell(int i, int j, Piece piece) 
    { 
    	this.piece = piece; 
        this.i = i; 
        this.j = j; 
    } 
  
    public Piece getPiece() 
    { 
        return this.piece; 
    } 
  
    public void setPiece(Piece p) 
    { 
        this.piece = p; 
    } 
  
    public int getI() 
    { 
        return this.i; 
    }
  
    public int getJ() 
    { 
        return this.j; 
    }
}
