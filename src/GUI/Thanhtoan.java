package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Header;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.sql.*;
import java.util.*;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import BLL.ChuyenBayBLL;
import BLL.HoaDonBLL;
import BLL.KhachHangBLL;
import BLL.VeChuyenBayBLL;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.VeChuyenBayDTO;
import UTILS.ConnectionUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.util.PublicCloneable;

public class Thanhtoan extends JFrame{
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table ;
	private JTextField txtma_cb;
        public String hanhLy;
    

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thanhtoan frame = new Thanhtoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Thanhtoan() throws ClassNotFoundException {
		font();
	}
	

	public void  font() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	     contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin chuyến bay \n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 170, 22);
		lblNewLabel.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel,BorderLayout.NORTH);
		
		
		JLabel lblNewLabel_0_1 = new JLabel("_________________________________________________________________________________\n");
		lblNewLabel_0_1.setBounds(8, 15, 600, 22);
		lblNewLabel_0_1.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_0_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("<_Điểm Đi__ __________ \n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(235, 40, 300, 22);
		lblNewLabel_3.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(246, 72, 95, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("__Điểm Đến_> \n");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(387, 39, 120, 22);
		lblNewLabel_3_1.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_3_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(400, 72, 100, 20);
		contentPane.add(textField_3);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JLabel lblNewLabel_7 = new JLabel("Thông tin khách hàng\n");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(10, 145, 200, 22);
		lblNewLabel_7.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("_________________________________________________________________________________\n");
		lblNewLabel_7_1.setBounds(8, 148, 600, 22);
		lblNewLabel_7_1.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8= new JLabel("Họ và tên");
		lblNewLabel_8.setBounds(10, 175, 100, 22);
		contentPane.add(lblNewLabel_8);
		
		
		JLabel lblNewLabel_9= new JLabel("Ví dụ:Nguyễn Văn Thành");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(10, 195, 200, 22);
		contentPane.add(lblNewLabel_9);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 220, 150, 25);
		textField_5.setColumns(10);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_10 = new JLabel("CMND/PP");
		lblNewLabel_10.setBounds(200, 177, 70, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11= new JLabel("Ví dụ:351000000");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(200, 195, 200, 22);
		contentPane.add(lblNewLabel_11);
		
		textField_6 = new JTextField();
		textField_6.setBounds(200, 220, 150, 25);
		textField_6.setColumns(10);
		contentPane.add(textField_6);
	
                JLabel lblThngTinLin = new JLabel("___Thông tin liên hệ___\n");
		lblThngTinLin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThngTinLin.setForeground(new Color(57,153,255));
		lblThngTinLin.setBounds(400, 170, 200, 22);
		contentPane.add(lblThngTinLin);
		
		JLabel lblNewLabel_13 = new JLabel("Số ĐT: \n");
		lblNewLabel_13.setBounds(400, 200, 83, 14);
		contentPane.add(lblNewLabel_13);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(450, 200, 120, 20);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_14 = new JLabel("Email: \n");
		lblNewLabel_14.setBounds(400, 230, 83, 14);
		contentPane.add(lblNewLabel_14);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(450, 230, 120, 20);
		contentPane.add(textField_8);
		
		JLabel lblNewLabel_15 = new JLabel("Chú ý !\n");
		lblNewLabel_15.setBounds(10, 263, 83, 14);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_15.setForeground(Color.RED);
		contentPane.add(lblNewLabel_15);
                
                JLabel lbltong = new JLabel("TỔNG");
		lbltong.setBounds(300, 263, 60, 14);
		lbltong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltong.setForeground(Color.RED);
		contentPane.add(lbltong);
                
                JTextField txttong = new JTextField();
                txttong.setColumns(10);
		txttong.setBounds(350, 263, 100, 20);
                txttong.setEditable(false);
		contentPane.add(txttong);
                
		
		JLabel lblNewLabel_16 = new JLabel("Hành lý xách tay     được "+ hanhLy + " hành lý xách tay.\n");
		lblNewLabel_16.setBounds(10, 290, 500, 17);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_18 = new JLabel("Hành lý ký gửi Mua Thêm");
		lblNewLabel_18.setBounds(10, 315, 170, 17);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_18);

                    JRadioButton radioBtn1 = new JRadioButton("+15kg");
                    JRadioButton radioBtn2 = new JRadioButton("+20kg");
                    JRadioButton radioBtn3 = new JRadioButton("+30kg");
                    radioBtn1.setBounds(190, 315, 80, 17);
                    radioBtn2.setBounds(270, 315, 80, 17);
                    radioBtn3.setBounds(350, 315, 80, 17);

                    ButtonGroup bg = new ButtonGroup();

                    bg.add(radioBtn1);
                    bg.add(radioBtn2);
                    bg.add(radioBtn3);
                    
                    contentPane.add(radioBtn1);
                    contentPane.add(radioBtn2);
                    contentPane.add(radioBtn3);
                    
		JButton btnNewButton = new JButton("THANH TOÁN");
		btnNewButton.setBounds(455, 255, 120, 50);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(57,153,255));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				print(txtma_cb.getText());
				//ex();
			}

		});
         contentPane.add(btnNewButton);
         
         JScrollPane scrollPane = new JScrollPane();
         scrollPane.setBounds(10, 102, 566, 48);
         contentPane.add(scrollPane);
         
        table =new JTable();
        //loadAllChuyenBay();
        scrollPane.setViewportView(table);
        
        txtma_cb = new JTextField();
        txtma_cb.setColumns(10);
        txtma_cb.setBounds(104, 43, 120, 20);
        contentPane.add(txtma_cb);
        
        JLabel tblma_cb = new JLabel("Mã HANG HK");
        tblma_cb.setBounds(10, 43, 100, 14);
        contentPane.add(tblma_cb);
	}
	public void loadChuyenBay(String cb) throws ClassNotFoundException {
		
		 //tạo control DefaultTableModel để hiển thị danh sách ChuyenBay
	  String[] header = { "HANG HK", "TEN", "GIO", "NGAY", "LOAI GHE", "GIA" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //lÃ¡ÂºÂ¥y danh sÃƒÂ¡ch ChuyenBayDTO (gÃ¡Â»ï¿½i hÃƒÂ m getAllChuyenBay() trong ChuyenBayBLL)
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
         ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
         ChuyenBayDTO.setMaChuyenbay(cb);
	 arr = ChuyenBayBLL.getChuyenBayByma_cb(ChuyenBayDTO);
	 
	 //DuyÃ¡Â»â€¡t mÃ¡ÂºÂ£ng ChuyenBayDTO vÃ¡Â»Â«a lÃ¡ÂºÂ¥y Ã„â€˜Ã†Â°Ã¡Â»Â£c: arr
	 
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
                 hanhLy = quydinh;
		 //tÃ¡ÂºÂ¡o row Ã„â€˜Ã¡Â»Æ’ add vÃƒÂ o control DefaultTableModel
		 

            textField_2.setText(di);
            textField_3.setText(den);
            txtma_cb.setText(hang_HK);
            //tạo row để add vào control DefaultTableModel
            Object[] row = { hang_HK, ten, ngay, gio, loaighe, gia };
            dtm.addRow(row);
	 }
	 table.setModel(dtm);
	 }
	public void getkh(KhachHangDTO khDto) throws ClassNotFoundException {
		/*ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();
		KhachHangBLL khbll = new KhachHangBLL();
		kh = khbll.getKhachHangByma_kh(khDto);
		khDto= kh.get(0);*/
		textField_5.setText(khDto.getTen_kh());
		textField_8.setText(khDto.getEmail());
		textField_6.setText(khDto.getCmnd());
		textField_7.setText(khDto.getSDT());
	}
	public void getcb(ChuyenBayDTO cb) throws ClassNotFoundException {
		txtma_cb.setText(cb.getMaChuyenbay());
		loadChuyenBay(cb.getMaChuyenbay());
		
	}
	public void print(String mcb){
		// Tạo đối tượng tài liệu
					Document document = new Document(PageSize.A4, 50, 50, 50, 50);
					HoaDonDTO hdDTO = new HoaDonDTO();
					HoaDonBLL hdBll = new HoaDonBLL();
					ArrayList<VeChuyenBayDTO> list = new ArrayList<VeChuyenBayDTO>();
					VeChuyenBayBLL vcbbll = new VeChuyenBayBLL();
					VeChuyenBayDTO vcbDto =new VeChuyenBayDTO();
					
					vcbDto.setMa_cb(mcb);
					try {
						list = vcbbll.getVeChuyenBayByma_cb(vcbDto);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						String file_name="C:\\Users\\ASUS\\Desktop\\in.pdf";
						// Tạo đối tượng PdfWriter
						PdfWriter.getInstance(document, new FileOutputStream(file_name));
						// Mở file để thực hiện ghi
						document.open(); 
						// Thêm nội dung sử dụng add function
						Paragraph head=new Paragraph("Hóa Đơn");
						head.setAlignment(Paragraph.ALIGN_CENTER);//căn giữa
						document.add(head);
						Paragraph bordertop= new Paragraph("Mã hóa đơn: " +  hdDTO.getMa_hd());
						Paragraph para2= new Paragraph("Tên khách hàng: " + textField_5.getText());
						Paragraph para3= new Paragraph("Ngày lập hóa đơn:" + hdDTO.getNgay_Lap());
						Paragraph para4 = new Paragraph("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						document.add(bordertop);
			            document.add(para2);
			            document.add(para3);
			            document.add(para4);
			            PdfPTable table=new PdfPTable(6);
			            PdfPCell c1 = new PdfPCell(new Phrase("Mã chuyến bay"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("Mã máy bay"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("Ngày giờ"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("Điểm đến"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("Loại vé"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("Thành tiền"));
			            table.addCell(c1);
			            for (int i = 0; i < list.size(); i++) {
			            	vcbDto = list.get(i);
			            	table.addCell(new Phrase(""+vcbDto.getMa_cb()));
			                table.addCell(new Phrase(""+vcbDto.getGia()));
			                table.addCell(new Phrase(""+vcbDto.getMa_ve_cb()));
			                table.addCell(new Phrase(""+hdDTO.getMa_nv()));
			                table.addCell(new Phrase(""+hdDTO.getThanh_tien()));
			            }
			            document.add(table);
			            Paragraph para5 = new Paragraph("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			            document.add(para5);
			            Paragraph para6 = new Paragraph("     Tổng cộng: "+hdDTO.getThanh_tien());
			            document.add(para6);
						// Đóng File
						document.close();
						System.out.println("Write file succes!");
					} catch (FileNotFoundException | DocumentException e) {
						e.printStackTrace();
					}
				}
	public void ex() {
		
		        String jdbcURL = "jdbc:mysql://localhost:3306/qlbvmb";
		        String username = "root";
		        String password = "123456";
		 
		        String excelFilePath = "C:/Users/ASUS/Desktop/ex.xlsx";
		 
		        int batchSize = 20;
		 
		        Connection connection = null;
		 
		        try {
		            long start = System.currentTimeMillis();
		             
		            FileInputStream inputStream = new FileInputStream(excelFilePath);
		 
		            Workbook workbook = new XSSFWorkbook(inputStream);
		 
		            Sheet firstSheet = workbook.getSheetAt(0);
		            Iterator<Row> rowIterator = firstSheet.iterator();
		 
		            connection = DriverManager.getConnection(jdbcURL, username, password);
		            connection.setAutoCommit(false);
		  
		            String sql = "INSERT INTO san_bay (ma_sb,ten_sb) VALUES ( ?, ?)";
		            PreparedStatement statement = connection.prepareStatement(sql);    
		             
		            int count = 0;
		             
		            rowIterator.next(); // skip the header row
		             
		            while (rowIterator.hasNext()) {
		                Row nextRow = rowIterator.next();
		                Iterator<Cell> cellIterator = nextRow.cellIterator();
		 
		                while (cellIterator.hasNext()) {
		                    Cell nextCell = cellIterator.next();
		 
		                    int columnIndex = nextCell.getColumnIndex();
		 
		                    switch (columnIndex) {
		                    case 0:
		                        String ma_sb = nextCell.getStringCellValue();
		                        statement.setString(1, ma_sb);
		                        break;
		                    case 1:
		                    	String ten_sb = nextCell.getStringCellValue();
		                        statement.setString(1, ten_sb);
		 
		                }
		                 
		                statement.addBatch();
		                 
		                if (count % batchSize == 0) {
		                    statement.executeBatch();
		                }              
		 
		            }
		 
		            workbook.close();
		             
		            // execute the remaining queries
		            statement.executeBatch();
		  
		            connection.commit();
		            connection.close();
		             
		            long end = System.currentTimeMillis();
		            System.out.printf("Import done in %d ms\n", (end - start));
		             
		        }} catch (IOException ex1) {
		            System.out.println("Error reading file");
		            ex1.printStackTrace();
		        } catch (SQLException ex2) {
		            System.out.println("Database error");
		            ex2.printStackTrace();
		        }
		 
	}
		
	
}