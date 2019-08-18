/** This class is to create generics Double Linked List for manipulation(IMO) */
public class DLList<Stuff> {
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

    public void addFirst(Stuff s) {
        if (sentinel.next == null) {
            initialSentinel(s);
        } else {
            sentinel.next = new StuffNode(s, sentinel.next, sentinel);
            sentinel.next.next.prev = sentinel.next;
            size++;
        }
    }

    public void addLast(Stuff s) {
        size++;
        if (sentinel.prev == null) {
            initialSentinel(s);
        } else {
            sentinel.prev = new StuffNode(s, sentinel, sentinel.prev);
            sentinel.prev.prev.next = sentinel.prev;
        }
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
