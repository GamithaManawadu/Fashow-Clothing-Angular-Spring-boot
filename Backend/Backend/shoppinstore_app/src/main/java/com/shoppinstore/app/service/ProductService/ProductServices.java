package com.shoppinstore.app.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppinstore.app.Repository.CatergoryRepository;
import com.shoppinstore.app.Repository.ProductRepository;
import com.shoppinstore.app.model.Category;


import com.shoppinstore.app.model.Products;

@Service
public class ProductServices {

	@Autowired
	ProductRepository productRepo;
	@Autowired
	CatergoryRepository cateRepo;
	
	public List<Products>getAllProducts(){
		return productRepo.findAll();
	}
	public List<Products>getProductsByCategory(String product_id){
		return productRepo.getByCategoryId(product_id);
	}
	
	public List<Category>getAllCategory(){
		return cateRepo.findAll();
	}
	
	public Products getProductsById(long productId) throws Exception {
		return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
	}
}
