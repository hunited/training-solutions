package week10.d02S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Travel {

    public int getStopWithMax(InputStream is) {
        int[] stops = new int[30];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(" ");
                stops[Integer.parseInt(row[0])]++;
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
        return getResult(stops);
    }

    private int getResult(int[] stops) {
        int max = 0;
        int result = 0;
        for (int i = 0; i < stops.length; i++) {
            if (stops[i] > max) {
                result = i;
                max = stops[i];
            }
        }
        return result;
    }

}
