package Controllers;

import Models.Species;
import Utilities.DBUtility;
import Utilities.SceneChangeUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private TableView<Species> speciesTableView;

    @FXML
    private TableColumn<Species, Integer> speciesIDColumn;

    @FXML
    private TableColumn<Species, String> scientificNameColumn;

    @FXML
    private TableColumn<Species, String> commonNameColumn;

    @FXML
    private TableColumn<Species, String> familyColumn;

    @FXML
    private TableColumn<Species, String> regionOriginColumn;

    @FXML
    private TableColumn<Species, String> lifeCycleColumn;

    @FXML
    private Button graphButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Populate columns
        speciesIDColumn.setCellValueFactory(new PropertyValueFactory<Species, Integer>("speciesID"));
        scientificNameColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("scientificName"));
        commonNameColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("commonName"));
        familyColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("family"));
        regionOriginColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("regionOrigin"));
        lifeCycleColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("lifeCycle"));

        try {
            // Populate table with columns
            speciesTableView.getItems().addAll(DBUtility.getAllSpeciesFromDB());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Change scene to bar chart
     * @param event click of graph button
     */
    public void viewGraphClicked(ActionEvent event) throws IOException
    {
        SceneChangeUtility.changeScene(event, "/Views/BarChartView.fxml", "Invasive Species Graph");
    }
}
