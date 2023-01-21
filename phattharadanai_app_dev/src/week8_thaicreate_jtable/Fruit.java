package week8_thaicreate_jtable;

public class Fruit {

	int no;
	int id;
	String name;
	int price;

	public Fruit(int no,int id, String name, int price) {

		this.no = no;
		this.id = id;
		this.name = name;
		this.price = price;

	}

	public String toString() {
		String data = "No:"+no+"id:" + id + ",name:" + name + ", price:" + price;
		return data;
	}

}
