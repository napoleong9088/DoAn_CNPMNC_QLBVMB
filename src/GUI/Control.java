package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.w3c.dom.Text;

import BLL.ChuyenBayBLL;

import BLL.HoaDonBLL;
import BLL.KhachHangBLL;
import BLL.NhanVienBLL;
import BLL.VeChuyenBayBLL;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.VeChuyenBayDTO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Window;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import javax.swing.JPasswordField;

public class Control extends JFrame {

	private JPanel contentPane;
	private JTable tblHoadon;
	private JTable tblKhachhang;
	private JTable tblnhanvien;
	private JTable tblchuyenbay;
	private JTable tblvechuyenbay;
	private JPanel panelkh;
	private JPanel panel1;
	private JPanel panelhd;
	private JPanel panelvcb;
	private JPanel panelcb;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control frame = new Control();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Control () throws ClassNotFoundException {
		Font ();
		header();
		loadAllNhanVien();
		loadAllChuyenBay();
		loadAllKhachHang();
		loadAllHoaDon();
		loadAllVeChuyenBay();
	}
	/**
	 * Create the frame.
	 */
	public void Font() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 561);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 79, 619, 146);
		
		
		
		contentPane.add(scrollPane);
		
// ve Chuyen bay {		
		panelvcb = new JPanel();
		panelvcb.setBounds(167, 269, 619, 245);

		panelvcb.setBackground(new Color(0,0,0,0));
		
		JTextField txtsoghe = new JTextField();
		txtsoghe.setColumns(10);
		txtsoghe.setBounds(116, 5, 96, 19);
		
		JTextField txtmacb = new JTextField();
		txtmacb.setBounds(318, 5, 96, 19);
		txtmacb.setColumns(10);
		
		JTextField txtkh = new JTextField();
		txtkh.setBounds(513, 5, 96, 19);
		txtkh.setColumns(10);
		
		JTextField txtngay = new JTextField();
		txtngay.setBounds(116, 57, 96, 19);
		
		JTextField txtgio = new JTextField();
		txtgio.setColumns(10);
		txtgio.setBounds(318, 57, 96, 19);
		
		JTextField txtgia = new JTextField();
		txtgia.setColumns(10);
		txtgia.setBounds(513, 57, 96, 19);
                
                JTextField txttinhtrangve = new JTextField();
		txttinhtrangve.setColumns(10);
		txttinhtrangve.setBounds(513, 113, 96, 19);
                
                JTextField txtmavecb = new JTextField();
                
                JLabel lblsoghe = new JLabel("SO GHE");
		lblsoghe.setBounds(10, 8, 102, 13);
                
                JLabel lblmacb = new JLabel("MA CB");
		lblmacb.setBounds(222, 9, 86, 13);
                
                JLabel lblkh = new JLabel("KH");
		lblkh.setBounds(435, 9, 68, 13);
                
                JLabel lblngay = new JLabel("NGAY");
		lblngay.setBounds(10, 61, 68, 13);
		
		JLabel lblgio = new JLabel("GIO");
		lblgio.setBounds(222, 61, 68, 13);
                
                JLabel lblgia = new JLabel("GIA");
		lblgia.setBounds(435, 61, 76, 13);
                
                JLabel lbltinhtrangve = new JLabel("TINH TRANG VE");
		lbltinhtrangve.setBounds(400, 113, 150, 13);
		
		panelvcb.setLayout(null);
		panelvcb.add(txtsoghe);
		panelvcb.add(txtmacb);
		panelvcb.add(txtkh);
		panelvcb.add(txtngay);
		panelvcb.add(txtgio);
                panelvcb.add(txtgia);
		panelvcb.add(txttinhtrangve);
		panelvcb.add(lbltinhtrangve);
		panelvcb.add(lblkh);
		panelvcb.add(lblngay);
		panelvcb.add(lblsoghe);
		panelvcb.add(lblmacb);
		panelvcb.add(lblgia);
                panelvcb.add(lblgio);
		panelvcb.setVisible(false);
		
		JButton btnDvcb = new JButton("Delete");
		btnDvcb.setBounds(345, 163, 111, 57);
		btnDvcb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDvcb.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 VeChuyenBayDTO vcb = new VeChuyenBayDTO();
				 vcb.setMa_ve_cb(txtmavecb.getText());
				 VeChuyenBayBLL vcbbll = new VeChuyenBayBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "BAN CHAC CHAN MUON XOA!", "XAC NHAN",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 @SuppressWarnings("unused")
					 int result = vcbbll.deleteVeChuyenBay(vcb);
					 loadAllVeChuyenBay();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 	}
				 }
			}
		});
		panelvcb.add(btnDvcb);
		
		
		/*JButton btnEvcb = new JButton("Edit");
		btnEvcb.setBounds(482, 163, 111, 57);
		btnEvcb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEvcb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VeChuyenBayDTO vcb = new VeChuyenBayDTO();
				 vcb.setMa_ve_cb(txtmavecb.getText());
				 vcb.setMa_cb(txtmacb.getText());
				 vcb.setMa_dongia(txtmadongia.getText());
				 vcb.setMa_hd(txtmahdcb.getText());
				 vcb.setMa_hv(txtmahvcb.getText());
				 vcb.setTinhtrangve(txttinhtrangve.getText());
				 VeChuyenBayBLL vcbbll = new VeChuyenBayBLL();
				try {
					int result = vcbbll.updateVeChuyenBay(vcb);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"cÃ¡ÂºÂ­p nhÃ¡ÂºÂ­t thÃƒÂ nh cÃƒÂ´ng!","thÃƒÂ´ng bÃƒÂ¡o",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllVeChuyenBay();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		panelvcb.add(btnEvcb);*/
		
		contentPane.add(panelvcb);
		
		tblvechuyenbay = new JTable();
		tblvechuyenbay.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblvechuyenbay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblvechuyenbay.addMouseListener(new MouseAdapter() {
			 // LÃ¡ÂºÂ¥y thÃƒÂ´ng tin dÃƒÂ²ng dÃ¡Â»Â¯ liÃ¡Â»â€¡u Ã„â€˜Ã†Â°Ã¡Â»Â£c chÃ¡Â»ï¿½n hiÃ¡Â»Æ’n thÃ¡Â»â€¹ lÃƒÂªn component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tblvechuyenbay.getSelectedRow();
			 if (row != -1) {
                         txtmavecb.setText(tblvechuyenbay.getValueAt(row, 0).toString());
			 txtsoghe.setText(tblvechuyenbay.getValueAt(row, 1).toString());
			 txtmacb.setText(tblvechuyenbay.getValueAt(row, 2).toString());				
			 txtkh.setText(tblvechuyenbay.getValueAt(row, 3).toString());
			 txtngay.setText(tblvechuyenbay.getValueAt(row, 4).toString());
                         txtgio.setText(tblvechuyenbay.getValueAt(row, 5).toString());
                         txtgia.setText(tblvechuyenbay.getValueAt(row, 6).toString());
			 txttinhtrangve.setText(tblvechuyenbay.getValueAt(row, 7).toString());
			 }
			 }
			 });
		
		JButton btnVechuyenbay = new JButton("VE CHUYEN BAY");
		btnVechuyenbay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVechuyenbay.setBackground(Color.white);
		btnVechuyenbay.setForeground(new Color(86, 172, 191));
		btnVechuyenbay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblvechuyenbay);
				panel1.setVisible(false);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelvcb.setVisible(true);
				panelcb.setVisible(false);
			}
		});
		btnVechuyenbay.setBounds(10, 309, 160, 23);
		contentPane.add(btnVechuyenbay);
