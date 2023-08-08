package dao;


import entities.Retailer;

public class RetailerTest {

	public static void main(String[] args) {
		
		RetailerDAOImplementation retailerDAO = new RetailerDAOImplementation();

        // Insert a new retailer
        Retailer retailer1 = new Retailer();
        retailer1.setRetailerId(6);
        retailer1.setRetailerName("Retailer 1");
        retailer1.setRetailerEmail("retailer1@example.com");
        retailer1.setRetailerPhone("1234567890");
        retailer1.setRetailerAddress("Address 1");
        retailer1.setRetailerPostalCode("12345");
        retailer1.setRetailerIsVerified(true);
        retailerDAO.insertRetailer(retailer1);

        // Retrieve a retailer
        Retailer retrievedRetailer = retailerDAO.selectRetailer(1);
        System.out.println("Retrieved Retailer: " + retrievedRetailer);

        // Update the retailer
        retrievedRetailer.setRetailerName("Updated Retailer 1");
        retailerDAO.updateRetailer(retrievedRetailer);

        // Retrieve all retailers
        System.out.println("All Retailers:");
        retailerDAO.selectRetailers().forEach(System.out::println);

        // Delete the retailer
        retailerDAO.deleteRetailer(1);

        // Retrieve all retailers after deletion
        System.out.println("All Retailers after deletion:");
        retailerDAO.selectRetailers().forEach(System.out::println);

	}

}
