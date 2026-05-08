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
            if(board[row][c] !=null && board[row][c].color.equals(this.color)){

                horEnd = c-1;
                break;

            }

        }

        for(int c = col; c>=0; c--){



            if(board[row][c] !=null && !board[row][c].color.equals(this.color)){

                horStart = c;
                break;
            }
            if(board[row][c] !=null && board[row][c].color.equals(this.color)){

                horStart = c+1;
                break;

            }


        }

        for(int c = horStart; c<=horEnd; c++){

            legalMoves.add(new int[]{row,c});

        }

        //for Vertical MOVES

        int vertEnd;
        int vertStart;


        for(int r = row; r<8; r++){

            if (row == 7){
                continue;
            }

            if(board[r][col] !=null && !board[r][col].color.equals(this.color)){

                horEnd = r;
                break;
            }
            if(board[r][col] !=null && board[r][col].color.equals(this.color)){

                horEnd = r-1;
                break;

            }

        }

        for(int r = row; r>=0; r--){



            if(board[r][col] !=null && !board[r][col].color.equals(this.color)){

                horStart = r;
                break;
            }
            if(board[r][col] !=null && board[r][col].color.equals(this.color)){

                horStart = r+1;
                break;

            }


        }

        for(int r = vertStart; r<=vertEnd; r++){

            legalMoves.add(new int[]{r,col});

        }




        return legalMoves;
    }











    }


*/