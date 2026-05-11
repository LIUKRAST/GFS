public class AddNode extends Node {
    public AddNode(int id) {
        super(id);
    }

    @Override
    public void changeData() {
        int res = 0;
        for(var node : pointed) res += node.value;
        if(res == value) return;
        value = res;
        System.out.println("Passing node " + id + ":" + res);
        dirty = true;
    }
}
