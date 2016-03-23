package homework09.question04;

/**
 * Created by Bhanu on 22/03/2016.
 */
public class BHTest {
    public static void main(String[] args) {
//        int[] E = { 0, 12, 90, 1, 85, 12, 3, 13, 49, 55, 10, 3, 31, 97, 19, 93,
//                41, 55, 56, 82, 2, };
//		int[] E = { 0, 12, 90, 1, 85};
		int[] E = { 12,7,25,15,28,33,41};
        BinomialHeap heap = BinomialHeap.makeHeap();

        for (int i : E) {
            heap.insert(i);
//            heap.traversal(heap.head);
//            System.out.println();
        }
//		heap.traversal(heap.head);
//		heap.print();
        heap.printNew(heap.head.sibling);

//		BinomialHeapNode n = heap.find(85, heap.head);
//		System.out.println();
//		if (null == n) {
//			System.out.print("Node Not Found");
//		} else {
//            System.out.print("Key" + n.key + "\n");
//            heap.traversal(n);
//        }

//
//		System.out.println("最小值为：" + heap.minimum().key);
//
//		heap.delete(19);
//
//		heap.traversal(heap.head);
    }
}
