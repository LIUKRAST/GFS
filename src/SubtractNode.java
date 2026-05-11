public class SubtractNode extends Node {
    public SubtractNode(int id) {
        super(id);
    }

    @Override
    public void changeData() {
        int res = pointed[0].value - pointed[1].value;
        if(res == value) return;
        value = res;
        System.out.println("Passing node " + id + ":" + res);
        dirty = true;
    }
}
