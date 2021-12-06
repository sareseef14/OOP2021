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

        GraphAlgo algos = new GraphAlgo();
        algos.init(G);

        //GraphAlgo newAlgo = new GraphAlgo();
        Graph copiOfG = (Graph)algos.copy();





        G.printNodes();
        System.out.println();
        G.printEdeges();
        System.out.println("Edges number : " + G.edgeSize());
        System.out.println("Nodes  number : " + G.nodeSize());

        System.out.println();
        // remove edge 3-->1
        G.removeEdge(3, 1);
        G.printNodes();
        System.out.println();
        G.printEdeges();
        System.out.println("Edges number : " + G.edgeSize());
        System.out.println("Nodes  number : " + G.nodeSize());

        // delete node3
        NodeData re1 = G.removeNode(3);
        G.printNodes();
        System.out.println();
        G.printEdeges();
        System.out.println("Edges number : " + G.edgeSize());
        System.out.println("Nodes  number : " + G.nodeSize());

        System.out.println();

        // delete edge4_5
        EdgeData re2 = G.removeEdge(4,5);
        G.printNodes();
        System.out.println();
        G.printEdeges();
        System.out.println("Edges number : " + G.edgeSize());
        System.out.println("Nodes  number : " + G.nodeSize());

        System.out.println();

        Iterator<EdgeData> iter = G.edgeIter();
        while(iter.hasNext())
        {
            EdgeData ed = iter.next();
            int src = ed.getSrc();
            int dst = ed.getDest();
            double w = ed.getWeight();
            System.out.println(src + "---(" + w + ")--> " + dst);
        }


        //---------------print grapg like first lines -----------------
        copiOfG.printNodes();
        System.out.println();
        copiOfG.printEdeges();
        System.out.println("Edges number : " + copiOfG.edgeSize());
        System.out.println("Nodes  number : " + copiOfG.nodeSize());

//        //System.out.println(src + "---(" + w + ")--> " + dst);



















    }
}
