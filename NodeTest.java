package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    int k1 = 0;
    int k2 = 1;
    int k3 = 2;


    Node n0 = new Node(k1);
    Node n1 = new Node(k2);
    Node n2 = new Node(k3);


    Geo_Location  g1 = new Geo_Location(1,2,3);
    Geo_Location  g2 = new Geo_Location(0,0,0);
    Geo_Location  g3 = new Geo_Location(2,1,5);

    @Test
    void getKey()
    {


    assertEquals(n0.getKey(),k1);
    assertEquals(n1.getKey(),k2);
    assertEquals(n2.getKey(),k3);

    }
     @Test
    void getLocation()
    {
///here just check if problem..
        n0.setLocation(g1);
        assertFalse(n0.getLocation()==g2);
        n1.setLocation(g2);
        assertFalse(n1.getLocation()==g1);


    }

    @Test
    void setLocation()
    {
        n0.setLocation(g1);
        assertFalse(n0.getLocation()==g2);
        n1.setLocation(g2);
        assertFalse(n1.getLocation()==g1);

    }

    @Test
    void getWeight()
    {
        n0.setWeight(55);
        n1.setWeight(20);
        n2.setWeight(47);


        assertEquals(n0.getWeight(),55);
        assertEquals(n1.getWeight(),20);
        assertEquals(n2.getWeight(),47);

    }

    @Test
    void setWeight()
    {
        n0.setWeight(55);
        n1.setWeight(20);
        n2.setWeight(47);
    }

    @Test
    void getInfo()
    {
        n0.setInfo("Directed");
        n1.setInfo("Weighted");

        assertEquals(n0.getInfo(),"Directed");
        assertEquals(n1.getInfo(),"Weighted");
    }

    @Test
    void setInfo()
    {
        n0.setInfo("Directed");
        n1.setInfo("Weighted");
        n2.setInfo("Graph");
        assertFalse(n0.getInfo()=="Dir");
        assertFalse(n1.getInfo()=="eighted");
        assertTrue(n2.getInfo()=="Graph");
        assertFalse(n2.getInfo()==" Graph");
    }

    @Test
    void getTag()
    {
     n0.setTag(5);
     assertEquals(n0.getTag(),5);
    }

    @Test
    void setTag()
    {
        n0.setTag(5);
        assertEquals(n0.getTag(),5);
    }
}