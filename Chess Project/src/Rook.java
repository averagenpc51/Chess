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

        int horEnd = 6;
        int horStart = 1;


        for(int c = col; c<8; c++){

            if (c == col){
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

            if(c == col){


                continue;
            }



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

        int vertEnd = 6;
        int vertStart = 1;


        for(int r = row; r<8; r++){

            if (r == row){
                continue;
            }

            if(board[r][col] !=null && !board[r][col].color.equals(this.color)){

                vertEnd = r;
                break;
            }
            if(board[r][col] !=null && board[r][col].color.equals(this.color)){

                vertEnd = r-1;
                break;

            }

        }

        for(int r = row; r>=0; r--){



            if(board[r][col] !=null && !board[r][col].color.equals(this.color)){

                vertStart = r;
                break;
            }
            if(board[r][col] !=null && board[r][col].color.equals(this.color)){

                vertStart = r+1;
                break;

            }


        }

        for(int r = vertStart; r<=vertEnd; r++){

            legalMoves.add(new int[]{r,col});

        }

        for(int c = horEnd; c<= horEnd; c++){

            legalMoves.add(new int[]{row, c});

        }




        return legalMoves;
    }











    }


*/