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

            return row == 6;

        }
        else if(color.equals("black")){

            return row == 1;

        }


        return false;
    }



    private boolean canMoveForward(Piece[][] board){

        try {
            return board[row + getDirection()][col] == null;
        }
        catch (IndexOutOfBoundsException e){

            return false;
        }
    }

    private boolean canMoveTwoSquares(Piece[][] board){

        try {
            return isFirstMove() && board[row + 2 * getDirection()][col] == null &&  board[row + getDirection()][col] == null;
        }
        catch (IndexOutOfBoundsException e){

            return false;
        }

    }

    private boolean canCaptureLeft(Piece[][] board){

        try {
            return board[row + getDirection()][col - 1] != null && !board[row + getDirection()][col - 1].color.equals(this.color);
        }
        catch (IndexOutOfBoundsException e){

            return false;
        }
    }




    private boolean canCaptureRight(Piece[][] board){

        try {
            return board[row + getDirection()][col + 1] != null && !board[row + getDirection()][col + 1].color.equals(this.color);
        }
        catch (IndexOutOfBoundsException e){

            return false;
        }
    }


}