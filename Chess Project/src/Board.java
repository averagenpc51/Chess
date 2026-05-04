import processing.core.PApplet;

public class Board extends PApplet
{
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
        Piece[][] grid = new Piece[8][8]; // master of all piece positions

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
        grid[]
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





    }
// ^^^ end of draw()
    
}