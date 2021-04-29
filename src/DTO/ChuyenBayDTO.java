package DTO;

import java.sql.Time;
import java.sql.Date;

public class ChuyenBayDTO {
	private String MaChuyenbay;
	private String HangHK;
	private String KyHieuMB;
	private String TenMayBay;
	private Date NgayBay;
	private Time GioBay;
	private String DiemDi;
	private String DiemDen;
	private String SanBayDi;
	private String SanBayDen;
	private String LoaiGhe;
	private String SoGhe;
	private int Gia;
	private String QuyDinh;
 
	public ChuyenBayDTO() {
		this.MaChuyenbay=null;
		this.HangHK=null;
		this.KyHieuMB=null;
		this.TenMayBay=null;
		this.NgayBay=null;
		this.GioBay=null;
		this.DiemDi=null;
		this.DiemDen=null;
		this.SanBayDi=null;
		this.SanBayDen=null;
		this.LoaiGhe=null;
		this.SoGhe=null;
		this.Gia=0;
		this.QuyDinh=null;
	}
 
	 public ChuyenBayDTO(String MaChuyenbay, String HangHK, String KyHieuMB, String TenMayBay, Date NgayBay, Time GioBay, String DiemDi, String DiemDen, String SanBayDi, String SanBayDen, String LoaiGhe, String SoGhe, int Gia, String QuyDinh) {
		 this.MaChuyenbay=MaChuyenbay;
		 this.HangHK=HangHK;
		 this.KyHieuMB=KyHieuMB;
		 this.TenMayBay=TenMayBay;
		 this.NgayBay=NgayBay;
		 this.GioBay=GioBay;
		 this.DiemDi=DiemDi;
		 this.DiemDen=DiemDen;
		 this.SanBayDi=SanBayDi;
		 this.SanBayDen=SanBayDen;
		 this.LoaiGhe=LoaiGhe;
		 this.SoGhe=SoGhe;
		 this.Gia=Gia;
		 this.QuyDinh=QuyDinh;
	}

	public String getMaChuyenbay() {
		return MaChuyenbay;
	}

	public void setMaChuyenbay(String maChuyenbay) {
		MaChuyenbay = maChuyenbay;
	}

	public String getHangHK() {
		return HangHK;
	}

	public void setHangHK(String hangHK) {
		HangHK = hangHK;
	}

	public String getKyHieuMB() {
		return KyHieuMB;
	}

	public void setKyHieuMB(String kyHieuMB) {
		KyHieuMB = kyHieuMB;
	}

	public String getTenMayBay() {
		return TenMayBay;
	}

	public void setTenMayBay(String tenMayBay) {
		TenMayBay = tenMayBay;
	}

	public Date getNgayBay() {
		return NgayBay;
	}

	public void setNgayBay(Date ngayBay) {
		NgayBay = ngayBay;
	}

	public Time getGioBay() {
		return GioBay;
	}

	public void setGioBay(Time gioBay) {
		GioBay = gioBay;
	}

	public String getDiemDi() {
		return DiemDi;
	}

	public void setDiemDi(String diemDi) {
		DiemDi = diemDi;
	}

	public String getDiemDen() {
		return DiemDen;
	}

	public void setDiemDen(String diemDen) {
		DiemDen = diemDen;
	}

	public String getSanBayDi() {
		return SanBayDi;
	}

	public void setSanBayDi(String sanBayDi) {
		SanBayDi = sanBayDi;
	}

	public String getSanBayDen() {
		return SanBayDen;
	}

	public void setSanBayDen(String sanBayDen) {
		SanBayDen = sanBayDen;
	}

	public String getLoaiGhe() {
		return LoaiGhe;
	}

	public void setLoaiGhe(String loaiGhe) {
		LoaiGhe = loaiGhe;
	}

	public String getSoGhe() {
		return SoGhe;
	}

	public void setSoGhe(String soGhe) {
		SoGhe = soGhe;
	}

	public int getGia() {
		return Gia;
	}

	public void setGia(int gia) {
		Gia = gia;
	}

	public String getQuyDinh() {
		return QuyDinh;
	}

	public void setQuyDinh(String quyDinh) {
		QuyDinh = quyDinh;
	}
}
