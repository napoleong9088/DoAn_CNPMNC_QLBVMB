package DTO;

import java.util.Date;

public class HoaDonDTO {
	private String Ma_hd;
	private int Thanh_tien;
	private Date Ngay_Lap;
	private String Ma_nv;
	private String Ma_kh;
	private String Ma_ve_cb;
	
	public HoaDonDTO() {
		this.Ma_hd=null;
		this.Thanh_tien=0;
		this.Ngay_Lap=null;
		this.Ma_nv=null;
		this.Ma_kh=null;
	}
	public HoaDonDTO(String Ma_hd, int Thanh_tien, Date Ngay_Lap, String Ma_nv, String Ma_kh) {
		this.Ma_hd=Ma_hd;
		this.Thanh_tien=Thanh_tien;
		this.Ngay_Lap=Ngay_Lap;
		this.Ma_nv=Ma_kh;
		this.Ma_kh=Ma_kh;
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
}
