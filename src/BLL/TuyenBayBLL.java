package BLL;

import java.util.ArrayList;

import DAL.TuyenBayDAL;
import DTO.TuyenBayDTO;

public class TuyenBayBLL {
	TuyenBayDAL TuyenBayDAL = new TuyenBayDAL();

	 public ArrayList<TuyenBayDTO> getAllTuyenBay() throws ClassNotFoundException{
	 return TuyenBayDAL.getAllTuyenBay();
	 }

	 public ArrayList<TuyenBayDTO> getTuyenBayByma_tuyenbay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException{
	 return TuyenBayDAL.getTuyenBayByMa_tuyenbay(TuyenBayDTO);
	 }

	 public int updateTuyenBay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException{
	 int result = TuyenBayDAL.updateTuyenBay(TuyenBayDTO);
	 return result;
	 }

	 public int deleteTuyenBay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException{
	 int result = TuyenBayDAL.deleteTuyenBay(TuyenBayDTO);
	 return result;
	 }
	 
	 public int insertTuyenBay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException{
	 int result = TuyenBayDAL.insertTuyenBay(TuyenBayDTO);
	 return result;
	 }
	 
	 public ArrayList<TuyenBayDTO> searchTuyenBayByma_tuyenbay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException{
		 return TuyenBayDAL.searchTuyenBayByMa_tuyenbay(TuyenBayDTO);
		 }
}
