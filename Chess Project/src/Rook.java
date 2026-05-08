/*import java.util.ArrayList;

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



        //for HOROZONTAL MOVES

        int horEnd;
        int horStart;


        for(int c = col; c<8; c++){

            if (col == 7){
                continue;
            }

            if(board[row][c] !=null && !board[row][c].color.equals(this.color)){

                horEnd = c;
                break;
            }
            if(board[row][c] !=null && board[row][c].color.equals(this.color){

                horEnd = c-1;
                break;

            }

        }

        for(int c = col; c<=0; c--){

            if (c == 0){continue;}

            if(board[row][c] !=null && !board[row][c].color.equals(this.color)){

                horStart = c;
                break;
            }
            if(board[row][c] !=null && board[row][c].color.equals(this.color){

                horStart = c+1;
                break;



        }


        }




        return legalMoves;
    }











    }

*/
