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
import BLL.DonGiaBLL;
import BLL.HangVeBLL;
import BLL.HoaDonBLL;
import BLL.KhachHangBLL;
import BLL.MayBayBLL;
import BLL.NhanVienBLL;
import BLL.PhieuDatChoBLL;
import BLL.SanBayBLL;
import BLL.TuyenBayBLL;
import BLL.VeChuyenBayBLL;
import DTO.ChuyenBayDTO;
import DTO.DonGiaDTO;
import DTO.HangVeDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.MayBayDTO;
import DTO.NhanVienDTO;
import DTO.PhieuDatChoDTO;
import DTO.SanBayDTO;
import DTO.TuyenBayDTO;
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

public class Control extends JFrame {

	private JPanel contentPane;
	private JTable tblHoadon;
	private JTable tblKhachhang;
	private JTable tblhangve;
	private JTable tblnhanvien;
	private JTable tblphieudatcho;
	private JTable tblmaybay;
	private JTable tblsanbay;
	private JTable tblchuyenbay;
	private JTable tbltuyenbay;
	private JTable tblvechuyenbay;
	private JTable tbldongia;
	private JPanel panelkh;
	private JPanel panel1;
	private JPanel panelhv;
	private JPanel panelhd;
	private JPanel panelsb;
	private JPanel paneltb;
	private JPanel panelmb;
	private JPanel panelvcb;
	private JPanel panelpdc;
	private JPanel paneldg;
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
		loadAllDonGia();
		loadAllHangVe();
		loadAllKhachHang();
		loadAllMayBay();
		loadAllHoaDon();
		loadAllPhieuDatCho();
		loadAllSanBay();
		loadAllVeChuyenBay();
		loadAllTuyenBay();
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
		
//Chuyen bay {		
		panelvcb = new JPanel();
		panelvcb.setBounds(167, 269, 619, 245);

		panelvcb.setBackground(new Color(0,0,0,0));
		
		JTextField txtmavecb = new JTextField();
		txtmavecb.setColumns(10);
		txtmavecb.setBounds(116, 5, 96, 19);
		
		JTextField txtmacb = new JTextField();
		txtmacb.setBounds(318, 5, 96, 19);
		txtmacb.setColumns(10);
		
		JTextField txtmahdcb = new JTextField();
		txtmahdcb.setBounds(513, 5, 96, 19);
		txtmahdcb.setColumns(10);
		
		JTextField txtmahvcb = new JTextField();
		txtmahvcb.setBounds(116, 57, 96, 19);
		
		JTextField txtmadongia = new JTextField();
		txtmadongia.setColumns(10);
		txtmadongia.setBounds(318, 57, 96, 19);
		
		JTextField txttinhtrangve = new JTextField();
		txttinhtrangve.setColumns(10);
		txttinhtrangve.setBounds(513, 57, 96, 19);
		
		JLabel lbltinhtrangve = new JLabel("Tình trạng vé");
		lbltinhtrangve.setBounds(435, 61, 76, 13);
		
		JLabel lblmahdcb = new JLabel("Mã hóa đơn");
		lblmahdcb.setBounds(435, 9, 68, 13);
		
		JLabel lblmavecb = new JLabel("Mã vé chuyến bay");
		lblmavecb.setBounds(10, 8, 102, 13);
		
		JLabel lblmahvcb = new JLabel("Mã hạng vé");
		lblmahvcb.setBounds(10, 61, 68, 13);
		
		JLabel lblmacb = new JLabel("Mã chuyến bay");
		lblmacb.setBounds(222, 9, 86, 13);
		
		JLabel lblmadongia = new JLabel("Mã đơn giá");
		lblmadongia.setBounds(222, 61, 68, 13);
		
		panelvcb.setLayout(null);
		panelvcb.add(txtmavecb);
		panelvcb.add(txtmacb);
		panelvcb.add(txtmahdcb);
		panelvcb.add(txtmahvcb);
		panelvcb.add(txtmadongia);
		panelvcb.add(txttinhtrangve);
		panelvcb.add(lbltinhtrangve);
		panelvcb.add(lblmahdcb);
		panelvcb.add(lblmavecb);
		panelvcb.add(lblmahvcb);
		panelvcb.add(lblmacb);
		panelvcb.add(lblmadongia);
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
				 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
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
		
		
		JButton btnEvcb = new JButton("Edit");
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
						JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllVeChuyenBay();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		panelvcb.add(btnEvcb);
		
		contentPane.add(panelvcb);
		
		tblvechuyenbay = new JTable();
		tblvechuyenbay.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblvechuyenbay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblvechuyenbay.addMouseListener(new MouseAdapter() {
			 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tblvechuyenbay.getSelectedRow();
			 if (row != -1) {
			 txtmavecb.setText(tblvechuyenbay.getValueAt(row, 0).toString());
			 txtmahdcb.setText(tblvechuyenbay.getValueAt(row, 1).toString());
			 txtmacb.setText(tblvechuyenbay.getValueAt(row, 2).toString());				
			 txtmahvcb.setText(tblvechuyenbay.getValueAt(row, 3).toString());
			 txtmadongia.setText(tblvechuyenbay.getValueAt(row, 4).toString());
			 txttinhtrangve.setText(tblvechuyenbay.getValueAt(row, 5).toString());
			 }
			 }
			 });
		
		JButton btnVechuyenbay = new JButton("Vé chuyến bay");
		btnVechuyenbay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVechuyenbay.setBackground(Color.white);
		btnVechuyenbay.setForeground(new Color(86, 172, 191));
		btnVechuyenbay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblvechuyenbay);
				panel1.setVisible(false);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelhv.setVisible(false);
				panelvcb.setVisible(true);
				paneldg.setVisible(false);
				panelpdc.setVisible(false);
				panelcb.setVisible(false);
			}
		});
		btnVechuyenbay.setBounds(10, 385, 128, 23);
		contentPane.add(btnVechuyenbay);
