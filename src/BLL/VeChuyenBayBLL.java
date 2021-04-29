package BLL;

import java.util.ArrayList;

import DAL.VeChuyenBayDAL;
import DTO.VeChuyenBayDTO;

public class VeChuyenBayBLL {
	VeChuyenBayDAL VeChuyenBayDAL = new VeChuyenBayDAL();
	
	 public ArrayList<VeChuyenBayDTO> getAllVeChuyenBay() throws ClassNotFoundException{
	 return VeChuyenBayDAL.getAllVeChuyenBay();
	 }

	 public ArrayList<VeChuyenBayDTO> getVeChuyenBayByma_ve_cb(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException{
	 return VeChuyenBayDAL.getVeChuyenBayByMa_ve_cb(VeChuyenBayDTO);
	 }

	 public int updateVeChuyenBay(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException{
	 int result = VeChuyenBayDAL.updateVeChuyenBay(VeChuyenBayDTO);
	 return result;
	 }

	 public int deleteVeChuyenBay(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException{
	 int result = VeChuyenBayDAL.deleteVeChuyenBay(VeChuyenBayDTO);
	 return result;
	 }
	 
	 public int insertVeChuyenBay(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException{
	 int result = VeChuyenBayDAL.insertVeChuyenBay(VeChuyenBayDTO);
	 return result;
	 }
	 
	 public ArrayList<VeChuyenBayDTO> getVeChuyenBayByma_hd(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException{
		 return VeChuyenBayDAL.getVeChuyenBayByMa_hd(VeChuyenBayDTO);
	 }
	 
	 public ArrayList<VeChuyenBayDTO> getVeChuyenBayByma_cb(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException{
		 return VeChuyenBayDAL.getVeChuyenBayByMa_cb(VeChuyenBayDTO);
	 }


}
