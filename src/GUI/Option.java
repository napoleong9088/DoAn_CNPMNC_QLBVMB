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
import BLL.MayBayBLL;
import BLL.SanBayBLL;
import BLL.TuyenBayBLL;
import BLL.VeChuyenBayBLL;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.MayBayDTO;
import DTO.SanBayDTO;
import DTO.TuyenBayDTO;
import DTO.VeChuyenBayDTO;

import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class Option extends JFrame {
	private JPanel contentPane;
	private JTextField txtchuyenbayid;
	private JTextField txtngaygio;
	private JTextField txtmaybayname;
	private JTextField txtgheh1;
	private JTextField txtgheh2;
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
		loadAllChuyenBay();
		loadAllChuyenBayBydiem(diem_di, diem_den);
		//loadAllKhachHangByCmnd(txtcmndpp.getText());
		//loadAllKhachHangBySDT(txtsdtkh.getText());
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
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Lịch bay", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblchuyenbay = new JLabel("__Chuyến bay________________________________________");
		lblchuyenbay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblchuyenbay.setBounds(10, 10, 420, 14);
		panel.add(lblchuyenbay);
		
		JLabel lblchuyenbayid = new JLabel("Mã chuyến bay:");
		lblchuyenbayid.setBounds(10, 35, 100, 14);
		panel.add(lblchuyenbayid);
		
		txtchuyenbayid = new JTextField();
		txtchuyenbayid.setBounds(100, 33, 100, 20);
		panel.add(txtchuyenbayid);
		txtchuyenbayid.setColumns(10);
		
		JLabel lblngaygio = new JLabel("Ngày khởi hành:");
		lblngaygio.setBounds(235, 35, 100, 14);
		panel.add(lblngaygio);
		
		txtngaygio = new JTextField();
		txtngaygio.setBounds(330, 33, 85, 20);
		panel.add(txtngaygio);
		txtngaygio.setColumns(10);
		
		JLabel lblmaybay = new JLabel("___Máy bay______________________________________________");
		lblmaybay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblmaybay.setBounds(10, 79, 420, 14);
		panel.add(lblmaybay);
		
		JLabel lbltenmb  = new JLabel("Tên máy bay:");
		lbltenmb.setBounds(10, 103, 75, 14);
		panel.add(lbltenmb);
		
		txtmaybayname = new JTextField();
		txtmaybayname.setBounds(85, 103, 125, 20);
		panel.add(txtmaybayname);
		txtmaybayname.setColumns(10);
		
		JLabel lblgheh1 = new JLabel("Hàng ghế 1:");
		lblgheh1.setBounds(260,105, 75, 14);
		panel.add(lblgheh1);
		
		txtgheh1 = new JTextField();
		txtgheh1.setBounds(330,103, 86, 20);
		panel.add(txtgheh1);
		txtgheh1.setColumns(10);
		
		JLabel lblgheh2 = new JLabel("Hàng ghế 2:");
		lblgheh2.setBounds(260,133, 75, 14);
		panel.add(lblgheh2);
		
		txtgheh2 = new JTextField();
		txtgheh2.setBounds(329,131, 86, 20);
		panel.add(txtgheh2);
		txtgheh2.setColumns(10);
		
		JLabel lblsanbaydi = new JLabel("________Sân bay đi________");
		lblsanbaydi.setBounds(10, 161, 200, 14);
		panel.add(lblsanbaydi);
		
		JLabel lbltensbdi = new JLabel("Tên sân bay:");
		lbltensbdi.setBounds(10, 185, 75, 14);
		panel.add(lbltensbdi);
		
		txtsanbaydiname = new JTextField();
		txtsanbaydiname.setBounds(82, 183, 100, 20);
		panel.add(txtsanbaydiname);
		txtsanbaydiname.setColumns(10);
		
		JLabel lblsanbayden = new JLabel("_______Sân bay đến________");
		lblsanbayden.setBounds(240, 161, 200, 14);
		panel.add(lblsanbayden);
		
		JLabel lbltensbden = new JLabel("Tên sân bay:");
		lbltensbden.setBounds(240, 185, 75, 14);
		panel.add(lbltensbden);
		
		txtsanbaydenname = new JTextField();
		txtsanbaydenname.setBounds(318, 183, 100, 20);
		panel.add(txtsanbaydenname);
		txtsanbaydenname.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(330, 59, 85, 20);
		panel.add(textField);
		
		JLabel lblGioBay = new JLabel("Giờ Bay");
		lblGioBay.setBounds(235, 59, 100, 14);
		panel.add(lblGioBay);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 227, 525, 119);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			 // Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = table.getSelectedRow();
			 if (row != -1) {
			 txtchuyenbayid.setText(table.getValueAt(row, 0).toString());
			 txtmaybayname.setText(table.getValueAt(row, 1).toString());
			 txtngaygio.setText(table.getValueAt(row, 2).toString());				
			 textField.setText(table.getValueAt(row, 3).toString());
			 txtsanbaydiname.setText(table.getValueAt(row, 4).toString());
			 txtsanbaydenname.setText(table.getValueAt(row, 5).toString());
			 txtgheh1.setText(table.getValueAt(row, 6).toString());
			 txtgheh2.setText(table.getValueAt(row, 7).toString());
			 }
			 }
			 });
		
		Button button = new Button("MUA VÉ");
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
					
					
					cbDto.setMa_cb(txtchuyenbayid.getText());
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
		panel.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(330, 59, 85, 20);
		panel.add(textField);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tìm kiếm chuyến bay", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lbldiemdi = new JLabel("Điểm đi:");
		lbldiemdi.setBounds(10, 44, 50, 14);
		panel_2.add(lbldiemdi);
		
		JLabel lbldiemden = new JLabel("Điểm đến:");
		lbldiemden.setBounds(224, 44, 63, 14);
		panel_2.add(lbldiemden);
		
		SanBayDTO sb = new SanBayDTO();
		ArrayList<SanBayDTO> sbs = new ArrayList<SanBayDTO>();
		SanBayBLL sbbll = new SanBayBLL();
		sbs = sbbll.getAllSanBay();
		String[] sanbay = new String[sbs.size()] ;
		for (int i=0; i<sbs.size();i++) {
			sb = sbs.get(i);
			String a = sb.getTen_sb();
			sanbay[i] = a;
		}

		
		JComboBox comboBox = new JComboBox(sanbay);
		
		comboBox.setBounds(67, 41, 100, 20);
		comboBox.setBackground(Color.WHITE);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(sanbay);
		comboBox_1.setBounds(297, 41, 100, 20);
		comboBox_1.setBackground(Color.WHITE);
		panel_2.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Kiểm tra");
		btnNewButton.setBounds(431, 15, 89, 23);
		btnNewButton.setBackground(new Color(57,153,255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				diem_di = (String) comboBox.getSelectedItem();
				diem_den = (String) comboBox_1.getSelectedItem();
				try {
					loadAllChuyenBayBydiem(diem_di, diem_den);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
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
			 txtgheh2.setText(table_1.getValueAt(row, 7).toString());
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
					
					cbDto.setMa_cb(txtchuyenbayid.getText());
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
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "Mã chuyến bay", "Máy Bay","Ngày giờ", "Thời gian bay","Điểm đi","Điểm đến", "Số ghế hạng 1", "Số ghế hạng 2",};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách ChuyenBayDTO (gọi hàm getAllChuyenBay() trong ChuyenBayBLL)
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 arr = ChuyenBayBLL.getAllChuyenBay();
	 
	 //Duyệt mảng ChuyenBayDTO vừa lấy được: arr
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 
	 TuyenBayDTO TuyenBayDTO = new TuyenBayDTO();
	 ArrayList<TuyenBayDTO> tuyenbay = new ArrayList<TuyenBayDTO>();
	 TuyenBayBLL TuyenBayBLL = new TuyenBayBLL();
	 
	 MayBayDTO MayBayDTO = new MayBayDTO();
	 ArrayList<MayBayDTO> maybay = new ArrayList<MayBayDTO>();
	 MayBayBLL MayBayBLL = new MayBayBLL();
	 
	 for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
		 
		 String ma_cb = ChuyenBayDTO.getMa_cb();
		 Date ngaygio = (Date) ChuyenBayDTO.getNgaygio();
		 String thoigianbay = ChuyenBayDTO.getThoigianbay();
		 int soghehang1 = ChuyenBayDTO.getSoghehang1();
		 int soghehang2 = ChuyenBayDTO.getSoghehang2();
		 String ma_mb = ChuyenBayDTO.getMa_mb();
		 String ma_tb = ChuyenBayDTO.getMa_tuyenbay();
		 TuyenBayDTO.setMa_tuyenbay(ma_tb);
		 MayBayDTO.setMa_mb(ma_mb);
		 
		 maybay = MayBayBLL.getMayBayByma_mb(MayBayDTO);
		 MayBayDTO = maybay.get(0);
		 String ten_mb = MayBayDTO.getTen_mb();
		 
		 tuyenbay = TuyenBayBLL.getTuyenBayByma_tuyenbay(TuyenBayDTO);
		 TuyenBayDTO = tuyenbay.get(0);
		 String diem_di = TuyenBayDTO.getSanbaydi();
		 String diem_den = TuyenBayDTO.getSanbayden();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_cb, ten_mb,ngaygio, thoigianbay,diem_di,diem_den, soghehang1, soghehang2 };
		 dtm.addRow(row);
	 }
	 table.setModel(dtm);
	 }
	 
	 /**
	  * Get all chuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllChuyenBayBydiem( String di, String den) throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "Mã chuyến bay", "Máy Bay","Ngày giờ", "Thời gian bay","Điểm đi","Điểm đến", "Số ghế hạng 1", "Số ghế hạng 2"};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lấy danh sách ChuyenBayDTO (gọi hàm getAllChuyenBay() trong ChuyenBayBLL)
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 
		 
	 TuyenBayDTO TuyenBayDTO = new TuyenBayDTO();
	 ArrayList<TuyenBayDTO> tuyenbay = new ArrayList<TuyenBayDTO>();
	 TuyenBayBLL TuyenBayBLL = new TuyenBayBLL();
	 
	 MayBayDTO MayBayDTO = new MayBayDTO();
	 ArrayList<MayBayDTO> maybay = new ArrayList<MayBayDTO>();
	 MayBayBLL MayBayBLL = new MayBayBLL();
	 TuyenBayDTO.setSanbaydi(di);
	 TuyenBayDTO.setSanbayden(den);
	 arr = ChuyenBayBLL.getChuyenBayBydiem(TuyenBayDTO);
	 
	 for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
		 
		 String ma_cb = ChuyenBayDTO.getMa_cb();
		 Date ngaygio = (Date) ChuyenBayDTO.getNgaygio();
		 String thoigianbay = ChuyenBayDTO.getThoigianbay();
		 int soghehang1 = ChuyenBayDTO.getSoghehang1();
		 int soghehang2 = ChuyenBayDTO.getSoghehang2();
		 String ma_mb = ChuyenBayDTO.getMa_mb();
		 String ma_tb = ChuyenBayDTO.getMa_tuyenbay();
		 TuyenBayDTO.setMa_tuyenbay(ma_tb);
		 MayBayDTO.setMa_mb(ma_mb);
		 
		 maybay = MayBayBLL.getMayBayByma_mb(MayBayDTO);
		 MayBayDTO = maybay.get(0);
		 String ten_mb = MayBayDTO.getTen_mb();
		 
		 String diem_di = di;
		 String diem_den = den;
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_cb, ten_mb,ngaygio, thoigianbay,diem_di,diem_den, soghehang1, soghehang2 };
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
	 String[] header = { "Mã khách hàng", "Tên khách hàng","SDT", "CMND/PP","Mã chuyến bay","Ngày","Giờ","Điểm đi","Điểm đến",};
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
	 
	 HoaDonDTO hd = new HoaDonDTO();
	 ArrayList<HoaDonDTO> hds = new ArrayList<HoaDonDTO>();
	 HoaDonBLL hdbll = new HoaDonBLL();
	 
	 TuyenBayDTO TuyenBayDTO = new TuyenBayDTO();
	 ArrayList<TuyenBayDTO> tuyenbay = new ArrayList<TuyenBayDTO>();
	 TuyenBayBLL TuyenBayBLL = new TuyenBayBLL();
	 try {
	 for (int i = 0; i < kh.size(); i++) {
		 khDto = kh.get(i);
		 
		 String ma_kh = khDto.getMa_kh();
		 String ten_kh = khDto.getTen_kh();
		 String sdt = khDto.getSDT();
		 String cmnd = khDto.getCmnd();
		 
		 hd.setMa_kh(ma_kh);
		 hds = hdbll.getHoaDonByma_kh(hd);
		 hd = hds.get(0);
		 String ma_hd = hd.getMa_hd();
		 
		 VeChuyenBayDTO.setMa_hd(ma_hd);
		 vcb = VeChuyenBayBLL.getVeChuyenBayByma_hd(VeChuyenBayDTO);
		 VeChuyenBayDTO=vcb.get(0);
		 String ma_cb = VeChuyenBayDTO.getMa_cb();
		 
		 ChuyenBayDTO.setMa_cb(ma_cb);
		 arr = ChuyenBayBLL.getChuyenBayByma_cb(ChuyenBayDTO);
		 ChuyenBayDTO=arr.get(0);		 
		 Date ngaygio = (Date) ChuyenBayDTO.getNgaygio();
		 String thoigianbay = ChuyenBayDTO.getThoigianbay();
		 String ma_tuyenBay = ChuyenBayDTO.getMa_tuyenbay();
		 
		 TuyenBayDTO.setMa_tuyenbay(ma_tuyenBay);;
		 tuyenbay = TuyenBayBLL.getTuyenBayByma_tuyenbay(TuyenBayDTO);
		 TuyenBayDTO=tuyenbay.get(0);
		 String diem_di = TuyenBayDTO.getSanbaydi();
		 String diem_den = TuyenBayDTO.getSanbayden();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_kh,ten_kh, sdt,cmnd,ma_cb,ngaygio, thoigianbay,diem_di,diem_den };
		 dtm.addRow(row);
	 }	
	 }catch (Exception e) {
	 }
	 table_2.setModel(dtm);
	 }
	 public void loadAllKhachHangBySDT(String SDT) throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "Mã khách hàng", "Tên khách hàng","SDT", "CMND/PP","Mã chuyến bay","Ngày","Giờ","Điểm đi","Điểm đến",};
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
	 
	 HoaDonDTO hd = new HoaDonDTO();
	 ArrayList<HoaDonDTO> hds = new ArrayList<HoaDonDTO>();
	 HoaDonBLL hdbll = new HoaDonBLL();
	 
	 TuyenBayDTO TuyenBayDTO = new TuyenBayDTO();
	 ArrayList<TuyenBayDTO> tuyenbay = new ArrayList<TuyenBayDTO>();
	 TuyenBayBLL TuyenBayBLL = new TuyenBayBLL();
	 try {
	 for (int i = 0; i < kh.size(); i++) {
		 khDto = kh.get(i);
		 
		 String ma_kh = khDto.getMa_kh();
		 String ten_kh = khDto.getTen_kh();
		 String sdt = khDto.getSDT();
		 String cmnd = khDto.getCmnd();
		 
		 hd.setMa_kh(ma_kh);
		 hds = hdbll.getHoaDonByma_kh(hd);
		 hd=hds.get(0);
		 String ma_hd = hd.getMa_hd();
		 
		 VeChuyenBayDTO.setMa_hd(ma_hd);
		 vcb = VeChuyenBayBLL.getVeChuyenBayByma_hd(VeChuyenBayDTO);
		 VeChuyenBayDTO=vcb.get(0);
		 String ma_cb = VeChuyenBayDTO.getMa_cb();
		 
		 ChuyenBayDTO.setMa_cb(ma_cb);
		 arr = ChuyenBayBLL.getChuyenBayByma_cb(ChuyenBayDTO);
		 ChuyenBayDTO=arr.get(0);		 
		 Date ngaygio = (Date) ChuyenBayDTO.getNgaygio();
		 String thoigianbay = ChuyenBayDTO.getThoigianbay();
		 String ma_tuyenBay = ChuyenBayDTO.getMa_tuyenbay();
		 
		 TuyenBayDTO.setMa_tuyenbay(ma_tuyenBay);;
		 tuyenbay = TuyenBayBLL.getTuyenBayByma_tuyenbay(TuyenBayDTO);
		 TuyenBayDTO=tuyenbay.get(0);
		 String diem_di = TuyenBayDTO.getSanbaydi();
		 String diem_den = TuyenBayDTO.getSanbayden();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_kh,ten_kh, sdt,cmnd,ma_cb,ngaygio, thoigianbay,diem_di,diem_den };
		 dtm.addRow(row);
	 }
	 } catch (Exception e) {
		 JOptionPane.showMessageDialog(null,"dữ Liệu trùng hoặc không tìm thấy ","Pesan",JOptionPane.ERROR_MESSAGE);
	}
	 table_2.setModel(dtm);
	 }
	 public void loadAllKhachHangByma_cb(String macb ) throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "Mã khách hàng", "Tên khách hàng","SDT", "CMND/PP","Mã chuyến bay","Ngày","Giờ","Điểm đi","Điểm đến",};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);

	 ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
	 KhachHangBLL khbll = new KhachHangBLL();
	 KhachHangDTO khDto =new KhachHangDTO();
	 
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 ChuyenBayDTO.setMa_cb(macb);
	 arr = ChuyenBayBLL.getChuyenBayByma_cb(ChuyenBayDTO);
	 
	 
	 ArrayList<VeChuyenBayDTO> vcb = new ArrayList<VeChuyenBayDTO>();
	 VeChuyenBayBLL VeChuyenBayBLL = new VeChuyenBayBLL();
	 VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
	 
	 HoaDonDTO hd = new HoaDonDTO();
	 ArrayList<HoaDonDTO> hds = new ArrayList<HoaDonDTO>();
	 HoaDonBLL hdbll = new HoaDonBLL();
	 
	 TuyenBayDTO TuyenBayDTO = new TuyenBayDTO();
	 ArrayList<TuyenBayDTO> tuyenbay = new ArrayList<TuyenBayDTO>();
	 TuyenBayBLL TuyenBayBLL = new TuyenBayBLL();
	 try {
	 for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
		 	 
		 Date ngaygio = (Date) ChuyenBayDTO.getNgaygio();
		 String thoigianbay = ChuyenBayDTO.getThoigianbay();
		 String ma_tuyenBay = ChuyenBayDTO.getMa_tuyenbay();
		 String ma_cb = ChuyenBayDTO.getMa_cb();
		 
		 VeChuyenBayDTO.setMa_cb(ma_cb);
		 vcb = VeChuyenBayBLL.getVeChuyenBayByma_cb(VeChuyenBayDTO);
		 VeChuyenBayDTO=vcb.get(0);
		 String ma_ve_cb = VeChuyenBayDTO.getMa_ve_cb();
		 String ma_hd = VeChuyenBayDTO.getMa_hd();
		 
		 hd.setMa_hd(ma_hd);
		 hds = hdbll.getHoaDonByma_hd(hd);
		 hd=hds.get(0);
		 String ma_kh = hd.getMa_kh();
		 
		 khDto.setMa_kh(ma_kh);
		 kh = khbll.getKhachHangByma_kh(khDto);
		 khDto = kh.get(0);
		 String ten_kh = khDto.getTen_kh();
		 String sdt = khDto.getSDT();
		 String cmnd = khDto.getCmnd();
		 	 
		 
		 
		 TuyenBayDTO.setMa_tuyenbay(ma_tuyenBay);;
		 tuyenbay = TuyenBayBLL.getTuyenBayByma_tuyenbay(TuyenBayDTO);
		 TuyenBayDTO=tuyenbay.get(0);
		 String diem_di = TuyenBayDTO.getSanbaydi();
		 String diem_den = TuyenBayDTO.getSanbayden();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_kh,ten_kh, sdt,cmnd,ma_cb,ngaygio, thoigianbay,diem_di,diem_den };
		 dtm.addRow(row);
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
}
