package week8_hashmap;

import java.util.*;

public class HashMap2 {
	public static void main(String args[]) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Amit");
		map.put(101, "Vijay");
		map.put(102, "Rahul");
		map.put(103, "Gaurav");
		map.put(104, "pwx");
		System.out.println("Initial list of elements: " + map);
		// key-based removal
		map.remove(100);
		System.out.println("Updated list of elements: " + map);
		// value-based removal
		map.remove(101);
		System.out.println("Updated list of elements: " + map);
		// key-value pair based removal
		map.remove(102, "Rahul");
		System.out.println("Updated list of elements: " + map);
	}
}
