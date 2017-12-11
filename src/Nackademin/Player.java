package Nackademin;

import javax.swing.*;

public class Player extends Board{

    private String name;


    public Player(int rowAndCol)
    {
        super(rowAndCol);
    }
    public Player()
    {

    }

    public void setName()
    {
        String s = JOptionPane.showInputDialog("Input player's name here please");
        this.name = s;
    }

    public String getName()
    {
        return name;
    }

    public void setChessLabel()
    {
        String s = JOptionPane.showInputDialog("Hi, "+ this.name + ". Input your chess label");
        this.chessLabel = s;
    }


    public void setChessCoordinateX()
    {
        String s = JOptionPane.showInputDialog("Hi "+ this.name + " ,your turn to input your chess coordinate x:");
        x = Integer.parseInt(s);
        this.x = x-1;
    }


    public void setChessCoordinateY()
    {
        String s = JOptionPane.showInputDialog("And "+ this.name + " ,continue to input your chess coordinate y:");
        y = Integer.parseInt(s);
        this.y = y-1;
    }


}
