/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */
// CREDIT: Based off of Amy Lei and Kyle Sacks's work with Element[] array

public class List_inArraySlots {
    // FIELDS

    private int filledElements; // the number of elements in this list
    private Object[] list;

    private static final int INITIAL_CAPACITY = 10;

    // CONSTRUCTORS

    public List_inArraySlots() {
        list = new Object[INITIAL_CAPACITY];
    }

    // METHODS

    /**
      @return the number of elements in this list
     */
    public int size() {
        return filledElements;
    }

     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
        String stringRep = "[";

        for (int index = 0; index < filledElements; index++)
            stringRep += list[index] + ",";

        stringRep += "]";
        return stringRep;
    }


    /**
      Appends @value to the end of this list.
      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add(Object input) {
          if (filledElements == list.length) expand();

          list[filledElements] = input;
          filledElements++;
          return true;
     }

    public Object get(int index){
        return list[index];
    }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
         //System.out.println( "old length:" + typeOfElements.length);
         // create new list, copy values over, and replace list
         Object[] bigger = new Object[list.length * 2];
         for(int index=0;index<list.length; index++){
             bigger[index] = list[index];
         }
         list = bigger;
         // System.out.println( "new length:" + typeOfElements.length);
     }
}