//}
//HoaDon {	
		panelhd = new JPanel();
		panelhd.setBounds(167, 269, 619, 245);
		panelhd.setBackground(new Color(0,0,0,0));
		
		JTextField txttenhd = new JTextField();
		txttenhd.setColumns(10);
		txttenhd.setBounds(116, 5, 96, 19);
		
		JTextField txtnvhd = new JTextField();
		txtnvhd.setBounds(318, 5, 96, 19);
		txtnvhd.setColumns(10);
		
		JTextField txtkhhd = new JTextField();
		txtkhhd.setBounds(513, 5, 96, 19);
		txtkhhd.setColumns(10);
		
		JTextField txtngaylap = new JTextField();
		txtngaylap.setBounds(513, 113, 96, 19);
		
		JTextField txtmave = new JTextField();
		txtmave.setColumns(10);
		txtmave.setBounds(318, 57, 96, 19);
		
		JTextField txtthanhtien = new JTextField();
		txtthanhtien.setColumns(10);
		txtthanhtien.setBounds(513, 57, 96, 19);
                
                JTextField txttinhtranghd = new JTextField();
		txttinhtranghd.setColumns(10);
		txttinhtranghd.setBounds(116, 57, 96, 19);
                
                JTextField txtmahd = new JTextField();
                
                JLabel lbltenhd = new JLabel("GOI TT");
		lbltenhd.setBounds(10, 8, 102, 13);
                
                JLabel lblnvhd = new JLabel("NV");
		lblnvhd.setBounds(222, 9, 86, 13);
                
                JLabel lblkhhd = new JLabel("KH");
		lblkhhd.setBounds(435, 9, 68, 13);
                
                JLabel lblngaylap = new JLabel("NGAY LAP");
		lblngaylap.setBounds(10, 61, 68, 13);
		
		JLabel lblmave = new JLabel("MA VE");
		lblmave.setBounds(222, 61, 68, 13);
                
                JLabel lblthanhtien = new JLabel("THANH TIEN");
		lblthanhtien.setBounds(435, 61, 76, 13);
                
                JLabel lbltinhtranghd = new JLabel("TRANG THAI");
		lbltinhtranghd.setBounds(400, 113, 150, 13);
                
		panelhd.setLayout(null);
		panelhd.add(txttenhd);
		panelhd.add(txtthanhtien);
		panelhd.add(txtngaylap);
		panelhd.add(txtkhhd);
		panelhd.add(txtnvhd);
                panelhd.add(txtmave);
                panelhd.add(txttinhtranghd);
		panelhd.add(lbltenhd);
		panelhd.add(lblthanhtien);
		panelhd.add(lblngaylap);
		panelhd.add(lblkhhd);
		panelhd.add(lblnvhd);
                panelhd.add(lbltinhtranghd);
                panelhd.add(lblmave);
		panelhd.setVisible(false);
		
		/*JButton btnEhd = new JButton("Edit");
		btnEhd.setBounds(482, 163, 111, 57);
		btnEhd.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEhd.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			HoaDonDTO hd = new HoaDonDTO();
			hd.setMa_hd(txtmahd.getText());
			hd.setThanh_tien(Integer.parseInt(txtthanhtien.getText()));
			hd.setNgay_Lap(java.sql.Date.valueOf(txtngaylap.getText()));
			hd.setMa_kh(txtkhachhangID.getText());
			hd.setMa_nv(txtnhanvienID.getText());
			HoaDonBLL hdbll = new HoaDonBLL();
			try {
				int result = hdbll.updateHoaDon(hd);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cÃ¡ÂºÂ­p nhÃ¡ÂºÂ­t thÃƒÂ nh cÃƒÂ´ng!","thÃƒÂ´ng bÃƒÂ¡o",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllHoaDon();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});*/
		JButton btnDhd = new JButton("Delete");
		btnDhd.setBounds(345, 163, 111, 57);
		btnDhd.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDhd.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 HoaDonDTO hd = new HoaDonDTO();
				hd.setMa_hd(txtmahd.getText());
				HoaDonBLL hdbll = new HoaDonBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "BAN CHAC CHAN MUON XOA!", "XAC NHAN",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
			 try {
				 @SuppressWarnings("unused")
				 int result = hdbll.deleteHoaDon(hd);
				 loadAllHoaDon();
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 	}
			 }
		}
		});
		/*panelhd.add(btnEhd);*/
		panelhd.add(btnDhd);
		
		contentPane.add(panelhd);
		
		 tblHoadon = new JTable();
		//
		 tblHoadon.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 tblHoadon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 tblHoadon.addMouseListener(new MouseAdapter() {
			 // LÃ¡ÂºÂ¥y thÃƒÂ´ng tin dÃƒÂ²ng dÃ¡Â»Â¯ liÃ¡Â»â€¡u Ã„â€˜Ã†Â°Ã¡Â»Â£c chÃ¡Â»ï¿½n hiÃ¡Â»Æ’n thÃ¡Â»â€¹ lÃƒÂªn component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tblHoadon.getSelectedRow();
			 if (row != -1) {
			 txttenhd.setText(tblHoadon.getValueAt(row, 0).toString());
			 txtnvhd.setText(tblHoadon.getValueAt(row, 1).toString());
			 txtkhhd.setText(tblHoadon.getValueAt(row, 2).toString());				
			 txtmave.setText(tblHoadon.getValueAt(row, 3).toString());
			 txtthanhtien.setText(tblHoadon.getValueAt(row, 4).toString());
                         txttinhtranghd.setText(tblHoadon.getValueAt(row, 5).toString());
                         txtngaylap.setText(tblHoadon.getValueAt(row, 6).toString());
			 }
			 }
			 });
		 
		JButton btnHoadon = new JButton("HOA DON");
		btnHoadon.setForeground(new Color(255, 255, 255));
		btnHoadon.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnHoadon.setBackground(new Color(86, 172, 191));
		btnHoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblHoadon);
				panel1.setVisible(false);
				panelkh.setVisible(false);
				panelhd.setVisible(true);
				panelvcb.setVisible(false);
				panelcb.setVisible(false);
			}
		});
		btnHoadon.setBounds(10, 113, 128, 23);
		contentPane.add(btnHoadon);
