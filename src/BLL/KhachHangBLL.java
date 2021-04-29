package BLL;

import java.util.ArrayList;

import DAL.KhachHangDAL;
import DTO.KhachHangDTO;

public class KhachHangBLL {
	KhachHangDAL KhachHangDAL = new KhachHangDAL();

	 public ArrayList<KhachHangDTO> getAllKhachHang() throws ClassNotFoundException{
	 return KhachHangDAL.getAllKhachhang();
	 }

	 public ArrayList<KhachHangDTO> getKhachHangByma_kh(KhachHangDTO KhachHangDTO)throws ClassNotFoundException {
	 return KhachHangDAL.getKhachHangByMa_kh(KhachHangDTO);
	 }

	 public int updateKhachHang(KhachHangDTO KhachHangDTO) throws ClassNotFoundException{
	 int result = KhachHangDAL.updateKhachHang(KhachHangDTO);
	 return result;
	 }

	 public int deleteKhachHang(KhachHangDTO KhachHangDTO) throws ClassNotFoundException{
	 int result = KhachHangDAL.deleteKhachHang(KhachHangDTO);
	 return result;
	 }
	 
	 public int insertKhachHang(KhachHangDTO KhachHangDTO) throws ClassNotFoundException{
	 int result = KhachHangDAL.insertKhachHang(KhachHangDTO);
	 return result;
	 }
	 public ArrayList<KhachHangDTO> getKhachHangByCMND_PP(KhachHangDTO KhachHangDTO)throws ClassNotFoundException {
		 return KhachHangDAL.getKhachHangByCMND_PP(KhachHangDTO);
	 }
	 
	 public ArrayList<KhachHangDTO> getKhachHangBySDT(KhachHangDTO KhachHangDTO)throws ClassNotFoundException {
		 return KhachHangDAL.getKhachHangBySDT(KhachHangDTO);
	 }
	 
	 public ArrayList<KhachHangDTO> getKhachHangByEmail(KhachHangDTO KhachHangDTO)throws ClassNotFoundException {
		 return KhachHangDAL.getKhachHangEmail(KhachHangDTO);
	 }

}
