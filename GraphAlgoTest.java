package api;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphAlgoTest {



    @Test
    void init()
    {
        DirectedWeightedGraphAlgorithms init = new GraphAlgo();
        Graph G3 = new Graph();
        Node n31 = new Node(1);
        Node n32 = new Node(2);
        Node n33 = new Node(3);
        Node n34 = new Node(4);
        Node n35 = new Node(5);
        G3.addNode(n31);
        G3.addNode(n32);
        G3.addNode(n33);
        G3.addNode(n34);
        G3.addNode(n35);
        G3.connect(1,2,0.5);
        G3.connect(2,3,2.5);
        G3.connect(3,1,4.5);
        G3.connect(3,4,0.5);
        G3.connect(4,5,2);
        G3.connect(5,1,6.5);
       init.init(G3);
       assertEquals(init,null);
    }

    @Test
    void getGraph()
    {
        Graph h5 = new Graph();
        DirectedWeightedGraphAlgorithms algorithms = new GraphAlgo();

        Node n51=new Node(1);
        Node n52= new Node(2);
        Node n53= new Node(3);
        Node n54= new Node(4);
        Node n55= new Node(5);
        h5.addNode(n51);
        h5.addNode(n52);
        h5.addNode(n53);
        h5.addNode(n54);
        h5.addNode(n55);
        h5.connect(1,2,0.5);
        h5.connect(2,1,0.5);
        h5.connect(2,3,1.5);
        h5.connect(2,4,0.5);
        h5.connect(2,5,20.5);
        h5.connect(3,4,0.5);
        h5.connect(4,5,0.5);
        h5.connect(5,1,2000.5);
        algorithms.init(h5);
        assertTrue(algorithms.getGraph() != null);
    }

    @Test
    void copy()
    {
        DirectedWeightedGraphAlgorithms init = new GraphAlgo();
        DirectedWeightedGraphAlgorithms in = new GraphAlgo();
        Graph h5 = new Graph();
        Node n51=new Node(1);
        Node n52= new Node(2);
        Node n53= new Node(3);
        Node n54= new Node(4);
        Node n55= new Node(5);
        h5.addNode(n51);
        h5.addNode(n52);
        h5.addNode(n53);
        h5.addNode(n54);
        h5.addNode(n55);
        h5.connect(1,2,0.5);
        h5.connect(2,1,0.5);
        h5.connect(2,3,1.5);
        h5.connect(2,4,0.5);
        h5.connect(2,5,20.5);
        h5.connect(3,4,0.5);
        h5.connect(4,5,0.5);
        h5.connect(5,1,2000.5);

        init.init(h5);
        in.copy();
        assertFalse(init == null );
        assertFalse(in == null);
    }

    @Test
    void isConnected()
    {

        DirectedWeightedGraph G = new Graph();
        DirectedWeightedGraphAlgorithms init = new GraphAlgo();

        Node n1=new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        G.addNode(n1);
        G.addNode(n2);
        G.addNode(n3);
        G.addNode(n4);
        G.addNode(n5);
        G.connect(1,2,0.5);
        G.connect(2,4,2);
        G.connect(3,1,1.5);
        G.connect(3,2,1);
        G.connect(3,4,2.5);
        G.connect(4,3,3);
        G.connect(4,5,3.5);

        init.init(G);
        assertTrue(init.isConnected() == false);


    }

    @Test
    void shortestPathDist()
    {
        DirectedWeightedGraphAlgorithms algorithms = new GraphAlgo();
        Graph G4 = new Graph();
        Node n41 = new Node(1);
        Node n42 = new Node(2);
        Node n43 = new Node(3);
        Node n44 = new Node(4);
        Node n45 = new Node(5);
        G4.addNode(n41);
        G4.addNode(n42);
        G4.addNode(n43);
        G4.addNode(n44);
        G4.addNode(n45);
        //G4.connect(1,2,0.5);
        //G4.connect(1,3,10.5);
        G4.connect(2,3,2.5);
        //G4.connect(3,1,4.5);
        G4.connect(3,4,0.5);
        G4.connect(3,5,8.5);
        G4.connect(4,5,2);
        //G4.connect(5,1,6.5);
        G4.connect(5,2,9);
        G4.connect(5,4,7);
        algorithms.init(G4);
        double shortPath1 = algorithms.shortestPathDist(0,10);
        assertTrue(0==shortPath1);

    }

    @Test
    void shortestPath()
    {
        Graph l2 = new Graph();
        DirectedWeightedGraphAlgorithms n =new GraphAlgo();
        n.init(l2);
        Node n316 = new Node(1);
        Node n326 = new Node(2);
        Node n336 = new Node(3);
        Node n346 = new Node(4);
        Node n356 = new Node(5);
        l2.addNode(n316);
        l2.addNode(n326);
        l2.addNode(n336);
        l2.addNode(n346);
        l2.addNode(n356);
        l2.connect(1,2,8);
        l2.connect(2,3,8);
        l2.connect(3,4,8);
        l2.connect(4,5,8);

        List<NodeData> path = new LinkedList<>();
        List<NodeData> list = new LinkedList<>();
        Iterator<NodeData> it ;
        it = l2.nodeIter();
        while (it.hasNext())
        {
            path.add(it.next());
        }
        list = n.shortestPath(1,2);
        it = list.iterator();
        assertEquals(it.next().getKey(),1);
    }

    @Test
    void center()
    {
        DirectedWeightedGraphAlgorithms init = new GraphAlgo();

        Graph ha5 = new Graph();
        Node j51 =new Node(1);
        Node j52 = new Node(2);
        Node j53 = new Node(3);
        Node j54 = new Node(4);
        Node j55 = new Node(0);
        ha5.addNode(j51);
        ha5.addNode(j52);
        ha5.addNode(j53);
        ha5.addNode(j54);
        ha5.addNode(j55);
        ha5.connect(1,2,0.5);
        ha5.connect(2,0,0.5);
        ha5.connect(0,1,1.5);
        ha5.connect(2,3,1.5);
        ha5.connect(3,4,0.5);
        ha5.connect(4,1,0.5);


        init.init(ha5);
        NodeData cent = init.center();
        assertEquals( cent.getKey() ,2);
    }

    @Test
    void tsp()
    {
        Graph l2 = new Graph();
        DirectedWeightedGraphAlgorithms n =new GraphAlgo();
        n.init(l2);
        Node n316 = new Node(1);
        Node n326 = new Node(2);
        Node n336 = new Node(3);
        Node n346 = new Node(4);
        Node n356 = new Node(5);
        l2.addNode(n316);
        l2.addNode(n326);
        l2.addNode(n336);
        l2.addNode(n346);
        l2.addNode(n356);
        l2.connect(1,2,8);
        l2.connect(2,3,8);
        l2.connect(3,4,8);
        l2.connect(4,5,8);


        List<NodeData> cities = new LinkedList<>();
        List<NodeData> list = new LinkedList<>();
        Iterator<NodeData> it ;
        it = l2.nodeIter();
        while (it.hasNext())
        {
            cities.add(it.next());
        }
        list = n.tsp(cities);
        it = list.iterator();
        assertEquals(it.next().getKey(),1);



    }


}