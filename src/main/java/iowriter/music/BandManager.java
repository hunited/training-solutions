package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private final List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path inputFile) {
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(";");
                bands.add(new Band(array[0], Integer.parseInt(array[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void writeBandsBefore(Path outputFile, int year) {
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            for (Band band : olderThan(year)) {
                writer.write(band.getName() + " " + band.getYear() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private List<Band> olderThan(int year) {
        List<Band> filtered = new ArrayList<>();
        for (Band band : bands) {
            if (band.getYear() < year) {
                filtered.add(band);
            }
        }
        return filtered;
    }

    public List<Band> getBands() {
        return new ArrayList<>(bands);
    }
}
