package homework08.question02;

/**
 * Created by Bhanu on 13/03/2016.
 */
public class RedBlackNode{

    /**
     * The enum Color.
     */
    public enum Color {
        /**
         * Red color.
         */
        RED,
        /**
         * Black color.
         */
        BLACK
    }

    /**
     * The Data.
     */
    public int data;
    /**
     * The Key.
     */
    public int key;
    /**
     * The Color.
     */
    public Color color;
    /**
     * The Left.
     */
    public RedBlackNode left;
    /**
     * The Right.
     */
    public RedBlackNode right;
    /**
     * The Parent.
     */
    public RedBlackNode parent;


    /**
     * Instantiates a new Red black node.
     */
    public RedBlackNode(){
        color = Color.BLACK;
        parent = null;
        left = null;
        right = null;
    }

    /**
     * Instantiates a new Red black node.
     *
     * @param key the key
     */
    public RedBlackNode(int key) {
        this();
        this.key = key;
    }

}
