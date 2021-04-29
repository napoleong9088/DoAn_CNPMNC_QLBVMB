package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


import DTO.PhieuDatChoDTO;
import UTILS.ConnectionUtil;

public class PhieuDatChoDAL {
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	
	private PreparedStatement preparedStatement;

	private ResultSet resultSet;
	
	private Statement st;

	public ArrayList<PhieuDatChoDTO> getAllPhieuDatCho() throws ClassNotFoundException {
			
		ArrayList<PhieuDatChoDTO> result = new ArrayList<PhieuDatChoDTO>();
		String sqlSelectAll = "select * from phieu_dat_cho";
			
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				PhieuDatChoDTO PhieuDatChoDTO = new PhieuDatChoDTO();
				PhieuDatChoDTO.setMa_phieu(resultSet.getString("ma_phieu"));
				PhieuDatChoDTO.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
				PhieuDatChoDTO.setNgaydat(resultSet.getDate("ngay_dat"));
				PhieuDatChoDTO.setSoghe(resultSet.getInt("so_ghe"));
				
				
				result.add(PhieuDatChoDTO);
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

	public ArrayList<PhieuDatChoDTO> getPhieuDatChoByMa_phieu(PhieuDatChoDTO PhieuDatChoDTO) throws ClassNotFoundException {
			
		ArrayList<PhieuDatChoDTO> result = new ArrayList<PhieuDatChoDTO>();
		String sqlSelectByma_phieu = "select * from phieu_dat_cho where ma_phieu = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByma_phieu);
			preparedStatement.setString(1, PhieuDatChoDTO.getMa_phieu());
			resultSet  = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				PhieuDatChoDTO PhieuDatCho = new PhieuDatChoDTO();
				PhieuDatCho.setMa_phieu(resultSet.getString("ma_phieu"));
				PhieuDatCho.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
				PhieuDatCho.setNgaydat(resultSet.getDate("ngay_dat"));
				PhieuDatCho.setSoghe(resultSet.getInt("so_ghe"));
				
				result.add(PhieuDatCho);
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
	
	public int insertPhieuDatCho(PhieuDatChoDTO PhieuDatChoDTO) throws ClassNotFoundException {
		
		int result = 0;
		String sqlInsert = "insert into phieu_dat_cho(ma_phieu,ma_ve_cb,ngay_dat,so_ghe) values(?,?,?,?)";
		
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1,PhieuDatChoDTO.getMa_phieu());
			preparedStatement.setString(2, PhieuDatChoDTO.getMa_ve_cb());
			preparedStatement.setDate(3, (java.sql.Date) PhieuDatChoDTO.getNgaydat());
			preparedStatement.setInt(4, PhieuDatChoDTO.getSoghe());
		
			
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
	
		public int updatePhieuDatCho(PhieuDatChoDTO PhieuDatChoDTO) throws ClassNotFoundException {
			
			int result = 0;
			String sqlUpdate = "update phieu_dat_cho set ma_ve_cb=?,ngay_dat=?,so_ghe=? where ma_phieu=?";
			
			try {
			
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlUpdate);
				preparedStatement.setString(1, PhieuDatChoDTO.getMa_ve_cb());
				preparedStatement.setDate(2,(java.sql.Date) PhieuDatChoDTO.getNgaydat());
				preparedStatement.setInt(3, PhieuDatChoDTO.getSoghe());
				preparedStatement.setString(4, PhieuDatChoDTO.getMa_phieu());
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
		
		public int deletePhieuDatCho(PhieuDatChoDTO PhieuDatChoDTO) throws ClassNotFoundException {
				
			int result = 0;
			String sqlDelete = "delete from phieu_dat_cho where ma_phieu = ?";
			
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1,PhieuDatChoDTO.getMa_phieu());
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
