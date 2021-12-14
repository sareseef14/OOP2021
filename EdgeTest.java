package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {




NodeData o = new Node(2);
NodeData o1 = new Node(3);
NodeData o2 = new Node(4);
NodeData o3 = new Node(5);

//GeoLocation l = new Geo_Location(2,4,8);
//GeoLocation l1 = new Geo_Location(4,7,9);
//GeoLocation l3 = new Geo_Location(7,3,0);
    Edge j = new Edge(o,o1,9);
    Edge j1 = new Edge(o2,o3,6);

    @Test
    void getSrc()
    {
        assertEquals(j.getSrc(),2);
        assertEquals(j1.getSrc(),4);

    }

    @Test
    void getDest() {

        assertEquals(j.getSrc(),2);
        assertEquals(j1.getSrc(),4);

    }

    @Test
    void getWeight() {

        assertEquals(j.getWeight(),9);
        assertEquals(j1.getWeight(),6);

    }

    @Test
    void getInfo() {

        j.setInfo("hola");
        j1.setInfo("kola");
        assertEquals(j.getInfo(),"hola");
        assertEquals(j1.getInfo(),"kola");



    }

    @Test
    void setInfo() {
        j.setInfo("hola");
        j1.setInfo("kola");
        assertTrue(j.getInfo()=="hola");
        assertFalse(j1.getInfo()==" kola");
    }

    @Test
    void getTag() {
        j.setInfo("hola");
        j1.setInfo("kola");
        assertTrue(j.getInfo()=="hola");
        assertFalse(j1.getInfo()==" kola");
    }

    @Test
    void setTag() {

        j.setTag(8);
        j1.setTag(9);
        assertTrue(j.getTag()==8);
        assertFalse(j1.getTag()==0);
    }


}