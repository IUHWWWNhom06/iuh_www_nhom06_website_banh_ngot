package com.banhngot.controller.user;

import java.security.Principal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banhngot.entity.OrderDetail;
import com.banhngot.entity.Product;
import com.banhngot.entity.ProductCart;
import com.banhngot.entity.Order;
import com.banhngot.entity.NguoiDung;
import com.banhngot.entity.PaymentMethod;
import com.banhngot.service.ProductService;
import com.banhngot.service.OrderService;
import com.banhngot.service.NguoiDungService;
import com.banhngot.service.OrderDetailService;

@Controller(value = "paymentController")
@RequestMapping(value = "/user")
public class PaymentController {
	@Autowired
	OrderService orderService;

	@Autowired
	NguoiDungService nguoiDungService;

	@Autowired
	OrderDetailService orderDetailService;

	@Autowired
	ProductService productService;

	@GetMapping(value = "/showFormNguoiNhan")
	public String showFormNguoiNhan(Model model, HttpSession session) {
		List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
		if (cart == null) {
			session.setAttribute("errorcartnull", "Vui lòng chọn sản phẩm vào giỏ hàng");
			return "redirect:/user/gioHang";

		} else {
			if (cart.size() <= 0) {
				session.setAttribute("errorcartnull", "Vui lòng chọn sản phẩm vào giỏ hàng");
				return "redirect:/user/gioHang";
			} else {
				List<PaymentMethod> getAllPaymentMethod = orderService.getAllPaymentMethod();
				model.addAttribute("nguoiNhan", new Order());
				model.addAttribute("getAllPaymentMethod", getAllPaymentMethod);
				return "user/thanhtoan";
			}
		}
	}

	@RequestMapping(value = "/thanhtoan", method = RequestMethod.POST)
	public String thanhToan(@Valid @ModelAttribute("nguoiNhan")Order nguoiNhan,BindingResult result,@RequestParam("idPT") int idPT, Model model, Principal principal,
			HttpSession session) {
		if (result.hasErrors()) {
			List<PaymentMethod> getAllPaymentMethod = orderService.getAllPaymentMethod();
			model.addAttribute("getAllPaymentMethod", getAllPaymentMethod);
			return "user/thanhtoan";
		}
		else {
			String tenDangNhap = principal.getName();
			NguoiDung nguoiDung = nguoiDungService.getTenDangNhap(tenDangNhap);
			nguoiNhan.setNguoiDung(nguoiDung);
			
			PaymentMethod pm=orderService.getMethod(idPT);
			nguoiNhan.setPayment(pm);
			
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			nguoiNhan.setCreateAt(date);
						
			orderService.saveOrder(nguoiNhan);
			
			DecimalFormat format = new DecimalFormat("###,###.## vnđ");
			List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
			String noiDung="";
			for (ProductCart cake : cart) {	
				noiDung+="Bánh: "+cake.getProduct().getName()+" "
						 +" . "+"Đơn giá: "+format.format(cake.getProduct().getPrice())+" "+" Số lượng: "+cake.getSoLuong()+" \n";
				orderDetailService.addAllOrderDetail( nguoiNhan.getId(),cake.getProduct().getId(), cake.getSoLuong());
				Product capNhatSoLuong=cake.getProduct();
				int soLuong=0;
				soLuong= cake.getProduct().getQuantity()-cake.getSoLuong();
				capNhatSoLuong.setQuantity(soLuong);
				productService.saveProduct(capNhatSoLuong);
			}
			String thongTinNguoiNhan = 
					"- Họ và tên: "+nguoiNhan.getNameCustomer()+"\n"+
					"- Số điện thoại: "+nguoiNhan.getPhoneCustomer()+"\n"+
					"- Email: "+nguoiNhan.getEmail()+"\n"+
					"- Địa chỉ nhận: "+nguoiNhan.getAddressCustomer()+"\n";
			
			cart.removeAll(cart);
			session.setAttribute("cart", cart);
			return "user/xacnhan";
		}
	}

}
