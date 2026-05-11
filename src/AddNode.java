public class AddNode extends Node {
    public AddNode(int id) {
        super(id);
    }

    @Override
    public boolean changeData() {
        int res = 0;
        for(var node : pointed) res += node.value;
        if(res == value) return false;
        value = res;
        return true;
    }
}
