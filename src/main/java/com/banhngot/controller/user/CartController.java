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

import com.banhngot.entity.ProductCart;
import com.banhngot.service.ProductService;

@Controller(value = "CartControllerOfUser")
@RequestMapping("/user")
public class CartController {
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/cart")
	public String showCart(HttpSession session, Model model, Principal principal) {
		List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
		if (cart == null) {
			session.setAttribute("tamtinh", 0);
			session.setAttribute("giamgia", 0);
			session.setAttribute("tongtien", 0);
			session.setAttribute("tinhtrangcart", "Không có sản phẩm nào trong giỏ hàng");
			try {
				model.addAttribute("tenDangNhap", principal.getName());
			} catch (Exception e) {
				// TODO: handle exception
			}
			return "user/cart";
		} else {
			if (cart.size() == 0) {
				session.setAttribute("tamtinh", 0);
				session.setAttribute("giamgia", 0);
				session.setAttribute("tongtien", 0);
				session.setAttribute("tinhtrangcart", "Không có sản phẩm nào trong giỏ hàng");
				try {
					model.addAttribute("tenDangNhap", principal.getName());
				} catch (Exception e) {
					// TODO: handle exception
				}
				return "user/cart";
			} else {
				session.setAttribute("tinhtrangcart", "");
				capNhatGiaTrongCart(session);
				try {
					model.addAttribute("tenDangNhap", principal.getName());
				} catch (Exception e) {
					// TODO: handle exception
				}

				return "user/cart";
			}
		}
	}

	@RequestMapping(value = "/themvaocart/{id}", method = RequestMethod.GET)
	public String themVaoGioGang(@PathVariable(value = "id") int id, Model model, HttpSession session) {
		if (session.getAttribute("cart") == null) {
			List<ProductCart> cart = new ArrayList<ProductCart>();
			ProductCart productCart = new ProductCart(productService.getProduct(id), 1);
			cart.add(productCart);
			session.setAttribute("cart", cart);
		} else {
			List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
			int index = kiemTraProductTonTaiTrongCart(id, session);
			if (index == -1) {
				ProductCart productCart = new ProductCart(productService.getProduct(id), 1);
				cart.add(productCart);
			} else {
				int quantity = cart.get(index).getSoLuong() + 1;
				cart.get(index).setSoLuong(quantity);
			}
			session.setAttribute("cart", cart);
		}
		session.setAttribute("errorcartnull", "");
		return "redirect:/user/cart";
	}

	public void capNhatGiaTrongCart(HttpSession session) {
		List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
		double giamGia = 0;
		double tamTinh = 0;
		double thue = 0;
		for (ProductCart productCart : cart) {
			thue++;
			tamTinh += productCart.getProduct().getGiaDT() * productCart.getSoLuong();
			giamGia += (tamTinh * productCart.getProduct().getGiamGia()) / 100;
//			thue += (tamTinh * productCart.getProduct().getThue()) / 100;
			session.setAttribute("tamtinh", tamTinh);
			session.setAttribute("giamgia", giamGia);
			session.setAttribute("tongtien", tamTinh - giamGia + thue);
		}
	}

	public int kiemTraProductTonTaiTrongCart(int id, HttpSession session) {
		List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id)
				return i;
		}
		return -1;
	}

	@RequestMapping(value = "/xoaproductcart/{id}")
	public String xoaProductCart(@PathVariable(value = "id") int id, Model model, HttpSession session) {
		List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				cart.remove(i);
				break;
			}
		}
		session.setAttribute("cart", cart);
		capNhatGiaTrongCart(session);
		session.setAttribute("errorcartnull", "");
		return "redirect:/user/cart";
	}

	@RequestMapping(value = "/tangsoluong/{id}")
	public String tangSoLuong(@PathVariable(value = "id") int id, HttpSession session) {
		List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
		for (ProductCart productCart : cart) {
			if (productCart.getProduct().getId() == id) {
				int quantity = productCart.getSoLuong() + 1;
				productCart.setSoLuong(quantity);
			}
		}
		return "redirect:/user/cart";

	}

	@RequestMapping(value = "/giamsoluong/{id}")
	public String giamSoLuong(@PathVariable(value = "id") int id, HttpSession session) {
		List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
		for (ProductCart productCart : cart) {
			if (productCart.getProduct().getId() == id) {
				int quantity = productCart.getSoLuong() - 1;
				productCart.setSoLuong(quantity);
			}
		}
		return "redirect:/user/cart";

	}
}