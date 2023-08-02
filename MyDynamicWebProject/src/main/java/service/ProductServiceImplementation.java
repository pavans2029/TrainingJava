package service;

import java.util.List;

import dao.ProductDAO;
import dao.ProductDAOImplementation;
import entities.Product;
//In The SERVICE
public class ProductServiceImplementation implements ProductService {
	ProductDAO deptDAO = new ProductDAOImplementation();
	public void createProductService(Product dept) {
			deptDAO.insertProduct(dept);
	}
	public Product findProductService(int deptNumber) {	
		return deptDAO.selectProduct(deptNumber);
	}
	public List<Product> findProductsService() {
		return deptDAO.selectProducts();
	}
	public void modifyProductService(Product dept) {
		deptDAO.updateProduct(dept);
	}
	public void removeProductService(int deptNumber) {
		deptDAO.deleteProduct(deptNumber);
	}
	

}
