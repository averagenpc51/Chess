import java.util.ArrayList;

public class Rook extends Piece
{




    public Rook(String color, int row, int col)
    {
        this.color = color;
        this.row = row;
        this.col = col;


    }

    @Override

    public ArrayList<int[]> getLegalMoves(Piece[][] board)
    {
        ArrayList<int[]> legalMoves = new ArrayList<>();



        for(int c = 0; c<=col; c++){

            if(board[row][c] !=null && !board[row][c].color.equals(this.color)){

                

            }

        }

        }




        return legalMoves;
    }











    }