//}
//Khach Hang {
		panelkh = new JPanel();
		panelkh.setBounds(167, 269, 619, 245);
		panelkh.setBackground(new Color(0,0,0,0));
		
                JTextField txtkhachhangname = new JTextField();
		txtkhachhangname.setColumns(10);
		txtkhachhangname.setBounds(50, 5, 96, 19);
		
		JTextField txtsdtkh = new JTextField();
		txtsdtkh.setBounds(220, 5, 96, 19);
		txtsdtkh.setColumns(10);
                
		JTextField txtxacdinh=new JTextField();
		txtxacdinh.setBounds(455, 5, 96, 19);
		txtxacdinh.setColumns(10);
		
                JTextField txtkhachhangemail = new JTextField();
		txtkhachhangemail.setColumns(10);
		txtkhachhangemail.setBounds(50, 56, 96, 19);
                
                JPasswordField  txtpwkh = new JPasswordField();
		txtpwkh.setBounds(220, 57, 96, 19);
		txtpwkh.setColumns(10);
                
                JTextField  txtdiachikh = new JTextField();
		txtdiachikh.setBounds(400, 56, 200, 20);
		txtdiachikh.setColumns(10);
                
                JTextField txtmakh = new JTextField();
                
                JLabel lbltenkh = new JLabel("TEN");
		lbltenkh.setBounds(9, 8, 49, 13);
                
                
                JLabel lblsdtkh = new JLabel("SDT");
		lblsdtkh.setBounds(185, 8, 49, 13);
                
                JLabel lblxacdinh = new JLabel("CMND/PASSPORT");
		lblxacdinh.setBounds(320, 8, 135, 13);
                

                JLabel lblemailkh = new JLabel("Email");
		lblemailkh.setBounds(9, 60, 50, 13);
                
                JLabel lblpwkh = new JLabel("PASSWORD");
		lblpwkh.setBounds(147, 60, 74, 13);
               
                JLabel lbldiachikh = new JLabel("DIA CHI");
		lbldiachikh.setBounds(320, 60, 105, 13);
		
		 	panelkh.setLayout(null);	
			panelkh.add(lbltenkh);
			panelkh.add(lbldiachikh);
			panelkh.add(lblemailkh);
			panelkh.add(lblpwkh);
			panelkh.add(lblsdtkh);
			panelkh.add(lblxacdinh);
			panelkh.add(txtdiachikh);
			panelkh.add(txtpwkh);
			panelkh.add(txtsdtkh);
			panelkh.add(txtkhachhangname);
			panelkh.add(txtkhachhangemail);
			panelkh.add(txtxacdinh);
			panelkh.setVisible(false);
			
			JButton btnIkh = new JButton("Insert");
			btnIkh.setBounds(212, 163, 100, 57);
			btnIkh.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnIkh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KhachHangDTO kh = new KhachHangDTO();
				kh.setTen_kh(txtkhachhangname.getText());
				kh.setEmail(txtkhachhangemail.getText());
                                kh.setPassword(txtpwkh.getText());
				kh.setSDT(txtsdtkh.getText());
				kh.setCmnd(txtxacdinh.getText());
				kh.setDiaChi(txtdiachikh.getText());
				KhachHangBLL khbll = new KhachHangBLL();
				try {
					int result = khbll.insertKhachHang(kh);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"THEM THANH CONG!","THONG BAO",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllKhachHang();
				} catch (Exception ex) {
					ex.printStackTrace();
				  }
			}
			});
			JButton btnEkh = new JButton("Edit");
			btnEkh.setBounds(482, 163, 111, 57);
			btnEkh.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnEkh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KhachHangDTO kh = new KhachHangDTO();
				kh.setMa_kh(txtmakh.getText());
				kh.setTen_kh(txtkhachhangname.getText());
				kh.setEmail(txtkhachhangemail.getText());
				kh.setSDT(txtsdtkh.getText());
				kh.setCmnd(txtxacdinh.getText());
				kh.setDiaChi(txtdiachikh.getText());
				KhachHangBLL khbll = new KhachHangBLL();
				try {
					int result = khbll.updateKhachHang(kh);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"CAP NHAT THANH CONG!","THONG BAO",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllKhachHang();
				} catch (Exception ex) {
					ex.printStackTrace();
				  }
			}
			});
			JButton btnDkh = new JButton("Delete");
			btnDkh.setBounds(345, 163, 111, 57);
			btnDkh.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnDkh.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 KhachHangDTO kh = new KhachHangDTO();
					kh.setMa_kh(txtmakh.getText());
					KhachHangBLL khbll = new KhachHangBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "BAN CHAC CHAN MUON XOA!", "XAC NHAN",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 @SuppressWarnings("unused")
					 int result = khbll.deleteKhachHang(kh);
					 loadAllKhachHang();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 	}
				 }
			}
			});
			panelkh.add(btnIkh);
			panelkh.add(btnEkh);
			panelkh.add(btnDkh);
			
			contentPane.add(panelkh);
			
		tblKhachhang = new JTable();
		//
		tblKhachhang.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblKhachhang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblKhachhang.addMouseListener(new MouseAdapter() {
		 // LÃ¡ÂºÂ¥y thÃƒÂ´ng tin dÃƒÂ²ng dÃ¡Â»Â¯ liÃ¡Â»â€¡u Ã„â€˜Ã†Â°Ã¡Â»Â£c chÃ¡Â»ï¿½n hiÃ¡Â»Æ’n thÃ¡Â»â€¹ lÃƒÂªn component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblKhachhang.getSelectedRow();
		 if (row != -1) {
                 txtmakh.setText(tblKhachhang.getValueAt(row, 0).toString());
		 txtkhachhangname.setText(tblKhachhang.getValueAt(row, 1).toString());
		 txtxacdinh.setText(tblKhachhang.getValueAt(row, 2).toString());
		 txtkhachhangemail.setText(tblKhachhang.getValueAt(row, 3).toString());
		 txtsdtkh.setText(tblKhachhang.getValueAt(row, 4).toString());
		 txtdiachikh.setText(tblKhachhang.getValueAt(row, 5).toString());
                 txtpwkh.setEditable(false);
		 }
		 }
		 });
		JButton btnKhachhang = new JButton("KHACH HANG");
		btnKhachhang.setForeground(new Color(255, 255, 255));
		btnKhachhang.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnKhachhang.setBackground(new Color(86, 172, 191));
		btnKhachhang.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblKhachhang);
				panel1.setVisible(false);
				panelhd.setVisible(false);
				panelkh.setVisible(true);
				panelvcb.setVisible(false);
				panelcb.setVisible(false);
				
			}
		});
		btnKhachhang.setBounds(10, 164, 128, 23);
		
		contentPane.add(btnKhachhang);
