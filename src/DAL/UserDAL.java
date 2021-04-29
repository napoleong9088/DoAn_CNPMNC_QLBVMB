package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.UserDTO;
import UTILS.ConnectionUtil;

public class UserDAL {
	private ConnectionUtil conUtil;
	private Connection con;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public ArrayList<UserDTO> getUserByid(UserDTO UserDTO) throws ClassNotFoundException {
		
		ArrayList<UserDTO> result = new ArrayList<UserDTO>();
		String sqlSelectByid = "select * from users where username = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByid);
			preparedStatement.setString(1, UserDTO.getUsername());
			resultSet  = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				UserDTO User = new UserDTO();
				UserDTO.setUsername(resultSet.getString("username"));
				UserDTO.setPassword(resultSet.getString("password"));
				UserDTO.setRole(resultSet.getInt("role"));
				
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

	public ResultSet GetUserByNameNPass(UserDTO userDTO) throws ClassNotFoundException {
		ResultSet result = null;
		String sql = "Select * from users where userName=? and password=?";
		
		try {
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userDTO.getUsername());
			preparedStatement.setString(2, userDTO.getPassword());
			
			result  = preparedStatement.executeQuery();
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
