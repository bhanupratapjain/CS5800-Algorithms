package homework12.question05;

import homework09.question04.working.EmptyHeapException;

/**
 * Created by Bhanu on 26/04/2016.
 */
public class PushRelabelTest {

    public static void main(String[] args) {

        int noOfVertices = 3;
        int source=0;
        int sink=2;
        int[][] caps1  = {{0,3,2},{0,0,2},{0,0,0}};
        int[][] caps2  = {{0,16,13,0,0,0},{0,0,0,12,0,0},{0,4,0,0,14,0},{0,0,9,0,0,20},{0,0,0,7,0,4},{0,0,0,0,0,0}};
        FlowNetwork fn1 = new FlowNetwork(noOfVertices,source,sink,caps1);
        FlowNetwork fn2 = new FlowNetwork(6,0,5,caps2);
        PushRelabel pr1 = new PushRelabel(fn1);
        PushRelabel pr2 = new PushRelabel(fn2);
        System.out.println(pr1.getMaxFlow());
        System.out.println(pr2.getMaxFlow());
    }
}