//}
//Don Gia {
		paneldg = new JPanel();
		paneldg.setBounds(167, 269, 619, 245);
		paneldg.setBackground(new Color(0,0,0,0));
		
		JTextField txtdongiaid = new JTextField();
		txtdongiaid.setBounds(88, 5, 96, 19);
		
		JTextField txtvnd = new JTextField();
		txtvnd.setColumns(10);
		txtvnd.setBounds(263, 5, 96, 19);
		
		JTextField txtusd = new JTextField();
		txtusd.setColumns(10);
		txtusd.setBounds(436, 5, 96, 19);
		
		JLabel lbldongiaid = new JLabel("Mã đơn giá");
		lbldongiaid.setBounds(10, 9, 68, 13);
		
		JLabel lblvnd = new JLabel("VND");
		lblvnd.setBounds(222, 9, 44, 13);
		
		JLabel lblusd = new JLabel("USD");
		lblusd.setBounds(394, 9, 44, 13);
		
		paneldg.setLayout(null);
		
		paneldg.add(txtdongiaid);
		paneldg.add(txtvnd);
		paneldg.add(txtusd);
		paneldg.add(lbldongiaid);
		paneldg.add(lblvnd);
		paneldg.add(lblusd);
		paneldg.setVisible(false);
		
		
		JButton btnIdg = new JButton("Insert");
		btnIdg.setBounds(212, 163, 100, 57);
		btnIdg.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnIdg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DonGiaDTO dg = new DonGiaDTO();
				dg.setUSD(Integer.parseInt(txtusd.getText()));
				dg.setVND(Integer.parseInt(txtvnd.getText()));
				DonGiaBLL dgbll = new DonGiaBLL();
				try {
					int result = dgbll.insertDonGia(dg);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"thêm thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllDonGia();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		paneldg.add(btnIdg);
		
		JButton btnDdg = new JButton("Delete");
		btnDdg.setBounds(345, 163, 111, 57);
		btnDdg.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDdg.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 DonGiaDTO dg = new DonGiaDTO();
				 dg.setUSD(Integer.parseInt(txtusd.getText()));
				 dg.setVND(Integer.parseInt(txtvnd.getText()));
				 DonGiaBLL dgbll = new DonGiaBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 @SuppressWarnings("unused")
					 int result = dgbll.deleteDonGia(dg);
					 loadAllDonGia();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 	}
				 }
			}
		});
		paneldg.add(btnDdg);
		
		
		JButton btnEdg = new JButton("Edit");
		btnEdg.setBounds(482, 163, 111, 57);
		btnEdg.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEdg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DonGiaDTO dg = new DonGiaDTO();
				dg.setMa_dongia(txtdongiaid.getText());
				dg.setUSD(Integer.parseInt(txtusd.getText()));
				dg.setVND(Integer.parseInt(txtvnd.getText()));
				DonGiaBLL dgbll = new DonGiaBLL();
				try {
					int result = dgbll.updateDonGia(dg);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllDonGia();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		paneldg.add(btnEdg);
		
		contentPane.add(paneldg);
		tbldongia = new JTable();
		//
		tbldongia.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tbldongia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbldongia.addMouseListener(new MouseAdapter() {
			 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tbldongia.getSelectedRow();
			 if (row != -1) {
			 txtdongiaid.setText(tbldongia.getValueAt(row, 0).toString());
			 txtvnd.setText(tbldongia.getValueAt(row, 1).toString());
			 txtusd.setText(tbldongia.getValueAt(row, 2).toString());				
			
			 }
			 }
			 });
		JButton btnDongia = new JButton("Đơn giá");
		btnDongia.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDongia.setBackground(Color.white);
		btnDongia.setForeground(new Color(86, 172, 191));
		btnDongia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tbldongia);
				panel1.setVisible(false);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelhv.setVisible(false);
				panelvcb.setVisible(false);
				panelpdc.setVisible(false);
				paneldg.setVisible(true);
				panelcb.setVisible(false);
				
			}
		});
		btnDongia.setBounds(10, 419, 128, 23);
		contentPane.add(btnDongia);
//}
//Hang Ve {
		
		panelhv = new JPanel();
		panelhv.setBounds(167, 269, 619, 245);
		panelhv.setBackground(new Color(0,0,0,0));
		
		JTextField txtmahangve = new JTextField();
		txtmahangve.setColumns(10);
		txtmahangve.setBounds(79, 5, 96, 19);
		
		JTextField txttenhangve = new JTextField();
		txttenhangve.setColumns(10);
		txttenhangve.setBounds(267, 5, 96, 19);
		
		 JLabel lblmahv = new JLabel("Mã hạng vé");
		 lblmahv.setBounds(10, 8, 69, 13);
		 
		 JLabel lbltenhv = new JLabel("Tên hạng vé");
		 lbltenhv.setBounds(185, 8, 76, 13);
		panelhv.setLayout(null);
		 
		panelhv.add(txtmahangve);
		panelhv.add(txttenhangve);
		panelhv.add(lblmahv);
		panelhv.add(lbltenhv);
		panelhv.setVisible(false);
		
		JButton btnIhv = new JButton("Insert");
		btnIhv.setBounds(212, 163, 100, 57);
		btnIhv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnIhv.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			HangVeDTO hv = new HangVeDTO();
			hv.setTen_hv(txttenhangve.getText());
			HangVeBLL hvbll = new HangVeBLL();
			try {
				int result = hvbll.insertHangVe(hv);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"thêm thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllHangVe();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnEhv = new JButton("Edit");
		btnEhv.setBounds(482, 163, 111, 57);
		btnEhv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEhv.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			HangVeDTO hv = new HangVeDTO();
			hv.setMa_hv(txtmahangve.getText());
			hv.setTen_hv(txttenhangve.getText());
			System.out.println(txttenhangve.getText());
			HangVeBLL hvbll = new HangVeBLL();
			try {
				int result = hvbll.updateHangVe(hv);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllHangVe();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnDhv = new JButton("Delete");
		btnDhv.setBounds(345, 163, 111, 57);
		btnDhv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDhv.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 HangVeDTO hv = new HangVeDTO();
			 hv.setMa_hv(txtmahangve.getText());
			 HangVeBLL hvbll = new HangVeBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
			 try {
				 @SuppressWarnings("unused")
				 int result = hvbll.deleteHangVe(hv);
				 loadAllHangVe();
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 	}
			 }
		}
		});
		panelhv.add(btnIhv);
		panelhv.add(btnEhv);
		panelhv.add(btnDhv);
		
		contentPane.add(panelhv);
		
		tblhangve = new JTable();
		//
		tblhangve.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblhangve.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblhangve.addMouseListener(new MouseAdapter() {
		 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblhangve.getSelectedRow();
		 if (row != -1) {
		 txtmahangve.setText(tblhangve.getValueAt(row, 0).toString());
		 txttenhangve.setText(tblhangve.getValueAt(row, 1).toString());	
		 }
		 }
		 });
		JButton btnHangve = new JButton("Hạng vé");
		btnHangve.setForeground(new Color(255, 255, 255));
		btnHangve.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnHangve.setBackground(new Color(86, 172, 191));
		
		
		
		btnHangve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblhangve);
				panel1.setVisible(false);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelhv.setVisible(true);
				panelvcb.setVisible(false);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
			}
		});
		btnHangve.setBounds(10, 79, 128, 23);
		contentPane.add(btnHangve);
