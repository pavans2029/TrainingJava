package service;

import java.util.List;

import entities.Retailer;

public interface RetailerService {
	void createRetailerService(Retailer retailer);
	Retailer findRetailerService(int retailerNumber);
	List<Retailer> findRetailersService();
	void modifyRetailerService(Retailer retailer);
	void removeRetailerService(int retailerNumber);
}
