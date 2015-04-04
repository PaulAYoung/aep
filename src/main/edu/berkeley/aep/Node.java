package edu.berkeley.aep;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by paul on 4/3/15.
 */
public class Node {
    private final String name;
    private Set<Node> connections = new HashSet<Node>();

    public Node(String name) {
        this.name = name;
        this.connect(this);
    }

    public boolean canReach(Node node) {
        if (this.connections.contains(node)){
            return true;
        }else {
            for (Node n : connections){
                if (n.canReach(node)) return true;
            }
            return false;
        }
    }

    public void connect(Node node) {
        this.connections.add(node);
    }
}
