package DTO;

public class TuyenBayDTO {
	 private String ma_tuyenbay;
	 private String sanbaydi;
	 private String sanbayden;
	 
	 public TuyenBayDTO() {
		 this.ma_tuyenbay=null;
		 this.sanbaydi=null;
		 this.sanbayden=null;
   }
	 
	 public TuyenBayDTO(String ma_tuyenbay, String sanbaydi,String sanbayden) {
		 this.ma_tuyenbay= ma_tuyenbay;
		 this.sanbaydi = sanbaydi;
		 this.sanbayden = sanbayden;
    }

	public String getMa_tuyenbay() {
		return ma_tuyenbay;
	}

	public void setMa_tuyenbay(String ma_tuyenbay) {
		this.ma_tuyenbay = ma_tuyenbay;
	}

	public String getSanbaydi() {
		return sanbaydi;
	}

	public void setSanbaydi(String sanbaydi) {
		this.sanbaydi = sanbaydi;
	}

	public String getSanbayden() {
		return sanbayden;
	}

	public void setSanbayden(String sanbayden) {
		this.sanbayden = sanbayden;
	}
}
