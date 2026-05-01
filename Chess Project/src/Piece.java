import java.util.ArrayList;

public abstract class Piece
{
    String color; // Black or White
    int row; // needs to be converted later to abcdefgh
    int col; // needs to be converted later to 12345678

    public ArrayList<int[]> getLegalMoves()
    {
        ArrayList<int[]> legalMoves = new ArrayList<>(); // list of all of the legal moves
    }

}
