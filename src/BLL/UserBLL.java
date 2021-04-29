package BLL;

import java.sql.ResultSet;
import java.util.ArrayList;

import DAL.UserDAL;
import DTO.UserDTO;

public class UserBLL {
	UserDAL userDAL = new UserDAL();;

	public ResultSet Login(UserDTO userDTO) throws ClassNotFoundException {
		ResultSet result = null;
		
		if (userDTO.getUsername().equals("")) {
			return result;
		}
		else if (userDTO.getPassword().equals("")) {
			return result;
		}
		else {
			result = userDAL.GetUserByNameNPass(userDTO);
		}
		return result;
	}
	public ArrayList<UserDTO> getUserByid(UserDTO userDTO) throws ClassNotFoundException{
		 return userDAL.getUserByid(userDTO);
	}

}
