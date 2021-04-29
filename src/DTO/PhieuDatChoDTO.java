package DTO;

import java.util.Date;

public class PhieuDatChoDTO {
	 private String ma_phieu;
	 private String ma_ve_cb;
	 private Date ngaydat;
	 private int soghe;
	 
	 public PhieuDatChoDTO() {
		 this.ma_phieu = null;
		 this.ma_ve_cb = null;
		 this.ngaydat =null;
		 this.soghe = 0;
   }
	 
	 public PhieuDatChoDTO(String ma_phieu, String ma_ve_cb, Date ngaydat,int soghe) {
		 this.ma_phieu= ma_phieu;
		 this.ma_ve_cb = ma_ve_cb;
		 this.ngaydat = ngaydat;
		 this.soghe = soghe;
    }

	public String getMa_phieu() {
		return ma_phieu;
	}

	public void setMa_phieu(String ma_phieu) {
		this.ma_phieu = ma_phieu;
	}

	public String getMa_ve_cb() {
		return ma_ve_cb;
	}

	public void setMa_ve_cb(String ma_ve_cb) {
		this.ma_ve_cb = ma_ve_cb;
	}

	public Date getNgaydat() {
		return ngaydat;
	}

	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}

	public int getSoghe() {
		return soghe;
	}

	public void setSoghe(int soghe) {
		this.soghe = soghe;
	}
}
