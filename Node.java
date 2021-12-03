package api;

import java.awt.*;

public class Node implements NodeData{
    private int _key;
    private GEO_Location _location;
    private  double _weight;
    private String _info;
    private int _tag;

    public Node(int key) {
    this._key = key;
    this._location = null;
    this._weight = 0;
    this._info = "";
    this._tag = 0;
    }

    @Override
    public int getKey() {
        return _key;
    }
    
    @Override
    public GeoLocation getLocation() {
        return _location;
    }

    @Override
    public void setLocation(GeoLocation l) {
        this._location = l;
    }

    @Override
    public double getWeight() {
        return _weight;
    }

    @Override
    public void setWeight(double w) {
        this._weight = w;
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
