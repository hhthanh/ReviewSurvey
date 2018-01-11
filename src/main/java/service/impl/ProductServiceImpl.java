package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ProductDAO;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<Product> getAllProduct() {
		return getProductDAO().getAllProduct();
	}

	@Override
	public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
		return getProductDAO().addProductToDB(p);
	}

	@Override
	public Product findProductById(Integer id) {
		// TODO Auto-generated method stub
		return getProductDAO().findProductById(id);
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

}
