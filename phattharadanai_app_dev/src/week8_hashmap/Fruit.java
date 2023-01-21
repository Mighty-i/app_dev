package week8_hashmap;

public class Fruit {
	
	int id;
	String name;
	int price;
	
	public Fruit(int id,String name,int price) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		
	}
	public String toString(){
		String data = "id:"+id+",name:"+name+", price:"+price;
		return data;
	}

}
