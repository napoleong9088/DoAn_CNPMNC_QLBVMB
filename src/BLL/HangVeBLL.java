package BLL;

import java.util.ArrayList;

import DAL.HangVeDAL;
import DTO.HangVeDTO;

public class HangVeBLL {
	HangVeDAL HangVeDAL = new HangVeDAL();

	 public ArrayList<HangVeDTO> getAllHangVe() throws ClassNotFoundException{
	 return HangVeDAL.getAllHangVe();
	 }

	 public ArrayList<HangVeDTO> getHangVeByma_hv(HangVeDTO HangVeDTO)throws ClassNotFoundException {
	 return HangVeDAL.getHangVeByMa_hv(HangVeDTO);
	 }

	 public int updateHangVe(HangVeDTO HangVeDTO) throws ClassNotFoundException{
	 int result = HangVeDAL.updateHangVe(HangVeDTO);
	 return result;
	 }

	 public int deleteHangVe(HangVeDTO HangVeDTO) throws ClassNotFoundException{
	 int result = HangVeDAL.deleteHangVe(HangVeDTO);
	 return result;
	 }
	 
	 public int insertHangVe(HangVeDTO HangVeDTO) throws ClassNotFoundException{
	 int result = HangVeDAL.insertHangVe(HangVeDTO);
	 return result;
	 } 

}
