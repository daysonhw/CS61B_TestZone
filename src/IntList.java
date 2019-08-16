public class IntList {
    public int value;
    public IntList next;

    public  IntList(int a, IntList p) {
        //set a = value, p = next Intlist
        this.value = a;
        this.next = p;
    }

    public int getLength() {
        int a = 0;
        IntList p = this;
        while (p != null) {
            a++;
            p = p.next;
            //this.next doesn't equal p.next
        }
        return a;
    }

    public int getLength1() {
        if (next == null) {
            return 1;
        }
        return 1 + next.getLength1();
    }

    public int getValue(int index) {
        if (index==0) {
            return value;
        }
        if (next == null | index < 0) {
            return 0;
            //int couldn't return null
        }
        return next.getValue(--index);
    }

    public static void main(String[] args) {
        IntList p1 = new IntList(1, null);
        IntList p0 = new IntList(5, p1);
        System.out.println(p0.getLength());
        System.out.println(p0.getLength1());
        System.out.println(p0.getValue(1));
    }
}
