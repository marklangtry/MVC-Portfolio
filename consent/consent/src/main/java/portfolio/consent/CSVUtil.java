package portfolio.consent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVUtil {
    private static final String CSV_SEPARATOR = ",";

    public static void writeDataToCsv(String csvFilePath, List<String[]> data) throws IOException {
        try (FileWriter writer = new FileWriter(csvFilePath)) {
            for (String[] rowData : data) {
                writer.append(String.join(CSV_SEPARATOR, rowData));
                writer.append("\n");
            }
        }
    }
}
