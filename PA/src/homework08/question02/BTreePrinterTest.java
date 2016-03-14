package homework08.question02;

/**
 * Created by Bhanu on 14/03/2016.
 */

public class BTreePrinterTest {

    private static RedBlackNode test1() {
        RedBlackNode root = new RedBlackNode(2);
        RedBlackNode n11 = new RedBlackNode(7);
        RedBlackNode n12 = new RedBlackNode(5);
        RedBlackNode n21 = new RedBlackNode(2);
        RedBlackNode n22 = new RedBlackNode(6);
        RedBlackNode n23 = new RedBlackNode(3);
        RedBlackNode n24 = new RedBlackNode(6);
        RedBlackNode n31 = new RedBlackNode(5);
        RedBlackNode n32 = new RedBlackNode(8);
        RedBlackNode n33 = new RedBlackNode(4);
        RedBlackNode n34 = new RedBlackNode(5);
        RedBlackNode n35 = new RedBlackNode(8);
        RedBlackNode n36 = new RedBlackNode(4);
        RedBlackNode n37 = new RedBlackNode(5);
        RedBlackNode n38 = new RedBlackNode(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    public static void main(String[] args) {
        RBTreePrinter.printRBTree(test1());
    }
}