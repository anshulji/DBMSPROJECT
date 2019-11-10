package com.anshul.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anshul.model.Product;

public class WishlistDaoImpl implements WishlistDao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addItemToWishlist(int prodid, String username) {
		List<Product> list;
		String sql="select product.prod_id,product.prod_price,product.prod_name,product.prod_desc,product.prod_image,quantity_available,cat_id from wishlist,product where username=\""+username+"\" and product.prod_id=\""+prodid+"\" and product.prod_id=wishlist.prod_id";
		list=(List<Product>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		if(list.isEmpty())
		{
			sql="insert into wishlist values(?,?)";
			Object[] object= {prodid,username};
			jdbcTemplate.update(sql,object);
		}
		
	}
	
	public List<Product> getProdInWishlist(String username)
	{
		List<Product> list;
		String sql="select product.prod_id,product.prod_price,product.prod_name,product.prod_desc,product.prod_image,quantity_available,cat_id from wishlist,product where username=\""+username+"\" and product.prod_id=wishlist.prod_id";
		list=(List<Product>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		return list;
		
	}

	public void removeItemFromWishlist(int prodid, String username) {	
		String sql="delete from wishlist where username=\""+username+"\" and prod_id=\""+prodid+"\"";
		jdbcTemplate.update(sql);
	}
	

}
