package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DTO.HoaDonDTO;
import UTILS.ConnectionUtil;

public class HoaDonDAL {
	//thá»±c hiá»‡n káº¿t ná»‘i csdl
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	//thá»±c hiá»‡n cÃ¡c cÃ¢u truy váº¥n
	private PreparedStatement preparedStatement;
	//chá»©a káº¿t quáº£ truy váº¥n
	private ResultSet resultSet;
	
	private Statement st;

	//func hiá»ƒn thá»‹ table hoa_don
	public ArrayList<HoaDonDTO> getAllHoaDon() throws ClassNotFoundException {
		// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng HoaDonDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
		ArrayList<HoaDonDTO> result = new ArrayList<HoaDonDTO>();
		String sqlSelectAll = "select * from hoadon";
			
		try {
			//má»Ÿ káº¿t ná»‘i tá»›i CSDL
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thá»±c thi cÃ¢u truy váº¥n
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				HoaDonDTO HoaDonDTO = new HoaDonDTO();
				HoaDonDTO.setMa_hd(resultSet.getString("ma_hd"));
                                HoaDonDTO.setTen_hd(resultSet.getString("ten_hd"));
				HoaDonDTO.setThanh_tien(resultSet.getInt("thanh_tien"));
				HoaDonDTO.setNgay_Lap(resultSet.getDate("ngay_lap"));
				HoaDonDTO.setMa_nv(resultSet.getString("ma_nv"));
				HoaDonDTO.setMa_kh(resultSet.getString("ma_kh"));
                                HoaDonDTO.setTrangThai(resultSet.getString("TrangThai"));
                                HoaDonDTO.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
				result.add(HoaDonDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//ngáº¯t káº¿t ná»‘i csdl
				con.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}
	//func tÃ¬m kiáº¿m dá»¯ liá»‡u báº±ng ma_hd
	public ArrayList<HoaDonDTO> getHoaDonByMa_hd(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
		// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng HoaDonDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
		ArrayList<HoaDonDTO> result = new ArrayList<HoaDonDTO>();
		String sqlSelectByMa_hd = "select * from hoadon where ma_hd = ?";
			
		try {
			//má»Ÿ káº¿t ná»‘i tá»›i CSDL		
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thá»±c thi cÃ¢u truy váº¥n
			preparedStatement = con.prepareStatement(sqlSelectByMa_hd);
			preparedStatement.setString(1, HoaDonDTO.getMa_hd());
			resultSet  = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				HoaDonDTO HoaDon = new HoaDonDTO();
				HoaDon.setMa_hd(resultSet.getString("ma_hd"));
                                HoaDon.setTen_hd(resultSet.getString("ten_hd"));
				HoaDon.setThanh_tien(resultSet.getInt("thanh_tien"));
				HoaDon.setNgay_Lap(resultSet.getDate("ngay_lap"));
				HoaDon.setMa_nv(resultSet.getString("ma_nv"));
				HoaDon.setMa_kh(resultSet.getString("ma_kh"));
                                HoaDon.setTrangThai(resultSet.getString("TrangThai"));
                                HoaDon.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
				result.add(HoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//ngáº¯t káº¿t ná»‘i csdl
				con.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}
	//func thÃªm hÃ³a Ä‘Æ¡n
	public int insertHoaDon(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
		// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng HoaDonDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
		int result = 0;
		String sqlInsert = "insert into hoa_don(ma_hd,ten_hd,thanh_tien, ngay_lap, ma_nv, ma_kh,ma) values(?,?,?,?,?,?)";
		
		try {
			//má»Ÿ káº¿t ná»‘i tá»›i CSDL	
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thá»±c thi cÃ¢u truy váº¥n
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1, HoaDonDTO.getMa_hd());
			preparedStatement.setInt(2, HoaDonDTO.getThanh_tien());
			preparedStatement.setDate(3, (java.sql.Date) HoaDonDTO.getNgay_Lap());
			preparedStatement.setString(4, HoaDonDTO.getMa_nv());
			preparedStatement.setString(5, HoaDonDTO.getMa_kh());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		  }
		finally {
			try {
				con.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}
	//func sá»­a HoaDon
		public int updateHoaDon(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
			// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng HoaDonDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
			int result = 0;
			String sqlUpdate = "update hoa_don set ten_hd=?, thanh_tien=?, ngay_lap=?, ma_nv=?, ma_kh=?, ma_ve_cb=?, TrangThai=? where ma_hd=?";
			
			try {
				//má»Ÿ káº¿t ná»‘i tá»›i CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thá»±c thi cÃ¢u truy váº¥n
				preparedStatement = con.prepareStatement(sqlUpdate);
                                preparedStatement.setString(1, HoaDonDTO.getTen_hd());
				preparedStatement.setInt(2, HoaDonDTO.getThanh_tien());
				preparedStatement.setDate(3, (java.sql.Date) HoaDonDTO.getNgay_Lap());
				preparedStatement.setString(4, HoaDonDTO.getMa_nv());
				preparedStatement.setString(5, HoaDonDTO.getMa_kh());
                                preparedStatement.setString(6, HoaDonDTO.getMa_ve_cb());
                                preparedStatement.setString(7, HoaDonDTO.getTrangThai());
				preparedStatement.setString(8, HoaDonDTO.getMa_hd());
				result = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
			finally {
				try {
					con.close();
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				  }
			}
			return result;
		}
		//func xÃ³a hÃ³a Ä‘Æ¡n
		public int deleteHoaDon(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
			// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng HoaDonDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
			int result = 0;
			String sqlDelete = "delete from hoadon where ma_hd = ?";
			
			try {
				//má»Ÿ káº¿t ná»‘i tá»›i CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thá»±c thi cÃ¢u truy váº¥n
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1, HoaDonDTO.getMa_hd());
				result = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
			finally {
				try {
					con.close();
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				  }
			}
			return result;
		}
		public ArrayList<HoaDonDTO> getHoaDonByMa_kh(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
			// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng HoaDonDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
			ArrayList<HoaDonDTO> result = new ArrayList<HoaDonDTO>();
			String sqlSelectByMa_kh = "select * from hoadon where ma_kh = ?";
				
			try {
				//má»Ÿ káº¿t ná»‘i tá»›i CSDL		
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thá»±c thi cÃ¢u truy váº¥n
				preparedStatement = con.prepareStatement(sqlSelectByMa_kh);
				preparedStatement.setString(1, HoaDonDTO.getMa_kh());
				resultSet  = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					HoaDonDTO HoaDon = new HoaDonDTO();
					HoaDon.setMa_hd(resultSet.getString("ma_hd"));
                                        HoaDon.setTen_hd(resultSet.getString("ten_hd"));
                                        HoaDon.setThanh_tien(resultSet.getInt("thanh_tien"));
                                        HoaDon.setNgay_Lap(resultSet.getDate("ngay_lap"));
                                        HoaDon.setMa_nv(resultSet.getString("ma_nv"));
                                        HoaDon.setMa_kh(resultSet.getString("ma_kh"));
                                        HoaDon.setTrangThai(resultSet.getString("TrangThai"));
                                        HoaDon.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
					result.add(HoaDon);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					//ngáº¯t káº¿t ná»‘i csdl
					con.close();
					preparedStatement.close();
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				  }
			}
			return result;
		}
                
                public ArrayList<HoaDonDTO> getHoaDonByMa_khMa_cb(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
			// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng HoaDonDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
			ArrayList<HoaDonDTO> result = new ArrayList<HoaDonDTO>();
			String sqlSelectByMa_khcb = "select * from hoadon where ma_kh = ? and ma_ve_cb=?";
				
			try {
				//má»Ÿ káº¿t ná»‘i tá»›i CSDL		
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thá»±c thi cÃ¢u truy váº¥n
				preparedStatement = con.prepareStatement(sqlSelectByMa_khcb);
				preparedStatement.setString(1, HoaDonDTO.getMa_kh());
                                preparedStatement.setString(2, HoaDonDTO.getMa_ve_cb());
				resultSet  = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					HoaDonDTO HoaDon = new HoaDonDTO();
					HoaDon.setMa_hd(resultSet.getString("ma_hd"));
                                        HoaDon.setTen_hd(resultSet.getString("ten_hd"));
                                        HoaDon.setThanh_tien(resultSet.getInt("thanh_tien"));
                                        HoaDon.setNgay_Lap(resultSet.getDate("ngay_lap"));
                                        HoaDon.setMa_nv(resultSet.getString("ma_nv"));
                                        HoaDon.setMa_kh(resultSet.getString("ma_kh"));
                                        HoaDon.setTrangThai(resultSet.getString("TrangThai"));
                                        HoaDon.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
					result.add(HoaDon);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					//ngáº¯t káº¿t ná»‘i csdl
					con.close();
					preparedStatement.close();
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				  }
			}
			return result;
		}
}
