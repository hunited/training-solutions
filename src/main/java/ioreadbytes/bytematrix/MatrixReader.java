package ioreadbytes.bytematrix;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {

    private final List<byte[]> myMatrix = new ArrayList();

    public void readBytesAndCreateMatrix(String fileName) {
        Path file = Path.of("src/test/resources/ioreadbytes/" + fileName);
        try (InputStream inputStream = Files.newInputStream(file)) {
            byte[] buffer = new byte[1000];
            while (inputStream.read(buffer) > 0) {
                myMatrix.add(buffer);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            int zero = 0;
            int one = 0;
            for (byte[] matrix : myMatrix) {
                if (matrix[i] == (byte) '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            if (zero > one) {
                result++;
            }
        }
        return result;
    }

    public List<byte[]> getMyMatrix() {
        return myMatrix;
    }

}
