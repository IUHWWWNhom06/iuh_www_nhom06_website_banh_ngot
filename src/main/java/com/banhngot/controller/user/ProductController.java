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
import com.banhngot.service.DanhMucService;
import com.banhngot.service.ProductService;

@Controller(value = "dienThoaiControllerOfUser")
@RequestMapping("/dienthoai")
public class ProductController { 
	@Autowired
	private ProductService dienThoaiService;
	
	@Autowired
	private BinhLuanService binhLuanService;
	
	@Autowired
	private DanhMucService danhMucService;

	@GetMapping("/danhsach")
	public String listCustomers(Model theModel, @RequestParam(required = false) String sort,  @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value="search", defaultValue = "") String search,@RequestParam(value="memory", defaultValue = "") String memory) {
		List<Product> listDienThoai = new ArrayList<Product>();
		if (sort!=null) {
			listDienThoai = dienThoaiService.getListDienThoaiCoSapXep(sort,search,memory);
		}else {
			listDienThoai = dienThoaiService.getListDienThoaiCoSapXep("desc",search,memory);
		}
		theModel.addAttribute("memory",memory);
		theModel.addAttribute("search",search);
		theModel.addAttribute("sort",sort);
		theModel.addAttribute("page", page);
		theModel.addAttribute("dienthoais", dienThoaiService.getListDienThoaiTheoPage(page,12, listDienThoai));
		theModel.addAttribute("total", listDienThoai.size());	
		theModel.addAttribute("dms", danhMucService.getListDanhMuc());
		return "user/danhsach-dienthoai2";
	}
	
//	@GetMapping("/danhmuc")
//	public String danhmuc(Model theModel, HttpSession session) {
//		List<Product> dts = (List<Product>) session.getAttribute("dts");
//		if (dts == null) {
//			dts = dienThoaiService.getListDienThoaiLienQuan(danhMucService.getListDanhMuc().get(0).getTenDanhMuc());
//		}
//		theModel.addAttribute("dts", dts);
//		theModel.addAttribute("iddanhmuc", session.getAttribute("iddanhmuc"));
//		theModel.addAttribute("dms", danhMucService.getListDanhMuc());
//		return "user/danhmuc";
//	}
//	@RequestMapping(value = "/danhmuc/{danhMucId}", method = RequestMethod.GET)
//	public String getDienThoaiTheoDanhMuc(Model model,@PathVariable(value = "danhMucId")int danhMucId,HttpSession session) {
//		session.setAttribute("dts", dienThoaiService.getListDienThoaiLienQuan(danhMucService.getDanhMuc(danhMucId).getTenDanhMuc()));
//		session.setAttribute("iddanhmuc", danhMucId);
//		return "redirect:/dienthoai/danhmuc";
//	}
//	
//	@GetMapping("/chitietdienthoai")
//	public String chitietdienthoai(Model model, HttpSession session) {
//		Product dt = (Product) session.getAttribute("dienthoai");
//		List<Product> dts=dienThoaiService.getListDienThoaiLienQuan(dt.getDanhMuc().getTenDanhMuc());
//		model.addAttribute("dts", dts);
//		model.addAttribute("dt", dt);
//		model.addAttribute("binhluans", binhLuanService.getListBinhLuanByIdDienThoai(dt.getId()));
//		model.addAttribute("binhluan", new BinhLuan());
////		model.addAttribute("dtbythuonghieu", dienThoaiService.getListDienThoaiTheoThuongHieu(dt.getThuongHieu().getId()));
//		return "user/chitietdienthoai";
//	}
	@RequestMapping(value = "/laychitiet/{id}", method = RequestMethod.GET)
	public String laychitiethoadon(Model model,@PathVariable(value = "id")int id,HttpSession session) {
		Product dt = dienThoaiService.getDienThoai(id);
		session.setAttribute("dienthoai", dt);
		session.setAttribute("size", dt.getHinhAnh().size());
		return "redirect:/dienthoai/chitietdienthoai";
	}
//	@GetMapping("/search")
//	public String searchDienThoai(Model model, @RequestParam(required = false) String searchName,  @RequestParam(value = "page", defaultValue = "1") int page) {
//		List<Product> dts = dienThoaiService.getListDienThoaiSearch(searchName);
//		if (dts.size()>0) {
//			model.addAttribute("page", page);
//			model.addAttribute("dienthoais", dienThoaiService.getListDienThoaiTheoPage(page,8, dts));
//			model.addAttribute("total", dts.size());
//			model.addAttribute("ths", dienThoaiService.getListThuongHieu());
//			return "user/danhsach-dienthoai2";
//		}else {
//			System.out.println("không có điện thoại!");
//			return "user/notfounddienthoai";
//		}
//	}
	@RequestMapping(value = "/savebinhluan", method = RequestMethod.POST)
	public String themBinhLuan(@ModelAttribute("binhluan") BinhLuan binhLuan,HttpSession session) {
		if (!binhLuan.getNoiDung().equals("")||!binhLuan.getTenBinhLuan().equals("")) {
			Product dt =(Product) session.getAttribute("dienthoai");
			binhLuan.setDienThoai(dt);
			binhLuan.setId(null);
			binhLuan.setNgay(LocalDateTime.now());
			binhLuanService.themBinhLuan(binhLuan);
		}
		
		return "redirect:/dienthoai/chitietdienthoai";
	}
}
