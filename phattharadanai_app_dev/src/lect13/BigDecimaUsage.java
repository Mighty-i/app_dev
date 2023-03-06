package lect13;

import java.math.*;

public class BigDecimaUsage {
	
	public static void main(String[] args) {
		
		System.out.println("Hello world");
		
		double dbl1 = 123456;
		double dbl2 = 7;
		double dbl3 = dbl1/dbl2;
		System.out.println("dbl1:" + dbl1 + ", db2:" + dbl2 + ", dbl3:" + dbl3);
		
		String str1 = "123456";
		String str2 = "7";
		
		MathContext mc = new MathContext(2);
		BigDecimal bd1 = new BigDecimal(str1);
		BigDecimal bd2 = new BigDecimal(str2);
		
		System.out.println("bd1:"+bd1);
		System.out.println("bd2:"+bd2);
		
		BigDecimal bd3;
//		bd3 = bd1.divide(bd2);
//		System.out.println("bd3:"+bd3);
		BigDecimal bd4 = bd1.divide(bd2,mc);
		System.out.println("bd4:"+bd4.doubleValue());
		
		bd4 = bd1.divide(bd2,2,RoundingMode.HALF_UP);
		System.out.println("bd4:"+bd4);
		
	}

}
