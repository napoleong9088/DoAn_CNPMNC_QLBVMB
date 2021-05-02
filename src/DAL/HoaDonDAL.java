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
	//thực hiện kết nối csdl
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	//thực hiện các câu truy vấn
	private PreparedStatement preparedStatement;
	//chứa kết quả truy vấn
	private ResultSet resultSet;
	
	private Statement st;

	//func hiển thị table hoa_don
	public ArrayList<HoaDonDTO> getAllHoaDon() throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng HoaDonDTO để chứa kết quả truy vấn	
		ArrayList<HoaDonDTO> result = new ArrayList<HoaDonDTO>();
		String sqlSelectAll = "select * from hoa_don";
			
		try {
			//mở kết nối tới CSDL
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				HoaDonDTO HoaDonDTO = new HoaDonDTO();
				HoaDonDTO.setMa_hd(resultSet.getString("Ma_hd"));
				HoaDonDTO.setThanh_tien(resultSet.getInt("Thanh_tien"));
				HoaDonDTO.setNgay_Lap(resultSet.getDate("Ngay_Lap"));
				HoaDonDTO.setMa_nv(resultSet.getString("Ma_nv"));
				HoaDonDTO.setMa_kh(resultSet.getString("Ma_kh"));
				result.add(HoaDonDTO);
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
	//func tìm kiếm dữ liệu bằng ma_hd
	public ArrayList<HoaDonDTO> getHoaDonByMa_hd(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng HoaDonDTO để chứa kết quả truy vấn	
		ArrayList<HoaDonDTO> result = new ArrayList<HoaDonDTO>();
		String sqlSelectByMa_hd = "select * from hoa_don where ma_hd = ?";
			
		try {
			//mở kết nối tới CSDL		
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlSelectByMa_hd);
			preparedStatement.setString(1, HoaDonDTO.getMa_hd());
			resultSet  = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				HoaDonDTO HoaDon = new HoaDonDTO();
				HoaDon.setMa_hd(resultSet.getString("Ma_hd"));
				HoaDon.setThanh_tien(resultSet.getInt("Thanh_tien"));
				HoaDon.setNgay_Lap(resultSet.getDate("Ngay_Lap"));
				HoaDon.setMa_nv(resultSet.getString("Ma_nv"));
				HoaDon.setMa_kh(resultSet.getString("Ma_kh"));
				result.add(HoaDon);
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
	//func thêm hóa đơn
	public int insertHoaDon(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng HoaDonDTO để chứa kết quả truy vấn	
		int result = 0;
		String sqlInsert = "insert into hoa_don(ma_hd,thanh_tien, ngay_lap, ma_nv, ma_kh) values(?,?,?,?,?,?)";
		
		try {
			//mở kết nối tới CSDL	
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
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
	//func sửa HoaDon
		public int updateHoaDon(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng HoaDonDTO để chứa kết quả truy vấn	
			int result = 0;
			String sqlUpdate = "update hoa_don set thanh_tien=?, ngay_lap=?, ma_nv=?, ma_kh=? where ma_hd=?";
			
			try {
				//mở kết nối tới CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlUpdate);
				preparedStatement.setInt(1, HoaDonDTO.getThanh_tien());
				preparedStatement.setDate(2, (java.sql.Date) HoaDonDTO.getNgay_Lap());
				preparedStatement.setString(3, HoaDonDTO.getMa_nv());
				preparedStatement.setString(4, HoaDonDTO.getMa_kh());
				preparedStatement.setString(5, HoaDonDTO.getMa_hd());
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
		//func xóa hóa đơn
		public int deleteHoaDon(HoaDonDTO HoaDonDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng HoaDonDTO để chứa kết quả truy vấn	
			int result = 0;
			String sqlDelete = "delete from hoa_don where ma_hd = ?";
			
			try {
				//mở kết nối tới CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
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
			// Khởi tạo mảng đối tượng HoaDonDTO để chứa kết quả truy vấn	
			ArrayList<HoaDonDTO> result = new ArrayList<HoaDonDTO>();
			String sqlSelectByMa_kh = "select * from hoa_don where ma_kh = ?";
				
			try {
				//mở kết nối tới CSDL		
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlSelectByMa_kh);
				preparedStatement.setString(1, HoaDonDTO.getMa_kh());
				resultSet  = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					HoaDonDTO HoaDon = new HoaDonDTO();
					HoaDon.setMa_hd(resultSet.getString("Ma_hd"));
					HoaDon.setThanh_tien(resultSet.getInt("Thanh_tien"));
					HoaDon.setNgay_Lap(resultSet.getDate("Ngay_Lap"));
					HoaDon.setMa_nv(resultSet.getString("Ma_nv"));
					HoaDon.setMa_kh(resultSet.getString("Ma_kh"));
					result.add(HoaDon);
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
}
