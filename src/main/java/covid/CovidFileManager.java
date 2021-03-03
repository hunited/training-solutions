package covid;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CovidFileManager {

    private final CitizenDao dao = new CitizenDao();

    public String uploadCitizensFromFile(String fileName) {
        List<String> wrongLines = new ArrayList<>();
        int sum = 0;
        try (InputStream is = CovidFileManager.class.getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String columns = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                sum = uploadCitizenFromFile(wrongLines, sum, line);
            }
            return getUploadResult(wrongLines, sum, columns);
        } catch (IOException ioe) {
            throw new IllegalStateException("Nincs fájl! ", ioe);
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Fájl nem található! ", npe);
        }
    }

    public void saveListToFile(String zip, String fileName) {
        Path path = Path.of("src/main/resources/covid/" + fileName);
        try (Writer writer = new BufferedWriter(Files.newBufferedWriter(path))) {
            for (String row : dao.listRowsByZip(zip)) {
                writer.write(row + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Fájl nem található! ", ioe);
        }
    }

    private int uploadCitizenFromFile(List<String> wrongLines, int sum, String line) {
        try {
            String[] row = line.split(";");
            dao.uploadCitizenToDb(new Citizen(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4]));
            sum++;
        } catch (IllegalArgumentException iae) {
            wrongLines.add(line);
        }
        return sum;
    }

    private String getUploadResult(List<String> wrongLines, int sum, String columns) {
        if (wrongLines.isEmpty() && sum > 0) {
            return "Sikeresen feltöltve " + sum + " páciens (oszlopok: " + columns + ").";
        } else if (sum > 0) {
            StringBuilder sb = new StringBuilder("Néhány sor hibákat tartalmazott, a többi sikeresen feltöltve.\n")
                    .append("Ellenőrizze a lentieket, és töltse fel csak a hibás sorokat újra! A hibás sorok:\n");
            for (String wrongLine : wrongLines) {
                sb.append(wrongLine).append("\n");
            }
            return sb.toString();
        } else {
            throw new IllegalArgumentException("Hibás fájl: nem tartalmaz sorokat!");
        }
    }

}
