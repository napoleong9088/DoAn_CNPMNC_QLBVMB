package BLL;

import java.util.ArrayList;

import DAL.PhieuDatChoDAL;
import DTO.PhieuDatChoDTO;

public class PhieuDatChoBLL {
	 PhieuDatChoDAL  PhieuDatChoDAL = new  PhieuDatChoDAL();

	 public ArrayList< PhieuDatChoDTO> getAllPhieuDatCho() throws ClassNotFoundException{
	 return  PhieuDatChoDAL.getAllPhieuDatCho();
	 }

	 public ArrayList< PhieuDatChoDTO> getPhieuDatChoByma_phieu( PhieuDatChoDTO  PhieuDatChoDTO)throws ClassNotFoundException {
	 return  PhieuDatChoDAL.getPhieuDatChoByMa_phieu( PhieuDatChoDTO);
	 }

	 public int updatePhieuDatCho( PhieuDatChoDTO  PhieuDatChoDTO) throws ClassNotFoundException {
	 int result =  PhieuDatChoDAL.updatePhieuDatCho( PhieuDatChoDTO);
	 return result;
	 }

	 public int deletePhieuDatCho( PhieuDatChoDTO  PhieuDatChoDTO) throws ClassNotFoundException{
	 int result =  PhieuDatChoDAL.deletePhieuDatCho( PhieuDatChoDTO);
	 return result;
	 }
	 
	 public int insertPhieuDatCho( PhieuDatChoDTO  PhieuDatChoDTO) throws ClassNotFoundException{
	 int result =  PhieuDatChoDAL.insertPhieuDatCho( PhieuDatChoDTO);
	 return result;
	 }

}
