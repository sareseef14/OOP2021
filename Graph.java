package api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph implements DirectedWeightedGraph {

    private HashMap<Integer, NodeData> _nodes;
    private HashMap<Integer, HashMap<Integer, EdgeData>> _edges;
    private int _nodesCounter;
    private int _edgesCounter;
    private int _modeCounter;
    private ArrayList<EdgeData> _tempEdges;//


    public Graph()
    {

        this._nodes = new HashMap<Integer, NodeData>();
        this._edges = new HashMap<Integer, HashMap<Integer, EdgeData>>();
        this._edgesCounter = 0;
        this._modeCounter = 0;
        this._nodesCounter = 0;
        this._tempEdges = new ArrayList<EdgeData>();
    }

    @Override
    public NodeData getNode(int key)
    {
        return _nodes.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest)
    {
        return _edges.get(src).get(dest);
    }

    @Override
    public void addNode(NodeData n)
    {
        _nodes.put(n.getKey(), n);

        // make an infrastructure for adding new edge every edge his start from src node .
        HashMap<Integer, EdgeData> newHM = new HashMap<Integer, EdgeData>();
        _edges.put(n.getKey(), newHM);

        _nodesCounter++;

    }

    @Override
    public void connect(int src, int dest, double w)
    {
        NodeData srcNode = _nodes.get(src);
        NodeData dstNode = _nodes.get(dest);

        Edge newEdge = new Edge(srcNode, dstNode, w);

        _edges.get(src).put(dest, newEdge);


        _edgesCounter++;//to know of the number of the edges in graph:)
        _tempEdges.add(newEdge);//
    }

    @Override
    public Iterator<NodeData> nodeIter()
    {
        return _nodes.values().iterator();
    }

    // TODO
    @Override
    public Iterator<EdgeData> edgeIter()
    {
        return _tempEdges.iterator();//
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return _edges.get(node_id).values().iterator();
    }


    @Override
    public NodeData removeNode(int key)
    {
        NodeData ret = _nodes.remove(key);
        _nodesCounter = (ret != null) ? --_nodesCounter : _nodesCounter;

        // remove the edges that get out from key
        _edgesCounter -= _edges.get(key).size();
        _edges.remove(key);
        tempRemoveEdge(key);//

        // remove the edges that get in from key
        Iterator<HashMap<Integer, EdgeData>> iter = _edges.values().iterator();
        while (iter.hasNext()) {
            EdgeData e = iter.next().remove(key);
            _edgesCounter = (e != null) ? --_edgesCounter : _edgesCounter;
        }
        return ret;
    }

    @Override
    public EdgeData removeEdge(int src, int dest)
    {
        EdgeData ret = _edges.get(src).remove(dest);
        _edgesCounter = (ret != null) ? --_edgesCounter : _edgesCounter;

        tempRemoveEdge(src, dest);//
        return ret;
    }

    @Override
    public int nodeSize()
    {
        return _nodesCounter;
    }

    @Override
    public int edgeSize()
    {
        return _edgesCounter;
    }

    @Override
    public int getMC() {
        return _modeCounter;
    }


    //---------------- to delete ------------
    public void printNodes()
    {
        Iterator<NodeData> itr = nodeIter();
        while (itr.hasNext())
        {
            NodeData n = itr.next();
            System.out.print(n.getKey() + " ");
        }
    }


    public void printEdeges()
    {
        Iterator<NodeData> itrN = nodeIter();
        while (itrN.hasNext())
        {
            Iterator<EdgeData> itrE = edgeIter(itrN.next().getKey());
            while(itrE.hasNext())
            {
                EdgeData e = itrE.next();
                int src = e.getSrc();
                int dst = e.getDest();
                double w = e.getWeight();

                System.out.println(src + "---(" + w + ")--> " + dst);
            }
        }
    }

    private void tempRemoveEdge(int s)//
    {

        Iterator<EdgeData> itr = _tempEdges.iterator();
        while(itr.hasNext())
        {
            EdgeData e = itr.next();
            int srcE = e.getSrc();
            int dstE = e.getDest();
            if(srcE == s || dstE == s)
            {
                itr.remove();
            }
        }
    }

   private void tempRemoveEdge(int s , int d)//
    {
       for(int i = 0 ; i < _tempEdges.size() ; i++)
       {
           if ((_tempEdges.get(i).getSrc() == s) && (_tempEdges.get(i).getDest() == d))
           {
               _tempEdges.remove(i);
               break;
           }
       }
    }
}