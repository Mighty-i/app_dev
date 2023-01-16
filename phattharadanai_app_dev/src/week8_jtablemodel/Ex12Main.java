package week8_jtablemodel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.SQLException;

public class Ex12Main {

	Ex12JMenu ex12JMenu;

	public void addCar(Ex12Car car) {

		System.out.println("Add car");
		Ex12CarDAO dao = new Ex12CarDAO();
		dao.addCar(car);
		System.out.println("Car added successfully.");

	}

	public void editCar(Ex12Car car) {
		
		System.out.println("Edit car");
		Ex12CarDAO dao = new Ex12CarDAO();
		dao.editCar(car);
		System.out.println("Car edited successfully.");
		
	}

	public void deleteCar(int plate) {
		
		System.out.println("Delete car");
		Ex12CarDAO dao = new Ex12CarDAO();
		dao.deleteCar(plate);
//		ex12JMenu.ex12FormDelete.setForm();
		System.out.println("Car deleted successfully.");

	}

	public void searchCar(int plate) {
		
		System.out.println("Search car");
		Ex12CarDAO dao = new Ex12CarDAO();
		Ex12Car car = dao.searchCar(plate);
//		ex12JMenu.ex12FormSearch.setForm(car);
		System.out.println("Searched successfully.");
		
	}

	public void viewCars() {

		System.out.println("View car");
		Ex12CarDAO dao = new Ex12CarDAO();
//		ArrayList<Ex12Car> cars = dao.viewCars();
		ArrayList<Ex12Car> cars = dao.viewCarsArrays();
		ex12JMenu.ex12FormView.setForm(cars);
		System.out.println("cars:" + cars.toString());
		System.out.println("Viewed successfully.");

	}

	public Ex12Main() {

		ex12JMenu = new Ex12JMenu(this);
		ex12JMenu.setVisible(true);
	}

	public static void main(String[] args) {

		new Ex12Main();

	}

}