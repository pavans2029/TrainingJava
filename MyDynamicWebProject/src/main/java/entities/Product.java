package entities; //1. package

//POJO as per the DEPT10 table's structure

//2. public 
public class Product { //I. POJO
	//4. it must have private data as per the table's structure
	private int productId; //deptno
	private String productName; //dname
	private double productPrice; //loc
	public Product() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	
}
