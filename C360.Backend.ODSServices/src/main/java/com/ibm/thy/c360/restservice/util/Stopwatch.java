package com.ibm.thy.c360.restservice.util;

import java.text.DecimalFormat;
import java.util.Date;

/*
 * https://introcs.cs.princeton.edu/java/32class/Stopwatch.java.html
 * credit goes to Robert && Kevin
 */

/******************************************************************************
 *  Compilation:  javac Stopwatch.java
 *  Execution:    java Stopwatch n
 *  Dependencies: none
 *
 *  A utility class to measure the running time (wall clock) of a program.
 *
 *  % java8 Stopwatch 100000000
 *  6.666667e+11  0.5820 seconds
 *  6.666667e+11  8.4530 seconds
 *
 ******************************************************************************/

/**
 *  The {@code Stopwatch} data type is for measuring
 *  the time that elapses between the start and end of a
 *  programming task (wall-clock time).
 *
 *  See {@link StopwatchCPU} for a version that measures CPU time.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */


public class Stopwatch { 
	private static DecimalFormat df2 = new DecimalFormat(".");
    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch() {
//      start = System.currentTimeMillis();
    	/*
    	 *  considering below stackoverflow comments I have decided to continue with nanotime
    	 *  https://stackoverflow.com/questions/5640409/time-measuring-overhead-in-java
    	 */
        start = System.nanoTime();
    } 


    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
//    public String elapsedTimeMiliSecondString() {
////        long now = System.currentTimeMillis();
//        long now = System.nanoTime();
//        return df2.format((now - start) / 1000000.0);
//    }
    
    public String elapsedTimeMiliSecondString() {
    	return elapsedTimeMiliSecond()+"";
  }
    
    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public int elapsedTimeMiliSecond() {
//        long now = System.currentTimeMillis();
        long now = System.nanoTime();
        return (int)((now - start) / 1000000.0);
    }
    
    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public long elapsedTimeNanoSecond() {
//        long now = System.currentTimeMillis();
        long now = System.nanoTime();
        return (now - start);
    }

    

    
    /**
     * Unit tests the {@code Stopwatch} data type.
     * Takes a command-line argument {@code n} and computes the 
     * sum of the square roots of the first {@code n} positive integers,
     * first using {@code Math.sqrt()}, then using {@code Math.pow()}.
     * It prints to standard output the sum and the amount of time to
     * compute the sum. Note that the discrete sum can be approximated by
     * an integral - the sum should be approximately 2/3 * (n^(3/2) - 1).
     *
     * @param args the command-line arguments
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        int n = 10000;

        // sum of square roots of integers from 1 to n using Math.sqrt(x).
        Stopwatch timer1 = new Stopwatch();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        int time1 = timer1.elapsedTimeMiliSecond();
        System.out.println(new Date() +  " time1:" + time1);

        // sum of square roots of integers from 1 to n using Math.pow(x, 0.5).
        Stopwatch timer2 = new Stopwatch();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTimeMiliSecond();
        System.out.println(new Date() +  " time2:" + time2);
        int time22 = timer2.elapsedTimeMiliSecond();
        System.out.println(new Date() +  " time22:" + time22);
        long time3 = timer2.elapsedTimeNanoSecond();
        System.out.println(new Date() +  " time2:" + time3);
        System.out.println(new Date() +  " time2:" + timer2.elapsedTimeMiliSecondString());
        Thread.sleep(1000);
        System.out.println(new Date() +  " time3:" + timer2.elapsedTimeMiliSecondString());

        

        
		double dvalue = Double.valueOf("22");
        System.out.println("MSec "+ dvalue);
        System.out.println("Sec"+ (int)((dvalue/1000 * 1000d) + 0.5d) / 1000d);
        
    }
} 