//}
// NhanVien {
	//jtextfield
		panel1 = new JPanel();
		panel1.setBounds(167, 269, 619, 245);
		panel1.setBackground(new Color(0, 0,0,0));
                
		JTextField txtnvname = new JTextField();
		txtnvname.setColumns(10);
		txtnvname.setBounds(50, 5, 96, 19);
		
		JTextField txtsdtnv = new JTextField();
		txtsdtnv.setBounds(220, 5, 96, 19);
		txtsdtnv.setColumns(10);
                
		JTextField txtchucvu=new JTextField("emp");
		txtchucvu.setBounds(455, 5, 96, 19);
		txtchucvu.setColumns(10);
                txtchucvu.setEditable(false);
		
                JTextField txtnvemail = new JTextField();
		txtnvemail.setColumns(10);
		txtnvemail.setBounds(50, 56, 96, 19);
                
                JPasswordField  txtpwnv = new JPasswordField();
		txtpwnv.setBounds(220, 57, 96, 19);
		txtpwnv.setColumns(10);
                
                JTextField  txtdiachinv = new JTextField();
		txtdiachinv.setBounds(400, 56, 200, 20);
		txtdiachinv.setColumns(10);
                
                JTextField txtmanv = new JTextField();
                
                JLabel lbltennv = new JLabel("TEN");
		lbltennv.setBounds(9, 8, 49, 13);
                
                
                JLabel lblsdtnv = new JLabel("SDT");
		lblsdtnv.setBounds(185, 8, 49, 13);
                
                JLabel lblchucvu = new JLabel("CHUC VU");
		lblchucvu.setBounds(320, 8, 135, 13);
                

                JLabel lblemailnv = new JLabel("Email");
		lblemailnv.setBounds(9, 60, 50, 13);
                
                JLabel lblpwnv = new JLabel("PASSWORD");
		lblpwnv.setBounds(147, 60, 74, 13);
               
                JLabel lbldiachinv = new JLabel("DIA CHI");
		lbldiachinv.setBounds(320, 60, 105, 13);
		panel1.setLayout(null);
		
	//Jpannel nhavien
		
		panel1.add(lbltennv);
		panel1.add(lbldiachinv);
		panel1.add(lblemailnv);
		panel1.add(lblchucvu);
		panel1.add(lblsdtnv);
                panel1.add(lblpwnv);
		panel1.add(txtnvname);
		panel1.add(txtdiachinv);
		panel1.add(txtnvemail);
		panel1.add(txtchucvu);
		panel1.add(txtsdtnv);
                panel1.add(txtpwnv);
		panel1.setVisible(false);
		
		JButton btnInv = new JButton("Insert");
		btnInv.setBounds(212, 163, 100, 57);
		btnInv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnInv.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			NhanVienDTO nv = new NhanVienDTO();
			
			nv.setTen_nv(txtnvname.getText());
			nv.setDiaChi(txtdiachinv.getText());
			nv.setSDT(txtsdtnv.getText());
			nv.setEmail(txtnvemail.getText());
                        nv.setPassword(txtpwnv.getText());
                        nv.setChucVu(txtchucvu.getText());
			NhanVienBLL nvbll = new NhanVienBLL();
			try {
				int result = nvbll.insertNhanVien(nv);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"THEM THANH CONG!","THONG BAO",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllNhanVien();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnEnv = new JButton("Edit");
		btnEnv.setBounds(482, 163, 111, 57);
		btnEnv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEnv.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			NhanVienDTO nv = new NhanVienDTO();
			nv.setTen_nv(txtnvname.getText());
			nv.setDiaChi(txtdiachinv.getText());
			nv.setSDT(txtsdtnv.getText());
                        nv.setMa_nv(txtmanv.getText());
			NhanVienBLL nvbll = new NhanVienBLL();
			try {
				int result = nvbll.updateNhanVien(nv);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"CAP NHAT THANH CONG!","THONG BAO",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllNhanVien();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnDnv = new JButton("Delete");
		btnDnv.setBounds(345, 163, 111, 57);
		btnDnv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDnv.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 NhanVienDTO nv = new NhanVienDTO();
			 nv.setMa_nv(txtmanv.getText());
			 NhanVienBLL nvbll = new NhanVienBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "BAN CHAC CHAN MUON XOA!", "XAC NHAN",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
			 try {
				 @SuppressWarnings("unused")
				 int result = nvbll.deleteNhanVien(nv);
				 loadAllNhanVien();
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 	}
			 }
		}
		});
		panel1.add(btnInv);
		panel1.add(btnEnv);
		panel1.add(btnDnv);
		
		contentPane.add(panel1);		
	//btn nhanvien	
		 tblnhanvien = new JTable();
		 tblnhanvien.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 tblnhanvien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 tblnhanvien.addMouseListener(new MouseAdapter() {
		 // LÃ¡ÂºÂ¥y thÃƒÂ´ng tin dÃƒÂ²ng dÃ¡Â»Â¯ liÃ¡Â»â€¡u Ã„â€˜Ã†Â°Ã¡Â»Â£c chÃ¡Â»ï¿½n hiÃ¡Â»Æ’n thÃ¡Â»â€¹ lÃƒÂªn component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblnhanvien.getSelectedRow();
		 if (row != -1) {
                 txtmanv.setText(tblnhanvien.getValueAt(row, 0).toString());
		 txtnvname.setText(tblnhanvien.getValueAt(row, 1).toString());
		 txtnvemail.setText(tblnhanvien.getValueAt(row, 2).toString());
		 txtsdtnv.setText(tblnhanvien.getValueAt(row, 3).toString());
		 txtchucvu.setText(tblnhanvien.getValueAt(row, 4).toString());
		 txtdiachinv.setText(tblnhanvien.getValueAt(row, 5).toString());
                 txtpwnv.setEditable(false);
		 }
		 }
		 });
		JButton btnNhanvien = new JButton("NHAN VIEN");
		btnNhanvien.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNhanvien.setBackground(new Color(220, 242, 238));
		btnNhanvien.setForeground(new Color(95,  154,  156));
		btnNhanvien.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblnhanvien);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelvcb.setVisible(false);
				panel1.setVisible(true);
				panelcb.setVisible(false);
			}
		});
		btnNhanvien.setBounds(10, 215, 128, 23);
		contentPane.add(btnNhanvien);
