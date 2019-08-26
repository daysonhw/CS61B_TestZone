/** A class to handle single linked list*/
public class SLList<Item> implements CS61BList {
    /** Creating inner class that holds data
     * using static modifier help us save space*/
    private static class StuffNode<Item> {
        private Item element;
        private StuffNode next;

        private StuffNode(Item x, StuffNode y) {
            element = x;
            next = y;
        }

        private StuffNode() {
        }
    }

    /**Create sentinel as a middleman to operate data in StuffNode */
    private StuffNode sentinel;
    private int size;

    private SLList() {
        size = 1;
        sentinel = new StuffNode();
        sentinel.next = new StuffNode();
    }

    private SLList(Item x, SLList s) {
        sentinel = new StuffNode();
        if (s != null) {
            size = 1 + s.size;
            s.sentinel.next = new StuffNode(x, s.sentinel.next);
        } else {
            size = 1;
        }
        sentinel.next = new StuffNode(x, null);
    }

    @Override
    public void addFirst(Object x) {
        size++;
        sentinel.next = new StuffNode(x, sentinel.next);
    }

    @Override
    public void addLast(Object x) {
        size++;
        if (sentinel.next != null) {
            StuffNode p = sentinel.next;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new StuffNode(x, null);
        }
        sentinel.next = new StuffNode(x, null);
    }

    @Override
    public Object getFirst() {
        return sentinel.next;
    }

    @Override
    public Object getLast() {
            StuffNode p = sentinel.next;
            while (p.next != null) {
                p = p.next;
            }
            return p.element;
    }

    @Override
    public Object removeLast() {
        if (sentinel.next != null) {
            StuffNode p = sentinel;
            StuffNode pb = null;
            while (p != null) {
                pb = p;
                p = p.next;
            }
            pb.next = null;
        }
        return null;
    }

    @Override
    public void insert(Object x, int position) {
        if (position == 0 && sentinel.next == null) {
            addFirst(x);
        }else {
            StuffNode stuffNode = sentinel.next;
            for (int i = 0; i < position; i++) {
                stuffNode = stuffNode.next;
                if (stuffNode == null) {
                    return;
                }
            }
            stuffNode.next = new StuffNode(x, stuffNode.next);
        }
    }

    @Override
    public Object get(int a) {
        StuffNode stuffNode = sentinel.next;
        for (int i = 0; i < a; i++) {
            if (stuffNode == null) {
                return null;
            }
            stuffNode = stuffNode.next;
        }
        return stuffNode.element;
    }

    @Override
    public int size() {
        return size;
    }


    public static void main(String[] args) {
        SLList p = new SLList(5,null);
        SLList p1 = new SLList(3, p);
        System.out.println(p1.size());
        p1.addLast(3);
        System.out.println(p1.size());
    }
}