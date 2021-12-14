# OOP2021

Ex2.readme introuduction @Auther Sari Safe& Semcha Teich 

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
	 	/** Allows changing this node's location.
	 * @param p - new new location  (position) of this node.
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
	 
