package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Understands a location
 */
public class Node {
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
}
