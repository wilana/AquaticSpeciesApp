package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class CSVUtility {
    public static void convertCSVtoSQL(File fileToRead, String sqlFileName) throws IOException {
        FileWriter fw = new FileWriter (sqlFileName, true);
        Formatter formatter = new Formatter(fw);
        Scanner scanner = new Scanner(fileToRead);

        while(scanner.hasNext())
        {
            String[] record = scanner.nextLine().split(",");
            String entries = "INSERT INTO plants VALUES (";
            for (int i = 0; i<record.length; i++)
            {
                entries = entries.concat("\'" + formatter.format(record[i]) + "\'");
                if (i != record.length - 1)
                {
                    entries = entries.concat(", ");
                }
            }
            entries = entries.concat(";");

            fw.write((entries));

        }
    }
}