//}		
//HoaDon {	
		panelhd = new JPanel();
		panelhd.setBounds(167, 269, 619, 245);
		panelhd.setBackground(new Color(0,0,0,0));
		
		JTextField txtmahoadon = new JTextField();
		txtmahoadon.setBounds(81, 4, 96, 19);
		txtmahoadon.setColumns(10);
		
		JTextField txtthanhtien = new JTextField();
		txtthanhtien.setBounds(81, 57, 96, 19);
		txtthanhtien.setColumns(10);
		
		JTextField txtngaylap = new JTextField();
		txtngaylap.setBounds(281, 57, 96, 19);
		txtngaylap.setColumns(10);
		
		JTextField txtnhanvienID = new JTextField();
		txtnhanvienID.setBounds(281, 4, 96, 19);
		txtnhanvienID.setColumns(10);
		
		
		JTextField txtkhachhangID = new JTextField();
		txtkhachhangID.setBounds(496, 4, 96, 19);
		txtkhachhangID.setColumns(10);
		
		 JLabel lblmahd = new JLabel("Mã hóa đơn");
		 lblmahd.setBounds(10, 8, 76, 13);
		 
		 JLabel lblthanhtien = new JLabel("Thành tiền");
		 lblthanhtien.setBounds(10, 61, 76, 13);
		 
		 JLabel lblmanvhd = new JLabel("Mã nhân viên");
		 lblmanvhd.setBounds(202, 8, 76, 13);
		 
		 JLabel lblkhachhangidhd = new JLabel("Mã khách hàng");
		 lblkhachhangidhd.setBounds(404, 8, 96, 13);
		 
		 JLabel lblngaylap = new JLabel("Ngày lập");
		 lblngaylap.setBounds(216, 61, 55, 13);
		panelhd.setLayout(null);
		panelhd.add(txtmahoadon);
		panelhd.add(txtkhachhangID);
		panelhd.add(txtnhanvienID);
		panelhd.add(txtngaylap);
		panelhd.add(txtthanhtien);
		panelhd.add(lblmahd);
		panelhd.add(lblmanvhd);
		panelhd.add(lblkhachhangidhd);
		panelhd.add(lblthanhtien);
		panelhd.add(lblngaylap);
		panelhd.setVisible(false);
		
		JButton btnEhd = new JButton("Edit");
		btnEhd.setBounds(482, 163, 111, 57);
		btnEhd.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEhd.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			HoaDonDTO hd = new HoaDonDTO();
			hd.setMa_hd(txtmahoadon.getText());
			hd.setThanh_tien(Integer.parseInt(txtthanhtien.getText()));
			hd.setNgay_Lap(java.sql.Date.valueOf(txtngaylap.getText()));
			hd.setMa_kh(txtkhachhangID.getText());
			hd.setMa_nv(txtnhanvienID.getText());
			HoaDonBLL hdbll = new HoaDonBLL();
			try {
				int result = hdbll.updateHoaDon(hd);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllHoaDon();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnDhd = new JButton("Delete");
		btnDhd.setBounds(345, 163, 111, 57);
		btnDhd.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDhd.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 HoaDonDTO hd = new HoaDonDTO();
				hd.setMa_hd(txtmahoadon.getText());
				HoaDonBLL hdbll = new HoaDonBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
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
		panelhd.add(btnEhd);
		panelhd.add(btnDhd);
		
		contentPane.add(panelhd);
		
		 tblHoadon = new JTable();
		//
		 tblHoadon.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 tblHoadon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 tblHoadon.addMouseListener(new MouseAdapter() {
			 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tblHoadon.getSelectedRow();
			 if (row != -1) {
			 txtmahoadon.setText(tblHoadon.getValueAt(row, 0).toString());
			 txtthanhtien.setText(tblHoadon.getValueAt(row, 1).toString());
			 txtngaylap.setText(tblHoadon.getValueAt(row, 2).toString());				
			 txtnhanvienID.setText(tblHoadon.getValueAt(row, 3).toString());
			 txtkhachhangID.setText(tblHoadon.getValueAt(row, 4).toString());
			 }
			 }
			 });
		 
		JButton btnHoadon = new JButton("Hóa đơn");
		btnHoadon.setForeground(new Color(255, 255, 255));
		btnHoadon.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnHoadon.setBackground(new Color(86, 172, 191));
		btnHoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblHoadon);
				panel1.setVisible(false);
				panelkh.setVisible(false);
				panelhv.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelhd.setVisible(true);
				panelvcb.setVisible(false);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
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
		
		JTextField txtkhachhangemail = new JTextField();
		txtkhachhangemail.setColumns(10);
		txtkhachhangemail.setBounds(220, 57, 96, 19);
		//txtkhachhangemail.setVisible(false);
		
		
		JTextField txtsdtkh = new JTextField();
		txtsdtkh.setBounds(220, 5, 96, 19);
		//txtsdtkh.setVisible(false);
		
		txtsdtkh.setColumns(10);
		
		JTextField txtkhachhangname = new JTextField();
		txtkhachhangname.setColumns(10);
		txtkhachhangname.setBounds(50, 5, 96, 19);
		//txtkhachhangname.setVisible(false);
		
		
		JTextField  txtkhachhangId = new JTextField();
		 txtkhachhangId.setBounds(455, 5, 96, 19);
		// txtkhachhangId.setVisible(false);
		
		 txtkhachhangId.setColumns(10);
		 
		 JTextField  txtdiachikh = new JTextField();
		 txtdiachikh.setBounds(50, 56, 96, 19);
		// txtkhachhangId.setVisible(false);
		 txtdiachikh.setColumns(10);
		
		JTextField txtxacdinh=new JTextField();
		txtxacdinh.setBounds(455, 56, 96, 20);
		txtxacdinh.setColumns(10);
		 
		 JLabel lblmakh = new JLabel("Mã khách hàng");
		 lblmakh.setBounds(349, 8, 135, 13);
		 //lblmakh.setVisible(false);
		
		 JLabel lblxacdinh = new JLabel("CMND/PASSPORT");
		 lblxacdinh.setBounds(349, 60, 105, 13);
		 
			JLabel lbltenkh = new JLabel("Họ tên");
			lbltenkh.setBounds(9, 8, 49, 13);
			//lbltenkh.setVisible(false);
			
			
			JLabel lblemailkh = new JLabel("Email");
			lblemailkh.setBounds(185, 60, 49, 13);
			//lblemailkh.setVisible(false);
			
			
			JLabel lbldiachikh = new JLabel("Địa chỉ");
			lbldiachikh.setBounds(9, 60, 50, 13);
			//lbldiachikh.setVisible(false);
		
			
			JLabel lblsdtkh = new JLabel("SĐT");
			lblsdtkh.setBounds(185, 8, 49, 13);
			panelkh.setLayout(null);
			
			//lblsdtkh.setVisible(false);
			
			
			panelkh.add(lbltenkh);
			panelkh.add(lbldiachikh);
			panelkh.add(lblemailkh);
			panelkh.add(lblmakh);
			panelkh.add(lblsdtkh);
			panelkh.add(lblxacdinh);
			panelkh.add(txtdiachikh);
			panelkh.add(txtkhachhangId);
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
				kh.setSDT(txtsdtkh.getText());
				kh.setCmnd(txtxacdinh.getText());
				kh.setDiaChi(txtdiachikh.getText());
				KhachHangBLL khbll = new KhachHangBLL();
				try {
					int result = khbll.insertKhachHang(kh);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"thêm thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
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
				kh.setMa_kh(txtkhachhangId.getText());
				kh.setTen_kh(txtkhachhangname.getText());
				kh.setEmail(txtkhachhangemail.getText());
				kh.setSDT(txtsdtkh.getText());
				kh.setCmnd(txtxacdinh.getText());
				kh.setDiaChi(txtdiachikh.getText());
				KhachHangBLL khbll = new KhachHangBLL();
				try {
					int result = khbll.updateKhachHang(kh);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
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
					kh.setMa_kh(txtkhachhangId.getText());
					KhachHangBLL khbll = new KhachHangBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
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
		 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblKhachhang.getSelectedRow();
		 if (row != -1) {
		 txtkhachhangId.setText(tblKhachhang.getValueAt(row, 0).toString());
		 txtkhachhangname.setText(tblKhachhang.getValueAt(row, 1).toString());
		 txtxacdinh.setText(tblKhachhang.getValueAt(row, 2).toString());
		 txtkhachhangemail.setText(tblKhachhang.getValueAt(row, 3).toString());
		 txtsdtkh.setText(tblKhachhang.getValueAt(row, 4).toString()); 
		 txtdiachikh.setText(tblKhachhang.getValueAt(row, 5).toString());			
		 }
		 }
		 });
		JButton btnKhachhang = new JButton("Khách hàng");
		btnKhachhang.setForeground(new Color(255, 255, 255));
		btnKhachhang.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnKhachhang.setBackground(new Color(86, 172, 191));
		btnKhachhang.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblKhachhang);
				panel1.setVisible(false);
				panelhv.setVisible(false);
				panelhd.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelkh.setVisible(true);
				panelvcb.setVisible(false);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
				
			}
		});
		btnKhachhang.setBounds(10, 147, 128, 23);
		
		contentPane.add(btnKhachhang);
