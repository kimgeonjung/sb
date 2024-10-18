package edu.du.sb1010_2.chap07;

public class ImpeCalculator implements Calculator {

    @Override
    public long factorial(long num) {
//        long start = System.nanoTime();
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
//        long end = System.nanoTime();
//        System.out.println("Factorial of " + num + " is " + (end - start) + " milliseconds");
        return factorial;
    }
}
