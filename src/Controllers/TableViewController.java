package Controllers;

import Models.Species;
import Utilities.DBUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        speciesIDColumn.setCellValueFactory(new PropertyValueFactory<Species, Integer>("speciesID"));
        scientificNameColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("scientificName"));
        commonNameColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("commonName"));
        familyColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("family"));
        regionOriginColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("regionOrigin"));
        lifeCycleColumn.setCellValueFactory(new PropertyValueFactory<Species, String>("lifeCycle"));

        try {
            speciesTableView.getItems().addAll(DBUtility.getAllSpeciesFromDB());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
