package api;

public class Node implements NodeData{


    private int _key;
    private Geo_Location _location;
    private  double _weight;
    private String _info;
    private int _tag;


    public Node(int key) {
        this._key = key;
       this._location = null; //new Geo_Location(0.0,0.0,0.0);
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
        if(_location!=null){
            return _location;
        }
        return null;
    }


    @Override
    public void setLocation(GeoLocation p) {

       this._location=new Geo_Location(p.x(),p.y(), p.z());
    }


    @Override
    public double getWeight() {
        return _weight;
    }


    @Override
    public void setWeight(double w) {
    this._weight=w;
    }

    @Override
    public String getInfo() {
        return _info;
    }
    @Override
    public void setInfo(String s) {
    this._info=s;
    }

    @Override
    public int getTag() {
        return _tag;
    }

    @Override
    public void setTag(int t) {
    this._tag=t;
    }

}
