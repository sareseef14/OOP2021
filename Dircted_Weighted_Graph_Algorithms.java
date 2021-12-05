package api;

import java.util.List;

//collection of imports to json
//import com.google.gson.GsonBuilder;
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonArray;

public class Dircted_Weighted_Graph_Algorithms implements DirectedWeightedGraphAlgorithms{

    //object to initialization
    private DirectedWeightedGraph _a;

    //public Dircted_Weighted_Graph_Algorithms() {
  //  }

    @Override
    public void init(DirectedWeightedGraph g) {
        _a=g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return null;
    }

    @Override
    public DirectedWeightedGraph copy() {
        return null;
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {

      //JsonObject jsonObject=new JspnObject();









        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
