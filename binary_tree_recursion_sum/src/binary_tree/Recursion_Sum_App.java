package binary_tree;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Recursion_Sum_App {
    public static final int NODE_QUANTITY = (int) Math.pow(2, 12) - 1; //количество узлов в полном бинарном дереве глубиной 11
    public static long recursiveResult = 0;

    public static void main(String[] args) {
        Tree tree = new Tree(NODE_QUANTITY);

        final ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        final ForkJoinTask<Long> result = forkJoinPool.submit(tree);
        System.out.println("The result by ForkJoinPool is: " + result.join());

        tree.recursivePreOrder(tree.getRootNode());
        System.out.println("The result by recursive algorithm is: " + recursiveResult);
    }
}
