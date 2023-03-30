package test14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.SQLException;

public class DataDAO {
			
	public void addData(Data data) {
		System.out.println("Add data");
		try {
			String insertSql = "INSERT INTO DATA VALUES" + "(" + data.id + ", " + data.price + 
					", " + data.amount;
			System.out.println("insertSql:" + insertSql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Data added successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void editData(Data data) {
		System.out.println("Edit Data");
		try {
			String updateSql = "UPDATE DATA SET PRICE='" + data.price + 
					", AMOUNT=" + data.amount  
					+ " WHERE ID=" + data.id;
			System.out.println("updateSql:" + updateSql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Data updated successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteData(int id) {
		System.out.println("Delete data");
		try {
			String deleteSql = "DELETE FROM DATA WHERE ID=" + id;
			System.out.println("deleteSql:" + deleteSql);

			ConnectionFactory connDB = new ConnectionFactory();
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
	
	public Data searchData(int id) {
		System.out.println("Search data");
		Data data = null;
		try {
			String searchSql = "SELECT * FROM DATA WHERE ID=" + id;
			System.out.println("selectSql:" + searchSql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(searchSql);
				if (rs.next()) {
					double price = rs.getDouble("PRICE");
					double amount = rs.getDouble("AMOUNT");
					data = new Data(id, price, amount);
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
		return data;
	}
	
	public ArrayList<Data> viewDataList() {
		System.out.println("View data list");
		ArrayList<Data> datas = null;
		
		try {
			String viewSql = "SELECT * FROM DATA";
			System.out.println("selectSql:" + viewSql);
			
			datas = new ArrayList<Data>();

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("ID");
					double price = rs.getDouble("PRICE");
					double amount = rs.getDouble("AMOUNT");
					Data data = new Data(id, price, amount);
					datas.add(data);
					System.out.println("data:" + data.toString());
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
		return datas;
	}
	
	public ArrayList<Data> viewDataArrays() {
		System.out.println("View data array");
		ArrayList<Data> datas = null;
		
		Object[][] dataArray = {
				{new Integer(123), new Double(123.123), new Double(234.234)},
				{new Integer(234), new Double(345.12), new Double(345.123)},
				{new Integer(345), new Double(456.78), new Double(456.789)}
		};
		
		datas = new ArrayList<Data>();
		
		for(Object[] row : dataArray) {
			
			int id = ((Integer)row[0]).intValue();
			double price = ((Double)row[1]).doubleValue();
			double amount = ((Double)row[2]).doubleValue();
			
			Data data = new Data(id, price, amount);
			datas.add(data);
			System.out.println("data:" + data.toString());
		}
		return datas;
	}
	
}