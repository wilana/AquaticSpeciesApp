package Utilities;
import Models.Species;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {

    // Info for a local mysql user created for this project
//    private static String user = "student";
//    private static String password = "student";
//    private static String url = "\"jdbc:mysql://127.0.0.1:3306/plantSpecies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//
    // Info for LAMP
    private static String user = "Wilana1120464";
    private static String password = "ltYCIfuzfm";
    private static String url = "jdbc:mysql://172.31.22.43:3306/Wilana1120464?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    /**
     * Queries database for all unique values for region of origin
     * @return List of regions
     */
    public static ArrayList<XYChart.Data> getAllRegions() throws SQLException {
        ArrayList<XYChart.Data> regions = new ArrayList<>();

        // Define the connection and statement
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Connect to the local database called plantSpecies (with timezone correction)
            conn = DriverManager.getConnection(url, user, password);

            // Prepare sql statement to prevent injection
            String sql = "SELECT regionOrigin, COUNT(*) AS num from invasivePlants GROUP BY regionOrigin";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);


            // Save each result as a XYChart.Data object
            while (resultSet.next()) {
                XYChart.Data<String, Integer> newRegion = new XYChart.Data(
                        resultSet.getString("regionOrigin"),
                        resultSet.getInt("num")
                );
                // Add xychart data to the array list that will be returned
                regions.add(newRegion);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection
            if (conn != null)
                conn.close();

            if (statement != null)
                statement.close();

            if (resultSet != null)
                resultSet.close();

            // return array list
            return regions;
        }
    }




    /**
     * Get all entries of species from database
     * @return All entries in db
     */
    public static ArrayList<Species> getAllSpeciesFromDB() throws SQLException {

        ArrayList<Species> plants = new ArrayList<>();

        // Define the connection and statement
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            // Connect to the local database called plantSpecies (with timezone correction)
            conn = DriverManager.getConnection(url, user, password);

            // Prepare sql statement to prevent injection
            String sql = "SELECT * FROM invasivePlants";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);


            // Save each result as a species object
            while(resultSet.next())
            {
                Species newSpecies = new Species(
                        resultSet.getInt("speciesID"),
                        resultSet.getString("scientificName"),
                        resultSet.getString("commonName"),
                        resultSet.getString("family"),
                        resultSet.getString("regionOrigin"),
                        resultSet.getString("lifeCycle")
                );
                // add species to array list to return
                plants.add(newSpecies);

            }



        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            // Close connection
            if (conn != null)
                conn.close();

            if (statement != null)
                statement.close();

            if (resultSet != null)
                resultSet.close();

            // return all species
            return plants;
        }

    }
}



