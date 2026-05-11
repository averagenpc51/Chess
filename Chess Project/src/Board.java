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

    int selectedRow = -1;
    int selectedCol = -1;

    int lastSelectedRow = -1;
    int lastSelectedCol = -1;

    String whosMove = "white";

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
        // pawns
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

        // rooks
        grid[7][0] = new Rook("white", 7, 0);
        grid[7][7] = new Rook("white", 7, 7);
        grid[0][0] = new Rook("black", 0, 0);
        grid[0][7] = new Rook("black", 0, 7);
/*
        // knights
        grid[7][1] = new Knight("white", 7, 1);
        grid[7][6] = new Knight("white", 7, 6);
        grid[0][1] = new Knight("black", 0, 1);
        grid[0][6] = new Knight("black", 0, 6);

        // bishops
        grid[7][2] = new Bishop("white", 7, 2);
        grid[7][5] = new Bishop("white", 7, 5);
        grid[0][2] = new Bishop("black", 0, 2);
        grid[0][5] = new Bishop("black", 0, 5);

        // queens
        grid[7][3] = new Queen("white", 7, 3);
        grid[0][3] = new Queen("black", 0, 3);

        // kings
        grid[7][4] = new King("white", 7, 4);
        grid[0][4] = new King("black", 0, 4);
        */
    }

    public void mousePressed()
    {
        int row = mouseY / 100;
        int col = mouseX / 100;

        selectedRow = row;
        selectedCol = col;



        Piece selectedPiece = grid[selectedRow][selectedCol];

        if (selectedPiece == null || !selectedPiece.color.equals(whosMove))
        {
            selectedRow = -1;
            selectedCol = -1;
        }
    }

    public void mouseReleased()
    {
        int row = mouseY / 100;
        int col = mouseX / 100;

        if (selectedRow == -1 || selectedCol == -1) // if last move was illegal do nothing
        {
            return;
        }

        Piece selectedPiece = grid[selectedRow][selectedCol];


        if (selectedPiece != null)
        {
            ArrayList<int[]> moves = selectedPiece.getLegalMoves(grid);

            for (int i = 0; i < moves.size(); i++)
            {
                int[] move = moves.get(i);

                if (move[0] == row && move[1] == col) // if it is a legal move
                {
                    grid[row][col] = grid[selectedRow][selectedCol];
                    grid[selectedRow][selectedCol] = null;
                    grid[row][col].row = row;
                    grid[row][col].col = col;
                    selectedRow = -1;
                    selectedCol = -1;

                    lastSelectedRow = row;
                    lastSelectedCol = col;

                    if (whosMove.equals("white"))
                    {
                        whosMove = "black";
                    }
                    else
                    {
                        whosMove = "white";
                    }
                }
            }
        }
    }

    public void draw() // this is being constantly updated
    {
        int squareSize = 100;

// --------------- making the blank board -----------------------------------------------
        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 8; c++)
            {
                if ((r + c) % 2 == 0)
                {
                    fill(235, 236, 208);
                    rect(c * 100, r * 100, squareSize, squareSize);
                }
                else
                {
                    fill(119, 149, 86);
                    rect(c * 100, r * 100, squareSize, squareSize);
                }
            }
        }
// ---------------------- end of blank chess board --------------------------------------




// ---------------------- looping through and placing every piece on the board ----------
        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 8; c++)
            {
                if (grid[r][c] instanceof Pawn && grid[r][c].color.equals("white"))
                { image(whitePawnImg, c * 100 + 5, r * 100 + 5, 90, 90); }
                else if (grid[r][c] instanceof Pawn && grid[r][c].color.equals("black"))
                { image(blackPawnImg, c * 100 + 5, r * 100 + 5, 90, 90); }

                else if (grid[r][c] instanceof Rook && grid[r][c].color.equals("white"))
                { image(whiteRookImg, c * 100 + 5, r * 100 + 5, 90, 90); }
                else if (grid[r][c] instanceof Rook && grid[r][c].color.equals("black"))
                { image(blackRookImg, c * 100 + 5, r * 100 + 5, 90, 90); }
                /*
                else if (grid[r][c] instanceof Knight && grid[r][c].color.equals("white"))
                { image(whiteKnightImg, c * 100 + 5, r * 100 + 5, 90, 90); }
                else if (grid[r][c] instanceof Knight && grid[r][c].color.equals("black"))
                { image(blackKnightImg, c * 100 + 5, r * 100 + 5, 90, 90); }

                else if (grid[r][c] instanceof Bishop && grid[r][c].color.equals("white"))
                { image(whiteBishopImg, c * 100 + 5, r * 100 + 5, 90, 90); }
                else if (grid[r][c] instanceof Bishop && grid[r][c].color.equals("black"))
                { image(blackBishopImg, c * 100 + 5, r * 100 + 5, 90, 90); }

                else if (grid[r][c] instanceof Queen && grid[r][c].color.equals("white"))
                { image(whiteQueenImg, c * 100 + 5, r * 100 + 5, 90, 90); }
                else if (grid[r][c] instanceof Queen && grid[r][c].color.equals("black"))
                { image(blackQueenImg, c * 100 + 5, r * 100 + 5, 90, 90); }

                else if (grid[r][c] instanceof King && grid[r][c].color.equals("white"))
                { image(whiteKingImg, c * 100 + 5, r * 100 + 5, 90, 90); }

                else if (grid[r][c] instanceof King && grid[r][c].color.equals("black"))
                { image(blackKingImg, c * 100 + 5, r * 100 + 5, 90, 90); }
                 */
            }
        }
// --------------------- end of placing pieces loop ------------------------------------




// ---------------------- legal moves overlay ------------------------------------------
        if (selectedRow != -1 && selectedCol != -1)
        {
            Piece selected = grid[selectedRow][selectedCol];
            if (selected != null)
            {
                ArrayList<int[]> moves = selected.getLegalMoves(grid);
                for (int i = 0; i < moves.size(); i++)
                {
                    int[] move = moves.get(i);
                    fill(150, 0, 0, 100);
                    ellipse(move[1] * 100 + 50, move[0] * 100 + 50, 50, 50);
                }
            }
        }
// ---------------------- end of legal moves overlay -----------------------------------




//-------------------------last move overlay-----------------------------------------------
        if (lastSelectedRow != -1)
        {
            fill(0, 150, 0, 100);
            rect(lastSelectedCol * 100, lastSelectedRow * 100, squareSize, squareSize);
        }

    }
// ^^^ end of draw()

}