//}
// May Bay {
		panelmb = new JPanel();
		panelmb.setBounds(167, 269, 619, 245);
		panelmb.setBackground(new Color(0,0,0,0));
		
		JTextField txtmaybayID = new JTextField();
		txtmaybayID.setColumns(10);
		txtmaybayID.setBounds(79, 5, 96, 19);
		
		JTextField txtmaybayname = new JTextField();
		txtmaybayname.setColumns(10);
		txtmaybayname.setBounds(267, 5, 96, 19);
		
		JLabel lblmamb = new JLabel("Mã máy bay");
		lblmamb.setBounds(10, 8, 69, 13);
		
		JLabel lbltenmb = new JLabel("Tên máy bay");
		 lbltenmb.setBounds(185, 8, 76, 13);
		
		
		panelmb.setLayout(null);
		panelmb.add(txtmaybayID);
		panelmb.add(txtmaybayname);
		panelmb.add(lblmamb);
		panelmb.add(lbltenmb);
		panelmb.setVisible(false);
		
		JButton btnImb = new JButton("Insert");
		btnImb.setBounds(212, 163, 100, 57);
		btnImb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImb.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MayBayDTO mb = new MayBayDTO();
			mb.setTen_mb(txtmaybayname.getText());
			MayBayBLL mbbll = new MayBayBLL();
			try {
				int result = mbbll.insertMayBay(mb);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"thêm thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllMayBay();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnEmb = new JButton("Edit");
		btnEmb.setBounds(482, 163, 111, 57);
		btnEmb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEmb.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MayBayDTO mb = new MayBayDTO();
			mb.setMa_mb(txtmaybayID.getText());
			mb.setTen_mb(txtmaybayname.getText());
			MayBayBLL mbbll = new MayBayBLL();
			try {
				int result = mbbll.updateMayBay(mb);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllMayBay();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnDmb = new JButton("Delete");
		btnDmb.setBounds(345, 163, 111, 57);
		btnDmb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDmb.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 MayBayDTO mb = new MayBayDTO();
			 mb.setMa_mb(txtmaybayID.getText());
			 MayBayBLL mbbll = new MayBayBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
			 try {
				 @SuppressWarnings("unused")
				 int result = mbbll.deleteMayBay(mb);
				 loadAllMayBay();
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 	}
			 }
		}
		});
		panelmb.add(btnImb);
		panelmb.add(btnEmb);
		panelmb.add(btnDmb);
		
		contentPane.add(panelmb);
		
		tblmaybay = new JTable();
		//
		tblmaybay.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblmaybay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblmaybay.addMouseListener(new MouseAdapter() {
		 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblmaybay.getSelectedRow();
		 if (row != -1) {
		 txtmaybayID.setText(tblmaybay.getValueAt(row, 0).toString());
		 txtmaybayname.setText(tblmaybay.getValueAt(row, 1).toString());
		
			
		 }
		 }
		 });
		JButton btnMaybay = new JButton("Máy bay");
		btnMaybay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnMaybay.setBackground(new Color(220, 242, 238));
		btnMaybay.setForeground(new Color(95,  154,  156));
		btnMaybay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblmaybay);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelhv.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(true);
				paneltb.setVisible(false);
				panelvcb.setVisible(false);
				panel1.setVisible(false);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
			}
		});
		btnMaybay.setBounds(10, 181, 128, 23);
		contentPane.add(btnMaybay);
// }
// NhanVien {
	//jtextfield
		panel1 = new JPanel();
		panel1.setBounds(167, 269, 619, 245);
		panel1.setBackground(new Color(0, 0,0,0));
		JTextField txtnhanvienemail = new JTextField();
		txtnhanvienemail.setColumns(10);
		txtnhanvienemail.setBounds(220, 57, 96, 19);

		JTextField txtsdtnv = new JTextField();
		txtsdtnv.setBounds(220, 5, 96, 19);
		txtsdtnv.setColumns(10);
		
		JTextField txtdiachinv = new JTextField();
		txtdiachinv.setBounds(50, 57, 96, 19);
		
		JTextField txtnhanvienname = new JTextField();
		txtnhanvienname.setColumns(10);
		txtnhanvienname.setBounds(50, 5, 96, 19);
		
		JTextField txtnhanvienId = new JTextField();
		txtnhanvienId.setBounds(455, 5, 96, 19);
		txtnhanvienId.setColumns(10);
	//jlabel		
		JLabel lblmanv = new JLabel("Mã nhân viên");
		lblmanv.setBounds(349, 8, 135, 13);
		
		JLabel lbltennv = new JLabel("Họ tên");
		lbltennv.setBounds(10, 8, 49, 13);
		
		JLabel lblemailnv = new JLabel("Email");
		lblemailnv.setBounds(185, 60, 49, 13);
		
		JLabel lbldiachinv = new JLabel("Địa chỉ");
		lbldiachinv.setBounds(9, 60, 50, 13);
		
		JLabel lblsdtnv = new JLabel("SĐT");
		lblsdtnv.setBounds(185, 8, 49, 13);
		panel1.setLayout(null);
		
	//Jpannel nhavien
		
		panel1.add(lbltennv);
		panel1.add(lbldiachinv);
		panel1.add(lblemailnv);
		panel1.add(lblmanv);
		panel1.add(lblsdtnv);
		panel1.add(txtnhanvienname);
		panel1.add(txtdiachinv);
		panel1.add(txtnhanvienemail);
		panel1.add(txtnhanvienId);
		panel1.add(txtsdtnv);
		panel1.setVisible(false);
		
		JButton btnInv = new JButton("Insert");
		btnInv.setBounds(212, 163, 100, 57);
		btnInv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnInv.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			NhanVienDTO nv = new NhanVienDTO();
			
			nv.setTen_nv(txtnhanvienname.getText());
			nv.setDiaChi(txtdiachinv.getText());
			nv.setSDT(txtsdtnv.getText());
			nv.setEmail(txtnhanvienemail.getText());
			NhanVienBLL nvbll = new NhanVienBLL();
			try {
				int result = nvbll.insertNhanVien(nv);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"thêm thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
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
		@Override
		public void actionPerformed(ActionEvent e) {
			NhanVienDTO nv = new NhanVienDTO();
			nv.setMa_nv(txtnhanvienID.getText());
			nv.setTen_nv(txtnhanvienname.getText());
			nv.setDiaChi(txtdiachinv.getText());
			nv.setSDT(txtsdtnv.getText());
			nv.setEmail(txtnhanvienemail.getText());
			NhanVienBLL nvbll = new NhanVienBLL();
			try {
				int result = nvbll.updateNhanVien(nv);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
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
			 nv.setMa_nv(txtnhanvienID.getText());
			 NhanVienBLL nvbll = new NhanVienBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
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
		 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblnhanvien.getSelectedRow();
		 if (row != -1) {
		 txtnhanvienId.setText(tblnhanvien.getValueAt(row, 0).toString());
		 txtnhanvienname.setText(tblnhanvien.getValueAt(row, 1).toString());
		 txtnhanvienemail.setText(tblnhanvien.getValueAt(row, 2).toString());
		 txtsdtnv.setText(tblnhanvien.getValueAt(row, 3).toString()); 
		 txtdiachinv.setText(tblnhanvien.getValueAt(row, 4).toString());	
		 }
		 }
		 });
		JButton btnNhanvien = new JButton("Nhân viên");
		btnNhanvien.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNhanvien.setBackground(new Color(220, 242, 238));
		btnNhanvien.setForeground(new Color(95,  154,  156));
		btnNhanvien.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblnhanvien);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelhv.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelvcb.setVisible(false);
				panel1.setVisible(true);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
			}
		});
		btnNhanvien.setBounds(10, 215, 128, 23);
		contentPane.add(btnNhanvien);
