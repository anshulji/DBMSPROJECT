package com.anshul.dao;

import java.util.List;

import com.anshul.model.Product;

public interface WishlistDao {
	public void addItemToWishlist(int prodid, String username);
	public void removeItemFromWishlist(int prodid, String username);
	public List<Product> getProdInWishlist(String username);
	

}
