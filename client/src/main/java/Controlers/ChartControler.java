package Controlers;

import GUI.Chart;
import GUI.Interfaces.Controlers;
import Utils.Language;
import Utils.Observerr;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChartControler extends Observerr implements Controlers {
    private Chart chartt;
    private ArrayList<String> data = new ArrayList<>();
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public ChartControler() {
        chartt = new Chart();

        JFreeChart chart = createChart(this.dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        chartt.add(chartPanel);
        chartt.pack();


    }

    @Override
    public void language() {
        chartt = new Chart();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        chartt.add(chartPanel);
        chartt.pack();
    }

    private CategoryDataset createDataset() {


        for (String i : data) {

        }


        return dataset;
    }


    private JFreeChart createChart(CategoryDataset dataset) {
        Locale l = new Locale(Language.lang, Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", l);
        JFreeChart barChart = ChartFactory.createBarChart(
                resourceBundle.getString("no"),
                "",
                resourceBundle.getString("statie"),
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
        return barChart;
    }

    @Override
    public void setCommand(String command) {

    }

    @Override
    public void setUsed(boolean used) {

    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public boolean isUsed() {
        return false;
    }
}
