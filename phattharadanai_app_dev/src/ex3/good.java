package ex3;

public class good {
	String Good;
	String name;
	int price;
	int qty;
	int amount;

	public good(String Good, String name, int price, int qty, int amount) {

		this.Good = Good;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.amount = amount;

	}

	public String getGood() {
		return Good;
	}

	public void setGood(String good) {
		Good = good;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
