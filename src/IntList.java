public class IntList {
    public int element;
    public IntList next;

    public  IntList(int a, IntList p) {
        //set a = element, p = next Intlist
        this.element = a;
        this.next = p;
    }

    public int getLength() {
        int a = 0;
        IntList p = this;
        while (p != null) {
            a++;
            p = p.next;
            /*this.next doesn't equal p.next*/
        }
        return a;
    }

    public int getLength1() {
        if (next == null) {
            return 1;
        }
        return 1 + next.getLength1();
    }

    public int getelement(int index) {
        if (index==0) {
            return element;
        }
        if (next == null | index < 0) {
            return 0;
            /*int couldn't return null/*/
        }
        return next.getelement(--index);
    }

    public static void main(String[] args) {
        IntList p1 = new IntList(1, null);
        IntList p0 = new IntList(5, p1);
        System.out.println(p0.getLength());
        System.out.println(p0.getLength1());
        System.out.println(p0.getelement(1));
    }
}
