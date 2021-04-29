package BLL;

import java.util.ArrayList;

import DAL.DonGiaDAL;
import DTO.DonGiaDTO;

public class DonGiaBLL {
	DonGiaDAL DonGiaDAL = new DonGiaDAL();

	 public ArrayList<DonGiaDTO> getAllDonGia()throws ClassNotFoundException {
	 return DonGiaDAL.getAllDonGia();
	 }

	 public ArrayList<DonGiaDTO> getDonGiaByma_dongia(DonGiaDTO DonGiaDTO) throws ClassNotFoundException {
	 return DonGiaDAL.getDonGiaByma_don_gia(DonGiaDTO);
	 }

	 public int updateDonGia(DonGiaDTO DonGiaDTO) throws ClassNotFoundException{
	 int result = DonGiaDAL.updateDonGia(DonGiaDTO);
	 return result;
	 }

	 public int deleteDonGia(DonGiaDTO DonGiaDTO) throws ClassNotFoundException{
	 int result = DonGiaDAL.deleteDonGia(DonGiaDTO);
	 return result;
	 }
	 
	 public int insertDonGia(DonGiaDTO DonGiaDTO) throws ClassNotFoundException{
	 int result = DonGiaDAL.insertDonGia(DonGiaDTO);
	 return result;
	 }

}
