package com.banhngot.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banhngot.entity.Product;
import com.banhngot.service.ProductService;

@RestController(value = "productRestControllerOfAdmin")
@RequestMapping("/admin/product/api")
public class ProductRestController {
	@Autowired
	private ProductService productService;

//	@GetMapping("/product")
//	public List<Product> getProducts() {
//		return productService.getDienTHoaiBanChay();
//	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable int id) {
		return productService.getProduct(id);
	}

//	@GetMapping("/products")
//	public List<Product> getListTheoTen(@RequestParam("tenDT") String tenDT) {
//		return productService.getListTheoTen(tenDT);
//	}

	@PostMapping("/products")
	public Product themProduct(@RequestBody Product product) {
		product.setId(0);
		productService.saveProduct(product);
		return product;
	}

	@PutMapping("/products")
	public Product suaProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return product;
	}

	@DeleteMapping("/products/{id}")
	public void xoaProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}

}
