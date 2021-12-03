package api;

import javax.swing.*;
import java.awt.*;

public class Edge implements EdgeData{

    private Node _src;
    private Node _dst;
 
    // have to be a positive value!
    private double _weight;
 
    //string represent the details of Edge and the Tag of the Node
    //just look of node.getTag if this method return
    private String _info; //""+ src +"" +dest +""+ Weight +"" + node.getTag() + ""
    
    private int _tag;

    public Edge(Node src, Node dest, double weight) {
        this._src = src;
        this._dst = dst;
        this._weight = weight;
        this._tag = 0;
        this._info = "";
    }
    
    @Override
    public int getSrc() {
        return _src.getKey();
    }
    
    @Override
    public int getDest() {
        return _dst.getKey();
    }
   
    @Override
    public double getWeight() {
        return _weight;
    }

    @Override
    public String getInfo() {
        return _info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }
 
    @Override
    public int getTag() {
        return _tag;
    }

    @Override
    public void setTag(int t) {
        this._tag = t;
    }
}
