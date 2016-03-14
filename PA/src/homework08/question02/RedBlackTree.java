package homework08.question02;

/**
 * Created by Bhanu on 13/03/2016.
 */
public class RedBlackTree {


    public enum Color {
        RED,
        BLACK
    }

    public static class Node {
        int data;
        Color color;
        Node left;
        Node right;
        Node parent;
        boolean isNullLeaf;
    }


}
