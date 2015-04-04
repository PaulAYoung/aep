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
        return this.allconnections().contains(node);
    }

    private Set<Node> allconnections() {
        Set<Node> nodes = new HashSet<Node>();
        nodes.addAll(this.connections);
        for (Node n : this.connections){
            nodes.addAll(n.connections);
        }
        return nodes;
    }

    public void connect(Node node) {
        this.connections.add(node);
    }
}
