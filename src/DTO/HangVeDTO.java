package DTO;

public class HangVeDTO {
	 private String ma_hv;
	 private String ten_hv;
	 
	 
	 public HangVeDTO() {
		 this.ma_hv = null;
		 this.ten_hv =null;
	 }
	 
	 public HangVeDTO(String ma_hv, String ten_hv) {
		 this.ma_hv = ma_hv;
		 this.ten_hv = ten_hv;
	 }

	public String getMa_hv() {
		return ma_hv;
	}

	public void setMa_hv(String ma_hv) {
		this.ma_hv = ma_hv;
	}

	public String getTen_hv() {
		return ten_hv;
	}

	public void setTen_hv(String ten_hv) {
		this.ten_hv = ten_hv;
	}
}
