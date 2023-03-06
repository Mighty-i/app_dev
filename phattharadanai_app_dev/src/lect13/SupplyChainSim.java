package lect13;

public class SupplyChainSim {
	
	Good[] goods = {
			new Good(001, "Coke", 15, 20),
			new Good(002, "Fanta", 15, 30),
			new Good(003, "Mama", 7.5, 55),
			new Good(004, "Parrot Soap", 18.75, 40),
			new Good(005, "Colgate", 25, 33)
	};
	
	Customer[] customers = {
			new Customer(001, "John")
	};
	
	Branch[] branchs = {
			new Branch(001, "Tahkhonyang")
	};
	
	public SupplyChainSim() {
		Simulator custSim = new Simulator();
		Simulator branchSim = new Simulator();
		Simulator goodSim = new Simulator();
		Simulator quantSim = new Simulator();
		int noData = 100;
		int[] custIdArr = custSim.genIntUniformDist(noData, 0, customers.length, 1);
		int[] branchIdArr = branchSim.genIntUniformDist(noData, 0, branchs.length, 1);
		int[] goodIdArr = goodSim.genIntUniformDist(noData, 0, goods.length, 1);
		int[] quantArr = quantSim.genIntUniformDist(noData, 0, 10, 1);
		Transaction[] transactions = new Transaction[noData];
		for(int i=0; i<noData; i++) {
			int customerId = customers[custIdArr[i]].id;
			int branchId = branchs[branchIdArr[i]].id;
			String date = "2022-02-27";
			int goodId = goods[goodIdArr[i]].id;
			double price = goods[goodIdArr[i]].price;
			int quantity = quantArr[i];
			double amount = price * quantity;
			Transaction transaction = new Transaction(customerId, branchId, date, goodId, price, quantity, amount);
			transactions[i] = transaction;
			System.out.println("i:"+i+", transactios:"+ transaction.toString());
		}
	}
	public static void main(String[] args) {
		new SupplyChainSim();
	}

}
