package BLL;

import java.util.ArrayList;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;

public class NhanVienBLL {
NhanVienDAL NhanVienDAL =new NhanVienDAL();
	
	public ArrayList<NhanVienDTO> getAllNhanVien() throws ClassNotFoundException {
		return NhanVienDAL.getAllNhanVien();
	}
	public ArrayList<NhanVienDTO> getNhanVienByMANV(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
		return NhanVienDAL.getNhanVienByMANV(NhanVienDTO);
	}
	public int updateNhanVien(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
		int result = NhanVienDAL.updateNhanVien(NhanVienDTO);
		return result;
	}
	public int insertNhanVien(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
		int result = NhanVienDAL.insertNhanVien(NhanVienDTO);
		return result;
	}
	public int deleteNhanVien(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
		int result = NhanVienDAL.deleteNhanVien(NhanVienDTO);
		return result;
	}
}
