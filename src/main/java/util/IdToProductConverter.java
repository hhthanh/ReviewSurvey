package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import model.Product;
import service.ProductService;

public class IdToProductConverter implements Converter<String, Product>{

	@Autowired
	private ProductService productService;
	
	@Override
	public Product convert(String arg0) {
		// TODO Auto-generated method stub
		return productService.findProductById(Integer.parseInt(arg0));
	}

}
