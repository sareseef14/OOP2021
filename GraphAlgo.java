package api;

import java.util.*;

public class GraphAlgo implements DirectedWeightedGraphAlgorithms {
    final int WHITE = 0;
    final int GRAY = 1;
    final int BLACK = 2;
    private DirectedWeightedGraph _g;
    //  private static ArrayList<EdgeData>[] adj =new ArrayList[];//
    //private static ArrayList<EdgeData>[] tr =new ArrayList[];//

    @Override
    public void init(DirectedWeightedGraph g) {
        this._g = g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return _g;
    }

    @Override
    public DirectedWeightedGraph copy() {
        // create a new graph
        DirectedWeightedGraph newG = new Graph();

        // copy all nodes
        Iterator<NodeData> itrN = _g.nodeIter();
        while (itrN.hasNext()) {
            NodeData toCopy = itrN.next();
            int key = toCopy.getKey();
            NodeData newN = new Node(key);
            if (toCopy.getLocation() != null) {
                GeoLocation newGl = new Geo_Location(toCopy.getLocation().x(), toCopy.getLocation().y(), toCopy.getLocation().z());
                newN.setLocation(newGl);
            } else {
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
        while (iterE.hasNext()) {
            EdgeData e = iterE.next();
            newG.connect(e.getSrc(), e.getDest(), e.getWeight());
        }

        return newG;
    }

    //BFS by Gabriel nivash
    @Override
    public boolean isConnected()
    {
        int blackCounter = 0;
        if(_g.nodeSize() == 0) {return true;} // or false?

        DirectedWeightedGraph copyG = cleanColors(copy());

        Iterator<NodeData> iterN = copyG.nodeIter() ;

        while (iterN.hasNext())
        {
            NodeData startNode = iterN.next();

            // insert start node to queue
            Queue<NodeData> q = new LinkedList<NodeData>();
            q.add(startNode);

            while (!q.isEmpty())
            {
                NodeData u = q.remove();
                Iterator<EdgeData> itr = copyG.edgeIter(u.getKey());
                while (itr.hasNext())
                {
                    NodeData neighborOfU = copyG.getNode(itr.next().getDest());
                    if (neighborOfU.getTag() == WHITE)
                    {
                        neighborOfU.setTag(GRAY);
                        q.add(neighborOfU);
                    }
                }
                u.setTag(BLACK);
                blackCounter++;
            }
            if (_g.nodeSize() != blackCounter) {return false;}
            blackCounter = 0;
            cleanColors(copyG);
        }
        return true;
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

    private DirectedWeightedGraph cleanColors(DirectedWeightedGraph g)
    {
        Iterator<NodeData> itr = g.nodeIter();
        while (itr.hasNext())
        {
            NodeData node = itr.next();
            node.setTag(WHITE);
        }
        return g;
    }

}


