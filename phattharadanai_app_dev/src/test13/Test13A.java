package test13;

import java.math.*;
import java.util.*;

public class Test13A {
	
	public static void main(String[] args) {
		
		System.out.println("D...");
		BigDecimal num1 = new BigDecimal(1.2345);
		BigDecimal num2 = new BigDecimal(7.8901);
		System.out.println("before adding num1:" + num1 + ", num2:" + num2);
		num1 = num1.add(num2);
		System.out.println("after adding num1:" + num1 + ", num2:" + num2);
		
		System.out.println("C...");
		BigDecimal num3 = new BigDecimal(5.4793);
		System.out.println("before multiplying num2:" + num2 + ", num3:" + num3);
		num3 = num3.multiply(num2);
		System.out.println("after multiplying num2:" + num2 + ", num3:" + num3);
		
		Random rand = new Random(System.currentTimeMillis());
		double dbl1 = rand.nextDouble();
		double dbl2 = rand.nextDouble();
		
		System.out.println("B...");
		BigDecimal num4 = new BigDecimal(dbl1);
		BigDecimal num5 = new BigDecimal(dbl2);
		System.out.println("before subtracting num2:" + num2 + ", num3:" + num3);
		num4 = num4.subtract(num5);
		System.out.println("after subtracting num2:" + num2 + ", num3:" + num3);
		
		dbl1 *= 1000;
		dbl2 *= 1000;
		num4 = new BigDecimal(dbl1);
		num5 = new BigDecimal(dbl2);
		
		System.out.println("A...");
		System.out.println("before multiplying num4:" + num4 + ", num5:" + num5);
		num4 = num4.multiply(num5);
		System.out.println("after multiplying num4:" + num4 + ", num5:" + num5);
		System.out.println("before subtracting num4:" + num4 + ", num5:" + num5);
		num4 = num4.subtract(num5);
		System.out.println("after subtracting num4:" + num4 + ", num5:" + num5);
		
	}

}
