package Utilities;
import Models.Species;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    // Info for a local mysql user created for this project
    private static String user = "plantEnthusiast";
    private static String password = "plants";

    // Get all regions of origin

    // Get numbers from each origin


    /**
     * Get all info from database
     * @return
     * @throws SQLException
     */
    public static ArrayList<Species> getAllSpeciesFromDB() throws SQLException {
        ArrayList<Species> plants = new ArrayList<>();

        // Define the connection and statement
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            // Connect to the local database called plantSpecies
            // having issues with timezones??
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC/plantSpecies",
                    user, password);

            // Set up the statement and save the results
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * from invasiveplants");

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
                plants.add(newSpecies);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
            return plants;
        }

    }
}



