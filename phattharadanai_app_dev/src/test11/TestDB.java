package test11;

public class TestDB {

	public static void main(String[] args) {
		
		
		DataDAO dataDAO = new DataDAO();
		dataDAO.addData(new Data(1, "Name 1"));
		dataDAO.addData(new Data(2, "Name 2"));
		dataDAO.editData(new Data(1, "Name 1-1"));
		dataDAO.searchData(2);
		dataDAO.viewDataList();
		dataDAO.deleteData(2);
		dataDAO.viewDataList();
		
	}
	
}
