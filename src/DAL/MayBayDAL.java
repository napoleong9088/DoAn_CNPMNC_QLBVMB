package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.MayBayDTO;
import UTILS.ConnectionUtil;

public class MayBayDAL {
	//thực hiện kết nối csdl
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	//thực hiện các câu truy vấn
	private PreparedStatement preparedStatement;
	//chứa kết quả truy vấn
	private ResultSet resultSet;
	
	private Statement st;

	//func hiển thị table MayBay
	public ArrayList<MayBayDTO> getAllMayBay() throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng MayBayDTO để chứa kết quả truy vấn	
		ArrayList<MayBayDTO> result = new ArrayList<MayBayDTO>();
		String sqlSelectAll = "select * from may_bay";
			
		try {
			//mở kết nối tới CSDL
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				MayBayDTO MayBayDTO = new MayBayDTO();
				MayBayDTO.setMa_mb(resultSet.getString("Ma_mb"));
				MayBayDTO.setTen_mb(resultSet.getString("Ten_mb"));
				result.add(MayBayDTO);
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
	//func tìm kiếm dữ liệu bằng ma_mb
	public ArrayList<MayBayDTO> getMayBayByMa_mb(MayBayDTO MayBayDTO) throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng MayBayDTO để chứa kết quả truy vấn	
		ArrayList<MayBayDTO> result = new ArrayList<MayBayDTO>();
		String sqlSelectByMa_mb = "select * from may_bay where ma_mb = ?";
			
		try {
			//mở kết nối tới CSDL		
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlSelectByMa_mb);
			preparedStatement.setString(1, MayBayDTO.getMa_mb());
			resultSet  = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				MayBayDTO MayBay = new MayBayDTO();
				MayBay.setMa_mb(resultSet.getString("Ma_mb"));
				MayBay.setTen_mb(resultSet.getString("Ten_mb"));
				result.add(MayBay);
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
	public int insertMayBay(MayBayDTO MayBayDTO) throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng MayBayDTO để chứa kết quả truy vấn	
		int result = 0;
		String sqlInsert = "insert into may_bay(ma_mb,ten_mb) values(?,?)";
		
		try {
			//mở kết nối tới CSDL	
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1, MayBayDTO.getMa_mb());
			preparedStatement.setString(2, MayBayDTO.getTen_mb());
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
	//func sửa MayBay
		public int updateMayBay(MayBayDTO MayBayDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng MayBayDTO để chứa kết quả truy vấn	
			int result = 0;
			String sqlUpdate = "update may_bay set ten_mb=? where ma_mb=?";
			
			try {
				//mở kết nối tới CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlUpdate);
				preparedStatement.setString(1, MayBayDTO.getTen_mb());
				preparedStatement.setString(2,  MayBayDTO.getMa_mb());
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
		//func xóa máy bay
		public int deleteMayBay(MayBayDTO MayBayDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng MayBayDTO để chứa kết quả truy vấn	
			int result = 0;
			String sqlDelete = "delete from may_bay where ma_mb = ?";
			
			try {
				//mở kết nối tới CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1, MayBayDTO.getMa_mb());
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
