package Nackademin;

import javax.swing.*;

public class Player extends Board{

    private String name;


    public Player()
    {

    }

    public void setName()
    {
        String s = JOptionPane.showInputDialog("Input player's name here please");
        this.name = s;
    }

    public void setChessLabel()
    {
        String s = JOptionPane.showInputDialog("Hi, "+ this.name + ". Input your chess label");
        this.chessLabel = s;
    }


    public void setChessCoordinate(int x,int y,String chessLabel)
    {
        super.placeChess(x,y,chessLabel);
    }





    public void setChessCoordinateX()
    {
        String s = JOptionPane.showInputDialog("Hi "+ this.name + ",your turn input your chess coordinate x:");
        x = Integer.parseInt(s);
        super.setX(x);
    }


    public void setChessCoordinateY()
    {
        String s = JOptionPane.showInputDialog("And "+ this.name + "your chess coordinate y:");
        x = Integer.parseInt(s);
        super.setY(y);
        this.gameIsOn =true;
    }


}
