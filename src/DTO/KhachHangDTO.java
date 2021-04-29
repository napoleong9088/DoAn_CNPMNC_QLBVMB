package DTO;

public class KhachHangDTO {
		private String Ma_kh;
		private String Ten_kh;
		private String Email;
		private String Passworld;
		private String Cmnd;
		private String SDT;
		private String DiaChi;
		
		public KhachHangDTO() {
			this.Ma_kh=null;
			this.Ten_kh=null;
			this.Email=null;
			this.Passworld=null;
			this.Cmnd=null;
			this.SDT=null;
			this.DiaChi=null;
		}
		public KhachHangDTO(String Ma_kh, String Ten_kh, String Email, String Password,String Cmnd, String SDT, String Diachi) {
			this.Ma_kh=Ma_kh;
			this.Ten_kh=Ten_kh;
			this.Email=Email;
			this.Passworld=Passworld;
			this.Cmnd=Cmnd;
			this.SDT=SDT;
			this.DiaChi=DiaChi;
		}
		public String getMa_kh() {
			return Ma_kh;
		}
		public void setMa_kh(String ma_kh) {
			Ma_kh = ma_kh;
		}
		public String getTen_kh() {
			return Ten_kh;
		}
		public void setTen_kh(String ten_kh) {
			Ten_kh = ten_kh;
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
		public String getCmnd() {
			return Cmnd;
		}
		public void setCmnd(String cmnd) {
			Cmnd = cmnd;
		}
}
