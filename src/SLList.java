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

        void addLast(int x) {
            if (next != null) {
                next.addLast(x);
                return;
            }
            next = new IntNode(x, null);
        }

    }

    /**Create sentinal as a middleman to operate data in IntNode */
    private IntNode sentinal;
    private int size;

    public SLList() {
        size = 1;
        sentinal = new IntNode();
        sentinal.next = new IntNode();
    }

    public SLList(int x, SLList s) {
        sentinal = new IntNode();
        if (s != null) {
            size = 1 + s.size;
            s.sentinal.next = new IntNode(x, s.sentinal.next);
        } else {
            size = 1;
        }
        sentinal.next = new IntNode(x, null);
    }

    public void addFirst(int x) {
        size++;
        sentinal.next = new IntNode(x, sentinal.next.next);
    }
    /**This method calls the method of IntNode*/
    public void addLast(int x){
        size++;
        sentinal.next.addLast(x);
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
