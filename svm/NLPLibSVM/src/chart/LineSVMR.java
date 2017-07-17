package chart;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineSVMR {

	private static double atof(String s) {
		return Double.valueOf(s).doubleValue();
	}

	public static void main(String[] args) throws IOException {
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);
		CategoryDataset mDataset = GetDataset();
		JFreeChart mChart = ChartFactory.createLineChart("折线图", // 图名字
				"年份", // 横坐标
				"数量", // 纵坐标
				mDataset, // 数据集
				PlotOrientation.VERTICAL, true, // 显示图例
				true, // 采用标准生成器
				false);// 是否生成超链接

		CategoryPlot mPlot = (CategoryPlot) mChart.getPlot();
		mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		mPlot.setRangeGridlinePaint(Color.BLUE);// 背景底部横虚线
		mPlot.setOutlinePaint(Color.RED);// 边界线

		ValueAxis valueaxis = mPlot.getRangeAxis();
		// 数据为整型
		// valueaxis .setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// 设定显示范围,即总是显示1-10
		valueaxis.setLowerBound(600);
		valueaxis.setUpperBound(800);
		//valueaxis.setAutoRange(true);

		ChartFrame mChartFrame = new ChartFrame("折线图", mChart);
		mChartFrame.pack();

		mChartFrame.setLocationRelativeTo(null);

		mChartFrame.setVisible(true);

	}

	public static CategoryDataset GetDataset() throws IOException {

		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
		int i = 0;
		BufferedReader input = new BufferedReader(new FileReader("eunite2001.t"));
		while (true) {

			String line = input.readLine();
			if (line == null)
				break;

			StringTokenizer st = new StringTokenizer(line, " \t\n\r\f:");
			double target = atof(st.nextToken());

			System.out.println(i + " " + target);
			mDataset.addValue(target, "TRUE", String.valueOf(i++));
		}

		BufferedReader input2 = new BufferedReader(new FileReader("eunite2001.result"));

		int j = 0;
		while (true) {
			String line = input2.readLine();
			if (line == null)
				break;
			StringTokenizer st = new StringTokenizer(line, " \t\n\r\f:");
			double target = atof(st.nextToken());

			System.out.println(j + " " + target);
			mDataset.addValue(target, "SVM", String.valueOf(j++));
		}
		// mDataset.addValue(1, "First", "2013");
		// mDataset.addValue(3, "First", "2014");
		// mDataset.addValue(2, "First", "2015");
		// mDataset.addValue(6, "First", "2016");
		// mDataset.addValue(5, "First", "2017");
		// mDataset.addValue(12, "First", "2018");
		// mDataset.addValue(14, "Second", "2013");
		// mDataset.addValue(13, "Second", "2014");
		// mDataset.addValue(12, "Second", "2015");
		// mDataset.addValue(9, "Second", "2016");
		// mDataset.addValue(5, "Second", "2017");
		// mDataset.addValue(7, "Second", "2018");
		return mDataset;
	}

}