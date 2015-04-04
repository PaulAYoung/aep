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
        Node node = new Node("h");
        assertTrue(node.canReach(node));
    }

    @Test
    public void nodeShouldBeAbleToReachConnected(){
        Node h = new Node("h");
        Node b = new Node("b");
        h.connect(b);
        assertTrue(h.canReach(b));
    }

    @Test
    public void nodeShouldNotBeAbleToReachConnected(){
        Node h = new Node("h");
        Node b = new Node("b");
        assertFalse(h.canReach(b));
    }

    @Test
    public void nodeShouldNotBeAbleToReachConnectionOfConnected(){
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        a.connect(b);
        b.connect(c);
        assertTrue(a.canReach(c));
    }
}