//}
//Phieu dat cho {
		panelpdc = new JPanel();
		panelpdc.setBounds(167, 269, 619, 245);
		panelpdc.setBackground(new Color(0, 0,0,0));
		JTextField txtphieuId = new JTextField();
		txtphieuId.setBounds(66, 4, 96, 19);
		txtphieuId.setColumns(10);
		
		JTextField txtmavecbdc = new JTextField();
		txtmavecbdc.setBounds(288, 4, 96, 19);
		
		JTextField txtngaydat = new JTextField();
		txtngaydat.setColumns(10);
		txtngaydat.setBounds(480, 4, 96, 19);
		
		JTextField txtsoghe = new JTextField();
		txtsoghe.setBounds(66, 56, 96, 19);
		txtsoghe.setColumns(10);
	
		JLabel lblphieuid = new JLabel("Mã phiếu");
		lblphieuid.setBounds(9, 8, 61, 13);
		
		JLabel lblmavecbdc = new JLabel("Mã vé chuyến bay");
		lblmavecbdc.setBounds(185, 8, 102, 13);
		
		JLabel lblngaydat = new JLabel("Ngày đặt");
		lblngaydat.setBounds(409, 8, 61, 13);
		
		JLabel lblsoghe = new JLabel("Số ghế");
		lblsoghe.setBounds(9, 60, 50, 13);
		panelpdc.setLayout(null);
		
		
		panelpdc.add(txtsoghe);
		panelpdc.add(txtngaydat);
		panelpdc.add(txtphieuId);
		panelpdc.add(txtmavecbdc);	
		panelpdc.add(lblmavecbdc);
		panelpdc.add(lblphieuid);
		panelpdc.add(lblngaydat);
		panelpdc.add(lblsoghe);
		panelpdc.setVisible(false);
		contentPane.add(panelpdc);
		
		JButton btnEpdc = new JButton("Edit");
		btnEpdc.setBounds(482, 163, 111, 57);
		btnEpdc.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEpdc.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			PhieuDatChoDTO pdc = new PhieuDatChoDTO();
			pdc.setMa_phieu(txtphieuId.getText());
			pdc.setMa_ve_cb(txtmavecbdc.getText());
			pdc.setNgaydat(java.sql.Date.valueOf(txtngaydat.getText()));
			pdc.setSoghe(Integer.parseInt(txtsoghe.getText()));
			
			PhieuDatChoBLL pdcbll = new PhieuDatChoBLL();
			try {
				int result = pdcbll.updatePhieuDatCho (pdc);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllPhieuDatCho();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnDpdc = new JButton("Delete");
		btnDpdc.setBounds(345, 163, 111, 57);
		btnDpdc.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDpdc.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 PhieuDatChoDTO pdc = new PhieuDatChoDTO();
			 pdc.setMa_phieu(txtphieuId.getText());
			 PhieuDatChoBLL pdcbll = new PhieuDatChoBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
			 try {
				 @SuppressWarnings("unused")
				 int result = pdcbll.deletePhieuDatCho(pdc);
				 loadAllPhieuDatCho();
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 	}
			 }
		}
		});
		panelpdc.add(btnEpdc);
		panelpdc.add(btnDpdc);
		
		tblphieudatcho = new JTable();
		//
		tblphieudatcho.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblphieudatcho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblphieudatcho.addMouseListener(new MouseAdapter() {
		 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblphieudatcho.getSelectedRow();
		 if (row != -1) {
		 txtphieuId.setText(tblphieudatcho.getValueAt(row, 0).toString());
		 txtmavecbdc.setText(tblphieudatcho.getValueAt(row, 1).toString());
		 txtngaydat.setText(tblphieudatcho.getValueAt(row, 2).toString());
		 txtsoghe.setText(tblphieudatcho.getValueAt(row, 3).toString()); 
	
		 }
		 }
		 });
		
		JButton btnPhieudatcho = new JButton("Phiếu đặt chỗ");
		btnPhieudatcho.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnPhieudatcho.setBackground(new Color(220, 242, 238));
		btnPhieudatcho.setForeground(new Color(95,  154,  156));
		btnPhieudatcho.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblphieudatcho);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelhv.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelvcb.setVisible(false);
				panel1.setVisible(false);
				panelpdc.setVisible(true);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
				
			}
		});
		btnPhieudatcho.setBounds(10, 249, 128, 23);
		contentPane.add(btnPhieudatcho);
//}
//San bay {
		panelsb = new JPanel();
		panelsb.setBounds(167, 269, 619, 245);
		panelsb.setBackground(new Color(0, 0,0,0));
		
		JTextField txtsanbayId = new JTextField();
		txtsanbayId.setBounds(76, 5, 96, 19);
		txtsanbayId.setColumns(10);
		
		JTextField txtsanbayname = new JTextField();
		txtsanbayname.setBounds(277, 5, 96, 19);
		txtsanbayname.setColumns(10);
		
		JLabel lblmasb = new JLabel("Mã sân bay");
		lblmasb.setBounds(10, 9, 81, 13);
		
		
		JLabel lbltensb = new JLabel("Tên sân bay");
		lbltensb.setBounds(197, 9, 81, 13);
		panelsb.setLayout(null);
		
		panelsb.add(txtsanbayId);
		panelsb.add(txtsanbayname);
		panelsb.add(lblmasb);
		panelsb.add(lbltensb);
		panelsb.setVisible(false);
		
		JButton btnIsb = new JButton("Insert");
		btnIsb.setBounds(212, 163, 100, 57);
		btnIsb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnIsb.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			SanBayDTO sb = new SanBayDTO();
			
			sb.setTen_sb(txtsanbayname.getText());
			
			SanBayBLL sbbll = new SanBayBLL();
			try {
				int result = sbbll.insertSanBay(sb);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"thêm thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllSanBay();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnEsb = new JButton("Edit");
		btnEsb.setBounds(482, 163, 111, 57);
		btnEsb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEsb.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			SanBayDTO sb = new SanBayDTO();
			sb.setMa_sb(txtsanbayId.getText());
			sb.setTen_sb(txtsanbayname.getText());
			
			SanBayBLL sbbll = new SanBayBLL();
			try {
				int result = sbbll.updateSanBay (sb);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllSanBay();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnDsb = new JButton("Delete");
		btnDsb.setBounds(345, 163, 111, 57);
		btnDsb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDsb.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 SanBayDTO sb = new SanBayDTO();
			 sb.setMa_sb(txtsanbayId.getText());
			 SanBayBLL sbbll = new SanBayBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
			 try {
				 @SuppressWarnings("unused")
				 int result = sbbll.deleteSanBay(sb);
				 loadAllSanBay();
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 	}
			 }
		}
		});
		panelsb.add(btnIsb);
		panelsb.add(btnEsb);
		panelsb.add(btnDsb);
		
		contentPane.add(panelsb);
		
		tblsanbay = new JTable();
		//
		tblsanbay.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblsanbay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblsanbay.addMouseListener(new MouseAdapter() {
		 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblsanbay.getSelectedRow();
		 if (row != -1) {
		 txtsanbayId.setText(tblsanbay.getValueAt(row, 0).toString());
		 txtsanbayname.setText(tblsanbay.getValueAt(row, 1).toString());
		 
		 }
		 }
		 });
		JButton btnSanbay = new JButton("Sân bay");
		btnSanbay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSanbay.setBackground(new Color(220, 242, 238));
		btnSanbay.setForeground(new Color(95,  154,  156));
		btnSanbay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblsanbay);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelhv.setVisible(false);
				panel1.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelsb.setVisible(true);
				panelvcb.setVisible(false);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
			}
		});
		btnSanbay.setBounds(10, 283, 128, 23);
		contentPane.add(btnSanbay);
