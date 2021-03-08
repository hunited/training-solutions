package week07.d04S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShoppingList {

    public long calculateSum(String path) {
        try (InputStream is = ShoppingList.class.getResourceAsStream(path);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            long result = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(";");
                long piece = Long.parseLong(row[1]);
                long price = Long.parseLong(row[2]);
                result += piece * price;
            }
            return result;
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
    }

}
