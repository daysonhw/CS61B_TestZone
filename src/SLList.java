public class SLList {
    /** Creating inner class that holds data
     * using static modifier help us save space*/
    private static class IntNode {
        private int value;
        private IntNode next;

        private IntNode(int x, IntNode y) {
            value = x;
            next = y;
        }

        private IntNode() {
            value = 0;
            next = null;


        }
    }

    /**Create sentinel as a middleman to operate data in IntNode */
    private IntNode sentinel;
    private int size;

    public SLList() {
        size = 1;
        sentinel = new IntNode();
        sentinel.next = new IntNode();
    }

    public SLList(int x, SLList s) {
        sentinel = new IntNode();
        if (s != null) {
            size = 1 + s.size;
            s.sentinel.next = new IntNode(x, s.sentinel.next);
        } else {
            size = 1;
        }
        sentinel.next = new IntNode(x, null);
    }

    public void addFirst(int x) {
        size++;
        sentinel.next = new IntNode(x, sentinel.next.next);
    }

    public void addLast(int x) {
        size++;
        if (sentinel.next != null) {
            IntNode p = sentinel.next;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new IntNode(x, null);
        }
        sentinel.next = new IntNode(x, null);
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        SLList p = new SLList(5,null);
        SLList p1 = new SLList(3, p);
        System.out.println(p1.getSize());
        p1.addLast(3);
        System.out.println(p1.getSize());
    }
}