//}
// chuyen bay {
		panelcb = new JPanel();
		panelcb.setBounds(167, 269, 619, 245);
		panelcb.setBackground(new Color(0,0,0,0));
		panelcb.setLayout(null);
			
			/*JButton btnEcb = new JButton("Edit");
			btnEcb.setBounds(482, 163, 111, 57);
			btnEcb.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnEcb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChuyenBayDTO cb = new ChuyenBayDTO();
				cb.setMa_cb(txtchuyenbayid.getText());
				cb.setMa_tuyenbay(txtmatuyenbay.getText());
				cb.setMa_mb(txtmaybayid.getText());
				cb.setNgaygio(java.sql.Date.valueOf(txtngaygio.getText()));
				cb.setSoghehang1(Integer.parseInt(txtgheh1.getText()));
				cb.setSoghehang2(Integer.parseInt(txtgheh2.getText()));
				cb.setThoigianbay(txtthoigian.getText());
				
				ChuyenBayBLL sbbll = new ChuyenBayBLL();
				try {
					int result = sbbll.updateChuyenBay (cb);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"cÃ¡ÂºÂ­p nhÃ¡ÂºÂ­t thÃƒÂ nh cÃƒÂ´ng!","thÃƒÂ´ng bÃƒÂ¡o",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllChuyenBay();
				} catch (Exception ex) {
					ex.printStackTrace();
				  }
			}
			});
			JButton btnDcb = new JButton("Delete");
			btnDcb.setBounds(345, 163, 111, 57);
			btnDcb.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnDcb.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 ChuyenBayDTO cb = new ChuyenBayDTO();
				 cb.setMa_cb(txtchuyenbayid.getText());
				 ChuyenBayBLL cbbll = new ChuyenBayBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "BÃ¡ÂºÂ¡n cÃƒÂ³ chÃ¡ÂºÂ¯c chÃ¡ÂºÂ¯n xÃƒÂ³a dÃ¡Â»Â¯ liÃ¡Â»â€¡u!", "XÃƒÂ¡c nhÃ¡ÂºÂ­n",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 @SuppressWarnings("unused")
					 int result = cbbll.deleteChuyenBay(cb);
					 loadAllChuyenBay();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 	}
				 }
			}
			});
			panelcb.add(btnEcb);
			panelcb.add(btnDcb);*/
			
			contentPane.add(panelcb);
		
		tblchuyenbay = new JTable();
		//
		tblchuyenbay.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblchuyenbay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblchuyenbay.addMouseListener(new MouseAdapter() {
			 // LÃ¡ÂºÂ¥y thÃƒÂ´ng tin dÃƒÂ²ng dÃ¡Â»Â¯ liÃ¡Â»â€¡u Ã„â€˜Ã†Â°Ã¡Â»Â£c chÃ¡Â»ï¿½n hiÃ¡Â»Æ’n thÃ¡Â»â€¹ lÃƒÂªn component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tblchuyenbay.getSelectedRow();
			 if (row != -1) {
				 /*txtchuyenbayid.setText(tblchuyenbay.getValueAt(row, 0).toString());
				 txtmatuyenbay.setText(tblchuyenbay.getValueAt(row, 1).toString());
				 txtmaybayid.setText(tblchuyenbay.getValueAt(row, 2).toString());				
				 txtgheh1.setText(tblchuyenbay.getValueAt(row, 3).toString());
				 txtgheh2.setText(tblchuyenbay.getValueAt(row, 4).toString());
				 txtthoigian.setText(tblchuyenbay.getValueAt(row, 5).toString());	
				 txtngaygio.setText(tblchuyenbay.getValueAt(row, 6).toString());*/	
			 }
			 }
			 });
		JButton btnChuyenbay = new JButton("CHUYEN BAY");
		btnChuyenbay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnChuyenbay.setBackground(Color.white);
		btnChuyenbay.setForeground(new Color(86, 172, 191));
		btnChuyenbay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblchuyenbay);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panel1.setVisible(false);
				panelvcb.setVisible(false);
				panelcb.setVisible(true);
			}
		});
		btnChuyenbay.setBounds(10, 262, 128, 23);
		contentPane.add(btnChuyenbay);
