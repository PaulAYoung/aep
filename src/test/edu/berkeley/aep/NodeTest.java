package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    static Node a = new Node();
    static Node b = new Node();
    static Node c = new Node();
    static Node d = new Node();
    static Node e = new Node();
    static Node f = new Node();
    static Node g = new Node();
    static Node h = new Node();

    //Let's just build the whole graph
    static {
        a.connect(f);
        b.connect(c);
        b.connect(a);
        c.connect(d);
        c.connect(e);
        d.connect(e);
        e.connect(b);
        h.connect(b);

        d.connect(f);
    }

    @Test
    public void nodeShouldBeAbleToReachSelf(){
        assertTrue(a.canReach(a));
    }

    @Test
    public void nodeShouldBeAbleToReachConnected(){
        assertTrue(h.canReach(b));
    }

    @Test
    public void nodeShouldNotBeAbleToReachUnconnected(){
        assertFalse(b.canReach(h));
    }

    @Test
    public void nodeShouldBeAbleToReachConnectionOfConnected(){
        assertTrue(h.canReach(d));
    }

    @Test
    public void hShouldReachE(){
        assertTrue(h.canReach(e));
    }

    @Test
    public void hShouldNotReachG(){
        assertFalse(h.canReach(g));
    }

    @Test
    public void hShouldBeZeroHopsFromSelf(){ assertEquals(0, h.hopsTo(h));}

    @Test
    public void hShouldBeOnHopFromB(){ assertEquals(1, h.hopsTo(b));}

    @Test
    public void hShouldNotBeAbleToReachG(){ assertEquals(Node.UNREACHABLE, h.hopsTo(g));}

    @Test
    public void hShouldBeThreeHopsFromE(){ assertEquals(3, h.hopsTo(e));}

    @Test
    public void cShouldBeTwoHopsFromB(){ assertEquals(2, c.hopsTo(b));}

    @Test
    public void cShouldBeTwoHopsFromF(){ assertEquals(2, c.hopsTo(f));}
}
