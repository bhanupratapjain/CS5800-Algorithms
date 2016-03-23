package homework09.question04;

/**
 * Created by Bhanu on 22/03/2016.
 */
public class BinomialHeapNode {

    /**
     * The Parent.
     */
    BinomialHeapNode parent;
    /**
     * The Child.
     */
    BinomialHeapNode child;
    /**
     * The Sibling.
     */
    BinomialHeapNode sibling;
    /**
     * The Key.
     */
    int key;
    /**
     * The Degree.
     */
    int degree;

    /**
     * Instantiates a new Binomial heap node.
     *
     * @param keyValue the keyValue
     */
    public BinomialHeapNode(int keyValue) {
        parent = null;
        child = null;
        sibling = null;
        key = keyValue;
        degree = 0;
    }

}
