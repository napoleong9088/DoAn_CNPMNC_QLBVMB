package DTO;

import java.util.Date;

public class HoaDonDTO {
	private String Ma_hd;
	private String Ten_hd;
	private String Ma_nv;
	private String Ma_kh;
	private String Ma_ve_cb;
	private int Thanh_tien;
	private String TrangThai;
	private Date Ngay_Lap;
	
	public HoaDonDTO() {
		this.Ma_hd=null;
		this.Ten_hd=null;
		this.Ma_nv=null;
		this.Ma_kh=null;
		this.Ma_ve_cb=null;
		this.Thanh_tien=0;
		this.TrangThai=null;
		this.Ngay_Lap=null;
	}
	public HoaDonDTO(String Ma_hd, String Ten_hd, String Ma_nv, String Ma_kh, String Ma_ve_cb, int Thanh_tien, String TrangThai, Date Ngay_Lap) {
		this.Ma_hd=Ma_hd;
		this.Ten_hd=Ten_hd;
		this.Ma_nv=Ma_nv;
		this.Ma_kh=Ma_kh;
		this.Ma_ve_cb=Ma_ve_cb;
		this.Thanh_tien=Thanh_tien;
		this.TrangThai=TrangThai;
		this.Ngay_Lap=Ngay_Lap;
	}
	public String getMa_hd() {
		return Ma_hd;
	}
	public void setMa_hd(String ma_hd) {
		Ma_hd = ma_hd;
	}
	public int getThanh_tien() {
		return Thanh_tien;
	}
	public void setThanh_tien(int thanh_tien) {
		Thanh_tien = thanh_tien;
	}
	public Date getNgay_Lap() {
		return Ngay_Lap;
	}
	public void setNgay_Lap(Date ngay_Lap) {
		Ngay_Lap = ngay_Lap;
	}
	public String getMa_nv() {
		return Ma_nv;
	}
	public void setMa_nv(String ma_nv) {
		Ma_nv = ma_nv;
	}
	public String getMa_kh() {
		return Ma_kh;
	}
	public void setMa_kh(String ma_kh) {
		Ma_kh = ma_kh;
	}
	public String getTen_hd() {
		return Ten_hd;
	}
	public void setTen_hd(String ten_hd) {
		Ten_hd = ten_hd;
	}
	public String getMa_ve_cb() {
		return Ma_ve_cb;
	}
	public void setMa_ve_cb(String ma_ve_cb) {
		Ma_ve_cb = ma_ve_cb;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
}
