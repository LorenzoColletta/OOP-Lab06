package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    private static final int MIN = 1000;
    private static final int MAX = 2000;
    
    private static final int ELEMS = 100_000;
    private static final int TO_MS = 1_000_000;
    
    public static void main(final String... s) {
        
    	/*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
    
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	final List<Integer> numbers = new ArrayList<>();
    	for (int i = MIN ; i < MAX; i++) {
    		numbers.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        
    	final List<Integer> same = new LinkedList<>(numbers);
    	
    	/*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        var temporary = numbers.get(0);
        numbers.set(0, numbers.get(numbers.size() - 1));
        numbers.set(numbers.size() - 1, temporary);
    	/*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        
        for (int element : numbers) {
        	System.out.print(element);
        	System.out.print(" - ");
        }
        System.out.println();
        
    	/*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        
        long time = System.nanoTime();
        
        for (int i = 0; i < MIN; i++) {
        	numbers.add(0, i);
        }
        
        time = System.nanoTime() - time;
        System.out.println("Time required to add 100.000 elements to ArrayList: " +time/TO_MS + "ms");
        
        time = System.nanoTime();
        
        for (int i = 0; i < MIN; i++) {
        	same.add(0, i);
        }
        
        time = System.nanoTime() - time;
        System.out.println("Time required to add 100.000 elements to LinkedList: " +time/TO_MS + "ms");
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        time = System.nanoTime();
        
        for (int i = 0; i < ELEMS; i++) {
        	numbers.get((int)(numbers.size()/2));
        }
        
        time = System.nanoTime() - time;
        System.out.println("Time required to read 1000 times the element '" + numbers.get((int)(numbers.size()/2)) + "' from ArrayList: " + time/TO_MS + "ms");
        
        time = System.nanoTime();
        
        for (int i = 0; i < ELEMS; i++) {
        	same.get((int)(same.size()/2));
        }
        
        time = System.nanoTime() - time;
        System.out.println("Time required to read 1000 times the element '" + same.get((int)(same.size()/2)) + "' from LinkedList: " + time/TO_MS + "ms");
        
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
        
        
        final Map<String, Long> popolation = new HashMap<>(); 
        popolation.put("Africa" , 1_110_635_000L);
        popolation.put("Americas" , 972_005_000L);
        popolation.put("Antarctica" , 0L);
        popolation.put("Asia" , 4_298_723_000L);
        popolation.put("Europe" , 742_452_000L);
        popolation.put("Oceania" , 38_304_000L);
        
        /*
         * 8) Compute the population of the world
         */
        Long worldP = 0L;
        for( Long singleP : popolation.values()) {
        	worldP += singleP;
        }
        System.out.println("Entire world population: " + worldP);
    }
}
