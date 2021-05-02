package DTO;

import java.sql.Date;
import java.sql.Time;


public class VeChuyenBayDTO {
	 private String ma_ve_cb ;
	 private String so_ghe;
	 private String ma_cb;
	 private String ma_kh;
	 private Time thoi_gian_bay;
	 private Date ngay_bay;
	 private int gia;
	 private String tinhtrangve;
	 
	 public VeChuyenBayDTO () {
		 this.ma_ve_cb = null;
		 this.so_ghe = null;
		 this.ma_cb = null;
		 this.ma_kh = null; 
		 this.thoi_gian_bay = null;
		 this.ngay_bay = null;
		 this.gia = 0;
		 this.tinhtrangve = null;
	 }
	 
	 public VeChuyenBayDTO(String ma_ve_cb, String  so_ghe, String  ma_cb, String  ma_kh, Time thoi_gian_bay, Date ngay_bay, int gia, String tinhtrangve) {
		 this.ma_ve_cb = ma_ve_cb;
		 this.so_ghe = so_ghe;
		 this.ma_cb = ma_cb;
		 this.ma_kh = ma_kh; 
		 this.thoi_gian_bay = thoi_gian_bay;
		 this.ngay_bay = ngay_bay;
		 this.gia = 0;
		 this.tinhtrangve = tinhtrangve;
	 }

	public String getMa_ve_cb() {
		return ma_ve_cb;
	}

	public void setMa_ve_cb(String ma_ve_cb) {
		this.ma_ve_cb = ma_ve_cb;
	}

	public String getSo_ghe() {
		return so_ghe;
	}

	public void setSo_ghe(String so_ghe) {
		this.so_ghe = so_ghe;
	}

	public String getMa_cb() {
		return ma_cb;
	}

	public void setMa_cb(String ma_cb) {
		this.ma_cb = ma_cb;
	}

	public String getMa_kh() {
		return ma_kh;
	}

	public void setMa_kh(String ma_kh) {
		this.ma_kh = ma_kh;
	}

	public Time getThoi_gian_bay() {
		return thoi_gian_bay;
	}

	public void setThoi_gian_bay(Time thoi_gian_bay) {
		this.thoi_gian_bay = thoi_gian_bay;
	}

	public Date getNgay_bay() {
		return ngay_bay;
	}

	public void setNgay_bay(Date ngay_bay) {
		this.ngay_bay = ngay_bay;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getTinhtrangve() {
		return tinhtrangve;
	}

	public void setTinhtrangve(String tinhtrangve) {
		this.tinhtrangve = tinhtrangve;
	}
}
