package ace.ucv.licenta.core.charts;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import ace.ucv.licenta.converter.core.dto.FileStatus;

public class BarChart extends JFrame {

	private static final long serialVersionUID = 1L;

	private List<FileStatus> elements;
	private JFreeChart barChart;

	public BarChart(List<FileStatus> elements) {
		super("Bar chart");
		this.elements = elements;
	}

	public void display() {
		this.barChart = ChartFactory.createBarChart("", "Files", "Score", createDataset(), PlotOrientation.VERTICAL,
				true, true, false);
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(560, 367));
		setContentPane(chartPanel);
		pack();
		RefineryUtilities.centerFrameOnScreen(this);
		setVisible(true);
	}

	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String vsm = "VSM";
		String bigram = "Bigram";
		String languageAnalyzer = "Language Analyzer";
		int index = 1;
		for (FileStatus fileStatus : elements) {
			double vsmDoubleValue = Double.parseDouble(fileStatus.getVSM());
			double bigramDoubleValue = Double.parseDouble(fileStatus.getBigram());
			double languageAnalyzerDoubleValue = Double.parseDouble(fileStatus.getLanguageAnalyzer());
			if (vsmDoubleValue > 0 || bigramDoubleValue > 0 || languageAnalyzerDoubleValue > 0) {
				String filePath = "r" + index;//fileStatus.getPath().replace("\\", "/");
				String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
				dataset.addValue(vsmDoubleValue, vsm, fileName);
				dataset.addValue(bigramDoubleValue, bigram, fileName);
				dataset.addValue(languageAnalyzerDoubleValue, languageAnalyzer, fileName);
			}
			index++;
		}

		return dataset;
	}

	public void meanChart(double vsmMean, double bigramMean, double languageAnalyzerMean) {
		this.barChart = ChartFactory.createBarChart("", "Algorithms", "Score", createMeanDataset(vsmMean, bigramMean, languageAnalyzerMean), PlotOrientation.VERTICAL,
				true, true, false);
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(560, 367));
		setContentPane(chartPanel);
		pack();
		RefineryUtilities.centerFrameOnScreen(this);
		setVisible(true);
	}

	private CategoryDataset createMeanDataset(double vsmMean, double bigramMean, double languageAnalyzerMean) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String vsm = "VSM";
		String bigram = "Bigram";
		String languageAnalyzer = "Language Analyzer";
		
		dataset.addValue(vsmMean, vsm, "");
		dataset.addValue(bigramMean, bigram, "");
		dataset.addValue(languageAnalyzerMean, languageAnalyzer, "");
		
		return dataset;
	}

}
