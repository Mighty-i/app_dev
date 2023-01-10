package week7;

// https://www.javatpoint.com/java-arraylist

import java.util.*;

class Fruit {
	
	int id;
	String name;
	int price;
	
	public Fruit(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		String data = "id:" + id + ", name:" + name +
				", price:" + price;
		return data;
	}
	
}

public class ArrayListExample2 {
	public static void main(String args[]) {
		ArrayList<Fruit> list = new ArrayList<Fruit>();// Creating arraylist
		
		Fruit f1 = new Fruit(1, "Mango", 15);
		Fruit f2 = new Fruit(2, "Apple", 20);
		Fruit f3 = new Fruit(3, "Banana", 30);
		Fruit f4 = new Fruit(4, "Grape", 60);
		list.add(f1);// Adding object in arraylist
		list.add(f2);
		list.add(f3);
		list.add(f4);
		// Traversing list through Iterator
		Iterator itr = list.iterator();// getting the Iterator
		while (itr.hasNext()) {// check if iterator has the elements
			System.out.println(itr.next());// printing the element and move to next
		}
	}
}