//}
// chuyen bay {
		panelcb = new JPanel();
		panelcb.setBounds(167, 269, 619, 245);
		panelcb.setBackground(new Color(0,0,0,0));
		
		JTextField txtchuyenbayid = new JTextField();
		txtchuyenbayid.setColumns(10);
		txtchuyenbayid.setBounds(89, 4, 96, 19);
		//txtkhachhangemail.setVisible(false);
		
		JTextField txtthoigian = new JTextField();
		txtthoigian.setBounds(295, 56, 96, 19);
		//txtsdtkh.setVisible(false);
		txtthoigian.setColumns(10);
		
		JTextField txtmatuyenbay = new JTextField();
		txtmatuyenbay.setBounds(295, 4, 96, 19);
		//txtsdtkh.setVisible(false);
		txtmatuyenbay.setColumns(10);
		
		JTextField txtmaybayid = new JTextField();
		txtmaybayid.setColumns(10);
		txtmaybayid.setBounds(492, 56, 96, 19);
		//txtkhachhangname.setVisible(false);
		
		
		JTextField  txtgheh1 = new JTextField();
		txtgheh1.setBounds(89,111, 96, 19);
		// txtkhachhangId.setVisible(false);
		txtgheh1.setColumns(10);
		 
		 JTextField  txtgheh2 = new JTextField();
		 txtgheh2.setBounds(89, 56, 96, 19);
		// txtkhachhangId.setVisible(false);
		 txtgheh2.setColumns(10);
		
		JTextField txtngaygio=new JTextField();
		txtngaygio.setBounds(492, 4, 96, 20);
		txtngaygio.setColumns(10);
		 
		 JLabel lblchuyenbayid = new JLabel("Mã chuyến bay");
		 lblchuyenbayid.setBounds(9, 8, 95, 13);
		 //lblmakh.setVisible(false);
		
		 JLabel lblmatuyenbay = new JLabel("Mã tuyến bay");
		 lblmatuyenbay.setBounds(213, 8, 95, 13);
		 
			JLabel lblmabayid = new JLabel("Mã máy bay");
			lblmabayid.setBounds(423, 8, 70, 13);
			//lbltenkh.setVisible(false);
			
			
			JLabel lblgheh1 = new JLabel("Số ghế hạng 1");
			lblgheh1.setBounds(9, 60, 95, 13);
			//lblemailkh.setVisible(false);
			
			
			JLabel lblgheh2 = new JLabel("Số ghế hạng 2");
			lblgheh2.setBounds(213, 60, 84, 13);
			//lbldiachikh.setVisible(false);
		
			
			JLabel lblngaygio = new JLabel("Ngày giờ");
			lblngaygio.setBounds(423, 60, 70, 13);
			
			JLabel lblthoigian = new JLabel("Thời gian bay");
			lblthoigian.setBounds(9, 115, 95, 13);
			panelcb.setLayout(null);
			panelcb.add(lblngaygio);
			panelcb.add(lblgheh1);
			panelcb.add(lblgheh2);
			panelcb.add(lblmabayid);
			panelcb.add(lblmatuyenbay);
			panelcb.add(lblchuyenbayid);
			panelcb.add(lblthoigian);
			panelcb.add(txtchuyenbayid);
			panelcb.add(txtngaygio);
			panelcb.add(txtgheh2);
			panelcb.add(txtgheh1);
			panelcb.add(txtmaybayid);
			panelcb.add(txtmatuyenbay);
			panelcb.add(txtthoigian);
			
			JButton btnEcb = new JButton("Edit");
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
						JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
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
				 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
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
			panelcb.add(btnDcb);
			
			contentPane.add(panelcb);
		
		tblchuyenbay = new JTable();
		//
		tblchuyenbay.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblchuyenbay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblchuyenbay.addMouseListener(new MouseAdapter() {
			 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tblchuyenbay.getSelectedRow();
			 if (row != -1) {
				 txtchuyenbayid.setText(tblchuyenbay.getValueAt(row, 0).toString());
				 txtmatuyenbay.setText(tblchuyenbay.getValueAt(row, 1).toString());
				 txtmaybayid.setText(tblchuyenbay.getValueAt(row, 2).toString());				
				 txtgheh1.setText(tblchuyenbay.getValueAt(row, 3).toString());
				 txtgheh2.setText(tblchuyenbay.getValueAt(row, 4).toString());
				 txtthoigian.setText(tblchuyenbay.getValueAt(row, 5).toString());	
				 txtngaygio.setText(tblchuyenbay.getValueAt(row, 6).toString());	
			 }
			 }
			 });
		JButton btnChuyenbay = new JButton("Chuyến bay");
		btnChuyenbay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnChuyenbay.setBackground(Color.white);
		btnChuyenbay.setForeground(new Color(86, 172, 191));
		btnChuyenbay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblchuyenbay);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelhv.setVisible(false);
				panel1.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelsb.setVisible(false);
				panelvcb.setVisible(false);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
				panelcb.setVisible(true);
			}
		});
		btnChuyenbay.setBounds(10, 317, 128, 23);
		contentPane.add(btnChuyenbay);
