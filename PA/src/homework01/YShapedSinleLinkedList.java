package homework01;

/**
 * Created by Bhanu on 24/01/2016.
 */
public class YShapedSinleLinkedList {

    // Two Heads of the Y shaped Linked List
    Node headA;
    Node headB;

    public Node getHeadB() {
        return headB;
    }

    public void setHeadB(Node headB) {
        this.headB = headB;
    }


    /**
     * @param head
     * @return the length of the list from the current head.
     */
    int countLength(Node head) {

        int length = 0;
        Node nextNode = head;
        while (nextNode != null) {
            length = length + 1 ;
            nextNode = nextNode.getNextNode();
        }
        return length;
    }


    String findIntersection(Node headA, Node headB) {

        int lengthA, lengthB, diff = 0;
        Node bigHead, smallHead = null;

        lengthA = countLength(headA);
        lengthB = countLength(headB);

        if (lengthA == lengthB) {
            return "Both the List have the same length, hence they are the same.";
        } else if (lengthA > lengthB) {
            diff = lengthA - lengthB;
            bigHead = headA;
            smallHead = headB;
        } else {
            diff = lengthB - lengthA;
            bigHead = headB;
            smallHead = headA;
        }

        for (int i = 1; i <= diff; i++) {
            bigHead = bigHead.getNextNode();
        }

        while (bigHead != null && smallHead != null) {
            if(bigHead==smallHead){
                return String.valueOf(bigHead.getData());
            }
            bigHead = bigHead.getNextNode();
            smallHead = smallHead.getNextNode();
        }
        return "None";
    }


    public static void main(String[] args) {

        YShapedSinleLinkedList linkedList = new YShapedSinleLinkedList();

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        Node headA = node11;
        Node headB = node11;


//        headA.setNextNode(node6);
//        node6.setNextNode(node7);
//        node7.setNextNode(node8);
//        node8.setNextNode(node9);
//        node9.setNextNode(node10);
//        node10.setNextNode(node11);
//
//        headB.setNextNode(node12);
//        node12.setNextNode(node8);
//        node8.setNextNode(node9);

        linkedList.headA = headA;
        linkedList.headB = headB;

        //6 11
        // 11

        System.out.println("Running ");
        System.out.println("Count of Head A :: "+ linkedList.countLength(headA));
        System.out.println("Count of Head B :: "+ linkedList.countLength(headB));
        System.out.println("First Common Element :: "+ linkedList.findIntersection(headA,headB));


    }
}
