/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.
 */

public class Accumulator {

    /**
      @return the concatenation of all the Strings
      in the \list that begin with \prefix,
      each followed by a space.
     */
    public static String catElementsStartingWith(
        List_inArraySlots list
      , String prefix
      ) {
        String result = "";

        for( int el = 0; el < list.size(); el++) {

            /* 3.  Stumbling block 0
               Java protects a programmer against applying a method to
               elements in list when some elements of the list might
               omit support for a particular operation.

               This protection is implemented by the compiler
               The following code violates the restriction:
              */
            // if (list.get(el).startsWith(prefix)) result += list.get(el);
            /*
             predicted error message: method not found in class

             actual error message:

             .\Accumulator.java:32: error: cannot find symbol
                             if (list.get(el).startsWith(prefix));
                                             ^
               symbol:   method startsWith(String)
               location: class Object
             1 error

            */
            /* 4.  Workaround 0
               A programmer should expect there to be a way to
               work around the stumbling block, because
               the compiler knows the type of an element.

               Java's instanceof operator identifies the type
               of an element to the compiler.
             */


            /* 5.  Stumbling block 1
               However, use of the operator alone is insufficient,
               because the compiler objects to the following code
               that adds use of the operator to the code from
               Stumbling block 0:
             */

            
            /*  if (list.get(el) instanceof String) {
                    if (list.get(el).startsWith(prefix)) {
                        result += list.get(el);
                    }
                }

             predicted error message: method not found in class

             actual error message:

             .\Accumulator.java:64: error: cannot find symbol
                                 if (list.get(el).startsWith(prefix)) {
                                                 ^
               symbol:   method startsWith(String)
               location: class Object
             1 error
             */

            /* 6. Workaround 1
               Programmers use Java's cast operator
               to tell the JVM that code uses a subclass's method
               on an object, even though the reference to the
               object is stored in a super-class variable.
             */

            /* 7. Stumbling block 2
               However, use of this operator alone is insufficient,
               because the JVM objects to the following code that
               adds use of the operator to the code from Stumbling
               block 0:
			
            if ( ((String)list.get(el)).startsWith(prefix) )
                result += list.get(el);

             predicted error message: cannot cast one type to another

             actual error message:

             Exception in thread "main" java.lang.ClassCastException:
             java.base/java.lang.Double cannot be cast to java.base/java.lang.String
                     at Accumulator.catElementsStartingWith(Accumulator.java:95)
                     at UserOfList.main(UserOfList.java:32)
            */

            /* 8. Workaround 2
               A programmer can combine use of both operators
               to apply a method to exactly those
               elements in the list that support the method.
             */
          if (list.get(el) instanceof String) {
              String temp = (String) list.get(el);
              if ( temp.startsWith(prefix) )
                  result += temp + ", ";
            }
        }
        return result;
    }

    /**
      @return a list of each of the Double elements
      from the \list whose value is "finite".
     */
    public static List_inArraySlots finites(List_inArraySlots list) {
		List_inArraySlots numbers = new List_inArraySlots();

        for (int el = 0; el < list.size(); el++) {
            // If el is a double, check if it is infinite.
            // If it isn't, then add it to numbers
            if (list.get(el) instanceof Double
            && !( (Double)list.get(el) ).isInfinite() )
                numbers.add( list.get(el) );
            } 
        return numbers;
    }
}
