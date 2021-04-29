package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.HangVeDTO;
import UTILS.ConnectionUtil;

public class HangVeDAL {
	//thực hiện kết nối csdl
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	//thực hiện các câu truy vấn
	private PreparedStatement preparedStatement;
	//chứa kết quả truy vấn
	private ResultSet resultSet;
	
	private Statement st;

	//func hiển thị table hang ve
	public ArrayList<HangVeDTO> getAllHangVe() throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng HangVeDTO để chứa kết quả truy vấn	
		ArrayList<HangVeDTO> result = new ArrayList<HangVeDTO>();
		String sqlSelectAll = "select * from hang_ve";
			
		try {
			//mở kết nối tới CSDL
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				HangVeDTO HangVeDTO = new HangVeDTO();
				HangVeDTO.setMa_hv(resultSet.getString("Ma_hv"));
				HangVeDTO.setTen_hv(resultSet.getString("TenHv"));
				result.add(HangVeDTO);
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
	//func tìm kiếm dữ liệu bằng ma_hv
	public ArrayList<HangVeDTO> getHangVeByMa_hv(HangVeDTO HangVeDTO) throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng HangVeDTO để chứa kết quả truy vấn	
		ArrayList<HangVeDTO> result = new ArrayList<HangVeDTO>();
		String sqlSelectByMa_hv = "select * from hang_ve where ma_hv = ?";
			
		try {
			//mở kết nối tới CSDL		
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlSelectByMa_hv);
			preparedStatement.setString(1, HangVeDTO.getMa_hv());
			resultSet  = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				HangVeDTO HangVe = new HangVeDTO();
				HangVe.setMa_hv(resultSet.getString("Ma_hv"));
				HangVe.setTen_hv(resultSet.getString("TenHv"));
				result.add(HangVe);
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
	//func thêm hang ve
	public int insertHangVe(HangVeDTO HangVeDTO) throws ClassNotFoundException {
		// Khởi tạo mảng đối tượng HangVeDTO để chứa kết quả truy vấn	
		int result = 0;
		String sqlInsert = "insert into hang_ve(ma_hv,tenHv) values(?,?)";
		
		try {
			//mở kết nối tới CSDL	
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			//thực thi câu truy vấn
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1, HangVeDTO.getMa_hv());
			preparedStatement.setString(2, HangVeDTO.getTen_hv());
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
	//func sửa HangVe
		public int updateHangVe(HangVeDTO HangVeDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng HangVeDTO để chứa kết quả truy vấn	
			int result = 0;
			String sqlUpdate = "update hang_ve set tenHv=? where ma_hv=?";
			
			try {
				//mở kết nối tới CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlUpdate);
				preparedStatement.setString(1, HangVeDTO.getTen_hv());
				preparedStatement.setString(2, HangVeDTO.getMa_hv());
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
		//func xóa hang vé
		public int deleteHangVe(HangVeDTO HangVeDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng HangVeDTO để chứa kết quả truy vấn	
			int result = 0;
			String sqlDelete = "delete from hang_ve where ma_hv = ?";
			
			try {
				//mở kết nối tới CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1, HangVeDTO.getMa_hv());
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
