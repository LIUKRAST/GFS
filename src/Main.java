void main() {
    test(ex1());
    test(ex2());
}

void test(boolean test) {
    System.out.println(test ? "Test successful" : "Test failed");
}

boolean ex1() {
    Node n0 = new AddNode(0);
    Node n1 = new AddNode(1);
    Node n2 = new AddNode(2);
    Node n3 = new AddNode(3);
    Node n4 = new AddNode(4);
    Node n5 = new SubtractNode(5);

    n0.setPointing(n1, n2);
    n1.setPointing(n3);
    n2.setPointing(n4);
    n3.setPointing(n5);
    n4.setPointing(n5);
    n5.setPointing(n0);

    n0.value = 1;
    n0.startPropagation();
    if(!n0.isVisited) return false;
    if(!n1.isVisited) return false;
    if(!n2.isVisited) return false;
    if(!n3.isVisited) return false;
    if(!n4.isVisited) return false;
    if(!n5.isVisited) return false;
    return n0.value == 0;
}

boolean ex2() {
    Node n0 = new AddNode(0);
    Node n1 = new AddNode(1);
    Node n2 = new AddNode(2);
    Node n3 = new SubtractNode(3);
    Node n4 = new AddNode(4);

    n0.setPointing(n1, n2);
    n1.setPointing(n3);
    n2.setPointing(n4);
    n4.setPointing(n3);
    n3.setPointing(n0);
    n0.value = 1;
    n0.startPropagation();
    if(!n0.isVisited) return false;
    if(!n1.isVisited) return false;
    if(!n2.isVisited) return false;
    if(!n3.isVisited) return false;
    if(!n4.isVisited) return false;
    return n0.value == 0;
}
