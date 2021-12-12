package api;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import com.google.gson.*;

public class GraphAlgo implements DirectedWeightedGraphAlgorithms {
    final int WHITE = 0;
    final int GRAY = 1;
    final int BLACK = 2;
    private DirectedWeightedGraph _g;

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
            // take the current node
            NodeData toCopy = itrN.next();

            // take from current node his key
            int key = toCopy.getKey();

            // create new node with the same key.
            NodeData newN = new Node(key);

            // take copy of location into new node.
            if (toCopy.getLocation() != null)
            {
                GeoLocation newGl = new Geo_Location(toCopy.getLocation().x(), toCopy.getLocation().y(), toCopy.getLocation().z());
                newN.setLocation(newGl);
            }
            else
            {
                newN.setLocation(null);
            }

            // set the same width
            double newW = toCopy.getWeight();
            newN.setWeight(newW);

            // set the same Info
            String Info = toCopy.getInfo();
            newN.setInfo(Info);

            // set the same tag
            int tag = toCopy.getTag();
            newN.setTag(tag);

            // add the new deep copied node to the grath.
            newG.addNode(newN);
        }

        // copy all Edges
        Iterator<EdgeData> iterE = _g.edgeIter();
        while (iterE.hasNext())
        {
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
        if(_g.nodeSize() == 0) {return false;} // or true?

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
    public double shortestPathDist(int src, int dest)
    {
        HashMap<Integer, Double> dist = new HashMap<Integer, Double>();
        HashMap<Integer, Integer> prnt = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>((a, b) -> (int)(dist.get(a) - dist.get(b)));
        PriorityQueue<Integer> Q2 = new PriorityQueue<Integer>((a, b) -> (int)(dist.get(a) - dist.get(b)));

        Iterator<NodeData> itrN = _g.nodeIter();
        while(itrN.hasNext())
        {
            NodeData n = itrN.next();
            if(n.getKey() == src)
            {
                dist.put(src, 0.0);
            }
            else
            {
                dist.put(n.getKey(), Double.MAX_VALUE);
            }
            prnt.put(n.getKey(), -1);
            Q.add(n.getKey());
        }

        while(Q.size() > 0)
        {
            int u = Q.poll();
            //System.out.print(u +  " ");

            Iterator<EdgeData> itrE = _g.edgeIter(u);
            while(itrE.hasNext())
            {
                EdgeData u_v = itrE.next();
                int v = u_v.getDest();

                if(dist.get(v) > dist.get(u) + u_v.getWeight())
                {
                    dist.replace(v, dist.get(u) + u_v.getWeight());
                    prnt.replace(v, u);

                    // exactly like decrease key
                    while(!Q.isEmpty())
                    {
                        Q2.add(Q.poll());
                    }
                    while (!Q2.isEmpty())
                    {
                        Q.add(Q2.poll());
                    }
                }
            }

            if(u == dest){break;}
        }

        return dist.get(dest) == Double.MAX_VALUE ? -1 : dist.get(dest);
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest)
    {
        HashMap<Integer, Double> dist = new HashMap<Integer, Double>();
        HashMap<Integer, Integer> prnt = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>((a, b) -> (int)(dist.get(a) - dist.get(b)));
        PriorityQueue<Integer> Q2 = new PriorityQueue<Integer>((a, b) -> (int)(dist.get(a) - dist.get(b))); //

        Iterator<NodeData> itrN = _g.nodeIter();
        while(itrN.hasNext())
        {
            NodeData n = itrN.next();
            if(n.getKey() == src)
            {
                dist.put(src, 0.0);
            }
            else
            {
                dist.put(n.getKey(), Double.MAX_VALUE);
            }
            prnt.put(n.getKey(), -1);
            Q.add(n.getKey());
        }

        while(Q.size() > 0)
        {
            int u = Q.poll();

            Iterator<EdgeData> itrE = _g.edgeIter(u);
            while(itrE.hasNext())
            {
                EdgeData u_v = itrE.next();
                int v = u_v.getDest();

                if(dist.get(v) > dist.get(u) + u_v.getWeight())
                {
                    dist.replace(v, dist.get(u) + u_v.getWeight());
                    prnt.replace(v, u);

                    // exactly like "decrease key" :)
                    while(!Q.isEmpty())
                    {
                        Q2.add(Q.poll());
                    }
                    while (!Q2.isEmpty())
                    {
                        Q.add(Q2.poll());
                    }
                }
            }
            if(u == dest){break;} // when we finish with our dest.
        }

        // if no path
        if(dist.get(dest) == Double.MAX_VALUE)
        {
            return null;
        }

        List<NodeData> path = new LinkedList<NodeData>();
        int curr = dest;
        path.add(0, _g.getNode(curr));
        while(curr != src)
        {
            int prev = prnt.get(curr);
            path.add(0, _g.getNode(prev));
            curr = prev;
        }

        return path;
    }

    @Override
    public NodeData center()
    {
        if (!this.isConnected())
        {
            return null;
        }

        HashMap<Integer, Double> shortestPathSum = new HashMap<Integer, Double>();
        Iterator<NodeData> it = _g.nodeIter();
        while(it.hasNext())
        {
            NodeData curr = it.next();
            shortestPathSum.put(curr.getKey(), Double.MAX_VALUE);
        }

        it = _g.nodeIter();
        int returnCenter = it.next().getKey();
        System.out.println("\nCurrCenter: " + returnCenter);

        Iterator<NodeData> itSrc = _g.nodeIter();
        while(itSrc.hasNext())
        {
            int src = itSrc.next().getKey();
            Iterator<NodeData> itDst = _g.nodeIter();
            {
                while (itDst.hasNext())
                {
                    int dst = itDst.next().getKey();
                    double pathLenSrcToDst = shortestPathDist(src, dst);
                    if(shortestPathSum.get(src) == Double.MAX_VALUE)
                    {
                        shortestPathSum.replace(src, pathLenSrcToDst);
                    }
                    else
                    {
                        shortestPathSum.replace(src, shortestPathSum.get(src) + pathLenSrcToDst);
                    }
                }
            }
            if (shortestPathSum.get(returnCenter) > shortestPathSum.get(src))
            {
                System.out.println("\nCurrCenter: " + src);
                returnCenter = src;
            }

        }

        System.out.println("\n"+ shortestPathSum.toString());
        return _g.getNode(returnCenter);
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities)
    {
        HashSet<Integer> notVisited = new HashSet<Integer>();
        List<NodeData> pathAroundAllCities = new LinkedList<NodeData>();
        Iterator<NodeData> itCities = cities.iterator();
        while(itCities.hasNext())
        {
            NodeData n = itCities.next();
            if(pathAroundAllCities.size() == 0)
            {
                pathAroundAllCities.add(n);
            }
            else
            {
                notVisited.add(n.getKey());
            }
        }

        while(!notVisited.isEmpty())
        {
            int src = pathAroundAllCities.get(pathAroundAllCities.size()-1).getKey();
            Iterator<Integer> itNotVisit = notVisited.iterator();
            int dst = itNotVisit.next();
            List<NodeData> srcToDstPath = shortestPath(src, dst);

            Iterator<NodeData> itSrcToDstPath = srcToDstPath.iterator();
            itSrcToDstPath.next(); // avoid from first element because it exits at and of pathAroundAllCitiesList!
            while (itSrcToDstPath.hasNext())
            {
                NodeData n = itSrcToDstPath.next();
                pathAroundAllCities.add(n); // add to path
                notVisited.remove(n.getKey()); // remove from 'not visited'.
            }

        }

        return pathAroundAllCities;
    }

    @Override
    public boolean save(String file)
    {

        // serializer for nodes.
        JsonSerializer<NodeData> serializerNodes = new JsonSerializer<NodeData>()
        {
            @Override
            public JsonElement serialize(NodeData nodeData, Type type, JsonSerializationContext jsonSerializationContext)
            {
                JsonObject obj = new JsonObject();
                GeoLocation gl = nodeData.getLocation();
                String pos = gl.x() + "," + gl.y() + "," + gl.z();
                obj.addProperty("pos", pos);
                obj.addProperty("id", nodeData.getKey());

                return obj;
            }
        };

        // serializer for edges.
        JsonSerializer<EdgeData> serializerEdges = new JsonSerializer<EdgeData>()
        {
            @Override
            public JsonElement serialize(EdgeData edgeData, Type type, JsonSerializationContext jsonSerializationContext)
            {
                JsonObject obj = new JsonObject();
                obj.addProperty("src", edgeData.getSrc());
                obj.addProperty("w", edgeData.getWeight());
                obj.addProperty("dest", edgeData.getDest());
                return obj;
            }
        };

        // serializer for graph.
        JsonSerializer<DirectedWeightedGraph> serializerGraph = new JsonSerializer<DirectedWeightedGraph>()
        {
            @Override
            public JsonElement serialize(DirectedWeightedGraph G, Type type, JsonSerializationContext jsonSerializationContext)
            {
                // list for edges
                Iterator<EdgeData> itE = G.edgeIter();
                ArrayList<EdgeData> arrE = new ArrayList<EdgeData>();
                while(itE.hasNext())
                {
                    arrE.add(itE.next());
                }

                // list for nodes
                Iterator<NodeData> itN = G.nodeIter();
                ArrayList<NodeData> arrN = new ArrayList<NodeData>();
                while(itN.hasNext())
                {
                    arrN.add(itN.next());
                }

                Gson gsonNodes = new GsonBuilder().registerTypeAdapter(Node.class, serializerNodes).create();
                Gson gsonEdges = new GsonBuilder().registerTypeAdapter(Edge.class, serializerEdges).create();

                JsonObject obj = new JsonObject();
                obj.add("Edges", gsonEdges.toJsonTree(arrE));
                obj.add("Nodes", gsonNodes.toJsonTree(arrN));

                return obj;
            }
        };

//        // list for nodes
//        Iterator<NodeData> itN = _g.nodeIter();
//        ArrayList<NodeData> arrN = new ArrayList<NodeData>();
//        while(itN.hasNext())
//        {
//            arrN.add(itN.next());
//        }

//        Gson gson = new GsonBuilder().registerTypeAdapter(Node.class, serializerNodes).create();
//        String jsonNodesStr = gson.toJson(arrN);
//        System.out.println(jsonNodesStr);

//        // list for edges
//        Iterator<EdgeData> itE = _g.edgeIter();
//        ArrayList<EdgeData> arrE = new ArrayList<EdgeData>();
//        while(itE.hasNext())
//        {
//            arrE.add(itE.next());
//        }

//        gson = new GsonBuilder().registerTypeAdapter(Edge.class, serializerEdges).create();
//        String jsonEdgesStr = gson.toJson(arrE);
//        System.out.println(jsonEdgesStr);

        Gson gson = new GsonBuilder().registerTypeAdapter(Graph.class, serializerGraph).setPrettyPrinting().create();
        String jsonGraphStr = gson.toJson(this._g);

        try
        {
            FileWriter fw = new FileWriter(file);
            fw.write(jsonGraphStr);
            fw.close();
        }
        catch (IOException e){return  false;}

        return true;
    }

    @Override
    public boolean load(String file)
    {
        JsonDeserializer<DirectedWeightedGraph> deserializerGraph = new JsonDeserializer<DirectedWeightedGraph>()
        {
            @Override
            public DirectedWeightedGraph deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException
            {
                DirectedWeightedGraph newGraph = new Graph();

                // for Nodes.
                JsonObject jo = jsonElement.getAsJsonObject();
                JsonArray arrJO = jo.get("Nodes").getAsJsonArray();
                Iterator<JsonElement> itJO = arrJO.iterator();
                while(itJO.hasNext())
                {
                    JsonObject je = (JsonObject) itJO.next();

                    // take location
                    String pos = je.get("pos").toString();
                    String xyz[] = pos.split(",");
                    double x = Double.parseDouble(xyz[0].split("\"")[1]);
                    double y = Double.parseDouble(xyz[1]);
                    double z = Double.parseDouble(xyz[2].split("\"")[0]);
                    GeoLocation newLocation = new Geo_Location(x, y, z);

                    // take key
                    int key = je.get("id").getAsInt();

                    // create Node
                    NodeData newNode = new Node(key);
                    newNode.setLocation(newLocation);
                    newGraph.addNode(newNode);
                }


                // for Edges.
                arrJO = jo.get("Edges").getAsJsonArray();
                itJO = arrJO.iterator();
                while(itJO.hasNext())
                {
                    JsonObject je = (JsonObject) itJO.next();

                    // take src
                    int src = je.get("src").getAsInt();

                    // take width
                    double width = je.get("w").getAsDouble();

                    // take dest
                    int dst = je.get("dest").getAsInt();

                    newGraph.connect(src, dst, width);
                }

                return newGraph;
            }
        };

        String content = "";
        try
        {
            content = Files.readString(Path.of(file));
            //System.out.println(content);
        }
        catch (IOException e){return false;}

        Gson gson = new GsonBuilder().registerTypeAdapter(Graph.class, deserializerGraph).setPrettyPrinting().create();
        DirectedWeightedGraph newGraph = gson.fromJson(content, Graph.class);
        this.init(newGraph);
        return true;
    }


    //----------HELPERS-------------

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




