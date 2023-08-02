package dao;

import java.util.List;


import entities.Product;

//II. POJI
public interface ProductDAO { //POJI as per the POJO

	public void insertProduct(Product prod); //C
	public Product selectProduct(int prodId);//R
	public List<Product> selectProducts(); //RA
	public void updateProduct(Product prod); //U
	public void deleteProduct(int prod);  //D
	
}
