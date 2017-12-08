package Nackademin;
import java.lang.*;



public class Board {


    protected int rowAndCol, blockAmount;   //To decide how big a board would be, to count how many blocks left on the board
    protected String[][] board;       //To make a board
    protected int x, y;   //To create the coordinate for a chess
    protected boolean gameIsOn;
    protected String chessLabel;



// Constructor
    public Board(int rowAndCol)
    {
        this.rowAndCol = rowAndCol;
        this.board = new String[rowAndCol][rowAndCol];
        this.blockAmount = rowAndCol*rowAndCol;

    }
    public Board()
    {

    }



//Methods
    //Create an empty two dimentional array
    public void boardLayout()
    {

        for(int i = 0; i<this.rowAndCol; i++)
            for(int j =0; j<this.rowAndCol; j++)
                board[i][j]=(" ");


    }

    //print out an empty board
    public void printBoard()
    {
        //Create a board
        if(gameIsOn)
        {
            //At beginning create an empty board
            System.out.println("Enjoy your game!!");
            placeChess( x,y,chessLabel);
        }
        else {
            //After game began, show all chess
            System.out.println("Here is your chess board:");
            boardLayout();
        }

        //print the board
        for(int k=0;k<this.rowAndCol;k++)
            System.out.print(" ---");
        System.out.println();

        for(int i = 0; i<this.rowAndCol; i++)
        {
            for(int j = 0; j<this.rowAndCol; j++)
            {
                System.out.print("| "+board[i][j]+" ");
            }

            System.out.println("|");
            for(int k=0;k<this.rowAndCol;k++)
            {
                System.out.print(" ---");
            }
            System.out.println();
        }


    }

    //Calculate how many block left
    public void leftBlockAmount()
    {

        blockAmount--;
    }

    //Create a chess coordinate and place it on board
    public void placeChess(int x, int y,String s)
    {

        board[x][y]=s;

    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBlockAmount() {
        return blockAmount;
    }

    public int getRowAndCol() {
        return rowAndCol;
    }
}
