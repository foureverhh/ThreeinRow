package Nackademin;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import javax.swing.*;
import java.lang.*;



public class Board {


    protected int rowAndCol, blockAmount;   //To decide how big a board would be, to count how many blocks left on the board
    protected String[][] board;       //To make a board
    protected int x, y;   //To create the coordinate for a chess

    protected String chessLabel;

    protected boolean gameIsOn;     //To judge whether a new board is needed
    protected boolean gameRestart;      //To judge whether a game should go on or not



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
            gameIsOn = false;      //No blocks left, game stops.
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
    }

    //Scan the board to check who is the winner
    public void checkWinner(Player p)
    {
        horizontallyCheck(p);             // Check board in the direction of -
        verticallyCheck(p);               // Check board in the direction of |
        diagonallyCheckBackslash(p);      // Check board in the direction of \
        diagonallyCheckSlash(p);          // Check board in the direction of /
    }

    //Show winner's name on the board
    public void showWinner(Player p)
    {
        gameIsOn = false;      //Got a winner, game stops.
        gameRestart = true;      //Got a winner, game need to restart.
        JOptionPane.showMessageDialog(null,"Winner is "+ p.getName());
    }

    //To check whether player wins horizontally
    public void horizontallyCheck(Player p)
    {
        int i=0;
        while(i<board.length)
        {
            for(int j=0;j<board.length-1;j++) {
                //if each previous block holds the player's chess label
                //and all the next block has same  value to its previous one horizontally.
                if (board[i][j].equals(p.chessLabel)&&board[i][j].equals(board[i][j+1]))
                {
                    showWinner(p);
                    break;
                }
            }

            i++;
        }
    }


    //To check whether player wins vertically
    public void verticallyCheck(Player p)
    {
        int j=0;
        while(j<board.length)
        {
            for(int i=0;i<board.length-1;i++)
            {
                if(board[i][j].equals(p.chessLabel)&&board[i][j].equals(board[i+1][j]))
                {
                    showWinner(p);
                    break;
                }
            }
            j++;
        }
    }

    //To check whether player wins diagonally, slash
    public void diagonallyCheckSlash(Player p)
    {

        for(int i=0;i<board.length-1;i++)
        {
            if(board[i][i].equals(p.chessLabel)&&board[i][i].equals(board[i+1][i+1]))
            {
                showWinner(p);
                break;
            }
        }
    }

    //To check whether player wins diagonally, backslash
    public void diagonallyCheckBackslash(Player p)
    {
        for(int i=0;i<board.length-1;i++)
        {
            if(board[i][board.length-1-i].equals(p.chessLabel)
                    &&board[i][board.length-1-i].equals(board[i+1][board.length-1-i+1]))
            {
                showWinner(p);
                break;
            }
        }
    }


    public int getBlockAmount() {
        return blockAmount;
    }

    public int getRowAndCol() {
        return rowAndCol;
    }
}
