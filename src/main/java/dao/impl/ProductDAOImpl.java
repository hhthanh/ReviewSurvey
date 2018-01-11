package dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.ProductDAO;
import model.Product;

public class ProductDAOImpl extends JdbcDaoSupport implements ProductDAO{

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product";
		ArrayList<Product> l = (ArrayList<Product>)getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		System.out.println(l.size());
		return l;
	}

	public Product findProductById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product WHERE id = ?";
		return (Product) getJdbcTemplate().queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public boolean addProductToDB(Product p) {
		// TODO Auto-generated method stub
		return false;
	}

}
