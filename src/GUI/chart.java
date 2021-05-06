package GUI;
import BLL.HoaDonBLL;
import BLL.KhachHangBLL;
import BLL.NhanVienBLL;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class chart extends ApplicationFrame {

   public chart( String applicationTitle , String chartTitle ) throws ClassNotFoundException {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "ngay","Doanh Thu",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( ) throws ClassNotFoundException {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      /*dataset.addValue( 15 , "schools" , "1970" );
      dataset.addValue( 30 , "schools" , "1980" );
      dataset.addValue( 60 , "schools" ,  "1990" );
      dataset.addValue( 120 , "schools" , "2000" );
      dataset.addValue( 240 , "schools" , "2010" );
      dataset.addValue( 300 , "schools" , "2014" );*/
      ArrayList<HoaDonDTO> arr = new ArrayList<HoaDonDTO>();
	 HoaDonBLL HoaDonBLL = new HoaDonBLL();
	 arr = HoaDonBLL.getAllHoaDon();
	 
	 HoaDonDTO HoaDonDTO = new HoaDonDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 HoaDonDTO = arr.get(i);
		 
		 int thanh_tien = HoaDonDTO.getThanh_tien();
		 Date ngay_lap = HoaDonDTO.getNgay_Lap();
                 String a = String.valueOf(thanh_tien);
                 
         }
         
      return dataset;
   }
   
   public void loadAllHoaDon() throws ClassNotFoundException {

	 ArrayList<HoaDonDTO> arr = new ArrayList<HoaDonDTO>();
	 HoaDonBLL HoaDonBLL = new HoaDonBLL();
	 arr = HoaDonBLL.getAllHoaDon();
	 
	 HoaDonDTO HoaDonDTO = new HoaDonDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 HoaDonDTO = arr.get(i);
		 
		 int thanh_tien = HoaDonDTO.getThanh_tien();
		 Date ngay_lap = HoaDonDTO.getNgay_Lap();
         }
    }
   
   public static void main( String[ ] args ) throws ClassNotFoundException {
      chart chart = new chart(
         "THONG KE DOANH SO" ,
         "DOANH THU THEO NGAY");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }
}