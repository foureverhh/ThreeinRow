package Nackademin;

import javax.swing.*;

public class Player extends Board{

    private String name;
    private boolean playerIsMachine;

    public Player(int rowAndCol)
    {
        super(rowAndCol);

    }

    public Player()
    {

    }

    public void setName()
    {
        this.name = JOptionPane.showInputDialog("Input player's name here please");

    }

    public void machinePlayer()
    {
        if (playerIsMachine)
        {
            this.name="Machine";
            this.chessLabel =JOptionPane.showInputDialog("Set chess label for Machine");
        }
    }
    public String getName()
    {
        return name;
    }

    public void setChessLabel()
    {
        this.chessLabel = JOptionPane.showInputDialog("Hi, "+ this.name + ". Input your chess label");

    }


    public void setChessCoordinateX()
    {

        String s = JOptionPane.showInputDialog("Hi "+ name + " ,your turn to input your chess coordinate x:");
        setX(Integer.parseInt(s)-1);

    }


    public void setChessCoordinateY()
    {
        String s = JOptionPane.showInputDialog("And "+ name + " ,continue to input your chess coordinate y:");
        setY(Integer.parseInt(s)-1);
    }

    public void setPlayerIsMachine(boolean playerIsMachine) {
        this.playerIsMachine = playerIsMachine;
    }

    public boolean getPlayerIsMachine() {
        return playerIsMachine;
    }

}
