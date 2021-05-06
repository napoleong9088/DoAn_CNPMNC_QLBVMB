package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL.ChuyenBayBLL;
import BLL.HoaDonBLL;
import BLL.KhachHangBLL;
import BLL.VeChuyenBayBLL;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.VeChuyenBayDTO;

import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class Option extends JFrame {
	private JPanel contentPane;
	private JTextField txtchuyenbayid;
	private JTextField txtngaygio;
	private JTextField txtmaybayname;
	private JTextField txtgheh1;
	private JTextField txtgia;
	private JTextField txtsanbaydiname;
	private JTextField txtsanbaydenname;
	private JTextField txtcmndpp;
	private JTextField txtsdtkh;
	private JTextField txtmavecb;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private String diem_di;
	private String diem_den;
        private Date ngay;
        private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        private String diemdis[] = {"SGN", "HAN", "DAD", "PQC" };
        private String diemdens[] = {"SGN", "HAN", "DAD", "PQC" };

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Option frame = new Option();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Option() throws ClassNotFoundException {
		font();
		searchChuyenBay(diem_di, diem_den, ngay);
		loadAllKhachHangByCmnd(txtcmndpp.getText());
		loadAllKhachHangBySDT(txtsdtkh.getText());
	}
	
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public void font() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 547, 388);
		tabbedPane.setBackground(new Color(57,153,255));
		tabbedPane.setForeground(Color.WHITE);
		contentPane.add(tabbedPane);
		
		
		/*Button button = new Button("MUA VÉ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thanhtoan tt;
				try {
					tt = new Thanhtoan();
					tt.setVisible(true);
					
					ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
					KhachHangBLL khbll = new KhachHangBLL();
					KhachHangDTO khDto =new KhachHangDTO();
					kh = khbll.getKhachHangByma_kh(khDto);
					
					khDto.setSDT(txtsdtkh.getText());
					kh = khbll.getKhachHangBySDT(khDto);
					khDto = kh.get(0);
					khDto.setTen_kh(khDto.getTen_kh());
					khDto.setCmnd(khDto.getCmnd());
					khDto.setSDT(khDto.getSDT());
					khDto.setDiaChi(khDto.getDiaChi());
					tt.getkh(khDto);
					
					ArrayList<ChuyenBayDTO> cb = new ArrayList<ChuyenBayDTO>();
					ChuyenBayBLL cbbll = new ChuyenBayBLL();
					ChuyenBayDTO cbDto =new ChuyenBayDTO();
					
					
					cbDto.setMaChuyenbay(txtchuyenbayid.getText());
					cb = cbbll.getChuyenBayByma_cb(cbDto);
					cbDto=cb.get(0);
					tt.getcb(cbDto);
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		button.setBounds(440, 30, 80, 50);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(new Color(57,153,255));
		button.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(330, 59, 85, 20);*/
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tìm kiếm chuyến bay", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lbldiemdi = new JLabel("Điểm đi:");
		lbldiemdi.setBounds(10, 37, 50, 14);
		panel_2.add(lbldiemdi);
		
		JLabel lbldiemden = new JLabel("Điểm đến:");
		lbldiemden.setBounds(224, 37, 63, 14);
		panel_2.add(lbldiemden);
                
                JLabel lblngaybay = new JLabel("Ngày:");
		lblngaybay.setBounds(224, 64, 63, 14);
		panel_2.add(lblngaybay);
		
		JComboBox comboBox = new JComboBox(diemdis);
		
		comboBox.setBounds(67, 33, 100, 20);
		comboBox.setBackground(Color.WHITE);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(diemdens);
		comboBox_1.setBounds(297, 33, 100, 20);
		comboBox_1.setBackground(Color.WHITE);
		panel_2.add(comboBox_1);
                
                JTextField txtngaybay = new JTextField();
                txtngaybay.setBounds(297, 60, 100, 20);
                panel_2.add(txtngaybay);
		
		JButton btnNewButton = new JButton("Tìm Vé");
		btnNewButton.setBounds(431, 15, 89, 23);
		btnNewButton.setBackground(new Color(57,153,255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				diem_di = (String) comboBox.getSelectedItem();
				diem_den = (String) comboBox_1.getSelectedItem();
                            try {
                                ngay = formatter.parse(txtngaybay.getText().toString());
                            } catch (ParseException ex) {
                                Logger.getLogger(Option.class.getName()).log(Level.SEVERE, null, ex);
                            }
				try {
					searchChuyenBay(diem_di, diem_den, ngay);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 110, 522, 196);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter() {
			 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = table_1.getSelectedRow();
			 if (row != -1) {
			 txtchuyenbayid.setText(table_1.getValueAt(row, 0).toString());
			 txtmaybayname.setText(table_1.getValueAt(row, 1).toString());
			 txtngaygio.setText(table_1.getValueAt(row, 2).toString());				
			 textField.setText(table_1.getValueAt(row, 3).toString());
			 txtsanbaydiname.setText(table_1.getValueAt(row, 4).toString());
			 txtsanbaydenname.setText(table_1.getValueAt(row, 5).toString());
			 txtgheh1.setText(table_1.getValueAt(row, 6).toString());
			 txtgia.setText(table_1.getValueAt(row, 7).toString());
			 }
			 }
			 });
		
		JButton btnNewButton_1 = new JButton("Mua vé");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thanhtoan tt;
				try {
					tt = new Thanhtoan();
					tt.setVisible(true);
					
					ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
					KhachHangBLL khbll = new KhachHangBLL();
					KhachHangDTO khDto =new KhachHangDTO();
					kh = khbll.getKhachHangByma_kh(khDto);
					
					khDto.setSDT(txtsdtkh.getText());
					kh = khbll.getKhachHangBySDT(khDto);
					khDto = kh.get(0);
					khDto.setTen_kh(khDto.getTen_kh());
					khDto.setCmnd(khDto.getCmnd());
					khDto.setSDT(khDto.getSDT());
					khDto.setDiaChi(khDto.getDiaChi());
					tt.getkh(khDto);
					
					ChuyenBayBLL cbbll = new ChuyenBayBLL();
					ChuyenBayDTO cbDto =new ChuyenBayDTO();
					
					cbDto.setMaChuyenbay(txtchuyenbayid.getText());
					tt.getcb(cbDto);
				} catch (Exception e1) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton_1.setBounds(431, 54, 89, 23);
		btnNewButton_1.setBackground(new Color(57,153,255));
		btnNewButton_1.setForeground(Color.WHITE);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Tìm kiếm thông tin khách hàng", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 45, 522, 101);
		panel_1.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_18 = new JLabel("___Thông tin khách hàng___");
		lblNewLabel_18.setBounds(145, 15, 600, 20);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_18);
		
		txtcmndpp = new JTextField();
		txtcmndpp.setBounds(150, 165, 150, 20);
		panel_1.add(txtcmndpp);
		txtcmndpp.setColumns(10);
		
		JLabel lblcmndpp = new JLabel("CMND/PASSPORT:");
		lblcmndpp.setBounds(20, 168, 130, 14);
		panel_1.add(lblcmndpp);
		
		JLabel lblsdtkh = new JLabel("SĐT:");
		lblsdtkh.setBounds(20, 222, 100, 20);
		panel_1.add(lblsdtkh);
		
		txtsdtkh = new JTextField();
		txtsdtkh.setColumns(10);
		txtsdtkh.setBounds(150, 222, 150, 20);
		panel_1.add(txtsdtkh);
		
		JLabel lblmavecb = new JLabel("Mã vé:");
		lblmavecb.setBounds(20, 279, 100, 20);
		panel_1.add(lblmavecb);
		
		txtmavecb = new JTextField();
		txtmavecb.setColumns(10);
		txtmavecb.setBounds(150, 279, 150, 20);
		panel_1.add(txtmavecb);
		
		Button button_1 = new Button("Check");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadAllKhachHangByCmnd(txtcmndpp.getText());
					;
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(355, 155, 70, 30);
		button_1.setBackground(new Color(57,153,255));
		button_1.setForeground(Color.WHITE);
		panel_1.add(button_1);
		
		Button button_1_1 = new Button("Check");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadAllKhachHangBySDT(txtsdtkh.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1_1.setBounds(355, 222, 70, 30);
		button_1_1.setBackground(new Color(57,153,255));
		button_1_1.setForeground(Color.WHITE);
		panel_1.add(button_1_1);
		
		Button button_1_2 = new Button("Check");
		button_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadAllKhachHangByma_cb(txtmavecb.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1_2.setBounds(355, 279, 70, 30);
		button_1_2.setBackground(new Color(57,153,255));
		button_1_2.setForeground(Color.WHITE);
		panel_1.add(button_1_2);
		
	}

	/**
	  * Get all chuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllChuyenBay() throws ClassNotFoundException {
		 //táº¡o control DefaultTableModel Ä‘á»ƒ hiá»ƒn thá»‹ danh sÃ¡ch ChuyenBay
	 String[] header = { "MA CB", "HANG HK", "TEN", "DIEM DI", "DIEM DEN", "SB DI", "SB DEN", "GIO", "NGAY", "LOAI GHE", "GIA", "QUY DINH" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //láº¥y danh sÃ¡ch ChuyenBayDTO (gá»�i hÃ m getAllChuyenBay() trong ChuyenBayBLL)
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 arr = ChuyenBayBLL.getAllChuyenBay();
	 
	 //Duyá»‡t máº£ng ChuyenBayDTO vá»«a láº¥y Ä‘Æ°á»£c: arr
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
		 java.util.Date ngay = ChuyenBayDTO.getNgayBay();
		 Time gio = ChuyenBayDTO.getGioBay();
		 String loaighe = ChuyenBayDTO.getLoaiGhe();
		 int gia = ChuyenBayDTO.getGia();
		 String quydinh = ChuyenBayDTO.getQuyDinh();
		 //táº¡o row Ä‘á»ƒ add vÃ o control DefaultTableModel
		 Object[] row = { ma_cb, hang_HK, ten, di, den, sb_di, sb_den, ngay, gio, loaighe, gia, quydinh };
		 dtm.addRow(row);
	 }
	 table.setModel(dtm);
	 }
	 
	 /**
	  * Get all chuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void searchChuyenBay( String di, String den, Date ngay) throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "MA CB", "HANG HK", "TEN", "DIEM DI", "DIEM DEN", "SB DI", "SB DEN", "GIO", "NGAY", "LOAI GHE", "GIA", "QUY DINH"};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách ChuyenBayDTO (gọi hàm getAllChuyenBay() trong ChuyenBayBLL)
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
         arr = ChuyenBayBLL.getChuyenBayBydiem(ChuyenBayDTO);

	 for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
		 
		 String ma_cb = ChuyenBayDTO.getMaChuyenbay();
		 String hang_HK = ChuyenBayDTO.getHangHK();
                 String ten = ChuyenBayDTO.getTenMayBay();
                 String diemdi = ChuyenBayDTO.getDiemDi();
                 String diemden = ChuyenBayDTO.getDiemDen();
                 String sb_di = ChuyenBayDTO.getSanBayDi();
                 String sb_den = ChuyenBayDTO.getSanBayDen();
		 Date ngaybay = ChuyenBayDTO.getNgayBay();
		 Time gio = ChuyenBayDTO.getGioBay();
		 String loaighe = ChuyenBayDTO.getLoaiGhe();
		 int gia = ChuyenBayDTO.getGia();
		 String quydinh = ChuyenBayDTO.getQuyDinh();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_cb, hang_HK, ten, diemdi, diemden, sb_di, sb_den, ngaybay, gio, loaighe, gia, quydinh };
		 dtm.addRow(row);
	 }
	 table_1.setModel(dtm);
	 }
	 /**
	  * Get all chuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllKhachHangByCmnd(String CMND) throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "Ten KH","SDT", "CMND/PP","Ma CB","NgayBay","Gio","Diem di","Diem den",};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);

	 ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
	 KhachHangBLL khbll = new KhachHangBLL();
	 KhachHangDTO khDto =new KhachHangDTO();
	 khDto.setCmnd(CMND);
	 kh = khbll.getKhachHangByCMND_PP(khDto);
	 
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 
	 ArrayList<VeChuyenBayDTO> vcb = new ArrayList<VeChuyenBayDTO>();
	 VeChuyenBayBLL VeChuyenBayBLL = new VeChuyenBayBLL();
	 VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
	

	 try {
	 for (int i = 0; i < kh.size(); i++) {
		 khDto = kh.get(i);
		 
		 String ma_kh = khDto.getMa_kh();
		 String ten_kh = khDto.getTen_kh();
		 String sdt = khDto.getSDT();
		 String cmnd = khDto.getCmnd();
                 String ma_cb = null;
		
                 VeChuyenBayDTO.setMa_kh(ma_kh);
                 vcb = VeChuyenBayBLL.getVeChuyenBayByma_kh(VeChuyenBayDTO);
                 for (int j = 0; j < vcb.size(); j++) {
		 VeChuyenBayDTO = vcb.get(j);
		 
		 ma_cb = VeChuyenBayDTO.getMa_cb();
                 }
                 
                 
		 ChuyenBayDTO.setMaChuyenbay(ma_cb);
		 arr = ChuyenBayBLL.getChuyenBayByma_cb(ChuyenBayDTO);
		 ChuyenBayDTO=arr.get(0);
                 
		 Date ngay = ChuyenBayDTO.getNgayBay();
		 Time thoigianbay = ChuyenBayDTO.getGioBay();

		 String diem_di = ChuyenBayDTO.getDiemDi();
		 String diem_den = ChuyenBayDTO.getDiemDen();
		 //tạo row để add vào control DefaultTableModel*/
		 Object[] row = { ten_kh, sdt,cmnd,ma_cb, ngay, thoigianbay, diem_di,diem_den };
		 dtm.addRow(row);
                 if(row.length<1) {
                     JOptionPane.showMessageDialog(null,"dữ Liệu trùng hoặc không tìm thấy ","",JOptionPane.ERROR_MESSAGE);
                 }
	 }	
	 }catch (Exception e) {
	 }
	 table_2.setModel(dtm);
	 }
	 public void loadAllKhachHangBySDT(String SDT) throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "Ten KH","SDT", "CMND/PP","Ma CB","NgayBay","Gio","Diem di","Diem den",};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);

	 ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
	 KhachHangBLL khbll = new KhachHangBLL();
	 KhachHangDTO khDto =new KhachHangDTO();
	 khDto.setSDT(SDT);
	 kh = khbll.getKhachHangBySDT(khDto);
	 
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 
	 ArrayList<VeChuyenBayDTO> vcb = new ArrayList<VeChuyenBayDTO>();
	 VeChuyenBayBLL VeChuyenBayBLL = new VeChuyenBayBLL();
	 VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
	

	 try {
	 for (int i = 0; i < kh.size(); i++) {
		 khDto = kh.get(i);
		 
		 String ma_kh = khDto.getMa_kh();
		 String ten_kh = khDto.getTen_kh();
		 String sdt = khDto.getSDT();
		 String cmnd = khDto.getCmnd();
                 String ma_cb = null;
		
                 VeChuyenBayDTO.setMa_kh(ma_kh);
                 vcb = VeChuyenBayBLL.getVeChuyenBayByma_kh(VeChuyenBayDTO);
                 for (int j = 0; j < vcb.size(); j++) {
		 VeChuyenBayDTO = vcb.get(j);
		 
		 ma_cb = VeChuyenBayDTO.getMa_cb();
                 }
                 
                 
		 ChuyenBayDTO.setMaChuyenbay(ma_cb);
		 arr = ChuyenBayBLL.getChuyenBayByma_cb(ChuyenBayDTO);
		 ChuyenBayDTO=arr.get(0);
                 
		 Date ngay = ChuyenBayDTO.getNgayBay();
		 Time thoigianbay = ChuyenBayDTO.getGioBay();

		 String diem_di = ChuyenBayDTO.getDiemDi();
		 String diem_den = ChuyenBayDTO.getDiemDen();
		 //tạo row để add vào control DefaultTableModel*/
		 Object[] row = { ten_kh, sdt,cmnd,ma_cb, ngay, thoigianbay, diem_di,diem_den };
		 dtm.addRow(row);
                 if(row.length<1) {
                     JOptionPane.showMessageDialog(null,"dữ Liệu trùng hoặc không tìm thấy ","",JOptionPane.ERROR_MESSAGE);
                 }
	 }
	 } catch (Exception e) {
		 JOptionPane.showMessageDialog(null,"dữ Liệu trùng hoặc không tìm thấy ","Pesan",JOptionPane.ERROR_MESSAGE);
	}
	 table_2.setModel(dtm);
	 }
	 public void loadAllKhachHangByma_cb(String macb ) throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "Ten KH","SDT", "CMND/PP","Ma CB","NgayBay","Gio","Diem di","Diem den",};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);

	 ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
	 KhachHangBLL khbll = new KhachHangBLL();
	 KhachHangDTO khDto =new KhachHangDTO();
	 
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 ChuyenBayDTO.setMaChuyenbay(macb);
	 arr = ChuyenBayBLL.getChuyenBayByma_cb(ChuyenBayDTO);
	 
	 
	 ArrayList<VeChuyenBayDTO> vcb = new ArrayList<VeChuyenBayDTO>();
	 VeChuyenBayBLL VeChuyenBayBLL = new VeChuyenBayBLL();
	 VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
	 
	 try {
	 for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
		 	 
		 Date ngaygio = ChuyenBayDTO.getNgayBay();
		 Time thoigianbay = ChuyenBayDTO.getGioBay();
		 String ma_cb = ChuyenBayDTO.getMaChuyenbay();
                 String diem_di = ChuyenBayDTO.getDiemDi();
		 String diem_den = ChuyenBayDTO.getDiemDen();
		 
		 VeChuyenBayDTO.setMa_cb(ma_cb);
		 vcb = VeChuyenBayBLL.getVeChuyenBayByma_cb(VeChuyenBayDTO);
		 VeChuyenBayDTO=vcb.get(0);
		 String ma_ve_cb = VeChuyenBayDTO.getMa_ve_cb();
		 String ma_kh = VeChuyenBayDTO.getMa_kh();
		 
		 khDto.setMa_kh(ma_kh);
		 kh = khbll.getKhachHangByma_kh(khDto);
		 khDto = kh.get(0);
		 String ten_kh = khDto.getTen_kh();
		 String sdt = khDto.getSDT();
		 String cmnd = khDto.getCmnd();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_kh,ten_kh, sdt,cmnd,ma_cb,ngaygio, thoigianbay,diem_di,diem_den };
		 dtm.addRow(row);
                 if(row.length<1) {
                     JOptionPane.showMessageDialog(null,"dữ Liệu trùng hoặc không tìm thấy ","",JOptionPane.ERROR_MESSAGE);
                 }
	 }
	 } catch (Exception e) {
		 JOptionPane.showMessageDialog(null,"dữ Liệu trùng hoặc không tìm thấy ","Pesan",JOptionPane.ERROR_MESSAGE);
	 }
	 table_2.setModel(dtm);
	 }
	 public void getkh(KhachHangDTO khDto) throws ClassNotFoundException {
			/*ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
			KhachHangBLL khbll = new KhachHangBLL();
			kh = khbll.getKhachHangByEmail(khDto);
			txtkhachhangname.setText(khDto.getTen_kh());
			txtkhachhangemail.setText(khDto.getEmail());
			txtdiachikh.setText(khDto.getDiaChi());
			txtcmndpp.setText(khDto.getCmnd());*/
			txtsdtkh.setText(khDto.getSDT());
		}
         /*public void getdiem(){
             try {
             ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
            ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
            ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
            arr = ChuyenBayBLL.getAllChuyenBay();
            diemdis = new String[10];
            diemdens = new String[10];
            for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
                 diemdis[0] = ChuyenBayDTO.getDiemDi().toString();
                 System.out.println(diemdis[0]);
                 diemdis[0] = ChuyenBayDTO.getDiemDi().toString();
                 int temp=0;
                 for(int j =0; j< diemdis.length;j++){
                     if(diemdis[j].equals(ChuyenBayDTO.getDiemDi().toString())){
                         temp++;
                     }
                 }
                 if(temp==0)
                     diemdis[diemdis.length+1] = ChuyenBayDTO.getDiemDi().toString();
                 int temp1=0;
                 for(int j =0; j< diemdens.length;j++){
                     if(diemdens[j].equals(ChuyenBayDTO.getDiemDen().toString())){
                         temp1++;
                     }
                 }
                 if(temp1==0){
                     diemdens[diemdens.length+1] = ChuyenBayDTO.getDiemDen().toString();
                 }
            }
                 System.out.println(diemdis);
                 System.out.println(diemdens);
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Option.class.getName()).log(Level.SEVERE, null, ex);
            }
         }*/
}
