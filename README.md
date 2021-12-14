# OOP2021-EX2

Ex2.readme introuduction @Auther Sari Safe& Simcha Teich 

In the project we implemented the interfaces, There are five classes which we will use in order to implement for each interface. 
   (We will to represent  the  classes by its sectiones).

* Name of Interfaces : EdgeData ,NodeData , GeoLocation, DirectedWeightedGraph , DirectedWeightedGraphAlgorithms.
* Name of Classes :    Edge , Node , Geo_Location , Graph ,GraphAlgo.

**Node class function:**

**The First Class is Called "Node" :
 This class represents the individual Vertex in a (directional) weighted graph , by implementing the interface in the code "NodeData".**

 *In this class that performs the following steps:*


       public int getKey();
      /**
	 * Returns the key (id) associated with this node.
	 * @return
	 */

        public GeoLocation getLocation();
      /**
	 *Returns the location of this node, if none return null.
	 * @return
	 */
	
          public void setLocation(GeoLocation p); 
	/**
	 *Allows changing this node's location.
	 * @param p -new location  (position) of this node.
	 */

          public double getWeight();
	/**
	 * Returns the weight associated with this node.
	 * @return
	 */
	
         public void setWeight(double w);
	/**
	 * Allows changing this node's weight.
	 * @param w - the new weight
	 */
	
          public String getInfo();
	/**
	 * Returns the remark (meta data) associated with this node.
	 * @return
	 */
	
         public void setInfo(String s);	
	/**
	 * Allows changing the remark (meta data) associated with this node.
	 * @param s
	 */


         public int getTag();
	/**
	 * Temporal data (aka color: e,g, white, gray, black) 
	 * which can be used be algorithms 
	 * @return
	 */
	 
	
         public void setTag(int t);
	/** 
	 * Allows setting the "tag" value for temporal marking an node - common
	 * practice for marking by algorithms.
	 * @param t - the new value of the tag
	 */
	 
	 
	 
	 
**Geo_Location class functions:**

**The Seconed Class is Called "Geo_Location" :
 This class representsrepresents a geo location <x,y,z> , by implementing the interface in the code "GeoLocation".**

 *In this class that performs the following steps:*	 
 
 
  public double x();
  /**
  *Location of the x  in graph 3D.
  
    public double y();
    /**
    *Location of the y  in graph 3D.
    public double z();
    /**
    *Location of the z  in graph 3D.
    
    public double distance(GeoLocation g);
    /** 
    *The Distance of to Pionts 3D.
	 
	 
	 
	 
**The Third Class is Called "Edge" :
 This class represents the Edge thet Preseneted By Tow  Vertex (source ,destenation, Weight) in a (directional) weighted graph , by implementing the interface in the code "EdgeData".**

	/**
	 * The id of the source node of this edge.
	 * @return
	 */
	
	public int getSrc();
	/**
	 * The id of the destination node of this edge
	 * @return
	 */
	
	public int getDest();
	/**
	 * @return the weight of this edge (positive value).
	 */
	
	public double getWeight();
	/**
	 * Returns the remark (meta data) associated with this edge.
	 * @return
	 */
	
	public String getInfo();
	/**
	 * Allows changing the remark (meta data) associated with this edge.
	 * @param s
	 */
	
	public void setInfo(String s);
	/**
	 * Temporal data (aka color: e,g, white, gray, black) 
	 * which can be used be algorithms 
	 * @return
	 */
	
	public int getTag();
	/** 
	 * This method allows setting the "tag" value for temporal marking an edge - common
	 * practice for marking by algorithms.
	 * @param t - the new value of the tag
	 */
	public void setTag(int t);
	
	
