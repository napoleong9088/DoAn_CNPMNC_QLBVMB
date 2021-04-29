package DTO;

public class SanBayDTO {
	 private String ma_sb;
	 private String ten_sb;
	 
	 public SanBayDTO() {
		 this.ma_sb=null;
		 this.ten_sb=null;
    }
	 
	 public SanBayDTO(String ma_sb, String ten_sb) {
		 this.ma_sb= ma_sb;
		 this.ten_sb = ten_sb;
     }

	public String getMa_sb() {
		return ma_sb;
	}

	public void setMa_sb(String ma_sb) {
		this.ma_sb = ma_sb;
	}

	public String getTen_sb() {
		return ten_sb;
	}

	public void setTen_sb(String ten_sb) {
		this.ten_sb = ten_sb;
	}
}
