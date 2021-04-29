package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL.ChuyenBayBLL;
import BLL.HoaDonBLL;
import BLL.KhachHangBLL;
import BLL.TuyenBayBLL;
import BLL.VeChuyenBayBLL;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.TuyenBayDTO;
import DTO.VeChuyenBayDTO;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Action extends JFrame {
	private JPanel contentPane;
	private JTextField txtkhachhangname;
	private JTextField txtcmndpp;
	private JTextField txtkhachhangemail;
	private JTextField txtdiachikh;
	private JTextField txtsdtkh;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Action frame = new Action();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Action() throws ClassNotFoundException {
		font();
		//getkh(khDto);
		//loadAllChuyenBay();
	}

	/**
	 * Create the frame.
	 */
	public void font() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 430, 240);
		tabbedPane.setBackground(new Color(57,153,255));
		tabbedPane.setForeground(Color.WHITE);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Thông tin hành khách", null, panel, null);
		panel.setLayout(null);
		
	
		JLabel lblkhachhang = new JLabel("_Thông tin hành khách____________________\n");
		lblkhachhang.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblkhachhang.setBounds(5, 9,  600, 21);
		lblkhachhang.setForeground(Color.BLACK);
		panel.add(lblkhachhang);
		
		JLabel lbltenkh = new JLabel("Họ và tên:");
		lbltenkh.setBounds(10, 40, 100, 15);
		
		txtkhachhangname = new JTextField();
		txtkhachhangname.setBounds(10, 60, 140, 20);
		txtkhachhangname.setColumns(10);
		
		JLabel lblcmndpp = new JLabel("CMND/Hộ chiếu:");
		lblcmndpp.setBounds(10, 90,100,15);
		
		JLabel lblemailkh = new JLabel("Email:");
		lblemailkh.setBounds(210, 40, 80, 15);
		
		
		txtcmndpp = new JTextField();
		txtcmndpp.setColumns(10);
		txtcmndpp.setBounds(10,110, 150, 20);
		
		
		txtkhachhangemail = new JTextField();
		txtkhachhangemail.setColumns(10);
		txtkhachhangemail.setBounds(210, 60,150,20);
		
		
		JLabel lbldiachikh = new JLabel("Địa chỉ:");
		lbldiachikh.setBounds(210, 90, 86, 15);
		
		
		txtdiachikh = new JTextField();
		txtdiachikh.setColumns(10);
		txtdiachikh.setBounds(210, 110, 150, 20);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("----Thông tin liên lạc----");
		lblNewLabel_1_1_1_1_2.setBounds(14, 152, 300, 14);
		lblNewLabel_1_1_1_1_2.setForeground(Color.black);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblsdtkh = new JLabel("Số ĐT:");
		lblsdtkh.setBounds(10, 178, 86, 14);
		
		
		txtsdtkh = new JTextField();
		txtsdtkh.setColumns(10);
		txtsdtkh.setBounds(60, 175, 94, 20);
		 
		panel.add(lbltenkh);
		panel.add(lblcmndpp);
		panel.add(lblemailkh);
		panel.add(lbldiachikh);
		panel.add(lblsdtkh);
		
		panel.add(txtkhachhangname);
		panel.add(txtcmndpp);
		panel.add(txtkhachhangemail);
		panel.add(txtdiachikh);
		panel.add(txtsdtkh);
		
		panel.setVisible(false);
		
		JButton btnNewButton = new JButton("CẬP NHẬT");
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setBounds(214, 152, 100, 40);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(57,153,255));
		btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			KhachHangDTO kh = new KhachHangDTO();
			kh.setCmnd(txtcmndpp.getText());
			kh.setTen_kh(txtkhachhangname.getText());
			kh.setEmail(txtkhachhangemail.getText());
			kh.setSDT(txtsdtkh.getText());
			kh.setDiaChi(txtdiachikh.getText());
			KhachHangBLL khbll = new KhachHangBLL();
			try {
				int result = khbll.updateKhachHang(kh);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cập nhật thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		panel.add(btnNewButton);
		
		JButton btntV = new JButton("Đặt vé");
		btntV.setForeground(Color.WHITE);
		btntV.setBackground(SystemColor.activeCaptionBorder);
		btntV.setBounds(335, 152, 80, 40);
		btntV.setBackground(new Color(57,153,255));
		btntV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Option option;
				try {
					option = new Option();
					option.setVisible(true);
					try {
						ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
						KhachHangBLL khbll = new KhachHangBLL();
						KhachHangDTO khDto =new KhachHangDTO();
						khDto.setEmail(txtkhachhangemail.getText());
						kh = khbll.getKhachHangByEmail(khDto);
						khDto = kh.get(0);
						khDto.setTen_kh(khDto.getTen_kh());
						khDto.setCmnd(khDto.getCmnd());
						khDto.setSDT(khDto.getSDT());
						khDto.setDiaChi(khDto.getDiaChi());
						option.getkh(khDto);
						} catch (Exception e1) {
							// TODO: handle exception
						}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(btntV);
		
		
		/*JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Lịch sử chuyến bay", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblchuyenbay = new JLabel("Chuyến bay gần nhất ");
		lblchuyenbay.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblchuyenbay.setForeground(Color.BLACK);
		lblchuyenbay.setBounds(10, 7, 500, 21);
		panel_1.add(lblchuyenbay);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 400, 167);
		panel_1.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);*/
	}
	public void getkh(KhachHangDTO khDto) throws ClassNotFoundException {
		/*ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
		KhachHangBLL khbll = new KhachHangBLL();
		kh = khbll.getKhachHangByEmail(khDto);*/
		txtkhachhangname.setText(khDto.getTen_kh());
		txtkhachhangemail.setText(khDto.getEmail());
		txtdiachikh.setText(khDto.getDiaChi());
		txtcmndpp.setText(khDto.getCmnd());
		txtsdtkh.setText(khDto.getSDT());
	}
	/**
	  * Get all chuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllChuyenBay(String kh) throws ClassNotFoundException {
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	 String[] header = { "Mã chuyến bay", "Ngày giờ", "Thời gian bay","Điểm đi","Điểm đến", "Mã máy bay" };
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
	 
	 HoaDonDTO HoaDonDTO = new HoaDonDTO();
	 ArrayList<HoaDonDTO> hoadon = new ArrayList<HoaDonDTO>();
	 HoaDonBLL HoaDonBLL = new BLL.HoaDonBLL();
	 
	 VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
	 ArrayList<VeChuyenBayDTO> vechuyenbay = new ArrayList<VeChuyenBayDTO>();
	 VeChuyenBayBLL VeChuyenBayBLL = new VeChuyenBayBLL(); 
	 
	 ArrayList<KhachHangDTO> khs = new ArrayList<KhachHangDTO>();
	 KhachHangBLL khbll = new KhachHangBLL();
	 KhachHangDTO khDto =new KhachHangDTO();

	 khDto.setEmail(kh);
	 khs = khbll.getKhachHangByEmail(khDto);
	 khDto = khs.get(0);

	 HoaDonDTO.setMa_kh(khDto.getMa_kh());
	 hoadon = HoaDonBLL.getHoaDonByma_kh(HoaDonDTO);
	 HoaDonDTO = hoadon.get(0);
	 
	 VeChuyenBayDTO.setMa_hd(HoaDonDTO.getMa_hd());
	 vechuyenbay = VeChuyenBayBLL.getVeChuyenBayByma_hd(VeChuyenBayDTO);
	 VeChuyenBayDTO = vechuyenbay.get(0);
	 
	 ChuyenBayDTO.setMa_cb(VeChuyenBayDTO.getMa_cb());
	 arr = ChuyenBayBLL.getChuyenBayByma_cb(ChuyenBayDTO);
	 
	 for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
		 
		 String ma_cb = ChuyenBayDTO.getMa_cb();
		 Date ngaygio = (Date) ChuyenBayDTO.getNgaygio();
		 String thoigianbay = ChuyenBayDTO.getThoigianbay();
		 String ma_mb = ChuyenBayDTO.getMa_mb();
		 String ma_tb = ChuyenBayDTO.getMa_tuyenbay();
		 
		 TuyenBayDTO.setMa_tuyenbay(ma_tb);
		 tuyenbay = TuyenBayBLL.getTuyenBayByma_tuyenbay(TuyenBayDTO);
		 TuyenBayDTO = tuyenbay.get(0);
		 String diem_di = TuyenBayDTO.getSanbaydi();
		 String diem_den = TuyenBayDTO.getSanbayden();
		 
		 
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = { ma_cb, ngaygio, thoigianbay,diem_di,diem_den, ma_mb };
		 dtm.addRow(row);
	 }
	 table.setModel(dtm);
	 }
	 public void getlscb(KhachHangDTO kh) throws ClassNotFoundException {
			txtkhachhangemail.setText(kh.getEmail());
			//loadAllChuyenBay(kh.getEmail());
			
		}
}


