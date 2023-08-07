package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Retailer;

public class RetailerDAOImplementation implements RetailerDAO {

	Connection conn ; //GLOBAL 
	
	public RetailerDAOImplementation() {
		try {
			//1. Load the Driver
			System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded....");
			
			//2. Acquire the connection
			System.out.println("Trying to connect....");
			conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected : "+ conn);
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insertRetailer(Retailer retailer) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO RETAILER VALUES (?,?,?,?,?,?,?)");
			
//			pst.setInt(1, retailer.getRetailerNumber());
//			pst.setString(3, retailer.getRetailerName());
//			pst.setString(2,retailer.getRetailerLocation());
			
			pst.setInt(1, retailer.getRetailerId());
			pst.setString(2, retailer.getRetailerName());
			pst.setString(3,retailer.getRetailerEmail());
			pst.setString(4,retailer.getRetailerPhone());
			pst.setString(5,retailer.getRetailerAddress());
			pst.setString(6,retailer.getRetailerPostalCode());
			pst.setBoolean(7, retailer.isRetailerIsVerified());
			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Rows created : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public Retailer selectRetailer(int retailerNumber) {
		
		Retailer retailerObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM RETAILER WHERE RETAILER_ID="+retailerNumber);
			
			//5. process teh result if any
			if(result.next()) {
				retailerObj = new Retailer(); //blank object
				
//				retailerObj.setRetailerNumber(result.getInt(1));
//				retailerObj.setRetailerLocation(result.getString(2));
//				retailerObj.setRetailerName(result.getString(3));
				
				retailerObj.setRetailerId(result.getInt(1));
				retailerObj.setRetailerName(result.getString(2));
				retailerObj.setRetailerEmail(result.getString(3));
				retailerObj.setRetailerPhone(result.getString(4));
				retailerObj.setRetailerAddress(result.getString(5));
				retailerObj.setRetailerPostalCode(result.getString(6));
				retailerObj.setRetailerIsVerified(result.getBoolean(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retailerObj;
	}

	@Override
	public List<Retailer> selectRetailers() {
		
		List<Retailer> retailerList = new ArrayList<Retailer>();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM RETAILER");
			
			//5. process teh result if any
			while(result.next()) {
				Retailer retailerObj = new Retailer(); //blank object
				
//				retailerObj.setRetailerNumber(result.getInt(1));
//				retailerObj.setRetailerLocation(result.getString(2));
//				retailerObj.setRetailerName(result.getString(3));
				
				retailerObj.setRetailerId(result.getInt(1));
				retailerObj.setRetailerName(result.getString(2));
				retailerObj.setRetailerEmail(result.getString(3));
				retailerObj.setRetailerPhone(result.getString(4));
				retailerObj.setRetailerAddress(result.getString(5));
				retailerObj.setRetailerPostalCode(result.getString(6));
				retailerObj.setRetailerIsVerified(result.getBoolean(7));
				retailerList.add(retailerObj); // add this object to the LIST 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retailerList;
	}

	@Override
	public void updateRetailer(Retailer retailer) {
		//3. make a desired statement (insert/update/delete/select)
		
				try {
					PreparedStatement pst = 
							conn.prepareStatement("UPDATE RETAILER set RETAILER_NAME=?,CONTACT_EMAIL=?,CONTACT_PHONE=?,ADDRESS_LINE1=?,POSTAL_CODE=?,IS_VERIFIED=? where RETAILER_ID=?");
					
					
//					pst.setString(1, retailer.getRetailerName()); //SET dname=?
//					pst.setString(2,retailer.getRetailerLocation()); //SET loc=?
//					pst.setInt(3, retailer.getRetailerNumber()); //WHERE retailerno=?
					
					pst.setInt(7, retailer.getRetailerId());
					pst.setString(1, retailer.getRetailerName());
					pst.setString(2,retailer.getRetailerEmail());
					pst.setString(3,retailer.getRetailerPhone());
					pst.setString(4,retailer.getRetailerAddress());
					pst.setString(5,retailer.getRetailerPostalCode());
					pst.setBoolean(6, retailer.isRetailerIsVerified());

					
					System.out.println("PreparedStatement is created : "+ pst);
					
					//4. execute that statement //  UR TABLENAME IS MYDEPT120
					int rows = pst.executeUpdate();
					
					System.out.println("Row MODIFIED : "+rows);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void deleteRetailer(int retailerNumber) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("DELETE FROM RETAILER where RETAILER_ID=?");
			
			pst.setInt(1, retailerNumber); //WHERE retailerno=?

			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Row DELETED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
