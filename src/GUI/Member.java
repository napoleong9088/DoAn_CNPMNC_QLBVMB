package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.KhachHangBLL;
import BLL.UserBLL;
import DTO.KhachHangDTO;
import DTO.UserDTO;
import UTILS.ConnectionUtil;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Member extends JFrame {

	private ConnectionUtil conUtil;
	private Connection con;
	private PreparedStatement preparedStatement;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				Member frame = new Member();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Member() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 226, 275);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FourAirlines");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblNewLabel.setBounds(45, 20, 133, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Đăng Nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setBackground(new Color(0, 139, 139));
		lblNewLabel_1.setBounds(10, 39, 76, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 66, 190, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Đăng Nhập\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.setBounds(10, 137, 190, 36);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try
				{
					UserBLL userBLL = new UserBLL();
					UserDTO userDTO = new UserDTO();

				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				@SuppressWarnings("deprecation")
				String query = "SELECT * FROM users WHERE username = '"+textField.getText()+"' and password = '"+passwordField.getText()+"'";
				
				preparedStatement = con.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery(query);
				boolean run = false;
				run = rs.next();
					if(run)
					{
						JOptionPane.showMessageDialog(null,"Đăng Nhập thành công","Pesan",JOptionPane.INFORMATION_MESSAGE);
						userDTO.setUsername(textField.getText());
						userBLL.getUserByid(userDTO);
						if (userDTO.getRole()==1) {
							Control control = new Control();
							control.setVisible(true);
						} else if (userDTO.getRole()==2) {
							Option option = new Option();
							option.setVisible(true);
						} else {
							Action action = new Action();
							action.setVisible(true);
							try {
							ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
							KhachHangBLL khbll = new KhachHangBLL();
							KhachHangDTO khDto =new KhachHangDTO();
							khDto.setEmail(userDTO.getUsername());
							kh = khbll.getKhachHangByEmail(khDto);
							khDto = kh.get(0);
							khDto.setTen_kh(khDto.getTen_kh());
							khDto.setCmnd(khDto.getCmnd());
							khDto.setSDT(khDto.getSDT());
							khDto.setDiaChi(khDto.getDiaChi());
							action.getkh(khDto);
							action.getlscb(khDto);
							} catch (Exception e1) {
								// TODO: handle exception
							}
							
							
						}

					}
					else
					{
						JOptionPane.showMessageDialog(null,"Đăng Nhập không thành công ","Pesan",JOptionPane.ERROR_MESSAGE);
						textField.setText(" ");
						passwordField.setText("");
						textField.requestFocus();
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
			}

		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 101, 190, 31);
		contentPane.add(passwordField);
		

	}

}
