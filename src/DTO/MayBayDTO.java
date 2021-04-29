package DTO;

public class MayBayDTO {
	 private String ma_mb;
	 private String ten_mb;
	
	 
	 public MayBayDTO() {
		 this.ma_mb=null;
		 this.ten_mb=null;
	 
  }
	 
	 public MayBayDTO(String ma_mb, String ten_mb) {
		 this.ma_mb= ma_mb;
		 this.ten_mb = ten_mb;
   }

	public String getMa_mb() {
		return ma_mb;
	}

	public void setMa_mb(String ma_mb) {
		this.ma_mb = ma_mb;
	}

	public String getTen_mb() {
		return ten_mb;
	}

	public void setTen_mb(String ten_mb) {
		this.ten_mb = ten_mb;
	}
}
