package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import UTILS.ConnectionUtil;

public class KhachHangDAL {
	//thá»±c hiá»‡n káº¿t ná»‘i csdl
			private ConnectionUtil conUtil=null;
			private Connection con=null;
			//thá»±c hiá»‡n cÃ¡c cÃ¢u truy váº¥n
			private PreparedStatement preparedStatement;
			//chá»©a káº¿t quáº£ truy váº¥n
			private ResultSet resultSet;
			
			private Statement st;

			//func hiá»ƒn thá»‹ table nhanvien
			public ArrayList<KhachHangDTO> getAllKhachhang() throws ClassNotFoundException {
				// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng KhachHangDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
				ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
				String sqlSelectAll = "select * from khachhang";
					
				try {
					//má»Ÿ káº¿t ná»‘i tá»›i CSDL
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thá»±c thi cÃ¢u truy váº¥n
					preparedStatement = con.prepareStatement(sqlSelectAll);
					resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						KhachHangDTO KhachHangDTO = new KhachHangDTO();
						KhachHangDTO.setMa_kh(resultSet.getString("ma_kh"));
						KhachHangDTO.setTen_kh(resultSet.getString("ten_kh"));
						KhachHangDTO.setEmail(resultSet.getString("email"));
						KhachHangDTO.setCmnd(resultSet.getString("cmnd"));
						KhachHangDTO.setSDT(resultSet.getString("sdt"));
						KhachHangDTO.setDiaChi(resultSet.getString("diachi"));
                                                KhachHangDTO.setPassword(resultSet.getString("password"));
						result.add(KhachHangDTO);
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
			//func tÃ¬m kiáº¿m dá»¯ liá»‡u báº±ng ma_kh
			public ArrayList<KhachHangDTO> getKhachHangByMa_kh(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
				// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng KhachHangDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
				ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
				String sqlSelectByMa_kh = "select * from khachhang where ma_kh = ?";
					
				try {
					//má»Ÿ káº¿t ná»‘i tá»›i CSDL		
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thá»±c thi cÃ¢u truy váº¥n
					preparedStatement = con.prepareStatement(sqlSelectByMa_kh);
					preparedStatement.setString(1, KhachHangDTO.getMa_kh());
					resultSet  = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						KhachHangDTO KhachHang = new KhachHangDTO();
						KhachHang.setMa_kh(resultSet.getString("ma_kh"));
						KhachHang.setTen_kh(resultSet.getString("ten_kh"));
						KhachHang.setEmail(resultSet.getString("email"));
						KhachHang.setCmnd(resultSet.getString("cmnd"));
						KhachHang.setSDT(resultSet.getString("sdt"));
						KhachHang.setDiaChi(resultSet.getString("diachi"));
						result.add(KhachHang);
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
			//func thÃªm khach hang
			public int insertKhachHang(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
				// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng KhachHangDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
				int result = 0;
				String sqlInsert = "insert into khachhang(ma_kh,ten_kh,email,password,cmnd,sdt,diachi) values(?,?,?,?,?,?,?)";
				
				try {
					//má»Ÿ káº¿t ná»‘i tá»›i CSDL	
					conUtil = new ConnectionUtil();
					con = conUtil.getConnection();
					//thá»±c thi cÃ¢u truy váº¥n
					preparedStatement = con.prepareStatement(sqlInsert);
					preparedStatement.setString(1, KhachHangDTO.getMa_kh());
					preparedStatement.setString(2, KhachHangDTO.getTen_kh());
					preparedStatement.setString(3, KhachHangDTO.getEmail());
					preparedStatement.setString(4, KhachHangDTO.getPassword());
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
			//func sá»­a khachhang
				public int updateKhachHang(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
					// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng KhachHangDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
					int result = 0;
					String sqlUpdate = "update khachhang set ten_kh=? ,sdt=?,cmnd=?,diachi=? where ma_kh=?";
					
					try {
						//má»Ÿ káº¿t ná»‘i tá»›i CSDL	
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thá»±c thi cÃ¢u truy váº¥n
						preparedStatement = con.prepareStatement(sqlUpdate);
						preparedStatement.setString(1, KhachHangDTO.getTen_kh().toString());
						preparedStatement.setString(2, KhachHangDTO.getSDT().toString());
						preparedStatement.setString(3, KhachHangDTO.getCmnd().toString());
						preparedStatement.setString(4, KhachHangDTO.getDiaChi().toString());
						preparedStatement.setString(5, KhachHangDTO.getMa_kh().toString());
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
				//func xÃ³a khÃ¡ch hÃ ng
				public int deleteKhachHang(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
					// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng KhachHangDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
					int result = 0;
					String sqlDelete = "delete from khachhang where ma_kh = ?";
					
					try {
						//má»Ÿ káº¿t ná»‘i tá»›i CSDL	
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thá»±c thi cÃ¢u truy váº¥n
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
					// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng KhachHangDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
					ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
					String sql = "select * from khachhang where cmnd like ?";
						
					try {
						//má»Ÿ káº¿t ná»‘i tá»›i CSDL		
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thá»±c thi cÃ¢u truy váº¥n
						preparedStatement = con.prepareStatement(sql);
						preparedStatement.setString(1, KhachHangDTO.getCmnd()+"%");
						resultSet  = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							KhachHangDTO KhachHang = new KhachHangDTO();
							KhachHang.setMa_kh(resultSet.getString("ma_kh"));
							KhachHang.setTen_kh(resultSet.getString("ten_kh"));
							KhachHang.setEmail(resultSet.getString("email"));
							KhachHang.setCmnd(resultSet.getString("cmnd"));
							KhachHang.setSDT(resultSet.getString("sdt"));
							KhachHang.setDiaChi(resultSet.getString("diachi"));
							result.add(KhachHang);
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
				
				public ArrayList<KhachHangDTO> getKhachHangBySDT(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
					// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng KhachHangDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
					ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
					String sql = "select * from khachhang where sdt like ?";
						
					try {
						//má»Ÿ káº¿t ná»‘i tá»›i CSDL		
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thá»±c thi cÃ¢u truy váº¥n
						preparedStatement = con.prepareStatement(sql);
						preparedStatement.setString(1, KhachHangDTO.getSDT()+"%");
						resultSet  = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							KhachHangDTO KhachHang = new KhachHangDTO();
							KhachHang.setMa_kh(resultSet.getString("ma_kh"));
							KhachHang.setTen_kh(resultSet.getString("ten_kh"));
							KhachHang.setEmail(resultSet.getString("email"));
							KhachHang.setCmnd(resultSet.getString("cmnd"));
							KhachHang.setSDT(resultSet.getString("sdt"));
							KhachHang.setDiaChi(resultSet.getString("diachi"));
							result.add(KhachHang);
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
				public ArrayList<KhachHangDTO> getKhachHangEmail(KhachHangDTO KhachHangDTO) throws ClassNotFoundException {
					// Khá»Ÿi táº¡o máº£ng Ä‘á»‘i tÆ°á»£ng KhachHangDTO Ä‘á»ƒ chá»©a káº¿t quáº£ truy váº¥n	
					ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
					String sqlSelectByMa_kh = "select * from khachhang where email = ?";
						
					try {
						//má»Ÿ káº¿t ná»‘i tá»›i CSDL		
						conUtil = new ConnectionUtil();
						con = conUtil.getConnection();
						//thá»±c thi cÃ¢u truy váº¥n
						preparedStatement = con.prepareStatement(sqlSelectByMa_kh);
						preparedStatement.setString(1, KhachHangDTO.getEmail());
						resultSet  = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							KhachHangDTO KhachHang = new KhachHangDTO();
							KhachHang.setMa_kh(resultSet.getString("ma_kh"));
							KhachHang.setTen_kh(resultSet.getString("ten_kh"));
							KhachHang.setEmail(resultSet.getString("email"));
							KhachHang.setCmnd(resultSet.getString("CMND"));
							KhachHang.setSDT(resultSet.getString("sdt"));
							KhachHang.setDiaChi(resultSet.getString("diachi"));
							result.add(KhachHang);
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
                                
                                public ArrayList<KhachHangDTO> getKHByid(KhachHangDTO khachHangDTO) throws ClassNotFoundException {
		
		ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
		String sqlSelectByid = "select * from khachhang where email = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByid);
			preparedStatement.setString(1, khachHangDTO.getEmail());
			resultSet  = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				KhachHangDTO User = new KhachHangDTO();
                                khachHangDTO.setEmail(resultSet.getString("email"));
				khachHangDTO.setPassword(resultSet.getString("password"));
                                
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
