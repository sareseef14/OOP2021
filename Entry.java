package api;

import java.util.Comparator;

public class Entry implements Comparable<Entry>
{

    final int BIGGER = 1;
    final int EQUAL = 0;
    final int SMALLER = -1;

    private NodeData _n;
    private double _distance;

    public Entry(NodeData node, double distance)
    {
        this._distance = distance;
        this._n = node;
    }

    public NodeData getNode()
    {
        return this._n;
    }

    public double getdistance()
    {
        return this._distance;
    }

    public void setdistance(double dis)
    {
        this._distance = dis;
    }

    @Override
    public int compareTo(Entry other)
    {
        if (this._distance < other._distance)
        {
            return BIGGER;

        }
        else if (this._distance > other._distance)
        {
            return SMALLER;
        }
        else
        {
            return EQUAL;
        }


    }

}