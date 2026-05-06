import processing.core.PApplet;
import processing.core.PImage;

public class Board extends PApplet
{

    PImage whitePawnImg;
    PImage blackPawnImg;


    Piece[][] grid = new Piece[8][8]; // master of all piece positions

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
        blackPawnImg = loadImage("ChessPieces/BlackPawn.png");
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

        if(row != selectedRow && col != selectedCol)
        {
            grid[row][col] = grid[selectedRow][selectedCol];
            grid[selectedRow][selectedCol] = null;
        }
    }

    public void draw() // this is being constantly updated
    {
        int squareSize = 100; // each square is 100x100 pixels;

// --------------- making the blank board -----------------------------------------------
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
// ---------------------- end of blank chess board initiation ------------------------------



// ---------------------- looping through and placing every piece on the board -------------------------------------
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
// --------------------- end of placing pieces loop -----------------------------------------------------------------------------------

// ---------------------- placing the overlay for legalMoves --------------------------------------------------------------------------
        for (int r = 0 ; r < 8 ; r++)
        {
            for (int c = 0 ; r < 8 ; c++)
            {
                Piece akljsherkj = grid[r][c];


                for (int i = 0 ; i < grid.getLegalMoves().size ; i++) // loops through all of the legal moves for that piece
                {
                    if (i == (r*10) + c) // i dont think this is how its supossed to work
                    {
                        fill(150, 0 , 0);
                        ellipse(selectedCol * 100 + 50, selectedRow * 100 + 50, 50, 50);
                    }
                }
            }
        }





    }
// ^^^ end of draw()
    
}