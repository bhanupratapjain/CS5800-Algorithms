package homework08.question02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bhanu on 14/03/2016.
 */
public class RBTreePrinter {

    private RedBlackNode nil = new RedBlackNode();


    /**
     * Print rb tree.
     *
     * @param root the root
     */
    public static void printRBTree(RedBlackNode root) {
        int maxLevel = RBTreePrinter.maxLevel(root);

        printRedBlackNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printRedBlackNodeInternal(List<RedBlackNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || RBTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        RBTreePrinter.printWhitespaces(firstSpaces-floor);

        List<RedBlackNode> newRedBlackNodes = new ArrayList<RedBlackNode>();
        for (RedBlackNode node : nodes) {
            if (node != null && node.key!=0) {
//                System.out.print(node.key);
                System.out.print((node.color == RedBlackNode.Color.BLACK ? "B" : "R") + node.key);
                newRedBlackNodes.add(node.left);
                newRedBlackNodes.add(node.right);
            } else {
                newRedBlackNodes.add(null);
                newRedBlackNodes.add(null);
                System.out.print(" ");
            }

            RBTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                RBTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    RBTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null && nodes.get(j).left.key!=0)
                    System.out.print("/");
                else
                    RBTreePrinter.printWhitespaces(1);

                RBTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null && nodes.get(j).right.key!=0 )
                    System.out.print("\\");
                else
                    RBTreePrinter.printWhitespaces(1);

                RBTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printRedBlackNodeInternal(newRedBlackNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(RedBlackNode node) {
        if (node == null)
            return 0;

            return Math.max(node.left.key==0?0:RBTreePrinter.maxLevel(node.left), node.right.key==0?0:RBTreePrinter.maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}