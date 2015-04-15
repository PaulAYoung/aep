package edu.berkeley.aep;

import java.util.*;

/**
 * Understands a location in a network
 */
public class Node {

    public static final int UNREACHABLE = Integer.MAX_VALUE;

    private Set<Node> connections = new HashSet<Node>();


    public Node() {
        this.connect(this);
    }


    public boolean canReach(Node node) {
        List<Node> toExplore = new ArrayList<Node>();
        toExplore.add(this);
        Set<Node> scheduled = new HashSet<Node>();

        Node current;
        Set<Node> newNodes;

        while (!toExplore.isEmpty()){
            current = toExplore.remove(0);
            if (current.connections.contains(node)){
                return true;
            }

            newNodes = new HashSet<Node>(current.connections);
            newNodes.removeAll(scheduled);

            toExplore.addAll(newNodes);
            scheduled.addAll(current.connections);
        }

        return false;
    }

    public void connect(Node node) {
        this.connections.add(node);
    }

    public int hopsTo(Node node){
        Set<Node> toCheck = new HashSet<Node>();
        toCheck.add(this);
        return hopsTo(node, toCheck, new HashSet<Node>());
    }

    private static int hopsTo(Node node, Set<Node> toCheck, Collection<Node> explored) {
        Set<Node> nextExplore = new HashSet<Node>();

        for (Node n : toCheck){
            if (n == node) return 0;

            nextExplore.addAll(n.connections);
        }

        explored.addAll(toCheck);
        nextExplore.removeAll(explored);

        int d;

        if (nextExplore.isEmpty()) d = UNREACHABLE;
        else d = hopsTo(node, nextExplore, explored);

        if (d<UNREACHABLE) return 1+d;
        else return UNREACHABLE;
    }
}
