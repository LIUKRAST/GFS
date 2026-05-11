import java.util.*;

public abstract class Node {
    final int id;
    boolean isVisited;
    boolean isDirty;

    int value = 0;
    Node[] pointing;
    Node[] pointed = new Node[0];

    public Node(int id) {
        this.id = id;
    }

    public void setPointing(Node... nodes) {
        pointing = nodes;
        for(var node : nodes) {
            node.pointed = Arrays.copyOf(node.pointed, node.pointed.length+1);
            node.pointed[node.pointed.length-1] = this;
        }
    }

    public void changeData(boolean recursive) {
        if(recursive) {
            for(Node node : pointed) {
                if(node.isVisited) continue;
                node.isVisited = true;
                node.changeData(true);
            }
        }
        int oldValue = value;
        isDirty = changeData();
        System.out.println("Node " + id + ": " + oldValue + " -> " + value);
    }

    public abstract boolean changeData();

    public void startPropagation() {
        propagate();
        changeData();
    }

    // Propagate must recursively modify 
    public void propagate() {
        this.isVisited = true;

        for(Node node : pointing) {
            if(!node.isVisited) {
                node.changeData(true);
                if(!node.isDirty) {
                    node.isVisited = true;
                    continue;
                }
                node.propagate();
            }
        }
    }

    @Override
    public String toString() {
        return "Node" + id;
    }
}
