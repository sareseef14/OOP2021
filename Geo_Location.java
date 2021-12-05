package api;

public class Geo_Location implements GeoLocation{

    private double _x;
    private double _y;
    private double _z;

    public Geo_Location(double x, double y,double z) {

        this._x=x;
        this._y=y;
        this._z=z;

    }

    @Override
    public double x() {
        return _x;
    }

    @Override
    public double y() {
        return _y;
    }

    @Override
    public double z() {
        return _z;
    }

    @Override
    public double distance(GeoLocation g) {
        return dist(g);
    }
    private double dist(GeoLocation g){
        double dist_x = Math.pow((g.x() - _x), 2);
        double dist_y = Math.pow((g.y() - _y), 2);
        double dist_z = Math.pow((g.z() - _z), 2);
        double dist_all = dist_x + dist_y + dist_z;

        return Math.sqrt(dist_all);
    }

}
