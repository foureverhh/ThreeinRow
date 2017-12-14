package Nackademin;

import javax.swing.*;
import java.util.Random;

public class MachinePlayer extends Player{

    private boolean playerIsMachine;


    public MachinePlayer(int a)
    {
        super(a);
    }

    public MachinePlayer()
    {

    }

 /*public void setName(String s)
    {
        s = JOptionPane.showInputDialog("Want to play with a Machine player?(y/n)");
        if(s.toLowerCase().equals("y"))
        {
            this.name = "Machine";
            this.playerIsMachine = true;
        }
        else{
            s = JOptionPane.showInputDialog("Input player2's name here please");
            this.name = s;
        }

    }

    @Override
    public void setChessLabel(String s)
    {
        if(playerIsMachine)
        {
            s = JOptionPane.showInputDialog("Input chess label for Machine player:");
            this.chessLabel = s;
        }else
        {
            s = JOptionPane.showInputDialog("Input chess label for player2:");
            this.chessLabel = s;
        }
    }

    @Override
    public void setChessCoordinateX()
    {
        if(playerIsMachine)
        {
            x = randomMove();
        }else
        {
            super.setChessCoordinateX();
        }

    }

    @Override
    public void setChessCoordinateY()
    {
        if(playerIsMachine)
        {
           y = randomMove();
        }else{
            super.setChessCoordinateY();
        }

    }

    //Get a random place
    public int randomMove()
    {
        Random r = new Random();
        int chessPlace = r.nextInt(this.getRowAndCol())+1;
        return chessPlace;
    }

    public boolean getPlayerIsMachine()
    {
        return playerIsMachine;
    }
    */

}
