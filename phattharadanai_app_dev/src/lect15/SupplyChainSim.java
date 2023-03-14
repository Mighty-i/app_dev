package lect15;

public class SupplyChainSim {
	
	Good[] goods = {
			new Good(001,	"Coke",	15,	20),
			new Good(002,	"Fanta",	15,	30),
			new Good(003,	"Mama",	7.5,	55),
			new Good(004,	"Parrot Soap",	18.75,	40),
			new Good(005,	"Colgate",	25,	33)
	};
	
	Customer[] customers = {
			new Customer(001,	"John"),
			new Customer(002,	"Nath"),
			new Customer(003,	"Tee"),
			new Customer(004,	"Oil"),
			new Customer(005,	"Non-member"),
			new Customer(006,	"Boat"),
			new Customer(007,	"Pluem")
	};
	
	Branch[] branches = {
			new Branch(001,	"Tahkhonyang"),
			new Branch(002,	"Khamreang"),
			new Branch(003,	"Donyom"),
			new Branch(004,	"Kantara"),
			new Branch(005,	"Dondum")
	};
	
	Taxinvoice[] taxinvoice = {
			new Taxinvoice(001,	"Yes"),
			new Taxinvoice(002,	"No"),
			new Taxinvoice(003, "Ok")
			
	};


	Transaction[] transactions;
	public SupplyChainSim(int no) {
		Simulator custSim = new Simulator();
		Simulator branchSim = new Simulator();
		Simulator goodSim = new Simulator();
		Simulator quantSim = new Simulator();
		Simulator taxSim = new Simulator();
		int noData = no;
		transactions = new Transaction[noData];
		int[] custIdArr = custSim.genIntUniformDist(noData, 0, customers.length - 1, 1);
		int[] branchIdArr = branchSim.genIntUniformDist(noData, 0, branches.length - 1, 1);
		int[] goodIdArr = goodSim.genIntUniformDist(noData, 0, goods.length - 1, 1);
		int[] quantArr = quantSim.genIntUniformDist(noData, 1, 10, 1);
		int[] taxArr = taxSim.genIntUniformDist(noData, 0, taxinvoice.length - 1, 1);
		System.out.println("custIdArr.length:" + custIdArr.length);
		System.out.println("branchIdArr.length:" + branchIdArr.length);
		System.out.println("goodIdArr.length:" + goodIdArr.length);
		System.out.println("quantArr.length:" + quantArr.length);
		System.out.println("taxArr.length:" + taxArr.length);
		for(int i=0; i<noData; i++) {
			int customerId = customers[custIdArr[i]].id;
			int branchId = branches[branchIdArr[i]].id;
			String date = "2022-02-27";
			int goodId = goods[goodIdArr[i]].id;
			double price = goods[goodIdArr[i]].price;
			int quantity = quantArr[i];
			double amount = price * quantity;
			String tax = taxinvoice[taxArr[i]].neet;
			Transaction transaction = new Transaction(customerId, branchId, date, goodId, 
					price, quantity, amount, tax);
			transactions[i] = transaction;
			System.out.println("i:" + i + ", transaction:" + transaction.toString());

		}	
		
	}
	
	public static void main(String[] args) {
		new SupplyChainSim(100);
	}
}
