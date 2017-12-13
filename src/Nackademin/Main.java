package Nackademin;

import javax.swing.*;

public class Main
{

    public static void main(String[] args) {
        //Create board and players
        String s =JOptionPane.showInputDialog("Input how many rows you want to have:");
        int rowSize = Integer.parseInt(s);
        Player p1 = new Player(rowSize);
        Player p2 = new MachinePlayer(rowSize);

        s = "";

        p1.setName(s);
        p1.setChessLabel(s);
        p2.setName(s);
        p2.setChessLabel(s);

        while(!p1.gameRestart)
        {
            p1.printBoard(p1, p2);  //Print out a new empty chessboard

            p1.gameIsOn = true; // Game is moving further on

            while (p1.gameIsOn) {

                //Player 1 choose his/her own block and place the chess
                p1.placeChess1(p1);
                //Print out the current board
                p1.printBoard(p1, p2);
                //Check winner
                p1.checkWinner(p1, p2);
                if (!p1.gameIsOn)
                    break;

                //Player 2 choose his//her own block and place the chess
                p1.placeChess2(p2);
                //Print out the current board
                p1.printBoard(p1, p2);
                p1.checkWinner(p2, p1);
                if (!p1.gameIsOn)
                    break;

            }

        }
    }
}
