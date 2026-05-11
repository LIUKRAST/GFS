void main() {
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

    n0.initiatePropagation(1);

    System.out.println(n0.value);


}
