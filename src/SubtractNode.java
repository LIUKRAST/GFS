public class SubtractNode extends Node {
    public SubtractNode(int id) {
        super(id);
    }

    @Override
    public boolean changeData() {
        int res = pointed[0].value - pointed[1].value;
        if(res == value) return false;
        value = res;
        return true;
    }
}
