package api;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Geo_LocationTest
{

    GeoLocation G1 = new Geo_Location(1,89,3);
    GeoLocation G2 = new Geo_Location(2,3,100);
    GeoLocation G3 = new Geo_Location(3,4,5);
    GeoLocation G4 = new Geo_Location(0,0,6);
    GeoLocation G5 = new Geo_Location(5,0,7);
    GeoLocation G6 = new Geo_Location(6,33.01,8);

    double Xg1 = 1;
    double Xg2 = 2;
    double Xg3 = 3;
    double Xg4 = 0;
    double Xg5 = 5;
    double Xg6 = 6;

    double Yg1 = 89;
    double Yg2 = 3;
    double Yg3 = 4;
    double Yg4 = 0;
    double Yg5 = 0;
    double Yg6 = 33.01;

    double Zg1 = 3;
    double Zg2 = 100;
    double Zg3 = 5;
    double Zg4 = 6;
    double Zg5 = 7;
    double Zg6 = 8;

    double d1 = G1.distance(G2);
    double d2 = G5.distance(G6);
    double d3 = G4.distance(G3);

    double r1 = 129.63795740445775;
    double r2_0 = 33.04028;
    double r2_1 = 33.04027996249426;
    double r3_0 = 5.09902;
    double r3_1 = 5.0990195135927845;


    @Test
    void x()
    {
        assertEquals(G1.x(),Xg1);
        assertEquals(G2.x(),Xg2);
        assertEquals(G3.x(),Xg3);
        assertEquals(G4.x(),Xg4);
        assertEquals(G5.x(),Xg5);
        assertEquals(G6.x(),Xg6);

        assertTrue(G6.x()==Xg6);
        assertFalse(G6.x()==Xg5);

    }

    @Test
    void y()
    {
        assertEquals(G1.y(),Yg1);
        assertEquals(G2.y(),Yg2);
        assertEquals(G3.y(),Yg3);
        assertEquals(G4.y(),Yg4);
        assertEquals(G5.y(),Yg5);
        assertEquals(G6.y(),Yg6);

        assertTrue(G1.y()==Yg1);
        assertFalse(G2.y()==Yg6);
    }

    @Test
    void z()
    {
        assertEquals(G1.z(),Zg1);
        assertEquals(G2.z(),Zg2);
        assertEquals(G3.z(),Zg3);
        assertEquals(G4.z(),Zg4);
        assertEquals(G5.z(),Zg5);
        assertEquals(G6.z(),Zg6);

        assertTrue(G3.z()==Zg3);
        assertFalse(G6.z()==Zg1);

    }

    @Test
    void distance()
    {
        assertEquals(d1,r1);
        assertEquals(d2,r2_1);
        assertEquals(d3,r3_1);

        assertFalse(d1==5);
        assertFalse(d2==0);
        assertFalse(d2==r2_0);
        assertFalse(d3==r3_0);


    }

    @Test
    void testToString()
    {





    }
}