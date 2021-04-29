package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


import DTO.TuyenBayDTO;
import UTILS.ConnectionUtil;

public class TuyenBayDAL {
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	
	private PreparedStatement preparedStatement;

	private ResultSet resultSet;
	
	private Statement st;

	public ArrayList<TuyenBayDTO> getAllTuyenBay() throws ClassNotFoundException {
			
		ArrayList<TuyenBayDTO> result = new ArrayList<TuyenBayDTO>();
		String sqlSelectAll = "select * from tuyen_bay";
			
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				TuyenBayDTO TuyenBayDTO = new TuyenBayDTO();
				TuyenBayDTO.setMa_tuyenbay(resultSet.getString("ma_tuyen_bay"));
				TuyenBayDTO.setSanbaydi(resultSet.getString("san_bay_di"));
				TuyenBayDTO.setSanbayden(resultSet.getString("san_bay_den"));
			
				
				
				result.add(TuyenBayDTO);
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

	public ArrayList<TuyenBayDTO> getTuyenBayByMa_tuyenbay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException {
			
		ArrayList<TuyenBayDTO> result = new ArrayList<TuyenBayDTO>();
		String sqlSelectByma_tuyenbay = "select * from tuyen_bay where ma_tuyen_bay = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByma_tuyenbay);
			preparedStatement.setString(1, TuyenBayDTO.getMa_tuyenbay());
			resultSet  = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				TuyenBayDTO TuyenBay = new TuyenBayDTO();
				TuyenBay.setMa_tuyenbay(resultSet.getString("ma_tuyen_bay"));
				TuyenBay.setSanbaydi(resultSet.getString("san_bay_di"));
				TuyenBay.setSanbayden(resultSet.getString("san_bay_den"));
				
				result.add(TuyenBay);
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
	
	public int insertTuyenBay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException {
		
		int result = 0;
		String sqlInsert = "insert into tuyen_bay(ma_tuyen_bay,san_bay_di,san_bay_den) values(?,?,?)";
		
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1,TuyenBayDTO.getMa_tuyenbay());
			preparedStatement.setString(2, TuyenBayDTO.getSanbaydi());
			preparedStatement.setString(3, TuyenBayDTO.getSanbayden());
			
		
			
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
	
		public int updateTuyenBay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException {
			
			int result = 0;
			String sqlUpdate = "update tuyen_bay set san_bay_di=?,san_bay_den=? where ma_tuyen_bay=?";
			
			try {
			
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlUpdate);
				preparedStatement.setString(1, TuyenBayDTO.getSanbaydi());
				preparedStatement.setString(2,TuyenBayDTO.getSanbayden());
				preparedStatement.setString(4, TuyenBayDTO.getMa_tuyenbay());
				
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
		
		public int deleteTuyenBay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException {
				
			int result = 0;
			String sqlDelete = "delete from tuyen_bay where ma_tuyen_bay = ?";
			
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1,TuyenBayDTO.getMa_tuyenbay());
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
		}public ArrayList<TuyenBayDTO> searchTuyenBayByMa_tuyenbay(TuyenBayDTO TuyenBayDTO) throws ClassNotFoundException {
			
		ArrayList<TuyenBayDTO> result = new ArrayList<TuyenBayDTO>();
		String sqlSelectByma_tuyenbay = "select * from tuyen_bay where san_bay_di=?,san_bay_den=?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByma_tuyenbay);
			preparedStatement.setString(1, TuyenBayDTO.getMa_tuyenbay());
			resultSet  = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				TuyenBayDTO TuyenBay = new TuyenBayDTO();
				TuyenBay.setSanbaydi(resultSet.getString("san_bay_di"));
				TuyenBay.setSanbayden(resultSet.getString("san_bay_den"));
				
				result.add(TuyenBay);
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
