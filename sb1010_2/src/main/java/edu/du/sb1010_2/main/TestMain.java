package edu.du.sb1010_2.main;

import edu.du.sb1010_2.chap07.Calculator;
import edu.du.sb1010_2.chap07.ImpeCalculator;
import edu.du.sb1010_2.chap07.RecCalculator;

public class TestMain {
    public static void main(String[] args) {
        Calculator cal1 = new ImpeCalculator();
        Calculator cal2 = new RecCalculator();
        System.out.println("Impe: "+cal1.factorial(5));
        System.out.println("Rec: "+cal2.factorial(5));
    }
}
