package homework08.question02;

import java.util.ArrayList;

/**
 * Created by Bhanu on 13/03/2016.
 */
public class RedBlackTree {


    /**
     * The Nil.
     */
/*Initializing root to nil*/
    public RedBlackNode nil = new RedBlackNode();
    /**
     * The Root.
     */
    public RedBlackNode root = nil;

    /**
     * Instantiates a new Red black tree.
     */
    public RedBlackTree() {
        root.left = nil;
        root.right = nil;
        root.parent = nil;
    }


    /**
     * Insert.
     *
     * @param key the key
     */
    public void insert(int key) {
        RedBlackNode redBlackNode = new RedBlackNode(key);
        insert(redBlackNode);
    }

    private void insert(RedBlackNode z) {

        /* y will act as the placeholder to store the lead node*/
        RedBlackNode y = nil;
        RedBlackNode x = root;

        /*Continue till we reach the end.*/
        while (x != nil && x != null) {
            y = x;
            if (z.key < x.key) {
                //Go Left
                x = x.left;
            } else {
                //Go Right
                x = x.right;
            }
        }

        /*y becomes the parent of z*/
        z.parent = y;

        /*y will only be nil if our while loop exited before 1st step
          thus we put z at the root. Else we find the appropriate left or right
          position for z under y
          */
        if (y == nil || y == null) {
            root = z;
        } else if (z.key < y.key) {
            //z.color = RedBlackNode.Color.RED;
            y.left = z;
        } else {
            //z.color = RedBlackNode.Color.RED;
            y.right = z;
        }

        /*Initialize Z
         */
        z.left = nil;
        z.right = nil;
        z.color = RedBlackNode.Color.RED;


        /*We now fixup the RB tree*/
        insertFixup(z);

    }

    private void insertFixup(RedBlackNode z) {

        /*y will hold z's uncle*/
        RedBlackNode y = nil;

        /*There is RBT violation only while the z's parent color is RED*/
        while (z.parent.color == RedBlackNode.Color.RED) {

            /*When z.parent is left of z.parent.parent*/
            if (z.parent == z.parent.parent.left) {

                y = z.parent.parent.right;

                /*Case 1: If z's uncle is red*/
                if (y.color == RedBlackNode.Color.RED) {
                    /*Color Change:
                     z's uncle->black
                     z's parent->black
                     z's grandfather->red
                     replace z with parent
                     */
                    z.parent.color = RedBlackNode.Color.BLACK;
                    y.color = RedBlackNode.Color.BLACK;
                    z.parent.parent.color = RedBlackNode.Color.RED;
                    z = z.parent.parent;

                } else {
                    /*Case 2:
                    i) If z's uncle is Black
                    ii) Z is the right child
                    */
                    if (z == z.parent.right) {
                        z = z.parent;
                        rotateLeft(z);
                    }

                    /*Case 3:
                    i) If z's uncle is Black
                    ii) Z is the left child
                    */
                    z.parent.color = RedBlackNode.Color.BLACK;
                    z.parent.parent.color = RedBlackNode.Color.RED;
                    rotateRight(z.parent.parent);
                }
            }
            /*When z.parent is right of z.parent.parent*/
            else {
                y = z.parent.parent.left;

                /*Case 1: If z's uncle is red*/
                if (y.color == RedBlackNode.Color.RED) {
                    /*Color Change:
                     z's uncle->black
                     z's parent->black
                     z's grandfather->red
                      replace z with parent
                     */
                    z.parent.color= RedBlackNode.Color.BLACK;
                    y.color = RedBlackNode.Color.BLACK;
                    z.parent.parent.color = RedBlackNode.Color.RED;
                    z = z.parent.parent;
                } else {
                    /*Case 2:
                    i) If z's uncle is Black
                    ii) Z is the right child
                    */
                    if (z == z.parent.left) {
                        z = z.parent;
                        rotateRight(z);
                    }

                    /*Case 3:
                    i) If z's uncle is Black
                    ii) Z is the left child
                    */
                    z.parent.color = RedBlackNode.Color.BLACK;
                    z.parent.parent.color = RedBlackNode.Color.RED;
                    rotateLeft(z.parent.parent);
                }

            }
        }
        /*Making Sure Root remains black*/
        root.color = RedBlackNode.Color.BLACK;
    }

