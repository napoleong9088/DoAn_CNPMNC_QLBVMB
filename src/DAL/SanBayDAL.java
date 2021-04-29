package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DTO.PhieuDatChoDTO;
import DTO.SanBayDTO;
import UTILS.ConnectionUtil;



public class SanBayDAL {
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	
	private PreparedStatement preparedStatement;

	private ResultSet resultSet;
	
	private Statement st;

	public ArrayList<SanBayDTO> getAllSanBay() throws ClassNotFoundException {
			
		ArrayList<SanBayDTO> result = new ArrayList<SanBayDTO>();
		String sqlSelectAll = "select * from san_bay";
			
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				SanBayDTO SanBayDTO = new SanBayDTO();
				SanBayDTO.setMa_sb(resultSet.getString("ma_sb"));
				SanBayDTO.setTen_sb(resultSet.getString("ten_sb"));
				
				
				
				result.add(SanBayDTO);
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

	public ArrayList<SanBayDTO> getSanBayByMa_sb(SanBayDTO SanBayDTO) throws ClassNotFoundException {
			
		ArrayList<SanBayDTO>  result = new ArrayList<SanBayDTO>();
		String sqlSelectByma_sb = "select * from san_bay where ma_sb = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByma_sb);
			preparedStatement.setString(1, SanBayDTO.getMa_sb());
			resultSet  = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				SanBayDTO SanBay = new SanBayDTO();
				SanBay.setMa_sb(resultSet.getString("ma_sb"));
				SanBay.setTen_sb(resultSet.getString("ten_sb"));
				
				result.add(SanBay);
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
	
	public int insertSanBay(SanBayDTO SanBayDTO) throws ClassNotFoundException {
		
		int result = 0;
		String sqlInsert = "insert into san_bay(ma_sb,ten_sb) values(?,?)";
		
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1,SanBayDTO.getMa_sb());
			preparedStatement.setString(2, SanBayDTO.getTen_sb());
			
			
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
	
		public int updateSanBay(SanBayDTO SanBayDTO) throws ClassNotFoundException {
			
			int result = 0;
			String sqlUpdate = "update san_bay set ten_sb=? where ma_sb=?";
			
			try {
			
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlUpdate);
			    preparedStatement.setString(1,SanBayDTO.getTen_sb());
			    preparedStatement.setString(2,SanBayDTO.getMa_sb());
				
				
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
		
		public int deleteSanBay(SanBayDTO SanBayDTO) throws ClassNotFoundException {
				
			int result = 0;
			String sqlDelete = "delete from san_bay where ma_sb = ?";
			
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1, SanBayDTO.getMa_sb());
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

}
