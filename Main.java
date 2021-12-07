package api;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Graph G = new Graph();
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

        G.printNodes();
        System.out.println();
        G.printEdeges();
        System.out.println("Edges number : " + G.edgeSize());
        System.out.println("Nodes  number : " + G.nodeSize());
        System.out.println();

        //-----------check connected----------------
        DirectedWeightedGraphAlgorithms algorithms = new GraphAlgo();
        algorithms.init(G);
        boolean isConnectedGraph = algorithms.isConnected();
        System.out.println("connected? " + isConnectedGraph);


        Graph G2 = new Graph();
        Node n21 = new Node(1);
        Node n22 = new Node(2);
        Node n23 = new Node(3);

        G2.addNode(n21);
        G2.addNode(n22);
        G2.addNode(n23);
        G2.connect(1,2,0.5);
        G2.connect(2,3,0.5);
        G2.connect(3,1,0.5);
        algorithms.init(G2);
        G2.printNodes();
        G2.printEdeges();
        isConnectedGraph = algorithms.isConnected();
        System.out.println("connected? " + isConnectedGraph);







        Graph G3 = new Graph();
        Node n31 = new Node(1);
        Node n32 = new Node(2);
        Node n33 = new Node(3);
        Node n34 = new Node(4);
        Node n35 = new Node(5);
        System.out.println("-------------------------------------------------------------------------------------------------");
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
        algorithms.init(G3);
        G3.printNodes();
        G3.printEdeges();
        isConnectedGraph = algorithms.isConnected();
        System.out.println("connected?  " + isConnectedGraph);

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
        G4.connect(1,2,0.5);
        G4.connect(1,3,10.5);
        G4.connect(2,3,2.5);
        G4.connect(3,1,4.5);
        G4.connect(3,4,0.5);
        G4.connect(3,5,8.5);
        G4.connect(4,5,2);
        G4.connect(5,1,6.5);
        G4.connect(5,2,9);
        G4.connect(5,4,7);
        System.out.println("-------------------------------------------------------------------------------------------------");
        algorithms.init(G4);
        G4.printNodes();
        G4.printEdeges();
        isConnectedGraph = algorithms.isConnected();
        System.out.println("connected?  " + isConnectedGraph);


        //------------------------------------------


    }
}
