package BLL;

import java.util.ArrayList;

import DAL.ChuyenBayDAL;
import DTO.ChuyenBayDTO;
import DTO.TuyenBayDTO;

public class ChuyenBayBLL {
	ChuyenBayDAL ChuyenBayDAL = new ChuyenBayDAL();

	 public ArrayList<ChuyenBayDTO> getAllChuyenBay() throws ClassNotFoundException  {
	 return ChuyenBayDAL.getAllChuyenBay();
	 }

	 public ArrayList<ChuyenBayDTO> getChuyenBayByma_cb(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException{
	 return ChuyenBayDAL.getChuyenBayByma_cb(ChuyenBayDTO);
	 }

	 public int updateChuyenBay(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException {
	 int result = ChuyenBayDAL.updateChuyenBay(ChuyenBayDTO);
	 return result;
	 }

	 public int deleteChuyenBay(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException {
	 int result = ChuyenBayDAL.deleteChuyenBay(ChuyenBayDTO);
	 return result;
	 }
	 
	 public int insertChuyenBay(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException {
	 int result = ChuyenBayDAL.insertChuyenBay(ChuyenBayDTO);
	 return result;
	 }
	 
	 public ArrayList<ChuyenBayDTO> getChuyenBayBydiem(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException{
		 return ChuyenBayDAL.getChuyenBayBydiem(TuyenBayDTO);
	 }
}
