/**@version 1.0
 * @author dysnh */
 interface CS61BList<Stuff> {
     void addFirst(Stuff x);
     void addLast(Stuff y);
     Stuff getFirst();
     Stuff getLast();
     Stuff removeLast();
     int size();
     Stuff get(int i);
}
