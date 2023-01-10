package week7;

//https://www.javatpoint.com/java-arraylist

import java.util.*;



public class ArrayListExample3 {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();// Creating arraylist
		list.add("Mango");// Adding object in arraylist
		list.add("Apple");
		list.add("Banana");
		list.add("Grapes");
		// Traversing list through for-each loop
		for (String fruit : list)
			System.out.println(fruit);

	}
}