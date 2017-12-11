package Nackademin;

import javax.swing.*;

public class Main
{

    public static void main(String[] args) {
        //Create board and players
        Player p1 = new Player(2);
        Player p2 = new Player();

        p1.setName();
        p1.setChessLabel();
        p2.setName();
        p2.setChessLabel();

        p1.printBoard(p1,p2);  //Print out a new empty chessboard

        p1.gameIsOn = true; // Game is moving further on

        while(p1.gameIsOn)
        {

            //Player 1 choose his/her own block and place the chess
            p1.placeChess(p1);
            //Print out the current board
            p1.printBoard(p1,p2);
            //Check winner
            p1.horizontallyCheck(p1);

            //Player 2 choose his//her own block and place the chess
            p1.placeChess(p2);
            //Print out the current board
            p1.printBoard(p1,p2);

        }
    }
}
