package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NhanVienDTO;
import UTILS.ConnectionUtil;

public class NhanVienDAL {
	//thực hiện kết nối csdl
		private ConnectionUtil conUtil=null;
		private Connection con=null;
		//thực hiện các câu truy vấn
		private PreparedStatement preparedStatement;
		//chứa kết quả truy vấn
		private ResultSet resultSet;
		
		private Statement st;

		//func hiển thị table nhanvien
		public ArrayList<NhanVienDTO> getAllNhanVien() throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng NhanVienDTO để chứa kết quả truy vấn	
			ArrayList<NhanVienDTO> result = new ArrayList<NhanVienDTO>();
			String sqlSelectAll = "select * from nhan_vien";
				
			try {
				//mở kết nối tới CSDL
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlSelectAll);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					NhanVienDTO NhanVienDTO = new NhanVienDTO();
					NhanVienDTO.setMa_nv(resultSet.getString("Ma_NV"));
					NhanVienDTO.setTen_nv(resultSet.getString("Ten_NV"));
					NhanVienDTO.setEmail(resultSet.getString("Email"));
					NhanVienDTO.setSDT(resultSet.getString("SDT"));
					NhanVienDTO.setDiaChi(resultSet.getString("Dia_chi"));
					result.add(NhanVienDTO);
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
		//func tìm kiếm dữ liệu bằng MANV
		public ArrayList<NhanVienDTO> getNhanVienByMANV(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng NhanVienDTO để chứa kết quả truy vấn	
			ArrayList<NhanVienDTO> result = new ArrayList<NhanVienDTO>();
			String sqlSelectByMANV = "select * from nhan_vien where ma_nv = ?";
				
			try {
				//mở kết nối tới CSDL		
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlSelectByMANV);
				preparedStatement.setString(1, NhanVienDTO.getMa_nv());
				resultSet  = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					NhanVienDTO NhanVien = new NhanVienDTO();
					NhanVien.setMa_nv(resultSet.getString("Ma_NV"));
					NhanVien.setTen_nv(resultSet.getString("Ten_NV"));
					NhanVien.setEmail(resultSet.getString("Email"));
					NhanVien.setSDT(resultSet.getString("SDT"));
					NhanVien.setDiaChi(resultSet.getString("Dia_chi"));
					result.add(NhanVien);
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
		//func thêm nhân viên
		public int insertNhanVien(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
			// Khởi tạo mảng đối tượng NhanVienDTO để chứa kết quả truy vấn	
			int result = 0;
			String sqlInsert = "insert into nhan_vien(ma_nv,ten_nv,email,password,sdt,dia_chi) values(?,?,?,?,?,?)";
			
			try {
				//mở kết nối tới CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thực thi câu truy vấn
				preparedStatement = con.prepareStatement(sqlInsert);
				preparedStatement.setString(1, NhanVienDTO.getMa_nv());
				preparedStatement.setString(2, NhanVienDTO.getTen_nv());
				preparedStatement.setString(3, NhanVienDTO.getEmail());
				preparedStatement.setString(4, NhanVienDTO.getPassworld());
				preparedStatement.setString(5, NhanVienDTO.getSDT());
				preparedStatement.setString(6, NhanVienDTO.getDiaChi());
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
		//func sửa nhân viên
			public int updateNhanVien(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
				// Khởi tạo mảng đối tượng NhanVienDTO để chứa kết quả truy vấn	
				int result = 0;
				String sqlUpdate = "update nhan_vien set ten_nv=? ,sdt=?,dia_chi=? where ma_nv=?";
				
				try {
					//mở kết nối tới CSDL	
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thực thi câu truy vấn
					preparedStatement = con.prepareStatement(sqlUpdate);
					preparedStatement.setString(1, NhanVienDTO.getTen_nv());
					preparedStatement.setString(2, NhanVienDTO.getSDT());
					preparedStatement.setString(3, NhanVienDTO.getDiaChi());
					preparedStatement.setString(4, NhanVienDTO.getMa_nv());
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
			//func xóa nhân viên
			public int deleteNhanVien(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
				// Khởi tạo mảng đối tượng NhanVienDTO để chứa kết quả truy vấn	
				int result = 0;
				String sqlDelete = "delete from nhan_vien where ma_nv = ?";
				
				try {
					//mở kết nối tới CSDL	
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thực thi câu truy vấn
					preparedStatement = con.prepareStatement(sqlDelete);
					preparedStatement.setString(1, NhanVienDTO.getMa_nv());
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
