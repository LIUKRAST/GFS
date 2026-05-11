import java.util.*;

public abstract class Node {
    final int id;
    boolean isVisited;
    boolean dirty;

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

    public abstract void changeData();

    public void initiatePropagation(int startValue) {
        this.value = startValue;
        this.dirty = false; // Lo abbiamo già cambiato noi manualmente

        Set<Node> nextLevel = new LinkedHashSet<>();

        // Invece di processare me stesso, metto i miei vicini nel primo turno
        if (this.pointing != null) {
            nextLevel.addAll(Arrays.asList(this.pointing));
        }

        // Parte la solita BFS a livelli
        propagateFromLevel(nextLevel);
    }

    private void propagateFromLevel(Set<Node> currentLevel) {
        while (!currentLevel.isEmpty()) {
            Set<Node> nextLevel = new LinkedHashSet<>();
            for (Node node : currentLevel) {
                node.changeData();
                if (node.dirty) {
                    node.dirty = false;
                    if (node.pointing != null) {
                        for (Node neighbor : node.pointing) {
                            nextLevel.add(neighbor);
                        }
                    }
                }
            }
            currentLevel = nextLevel;
        }
    }
}
