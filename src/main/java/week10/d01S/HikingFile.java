package week10.d01S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HikingFile {

    private final List<Position> positions = new ArrayList<>();

    public List<Integer> getPlusElevation(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                positions.add(getPosition(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
        if (positions.isEmpty()) {
            throw new NullPointerException("The list cannot be empty");
        } else if (positions.size() == 1) {
            throw new IllegalArgumentException("The list should be at least two items");
        }
        return getResult();
    }

    private Position getPosition(String line) {
        String[] row = line.split(", ");
        double posX = Double.parseDouble(row[0]);
        double posY = Double.parseDouble(row[1]);
        int posZ = Integer.parseInt(row[2]);
        return new Position(posX, posY, posZ);
    }

    private List<Integer> getResult() {
        List<Integer> result = new ArrayList<>();
        int uptrend = 0;
        int descent = 0;
        for (int i = 1; i < positions.size(); i++) {
            if (positions.get(i).getPosZ() > positions.get(i - 1).getPosZ()) {
                uptrend += positions.get(i).getPosZ() - positions.get(i - 1).getPosZ();
            } else {
                descent += positions.get(i - 1).getPosZ() - positions.get(i).getPosZ();
            }
        }
        result.add(uptrend);
        result.add(descent);
        return result;
    }

    public List<Position> getPositions() {
        return new ArrayList<>(positions);
    }

}
