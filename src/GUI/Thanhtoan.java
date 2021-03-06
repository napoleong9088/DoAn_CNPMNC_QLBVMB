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
import BLL.MayBayBLL;
import BLL.TuyenBayBLL;
import BLL.UserBLL;
import BLL.VeChuyenBayBLL;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.MayBayDTO;
import DTO.TuyenBayDTO;
import DTO.UserDTO;
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

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		//loadAllChuyenBay();
		//getkh(khDto);
	}
	

	public void  font() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	     contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th??ng tin chuy???n bay \n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 170, 22);
		lblNewLabel.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel,BorderLayout.NORTH);
		
		
		JLabel lblNewLabel_0_1 = new JLabel("_________________________________________________________________________________\n");
		lblNewLabel_0_1.setBounds(8, 15, 600, 22);
		lblNewLabel_0_1.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_0_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("<_??i???m ??i__ __________ \n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(235, 40, 300, 22);
		lblNewLabel_3.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(246, 72, 95, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("__??i???m ?????n_> \n");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(387, 39, 120, 22);
		lblNewLabel_3_1.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_3_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(400, 72, 100, 20);
		contentPane.add(textField_3);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JLabel lblNewLabel_7 = new JLabel("Th??ng tin kh??ch h??ng\n");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(10, 145, 200, 22);
		lblNewLabel_7.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("_________________________________________________________________________________\n");
		lblNewLabel_7_1.setBounds(8, 148, 600, 22);
		lblNewLabel_7_1.setForeground(new Color(57,153,255));
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8= new JLabel("H??? v?? t??n");
		lblNewLabel_8.setBounds(10, 175, 100, 22);
		contentPane.add(lblNewLabel_8);
		
		
		JLabel lblNewLabel_9= new JLabel("V?? d???:Nguy???n V??n Th??nh");
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
		
		JLabel lblNewLabel_11= new JLabel("V?? d???:351000000");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(200, 195, 200, 22);
		contentPane.add(lblNewLabel_11);
		
		textField_6 = new JTextField();
		textField_6.setBounds(200, 220, 150, 25);
		textField_6.setColumns(10);
		contentPane.add(textField_6);
	
     	JLabel lblThngTinLin = new JLabel("___Th??ng tin li??n h???___\n");
		lblThngTinLin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThngTinLin.setForeground(new Color(57,153,255));
		lblThngTinLin.setBounds(400, 170, 200, 22);
		contentPane.add(lblThngTinLin);
		
		JLabel lblNewLabel_13 = new JLabel("S??? ??T: \n");
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
		
		JLabel lblNewLabel_15 = new JLabel("Ch?? ?? !\n");
		lblNewLabel_15.setBounds(10, 263, 83, 14);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_15.setForeground(Color.RED);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("H??nh l?? x??ch tay     M???i h??nh kh??ch ???????c ??em t???i ??a 7kg h??nh l?? x??ch tay.\n");
		lblNewLabel_16.setBounds(10, 290, 500, 17);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_18 = new JLabel("H??nh l?? k?? g???i         M???i h??nh kh??ch ???????c ??em t???i ??a 20kg h??nh l?? k?? g???i.\n");
		lblNewLabel_18.setBounds(10, 315, 500, 17);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_18);
		
		JButton btnNewButton = new JButton("THANH TO??N");
		btnNewButton.setBounds(455, 285, 120, 50);
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
        
        JLabel tblma_cb = new JLabel("M?? chuy???n bay");
        tblma_cb.setBounds(10, 43, 100, 14);
        contentPane.add(tblma_cb);
	}
	public void loadAllChuyenBay(String cb) throws ClassNotFoundException {
		
		 //t???o control DefaultTableModel ????? hi???n th??? danh s??ch ChuyenBay
	 String[] header = { "M?? chuy???n bay", "M??y Bay","Ng??y gi???", "Th???i gian bay","??i???m ??i","??i???m ?????n"};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //l???y danh s??ch ChuyenBayDTO (g???i h??m getAllChuyenBay() trong ChuyenBayBLL)
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	//Duy???t m???ng ChuyenBayDTO v???a l???y ???????c: arr
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 ChuyenBayDTO.setMa_cb(cb);	 
	 arr = ChuyenBayBLL.getChuyenBayByma_cb(ChuyenBayDTO);
	 
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
		 
		 textField_2.setText(diem_di);
		 textField_3.setText(diem_den);
		 //t???o row ????? add v??o control DefaultTableModel
		 Object[] row = { ma_cb, ten_mb,ngaygio, thoigianbay,diem_di,diem_den};
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
		txtma_cb.setText(cb.getMa_cb());
		loadAllChuyenBay(cb.getMa_cb());
		
	}
	public void print(String mcb){
		// T???o ?????i t?????ng t??i li???u
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
						// T???o ?????i t?????ng PdfWriter
						PdfWriter.getInstance(document, new FileOutputStream(file_name));
						// M??? file ????? th???c hi???n ghi
						document.open(); 
						// Th??m n???i dung s??? d???ng add function
						Paragraph head=new Paragraph("H??a ????n");
						head.setAlignment(Paragraph.ALIGN_CENTER);//c??n gi???a
						document.add(head);
						Paragraph bordertop= new Paragraph("M?? h??a ????n: " +  hdDTO.getMa_hd());
						Paragraph para2= new Paragraph("T??n kh??ch h??ng: " + textField_5.getText());
						Paragraph para3= new Paragraph("Ng??y l???p h??a ????n:" + hdDTO.getNgay_Lap());
						Paragraph para4 = new Paragraph("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
						document.add(bordertop);
			            document.add(para2);
			            document.add(para3);
			            document.add(para4);
			            PdfPTable table=new PdfPTable(6);
			            PdfPCell c1 = new PdfPCell(new Phrase("M?? chuy???n bay"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("M?? m??y bay"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("Ng??y gi???"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("??i???m ?????n"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("Lo???i v??"));
			            table.addCell(c1);
			            c1 = new PdfPCell(new Phrase("Th??nh ti???n"));
			            table.addCell(c1);
			            for (int i = 0; i < list.size(); i++) {
			            	vcbDto = list.get(i);
			            	table.addCell(new Phrase(""+vcbDto.getMa_cb()));
			                table.addCell(new Phrase(""+vcbDto.getMa_dongia()));
			                table.addCell(new Phrase(""+vcbDto.getMa_ve_cb()));
			                table.addCell(new Phrase(""+hdDTO.getMa_nv()));
			                table.addCell(new Phrase(""+hdDTO.getThanh_tien()));
			            }
			            document.add(table);
			            Paragraph para5 = new Paragraph("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			            document.add(para5);
			            Paragraph para6 = new Paragraph("     T???ng c???ng: "+hdDTO.getThanh_tien());
			            document.add(para6);
						// ????ng File
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