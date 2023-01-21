package week8_hashmap;

import java.util.HashMap;

public interface MyHashMap {
	
	public static void main(String[] args) {
		HashMap<Integer, Fruit> map = new HashMap<Integer, Fruit>();
		Fruit f1 = new Fruit(1, "Mango", 10);
		Fruit f2 = new Fruit(2, "Banana", 30);
		
		map.put(new Integer(1), f1);
		map.put(new Integer(2), f2);
		map.put(Integer.parseInt("3"), new Fruit(3,  "Grape",20));
		System.out.println("map:"+map);
		map.replace(new Integer(2), new Fruit(2, "Melon", 40));
		Fruit fruit = map.get(new Integer(2));
		System.out.println("fruit:"+fruit);
		System.out.println("map:"+map);
	}

}
