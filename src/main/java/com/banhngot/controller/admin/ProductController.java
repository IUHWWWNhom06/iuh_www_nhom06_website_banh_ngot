package com.banhngot.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.banhngot.entity.TypeProduct;
import com.banhngot.entity.Product;

import com.banhngot.service.TypeProductService;
import com.banhngot.service.ProductService;


@Controller(value = "dienThoaiControllerOfAdmin")
@RequestMapping("/admin")
public class ProductController {
	private static final String UPLOA_DIRECTORY = "resources/user/images/SanPham";
	@Autowired
	private ProductService dienThoaiService;

	@Autowired
	private TypeProductService danhMucService;



	@GetMapping("/product/list")
	public String listProduct(Model theModel, @RequestParam(value = "page", defaultValue = "1") int page) {
		List<Product> productList = dienThoaiService.getListProduct();
		theModel.addAttribute("page", page);
//		theModel.addAttribute("productList", dienThoaiService.getListProductTheoPage(page, 7, productList));
		theModel.addAttribute("total", productList.size());

		return "admin/product";
	}

//	@GetMapping("/product/delete")
//	public String deleteProduct(@RequestParam("productId") int id, @RequestParam("productDetailId") int detailId) {
//		thongSoService.deleteThongSo(detailId);
//		dienThoaiService.deleteProduct(id);
//		return "redirect:/admin/product/list";
//	}

	@GetMapping("/product/showFormEdit")
	private String showFormEditProduct(@RequestParam("productId") int id, Model theModel, HttpSession session) {
		Product product = dienThoaiService.getProduct(id);
		List<TypeProduct> cates = danhMucService.getListDanhMuc();
		int cate_id = product.getDanhMuc().getId();

		session.setAttribute("photos", product.getHinhAnh());
		theModel.addAttribute("product", product);
		theModel.addAttribute("cates", cates);
		theModel.addAttribute("id", cate_id);

		return "admin/product-form";
	}

	@GetMapping("/product/showFormAdd")
	private String showFormAddProduct(Model theModel) {
		Product product = new Product();
		List<TypeProduct> cates = danhMucService.getListDanhMuc();
		theModel.addAttribute("cates", cates);
		theModel.addAttribute("product", product);
		return "admin/product-form";
	}

	@PostMapping("/product/save")
	private String editAdmin(Model theModel, @ModelAttribute("product") @Validated Product product,
			BindingResult result, @RequestParam("cateId") int id, @RequestParam("detail_id") String detail_id,
			@RequestParam() CommonsMultipartFile[] files, HttpServletRequest request, HttpSession session)
			throws Exception {
		if (result.hasErrors()) {
			List<TypeProduct> cates = danhMucService.getListDanhMuc();
			theModel.addAttribute("cates", cates);
			return "admin/product-form";
		} else {
			if (files.length > 1) {
				try {
					List<String> anhs = new ArrayList<String>();
					for (CommonsMultipartFile file : files) {
						String fileName = saveImage(file, request);
						anhs.add(fileName);
					}
					product.setAnhURL(anhs.get(0));
					product.setHinhAnh(anhs);
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else {
				List<String> photos = (List<String>) session.getAttribute("photos");
				try {
					product.setAnhURL(photos.get(0));
				} catch (Exception e) {
					// TODO: handle exception
				}
				product.setHinhAnh(photos);
				session.removeValue("photos");
			}
//			ThongSo ts = thongSoService.getThongSo(Integer.parseInt(detail_id));
//			product.setThongSo(ts);
			TypeProduct cate = danhMucService.getDanhMuc(id);
			product.setDanhMuc(cate);
//			ThuongHieu thuongHieu = thuongHieuService.getTheoTen(cate.getTenDanhMuc().trim());
//			product.setThuongHieu(thuongHieu);
			dienThoaiService.saveProduct(product);
			return "redirect:/admin/product/list";
		}

	}

	private String saveImage(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request) {
		try {
			ServletContext context = request.getServletContext();
			String path = context.getRealPath(UPLOA_DIRECTORY);
			String imageUrl = commonsMultipartFile.getOriginalFilename();
			String img = "D:\\IUH\\WWW.JAVA\\A-project\\New folder\\Project_WebsiteBanProductTrucTuyen\\WebBanProduct\\src\\main\\webapp\\resources\\user\\images\\SanPham\\";

			byte[] bytes = commonsMultipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + imageUrl)));
			stream.write(bytes);
			stream.flush();
			stream.close();

			BufferedOutputStream str = new BufferedOutputStream(new FileOutputStream(new File(img + imageUrl)));
			str.write(bytes);
			str.flush();
			str.close();

			return commonsMultipartFile.getOriginalFilename();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}
