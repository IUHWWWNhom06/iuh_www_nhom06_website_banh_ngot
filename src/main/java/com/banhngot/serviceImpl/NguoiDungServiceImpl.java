package com.banhngot.serviceImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.NguoiDungDAO;
import com.banhngot.entity.NguoiDung;
import com.banhngot.entity.Role;
import com.banhngot.service.NguoiDungService;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {
	@Autowired
	private NguoiDungDAO nguoiDungDAO;

	@Override
	@Transactional
	public void saveNguoiDung(NguoiDung nguoiDung) {
		nguoiDungDAO.saveNguoiDung(nguoiDung);
	}

	@Override
	@Transactional
	public void deleteNguoiDung(int id) {
		nguoiDungDAO.deleteNguoiDung(id);
	}

	@Override
	@Transactional
	public NguoiDung getNguoiDung(int id) {
		return nguoiDungDAO.getNguoiDung(id);
	}

	@Override
	@Transactional
	public List<NguoiDung> getListNguoiDung() {
		return nguoiDungDAO.getListNguoiDung();
	}

	@Override
	@Transactional
	public NguoiDung dangNhapAdmin(String tenDangnhap, String matKhau) {
		// TODO Auto-generated method stub
		return nguoiDungDAO.dangNhapAdmin(tenDangnhap, matKhau);
	}

	@Override
	@Transactional
	public NguoiDung getTenDangNhap(String tenDangNhap) {
		// TODO Auto-generated method stub
		return nguoiDungDAO.getTenDangNhap(tenDangNhap);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		NguoiDung nguoiDung = nguoiDungDAO.getTenDangNhap(username);
		if (nguoiDung == null) {
			throw new UsernameNotFoundException("Tên đăng nhập hoặc mật khẩu không hợp lệ.");
		}
		return new org.springframework.security.core.userdetails.User(nguoiDung.getTenDangNhap(),
				nguoiDung.getMatKhau(), mapRolesToAuthorities(nguoiDung.getRoles()));

	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public NguoiDung getEmail(String email) {
		// TODO Auto-generated method stub
		return nguoiDungDAO.getEmail(email);
	}

	@Transactional
	@Override
	public List<NguoiDung> getDatHang() {
		// TODO Auto-generated method stub
		return nguoiDungDAO.getDatHang();
	}

	@Transactional
	@Override
	public List<NguoiDung> getChuaDatHang() {
		// TODO Auto-generated method stub
		return nguoiDungDAO.getChuaDatHang();
	}

	@Transactional
	@Override
	public List<NguoiDung> timKiemNguoiDungChuaDatHang(String search) {
		// TODO Auto-generated method stub
		return nguoiDungDAO.timKiemNguoiDungChuaDatHang(search);
	}

	@Transactional
	@Override
	public List<NguoiDung> timKiemNguoiDungDatHang(String search) {
		// TODO Auto-generated method stub
		return nguoiDungDAO.timKiemNguoiDungDatHang(search);
	}

}
