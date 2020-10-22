import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {

        /*File plantsCSV = new File("src/plants.csv");
        try {
            CSVUtility.convertCSVtoSQL(plantsCSV, "plantsSQL.sql");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/BarChartView.fxml"));
        Scene scene = new Scene(root);
        // Add title and show
        stage.setTitle("Create Student");
        stage.setScene(scene);
        stage.show();
    }
}
