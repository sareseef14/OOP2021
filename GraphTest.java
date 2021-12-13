package api;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest
{

    DirectedWeightedGraph graph =new Graph();
    NodeData n  = new Node(5);
    NodeData n1 = new Node(6);
    NodeData n2 = new Node(7);
    NodeData n3 = new Node(8);
    NodeData n4 = new Node(9);
    NodeData n5 = new Node(10);
    NodeData n6= new Node(11);
    NodeData n7= new Node(12);

    @Test
    void getNode()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        assertEquals(graph.getNode(5),n);
        assertEquals(graph.getNode(6),n1);
        assertEquals(graph.getNode(7),n2);


    }

    @Test
    void getEdge()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        //make new edge
       graph.connect(n.getKey(),n1.getKey(),9);
        EdgeData ed = new Edge(n,n1,8);

        //make new edge
        graph.connect(n2.getKey(),n3.getKey(),6);
        EdgeData ed2 = graph.getEdge(n2.getKey() , n3.getKey());

        // our check
        assertTrue(graph.getEdge( n.getKey() , n1.getKey() ).getSrc() + graph.getEdge( n.getKey() ,n1.getKey() ).getDest() == ed.getSrc() + ed.getDest() );
        assertFalse(graph.getEdge( n2.getKey() , n3.getKey() ).getSrc() + graph.getEdge( n2.getKey() ,n3.getKey() ).getDest() != ed2.getSrc() + ed2.getDest() );


    }

    @Test
    void addNode()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        assertEquals(graph.getNode(6),n1);
        assertEquals(graph.getNode(7),n2);

    }

    @Test
    void connect()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        //make new edge
        graph.connect(n.getKey(),n1.getKey(),9);
        EdgeData ed = new Edge(n,n1,8);

        //make new edge
        graph.connect(n2.getKey(),n3.getKey(),6);
        EdgeData ed2 = graph.getEdge(n2.getKey() , n3.getKey());

        // our check
        assertTrue(graph.getEdge( n.getKey() , n1.getKey() ).getSrc() + graph.getEdge( n.getKey() ,n1.getKey() ).getDest() == ed.getSrc() + ed.getDest() );
        assertFalse(graph.getEdge( n2.getKey() , n3.getKey() ).getSrc() + graph.getEdge( n2.getKey() ,n3.getKey() ).getDest() != ed2.getSrc() + ed2.getDest() );
    }

    @Test
    void nodeIter()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        Iterator<NodeData> Nitr = graph.nodeIter();
        int count = 0;

        while (Nitr.hasNext())
        {
            NodeData next = Nitr.next();
            count+=1;

        }

        assertTrue(graph.nodeSize() == count);


    }

    @Test
    void edgeIter()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        graph.connect(n1.getKey(), n2.getKey(), 4);
        graph.connect(n.getKey(), n3.getKey(), 4);


        Iterator<EdgeData> Eitr = graph.edgeIter();
        int count = 0;

        while (Eitr.hasNext())
        {
            EdgeData next = Eitr.next();
            count++;

        }

        assertTrue(graph.edgeSize() == count);

    }

    @Test
    void testEdgeIter()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        graph.connect(n.getKey(),n1.getKey(),9);
        graph.connect(n1.getKey(),n2.getKey(),7);
        graph.connect(n2.getKey(),n3.getKey(),4);

        Iterator<EdgeData> EdItr = graph.edgeIter();
        int num = 0;
        while (EdItr.hasNext())
        {
            EdgeData E1  = EdItr.next() ;
            num++;
        }

        assertTrue(num == graph.edgeSize() );



    }

    @Test
    void removeNode()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        graph.removeNode(n1.getKey());
        assertFalse(graph.nodeSize() == 4);
        assertTrue(graph.nodeSize() == 3);
    }

    @Test
    void removeEdge()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        graph.connect(n.getKey() , n1.getKey(),6);
        graph.connect(n2.getKey() , n3.getKey() , 7);
        graph.removeEdge(n2.getKey(),n3.getKey());

        assertTrue(graph.edgeSize() == 1);



    }

    @Test
    void nodeSize()
    {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        //Check  Before Remove
        int sizeB = graph.nodeSize();
        assertTrue( sizeB == 4 );

        //Check  After  Remove
        graph.removeNode(n.getKey());
        int sizeA = graph.nodeSize();
        assertTrue( sizeA == 3 );


    }

    @Test
    void edgeSize() {
        graph.addNode(n);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);
        graph.addNode(n6);
        graph.addNode(n7);

        

        graph.connect( n.getKey() , n1.getKey(),6);
        graph.connect( n2.getKey() , n3.getKey(),8);
        graph.connect( n4.getKey() , n5.getKey(),15);
        graph.connect( n6.getKey() , n7.getKey(),10);




        //Check  Before Remove
        int sizeB = graph.edgeSize();
        assertTrue( sizeB == 4 );

        //Check  After  Remove
        graph.removeEdge(n2.getKey(),n3.getKey());
        int sizeA = graph.edgeSize();
        assertTrue( sizeA == 3 );


    }

    @Test
    void getMC()
    {


    }
}