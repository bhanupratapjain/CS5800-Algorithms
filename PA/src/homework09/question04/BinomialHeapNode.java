package homework09.question04;

/**
 * Created by Bhanu on 22/03/2016.
 */
public class BinomialHeapNode {

    BinomialHeapNode parent;
    BinomialHeapNode child;
    BinomialHeapNode sibling;
    int key;
    int degree;

    public BinomialHeapNode(int ele) {
        parent = null;
        child = null;
        sibling = null;
        key = ele;
        degree = 0;
    }


}
