package api;

import java.security.Key;
import java.util.Iterator;
import java.util.List;

public class GraphAlgo implements DirectedWeightedGraphAlgorithms{

    private DirectedWeightedGraph _g ;


    @Override
    public void init(DirectedWeightedGraph g)
    {
         this._g = g;
    }

    @Override
    public DirectedWeightedGraph getGraph()
    {
        return _g;
    }

    @Override
    public DirectedWeightedGraph copy()
    {
        // create a new graph
        DirectedWeightedGraph newG = new Graph();

        // copy all nodes
        Iterator<NodeData> itrN = _g.nodeIter();
        while (itrN.hasNext())
        {
           NodeData toCopy = itrN.next();
           int key = toCopy.getKey();
            NodeData newN = new Node(key);
           if(toCopy.getLocation() != null)
           {
                GeoLocation newGl = new Geo_Location(toCopy.getLocation().x(), toCopy.getLocation().y(), toCopy.getLocation().z());
                newN.setLocation(newGl);
           }
           else
           {
               newN.setLocation(null);
           }
           double newW = toCopy.getWeight();
           String Info = toCopy.getInfo();
           int tag = toCopy.getTag();
           newN.setWeight(newW);
           newN.setInfo(Info);
           newN.setTag(tag);
           newG.addNode(newN);
        }

        // copy all Edges
        Iterator<EdgeData> iterE = _g.edgeIter();
        while (iterE.hasNext())
        {
            EdgeData e = iterE.next();
            newG.connect(e.getSrc(), e.getDest(),e.getWeight());
        }

        return newG;
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
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
