package week7;

import java.util.ArrayList;
import java.util.List;

class Footballer {
	int id;
	String name, surname, position;
	int age;
	int price;

	public Footballer(int id, String name, String surname, String position, int age, int price) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.age = age;
		this.price = price;
	}
	
	public String toString() {
		
		String data = "id:" + id + ", name:" + name +
				", surname:" + surname + ", position:" + position +
				", age:" + age + ",price:" + price;
		return data;
		
	}
	
}

public class ArrayListFootballer {
	
	public static void main (String[] args) {
		List<Footballer> list = new ArrayList<Footballer>();
		// Creating Books
		Footballer f1 = new Footballer(101, "Tony ", "Adams", "Sweeper", 20 , 10000000);
		Footballer f2 = new Footballer(102, "Jack ", "Alderson", "Left back", 23, 1000000000);
		Footballer f3 = new Footballer(103, "Dele", " Alli", "Midfielder", 24, 1000000);
		Footballer f4 = new Footballer(104, "John ", "Barnes", "Left wing midfield", 25, 1000000000);
		
		list.add(f1);
		list.add(f2);
		list.add(f3);
		list.add(f4);
		
		for (Footballer f : list) {
			System.out.println("f:" + f.toString());
			
		}
	}

}
