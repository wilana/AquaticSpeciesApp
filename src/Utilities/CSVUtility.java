package Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVUtility {
    /**
     * A method to convert a CSV file with header into a set of SQL
     * create table and insert statements
     * It doesn't work perfectly for this set because of multiple entries in one field
     * @param fileToRead A CSV file with header
     * @param sqlFileName a SQL file name
     * @throws IOException
     */
    public static void convertCSVtoSQL(File fileToRead, String sqlFileName) throws IOException {
        // Create filewriter for adding SQL to a file
        FileWriter fw = new FileWriter (sqlFileName, true);
        // Create scanner to read CSV from file
        Scanner scanner = new Scanner(fileToRead);
        // Create a string to hold the line and format it
        String format;

        // CREATE TABLE:
        // first line in CSV is column names
        String[] columns = scanner.nextLine().split(",");

        // Write a create table statement
        format = String.format("CREATE TABLE plants (%s int, " +
                        "%s varchar(50), %s varchar(50), %s varchar(50), " +
                        "%s varchar (50), %s varchar(50));%n",
                columns[0], columns[2], columns[1], columns[5], columns[7], columns[25]);
        // Add create table to the file
        fw.write(format);
        fw.flush();

        // INSERT STATEMENTS:
        while(scanner.hasNext())
        {
            // Get the information from the CSV
            String[] record = scanner.nextLine().split(",");

            // Reword into an insert statement but only certain columns
            format = String.format("INSERT INTO plants VALUES ('%s', '%s', '%s', '%s', '%s', '%s');%n",
                    record[0], record[2], record[1], record[5], record[7], record[25]);

            // Add insert statement to the file
            fw.write(format);
            fw.flush();
        }

        // Close file
        fw.close();
    }
}
