package ex3;

import java.util.ArrayList;

public class dao {
	public ArrayList<good> ViewDAO() {

		System.out.println("View Shop");
		ArrayList<good> GOODS = null;

		Object[][] data = { { "Coke can", "Can", new Integer(15), new Integer(0), new Integer(0) },
				{ "Fanta 1.5 Litre", "Bottle", new Integer(25), new Integer(0), new Integer(0) },
				{ "Soap Parrot", "Bar", new Integer(20), new Integer(0), new Integer(0) },
				{ "Orange Jam", "Can", new Integer(35), new Integer(0), new Integer(0) }, };

		GOODS = new ArrayList<good>();

		for (Object[] row : data) {

			String good = row[0].toString();
			String name = row[1].toString();
			int price = ((Integer) row[2]).intValue();
			int qty = ((Integer) row[3]).intValue();
			int amount = ((Integer) row[4]).intValue();
			good Good = new good(good, name, price, qty, amount);
			GOODS.add(Good);
			System.out.println("Item is : " + good.toString());

		}

		return GOODS;
	}

}
