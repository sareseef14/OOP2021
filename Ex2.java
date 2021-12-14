import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.GraphAlgo;
import api.NodeData;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * This class is the main class for Ex2 - your implementation will be tested using this class.
 */
public class Ex2
{
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraph getGrapg(String json_file) throws IOException {
        DirectedWeightedGraphAlgorithms algorithms = new GraphAlgo();
        algorithms.load(json_file);
        DirectedWeightedGraph ans = algorithms.getGraph();
        return ans;
    }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) throws IOException {
        DirectedWeightedGraphAlgorithms ans = new GraphAlgo();
        ans.init(getGrapg(json_file));
        return ans;
    }

    /**
     * This static function will run your GUI using the json fime.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) throws IOException {
        DirectedWeightedGraphAlgorithms alg = getGrapgAlgo(json_file);
        // ****** Add your code here ******
        //
        // ********************************
    }

    public static void main(String[] args) throws IOException {
//        Graph G = new Graph();
//        Node n1=new Node(1);
//        Node n2= new Node(2);
//        Node n3= new Node(3);
//        Node n4= new Node(4);
//        Node n5= new Node(5);
//        G.addNode(n1);
//        G.addNode(n2);
//        G.addNode(n3);
//        G.addNode(n4);
//        G.addNode(n5);
//        G.connect(1,2,0.5);
//        G.connect(2,4,2);
//        G.connect(3,1,1.5);
//        G.connect(3,2,1);
//        G.connect(3,4,2.5);
//        G.connect(4,3,3);
//        G.connect(4,5,3.5);
//
//        G.printNodes();
//        System.out.println();
//        G.printEdeges();
//        System.out.println("Edges number : " + G.edgeSize());
//        System.out.println("Nodes  number : " + G.nodeSize());
//        System.out.println();
//
//        //-----------check connected----------------
//        DirectedWeightedGraphAlgorithms algorithms = new GraphAlgo();
//        algorithms.init(G);
//        boolean isConnectedGraph = algorithms.isConnected();
//        System.out.println("connected? " + isConnectedGraph);
//
//
//        Graph G2 = new Graph();
//        Node n21 = new Node(1);
//        Node n22 = new Node(2);
//        Node n23 = new Node(3);
//
//        G2.addNode(n21);
//        G2.addNode(n22);
//        G2.addNode(n23);
//        G2.connect(1,2,0.5);
//        G2.connect(2,3,0.5);
//        G2.connect(3,1,0.5);
//        algorithms.init(G2);
//        G2.printNodes();
//        G2.printEdeges();
//        isConnectedGraph = algorithms.isConnected();
//        System.out.println("connected? " + isConnectedGraph);
//
//
//
//
//
//
//
//        Graph G3 = new Graph();
//        Node n31 = new Node(1);
//        Node n32 = new Node(2);
//        Node n33 = new Node(3);
//        Node n34 = new Node(4);
//        Node n35 = new Node(5);
//        System.out.println("-------------------------------------------------------------------------------------------------");
//        G3.addNode(n31);
//        G3.addNode(n32);
//        G3.addNode(n33);
//        G3.addNode(n34);
//        G3.addNode(n35);
//        G3.connect(1,2,0.5);
//        G3.connect(2,3,2.5);
//        G3.connect(3,1,4.5);
//        G3.connect(3,4,0.5);
//        G3.connect(4,5,2);
//        G3.connect(5,1,6.5);
//        algorithms.init(G3);
//        G3.printNodes();
//        G3.printEdeges();
//        isConnectedGraph = algorithms.isConnected();
//        System.out.println("connected?  " + isConnectedGraph);
//
//        Graph G4 = new Graph();
//        Node n41 = new Node(1);
//        Node n42 = new Node(2);
//        Node n43 = new Node(3);
//        Node n44 = new Node(4);
//        Node n45 = new Node(5);
//        G4.addNode(n41);
//        G4.addNode(n42);
//        G4.addNode(n43);
//        G4.addNode(n44);
//        G4.addNode(n45);
//        //G4.connect(1,2,0.5);
//        //G4.connect(1,3,10.5);
//        G4.connect(2,3,2.5);
//        //G4.connect(3,1,4.5);
//        G4.connect(3,4,0.5);
//        G4.connect(3,5,8.5);
//        G4.connect(4,5,2);
//        //G4.connect(5,1,6.5);
//        G4.connect(5,2,9);
//        G4.connect(5,4,7);
//        System.out.println("-------------------------------------------------------------------------------------------------");
//        algorithms.init(G4);
//        G4.printNodes();
//        G4.printEdeges();
//        isConnectedGraph = algorithms.isConnected();
//        System.out.println("connected?  " + isConnectedGraph);
//
//        double shortPath = algorithms.shortestPathDist(1,1); // not good for 4,1
//        System.out.println("Shortest path 1--->1: " + shortPath);
//        shortPath = algorithms.shortestPathDist(1,2); // not good for 4,1
//        System.out.println("Shortest path 1--->2: " + shortPath);
//        shortPath = algorithms.shortestPathDist(1,3); // not good for 4,1
//        System.out.println("Shortest path 1--->3: " + shortPath);
//        shortPath = algorithms.shortestPathDist(1,4); // not good for 4,1
//        System.out.println("Shortest path 1--->4: " + shortPath);
//        shortPath = algorithms.shortestPathDist(1,5); // not good for 4,1
//        System.out.println("Shortest path 1--->5: " + shortPath);
//        shortPath = algorithms.shortestPathDist(2,1); // not good for 4,1
//        System.out.println("Shortest path 2--->1: " + shortPath);
//        shortPath = algorithms.shortestPathDist(2,2); // not good for 4,1
//        System.out.println("Shortest path 2--->2: " + shortPath);
//        shortPath = algorithms.shortestPathDist(2,3); // not good for 4,1
//        System.out.println("Shortest path 2--->3: " + shortPath);
//        shortPath = algorithms.shortestPathDist(2,4); // not good for 4,1
//        System.out.println("Shortest path 2--->4: " + shortPath);
//        shortPath = algorithms.shortestPathDist(2,5); // not good for 4,1
//        System.out.println("Shortest path 2--->5: " + shortPath);
//        shortPath = algorithms.shortestPathDist(3,1); // not good for 4,1
//        System.out.println("Shortest path 3--->1: " + shortPath);
//        shortPath = algorithms.shortestPathDist(3,2); // not good for 4,1
//        System.out.println("Shortest path 3--->2: " + shortPath);
//        shortPath = algorithms.shortestPathDist(3,3); // not good for 4,1
//        System.out.println("Shortest path 3--->3: " + shortPath);
//        shortPath = algorithms.shortestPathDist(3,4); // not good for 4,1
//        System.out.println("Shortest path 3--->4: " + shortPath);
//        shortPath = algorithms.shortestPathDist(3,5); // not good for 4,1
//        System.out.println("Shortest path 3--->5: " + shortPath);
//        shortPath = algorithms.shortestPathDist(4,1); // not good for 4,1
//        System.out.println("Shortest path 4--->1: " + shortPath);
//        shortPath = algorithms.shortestPathDist(4,2); // not good for 4,1
//        System.out.println("Shortest path 4--->2: " + shortPath);
//        shortPath = algorithms.shortestPathDist(4,3); // not good for 4,1
//        System.out.println("Shortest path 4--->3: " + shortPath);
//        shortPath = algorithms.shortestPathDist(4,4); // not good for 4,1
//        System.out.println("Shortest path 4--->4: " + shortPath);
//        shortPath = algorithms.shortestPathDist(4,5); // not good for 4,1
//        System.out.println("Shortest path 4--->5: " + shortPath);
//        shortPath = algorithms.shortestPathDist(5,1); // not good for 4,1
//        System.out.println("Shortest path 5--->1: " + shortPath);
//        shortPath = algorithms.shortestPathDist(5,2); // not good for 4,1
//        System.out.println("Shortest path 5--->2: " + shortPath);
//        shortPath = algorithms.shortestPathDist(5,3);
//        System.out.println("Shortest path 5--->3: " + shortPath);
//        shortPath = algorithms.shortestPathDist(5,4);
//        System.out.println("Shortest path 5--->4: " + shortPath);
//        shortPath = algorithms.shortestPathDist(5,5);
//        System.out.println("Shortest path 5--->5: " + shortPath);
//
//        List<NodeData> l = algorithms.shortestPath(4, 5); // 4 to 3 get all
//        Iterator<NodeData> it = l.iterator();
//        while(it.hasNext())
//        {
//            System.out.print(it.next().getKey() + " --> ");
//        }
//        System.out.print("done");
//
//
//        //NodeData center = algorithms.center();
//        //System.out.println("\nCenter: " + center.getKey());
//
//        // tsp
////        List<NodeData> cities = new LinkedList<>();
////        cities.add(n44);
////        cities.add(n41);
////        l = algorithms.tsp(cities);
////        it = l.iterator();
////        while(it.hasNext())
////        {
////            System.out.print(it.next().getKey() + " --> ");
////        }
////        System.out.print("done");
//        //algorithms.save("file");
//
//        // test center
//        Graph G5 = new Graph();
//        Node n51=new Node(1);
//        Node n52= new Node(2);
//        Node n53= new Node(3);
//        Node n54= new Node(4);
//        Node n55= new Node(5);
//        G5.addNode(n51);
//        G5.addNode(n52);
//        G5.addNode(n53);
//        G5.addNode(n54);
//        G5.addNode(n55);
//        G5.connect(1,2,0.5);
//        G5.connect(2,1,0.5);
//        G5.connect(2,3,0.5);
//        G5.connect(2,4,0.5);
//        G5.connect(2,5,0.5);
//        G5.connect(3,4,0.5);
//        G5.connect(4,5,0.5);
//        G5.connect(5,1,0.5);
//
//        algorithms.init(G5);
//        NodeData center = algorithms.center();
//        System.out.println("\nCenter: " + center.getKey());
//
//        //algorithms.save("file.json");

        // load G1 by Boaz.

        //----------------------G1-----------------------------------
        DirectedWeightedGraphAlgorithms algorithms1 = getGrapgAlgo("G1.json");
        DirectedWeightedGraphAlgorithms algorithms2 = getGrapgAlgo("G2.json");
        DirectedWeightedGraphAlgorithms algorithms3 = getGrapgAlgo("G3.json");

        NodeData centerG1 = algorithms1.center();
        System.out.println("CenterG1: " + centerG1.getKey());

        NodeData centerG2 = algorithms2.center();
        System.out.println("CenterG2: " + centerG2.getKey());

        NodeData centerG3 = algorithms3.center();
        System.out.println("CenterG3: " + centerG3.getKey());

    }
}