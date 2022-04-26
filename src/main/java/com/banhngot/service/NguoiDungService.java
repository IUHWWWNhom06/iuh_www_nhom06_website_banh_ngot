package com.banhngot.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.banhngot.entity.NguoiDung;

public interface NguoiDungService extends UserDetailsService{
	public void saveNguoiDung(NguoiDung nguoiDung);
	public void deleteNguoiDung(int id);
	public NguoiDung getNguoiDung(int id);
	public List<NguoiDung> getListNguoiDung();
	public NguoiDung dangNhapAdmin(String tenDangnhap, String matKhau);
	public NguoiDung getTenDangNhap(String tenDangNhap);
	public NguoiDung getEmail(String email);
	public List<NguoiDung> getDatHang();
	public List<NguoiDung> getChuaDatHang();
	public List<NguoiDung> timKiemNguoiDungChuaDatHang(String search);
	public List<NguoiDung> timKiemNguoiDungDatHang(String search);
}
