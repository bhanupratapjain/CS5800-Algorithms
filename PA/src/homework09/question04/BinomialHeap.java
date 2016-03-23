package homework09.question04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bhanu on 22/03/2016.
 */
public class BinomialHeap {

    /**
     * The Head.
     */
    BinomialHeapNode head;

    /**
     * Instantiates a new Binomial heap.
     */
    BinomialHeap(){
        this.head = null;
    }

    /**
     * Make heap binomial heap.
     *
     * @return the binomial heap
     */
    public static BinomialHeap makeHeap() {
        BinomialHeap h = new BinomialHeap();
        h.head = null;
        return h;
    }

    /**
     * Minimum binomial heap node.
     *
     * @return the binomial heap node
     */
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

    /**
     * Link.
     *
     * @param x the x
     * @param y the y
     */
    static void link(BinomialHeapNode x, BinomialHeapNode y) {
        y.parent = x;
        y.sibling = x.child;
        x.child = y;
        x.degree++;
    }

    /**
     * Merge binomial heap.
     *
     * @param x the x
     * @return the binomial heap
     */
    BinomialHeap merge(BinomialHeap x) {
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

    /**
     * Union binomial heap.
     *
     * @param x the x
     * @return the binomial heap
     */
    public BinomialHeap union(BinomialHeap x) {
        merge(x);
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

    /**
     * Insert.
     *
     * @param key the key
     */
    public void insert(int key) {
        BinomialHeapNode x = new BinomialHeapNode(key);
        insert(x);
    }

    /**
     * Insert.
     *
     * @param x the x
     */
    public void insert(BinomialHeapNode x) {
        if (this.head == null)
            head = x;
        else {
            BinomialHeap temp = makeHeap();
            temp.head = x;
            union(temp);
        }
    }

    /**
     * Extract min binomial heap node.
     *
     * @return the binomial heap node
     */
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

    /**
     * Decrease key.
     *
     * @param x the x
     * @param k the k
     */
    public void decreaseKey(BinomialHeapNode x, int k) {
        if (k >= x.key) {
            System.out.println("New key is not smaller than current key!");
            return;
        }
        x.key = k;
        BinomialHeapNode y = x.parent;
        while (y != null && y.key > x.key) {
            exchange(x,y);
            x = y;
            y = x.parent;
        }
    }

    /**
     * Exchange.
     *
     * @param x the x
     * @param y the y
     */
    public void exchange(BinomialHeapNode x, BinomialHeapNode y) {
        x.key ^= y.key;
        y.key ^= x.key;
        x.key ^= y.key;
    }

    /**
     * Delete.
     *
     * @param x the x
     */
    public void delete(BinomialHeapNode x) {
        decreaseKey(x, Integer.MIN_VALUE);
        extractMin();
    }

    /**
     * Delete.
     *
     * @param keyValue the keyValue
     */
    public void delete(int keyValue) {
        BinomialHeapNode x = find(keyValue, this.head);
        if (x == null) {
            System.out.println("No such BinomialHeapNode!");
            return;
        }
        decreaseKey(x, Integer.MIN_VALUE);
        extractMin();
    }

    /**
     * Find binomial heap node.
     *
     * @param key              the key
     * @param binomialHeapNode the binomial heap node
     * @return the binomial heap node
     */
    public BinomialHeapNode find(int key, BinomialHeapNode binomialHeapNode) {
        if (null == binomialHeapNode) {
            return null;
        }
        if (key == binomialHeapNode.key) {
            return binomialHeapNode;
        }
        BinomialHeapNode n1 = find(key, binomialHeapNode.sibling);
        BinomialHeapNode n2 = find(key, binomialHeapNode.child);
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

    /**
     * Traversal.
     *
     * @param binomialHeapNode the binomial heap node
     */
    public void traversal(BinomialHeapNode binomialHeapNode) {
        if (null == binomialHeapNode) {
            return;
        }
        System.out.print(binomialHeapNode.key + ",");
        traversal(binomialHeapNode.child);
        traversal(binomialHeapNode.sibling);

    }

    public void print(BinomialHeapNode binomialHeapNode){
        if (null ==binomialHeapNode) {
            return;
        }
        List<BinomialHeapNode> nextLevelNodes = new ArrayList<BinomialHeapNode>();
        nextLevelNodes.add(binomialHeapNode);

        for(int i=0;i<nextLevelNodes.size();i++){
            BinomialHeapNode node = nextLevelNodes.get(i);
            while (null!=node){
                System.out.print(node.key + " ");
                nextLevelNodes.add(node.child);
                node = node.sibling;
            }
            System.out.println();
            nextLevelNodes.remove(i);
        }

    }

    public void print(){
        System.out.println("Binomial heap:");
        if (head != null) {
            print(0,this.head);
        }
    }

    public void print(int level, BinomialHeapNode curr) {
        while (curr != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append(" ");
            }
            if (level!=0) {
                sb.append("\\");
            }

            sb.append(String.valueOf(curr.key));
            System.out.println(sb.toString());
            if (curr.child != null) {
                print(level + 1, curr.child);
            }
            curr = curr.sibling;
        }
    }


}
