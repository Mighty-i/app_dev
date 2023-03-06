package week8_jtablemodel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.SQLException;

public class Ex12FruitDAO {
			
	public void addCar(Ex12Car car) {
		System.out.println("Add car");
		try {
			String insertSql = "INSERT INTO CAR VALUES" + "(" + car.plate + ", '" + car.model + "', '" + car.make
					+ "')";
			System.out.println("insertSql:" + insertSql);

			Ex12ConnectionFactory connDB = new Ex12ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Car added successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void editCar(Ex12Car car) {
		System.out.println("Edit car");
		try {
			String updateSql = "UPDATE CAR SET MODEL='" + car.model 
					+ "', MAKE='" + car.make + "' WHERE PLATE=" + car.plate;
			System.out.println("updateSql:" + updateSql);

			Ex12ConnectionFactory connDB = new Ex12ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Car updated successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteCar(int plate) {
		System.out.println("Delete car");
		try {
			String deleteSql = "DELETE FROM CAR WHERE PLATE=" + plate;
			System.out.println("deleteSql:" + deleteSql);

			Ex12ConnectionFactory connDB = new Ex12ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(deleteSql);
				stmnt.close();
				con.close();
				System.out.println("Deleted successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Ex12Car searchCar(int plate) {
		System.out.println("Search car");
		Ex12Car ex12Car = null;
		try {
			String searchSql = "SELECT * FROM CAR WHERE PLATE=" + plate;
			System.out.println("selectSql:" + searchSql);

			Ex12ConnectionFactory connDB = new Ex12ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(searchSql);
				if (rs.next()) {
					String model = rs.getString("MODEL");
					String make = rs.getString("MAKE");
					ex12Car = new Ex12Car(plate, model, make);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid plate");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ex12Car;
	}
	
	public ArrayList<Ex12Car> viewFruit() {
		System.out.println("View car");
		ArrayList<Ex12Car> cars = null;
		
		try {
			String viewSql = "SELECT * FROM CAR";
			System.out.println("selectSql:" + viewSql);
			
			cars = new ArrayList<Ex12Car>();

			Ex12ConnectionFactory connDB = new Ex12ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int plate = rs.getInt("PLATE");
					String model = rs.getString("MODEL");
					String make = rs.getString("MAKE");
					Ex12Car ex12Car = new Ex12Car(plate, model, make);
					cars.add(ex12Car);
					System.out.println("ex12Car:" + ex12Car.toString());
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return cars;
	}
	
	public ArrayList<Ex12Fruit> viewFruitArrays() {
		System.out.println("View fruit");
		ArrayList<Ex12Car> cars = null;
		
		Object[][] data = {
				{new Integer(123), "Revo", new Integer(123)},
				{new Integer(234), "Navara", new Integer(123)},
				{new Integer(345), "D-Max", new Integer(123)}
		};
		
		fruit = new ArrayList<Ex12Fruit>();
		
		for(Object[] row : data) {
			
			int id = ((Integer)row[0]).intValue();
			String name = row[1].toString();
			int price = ((Integer)row[0]).intValue();
			Ex12Fruit ex12fruit = new Ex12Fruit(id, name, price);
			fruit.add(ex12fruit);
			System.out.println("ex12fruit:" + ex12fruit.toString());
		}
		return fruit;
	}
	
}