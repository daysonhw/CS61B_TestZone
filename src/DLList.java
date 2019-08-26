/** This class is to create generics Double Linked List for manipulation(IMO) */
public class DLList<Stuff> implements CS61BList{

    private static class StuffNode<Stuff> {
        private Stuff stuff;
        private StuffNode next;
        private StuffNode prev;

        private StuffNode(Stuff s, StuffNode n, StuffNode p) {
            stuff = s;
            next = n;
            prev = p;
        }
    }

    private StuffNode sentinel;
    private int size;

    {
        size = 1;
        sentinel = new StuffNode((Stuff)new Object(),null,null);
    }

    private void initialSentinel(Stuff s) {
        sentinel.next = new StuffNode(s, sentinel, sentinel);
        sentinel.prev = sentinel.next;
    }

    @Override
    public void addFirst(Object s) {
        if (sentinel.next == null) {
            initialSentinel((Stuff) s);
        } else {
            sentinel.next = new StuffNode(s, sentinel.next, sentinel);
            sentinel.next.next.prev = sentinel.next;
            size++;
        }
    }
    @Override
    public void addLast(Object s) {
        size++;
        if (sentinel.prev == null) {
            initialSentinel((Stuff) s);
        } else {
            sentinel.prev = new StuffNode(s, sentinel, sentinel.prev);
            sentinel.prev.prev.next = sentinel.prev;
        }
    }

    @Override
    public Object getFirst() {
        return sentinel.next;
    }

    @Override
    public Object getLast() {
        return sentinel.prev;
    }

    @Override
    public Object removeLast() {
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return null;
    }

    /** Insert a stuff before position x+1 and after x */
    @Override
    public void insert(Object x, int position) {
        StuffNode stuffNode = sentinel.next;
        for (int i = 0; i < position; i++) {
            stuffNode = stuffNode.next;
        }
        stuffNode.next = new StuffNode(x, stuffNode, stuffNode.next);
        stuffNode.next.prev = stuffNode.next;
        size++;
    }

    @Override
    public int size() {
        return size;
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
        return stuffNode.stuff;
    }

    public static void main(String[] args) {
        DLList<Integer> dlList = new DLList();
        dlList.addFirst( 4);
        dlList.addFirst( 100);
        System.out.println(dlList.sentinel.next.next.stuff);
        dlList.addLast(2);
        dlList.addLast( 100);
        System.out.println(dlList.sentinel.prev.prev.stuff);
    }
}
