import java.util.ArrayList;

/* questions:
does this check to see if a pawn can capture its own colored pawn (like white pawn takes white pawn)?
does the returned arraylist include legal squares

*/







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

       if(this.canMoveForward(board)){

           legalMoves.add(new int[]{row+getDirection(), col});

       }
        if(this.canMoveTwoSquares(board)){

            legalMoves.add(new int[]{row+2*getDirection(), col});

        }
        if(this.canCaptureLeft(board)){

            legalMoves.add(new int[]{row + getDirection(), col-1});

        }
        if(this.canCaptureRight(board)){

            legalMoves.add(new int[]{row + getDirection(), col+1});

        }




        return legalMoves;
    }

    private int getDirection(){

        if (color.equals( "white")){

            return -1;
        }
        else return 1;


    }


    private boolean isFirstMove(){

        if(color.equals("white")){

            return row == 7;

        }
        else if(color.equals("black")){

            return row == 2;

        }


        return false;
    }



    private boolean canMoveForward(Piece[][] board){

        if (board[row + getDirection()][col] == null){

            return true;

        }
        return false;
    }

    private boolean canMoveTwoSquares(Piece[][] board){

        return isFirstMove() && board[row + 2 * getDirection()][col] == null;

    }

    private boolean canCaptureLeft(Piece[][] board){

        return board[row + getDirection()][col - 1]!= null && !board[row + getDirection()][col - 1].color.equals(this.color);

    }




    private boolean canCaptureRight(Piece[][] board){

        return board[row + getDirection()][col +1 ]!= null && !board[row + getDirection()][col + 1].color.equals(this.color);

    }


}