import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Board extends PApplet
{

    PImage whitePawnImg;
    PImage whiteRookImg;
    PImage whiteKnightImg;
    PImage whiteBishopImg;
    PImage whiteQueenImg;
    PImage whiteKingImg;

    PImage blackPawnImg;
    PImage blackRookImg;
    PImage blackKnightImg;
    PImage blackBishopImg;
    PImage blackQueenImg;
    PImage blackKingImg;


    Piece[][] grid = new Piece[8][8]; // master of all piece positions

    private boolean isALegalMove = false;

    int selectedRow = -1;
    int selectedCol = -1;

    public static void main(String[] args) // NOTHING GOES HERE
    {
        PApplet.main(new String[]{"Board"});

    }

    public void settings()
    {
        size(800, 800); // must be a square
    }


    public void setup() // everything runs once
    {
        initalizePieces();
        whitePawnImg = loadImage("ChessPieces/WhitePawn.png");
        whiteRookImg = loadImage("ChessPieces/WhiteRook.png");
        whiteKnightImg = loadImage("ChessPieces/WhiteKnight.png");
        whiteBishopImg = loadImage("ChessPieces/WhiteBishop.png");
        whiteQueenImg = loadImage("ChessPieces/WhiteQueen.png");
        whiteKingImg = loadImage("ChessPieces/WhiteKing.png");

        blackPawnImg = loadImage("ChessPieces/BlackPawn.png");
        blackRookImg = loadImage("ChessPieces/BlackRook.png");
        blackKnightImg = loadImage("ChessPieces/BlackKnight.png");
        blackBishopImg = loadImage("ChessPieces/BlackBishop.png");
        blackQueenImg = loadImage("ChessPieces/BlackQueen.png");
        blackKingImg = loadImage("ChessPieces/BlackKing.png");
    }

    /*
    From White's POV:
    bottom left  (a1) : [7][0]
    bottom right (h1) : [7][7]
    top left     (a8) : [0][0]
    top right    (h8) : [0][7]
     */



    public void initalizePieces()
    {
        grid[6][0] = new Pawn("white", 6, 0);
        grid[6][1] = new Pawn("white", 6, 1);
        grid[6][2] = new Pawn("white", 6, 2);
        grid[6][3] = new Pawn("white", 6, 3);
        grid[6][4] = new Pawn("white", 6, 4);
        grid[6][5] = new Pawn("white", 6, 5);
        grid[6][6] = new Pawn("white", 6, 6);
        grid[6][7] = new Pawn("white", 6, 7);

        grid[1][0] = new Pawn("black", 1, 0);
        grid[1][1] = new Pawn("black", 1, 1);
        grid[1][2] = new Pawn("black", 1, 2);
        grid[1][3] = new Pawn("black", 1, 3);
        grid[1][4] = new Pawn("black", 1, 4);
        grid[1][5] = new Pawn("black", 1, 5);
        grid[1][6] = new Pawn("black", 1, 6);
        grid[1][7] = new Pawn("black", 1, 7);
    }

    public void mousePressed()
    {
        int row = mouseY / 100;
        int col = mouseX / 100;

        selectedRow = row;
        selectedCol = col;

        // available moves visual representation: MAYBE


    }

    public void mouseReleased() // need to integrate getLegalMoves() into this later
    {
        int row = mouseY / 100;
        int col = mouseX / 100;

        Piece piece = grid[row][col]; // needed to make the getLegalMoves() call to work
        ArrayList<int[]> moves = piece.getLegalMoves(grid);


        for (int i = 0 ; i < moves.size(); i++) // loops through all the legal moves for that piece
        {
            int[] move = moves.get(i); // get the current move

            if (move[0] == row && move[1] == col) // compare current row and col with the legal moves list
            {
                grid[row][col] = grid[selectedRow][selectedCol];
                grid[selectedRow][selectedCol] = null; // incomplete
            }

        }
    }

    public void draw() // this is being constantly updated
    {
        int squareSize = 100; // each square is 100x100 pixels;

// --------------- making the blank board ----------------------------------------------------------------------------------------------------------------------------------------------
        for (int r = 0 ; r < 8 ; r++)
        {
            for (int c = 0 ; c < 8 ; c++)
            {
                if ((r + c) % 2 == 0)
                {
                    fill(235, 236, 208);
                    rect(r * 100, c * 100, squareSize, squareSize);
                }
                else
                {
                    fill(119, 149, 86);
                    rect(r * 100, c * 100, squareSize, squareSize);
                }
            }
        }
// ---------------------- end of blank chess board initiation ---------------------------------------------------------------------------------------------------------------




// ---------------------- looping through and placing every piece on the board -----------------------------------------------------------------------------------------------
        for (int r = 0 ; r < 8 ; r++)
        {
            for (int c = 0 ; c < 8 ; c++)
            {
                if (grid[r][c] instanceof Pawn && grid[r][c].color.equals("white")) // if it's a pawn AND if it's white
                {
                    image(whitePawnImg, c * 100 + 5, r * 100 + 5, 90, 90); // 90 and 90 so it sits nicely in the square
                }

                else if (grid[r][c] instanceof Pawn && grid[r][c].color.equals("black")) // if it's a pawn AND if it's black
                {
                    image(blackPawnImg, c * 100 + 5, r * 100 + 5, 90, 90);
                }
                //do the rest for rooks, queens ect.

            }
        }
// --------------------- end of placing pieces loop -------------------------------------------------------------------------------------------------------------------------------




// --------------------- making a square red if the attempted move is illegal (incomplete) -------------------------------------------------------------------------------------------------
        /*if (!isALegalMove)
        {
            fill(235, 236, 208);
            rect(selectedRow * 100, selectedCol * 100, squareSize, squareSize);
        }
         */
// --------------------- end of illegal moves overlay --------------------------------------------------------------------------------------------------------------------------------------------------------------------




// ---------------------- placing the overlay for legalMoves -------------------------------------------------------------------------------------------------------------------------
        for (int r = 0 ; r < 8 ; r++)
        {
            for (int c = 0 ; c < 8 ; c++)
            {
                Piece piece = grid[r][c]; // needed to make the getLegalMoves() call to work

                if (piece != null) // if the current square isn't blank
                {
                    ArrayList<int[]> moves = piece.getLegalMoves(grid);

                    for (int i = 0 ; i < moves.size(); i++) // loops through all the legal moves for that piece
                    {
                        int[] move = moves.get(i); // get the current move

                        if (move[0] == r && move[1] == c) // compare current row and col with the legal moves list
                        {
                            fill(150, 0 , 0);
                            ellipse(selectedCol * 100 + 50, selectedRow * 100 + 50, 50, 50);
                        }
                    }
                }



            }
        }
// --------------------------------- end of legal moves overlay --------------------------------------------------------------------------------------------------------------------------



    }
// ^^^ end of draw()
    
}