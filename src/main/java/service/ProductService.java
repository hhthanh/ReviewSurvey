package service;

import java.util.List;

import model.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	public boolean addProduct(Product p);
	public Product findProductById(Integer id);
}
