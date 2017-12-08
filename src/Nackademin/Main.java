package Nackademin;

public class Main {

    public static void main(String[] args) {

        //Create board and players

        Board board = new Board(4);
        Player p1   = new Player();
        Player p2   = new Player();

        p1.setName();
        p1.setChessLabel();
        p2.setName();
        p2.setChessLabel();

        p1.setChessCoordinateX();
        p1.setChessCoordinateY();
        p2.setChessCoordinateX();
        p2.setChessCoordinateY();

        board.printBoard();


    }
}
