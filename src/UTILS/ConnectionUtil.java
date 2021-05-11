/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILS;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class ConnectionUtil {
    public static java.sql.Connection getConnection(){
        final String url = "jdbc:mysql://localhost:3306/qlbvmb";
        final String user = "root";
        final String password = "";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        }  
        
        return null;            
    }
    
    public static void main(String[] args) {
        java.sql.Connection connection = getConnection();
        
        if(connection != null) {
            System.out.println("Thanh cong");
        } else{
            System.out.println("That bai");
        }
    }
}
