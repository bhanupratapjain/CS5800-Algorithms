package homework09.question04;

/**
 * Created by Bhanu on 22/03/2016.
 */
public class BinomialHeap {

    BinomialHeapNode head;

    BinomialHeap(){
        this.head = null;
    }

    public static BinomialHeap makeHeap() {
        BinomialHeap h = new BinomialHeap();
        h.head = null;
        return h;
    }

    public BinomialHeapNode minimum() {
        BinomialHeapNode x = this.head;
        BinomialHeapNode y = null;
        int min = Integer.MAX_VALUE;
        while (x != null) {
            if (x.key < min) {
                min = x.key;
                y = x;
            }
            x = x.sibling;
        }
        return y;
    }

    static void link(BinomialHeapNode x, BinomialHeapNode y) {
        y.parent = x;
        y.sibling = x.child;
        x.child = y;
        x.degree++;
    }

    BinomialHeap Binomial_Heap_Merge(BinomialHeap x) {
        BinomialHeapNode p = null;
        BinomialHeapNode headx = this.head;
        BinomialHeapNode heady = x.head;
        if (headx.degree < heady.degree) {
            p = headx;
            headx = headx.sibling;
        } else {
            p = heady;
            heady = heady.sibling;
        }
        this.head = p;
        while (headx != null && heady != null) {
            if (headx.degree <= heady.degree) {
                p.sibling = headx;
                headx = headx.sibling;
            } else {
                p.sibling = heady;
                heady = heady.sibling;
            }
            p = p.sibling;
        }
        if (headx != null)
            p.sibling = headx;
        if (heady != null)
            p.sibling = heady;
        return this;
    }

    public BinomialHeap union(BinomialHeap x) {
        Binomial_Heap_Merge(x);
        x = null;
        if (this.head == null)
            return this;
        BinomialHeapNode prev = null;
        BinomialHeapNode cur = this.head;
        BinomialHeapNode next = cur.sibling;
        while (next != null) {
            if (cur.degree != next.degree
                    || (next.sibling != null && cur.degree == next.sibling.degree)) {
                prev = cur;
                cur = next;
            } else if (cur.key < next.key) {
                cur.sibling = next.sibling;
                link(cur, next);
            } else {
                if (prev == null)
                    this.head = next;
                else
                    prev.sibling = next;
                link(next, cur);
                cur = next;
            }
            next = cur.sibling;
        }
        return this;
    }

    public void insert(int ele) {
        BinomialHeapNode x = new BinomialHeapNode(ele);
        insert(x);
    }

    public void insert(BinomialHeapNode x) {
        if (this.head == null)
            head = x;
        else {
            BinomialHeap temp = makeHeap();
            temp.head = x;
            union(temp);
        }
    }

    public BinomialHeapNode extractMin() {
        BinomialHeapNode x = this.head;
        BinomialHeapNode p = null, y = null, z = null;
        int min = Integer.MAX_VALUE;
        while (x != null) {
            if (x.key < min) {
                min = x.key;
                y = x;
                z = p;
            }
            p = x;
            x = x.sibling;
        }
        z.sibling = y.sibling;
        BinomialHeap temp = makeHeap();
        BinomialHeapNode cur = y.child;
        if (cur == null)
            return y;
        BinomialHeapNode prev = null;
        BinomialHeapNode next = cur.sibling;
        while (next != null) {
            cur.sibling = prev;
            cur.parent = null;
            prev = cur;
            cur = next;
            next = cur.sibling;
        }
        cur.sibling = prev;
        cur.parent = null;
        temp.head = cur;
        union(temp);
        return y;
    }

    public void decreaseKey(BinomialHeapNode x, int k) {
        if (k >= x.key) {
            System.out.println("New key is not smaller than current key!");
            return;
        }
        x.key = k;
        BinomialHeapNode y = x.parent;
        while (y != null && y.key > x.key) {
            Exchange(x,y);
            x = y;
            y = x.parent;
        }
    }

    private void Exchange(BinomialHeapNode x, BinomialHeapNode y) {
        x.key ^= y.key;
        y.key ^= x.key;
        x.key ^= y.key;
    }

    public void delete(BinomialHeapNode x) {
        decreaseKey(x, Integer.MIN_VALUE);
        extractMin();
    }

    public void delete(int ele) {
        BinomialHeapNode x = find(ele, this.head);
        if (x == null) {
            System.out.println("No such BinomialHeapNode!");
            return;
        }
        decreaseKey(x, Integer.MIN_VALUE);
        extractMin();
    }

    public BinomialHeapNode find(int key, BinomialHeapNode BinomialHeapNode) {
        if (null == BinomialHeapNode) {
            return null;
        }
        if (key == BinomialHeapNode.key) {
            return BinomialHeapNode;
        }
        BinomialHeapNode n1 = find(key, BinomialHeapNode.sibling);
        BinomialHeapNode n2 = find(key, BinomialHeapNode.child);
        if (n1 != null || n2 != null) {
            if (n1 != null) {
                return n1;
            } else {
                return n2;
            }
        } else {
            return null;
        }
    }

    public void traversal(BinomialHeapNode BinomialHeapNode) {
        if (null == BinomialHeapNode) {
            return;
        }
        System.out.print(BinomialHeapNode.key + ",");
        traversal(BinomialHeapNode.child);
        traversal(BinomialHeapNode.sibling);

    }
}
