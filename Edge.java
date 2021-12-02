package api;

import javax.swing.*;
import java.awt.*;

public class Edge implements EdgeData{

 private int src;
 private int dest ;
 private double Weight;
 private int Tag;
 private String Info;
    Node node;
/*
    constructor the details of parameters
    just you  need to check of initialization of 'Info'
    */
    public Edge(int src, int dest,double Weight) {
        this.src=src;
        this.dest=dest;
        this.Weight=Weight;
       // this.Tag=Tag; --------> these set him and don't delete we will do talk about him
        this.Info=" ";
    }
        //return the src
    @Override
    public int getSrc() {
        return src;
    }
    //return dest
    @Override
    public int getDest() {
        return dest;
    }
    //return weight, if this smallest from 0 then throw exception
    @Override
    public double getWeight() {
        if (Weight<0)
        {
            throw new ArithmeticException("The Weight is  Equal to Zero or Bigger Than ");
        }
        return Weight;
    }

    //string represent the details of Edge and the Tag of the Node
    //just look of node.getTag if this method return
    @Override
    public String getInfo() {
        return ""+ src +"" +dest +""+ Weight +"" + node.getTag() + "";
    }

    @Override
    public void setInfo(String s) {
    this.Info=s;
    }
    //there no idea what i need here ):
    @Override
    public int getTag() {
    return 0;
            //Color.getColor(Tag);
    }

    @Override
    public void setTag(int t) {
    this.Tag=t;
       }
}
