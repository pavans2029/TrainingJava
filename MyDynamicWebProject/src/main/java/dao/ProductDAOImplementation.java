package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductDAOImplementation implements ProductDAO {

	Connection conn ; //GLOBAL 
	
	public ProductDAOImplementation() {
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
	public void insertProduct(Product prod) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO MYDEPT120 VALUES (?,?,?)");
			
			pst.setInt(1, prod.getProductId());
			pst.setString(3, prod.getProductName());
			pst.setDouble(2,prod.getProductPrice());
			
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
	public Product selectProduct(int prodNumber) {
		
		Product prodObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM MYDEPT120 WHERE DEPTNO="+prodNumber);
			
			//5. process teh result if any
			if(result.next()) {
				prodObj = new Product(); //blank object
				
				prodObj.setProductId(result.getInt(1));
				prodObj.setProductName(result.getString(2));
				prodObj.setProductPrice(result.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prodObj;
	}

	@Override
	public List<Product> selectProducts() {
		
		List<Product> prodList = new ArrayList<Product>();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM MYDEPT120");
			
			//5. process teh result if any
			while(result.next()) {
				Product prodObj = new Product(); //blank object
				
				prodObj.setProductId(result.getInt(1));
				prodObj.setProductName(result.getString(2));
				prodObj.setProductPrice(result.getDouble(3));
				prodList.add(prodObj); // add this object to the LIST 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prodList;
	}

	@Override
	public void updateProduct(Product prod) {
		//3. make a desired statement (insert/update/delete/select)
		
				try {
					PreparedStatement pst = 
							conn.prepareStatement("UPDATE MYDEPT120 set dname=?, loc=? where prodno=?");
					
					
					pst.setInt(1, prod.getProductId()); //SET dname=?
					pst.setString(2,prod.getProductName()); //SET loc=?
					pst.setDouble(3, prod.getProductPrice()); //WHERE prodno=?

					
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
	public void deleteProduct(int prodNumber) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("DELETE FROM MYDEPT120 where prodno=?");
			
			pst.setInt(1, prodNumber); //WHERE prodno=?

			
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
