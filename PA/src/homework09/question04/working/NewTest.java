package homework09.question04.working;

/**
 * Created by Bhanu on 20/04/2016.
 */
public class NewTest {

    public static void main(String[] args) throws EmptyHeapException {

        int[] A = {17, 12, 90, 21};
        int[] B = {25, 52, 95, 63, 18};

        BinomialHeap heapA = new BinomialHeap();
        for (int i : A) {
            heapA.insert(i);
        }
        System.out.println(heapA);


        BinomialHeap heapB = new BinomialHeap();
        for (int i : B) {
            heapB.insert(i);
        }
        System.out.println(heapB);


        heapA =  heapA.union(heapB);
        System.out.println(heapA);

        int minA= heapA.extractMin();
        System.out.println(minA);

        System.out.println(heapA);

        minA= heapA.extractMin();
        System.out.println(minA);
        System.out.println(heapA);

        heapA.print();
        Node n25 = heapA.find(25,heapA.head);
        Node n18 = heapA.find(18,heapA.head);
        System.out.println(n25.parent);
        System.out.println(n25);
        System.out.println(" ");

        heapA.decreaseKey(n25,16);
        heapA.decreaseKey(n18,10);
        System.out.println(heapA);
        heapA.print();

        Node n63 = heapA.find(63,heapA.head);


        heapA.delete(n63);
        heapA.print();



    }
}
