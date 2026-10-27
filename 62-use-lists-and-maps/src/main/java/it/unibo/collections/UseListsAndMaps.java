package it.unibo.collections;
import java.util.ArrayList; //added by me
import java.util.HashMap;
import java.util.LinkedList; //added by me
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit; //added by me

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        
        for (int i=1000; i<2000; i++) {
            testArray.add(i);
        }
        
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> testLinkedList = new LinkedList<Integer>();
        testLinkedList.addAll(testArray);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        
        int temp = testArray.get(testArray.size() - 1);
        testArray.set(testArray.size() - 1, testArray.get(0));
        testArray.set(0, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : testArray) {
            IO.print(i + " ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            testArray.addFirst(1);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Adding 100'000 ints to an ArrayList took " + time + "ns (" + millis + "ms)"
        );


        time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            testLinkedList.addFirst(1);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Adding 100'000 ints to a LinkedList took " + time + "ns (" + millis + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        time = System.nanoTime();
        int middle = testArray.size() / 2;
        for (int i = 0; i < 1000; i++) {
            IO.print(testArray.get(middle));
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Reading 1000 elements of an ArrayList took " + time + "ns (" + millis + "ms)"
        );


        time = System.nanoTime();
        middle = testLinkedList.size() / 2;
        for (int i = 0; i < 1000; i++) {
            IO.print(testLinkedList.get(middle));
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Reading 1000 elements of a LinkedList took " + time + "ns (" + millis + "ms)"
        );

        //Comment by the student: the LinkedList is much faster when writing, while the ArrayList is much faster when reading;
        //This is expected as the ArrayList has to relocate every i+k element when adding one at the i position;
        //But the LinkedList can only simulate the use of an index and has to read every element before i to get to i;

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> worldMap = new HashMap<String, Long>();
        worldMap.put("Africa", 1110635000L);        
        worldMap.put("Americas", 972005000L);
        worldMap.put("Antarctica", 0L);
        worldMap.put("Asia", 429872300L);
        worldMap.put("Africa", 742452000L);
        worldMap.put("Africa", 38304000L);


        /*
         * 8) Compute the population of the world
         */

        //TODO: fai questo esercizio bro
    }
}
