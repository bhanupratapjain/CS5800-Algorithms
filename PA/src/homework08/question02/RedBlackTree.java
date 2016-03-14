package homework08.question02;

/**
 * Created by Bhanu on 13/03/2016.
 */
public class RedBlackTree {


    /*Initializing root to nil*/
    private RedBlackNode nil = new RedBlackNode();
    private RedBlackNode root = nil;

    public RedBlackTree() {
        root.left = nil;
        root.right = nil;
        root.parent = nil;
    }


    public void insert(int key) {
        RedBlackNode redBlackNode = new RedBlackNode(key);
        insert(redBlackNode);
    }


    private void insert(RedBlackNode z) {

        /* y will act as the placeholder to store the lead node*/
        RedBlackNode y = nil;
        RedBlackNode x = root;

        /*Continue till we reach the end.*/
        while (x != nil) {
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
        if (y == nil) {
            z.color = RedBlackNode.Color.BLACK;
            root = z;
        } else if (z.key < y.key) {
            z.color = RedBlackNode.Color.RED;
            y.left = z;
        } else {
            z.color = RedBlackNode.Color.RED;
            y.right = z;
        }

        /*We do not initialize z as in the algorithm from the book
         because we already have called a default constructor while
         creating z
         */

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
                     */

                    y.color = RedBlackNode.Color.BLACK;
                    z.color = RedBlackNode.Color.BLACK;
                    z.parent.parent.color = RedBlackNode.Color.RED;


                }
                /*Case 2:
                i) If z's uncle is Black
                ii) Z is the right child
                */
                else if (z==z.parent.right){
                    z = z.parent;
//                    leftRotate(z);
                }


                /*Case 3*/

            }
            /*When z.parent is right of z.parent.parent*/
            else {

            }
        }

    }

}
