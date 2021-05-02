package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.KhachHangDTO;
import UTILS.ConnectionUtil;

public class KhachHangDAL {
	//thực hiện kết nối csdl
			private ConnectionUtil conUtil=null;
			private Connection con=null;
			//thực hiện các câu truy vấn
			private PreparedStatement preparedStatement;
			//chứa kết quả truy vấn
			private ResultSet resultSet;
			
			private Statement st;

			//func hiển thị table nhanvien
			public ArrayList<KhachHangDTO> getAllKhachhang() throws ClassNotFoundException {
				// Khởi tạo mảng đối tượng KhachHangDTO để chứa kết quả truy vấn	
				ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
				String sqlSelectAll = "select * from khach_hang";
					
				try {
					//mở kết nối tới CSDL
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thực thi câu truy vấn
					preparedStatement = con.prepareStatement(sqlSelectAll);
					resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						KhachHangDTO KhachHangDTO = new KhachHangDTO();
						KhachHangDTO.setMa_kh(resultSet.getString("ma_kh"));
						KhachHangDTO.setTen_kh(resultSet.getString("ten_kh"));
						KhachHangDTO.setEmail(resultSet.getString("email"));
						KhachHangDTO.setCmnd(resultSet.getString("CMND_PP"));
						KhachHangDTO.setSDT(resultSet.getString("sdt"));
						KhachHangDTO.setDiaChi(resultSet.getString("dia_chi"));
						result.add(KhachHangDTO);
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
			//func tìm kiếm dữ liệu bằng ma_kh
			public ArrayList<KhachHangDTO> getKhachHangByMa_kh(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
				// Khởi tạo mảng đối tượng KhachHangDTO để chứa kết quả truy vấn	
				ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
				String sqlSelectByMa_kh = "select * from khach_hang where ma_kh = ?";
					
				try {
					//mở kết nối tới CSDL		
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thực thi câu truy vấn
					preparedStatement = con.prepareStatement(sqlSelectByMa_kh);
					preparedStatement.setString(1, KhachHangDTO.getMa_kh());
					resultSet  = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						KhachHangDTO KhachHang = new KhachHangDTO();
						KhachHang.setMa_kh(resultSet.getString("ma_kh"));
						KhachHang.setTen_kh(resultSet.getString("ten_kh"));
						KhachHang.setEmail(resultSet.getString("email"));
						KhachHang.setCmnd(resultSet.getString("CMND_PP"));
						KhachHang.setSDT(resultSet.getString("sdt"));
						KhachHang.setDiaChi(resultSet.getString("dia_chi"));
						result.add(KhachHang);
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
			public int insertKhachHang(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
				// Khởi tạo mảng đối tượng KhachHangDTO để chứa kết quả truy vấn	
				int result = 0;
				String sqlInsert = "insert into khach_hang(ma_kh,ten_kh,email,password,cmnd_pp,sdt,dia_chi) values(?,?,?,?,?,?,?)";
				
				try {
					//mở kết nối tới CSDL	
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thực thi câu truy vấn
					preparedStatement = con.prepareStatement(sqlInsert);
					preparedStatement.setString(1, KhachHangDTO.getMa_kh());
					preparedStatement.setString(2, KhachHangDTO.getTen_kh());
					preparedStatement.setString(3, KhachHangDTO.getEmail());
					preparedStatement.setString(4, KhachHangDTO.getPassworld());
					preparedStatement.setString(5, KhachHangDTO.getCmnd());
					preparedStatement.setString(6, KhachHangDTO.getSDT());
					preparedStatement.setString(7, KhachHangDTO.getDiaChi());
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
			//func sửa khachhang
				public int updateKhachHang(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
					// Khởi tạo mảng đối tượng KhachHangDTO để chứa kết quả truy vấn	
					int result = 0;
					String sqlUpdate = "update khach_hang set ten_kh=? ,sdt=?,cmnd_pp=?,dia_chi=? where ma_kh=?";
					
					try {
						//mở kết nối tới CSDL	
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thực thi câu truy vấn
						preparedStatement = con.prepareStatement(sqlUpdate);
						preparedStatement.setString(1, KhachHangDTO.getTen_kh());
						preparedStatement.setString(2, KhachHangDTO.getSDT());
						preparedStatement.setString(3, KhachHangDTO.getCmnd());
						preparedStatement.setString(4, KhachHangDTO.getDiaChi());
						preparedStatement.setString(5, KhachHangDTO.getMa_kh());
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
				//func xóa khách hàng
				public int deleteKhachHang(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
					// Khởi tạo mảng đối tượng KhachHangDTO để chứa kết quả truy vấn	
					int result = 0;
					String sqlDelete = "delete from khach_hang where ma_kh = ?";
					
					try {
						//mở kết nối tới CSDL	
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thực thi câu truy vấn
						preparedStatement = con.prepareStatement(sqlDelete);
						preparedStatement.setString(1, KhachHangDTO.getMa_kh());
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
				public ArrayList<KhachHangDTO> getKhachHangByCMND_PP(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
					// Khởi tạo mảng đối tượng KhachHangDTO để chứa kết quả truy vấn	
					ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
					String sql = "select * from khach_hang where CMND_PP = ?";
						
					try {
						//mở kết nối tới CSDL		
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thực thi câu truy vấn
						preparedStatement = con.prepareStatement(sql);
						preparedStatement.setString(1, KhachHangDTO.getCmnd());
						resultSet  = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							KhachHangDTO KhachHang = new KhachHangDTO();
							KhachHang.setMa_kh(resultSet.getString("ma_kh"));
							KhachHang.setTen_kh(resultSet.getString("ten_kh"));
							KhachHang.setEmail(resultSet.getString("email"));
							KhachHang.setCmnd(resultSet.getString("CMND_PP"));
							KhachHang.setSDT(resultSet.getString("sdt"));
							KhachHang.setDiaChi(resultSet.getString("dia_chi"));
							result.add(KhachHang);
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
				
				public ArrayList<KhachHangDTO> getKhachHangBySDT(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
					// Khởi tạo mảng đối tượng KhachHangDTO để chứa kết quả truy vấn	
					ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
					String sql = "select * from khach_hang where SDT = ?";
						
					try {
						//mở kết nối tới CSDL		
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thực thi câu truy vấn
						preparedStatement = con.prepareStatement(sql);
						preparedStatement.setString(1, KhachHangDTO.getSDT());
						resultSet  = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							KhachHangDTO KhachHang = new KhachHangDTO();
							KhachHang.setMa_kh(resultSet.getString("ma_kh"));
							KhachHang.setTen_kh(resultSet.getString("ten_kh"));
							KhachHang.setEmail(resultSet.getString("email"));
							KhachHang.setCmnd(resultSet.getString("CMND_PP"));
							KhachHang.setSDT(resultSet.getString("sdt"));
							KhachHang.setDiaChi(resultSet.getString("dia_chi"));
							result.add(KhachHang);
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
				public ArrayList<KhachHangDTO> getKhachHangEmail(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
					// Khởi tạo mảng đối tượng KhachHangDTO để chứa kết quả truy vấn	
					ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
					String sqlSelectByMa_kh = "select * from khach_hang where email = ?";
						
					try {
						//mở kết nối tới CSDL		
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thực thi câu truy vấn
						preparedStatement = con.prepareStatement(sqlSelectByMa_kh);
						preparedStatement.setString(1, KhachHangDTO.getEmail());
						resultSet  = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							KhachHangDTO KhachHang = new KhachHangDTO();
							KhachHang.setMa_kh(resultSet.getString("ma_kh"));
							KhachHang.setTen_kh(resultSet.getString("ten_kh"));
							KhachHang.setEmail(resultSet.getString("email"));
							KhachHang.setCmnd(resultSet.getString("CMND_PP"));
							KhachHang.setSDT(resultSet.getString("sdt"));
							KhachHang.setDiaChi(resultSet.getString("dia_chi"));
							result.add(KhachHang);
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
