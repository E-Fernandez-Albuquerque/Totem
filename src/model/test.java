package model;

public class test {

	public static void main(String[] args) {
		DBConnection.conectDB();
		DBTables.createTableUser();
		DBTables.createTableStation();
		DBTables.createTableReservation();
		
	}

}
