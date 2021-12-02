package api;

import java.awt.*;

public class Node implements NodeData{
    private int id;
    private int Tag;
    private  double Weight;
    GEO_Location location;

    public Node(int id, int Tag, double Weight) {
    this.id=id;
    this.location =new GEO_Location(getLocation().x(), getLocation().y(),getLocation().z());
    this.Tag=Tag;
    this.Weight=Weight;
    }

    @Override
    public int getKey() {
        return id;
    }

    @Override
    public void setLocation(GeoLocation p) {

        changeLocation(p);

    }
    private void changeLocation(GeoLocation p){
       //double new_x= p.x();
        // double new_y= p.y();
        //double new_z= p.z();



    }
    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public void setWeight(double w) {
    this.Weight=w;
    }

    @Override
    public String getInfo() {
        return  location +" "+id;
    }

    @Override
    public void setInfo(String s) {

    }
//Node take red
// Edge take black
//
    @Override
    public int getTag() {


        //return Tag;
        return 0;

    }

    @Override
    public void setTag(int t) {

    }

    @Override
    public GeoLocation getLocation() {
        return Location();
    }


    // if there null Null or something else
    private GeoLocation Location(){

        if(location==null) {

            return null;
        }
                return location;
    }
}
