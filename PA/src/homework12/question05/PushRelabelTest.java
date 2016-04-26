package homework12.question05;

import homework09.question04.working.EmptyHeapException;

/**
 * Created by Bhanu on 26/04/2016.
 */
public class PushRelabelTest {

    public static void main(String[] args) throws EmptyHeapException {

        int noOfVertices = 3;
        int source=0;
        int sink=2;
        int[][] caps  = {{0,3,2},{0,0,2},{0,0,0}};
        FlowNetwork fn = new FlowNetwork(noOfVertices,source,sink,caps);
        RelabelToFront pr = new RelabelToFront(fn);
        System.out.println(pr.getMaxFlow());
    }
}