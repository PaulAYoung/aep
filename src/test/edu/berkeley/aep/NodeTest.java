package edu.berkeley.aep;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by paul on 4/3/15.
 */
public class NodeTest {
    @Test
    public void nodeShouldBeAbleToReachSelf(){
        Node node = new Node();
        assertTrue(node.canReach(node));
    }

    @Test
    public void nodeShouldBeAbleToReachConnected(){
        Node h = new Node();
        Node b = new Node();
        h.connect(b);
        assertTrue(h.canReach(b));
    }

    @Test
    public void nodeShouldNotBeAbleToReachUnconnected(){
        Node h = new Node();
        Node b = new Node();
        assertFalse(h.canReach(b));
    }

    @Test
    public void nodeShouldBeAbleToReachConnectionOfConnected(){
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        a.connect(b);
        b.connect(c);
        assertTrue(a.canReach(c));
    }

    @Test
    public void hShouldReachE(){
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();
        Node h = new Node();

        //Let's just build the whole graph
        a.connect(f);
        b.connect(c);
        b.connect(a);
        c.connect(d);
        c.connect(e);
        d.connect(e);
        e.connect(b);
        h.connect(b);

        assertTrue(h.canReach(e));
    }

    @Test
    public void hShouldNotReachG(){
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();
        Node h = new Node();

        //Let's just build the whole graph
        a.connect(f);
        b.connect(c);
        b.connect(a);
        c.connect(d);
        c.connect(e);
        d.connect(e);
        e.connect(b);
        h.connect(b);

        assertFalse(h.canReach(g));
    }
}
