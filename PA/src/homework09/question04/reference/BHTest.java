package homework09.question04.reference;

/**
 * Created by Bhanu on 22/03/2016.
 */
public class BHTest {
    public static void main(String[] args) {

        int[] E = {17, 12, 90, 21};
        int[] F = {25, 52, 95, 63, 18};
//        binomialHeap heap1 = MakeBinomialHeap();


//        int[] E = { 0, 12, 90, 1, 85, 12, 3, 13, 49, 55, 10, 3, 31, 97, 19, 93,
//                41, 55, 56, 82, 2, };
//		int[] E = { 0, 12, 90, 1, 85};
//		int[] E = { 12,7,25,15,28,33,41};
        BinomialHeap heapA = BinomialHeap.makeHeap();
        BinomialHeap heapB = BinomialHeap.makeHeap();
        BinomialHeap heapC = BinomialHeap.makeHeap();


        for (int i : E) {
            heapA.insert(i);
        }
        for (int i : F) {
            heapB.insert(i);
        }

        heapA.print();
        heapB.print();

        heapA.union(heapB);
        heapA.print();

//        int eMinNode = heapA.extractMin1();
//        System.out.println("Extracted" + eMinNode);
//        heapA.print();
//
//        int eMinNode2 = heapA.extractMin1();
//        System.out.println("Extracted" + eMinNode2);
//        heapA.print();

//        BinomialHeapNode node63 = heapA.find(63,heapA.head);
//        System.out.println(node63.key);
//
//        heapA.decreaseKey(node63,2);
//        heapA.print();
//
//        heapA.delete(17);
//        BinomialHeapNode node95 = heapA.find(95,heapA.head);
//        heapA.decreaseKey(node95,94);
//        heapA.print();

//        heapA.extractMin();
//        heapA.print();


    }
}
