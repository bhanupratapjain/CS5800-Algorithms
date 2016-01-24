package homework01;

/**
 * Created by Bhanu on 24/01/2016.
 */
public class Node {

    Node nextNode ;

    int data;

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node() {
        this.data = 0;
        this.nextNode = null;
    }

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }
}
