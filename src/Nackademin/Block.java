package Nackademin;

import java.util.ArrayList;

public class Block extends Board{

    private ArrayList<String> blockLabel;

    public Block(int rowAndCol)
    {
        super(rowAndCol);
    }
/*
* public void setBlockLabel()
    {
        blockLabel = new ArrayList<String>();

        for(int i = 0; i<super.getRowAndCol(); i++)
            for(int j =0; j<super.getRowAndCol(); j++)
                blockLabel.add(board[i][j]);
    }

    public String toString ()
    {
        System.out.println("Element in blockLabel are: ");
        String str ="";
        for(String s:blockLabel)
            str+=s;
        return str+"  ";
    }*/




}
