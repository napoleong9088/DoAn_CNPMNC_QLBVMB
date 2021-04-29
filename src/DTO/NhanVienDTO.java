package DTO;

public class NhanVienDTO {
	private String Ma_nv;
	private String Ten_nv;
	private String Email;
	private String Passworld;
	private String SDT;
	private String DiaChi;
	
	public NhanVienDTO() {
		this.Ma_nv=null;
		this.Ten_nv=null;
		this.Email=null;
		this.Passworld=null;
		this.SDT=null;
		this.DiaChi=null;
	}
	public NhanVienDTO(String Ma_nv, String Ten_nv, String Email, String Password, String SDT, String Diachi) {
		this.Ma_nv=Ma_nv;
		this.Ten_nv=Ten_nv;
		this.Email=Email;
		this.Passworld=Passworld;
		this.SDT=SDT;
		this.DiaChi=DiaChi;
	}
	public String getMa_nv() {
		return Ma_nv;
	}
	public void setMa_nv(String ma_nv) {
		Ma_nv = ma_nv;
	}
	public String getTen_nv() {
		return Ten_nv;
	}
	public void setTen_nv(String ten_nv) {
		Ten_nv = ten_nv;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassworld() {
		return Passworld;
	}
	public void setPassworld(String passworld) {
		Passworld = passworld;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

}	
