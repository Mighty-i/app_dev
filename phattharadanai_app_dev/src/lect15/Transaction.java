package lect15;

public class Transaction {
	
	int customerId;
	int branchId;	
	String date;
	int goodId;
	double price;
	int quantity;
	double amount;
	String taxinvoice;
	
	public Transaction(int customerId, int branchId, String date, 
			int goodId, double price, int quantity, double amount, String taxinvoice
	) {
		this.customerId = customerId;
		this.branchId = branchId;
		this.date = date;
		this.goodId = goodId;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.taxinvoice = taxinvoice;
	}

	public String toString() {
		
		String data;
		data = "customerId:" + customerId + ", branchId:" + branchId + ", date:" + date +
				", goodId:" + goodId + ", price:" + price + ", quantity:" + quantity +
				", amount:" + amount + ", taxinvoice:" + taxinvoice;
		return data;
		
	}
}
