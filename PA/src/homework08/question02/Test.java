package homework08.question02;

/**
 * Created by Bhanu on 13/03/2016.
 */
public class Test {

    public static RedBlackNode printTest() {
        RedBlackNode root = new RedBlackNode(11);
        root.color = RedBlackNode.Color.BLACK;

        RedBlackNode n21 = new RedBlackNode(2);
        n21.color = RedBlackNode.Color.RED;
        n21.parent = root;

        RedBlackNode n22 = new RedBlackNode(14);
        n22.color = RedBlackNode.Color.BLACK;
        n22.parent = root;

        RedBlackNode n31 = new RedBlackNode(1);
        n31.color = RedBlackNode.Color.BLACK;
        n31.parent = n21;

        RedBlackNode n32 = new RedBlackNode(7);
        n32.color = RedBlackNode.Color.BLACK;
        n32.parent = n21;

        RedBlackNode n33 = new RedBlackNode(15);
        n33.color = RedBlackNode.Color.RED;
        n33.parent = n22;

        RedBlackNode n41 = new RedBlackNode(5);
        n41.color = RedBlackNode.Color.RED;
        n41.parent = n32;

        RedBlackNode n42 = new RedBlackNode(8);
        n42.color = RedBlackNode.Color.RED;
        n42.parent = n32;

        root.left = n21;
        root.right = n22;
        n21.left = n31;
        n21.right = n32;
        n22.right = n33;
        n32.left = n41;
        n32.right = n42;
        return root;
    }

    public static RedBlackNode insertTest(){

        RedBlackTree tree = new RedBlackTree();
        tree.insert(11);
        tree.insert(2);
        tree.insert(14);
        tree.insert(1);
        tree.insert(7);
//        tree.insert(15);
//        tree.insert(5);
//        tree.insert(8);

        return tree.root;
    }

    public static void main(String[] args) {

//        RBTreePrinter.printRBTree(printTest());
        RBTreePrinter.printRBTree(insertTest());


    }
}
