package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChuyenBayDTO;
import UTILS.ConnectionUtil;

public class ChuyenBayDAL {
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	
	private PreparedStatement preparedStatement;

	private ResultSet resultSet;
	
	private Statement st;

	public ArrayList<ChuyenBayDTO> getAllChuyenBay() throws ClassNotFoundException {
			
		ArrayList<ChuyenBayDTO> result = new ArrayList<ChuyenBayDTO>();
		String sqlSelectAll = "select * from chuyenbay";
			
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
				ChuyenBayDTO.setMaChuyenbay(resultSet.getString("ma_cb"));
				ChuyenBayDTO.setHangHK(resultSet.getString("hang_hk"));
                                ChuyenBayDTO.setKyHieuMB(resultSet.getString("kyhieu"));
                                ChuyenBayDTO.setTenMayBay(resultSet.getString("ten_mb"));
				ChuyenBayDTO.setNgayBay(resultSet.getDate("ngaybay"));
				ChuyenBayDTO.setGioBay(resultSet.getTime("giobay"));
				ChuyenBayDTO.setDiemDi(resultSet.getString("diemdi"));
				ChuyenBayDTO.setDiemDen(resultSet.getString("diemden"));
                                ChuyenBayDTO.setSanBayDi(resultSet.getString("sb_di"));
				ChuyenBayDTO.setSanBayDen(resultSet.getString("sb_den"));
				ChuyenBayDTO.setLoaiGhe(resultSet.getString("loaighe"));
                                ChuyenBayDTO.setGia(resultSet.getInt("gia"));
                                ChuyenBayDTO.setQuyDinh(resultSet.getString("quydinh"));
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
		String sqlSelectByma_cb = "select * from chuyenbay where ma_cb = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByma_cb);
			preparedStatement.setString(1, ChuyenBayDTO.getMaChuyenbay());
			resultSet  = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				ChuyenBayDTO ChuyenBay = new ChuyenBayDTO();
				ChuyenBay.setHangHK(resultSet.getString("hang_hk"));
                                ChuyenBay.setKyHieuMB(resultSet.getString("kyhieu"));
                                ChuyenBay.setTenMayBay(resultSet.getString("ten_mb"));
				ChuyenBay.setNgayBay(resultSet.getDate("ngaybay"));
				ChuyenBay.setGioBay(resultSet.getTime("giobay"));
				ChuyenBay.setDiemDi(resultSet.getString("diemdi"));
				ChuyenBay.setDiemDen(resultSet.getString("diemden"));
                                ChuyenBay.setSanBayDi(resultSet.getString("sb_di"));
				ChuyenBay.setSanBayDen(resultSet.getString("sb_den"));
				ChuyenBay.setLoaiGhe(resultSet.getString("loaighe"));
                                ChuyenBay.setGia(resultSet.getInt("gia"));
                                ChuyenBay.setQuyDinh(resultSet.getString("quydinh"));
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
		String sqlInsert = "insert into chuyenbay(ma_cb,hang_hk,kyhieu,ten_mb,ngaybay,giobay,diemdi,diemden,sb_di,sb_den,loaighe,gia,quydinh) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1, ChuyenBayDTO.getMaChuyenbay());
			preparedStatement.setString(2, ChuyenBayDTO.getHangHK());
			preparedStatement.setString(3, ChuyenBayDTO.getKyHieuMB());
			preparedStatement.setString(4, ChuyenBayDTO.getTenMayBay());
			preparedStatement.setDate(5, ChuyenBayDTO.getNgayBay());
			preparedStatement.setTime(6, ChuyenBayDTO.getGioBay());
			preparedStatement.setString(7, ChuyenBayDTO.getDiemDi());
                        preparedStatement.setString(8, ChuyenBayDTO.getDiemDen());
                        preparedStatement.setString(9, ChuyenBayDTO.getSanBayDi());
                        preparedStatement.setString(10, ChuyenBayDTO.getSanBayDen());
                        preparedStatement.setString(11, ChuyenBayDTO.getLoaiGhe());
                        preparedStatement.setInt(12, ChuyenBayDTO.getGia());
                        preparedStatement.setString(13, ChuyenBayDTO.getQuyDinh());
                        
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
	
		/*public int updateChuyenBay(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException {
			
			int result = 0;
			String sqlUpdate = "update chuyenbay set ma_tuyen_bay=?,ngay_gio=?,thoi_gian_bay=?,so_ghe_hang_1=?,so_ghe_hang_2=?,ma_mb=? where ma_cb=?";
			
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
		}*/
		
		public int deleteChuyenBay(ChuyenBayDTO ChuyenBayDTO) throws ClassNotFoundException {
				
			int result = 0;
			String sqlDelete = "delete from chuyenbay where ma_cb = ?";
			
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1, ChuyenBayDTO.getMaChuyenbay());
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
		public ArrayList<ChuyenBayDTO> getChuyenBayBydiem(String di, String den, String ngay) throws ClassNotFoundException {
			ArrayList<ChuyenBayDTO> result = new ArrayList<ChuyenBayDTO>();
			String sql = "select * from chuyenbay where diemdi = ? and diemden=? and ngaybay=?";
			
			try {
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1,di);
				preparedStatement.setString(2, den);
                                preparedStatement.setString(3, ngay);
				resultSet  = preparedStatement.executeQuery();
				while(resultSet.next()) {
					ChuyenBayDTO ChuyenBay = new ChuyenBayDTO();
                                        ChuyenBay.setMaChuyenbay(resultSet.getString("ma_cb"));
					ChuyenBay.setHangHK(resultSet.getString("hang_hk"));
                                        ChuyenBay.setKyHieuMB(resultSet.getString("kyhieu"));
                                        ChuyenBay.setTenMayBay(resultSet.getString("ten_mb"));
                                        ChuyenBay.setNgayBay(resultSet.getDate("ngaybay"));
                                        ChuyenBay.setGioBay(resultSet.getTime("giobay"));
                                        ChuyenBay.setDiemDi(resultSet.getString("diemdi"));
                                        ChuyenBay.setDiemDen(resultSet.getString("diemden"));
                                        ChuyenBay.setSanBayDi(resultSet.getString("sb_di"));
                                        ChuyenBay.setSanBayDen(resultSet.getString("sb_den"));
                                        ChuyenBay.setLoaiGhe(resultSet.getString("loaighe"));
                                        ChuyenBay.setGia(resultSet.getInt("gia"));
                                        ChuyenBay.setQuyDinh(resultSet.getString("quydinh"));
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
