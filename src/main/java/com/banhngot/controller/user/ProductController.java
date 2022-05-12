package com.banhngot.controller.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.banhngot.entity.Product;
import com.banhngot.service.TypeProductService;
import com.banhngot.service.ProductService;

@Controller(value = "productControllerOfUser")
@RequestMapping("/banhngot")
public class ProductController { 
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TypeProductService danhMucService;

	@GetMapping("/danhsach")
	public String listCustomers(Model theModel, @RequestParam(required = false) String sort,
			@RequestParam(value="search", defaultValue = "") String search) {
		List<Product> listProduct = new ArrayList<Product>();
		if (sort!=null) {
			listProduct = productService.getListProductCoSapXep(sort,search);
		}else {
			listProduct = productService.getListProductCoSapXep("desc",search);
		}

		theModel.addAttribute("search",search);
		theModel.addAttribute("sort",sort);
		theModel.addAttribute("products", productService.getListProduct(listProduct));
		theModel.addAttribute("total", listProduct.size());	
		theModel.addAttribute("dms", danhMucService.getListDanhMuc());
		System.out.println(search);
		return "user/listProduct";
	}
	
	@GetMapping("/danhmuc")
	public String danhmuc(Model theModel, HttpSession session) {
		List<Product> bns = (List<Product>) session.getAttribute("bns");
		if (bns == null) {
			bns = productService.getListProductLienQuan(danhMucService.getListDanhMuc().get(0).getTenDanhMuc());
		}
		theModel.addAttribute("bns", bns);
		theModel.addAttribute("iddanhmuc", session.getAttribute("iddanhmuc"));
		theModel.addAttribute("dms", danhMucService.getListDanhMuc());
		return "user/typeProduct";
	}
	@RequestMapping(value = "/danhmuc/{danhMucId}", method = RequestMethod.GET)
	public String getProductTheoDanhMuc(Model model,@PathVariable(value = "danhMucId")int danhMucId,HttpSession session) {
		System.out.println(danhMucId +"dong 65");
		session.setAttribute("bns", productService.getListProductLienQuan(danhMucService.getDanhMuc(danhMucId).getTenDanhMuc()));
		session.setAttribute("iddanhmuc", danhMucId);
		return "redirect:/banhngot/danhmuc";
	}

	@GetMapping("/search")
	public String searchProduct(Model model, @RequestParam(required = false) String searchName,  @RequestParam(value = "page", defaultValue = "1") int page) {
		List<Product> dts = productService.getListProductSearch(searchName);
		if (dts.size()>0) {
			model.addAttribute("search",searchName);
			model.addAttribute("page", page);
			model.addAttribute("products", productService.getListProduct(dts));
			return "user/listProduct";
		}else {
			return "user/notfoundproduct";
		}
	}

}
