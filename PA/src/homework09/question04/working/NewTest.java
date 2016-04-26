package homework09.question04.working;

/**
 * Created by Bhanu on 20/04/2016.
 */
public class NewTest {

    public static void main(String[] args) throws EmptyHeapException {

        int[] A = {17, 10, 90, 21};
        int[] B = {25, 7, 95, 88, 18};

        BinomialHeap heapA = new BinomialHeap();
        for (int i : A) {
            heapA.insert(i);
//            System.out.println(heapA);
        }
        heapA.print();


        BinomialHeap heapB = new BinomialHeap();
        for (int j : B) {
            heapB.insert(j);
        }
        heapB.print();
//        System.out.println(heapB);


        heapA = heapA.union(heapB);
//        System.out.println(heapA);
        heapA.print();

        int minA = heapA.extractMin();
        System.out.println(minA);
        System.out.println(" ");
        heapA.print();

        Node n95 = heapA.find(95, heapA.head);
        heapA.decreaseKey(n95, 12);
        heapA.print();

        Node n21 = heapA.find(21, heapA.head);
        heapA.delete(n21);
        heapA.print();

        System.out.println(heapA.minimum());


    }
}
