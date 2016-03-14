package homework08.question02;

/**
 * Created by Bhanu on 13/03/2016.
 */
public class RedBlackTree {


    /*Initializing root to nil*/
    private RedBlackNode nil = new RedBlackNode();
    private RedBlackNode root = nil;

    public RedBlackTree(){
        root.left = nil;
        root.right = nil;
        root.parent = nil;
    }


    public void insert(int key) {
        RedBlackNode redBlackNode = new RedBlackNode(key);
        insert(redBlackNode);
    }


    private void insert(RedBlackNode redBlackNode){


    }

}
