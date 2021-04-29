package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DonGiaDTO;
import UTILS.ConnectionUtil;

public class DonGiaDAL {
	//thực hiện kết nối csdl
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	//thực hiện các câu truy vấn
	private PreparedStatement preparedStatement;
	//chứa kết quả truy vấn
	private ResultSet resultSet;
	
	private Statement st;

	//func hiển thị table dongia
	public ArrayList<DonGiaDTO> getAllDonGia() throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng DonGiaDTO để chứa kết quả truy vấn	
		ArrayList<DonGiaDTO> result = new ArrayList<DonGiaDTO>();
		String sqlSelectAll = "select * from don_gia";
			
		try {
			//mở kết nối tới CSDL
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				DonGiaDTO DonGiaDTO = new DonGiaDTO();
				DonGiaDTO.setMa_dongia(resultSet.getString("ma_don_gia"));
				DonGiaDTO.setVND(resultSet.getInt("VND"));
				DonGiaDTO.setUSD(resultSet.getInt("USD"));
				result.add(DonGiaDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//ngắt kết nối csdl
				con.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}
	//func tìm kiếm dữ liệu bằng ma_don_gia
	public ArrayList<DonGiaDTO> getDonGiaByma_don_gia(DonGiaDTO DonGiaDTO) throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng DonGiaDTO để chứa kết quả truy vấn	
		ArrayList<DonGiaDTO> result = new ArrayList<DonGiaDTO>();
		String sqlSelectByma_don_gia = "select * from don_gia where ma_don_gia = ?";
			
		try {
			//mở kết nối tới CSDL		
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlSelectByma_don_gia);
			preparedStatement.setString(1, DonGiaDTO.getMa_dongia());
			resultSet  = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				DonGiaDTO DonGia = new DonGiaDTO();
				DonGia.setMa_dongia(resultSet.getString("ma_don_gia"));
				DonGia.setVND(resultSet.getInt("VND"));
				DonGia.setUSD(resultSet.getInt("USD"));
				result.add(DonGia);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//ngắt kết nối csdl
				con.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}
	//func thêm khach hang
	public int insertDonGia(DonGiaDTO DonGiaDTO) throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng DonGiaDTO để chứa kết quả truy vấn	
		int result = 0;
		String sqlInsert = "insert into don_gia(ma_don_gia, VND, USD) values(?,?,?)";
		
		try {
			//mở kết nối tới CSDL	
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1, DonGiaDTO.getMa_dongia());
			preparedStatement.setInt(2, DonGiaDTO.getVND());
			preparedStatement.setInt(3, DonGiaDTO.getUSD());
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
	//func sửa DonGia
		public int updateDonGia(DonGiaDTO DonGiaDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng DonGiaDTO để chứa kết quả truy vấn	
			int result = 0;
			String sqlUpdate = "update don_gia set VND=?, USD=? where ma_don_gia=?";
			
			try {
				//mở kết nối tới CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlUpdate);
				preparedStatement.setInt(1, DonGiaDTO.getVND());
				preparedStatement.setInt(2, DonGiaDTO.getUSD());
				preparedStatement.setString(3, DonGiaDTO.getMa_dongia());
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
		//func xóa don gia
		public int deleteDonGia(DonGiaDTO DonGiaDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng DonGiaDTO để chứa kết quả truy vấn	
			int result = 0;
			String sqlDelete = "delete from don_gia where ma_don_gia = ?";
			
			try {
				//mở kết nối tới CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1, DonGiaDTO.getMa_dongia());
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
