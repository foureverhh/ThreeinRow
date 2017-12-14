package Nackademin;
import com.sun.codemodel.internal.JOp;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import javax.swing.*;
import java.lang.*;
import java.util.Random;


public class Board {


    private int rowAndCol, blockAmount;   //To decide how big a board would be, to count how many blocks left on the board
    protected int winPoint;
    private String[][] board;       //To make a board
    private int x, y;               //To create the coordinate for a chess

    protected String chessLabel;
    private String winner;
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

    //print out an empty board
    public void printBoard(Player p1,Player p2)
    {

        if(gameIsOn)
        {
            //show all chess
            System.out.println("Welcome "+p1.getName()+" and "+p2.getName()+". Enjoy your game!!");
            showBoard();

        }
        else {

            //New chess board
            System.out.println("Hi, "+p1.getName()+" and "+p2.getName()+" . Here is your new chess board:");
            brandnewBoard();
            showBoard();
        }
    }

    //Create an empty two dimentional array
    public void brandnewBoard()
    {

        for(int i = 0; i<this.rowAndCol; i++)
            for(int j =0; j<this.rowAndCol; j++)
                board[i][j]=(" ");
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



    //To check whether a game should begin again
    public void gameRestart(Player playerCheck,Player otherPlayer)
    {
        String s=JOptionPane.showInputDialog("Do you players want to restart the game?(Y/N)");
        if(s.toLowerCase().equals("n"))
        {
            gameIsOn = false;      //No winner and no blocks left, game stops.
            gameRestart = true;      //No winner and no blocks left, game needed to restart.
            JOptionPane.showMessageDialog(null,"Game is over!"+
                    "\n"+playerCheck.getName()+" won "+playerCheck.winPoint+" times."+
                    "\n"+otherPlayer.getName()+" won "+otherPlayer.winPoint+" times.");
        }
    }



    //If here is a winner,show winner's name on the board
    //or show game is even, and print
    public void showGameResult(Player playerCheck,Player otherPlayer)
    {
            gameIsOn = false;        //Got a winner, game stops.
            playerCheck.winPoint++;

            JOptionPane.showMessageDialog(null, "Congratulation, winner is: " + winner
                    + "\n" + winner + " won " + playerCheck.winPoint + " times." + "\n" +
                    otherPlayer.getName() + " won " + otherPlayer.winPoint + " times.");

            gameRestart(playerCheck,otherPlayer);

    }

    //Create a chess coordinate and place  the  chess  on board
    public void placeChess(Player p)
    {
        if(p.getPlayerIsMachine())
        {
            Random r = new Random();
            p.setX(r.nextInt(p.getRowAndCol()));
            p.setY(r.nextInt(p.getRowAndCol()));
        }else {
            p.setChessCoordinateX();
            p.setChessCoordinateY();
        }
        while (!(this.board[p.getX()][p.getY()].equals(" ") || this.board[p.getX()][p.getY()].isEmpty()))
        {
            if(p.getPlayerIsMachine())
            {
                Random r = new Random();
                p.setX(r.nextInt(p.getRowAndCol()));
                p.setY(r.nextInt(p.getRowAndCol()));
            }else {
                System.out.println(p.getName() + ", the block you chose is taken. Choose again!");
                p.setChessCoordinateX();
                p.setChessCoordinateY();
            }
        }
        this.board[p.getX()][p.getY()] = p.chessLabel;
        blockAmount--;
        //System.out.println(blockAmount);
    }





    //Scan the board to check who is the winner
    public void checkWinner(Player playerCheck,Player otherPlayer)
    {
        horizontallyCheck(playerCheck,otherPlayer);             // Check board in the direction of -
        verticallyCheck(playerCheck,otherPlayer);               // Check board in the direction of |
        diagonallyCheckBackslash(playerCheck,otherPlayer);      // Check board in the direction of \
        diagonallyCheckSlash(playerCheck,otherPlayer);          // Check board in the direction of /

        if((playerCheck.getBlockAmount()==0))
        {
            gameIsOn = false;
            JOptionPane.showMessageDialog(null, "All blocks are used up, No winner this round!"
                    + "\n" + playerCheck.getName() + " won " + playerCheck.winPoint + " times." + "\n" +
                    otherPlayer.getName() + " won " + otherPlayer.winPoint + " times.");

            gameRestart(playerCheck,otherPlayer);
        }
    }



    //To check whether player wins horizontally
    public void horizontallyCheck(Player playerCheck,Player otherPlayer)
    {
        int i=0;
        while(i<board.length)
        {
            int k=0;
            for(int j=0;j<board.length;j++) {
                if (board[i][j].equals(playerCheck.chessLabel)) {
                    k++;
                } else {
                    break;
                }

            }
            if(k==board.length)
            {
                this.winner = playerCheck.getName(); //To judge whether here is a winner or not
                showGameResult(playerCheck,otherPlayer);
                break;
            }else {

                break;
            }

            i++;
        }

    }

    //To check whether player wins vertically
    public void verticallyCheck(Player playerCheck,Player otherPlayer)
    {
        int j=0;
        while(j<board.length)
        {
            int k = 0;
            for(int i=0;i<board.length;i++){
                if(board[i][j].equals(playerCheck.chessLabel))
                {
                    k++;
                }else
                {
                    break;
                }
            }
            if(k==board.length)
            {
                winner = playerCheck.getName();     //To judge whether here is a winner or not
                showGameResult(playerCheck,otherPlayer);
                break;
            }
            j++;
        }
    }

    //To check whether player wins diagonally, slash
    public void diagonallyCheckBackslash(Player playerCheck,Player otherPlayer)
    {
        int k=0;
        for(int i=0;i<board.length;i++)
        {
            if(board[i][i].equals(playerCheck.chessLabel))
            {
                k++;
                if(k==board.length)
                {
                    winner = playerCheck.getName(); //To judge whether here is a winner or not
                    showGameResult(playerCheck,otherPlayer);
                    break;
                }
            }else
            {
                break;
            }
        }
    }

    //To check whether player wins diagonally, backslash
    public void diagonallyCheckSlash(Player playerCheck,Player otherPlayer)
    {
        int k=0;
        for(int i=0;i<board.length;i++)
        {
            if(board[i][board.length-1-i].equals(playerCheck.chessLabel))
            {
                k++;
                if(k==board.length)
                {
                    winner = playerCheck.getName(); //To judge whether here is a winner or not
                    showGameResult(playerCheck,otherPlayer);
                    break;
                }
            }else
            {
                break;
            }
        }

    }

    public int getRowAndCol()
    {
        return rowAndCol;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
}