//}	
		
		JLabel lblNewLabel = new JLabel("THONG TIN CHI TIET");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(603, 11, 250, 48);
		contentPane.add(lblNewLabel);
	}

	public void header() {
		JLabel lblNewLabel = new JLabel("FourAirlines");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 22, 100, 50);
		contentPane.add(lblNewLabel);		
		
		JLabel lblNewLabel_2 = new JLabel("THONG TIN CHI TIET");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(177, 236, 128, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel window = new JLabel(new ImageIcon("image/forPDC.png"), SwingConstants.CENTER);
		window.setForeground(new Color(255, 255, 255));
		window.setBounds(322, 11, 46, 54);
		contentPane.add(window);
		window.setText("");
		window.setHorizontalTextPosition(SwingConstants.RIGHT);
		window.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel windownight = new JLabel(new ImageIcon("image/forPDC night.png"), SwingConstants.CENTER);
		windownight.setForeground(Color.WHITE);
		windownight.setBounds(276, 468, 46, 54);
		contentPane.add(windownight);
		windownight.setText("");
		windownight.setHorizontalTextPosition(SwingConstants.RIGHT);
		windownight.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel left=new JLabel(new ImageIcon("image/byTrang.jpg"), SwingConstants.CENTER);
		left.setText("");
		left.setBounds(0, 0, 322, 539);
		left.setHorizontalTextPosition(SwingConstants.RIGHT);
		left.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(left);
		
		
		JLabel icon = new JLabel(new ImageIcon("image/plane.png"), SwingConstants.CENTER);
		icon.setForeground(new Color(255, 255, 255));
		icon.setBounds(548, 27, 46, 38);
		contentPane.add(icon);
		icon.setText("");
		icon.setHorizontalTextPosition(SwingConstants.RIGHT);
		icon.setHorizontalTextPosition(SwingConstants.CENTER);
		
	}
	
	/**
	  * Get all nhanvien to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllNhanVien() throws ClassNotFoundException {
		 //tÃ¡ÂºÂ¡o control DefaultTableModel Ã„â€˜Ã¡Â»Æ’ hiÃ¡Â»Æ’n thÃ¡Â»â€¹ danh sÃƒÂ¡ch NhanVien
	 String[] header = { "MA NV", "TEN NV", "Email", "SDT", "CHUC VU", "DIA CHI" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lÃ¡ÂºÂ¥y danh sÃƒÂ¡ch NhanVienDTO (gÃ¡Â»ï¿½i hÃƒÂ m getAllNhanVien() trong NhanVienBLL)
	 ArrayList<NhanVienDTO> arr = new ArrayList<NhanVienDTO>();
	 NhanVienBLL NhanVienBLL = new NhanVienBLL();
	 arr = NhanVienBLL.getAllNhanVien();
	 
	 //DuyÃ¡Â»â€¡t mÃ¡ÂºÂ£ng NhanVienDTO vÃ¡Â»Â«a lÃ¡ÂºÂ¥y Ã„â€˜Ã†Â°Ã¡Â»Â£c: arr
	 NhanVienDTO NhanVienDTO = new NhanVienDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 NhanVienDTO = arr.get(i);
		 
		 String ma_nv = NhanVienDTO.getMa_nv();
		 String ten_nv = NhanVienDTO.getTen_nv();
		 String email = NhanVienDTO.getEmail();
		 String sdt = NhanVienDTO.getSDT();
                 String chuc_vu = NhanVienDTO.getChucVu();
		 String dia_chi = NhanVienDTO.getDiaChi();
		 //tÃ¡ÂºÂ¡o row Ã„â€˜Ã¡Â»Æ’ add vÃƒÂ o control DefaultTableModel
		 Object[] row = { ma_nv, ten_nv, email, sdt, chuc_vu, dia_chi };
		 dtm.addRow(row);
	 }
	 tblnhanvien.setModel(dtm);
	 }
	 /**
	  * Get all khachhang to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllKhachHang() throws ClassNotFoundException {
		 //tÃ¡ÂºÂ¡o control DefaultTableModel Ã„â€˜Ã¡Â»Æ’ hiÃ¡Â»Æ’n thÃ¡Â»â€¹ danh sÃƒÂ¡ch KhachHang
	 String[] header = { "MA KH", "TEN KH","CMND/PP", "Email", "SDT", "DIA CHI" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lÃ¡ÂºÂ¥y danh sÃƒÂ¡ch KhachHangDTO (gÃ¡Â»ï¿½i hÃƒÂ m getAllKhachHang() trong KhachHangBLL)
	 ArrayList<KhachHangDTO> arr = new ArrayList<KhachHangDTO>();
	 KhachHangBLL KhachHangBLL = new KhachHangBLL();
	 arr = KhachHangBLL.getAllKhachHang();
	 
	 //DuyÃ¡Â»â€¡t mÃ¡ÂºÂ£ng KhachHangDTO vÃ¡Â»Â«a lÃ¡ÂºÂ¥y Ã„â€˜Ã†Â°Ã¡Â»Â£c: arr
	 KhachHangDTO KhachHangDTO = new KhachHangDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 KhachHangDTO = arr.get(i);
		 
		 String ma_kh = KhachHangDTO.getMa_kh();
		 String ten_kh = KhachHangDTO.getTen_kh();
		 String cmnd = KhachHangDTO.getCmnd();
		 String email = KhachHangDTO.getEmail();
		 String sdt = KhachHangDTO.getSDT();
		 String dia_chi = KhachHangDTO.getDiaChi();
		 //tÃ¡ÂºÂ¡o row Ã„â€˜Ã¡Â»Æ’ add vÃƒÂ o control DefaultTableModel
		 Object[] row = { ma_kh, ten_kh, cmnd, email, sdt, dia_chi };
		 dtm.addRow(row);
	 }
	 tblKhachhang.setModel(dtm);
	 }
	 /**
	  * Get all chuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllChuyenBay() throws ClassNotFoundException {
		 //tÃ¡ÂºÂ¡o control DefaultTableModel Ã„â€˜Ã¡Â»Æ’ hiÃ¡Â»Æ’n thÃ¡Â»â€¹ danh sÃƒÂ¡ch ChuyenBay
	 String[] header = { "MA CB", "HANG HK", "TEN", "DIEM DI", "DIEM DEN", "SB DI", "SB DEN", "GIO", "NGAY", "LOAI GHE", "GIA", "QUY DINH" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lÃ¡ÂºÂ¥y danh sÃƒÂ¡ch ChuyenBayDTO (gÃ¡Â»ï¿½i hÃƒÂ m getAllChuyenBay() trong ChuyenBayBLL)
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 arr = ChuyenBayBLL.getAllChuyenBay();
	 
	 //DuyÃ¡Â»â€¡t mÃ¡ÂºÂ£ng ChuyenBayDTO vÃ¡Â»Â«a lÃ¡ÂºÂ¥y Ã„â€˜Ã†Â°Ã¡Â»Â£c: arr
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
		 
		 String ma_cb = ChuyenBayDTO.getMaChuyenbay();
		 String hang_HK = ChuyenBayDTO.getHangHK();
                 String ten = ChuyenBayDTO.getTenMayBay();
                 String di = ChuyenBayDTO.getDiemDi();
                 String den = ChuyenBayDTO.getDiemDen();
                 String sb_di = ChuyenBayDTO.getSanBayDi();
                 String sb_den = ChuyenBayDTO.getSanBayDen();
		 Date ngay = ChuyenBayDTO.getNgayBay();
		 Time gio = ChuyenBayDTO.getGioBay();
		 String loaighe = ChuyenBayDTO.getLoaiGhe();
		 int gia = ChuyenBayDTO.getGia();
		 String quydinh = ChuyenBayDTO.getQuyDinh();
		 //tÃ¡ÂºÂ¡o row Ã„â€˜Ã¡Â»Æ’ add vÃƒÂ o control DefaultTableModel
		 Object[] row = { ma_cb, hang_HK, ten, di, den, sb_di, sb_den, ngay, gio, loaighe, gia, quydinh };
		 dtm.addRow(row);
	 }
	 tblchuyenbay.setModel(dtm);
	 }
	 public void loadAllHoaDon() throws ClassNotFoundException {
		 //tÃ¡ÂºÂ¡o control DefaultTableModel Ã„â€˜Ã¡Â»Æ’ hiÃ¡Â»Æ’n thÃ¡Â»â€¹ danh sÃƒÂ¡ch HoaDon
	 String[] header = { "TEN", "NV", "KH", "VE CB", "THANH TIEN", "TRANG THAI", "NGAY"};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lÃ¡ÂºÂ¥y danh sÃƒÂ¡ch HoaDonDTO (gÃ¡Â»ï¿½i hÃƒÂ m getAllHoaDon() trong HoaDonBLL)
	 ArrayList<HoaDonDTO> arr = new ArrayList<HoaDonDTO>();
	 HoaDonBLL HoaDonBLL = new HoaDonBLL();
	 arr = HoaDonBLL.getAllHoaDon();
	 
	 //DuyÃ¡Â»â€¡t mÃ¡ÂºÂ£ng HoaDonDTO vÃ¡Â»Â«a lÃ¡ÂºÂ¥y Ã„â€˜Ã†Â°Ã¡Â»Â£c: arr
	 HoaDonDTO HoaDonDTO = new HoaDonDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 HoaDonDTO = arr.get(i);
		 
		 String ma_hd = HoaDonDTO.getMa_hd();
                 String ten = HoaDonDTO.getTen_hd();
		 int thanh_tien = HoaDonDTO.getThanh_tien();
		 Date ngay_lap = HoaDonDTO.getNgay_Lap();
                 String ma_kh = HoaDonDTO.getMa_kh();
		 String ma_nv = HoaDonDTO.getMa_nv();
                 String ma_ve = HoaDonDTO.getMa_ve_cb();
                 String trangthai = HoaDonDTO.getTrangThai();
                 String nv = null;
                 String kh = null;
                 
                 NhanVienBLL NVBLL = new NhanVienBLL();
                 NhanVienDTO NVDTO = new NhanVienDTO();
                 ArrayList<NhanVienDTO> nvs = new ArrayList<NhanVienDTO>();
                 NVDTO.setMa_nv(ma_nv);
                 nvs = NVBLL.getNhanVienByMANV(NVDTO);
                 for (int j = 0; j < nvs.size(); j++) {
                    NVDTO = nvs.get(j);
                    nv = NVDTO.getTen_nv();
                 }
                 
                 KhachHangBLL KHBLL = new KhachHangBLL();
                 KhachHangDTO KHDTO = new KhachHangDTO();
                 ArrayList<KhachHangDTO> khs = new ArrayList<KhachHangDTO>();
                 KHDTO.setMa_kh(ma_kh);
                 khs = KHBLL.getKhachHangByma_kh(KHDTO);
                 for (int l = 0; l < khs.size(); l++) {
                    KHDTO = khs.get(l);
                    kh = KHDTO.getTen_kh();
                 }
                 
		 
		 //tÃ¡ÂºÂ¡o row Ã„â€˜Ã¡Â»Æ’ add vÃƒÂ o control DefaultTableModel
		 Object[] row = { ten, nv, kh, ma_ve, thanh_tien, ngay_lap, trangthai };
		 dtm.addRow(row);
	 }
	 tblHoadon.setModel(dtm);
	 }
	 
	 /**
	  * Get all vechuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllVeChuyenBay() throws ClassNotFoundException {
		 //tÃ¡ÂºÂ¡o control DefaultTableModel Ã„â€˜Ã¡Â»Æ’ hiÃ¡Â»Æ’n thÃ¡Â»â€¹ danh sÃƒÂ¡ch VeChuyenBay
	 String[] header = { "MA VE", "SO GHE", "MA CB", "KH", "NGAY", "GIO", "GIA", "TINH TRANG VE" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lÃ¡ÂºÂ¥y danh sÃƒÂ¡ch VeChuyenBayDTO (gÃ¡Â»ï¿½i hÃƒÂ m getAllVeChuyenBay() trong HVeChuyenBayBLL)
	 ArrayList<VeChuyenBayDTO> arr = new ArrayList<VeChuyenBayDTO>();
	 VeChuyenBayBLL VeChuyenBayBLL = new VeChuyenBayBLL();
	 arr = VeChuyenBayBLL.getAllVeChuyenBay();
	 
	 //DuyÃ¡Â»â€¡t mÃ¡ÂºÂ£ng HoaDonDTO vÃ¡Â»Â«a lÃ¡ÂºÂ¥y Ã„â€˜Ã†Â°Ã¡Â»Â£c: arr
	 VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 VeChuyenBayDTO = arr.get(i);
		 
		 String ma_ve_cb = VeChuyenBayDTO.getMa_ve_cb();
		 String soghe = VeChuyenBayDTO.getSo_ghe();
		 String ma_cb = VeChuyenBayDTO.getMa_cb();
		 String ma_kh = VeChuyenBayDTO.getMa_kh();
                 Time gio = VeChuyenBayDTO.getThoi_gian_bay();
                 Date ngay = VeChuyenBayDTO.getNgay_bay();
                 int gia = VeChuyenBayDTO.getGia();
		 String tinh_trang = VeChuyenBayDTO.getTinhtrangve();
                 String kh = null;
                 
                 KhachHangBLL KHBLL = new KhachHangBLL();
                 KhachHangDTO KHDTO = new KhachHangDTO();
                 ArrayList<KhachHangDTO> khs = new ArrayList<KhachHangDTO>();
                 KHDTO.setMa_kh(ma_kh);
                 khs = KHBLL.getKhachHangByma_kh(KHDTO);
                 for (int l = 0; l < khs.size(); l++) {
                    KHDTO = khs.get(l);
                    kh = KHDTO.getTen_kh();
                    
                 }
		 //tÃ¡ÂºÂ¡o row Ã„â€˜Ã¡Â»Æ’ add vÃƒÂ o control DefaultTableModel
		 Object[] row = { ma_ve_cb, soghe, ma_cb, kh, ngay, gio, gia, tinh_trang };
		 dtm.addRow(row);
	 }
	 tblvechuyenbay.setModel(dtm);
	 }
}
