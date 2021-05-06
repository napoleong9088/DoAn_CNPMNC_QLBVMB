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
	//thá»±c hiá»‡n káº¿t ná»‘i csdl
		private ConnectionUtil conUtil=null;
		private Connection con=null;
		//thá»±c hiá»‡n cÃ¡c cÃ¢u truy váº¥n
		private PreparedStatement preparedStatement;
		//chá»©a káº¿t quáº£ truy váº¥n
		private ResultSet resultSet;
		
		private Statement st;

		//func hiá»ƒn thá»‹ table nhanvien
		public ArrayList<NhanVienDTO> getAllNhanVien() throws ClassNotFoundException {
			// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng NhanVienDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
			ArrayList<NhanVienDTO> result = new ArrayList<NhanVienDTO>();
			String sqlSelectAll = "select * from nhanvien";
				
			try {
				//má»Ÿ káº¿t ná»‘i tá»›i CSDL
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thá»±c thi cÃ¢u truy váº¥n
				preparedStatement = con.prepareStatement(sqlSelectAll);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					NhanVienDTO NhanVienDTO = new NhanVienDTO();
					NhanVienDTO.setMa_nv(resultSet.getString("ma_nv"));
					NhanVienDTO.setTen_nv(resultSet.getString("ten_nv"));
					NhanVienDTO.setEmail(resultSet.getString("email"));
					NhanVienDTO.setSDT(resultSet.getString("sdt"));
					NhanVienDTO.setDiaChi(resultSet.getString("diachi"));
                                        NhanVienDTO.setChucVu(resultSet.getString("chucvu"));
					result.add(NhanVienDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					//ngáº¯t káº¿t ná»‘i csdl
					con.close();
					preparedStatement.close();
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				  }
			}
			return result;
		}
		//func tÃ¬m kiáº¿m dá»¯ liá»‡u báº±ng MANV
		public ArrayList<NhanVienDTO> getNhanVienByMANV(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
			// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng NhanVienDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
			ArrayList<NhanVienDTO> result = new ArrayList<NhanVienDTO>();
			String sqlSelectByMANV = "select * from nhanvien where ma_nv = ?";
				
			try {
				//má»Ÿ káº¿t ná»‘i tá»›i CSDL		
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thá»±c thi cÃ¢u truy váº¥n
				preparedStatement = con.prepareStatement(sqlSelectByMANV);
				preparedStatement.setString(1, NhanVienDTO.getMa_nv());
				resultSet  = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					NhanVienDTO NhanVien = new NhanVienDTO();
					NhanVien.setMa_nv(resultSet.getString("ma_nv"));
					NhanVien.setTen_nv(resultSet.getString("ten_nv"));
					NhanVien.setEmail(resultSet.getString("email"));
					NhanVien.setSDT(resultSet.getString("sdt"));
					NhanVien.setDiaChi(resultSet.getString("diachi"));
                                        NhanVienDTO.setChucVu(resultSet.getString("chucvu"));
					result.add(NhanVien);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					//ngáº¯t káº¿t ná»‘i csdl
					con.close();
					preparedStatement.close();
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				  }
			}
			return result;
		}
		//func thÃªm nhÃ¢n viÃªn
		public int insertNhanVien(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
			// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng NhanVienDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
			int result = 0;
			String sqlInsert = "insert into nhanvien(ma_nv,ten_nv,email,password,sdt,diachi,chucvu) values(?,?,?,?,?,?,?)";
			
			try {
				//má»Ÿ káº¿t ná»‘i tá»›i CSDL	
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				//thá»±c thi cÃ¢u truy váº¥n
				preparedStatement = con.prepareStatement(sqlInsert);
				preparedStatement.setString(1, NhanVienDTO.getMa_nv());
				preparedStatement.setString(2, NhanVienDTO.getTen_nv());
				preparedStatement.setString(3, NhanVienDTO.getEmail());
				preparedStatement.setString(4, NhanVienDTO.getPassword());
				preparedStatement.setString(5, NhanVienDTO.getSDT());
				preparedStatement.setString(6, NhanVienDTO.getDiaChi());
                                preparedStatement.setString(7, NhanVienDTO.getChucVu());
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
		//func sá»­a nhÃ¢n viÃªn
			public int updateNhanVien(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
				// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng NhanVienDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
				int result = 0;
				String sqlUpdate = "update nhanvien set ten_nv=? ,sdt=?,diachi=? where ma_nv=?";
				
				try {
					//má»Ÿ káº¿t ná»‘i tá»›i CSDL	
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thá»±c thi cÃ¢u truy váº¥n
					preparedStatement = con.prepareStatement(sqlUpdate);
					preparedStatement.setString(1, NhanVienDTO.getTen_nv().toString());
					preparedStatement.setString(2, NhanVienDTO.getSDT().toString());
					preparedStatement.setString(3, NhanVienDTO.getDiaChi().toString());
                                        preparedStatement.setString(4, NhanVienDTO.getMa_nv().toString());
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
			//func xÃ³a nhÃ¢n viÃªn
			public int deleteNhanVien(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
				// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng NhanVienDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
				int result = 0;
				String sqlDelete = "delete from nhanvien where ma_nv = ?";
				
				try {
					//má»Ÿ káº¿t ná»‘i tá»›i CSDL	
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thá»±c thi cÃ¢u truy váº¥n
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
                        
                        public ArrayList<NhanVienDTO> getNVByid(NhanVienDTO NhanVienDTO) throws ClassNotFoundException {
		
		ArrayList<NhanVienDTO> result = new ArrayList<NhanVienDTO>();
		String sqlSelectByid = "select * from nhanvien where email = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByid);
			preparedStatement.setString(1, NhanVienDTO.getEmail());
			resultSet  = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				NhanVienDTO User = new NhanVienDTO();
                                NhanVienDTO.setEmail(resultSet.getString("email"));
				NhanVienDTO.setPassword(resultSet.getString("password"));
				NhanVienDTO.setChucVu(resultSet.getString("chucvu"));
                                NhanVienDTO.setTen_nv(resultSet.getString("ten_nv"));
				
				result.add(User);
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
