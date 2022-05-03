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

import com.banhngot.dao.BinhLuanDao;
import com.banhngot.entity.BinhLuan;
import com.banhngot.entity.Product;
import com.banhngot.entity.ThuongHieu;
import com.banhngot.service.BinhLuanService;
import com.banhngot.service.TypeProductService;
import com.banhngot.service.ProductService;

@Controller(value = "productControllerOfUser")
@RequestMapping("/product")
public class ProductController { 
	@Autowired
	private ProductService productService;
	
	@Autowired
	private BinhLuanService binhLuanService;
	
	@Autowired
	private TypeProductService danhMucService;

	
	//@RequestParam(value="search", defaultValue = "") String search là nhận search từ bên jsp
	@GetMapping("/danhsach")
	public String listCustomers(Model theModel, @RequestParam(required = false) String sort,  @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value="search", defaultValue = "") String search,@RequestParam(value="memory", defaultValue = "") String memory) {
		List<Product> listProduct = new ArrayList<Product>();
		if (sort!=null) {
			listProduct = productService.getListProductCoSapXep(sort,search,memory);
		}else {
			listProduct = productService.getListProductCoSapXep("desc",search,memory);
		}
		theModel.addAttribute("memory",memory);
		theModel.addAttribute("search",search);
		theModel.addAttribute("sort",sort);
		theModel.addAttribute("page", page);
		theModel.addAttribute("products", productService.getListProductTheoPage(page,12, listProduct));
		theModel.addAttribute("total", listProduct.size());	
		theModel.addAttribute("dms", danhMucService.getListDanhMuc());
		System.out.println(search);
		return "user/danhsach-product2";
	}
	
	@GetMapping("/danhmuc")
	public String danhmuc(Model theModel, HttpSession session) {
		List<Product> dts = (List<Product>) session.getAttribute("dts");
		if (dts == null) {
			dts = productService.getListProductLienQuan(danhMucService.getListDanhMuc().get(0).getTenDanhMuc());
		}
		theModel.addAttribute("dts", dts);
		theModel.addAttribute("iddanhmuc", session.getAttribute("iddanhmuc"));
		theModel.addAttribute("dms", danhMucService.getListDanhMuc());
		return "user/danhmuc";
	}
	@RequestMapping(value = "/danhmuc/{danhMucId}", method = RequestMethod.GET)
	public String getProductTheoDanhMuc(Model model,@PathVariable(value = "danhMucId")int danhMucId,HttpSession session) {
		session.setAttribute("dts", productService.getListProductLienQuan(danhMucService.getDanhMuc(danhMucId).getTenDanhMuc()));
		session.setAttribute("iddanhmuc", danhMucId);
		return "redirect:/product/danhmuc";
	}
//	
//	@GetMapping("/chitietproduct")
//	public String chitietproduct(Model model, HttpSession session) {
//		Product dt = (Product) session.getAttribute("product");
//		List<Product> dts=productService.getListProductLienQuan(dt.getDanhMuc().getTenDanhMuc());
//		model.addAttribute("dts", dts);
//		model.addAttribute("dt", dt);
//		model.addAttribute("binhluans", binhLuanService.getListBinhLuanByIdProduct(dt.getId()));
//		model.addAttribute("binhluan", new BinhLuan());
////		model.addAttribute("dtbythuonghieu", productService.getListProductTheoThuongHieu(dt.getThuongHieu().getId()));
//		return "user/chitietproduct";
//	}
	@RequestMapping(value = "/laychitiet/{id}", method = RequestMethod.GET)
	public String laychitiethoadon(Model model,@PathVariable(value = "id")int id,HttpSession session) {
		Product dt = productService.getProduct(id);
		session.setAttribute("product", dt);
		session.setAttribute("size", dt.getHinhAnh().size());
		return "redirect:/product/chitietproduct";
	}
	@GetMapping("/search")
	public String searchProduct(Model model, @RequestParam(required = false) String searchName,  @RequestParam(value = "page", defaultValue = "1") int page) {
		List<Product> dts = productService.getListProductSearch(searchName);
		if (dts.size()>0) {
			model.addAttribute("page", page);
			model.addAttribute("products", productService.getListProductTheoPage(page,8, dts));
//			model.addAttribute("total", dts.size());
//			model.addAttribute("ths", productService.getListThuongHieu());
			return "user/danhsach-product2";
		}else {
			System.out.println("không có điện thoại!");
			return "user/notfoundproduct";
		}
	}
	@RequestMapping(value = "/savebinhluan", method = RequestMethod.POST)
	public String themBinhLuan(@ModelAttribute("binhluan") BinhLuan binhLuan,HttpSession session) {
		if (!binhLuan.getNoiDung().equals("")||!binhLuan.getTenBinhLuan().equals("")) {
			Product dt =(Product) session.getAttribute("product");
			binhLuan.setDienThoai(dt);
			binhLuan.setId(null);
			binhLuan.setNgay(LocalDateTime.now());
			binhLuanService.themBinhLuan(binhLuan);
		}
		
		return "redirect:/product/chitietproduct";
	}
}
