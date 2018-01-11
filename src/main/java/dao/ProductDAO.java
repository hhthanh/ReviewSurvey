package dao;

import java.util.List;

import model.Product;

public interface ProductDAO {
	public List<Product> getAllProduct();
	public Product findProductById(Integer id);
	public boolean addProductToDB(Product p);
}
