package DTO;

import java.sql.Time;
import java.util.Date;

public class ChuyenBayDTO {
	private String ma_cb;
    private String ma_tuyenbay;
	private Date ngaygio;
	private String thoigianbay;
	private int soghehang1;
	private int soghehang2;
	private String ma_mb;
 
	public ChuyenBayDTO() {
		this.ma_cb=null;
		this.ma_tuyenbay=null;
		this.ngaygio=null;
		this.thoigianbay=null;
		this.soghehang1=0;
		this.soghehang2=0;
		this.ma_mb=null;
	}
 
	 public ChuyenBayDTO(String ma_cb,String ma_tuyenbay,Date ngaygio, String thoigianbay, int soghehang1, int soghehang2,String ma_mb) {
		 this.ma_cb = ma_cb; 
		 this.ma_tuyenbay = ma_tuyenbay;
		 this.ngaygio = ngaygio;
		 this.thoigianbay = thoigianbay;
		 this.soghehang1 = soghehang1;
		 this.soghehang2 = soghehang2;
		 this.ma_mb = ma_mb;
	}

	public String getMa_cb() {
		return ma_cb;
	}

	public void setMa_cb(String ma_cb) {
		this.ma_cb = ma_cb;
	}

	public String getMa_tuyenbay() {
		return ma_tuyenbay;
	}

	public void setMa_tuyenbay(String ma_tuyenbay) {
		this.ma_tuyenbay = ma_tuyenbay;
	}

	public Date getNgaygio() {
		return ngaygio;
	}

	public void setNgaygio(Date ngaygio) {
		this.ngaygio = ngaygio;
	}

	public String getThoigianbay() {
		return thoigianbay;
	}

	public void setThoigianbay(String thoigianbay) {
		this.thoigianbay = thoigianbay;
	}

	public int getSoghehang1() {
		return soghehang1;
	}

	public void setSoghehang1(int soghehang1) {
		this.soghehang1 = soghehang1;
	}

	public int getSoghehang2() {
		return soghehang2;
	}

	public void setSoghehang2(int soghehang2) {
		this.soghehang2 = soghehang2;
	}

	public String getMa_mb() {
		return ma_mb;
	}

	public void setMa_mb(String ma_mb) {
		this.ma_mb = ma_mb;
	}
}
