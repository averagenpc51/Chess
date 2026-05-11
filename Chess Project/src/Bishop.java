import java.util.ArrayList;


    public class Bishop extends Piece
    {




        public Bishop(String color, int row, int col)
        {
            this.color = color;
            this.row = row;
            this.col = col;


        }

        @Override

        public ArrayList<int[]> getLegalMoves(Piece[][] board)
        {



            ArrayList<int[]> legalMoves = new ArrayList<>();


            int downStartRow = row;
            int downStartCol = col;

            for(int r = row-1; r >= 0; r--) {
                for (int c = col - 1; c >= 0; c--) {



                    if (board[r][c] == null) {
                        downStartRow = r;
                        downStartCol = c;

                    }
                    else if (!board[r][c].color.equals(this.color)) {
                        downStartRow = r;
                        downStartCol = c;
                        break;
                    }
                    else if (board[r][c].color.equals(this.color)) {
                        downStartRow = r + 1;
                        downStartCol = c + 1;
                    }
                }


            }

            for(int r = downStartRow; r>=0; r--){

                for(int c = downStartCol; c>=0; c--){

                    legalMoves.add(new int[]{r,c});

                }

            }



            for(int r = row; r<=7; r++){

                for(int c = col; c<=7; c++){




                }


            }



            return legalMoves;
        }











    }



*/