//}
// tuyen bay {			
		
		paneltb = new JPanel();
		paneltb.setBounds(167, 269, 619, 245);
		paneltb.setBackground(new Color(0, 0,0,0));
		
		JTextField txtmatb = new JTextField();
		txtmatb.setBounds(88, 5, 96, 19);
		txtmatb.setColumns(10);
		
		JTextField txtsanbaydi = new JTextField();
		txtsanbaydi.setBounds(272, 5, 96, 19);
		txtsanbaydi.setColumns(10);
		
		JTextField txtsanbayden = new JTextField();
		txtsanbayden.setBounds(462, 5, 96, 19);
		txtsanbayden.setColumns(10);
		
		JLabel lblmatb = new JLabel("Mã tuyến bay");
		lblmatb.setBounds(10, 9, 81, 13);
		
		JLabel lblsanbaydi = new JLabel("Sân bay đi");
		lblsanbaydi.setBounds(211, 9, 60, 13);
		
		
		JLabel lblsanbayden = new JLabel("Sân bay đến");
		lblsanbayden.setBounds(390, 9, 74, 13);
		paneltb.setLayout(null);
		
		paneltb.add(txtmatb);
		paneltb.add(txtsanbaydi);
		paneltb.add(txtsanbayden);
		paneltb.add(lblmatb);
		paneltb.add(lblsanbaydi);
		paneltb.add(lblsanbayden);
		paneltb.setVisible(false);
		
		JButton btnItb = new JButton("Insert");
		btnItb.setBounds(212, 163, 100, 57);
		btnItb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnItb.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			TuyenBayDTO tb = new TuyenBayDTO();
			
			tb.setSanbaydi(txtsanbaydi.getText());
			tb.setSanbayden(txtsanbayden.getText());
			
			
			TuyenBayBLL tbbll = new TuyenBayBLL();
			try {
				int result = tbbll.insertTuyenBay(tb);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"thêm thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllTuyenBay();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnEtb = new JButton("Edit");
		btnEtb.setBounds(482, 163, 111, 57);
		btnEtb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEtb.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			TuyenBayDTO tb = new TuyenBayDTO();
			tb.setMa_tuyenbay(txtmatb.getText());
			tb.setSanbaydi(txtsanbaydi.getText());
			tb.setSanbayden(txtsanbayden.getText());
			
			TuyenBayBLL tbbll = new TuyenBayBLL();
			try {
				int result = tbbll.updateTuyenBay (tb);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllTuyenBay();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnDtb = new JButton("Delete");
		btnDtb.setBounds(345, 163, 111, 57);
		btnDtb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDtb.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 TuyenBayDTO tb = new TuyenBayDTO();
			 tb.setMa_tuyenbay(txtmatb.getText());
			 TuyenBayBLL tbbll = new TuyenBayBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
			 try {
				 @SuppressWarnings("unused")
				 int result = tbbll.deleteTuyenBay(tb);
				 loadAllTuyenBay();
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 	}
			 }
		}
		});
		paneltb.add(btnEtb);
		paneltb.add(btnDtb);
		
		contentPane.add(paneltb);
		
		
		tbltuyenbay = new JTable();
		//
		tbltuyenbay.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tbltuyenbay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbltuyenbay.addMouseListener(new MouseAdapter() {
			 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tbltuyenbay.getSelectedRow();
			 if (row != -1) {
			 txtmatb.setText(tbltuyenbay.getValueAt(row, 0).toString());
			 txtsanbaydi.setText(tbltuyenbay.getValueAt(row, 1).toString());
			 txtsanbayden.setText(tbltuyenbay.getValueAt(row, 2).toString());				
			 
			 }
			 }
			 });
		JButton btnTuyenbay = new JButton("Tuyến bay");
		btnTuyenbay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTuyenbay.setBackground(Color.white);
		btnTuyenbay.setForeground(new Color(86, 172, 191));
		btnTuyenbay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tbltuyenbay);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelhv.setVisible(false);
				panel1.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				panelvcb.setVisible(false);
				panelpdc.setVisible(false);
				paneltb.setVisible(true);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
			}
		});
		btnTuyenbay.setBounds(10, 351, 128, 23);
		contentPane.add(btnTuyenbay);
		
		JLabel lblNewLabel = new JLabel("Thông tin chi tiết");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(603, 11, 181, 48);
		contentPane.add(lblNewLabel);
	}

	public void header() {
		JLabel lblNewLabel = new JLabel("FourAirlines");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 22, 100, 50);
		contentPane.add(lblNewLabel);
		
		JLabel foradmin = new JLabel("admin");
		foradmin.setBounds(167, 11, 57, 57);
		contentPane.add(foradmin);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin chi tiết");
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
		 //tạo control DefaultTableModel để hiển thị danh sách NhanVien
	 String[] header = { "Mã nhân viên", "Tên nhân viên", "Email", "SDT", "Địa chỉ" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách NhanVienDTO (gọi hàm getAllNhanVien() trong NhanVienBLL)
	 ArrayList<NhanVienDTO> arr = new ArrayList<NhanVienDTO>();
	 NhanVienBLL NhanVienBLL = new NhanVienBLL();
	 arr = NhanVienBLL.getAllNhanVien();
	 
	 //Duyệt mảng NhanVienDTO vừa lấy được: arr
	 NhanVienDTO NhanVienDTO = new NhanVienDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 NhanVienDTO = arr.get(i);
		 
		 String ma_nv = NhanVienDTO.getMa_nv();
		 String ten_nv = NhanVienDTO.getTen_nv();
		 String email = NhanVienDTO.getEmail();
		 String sdt = NhanVienDTO.getSDT();
		 String dia_chi = NhanVienDTO.getDiaChi();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_nv, ten_nv, email, sdt, dia_chi };
		 dtm.addRow(row);
	 }
	 tblnhanvien.setModel(dtm);
	 }
	 /**
	  * Get all khachhang to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllKhachHang() throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách KhachHang
	 String[] header = { "Mã khách hàng", "Tên khách hàng","CMND/PP", "Email", "SDT", "Địa chỉ" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách KhachHangDTO (gọi hàm getAllKhachHang() trong KhachHangBLL)
	 ArrayList<KhachHangDTO> arr = new ArrayList<KhachHangDTO>();
	 KhachHangBLL KhachHangBLL = new KhachHangBLL();
	 arr = KhachHangBLL.getAllKhachHang();
	 
	 //Duyệt mảng KhachHangDTO vừa lấy được: arr
	 KhachHangDTO KhachHangDTO = new KhachHangDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 KhachHangDTO = arr.get(i);
		 
		 String ma_kh = KhachHangDTO.getMa_kh();
		 String ten_kh = KhachHangDTO.getTen_kh();
		 String cmnd = KhachHangDTO.getCmnd();
		 String email = KhachHangDTO.getEmail();
		 String sdt = KhachHangDTO.getSDT();
		 String dia_chi = KhachHangDTO.getDiaChi();
		 //tạo row để add vào control DefaultTableModel
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
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "Mã chuyến bay", "Mã tuyến bay", "Ngày giờ", "Thời gian bay", "Số ghế hạng 1", "Số ghế hạng 2", "Mã máy bay" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách ChuyenBayDTO (gọi hàm getAllChuyenBay() trong ChuyenBayBLL)
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 arr = ChuyenBayBLL.getAllChuyenBay();
	 
	 //Duyệt mảng ChuyenBayDTO vừa lấy được: arr
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
		 
		 String ma_cb = ChuyenBayDTO.getMa_cb();
		 String ma_tuyenbay = ChuyenBayDTO.getMa_tuyenbay();
		 Date ngaygio = (Date) ChuyenBayDTO.getNgaygio();
		 String thoigianbay = ChuyenBayDTO.getThoigianbay();
		 int soghehang1 = ChuyenBayDTO.getSoghehang1();
		 int soghehang2 = ChuyenBayDTO.getSoghehang2();
		 String ma_mb = ChuyenBayDTO.getMa_mb();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_cb, ma_tuyenbay, ngaygio, thoigianbay, soghehang1, soghehang2, ma_mb };
		 dtm.addRow(row);
	 }
	 tblchuyenbay.setModel(dtm);
	 }
	 /**
	  * Get all dongia to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllDonGia() throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách DonGia
	 String[] header = { "Mã đơn giá", "VND", "USD" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách DonGiaDTO (gọi hàm getAllDonGia() trong DonGiaBLL)
	 ArrayList<DonGiaDTO> arr = new ArrayList<DonGiaDTO>();
	 DonGiaBLL DonGiaBLL = new DonGiaBLL();
	 arr = DonGiaBLL.getAllDonGia();
	 
	 //Duyệt mảng DonGiaDTO vừa lấy được: arr
	 DonGiaDTO DonGiaDTO = new DonGiaDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 DonGiaDTO = arr.get(i);
		 
		 String ma_dongia = DonGiaDTO.getMa_dongia();
		 int VND = DonGiaDTO.getVND();
		 int USD = DonGiaDTO.getUSD();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_dongia, VND, USD };
		 dtm.addRow(row);
	 }
	 tbldongia.setModel(dtm);
	 }
	 /**
	  * Get all hangve to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllHangVe() throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách HangVe
	 String[] header = { "Mã hạng vé", "Tên hạng vé" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách HangVeDTO (gọi hàm getAllHangVe() trong HangVeBLL)
	 ArrayList<HangVeDTO> arr = new ArrayList<HangVeDTO>();
	 HangVeBLL HangVeBLL = new HangVeBLL();
	 arr = HangVeBLL.getAllHangVe();
	 
	 //Duyệt mảng HangVeDTO vừa lấy được: arr
	 HangVeDTO HangVeDTO = new HangVeDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 HangVeDTO = arr.get(i);
		 
		 String ma_hv = HangVeDTO.getMa_hv();
		 String ten_hv = HangVeDTO.getTen_hv();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_hv, ten_hv };
		 dtm.addRow(row);
	 }
	 tblhangve.setModel(dtm);
	 }
	 
	 /**
	  * Get all hangve to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllHoaDon() throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách HoaDon
	 String[] header = { "Mã hóa đơn","Thành tiền", "Ngày lập","Mã khách hàng","Mã nhân viên"};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách HoaDonDTO (gọi hàm getAllHoaDon() trong HoaDonBLL)
	 ArrayList<HoaDonDTO> arr = new ArrayList<HoaDonDTO>();
	 HoaDonBLL HoaDonBLL = new HoaDonBLL();
	 arr = HoaDonBLL.getAllHoaDon();
	 
	 //Duyệt mảng HoaDonDTO vừa lấy được: arr
	 HoaDonDTO HoaDonDTO = new HoaDonDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 HoaDonDTO = arr.get(i);
		 
		 String ma_hd = HoaDonDTO.getMa_hd();
		 int thanh_tien = HoaDonDTO.getThanh_tien();
		 Date ngay_lap = HoaDonDTO.getNgay_Lap();
		 String ma_kh = HoaDonDTO.getMa_kh();
		 String ma_nv = HoaDonDTO.getMa_nv();
		 
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_hd, thanh_tien, ngay_lap, ma_kh, ma_nv };
		 dtm.addRow(row);
	 }
	 tblHoadon.setModel(dtm);
	 }
	 
	 /**
	  * Get all phieudatcho to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllPhieuDatCho() throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách PhieuDatCho
	 String[] header = {"Mã phiếu","Mã vé chuyến bay","Ngày đặt","Số Ghế"};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách PhieuDatChoDTO (gọi hàm getAllPhieuDatCho() trong PhieuDatChoBLL)
	 ArrayList<PhieuDatChoDTO> arr = new ArrayList<PhieuDatChoDTO>();
	 PhieuDatChoBLL PhieuDatChoBLL = new PhieuDatChoBLL();
	 arr = PhieuDatChoBLL.getAllPhieuDatCho();
	 
	 //Duyệt mảng PhieuDatChoDTO vừa lấy được: arr
	 PhieuDatChoDTO PhieuDatChoDTO = new PhieuDatChoDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 PhieuDatChoDTO = arr.get(i);
		 
		 String ma_phieu = PhieuDatChoDTO.getMa_phieu();
		 String ma_ve_cb = PhieuDatChoDTO.getMa_ve_cb();
		 Date ngay_dat = (Date) PhieuDatChoDTO.getNgaydat();
		 int so_ghe = (int) PhieuDatChoDTO.getSoghe();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_phieu, ma_ve_cb, ngay_dat, so_ghe };
		 dtm.addRow(row);
	 }
	 tblphieudatcho.setModel(dtm);
	 }
	 
	 /**
	  * Get all sanbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllSanBay() throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách SanBay
	 String[] header = { "Mã sân bay", "Tên sân bay" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách SanBayDTO (gọi hàm getAllSanBay() trong SanBayBLL)
	 ArrayList<SanBayDTO> arr = new ArrayList<SanBayDTO>();
	 SanBayBLL SanBayBLL = new SanBayBLL();
	 arr = SanBayBLL.getAllSanBay();
	 
	 //Duyệt mảng SanBayDTO vừa lấy được: arr
	 SanBayDTO SanBayDTO = new SanBayDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 SanBayDTO = arr.get(i);
		 
		 String ma_sb = SanBayDTO.getMa_sb();
		 String ten_sb = SanBayDTO.getTen_sb();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_sb, ten_sb };
		 dtm.addRow(row);
	 }
	 tblsanbay.setModel(dtm);
	 }
	 
	 /**
	  * Get all maybay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllMayBay() throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách MayBay
	 String[] header = { "Mã máy bay", "Tên máy bay" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách MayBayDTO (gọi hàm getAllMayBay() trong MayBayBLL)
	 ArrayList<MayBayDTO> arr = new ArrayList<MayBayDTO>();
	 MayBayBLL MayBayBLL = new MayBayBLL();
	 arr = MayBayBLL.getAllMayBay();
	 
	 //Duyệt mảng MayBayDTO vừa lấy được: arr
	 MayBayDTO MayBayDTO = new MayBayDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 MayBayDTO = arr.get(i);
		 
		 String ma_mb = MayBayDTO.getMa_mb();
		 String ten_mb = MayBayDTO.getTen_mb();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_mb, ten_mb };
		 dtm.addRow(row);
	 }
	 tblmaybay.setModel(dtm);
	 }
	 
	 /**
	  * Get all vechuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllVeChuyenBay() throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách VeChuyenBay
	 String[] header = { "Mã vé","Mã hóa đơn","Mã chuyến bay","Mã đơn giá","Mã hạng vé","Tình Trạng" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách VeChuyenBayDTO (gọi hàm getAllVeChuyenBay() trong HVeChuyenBayBLL)
	 ArrayList<VeChuyenBayDTO> arr = new ArrayList<VeChuyenBayDTO>();
	 VeChuyenBayBLL VeChuyenBayBLL = new VeChuyenBayBLL();
	 arr = VeChuyenBayBLL.getAllVeChuyenBay();
	 
	 //Duyệt mảng HoaDonDTO vừa lấy được: arr
	 VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 VeChuyenBayDTO = arr.get(i);
		 
		 String ma_ve_cb = VeChuyenBayDTO.getMa_ve_cb();
		 String ma_hd = VeChuyenBayDTO.getMa_hd();
		 String ma_cb = VeChuyenBayDTO.getMa_cb();
		 String ma_dongia = VeChuyenBayDTO.getMa_dongia();
		 String ma_hv = VeChuyenBayDTO.getMa_hv();
		 String tinh_trang = VeChuyenBayDTO.getTinhtrangve();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_ve_cb, ma_hd, ma_cb, ma_dongia, ma_hv, tinh_trang};
		 dtm.addRow(row);
	 }
	 tblvechuyenbay.setModel(dtm);
	 }
	 
	 /**
	  * Get all vechuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllTuyenBay() throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách tuyenBay
	 String[] header = { "Mã tuyến bay","Sân bay đi", "Sân bay đến" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách TuyenBayDTO (gọi hàm getAllTuyenBay() trong TuyenBayBLL)
	 ArrayList<TuyenBayDTO> arr = new ArrayList<TuyenBayDTO>();
	 TuyenBayBLL tuyenBayBLL = new TuyenBayBLL();
	 arr = tuyenBayBLL.getAllTuyenBay();
	 
	 //Duyệt mảng TuyenbayDTO vừa lấy được: arr
	 TuyenBayDTO TuyenBayDTO = new TuyenBayDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 TuyenBayDTO = arr.get(i);
		 
		 String ma_tb = TuyenBayDTO.getMa_tuyenbay();
		 String sb_di = TuyenBayDTO.getSanbaydi();
		 String sb_den = TuyenBayDTO.getSanbayden();

		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_tb, sb_di,sb_den };
		 dtm.addRow(row);
	 }
	 tbltuyenbay.setModel(dtm);
	 }
}
