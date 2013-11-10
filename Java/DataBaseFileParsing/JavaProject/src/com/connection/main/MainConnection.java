package com.connection.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.readfiles.ReadOrderFile;
import com.readfiles.ReadPersonFile;
import com.simpleobjects.OrderObject;
import com.simpleobjects.PersonObject;

public class MainConnection {

	private static final String USERNAME = "admin";
	private static final String PASSWORD = "";
	private static final String CONN_STRING ="jdbc:mysql://localhost/test";
	
	private static final String INSERT_ELEMENT_INTO_PERSON_TABLE = "INSERT INTO `test`.`person` (`PERSON_ID`, `FIRST_NAME`, `LAST_NAME`, `STREET`, `CITY`)";  
	private static final String INSERT_ELEMENT_INTO_ORDER_TABLE = "INSERT INTO `test`.`order` (`ORDER_ID`, `ORDER_NO`, `PERSON_ID`)";  
	private static final String SELECT_FROM_TABLES_PERSON_WITH__AT_LEAST_ONE_ORDER = 
			"SELECT `person`.`PERSON_ID`, `person`.`FIRST_NAME`,`person`.`LAST_NAME`, `person`.`STREET`, " +
			"`person`.`CITY`,`ORDER_NO`,`ORDER_ID` FROM `test`.`person`,`test`.`order` WHERE `person`.`PERSON_ID` = `order`.`PERSON_ID`";
	
	
	public static void main(String[] args) throws SQLException {
		
		
		Connection conn = null;
		Statement stmt = null;
		try {
			@SuppressWarnings("unused")
			int rs;
			ReadPersonFile readPerson = new ReadPersonFile();
			ReadOrderFile readOrder = new ReadOrderFile();
			
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			
			System.out.println("Connected");
			List<PersonObject> persons = readPerson.readLines();
			for (int i = 0; i < persons.size(); i++) {
				
				rs = stmt.executeUpdate(INSERT_ELEMENT_INTO_PERSON_TABLE + 
						"values('"+persons.get(i).getPersonId()+"','"+persons.get(i).getFirstName()+"','"
						+persons.get(i).getLastName()+"','"+persons.get(i).getStreet()+"','"+persons.get(i).getCity()+"')");
				
			}
			
			
			@SuppressWarnings("unused")
			int rs2;
			List<OrderObject> orders = readOrder.readLines();
			
			for (int j = 0; j < orders.size(); j++) {
				
				rs2 = stmt.executeUpdate(INSERT_ELEMENT_INTO_ORDER_TABLE + 
						"values('"+orders.get(j).getOrderId()+"','"+orders.get(j).getOrderNumber()+"','"
						+orders.get(j).getPersonId()+"')");
			}
			System.out.println("\n" + "Connected!" + "\n" + "Inserted");
			ResultSet selectResult = stmt.executeQuery(SELECT_FROM_TABLES_PERSON_WITH__AT_LEAST_ONE_ORDER);
			while (selectResult.next()) {
				String personId = selectResult.getString("PERSON_ID");
				String firstName = selectResult.getString("FIRST_NAME");
				String lastName = selectResult.getString("LAST_NAME");
				String street = selectResult.getString("STREET");
				String city = selectResult.getString("CITY");			
				String orderNo = selectResult.getString("ORDER_NO");
				String orderId = selectResult.getString("ORDER_ID");
				System.out.println(personId + " " + firstName + " " 
				        + lastName + " "  + street + " " + city + " "  + orderNo + " " + orderId);
			}
			
		} catch (SQLException e) {
			System.err.println(e);
		}
		 catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}

