package binary_tree;

import java.util.concurrent.RecursiveTask;

public class Tree extends RecursiveTask<Long> {
    private Node rootNode;

    public Tree(Node node) {
        rootNode = node;
    }

    public Tree(int nodeQuantity) {
        rootNode = null;
        createTree(nodeQuantity);
    }

    private void createTree(int nodeQuantity) {
        for (int i = 0; i < nodeQuantity; i++) {
            long value = (long) (Math.random() * 10);
            this.insertNode(value);
        }
    }

    public void insertNode(long value) {
        Node newNode = new Node();
        newNode.setValue(value);

        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node currentNode = rootNode;
            Node parentNode;
            while (true) {
                parentNode = currentNode;
                if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(newNode);
                        break;
                    }
                } else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        break;
                    }
                }
            }
        }
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void recursivePreOrder(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        Recursion_Sum_App.recursiveResult += currentNode.getValue();

        recursivePreOrder(currentNode.getLeft());
        recursivePreOrder(currentNode.getRight());
    }

    @Override
    protected Long compute() {
        if (rootNode.getLeft() == null && rootNode.getRight() == null) {
            return rootNode.getValue();
        } else if (rootNode.getLeft() != null && rootNode.getRight() == null) {
            Tree leftTree = new Tree(rootNode.getLeft());
            leftTree.fork();
            return leftTree.join() + rootNode.getValue();
        } else if (rootNode.getLeft() == null && rootNode.getRight() != null) {
            Tree rightTree = new Tree(rootNode.getRight());
            rightTree.fork();
            return rightTree.join() + rootNode.getValue();
        } else {
            Tree leftTree = new Tree(rootNode.getLeft());
            Tree rightTree = new Tree(rootNode.getRight());
            leftTree.fork();
            return rightTree.compute() + leftTree.join() + rootNode.getValue();
        }
    }
}
