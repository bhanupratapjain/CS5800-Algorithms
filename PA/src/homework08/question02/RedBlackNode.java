package homework08.question02;

/**
 * Created by Bhanu on 13/03/2016.
 */
public class RedBlackNode{

    public enum Color {
        RED,
        BLACK
    }

    public int data;
    public int key;
    public Color color;
    public RedBlackNode left;
    public RedBlackNode right;
    public RedBlackNode parent;


    public RedBlackNode(){
        color = Color.BLACK;
        parent = null;
        left = null;
        right = null;
    }

    public RedBlackNode(int key) {
        this();
        this.key = key;
    }

}
