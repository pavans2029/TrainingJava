package entities; //1. package

//POJO as per the DEPT10 table's structure

//2. public 
public class Retailer { //I. POJO
	//4. it must have private data as per the table's structure
	private int retailerId;
    private String retailerName;
    private String retailerEmail;
    private String retailerPhone;
    private String retailerAddress;
    private String retailerPostalCode;
    private boolean retailerIsVerified;
    
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public String getRetailerName() {
		return retailerName;
	}
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}
	public String getRetailerEmail() {
		return retailerEmail;
	}
	public void setRetailerEmail(String retailerEmail) {
		this.retailerEmail = retailerEmail;
	}
	public String getRetailerPhone() {
		return retailerPhone;
	}
	public void setRetailerPhone(String retailerPhone) {
		this.retailerPhone = retailerPhone;
	}
	public String getRetailerAddress() {
		return retailerAddress;
	}
	public void setRetailerAddress(String retailerAddress) {
		this.retailerAddress = retailerAddress;
	}
	public String getRetailerPostalCode() {
		return retailerPostalCode;
	}
	public void setRetailerPostalCode(String retailerPostalCode) {
		this.retailerPostalCode = retailerPostalCode;
	}
	public boolean isRetailerIsVerified() {
		return retailerIsVerified;
	}
	public void setRetailerIsVerified(boolean retailerIsVerified) {
		this.retailerIsVerified = retailerIsVerified;
	}
	
    
    
	
	
	
	
}
