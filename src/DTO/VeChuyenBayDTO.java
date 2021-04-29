package DTO;

public class VeChuyenBayDTO {
	 private String ma_ve_cb ;
	 private String ma_hd;
	 private String ma_cb;
	 private String ma_dongia;
	 private String ma_hv;
	 private String tinhtrangve;
	 
	 public VeChuyenBayDTO () {
		 this.ma_ve_cb = null;
		 this.ma_hd = null;
		 this.ma_cb = null;
		 this.ma_dongia = null; 
		 this.ma_hv = null;
		 this.tinhtrangve = null;
	 }
	 
	 public VeChuyenBayDTO(String ma_ve_cb, String  ma_hd, String  ma_cb, String  ma_dongia, String  ma_hv, String tinhtrangve) {
		 this.ma_ve_cb = ma_ve_cb;
		 this.ma_hd = ma_hd;
		 this.ma_cb = ma_cb;
		 this.ma_dongia = ma_dongia; 
		 this.ma_hv = ma_hv;
		 this.tinhtrangve = tinhtrangve;
	 }

	public String getMa_ve_cb() {
		return ma_ve_cb;
	}

	public void setMa_ve_cb(String ma_ve_cb) {
		this.ma_ve_cb = ma_ve_cb;
	}

	public String getMa_hd() {
		return ma_hd;
	}

	public void setMa_hd(String ma_hd) {
		this.ma_hd = ma_hd;
	}

	public String getMa_cb() {
		return ma_cb;
	}

	public void setMa_cb(String ma_cb) {
		this.ma_cb = ma_cb;
	}

	public String getMa_dongia() {
		return ma_dongia;
	}

	public void setMa_dongia(String ma_dongia) {
		this.ma_dongia = ma_dongia;
	}

	public String getMa_hv() {
		return ma_hv;
	}

	public void setMa_hv(String ma_hv) {
		this.ma_hv = ma_hv;
	}

	public String getTinhtrangve() {
		return tinhtrangve;
	}

	public void setTinhtrangve(String tinhtrangve) {
		this.tinhtrangve = tinhtrangve;
	}
}
