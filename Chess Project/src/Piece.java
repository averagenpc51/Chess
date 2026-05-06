import java.util.ArrayList;


// I don't think we need to touch this class anymore

public abstract class Piece
{
    protected String color; // Black or White
    protected int row; // needs to be converted later to abcdefgh
    protected int col; // needs to be converted later to 12345678

    public abstract ArrayList<int[]> getLegalMoves(Piece[][] board);
    // this stays BLANK

    /*public abstract ArrayList<String[]> getLegalMoves(Piece[][] board);

    public String getColor(){

    }

public int getRow();

public int getCol();

public void setPosition(int row, int col);

public boolean hasMoved();

public void setMoved(boolean moved);

protected boolean isEnemyPiece(Piece piece);

protected boolean isAllyPiece(Piece piece);

protected boolean isEmptySquare(Piece piece);

protected boolean isWithinBounds(int row, int col);
     */
}
