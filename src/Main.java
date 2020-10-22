import Utilities.CSVUtility;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File plantsCSV = new File("src/plants.csv");
        try {
            CSVUtility.convertCSVtoSQL(plantsCSV, "plantsSQL.sql");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
