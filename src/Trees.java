public class Trees {
    private int[] array;
    private int size;
    public Trees(int capacity) {
        array = new int[capacity + 1];
        size = 0;
    }

    public void add(int i) {
        array[size + 1] = i;
        size ++;
    }

    public void replace(int pos, int item) {
        array[pos] = item;
    }

    public void delete(int pos) {
        if (array[pos + 1] != 0) {
            array[pos] = 0;

        }
    }

    public int get(int pos) {
        return array[pos + 1];
    }

    /**
     * Using recursion to get the root position, and put the number of layers to the root
     * By the way set temp to 0 to pass variable
     */
    private int getRoot(int pos, int temp) {
        if (array[pos] > -1) {
            temp -= 1;
            return getRoot(pos, temp);
        }
        if (array[pos] >= temp) {
            array[pos] = temp;
        }
        return pos;
    }

    /**
     * Optimized Structure to reduce time complexity
     *
     * @Warning this action will change the structure of branches
     * After the optimization, the object linked to the root will be set to -1
     */
    private void optimizedStructure(int i) {
        int root = getRoot(i, 0);
        int temp;
        while (i != root) {
            temp = array[i];
            array[i] = root;
            i = temp;
        }
        array[root] = -1;
    }

    /**
     * Check if those branches are connected. If true,
     * connect every branches to it's root
     *
     * @Warning this method will automatically optimized the Structure
     */
    private boolean isConnect(int pos1, int pos2) {
        if (getRoot(pos1, 0) == getRoot(pos2, 0)) {
            if (pos1 > -1) {
                optimizedStructure(pos1);
            } else if (pos2 > -1) {
                optimizedStructure(pos2);
            }
            return true;
        } else return false;
    }

    /**
     * Connect two branches to the root with less layers
     *
     * @Warning this method will call isConnect
     */
    public void connect(int pos1, int pos2) {
        if (!isConnect(pos1, pos2)) {
            pos1 = getRoot(pos1,0);
            pos2 = getRoot(pos2,0);
            if (array[pos1] < array[pos2]) {
                array[pos2] = pos1;
            } else {
                array[pos1] = pos2;
            }
        }
    }
}