import processing.core.PApplet;
import processing.core.PImage;

public class Board extends PApplet
{

    PImage whitePawnImg;


    Piece[][] grid = new Piece[8][8]; // master of all piece positions

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
        whitePawnImg = loadImage("WhitePawn.png");
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
    }



    public void draw() // this runs every frame
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

        for (int r = 0 ; r < 8 ; r++)
        {
            for (int c = 0 ; c < 8 ; c++)
            {
                if (grid[r][c] instanceof Pawn)
                {
                    image(whitePawnImg, c * 100, r * 100, 100, 100);
                }

            }
        }




    }
// ^^^ end of draw()
    
}