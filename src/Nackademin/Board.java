package Nackademin;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.lang.*;



public class Board {


    protected int rowAndCol, blockAmount;   //To decide how big a board would be, to count how many blocks left on the board
    protected String[][] board;       //To make a board
    protected int x, y;   //To create the coordinate for a chess

    protected String chessLabel;

    protected boolean gameIsOn;     //To judge whether a new board is needed
    protected boolean gameRestart;      //To judge whether a game should go on or not
    protected boolean blockIsTaken;     //To judge whether a block is taken or not


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
    public void brandnewBoard()
    {

        for(int i = 0; i<this.rowAndCol; i++)
            for(int j =0; j<this.rowAndCol; j++)
                board[i][j]=(" ");


    }

    //print out an empty board
    public void printBoard(Player p1,Player p2)
    {

        if(gameIsOn)
        {
        //show all chess
            System.out.println(p1.getName()+" "+p2.getName()+". Enjoy your game!!");
            showBoard();

        }
        else {

            //New chess board
            System.out.println(p1.getName()+" "+p2.getName()+" Here is your new chess board:");
            brandnewBoard();
            showBoard();
        }




    }

    public void showBoard()
    {
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

    //To check how many blocks left,when no block left turn gameIsOn to false
    public void leftBlockAmount()
    {

        blockAmount--;
        if(blockAmount==0)
        {
            gameRestart = true;    //No blocks left need to restart
            gameIsOn = false;   //No blocks left, game stops.
            System.out.println("All blocks are used up");
        }
    }

    //Create a chess coordinate and place  the  chess  on board
    public void placeChess(Player p) //(Player thisPlayer, Player otherPlayer)
    {
        p.setChessCoordinateX();
        p.setChessCoordinateY();

        while (!(board[p.x][p.y].equals(" ") || board[p.x][p.y].isEmpty()))
        {
            System.out.println(p.getName() +", the block you chose is taken. Choose again!");
            p.setChessCoordinateX();
            p.setChessCoordinateY();

        }
        this.board[p.x][p.y] = p.chessLabel;
        leftBlockAmount();
        System.out.println(blockAmount);

        /*if (board[p.x][p.y].equals(" ") || board[p.x][p.y].isEmpty())
        {
            this.board[p.x][p.y] = p.chessLabel;
            leftBlockAmount();
            System.out.println(blockAmount);
        }

        else
        {



            while(!blockIsTaken)
            {
                System.out.println(p.getName() +", the block you chose is taken. Choose again!");

                p.setChessCoordinateX();
                p.setChessCoordinateY();
                if(board[p.x][p.y].equals(" ")||board[p.x][p.y].isEmpty())
                {
                    this.board[p.x][p.y] = p.chessLabel;
                    leftBlockAmount();
                    System.out.println(blockAmount);
                    blockIsTaken = true;
                }
            }
        }*/


         /*
        *
        * if(this.board[x][y].equals(""))
        {
            this.board[thisPlayer.x][thisPlayer.y]= thisPlayer.chessLabel;
            this.board[otherPlayer.x][otherPlayer.y] = otherPlayer.chessLabel;
        }
        else
        {
            System.out.println("The block is taken, choose again!");
            blockIsTaken=true;
        }*/


        /*
        * //TO check whether the block chosen by thisPlayer is taken or not
        if (board[thisPlayer.x][thisPlayer.y].equals(" "))
        {
            this.board[thisPlayer.x][thisPlayer.y] = thisPlayer.chessLabel;

        } else
        {
            System.out.println("The block is taken, "+ thisPlayer.getName()+"choose again!");
            blockIsTaken=true;

        }
        //TO check whether the block chosen by otherPlayer is taken or not
        if(this.board[otherPlayer.x][otherPlayer.y].equals(" "))
        {
            this.board[otherPlayer.x][otherPlayer.y] = otherPlayer.chessLabel;
        }else
        {
            System.out.println("The block is taken, "+ otherPlayer.getName()+"choose again!");
            blockIsTaken=true;

        }*/
        //this.board[p.x][p.y] = p.chessLabel;

    }




    public int getBlockAmount() {
        return blockAmount;
    }

    public int getRowAndCol() {
        return rowAndCol;
    }
}
