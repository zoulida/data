package chart;



import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;

public class TimeSeriesChartSVMR {
	public static void main(String[] args) throws IOException {
		new TimeSeriesChartSVMR();
	}
	ChartPanel frame1;
	public TimeSeriesChartSVMR() throws IOException{
		XYDataset xydataset = createDataset2();
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Legal & General��λ���л���۸�", "����", "�۸�",xydataset, true, true, true);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        frame1=new ChartPanel(jfreechart,true);
        dateaxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
        dateaxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
        ValueAxis rangeAxis=xyplot.getRangeAxis();//��ȡ��״
        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
        jfreechart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
        jfreechart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
        ChartFrame mChartFrame = new ChartFrame("����ͼ", jfreechart);
        mChartFrame.pack();
        

        mChartFrame.setLocationRelativeTo(null);
       
        mChartFrame.setVisible(true);

	} 
	
	
	private static double atof(String s)
	{
		return Double.valueOf(s).doubleValue();
	}
	
	private static XYDataset createDataset2() throws IOException {  //������ݼ��е�࣬�����������
		
		TimeSeries timeseries = new TimeSeries("legal & generalŷ��ָ������",
				org.jfree.data.time.Year.class);
		
		int i=0;
		
		
		 BufferedReader input = new BufferedReader(new FileReader("eunite2001.t"));
		 while(true)
		  {
			 
				String line = input.readLine();
				if(line == null) break;

				StringTokenizer st = new StringTokenizer(line," \t\n\r\f:");

				double target = atof(st.nextToken());
				
				System.out.println(i+" "+ target);
				timeseries.add(new Year(i++),target);
				
		  }
		
		
        
        
        TimeSeries timeseries1 = new TimeSeries("legal & generalӢ��ָ������",
                org.jfree.data.time.Month.class);
        timeseries1.add(new Month(2, 2001), 129.59999999999999D);
        timeseries1.add(new Month(3, 2001), 123.2D);
        timeseries1.add(new Month(4, 2001), 117.2D);
        timeseries1.add(new Month(5, 2001), 124.09999999999999D);
        timeseries1.add(new Month(6, 2001), 122.59999999999999D);
        timeseries1.add(new Month(7, 2001), 119.2D);
        timeseries1.add(new Month(8, 2001), 116.5D);
        timeseries1.add(new Month(9, 2001), 112.7D);
        timeseries1.add(new Month(10, 2001), 101.5D);
        timeseries1.add(new Month(11, 2001), 106.09999999999999D);
        timeseries1.add(new Month(12, 2001), 110.3D);
        timeseries1.add(new Month(1, 2002), 111.7D);
        timeseries1.add(new Month(2, 2002), 111D);
        timeseries1.add(new Month(3, 2002), 109.59999999999999D);
        timeseries1.add(new Month(4, 2002), 113.2D);
        timeseries1.add(new Month(5, 2002), 111.59999999999999D);
        timeseries1.add(new Month(6, 2002), 108.8D);
        timeseries1.add(new Month(7, 2002), 101.59999999999999D);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);
        timeseriescollection.addSeries(timeseries);
        //timeseriescollection.addSeries(timeseries1);
        return timeseriescollection;
    }
	
	 private static XYDataset createDataset() {  //������ݼ��е�࣬�����������
	        TimeSeries timeseries = new TimeSeries("legal & generalŷ��ָ������",
	                org.jfree.data.time.Month.class);
	        timeseries.add(new Month(2, 2001), 181.80000000000001D);
	        timeseries.add(new Month(3, 2001), 167.30000000000001D);
	        timeseries.add(new Month(4, 2001), 153.80000000000001D);
	        timeseries.add(new Month(5, 2001), 167.59999999999999D);
	        timeseries.add(new Month(6, 2001), 158.80000000000001D);
	        timeseries.add(new Month(7, 2001), 148.30000000000001D);
	        timeseries.add(new Month(8, 2001), 153.90000000000001D);
	        timeseries.add(new Month(9, 2001), 142.69999999999999D);
	        timeseries.add(new Month(10, 2001), 123.2D);
	        timeseries.add(new Month(11, 2001), 131.80000000000001D);
	        timeseries.add(new Month(12, 2001), 139.59999999999999D);
	        timeseries.add(new Month(1, 2002), 142.90000000000001D);
	        timeseries.add(new Month(2, 2002), 138.69999999999999D);
	        timeseries.add(new Month(3, 2002), 137.30000000000001D);
	        timeseries.add(new Month(4, 2002), 143.90000000000001D);
	        timeseries.add(new Month(5, 2002), 139.80000000000001D);
	        timeseries.add(new Month(6, 2002), 137D);
	        timeseries.add(new Month(7, 2002), 132.80000000000001D);
	        TimeSeries timeseries1 = new TimeSeries("legal & generalӢ��ָ������",
	                org.jfree.data.time.Month.class);
	        timeseries1.add(new Month(2, 2001), 129.59999999999999D);
	        timeseries1.add(new Month(3, 2001), 123.2D);
	        timeseries1.add(new Month(4, 2001), 117.2D);
	        timeseries1.add(new Month(5, 2001), 124.09999999999999D);
	        timeseries1.add(new Month(6, 2001), 122.59999999999999D);
	        timeseries1.add(new Month(7, 2001), 119.2D);
	        timeseries1.add(new Month(8, 2001), 116.5D);
	        timeseries1.add(new Month(9, 2001), 112.7D);
	        timeseries1.add(new Month(10, 2001), 101.5D);
	        timeseries1.add(new Month(11, 2001), 106.09999999999999D);
	        timeseries1.add(new Month(12, 2001), 110.3D);
	        timeseries1.add(new Month(1, 2002), 111.7D);
	        timeseries1.add(new Month(2, 2002), 111D);
	        timeseries1.add(new Month(3, 2002), 109.59999999999999D);
	        timeseries1.add(new Month(4, 2002), 113.2D);
	        timeseries1.add(new Month(5, 2002), 111.59999999999999D);
	        timeseries1.add(new Month(6, 2002), 108.8D);
	        timeseries1.add(new Month(7, 2002), 101.59999999999999D);
	        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
	        timeseriescollection.addSeries(timeseries);
	        timeseriescollection.addSeries(timeseries1);
	        return timeseriescollection;
	    }
	  public ChartPanel getChartPanel(){
	    	return frame1;
	    	
	    }
}
