package BLL;

import java.util.ArrayList;

import DAL.MayBayDAL;
import DTO.MayBayDTO;

public class MayBayBLL {
	MayBayDAL MayBayDAL = new MayBayDAL();

	 public ArrayList<MayBayDTO> getAllMayBay() throws ClassNotFoundException {
	 return MayBayDAL.getAllMayBay();
	 }

	 public ArrayList<MayBayDTO> getMayBayByma_mb(MayBayDTO MayBayDTO)throws ClassNotFoundException {
		 return  MayBayDAL.getMayBayByMa_mb(MayBayDTO);
	 }

	 public int updateMayBay(MayBayDTO MayBayDTO) throws ClassNotFoundException{
	 int result = MayBayDAL.updateMayBay(MayBayDTO);
	 return result;
	 }

	 public int deleteMayBay(MayBayDTO MayBayDTO) throws ClassNotFoundException{
	 int result = MayBayDAL.deleteMayBay(MayBayDTO);
	 return result;
	 }
	 
	 public int insertMayBay(MayBayDTO MayBayDTO) throws ClassNotFoundException{
	 int result = MayBayDAL.insertMayBay(MayBayDTO);
	 return result;
	 }

}
