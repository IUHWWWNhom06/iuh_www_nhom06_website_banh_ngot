package com.banhngot.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banhngot.entity.DienThoaiGioHang;
import com.banhngot.service.ProductService;

@Controller(value = "GioHangControllerOfUser")
@RequestMapping("/user")
public class GioHangController {
	@Autowired
	private ProductService dienThoaiService;

	@GetMapping(value = "/gioHang")
	public String showGioHang(HttpSession session, Model model, Principal principal) {
		List<DienThoaiGioHang> cart = (List<DienThoaiGioHang>) session.getAttribute("cart");
		if (cart == null) {
			session.setAttribute("tamtinh", 0);
			session.setAttribute("giamgia", 0);
			session.setAttribute("tongtien", 0);
			session.setAttribute("tinhtranggiohang", "Không có sản phẩm nào trong giỏ hàng");
			try {
				model.addAttribute("tenDangNhap", principal.getName());
			} catch (Exception e) {
				// TODO: handle exception
			}
			return "user/giohang";
		} else {
			if (cart.size() == 0) {
				session.setAttribute("tamtinh", 0);
				session.setAttribute("giamgia", 0);
				session.setAttribute("tongtien", 0);
				session.setAttribute("tinhtranggiohang", "Không có sản phẩm nào trong giỏ hàng");
				try {
					model.addAttribute("tenDangNhap", principal.getName());
				} catch (Exception e) {
					// TODO: handle exception
				}
				return "user/giohang";
			} else {
				session.setAttribute("tinhtranggiohang", "");
				capNhatGiaTrongGioHang(session);
				try {
					model.addAttribute("tenDangNhap", principal.getName());
				} catch (Exception e) {
					// TODO: handle exception
				}

				return "user/giohang";
			}
		}
	}

	@RequestMapping(value = "/themvaogiohang/{id}", method = RequestMethod.GET)
	public String themVaoGioGang(@PathVariable(value = "id") int id, Model model, HttpSession session) {
		if (session.getAttribute("cart") == null) {
			List<DienThoaiGioHang> cart = new ArrayList<DienThoaiGioHang>();
			DienThoaiGioHang dienThoaiGioHang = new DienThoaiGioHang(dienThoaiService.getDienThoai(id), 1);
			cart.add(dienThoaiGioHang);
			session.setAttribute("cart", cart);
		} else {
			List<DienThoaiGioHang> cart = (List<DienThoaiGioHang>) session.getAttribute("cart");
			int index = kiemTraDienThoaiTonTaiTrongGioHang(id, session);
			if (index == -1) {
				DienThoaiGioHang dienThoaiGioHang = new DienThoaiGioHang(dienThoaiService.getDienThoai(id), 1);
				cart.add(dienThoaiGioHang);
			} else {
				int quantity = cart.get(index).getSoLuong() + 1;
				cart.get(index).setSoLuong(quantity);
			}
			session.setAttribute("cart", cart);
		}
		session.setAttribute("errorcartnull", "");
		return "redirect:/user/gioHang";
	}

	public void capNhatGiaTrongGioHang(HttpSession session) {
		List<DienThoaiGioHang> cart = (List<DienThoaiGioHang>) session.getAttribute("cart");
		double giamGia = 0;
		double tamTinh = 0;
		double thue = 0;
		for (DienThoaiGioHang dienThoaiGioHang : cart) {
			thue++;
			tamTinh += dienThoaiGioHang.getDienThoai().getGiaDT() * dienThoaiGioHang.getSoLuong();
			giamGia += (tamTinh * dienThoaiGioHang.getDienThoai().getGiamGia()) / 100;
//			thue += (tamTinh * dienThoaiGioHang.getDienThoai().getThue()) / 100;
			session.setAttribute("tamtinh", tamTinh);
			session.setAttribute("giamgia", giamGia);
			session.setAttribute("tongtien", tamTinh - giamGia + thue);
		}
	}

	public int kiemTraDienThoaiTonTaiTrongGioHang(int id, HttpSession session) {
		List<DienThoaiGioHang> cart = (List<DienThoaiGioHang>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getDienThoai().getId() == id)
				return i;
		}
		return -1;
	}

	@RequestMapping(value = "/xoadienthoaigiohang/{id}")
	public String xoaDienThoaiGioHang(@PathVariable(value = "id") int id, Model model, HttpSession session) {
		List<DienThoaiGioHang> cart = (List<DienThoaiGioHang>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getDienThoai().getId() == id) {
				cart.remove(i);
				break;
			}
		}
		session.setAttribute("cart", cart);
		capNhatGiaTrongGioHang(session);
		session.setAttribute("errorcartnull", "");
		return "redirect:/user/gioHang";
	}

	@RequestMapping(value = "/tangsoluong/{id}")
	public String tangSoLuong(@PathVariable(value = "id") int id, HttpSession session) {
		List<DienThoaiGioHang> cart = (List<DienThoaiGioHang>) session.getAttribute("cart");
		for (DienThoaiGioHang dienThoaiGioHang : cart) {
			if (dienThoaiGioHang.getDienThoai().getId() == id) {
				int quantity = dienThoaiGioHang.getSoLuong() + 1;
				dienThoaiGioHang.setSoLuong(quantity);
			}
		}
		return "redirect:/user/gioHang";

	}

	@RequestMapping(value = "/giamsoluong/{id}")
	public String giamSoLuong(@PathVariable(value = "id") int id, HttpSession session) {
		List<DienThoaiGioHang> cart = (List<DienThoaiGioHang>) session.getAttribute("cart");
		for (DienThoaiGioHang dienThoaiGioHang : cart) {
			if (dienThoaiGioHang.getDienThoai().getId() == id) {
				int quantity = dienThoaiGioHang.getSoLuong() - 1;
				dienThoaiGioHang.setSoLuong(quantity);
			}
		}
		return "redirect:/user/gioHang";

	}
}