    /**
     * Rotate right.
     *
     * @param y the y
     */
    public void rotateRight(RedBlackNode y) {

        RedBlackNode x = y.left;
        /*Turn X's Right Subtree in Y's Left Subtree*/
        y.left = x.right;

        /*Check if x has a right, then link x's right to y as parent*/
        if (x.right != nil && x.right != null) {
            x.right.parent = y;
        }

        x.parent = y.parent;
        /*Check if y's parent are nil then x will be root*/
        if (y.parent == nil) {
            root = x;
        }
        /*if y is right of Parent, then make x as right of y's parent*/
        else if (y.parent.right == y) {
            y.parent.right = x;
        }
        /*y is left of its parent, make x left of its parent*/
        else {
            y.parent.left = x;
        }

        /*y becomes x's right*/
        x.right = y;
        y.parent = x;
    }

    /**
     * Rotate left.
     *
     * @param x the x
     */
    public void rotateLeft(RedBlackNode x) {
        RedBlackNode y = x.right;
        /*Turn Y's Left Subtree in X's Right Subtree*/
        x.right = y.left;

        /*Check if y has a left, then link y's left to x as parent*/
        if (y.left != nil && y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        /*Check if x's parent are nil then y will be root*/
        if (x.parent == nil || x.parent == null) {
            root = y;
        }
        /*if x is left of Parent, then make y as left of x's parent*/
        else if (x.parent.left == x) {
            x.parent.left = y;
        }
        /*x is right of its parent, make y right of its parent*/
        else {
            x.parent.right = y;
        }

        /*x becomes y's left*/
        y.left = x;
        x.parent = y;
    }


    /**
     * Search red black node.
     *
     * @param key the key
     * @return the red black node
     */
    public RedBlackNode search(int key) {
        RedBlackNode currentNode = root;
        while (currentNode != nil && currentNode != null) {
            if (currentNode.key == key) {
                return currentNode;
            } else if (key > currentNode.key) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        return null;
    }


    /**
     * Mininmum red black node.
     *
     * @param node the node
     * @return the red black node
     */
    public RedBlackNode min(RedBlackNode node) {
        RedBlackNode currentNode = node;
        while (currentNode.left != nil && currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    /**
     * Max red black node.
     *
     * @param node the node
     * @return the red black node
     */
    public RedBlackNode max(RedBlackNode node) {
        RedBlackNode currentNode = node;
        while (currentNode.right != nil && currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }


    /**
     * Successor red black node.
     *
     * @param node the node
     * @return the red black node
     */
    public RedBlackNode successor(RedBlackNode node) {
        RedBlackNode currentNode = node;
        if (currentNode.right != nil && currentNode.right != null) {
            return this.min(currentNode.right);
        }
        RedBlackNode y = currentNode.parent;
        while (y != nil && y != null && currentNode == y.right) {
            currentNode = y;
            y = y.parent;
        }
        return y;
    }


    /**
     * Predeccessor red black node.
     *
     * @param node the node
     * @return the red black node
     */
    public RedBlackNode predecessor(RedBlackNode node) {
        RedBlackNode currentNode = node;
        if (currentNode.left != nil && currentNode.left != null) {
            return this.max(currentNode.left);
        }
        RedBlackNode x = currentNode.parent;
        while (x != nil && x != null && currentNode == x.left) {
            currentNode = x;
            x = x.parent;
        }
        return x;
    }


    /**
     * Sort array list.
     *
     * @param node the node
     * @return the array list
     */
    public ArrayList<Integer> sort(RedBlackNode node) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        if (node != nil && node != null) {
            sortedList.addAll(sort(node.left));
            sortedList.add(node.key);
            sortedList.addAll(sort(node.right));
        }
        return sortedList;
    }

}
