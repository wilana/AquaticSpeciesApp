package Controllers;

import Utilities.DBUtility;
import Utilities.SceneChangeUtility;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class BarChartController implements Initializable {

        @FXML
        private Button tableViewButton;

        // Bar chart holds region of origin and number of species
        @FXML
        private BarChart<String, Integer> barChart;

        @FXML
        private CategoryAxis originAxis;

        @FXML
        private NumberAxis numberAxis;

        // Series for data to populate bar chart
        XYChart.Series plantSeries;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        // Label the bar chart
        barChart.setTitle("Invasive Species in the Great Lakes");
        originAxis.setLabel("Region of Origin");
        numberAxis.setLabel("Number of Species");

        // Set up a new series
        plantSeries = new XYChart.Series();
        plantSeries.setName("Plants");

        try {
            // Add data from a db count query to the series
            plantSeries.getData().addAll(DBUtility.getAllRegions());
            // Add series to the bar chart
            barChart.getData().add(plantSeries);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * Switch to table view scene
     * @param event click of tableViewButton
     */
    public void viewTableClicked(ActionEvent event) throws IOException
    {
        // change scene
        SceneChangeUtility.changeScene(event, "/Views/TableView.fxml", "All Invasive Species");
    }
}
