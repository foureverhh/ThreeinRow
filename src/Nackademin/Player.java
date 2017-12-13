package Nackademin;

import javax.swing.*;

public class Player extends Board{

    protected String name;


    public Player(int rowAndCol)
    {
        super(rowAndCol);
    }

    public Player()
    {

    }

    public void setName(String s)
    {
        s = JOptionPane.showInputDialog("Input player 1's name here please");
        this.name = s;
    }

    public String getName()
    {
        return name;
    }

    public void setChessLabel(String s)
    {
         s = JOptionPane.showInputDialog("Hi, "+ this.name + ". Input your chess label");
         chessLabel = s;
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
