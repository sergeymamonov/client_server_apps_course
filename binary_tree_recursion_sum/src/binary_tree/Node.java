package binary_tree;

public class Node {
    private Node left;
    private Node right;
    private long value;

    public long getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(long value) {
        this.value = value;
    }
}