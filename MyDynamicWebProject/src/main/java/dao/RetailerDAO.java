package dao;

import java.util.List;

import entities.Retailer;

//II. POJI
public interface RetailerDAO { //POJI as per the POJO

	public void insertRetailer(Retailer retailer); //C
	public Retailer selectRetailer(int retailerNumber);//R
	public List<Retailer> selectRetailers(); //RA
	public void updateRetailer(Retailer retailer); //U
	public void deleteRetailer(int retailerNumber);  //D
	
}
