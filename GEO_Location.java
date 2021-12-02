package api;

public class GEO_Location implements GeoLocation{

    private double x;
    private double y;
    private double z;

    public GEO_Location(double x,double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;

    }

    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }

    @Override
    public double z() {
        return z;
    }

    @Override
    public double distance(GeoLocation g) {
        return dist(g);
    }
    private double dist(GeoLocation g){
        double dist_x=Math.pow((g.x()-x),2);
        double dist_y=Math.pow((g.y()-y),2);
        double dist_z=Math.pow((g.z()-z),2);
        double dist_all=dist_x+dist_y+dist_z;

            return Math.sqrt(dist_all);
    }


}
