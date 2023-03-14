package lect15;

import java.util.Random;

public class Simulator {
	
	Random rand;

	
	/*
	 *@param no is the number of values to be generated.
	 *@param lowBound is the inclusive lower bound value of the value range.
	 *@param upBound is the inclusive opper bound value of the value range. 
	 *@param interval is the interval between each pair of the values to be generated.
	 */
	public int[] genIntUniformDist(int no, int lowBound, int upBound, int interval) {
		int[] numbers = new int[no];
		int range = (upBound - lowBound)/interval + 1;
		int[] freq = new int[range];
		double[] deviation = new double[range];
		int excUpBound = range;
		System.out.println("range:" + range + ", excUpBound:" + excUpBound);
		for(int i=0; i<no; i++) {
			
			int orgValue = rand.nextInt(excUpBound);
			freq[orgValue]++;
			int scaledValue = orgValue * interval;
			int netValue = scaledValue + lowBound;
			numbers[i] = netValue;
			
			System.out.println("i:" + i + ", orgValue:" + orgValue + ", scaledValue:" + scaledValue +
					", netValue:" + netValue);
		}
		int count = 0;
		int avgCount = no/range;
		System.out.print("freq ");
		for(int i=0; i<freq.length; i++) {
			int missed = freq[i] - avgCount;
			deviation[i] = missed * 1.0 / avgCount * 100;
			System.out.print(i + ":" + freq[i] + 
					"(" + deviation[i] + ")" +
					(i<freq.length-1?", ": "\n"));
			count += freq[i];
		}
		System.out.println("count:" + count);
		return numbers;	
	}
	public Simulator() {
		rand = new Random(System.currentTimeMillis());
	}
	public static void main(String[] args) {
		/* To generate 5, 10, 15, 20, for 10 numbers */
		int param1 = 10;
		int param2 = 5;
		int param3 = 20;
		int param4 = 5;
		System.out.println("args.length:" + args.length);
		for(String str:args) {
			System.out.println("str:" + str);
		}
		if(args.length == 4) {
			try { 
				int temp1 = Integer.parseInt(args[0]);
				int temp2 = Integer.parseInt(args[1]);
				int temp3 = Integer.parseInt(args[2]);
				int temp4 = Integer.parseInt(args[3]);
				param1 = temp1;
				param2 = temp2;
				param3 = temp3;
				param4 = temp4;
			} catch(NumberFormatException ex) {
				;
			}
			
		}
		System.out.println("param1:" + param1 + ", param2:" + param2 +
				", param3:" + param3 + ", param4:" + param4);

		Simulator sim = new Simulator();
		sim.genIntUniformDist(param1, param2, param3, param4);
	}

}