**The Fourth  Class is Called "Graph" :This class represents the  Directedweighted graph , by implementing the interface in the code "DirectedWeightedGraph".**

 
 
 
        public NodeData getNode(int key);
       /**
	 * returns the node_data by the node_id,
	 * @param key - the node_id
	 * @return the node_data by the node_id, null if none.
	 */

       public EdgeData getEdge(int src, int dest);
      /**
	 * returns the data of the edge (src,dest), null if none.
	 * Note: this method should run in O(1) time.
	 * @param src
	 * @param dest
	 * @return
	 */

        public void addNode(NodeData n);
       /**
	 * adds a new node to the graph with the given node_data.
	 * Note: this method should run in O(1) time.
	 * @param n
	 */
   

     public void connect(int src, int dest, double w);
     /**
      * Connects an edge with weight w between node src to node dest.
      * Note: this method should run in O(1) time.
      * @param src - the source of the edge.
      * @param dest - the destination of the edge.
      * @param w - positive weight representing the cost (aka time, price, etc) between src-->dest.
      */
 
 	public Iterator<NodeData> nodeIter();
      /**
	 * This method returns an Iterator for the
	 * collection representing all the nodes in the graph.
	 * Note: if the graph was changed since the iterator was constructed - a RuntimeException should be thrown.
	 * @return Iterator<node_data>
         */
	
	public Iterator<EdgeData> edgeIter();
     /**
	* This method returns an Iterator for all the edges in this graph.
	* Note: if any of the edges going out of this node were changed since the iterator was constructed - a RuntimeException  * should be thrown.
	* @return Iterator<EdgeData>
        */
	
**The Five  Class is Called "DirectedWeightedGraphAlgorithms" :This class represents the  Directedweighted graph , by implementing the interface in the code "DirectedWeightedGraphAlgorithms".**

 * This interface represents a Directed (positive) Weighted Graph Theory Algorithms including:
 * 0. clone(); (copy)
 * 1. init(graph);
 * 2. isConnected(); // strongly (all ordered pais connected)
 * 3. double shortestPathDist(int src, int dest);
 * 4. List<NodeData> shortestPath(int src, int dest);
 * 5. NodeData center(); // finds the NodeData which minimizes the max distance to all the other nodes.
 * 6. List<NodeData> tsp(List<NodeData> cities); // computes a list of consecutive nodes which go over all the nodes in cities.                                         
 * 7. save(file); // JSON file
 * 8. load(file); // JSON file
 *
 */
     public interface DirectedWeightedGraphAlgorithms {
    /**
     * Inits the graph on which this set of algorithms operates on.
     * @param g
     */
    public void init(DirectedWeightedGraph g);

    /**
     * Returns the underlying graph of which this class works.
     * @return
     */
    public DirectedWeightedGraph getGraph();
    /**
     * Computes a deep copy of this weighted graph.
     * @return
     */
    public DirectedWeightedGraph copy();
    /**
     * Returns true if and only if (iff) there is a valid path from each node to each
     * other node. NOTE: assume directional graph (all n*(n-1) ordered pairs).
     * @return
     */
    public boolean isConnected();
    /**
     * Computes the length of the shortest path between src to dest
     * Note: if no such path --> returns -1
     * @param src - start node
     * @param dest - end (target) node
     * @return
     */
    public double shortestPathDist(int src, int dest);
    /**
     * Computes the the shortest path between src to dest - as an ordered List of nodes:
     * src--> n1-->n2-->...dest
     * Note if no such path --> returns null;
     * @param src - start node
     * @param dest - end (target) node
     * @return
     */
    public List<NodeData> shortestPath(int src, int dest);

    /**
     * Finds the NodeData which minimizes the max distance to all the other nodes.
     * @return the Node data to which the max shortest path to all the other nodes is minimized.
     */
    public NodeData center();
   /**
    * Computes a list of consecutive nodes which go over all the nodes in cities.
    * the sum of the weights of all the consecutive (pairs) of nodes (directed) is the "cost" of the solution -
    * the lower the better.
    */
    List<NodeData> tsp(List<NodeData> cities);
    /**
     * Saves this weighted (directed) graph to the given
     * file name - in JSON format
     * @param file - the file name (may include a relative path).
     * @return true - iff the file was successfully saved
     */
     public boolean save(String file);
    /**
     * This method loads a graph to this graph algorithm.
     * if the file was successfully loaded - the underlying graph
     * of this class will be changed (to the loaded one), in case the
     * graph was not loaded the original graph should remain "as is".
     * @param file - file name of JSON file
     * @return true - iff the graph was successfully loaded.
     */
    public boolean load(String file) throws IOException;
}


	 
