package iodatastream.statistics;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {

    public void saveHeights(List<Integer> heights, Path path) {
        try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            os.writeInt(heights.size());
            for (int height : heights) {
                os.writeInt(height);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

}
