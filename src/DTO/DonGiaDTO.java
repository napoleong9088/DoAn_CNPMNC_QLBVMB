package DTO;

public class DonGiaDTO {
	private  String  ma_dongia;
	 private int VND;
	 private int USD;
	 
	 public DonGiaDTO() {
	 this.ma_dongia=null;
	 this.VND=0;
	 this.USD=0;
  	 }
	 
	 public DonGiaDTO(String ma_dongia,int VND,int USD) {
	 this.ma_dongia= ma_dongia;
	 this.VND = VND;
	 this.USD = USD;
   	 }

	public String getMa_dongia() {
		return ma_dongia;
	}

	public void setMa_dongia(String ma_dongia) {
		this.ma_dongia = ma_dongia;
	}

	public int getVND() {
		return VND;
	}

	public void setVND(int vND) {
		VND = vND;
	}

	public int getUSD() {
		return USD;
	}

	public void setUSD(int uSD) {
		USD = uSD;
	}
}
