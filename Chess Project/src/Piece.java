import java.util.ArrayList;


// I don't think we need to touch this class anymore

public abstract class Piece
{
    String color; // Black or White
    int row; // needs to be converted later to abcdefgh
    int col; // needs to be converted later to 12345678

    public abstract ArrayList<int[]> getLegalMoves(Piece[][] board);
    // this stays BLANK
}
