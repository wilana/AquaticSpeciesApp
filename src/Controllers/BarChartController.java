package Controllers;

import Utilities.DBUtility;
import Utilities.SceneChangeUtility;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        // Label the bar chart
        barChart.setTitle("Invasive Species in the Great Lakes");
        originAxis.setLabel("");
        numberAxis.setLabel("");

        XYChart.Series series = new XYChart.Series();
        series.setName("Plants");
        try {
            series.getData().addAll(DBUtility.getAllRegions());
            barChart.getData().add(series);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    /**
     * Switch to table view scene
     * @param event
     * @throws IOException
     */
    public void viewTableClicked(ActionEvent event) throws IOException
    {
        SceneChangeUtility.changeScene(event, "/Views/TableView.fxml", "All Invasive Species");
    }
}
