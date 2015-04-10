package edu.berkeley.aep;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by paul on 4/3/15.
 */



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
}
