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
            p1.setChessCoordinateX();
            p1.setChessCoordinateY();

            p1.placeChess(p1);
            p1.printBoard(p1,p2);
            p1.leftBlockAmount();

            p2.setChessCoordinateX();
            p2.setChessCoordinateY();

            p1.placeChess(p2);
            p1.printBoard(p1,p2);
            p1.leftBlockAmount();
        }
        /*
        while (!p1.needNewBoard) {
            while (!p1.blockIsTaken) {

                //Player 1 puts a chess on the board
                p1.setChessCoordinateX();
                p1.setChessCoordinateY();

                p1.placeChess(p1);
                p1.printBoard();

                //Player 2 puts a chess on the board
                p2.setChessCoordinateX();
                p2.setChessCoordinateY();

                p1.placeChess(p2);
                p1.printBoard();


            }
            p1.leftBlockAmount();
        }
        */

/*
//To ask player whether to create a new game
            String newGame = JOptionPane.showInputDialog("Do you want to start a new game? (Y/N)");
            if (newGame.toLowerCase().equals("n"))
            {
                p1.gameRestart = false;
                System.out.println("Bye Bye!");
            }else{
                p1.needNewBoard = true;
                System.out.println("New game begin");
            }
            */
    }
}
