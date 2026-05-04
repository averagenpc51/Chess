import java.util.ArrayList;

public class Pawn extends Piece
{

    public Pawn(String color, int row, int col)
    {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    @Override

    public ArrayList<int[]> getLegalMoves(Piece[][] board)
    {
        ArrayList<int[]> legalMoves = new ArrayList<>();

        // mihir do this

        return legalMoves;
    }
}