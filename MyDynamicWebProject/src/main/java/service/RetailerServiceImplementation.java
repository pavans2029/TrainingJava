package service;

import java.util.List;

import dao.RetailerDAO;
import dao.RetailerDAOImplementation;
import entities.Retailer;
//In The SERVICE
public class RetailerServiceImplementation implements RetailerService {
	RetailerDAO retailerDAO = new RetailerDAOImplementation();
	public void createRetailerService(Retailer retailer) {
			retailerDAO.insertRetailer(retailer);
	}
	public Retailer findRetailerService(int retailerNumber) {	
		return retailerDAO.selectRetailer(retailerNumber);
	}
	public List<Retailer> findRetailersService() {
		return retailerDAO.selectRetailers();
	}
	public void modifyRetailerService(Retailer retailer) {
		retailerDAO.updateRetailer(retailer);
	}
	public void removeRetailerService(int retailerNumber) {
		retailerDAO.deleteRetailer(retailerNumber);
	}

}
