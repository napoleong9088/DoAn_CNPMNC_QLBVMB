package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DTO.PhieuDatChoDTO;
import DTO.VeChuyenBayDTO;
import UTILS.ConnectionUtil;

public class VeChuyenBayDAL {
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	
	private PreparedStatement preparedStatement;

	private ResultSet resultSet;
	
	private Statement st;

	public ArrayList<VeChuyenBayDTO> getAllVeChuyenBay() throws ClassNotFoundException {
			
		ArrayList<VeChuyenBayDTO> result = new ArrayList<VeChuyenBayDTO>();
		String sqlSelectAll = "select * from ve_chuyen_bay";
			
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
				VeChuyenBayDTO.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
				VeChuyenBayDTO.setMa_cb(resultSet.getString("ma_cb"));
				VeChuyenBayDTO.setMa_hd(resultSet.getString("ma_hd"));
				VeChuyenBayDTO.setMa_dongia(resultSet.getString("ma_don_gia"));
				VeChuyenBayDTO.setMa_hv(resultSet.getString("ma_hv"));
				VeChuyenBayDTO.setTinhtrangve(resultSet.getString("tinh_trang_ve"));
				
				
				result.add(VeChuyenBayDTO);
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

	public ArrayList<VeChuyenBayDTO> getVeChuyenBayByMa_ve_cb(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
			
		ArrayList<VeChuyenBayDTO> result = new ArrayList<VeChuyenBayDTO>();
		String sqlSelectByma_ve_cb = "select * from ve_chuyen_bay where ma_ve_cb = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByma_ve_cb);
			preparedStatement.setString(1, VeChuyenBayDTO.getMa_ve_cb());
			resultSet  = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				VeChuyenBayDTO VeChuyenBay = new VeChuyenBayDTO();
				VeChuyenBay.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
				VeChuyenBay.setMa_hd(resultSet.getString("ma_hd"));
				VeChuyenBay.setMa_cb(resultSet.getString("ma_cb"));
				VeChuyenBay.setMa_dongia(resultSet.getString("ma_don_gia"));
				VeChuyenBay.setMa_hv(resultSet.getString("ma_hv"));
				VeChuyenBay.setTinhtrangve(resultSet.getString("tinh_trang_ve"));
				
				result.add(VeChuyenBay);
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
	
	public int insertVeChuyenBay(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
		
		int result = 0;
		String sqlInsert = "insert into ve_chuyen_bay(ma_ve_cb,ma_hd,ma_cb,ma_don_gia,ma_hv,tinh_trang_ve) values(?,?,?,?,?,?)";
		
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1,VeChuyenBayDTO.getMa_ve_cb());
			preparedStatement.setString(2, VeChuyenBayDTO.getMa_hd());
			preparedStatement.setString(3, VeChuyenBayDTO.getMa_cb());
            preparedStatement.setString(4, VeChuyenBayDTO.getMa_dongia());
			preparedStatement.setString(5, VeChuyenBayDTO.getMa_hv());
			preparedStatement.setString(6, VeChuyenBayDTO.getTinhtrangve());
		
			
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
	
		public int updateVeChuyenBay(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
			
			int result = 0;
			String sqlUpdate = "update ve_chuyen_bay set ma_hd=?,ma_cb=?,ma_don_gia=?,ma_hv=?,tinh_trang_ve=? where ma_ve_cb=? ";
			
			try {
			
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlUpdate);
				preparedStatement.setString(1, VeChuyenBayDTO.getMa_hd());
				preparedStatement.setString(2, VeChuyenBayDTO.getMa_cb());
				preparedStatement.setString(3, VeChuyenBayDTO.getMa_dongia());
				preparedStatement.setString(4, VeChuyenBayDTO.getMa_hv());
				preparedStatement.setString(5, VeChuyenBayDTO.getTinhtrangve());
				preparedStatement.setString(6, VeChuyenBayDTO.getMa_ve_cb());
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
		
		public int deleteVeChuyenBay(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
				
			int result = 0;
			String sqlDelete = "delete from ve_chuyen_bay where ma_ve_cb = ?";
			
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1,VeChuyenBayDTO.getMa_ve_cb());
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
		
		public ArrayList<VeChuyenBayDTO> getVeChuyenBayByMa_hd(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
			
			ArrayList<VeChuyenBayDTO> result = new ArrayList<VeChuyenBayDTO>();
			String sqlSelectByma_ve_cb = "select * from ve_chuyen_bay where ma_hd = ?";
				
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlSelectByma_ve_cb);
				preparedStatement.setString(1, VeChuyenBayDTO.getMa_hd());
				resultSet  = preparedStatement.executeQuery();			
				
				while(resultSet.next()) {
					VeChuyenBayDTO VeChuyenBay = new VeChuyenBayDTO();
					VeChuyenBay.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
					VeChuyenBay.setMa_hd(resultSet.getString("ma_hd"));
					VeChuyenBay.setMa_cb(resultSet.getString("ma_cb"));
					VeChuyenBay.setMa_dongia(resultSet.getString("ma_don_gia"));
					VeChuyenBay.setMa_hv(resultSet.getString("ma_hv"));
					VeChuyenBay.setTinhtrangve(resultSet.getString("tinh_trang_ve"));
					
					result.add(VeChuyenBay);
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
		public ArrayList<VeChuyenBayDTO> getVeChuyenBayByMa_cb(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
			
			ArrayList<VeChuyenBayDTO> result = new ArrayList<VeChuyenBayDTO>();
			String sqlSelectByma_ve_cb = "select * from ve_chuyen_bay where ma_cb = ?";
				
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlSelectByma_ve_cb);
				preparedStatement.setString(1, VeChuyenBayDTO.getMa_cb());
				resultSet  = preparedStatement.executeQuery();			
				
				while(resultSet.next()) {
					VeChuyenBayDTO VeChuyenBay = new VeChuyenBayDTO();
					VeChuyenBay.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
					VeChuyenBay.setMa_hd(resultSet.getString("ma_hd"));
					VeChuyenBay.setMa_cb(resultSet.getString("ma_cb"));
					VeChuyenBay.setMa_dongia(resultSet.getString("ma_don_gia"));
					VeChuyenBay.setMa_hv(resultSet.getString("ma_hv"));
					VeChuyenBay.setTinhtrangve(resultSet.getString("tinh_trang_ve"));
					
					result.add(VeChuyenBay);
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
