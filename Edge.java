package api;

public class Edge implements  EdgeData{
    private int id;
    private int dest;
    private double Weight;
    private  String Info;
    private int Tag;


    public Edge(int id, int dest, double Weight, String Info,int Tag) {
        this.id = id;
        this.dest=dest;
        this.Weight=Weight;
        this.Info=Info;
        this.Tag=Tag;
    }

    @Override
    public int getSrc() {
        return id;
    }

    @Override
    public int getDest() {
        return dest;
    }

    @Override
    public double getWeight() {
        return Weight;
    }

    @Override
    public String getInfo() {
        return Info;
    }

    @Override
    public void setInfo(String s) {
        this.Info=s;
    }

    @Override
    public int getTag() {
        return Tag;
    }

    @Override
    public void setTag(int t) {
    this.Tag=t;
    }
}
