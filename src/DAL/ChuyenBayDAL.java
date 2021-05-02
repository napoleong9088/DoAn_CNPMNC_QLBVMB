package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChuyenBayDTO;
import DTO.TuyenBayDTO;
import UTILS.ConnectionUtil;

public class ChuyenBayDAL {
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	
	private PreparedStatement preparedStatement;

	private ResultSet resultSet;
	
	private Statement st;

	public ArrayList<ChuyenBayDTO> getAllChuyenBay() throws ClassNotFoundException {
			
		ArrayList<ChuyenBayDTO> result = new ArrayList<ChuyenBayDTO>();
		String sqlSelectAll = "select * from chuyen_bay";
			
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
				ChuyenBayDTO.setMa_cb(resultSet.getString("ma_cb"));
				ChuyenBayDTO.setMa_tuyenbay(resultSet.getString("ma_tuyen_bay"));
				ChuyenBayDTO.setNgaygio(resultSet.getDate("ngay_gio"));
				ChuyenBayDTO.setThoigianbay(resultSet.getString("thoi_gian_bay"));
				ChuyenBayDTO.setSoghehang1(resultSet.getInt("so_ghe_hang_1"));
				ChuyenBayDTO.setSoghehang2(resultSet.getInt("so_ghe_hang_2"));
				ChuyenBayDTO.setMa_mb(resultSet.getString("ma_mb"));
				result.add(ChuyenBayDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				con.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}

	public ArrayList<ChuyenBayDTO> getChuyenBayByma_cb(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException {
			
		ArrayList<ChuyenBayDTO> result = new ArrayList<ChuyenBayDTO>();
		String sqlSelectByma_cb = "select * from chuyen_bay where ma_cb = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByma_cb);
			preparedStatement.setString(1, ChuyenBayDTO.getMa_cb());
			resultSet  = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				ChuyenBayDTO ChuyenBay = new ChuyenBayDTO();
				ChuyenBay.setMa_cb(resultSet.getString("ma_cb"));
				ChuyenBay.setMa_tuyenbay(resultSet.getString("ma_tuyen_bay"));
				ChuyenBay.setNgaygio(resultSet.getDate("ngay_gio"));
				ChuyenBay.setThoigianbay(resultSet.getString("thoi_gian_bay"));
				ChuyenBay.setSoghehang1(resultSet.getInt("so_ghe_hang_1"));
				ChuyenBay.setSoghehang2(resultSet.getInt("so_ghe_hang_2"));
				ChuyenBay.setMa_mb(resultSet.getString("ma_mb"));
				result.add(ChuyenBay);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				con.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}
	
	public int insertChuyenBay(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException {
		
		int result = 0;
		String sqlInsert = "insert into chuyen_bay(ma_CB,ma_tuyenbay,ngaygio,thoigianbay,soghehang1,soghehang2,ma_MB) values(?,?,?,?,?,?,?)";
		
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1, ChuyenBayDTO.getMa_cb());
			preparedStatement.setString(2, ChuyenBayDTO.getMa_tuyenbay());
			preparedStatement.setDate(3, (java.sql.Date) ChuyenBayDTO.getNgaygio());
			preparedStatement.setString(4, ChuyenBayDTO.getThoigianbay());
			preparedStatement.setInt(5, ChuyenBayDTO.getSoghehang1());
			preparedStatement.setInt(6, ChuyenBayDTO.getSoghehang2());
			preparedStatement.setString(7, ChuyenBayDTO.getMa_mb());
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
	
		public int updateChuyenBay(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException {
			
			int result = 0;
			String sqlUpdate = "update chuyen_bay set ma_tuyen_bay=?,ngay_gio=?,thoi_gian_bay=?,so_ghe_hang_1=?,so_ghe_hang_2=?,ma_mb=? where ma_cb=?";
			
			try {
			
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlUpdate);
				preparedStatement.setString(1, ChuyenBayDTO.getMa_tuyenbay());
				preparedStatement.setString(2, ChuyenBayDTO.getMa_tuyenbay());
				preparedStatement.setDate(3, (java.sql.Date) ChuyenBayDTO.getNgaygio());
				preparedStatement.setInt(4, ChuyenBayDTO.getSoghehang1());
				preparedStatement.setInt(5, ChuyenBayDTO.getSoghehang2());
				preparedStatement.setString(6, ChuyenBayDTO.getMa_mb());
				preparedStatement.setString(7, ChuyenBayDTO.getMa_cb());
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
		
		public int deleteChuyenBay(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException {
				
			int result = 0;
			String sqlDelete = "delete from chuyen_bay where ma_cb = ?";
			
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1, ChuyenBayDTO.getMa_cb());
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
		public ArrayList<ChuyenBayDTO> getChuyenBayBydiem(TuyenBayDTO TuyenBayDto) throws ClassNotFoundException {
			ArrayList<ChuyenBayDTO> result = new ArrayList<ChuyenBayDTO>();
			String sql = "select * from chuyen_bay cb inner join tuyen_bay tb on cb.ma_tuyen_bay=tb.ma_tuyen_bay  where san_bay_di = ? and san_bay_den=? ";
			TuyenBayDTO TuyenBayDTO = new TuyenBayDTO(); 
			try {
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, TuyenBayDTO.getSanbaydi());
				preparedStatement.setString(2, TuyenBayDTO.getSanbayden());
				resultSet  = preparedStatement.executeQuery();
				while(resultSet.next()) {
					ChuyenBayDTO ChuyenBay = new ChuyenBayDTO();
					ChuyenBay.setMa_cb(resultSet.getString("ma_cb"));
					ChuyenBay.setMa_tuyenbay(resultSet.getString("ma_tuyen_bay"));
					ChuyenBay.setNgaygio(resultSet.getDate("ngay_gio"));
					ChuyenBay.setThoigianbay(resultSet.getString("thoi_gian_bay"));
					ChuyenBay.setSoghehang1(resultSet.getInt("so_ghe_hang_1"));
					ChuyenBay.setSoghehang2(resultSet.getInt("so_ghe_hang_2"));
					ChuyenBay.setMa_mb(resultSet.getString("ma_mb"));
					result.add(ChuyenBay);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
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
