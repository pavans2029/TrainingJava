package service;

import java.util.List;

import entities.Product;

public interface ProductService {
	void createProductService(Product prod);
	Product findProductService(int prodId);
	List<Product> findProductsService();
	void modifyProductService(Product prod);
	void removeProductService(int prodId);
}
