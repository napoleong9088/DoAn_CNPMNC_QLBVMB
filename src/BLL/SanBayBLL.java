package BLL;

import java.util.ArrayList;

import DAL.SanBayDAL;
import DTO.SanBayDTO;


public class SanBayBLL {
	SanBayDAL SanBayDAL = new SanBayDAL();

	 public ArrayList<SanBayDTO> getAllSanBay() throws ClassNotFoundException {
	 return SanBayDAL.getAllSanBay();
	 }

	 public ArrayList<SanBayDTO> getSanBayByma_sb(SanBayDTO SanBayDTO) throws ClassNotFoundException{
	 return SanBayDAL.getSanBayByMa_sb(SanBayDTO);
	 }

	 public int updateSanBay(SanBayDTO SanBayDTO) throws ClassNotFoundException{
	 int result = SanBayDAL.updateSanBay(SanBayDTO);
	 return result;
	 }

	 public int deleteSanBay(SanBayDTO SanBayDTO) throws ClassNotFoundException{
	 int result = SanBayDAL.deleteSanBay(SanBayDTO);
	 return result;
	 }
	 
	 public int insertSanBay(SanBayDTO SanBayDTO) throws ClassNotFoundException{
	 int result = SanBayDAL.insertSanBay(SanBayDTO);
	 return result;
	 }

}
