package BLL;

import java.util.ArrayList;

import DAL.HoaDonDAL;
import DTO.HoaDonDTO;

public class HoaDonBLL {
	HoaDonDAL HoaDonDAL = new HoaDonDAL();

	 public ArrayList<HoaDonDTO> getAllHoaDon() throws ClassNotFoundException{
	 return HoaDonDAL.getAllHoaDon();
	 }

	 public ArrayList<HoaDonDTO> getHoaDonByma_hd(HoaDonDTO HoaDonDTO)throws ClassNotFoundException {
	 return HoaDonDAL.getHoaDonByMa_hd(HoaDonDTO);
	 }

	 public int updateHoaDon(HoaDonDTO HoaDonDTO) throws ClassNotFoundException{
	 int result = HoaDonDAL.updateHoaDon(HoaDonDTO);
	 return result;
	 }

	 public int deleteHoaDon(HoaDonDTO HoaDonDTO) throws ClassNotFoundException{
	 int result = HoaDonDAL.deleteHoaDon(HoaDonDTO);
	 return result;
	 }
	 
	 public int insertHoaDon(HoaDonDTO HoaDonDTO) throws ClassNotFoundException{
	 int result = HoaDonDAL.insertHoaDon(HoaDonDTO);
	 return result;
	 } 
	 
	 public ArrayList<HoaDonDTO> getHoaDonByma_kh(HoaDonDTO HoaDonDTO)throws ClassNotFoundException {
		 return HoaDonDAL.getHoaDonByMa_kh(HoaDonDTO);
	 }

}
