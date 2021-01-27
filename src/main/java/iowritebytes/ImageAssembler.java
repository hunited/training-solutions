package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] source, Path path) {
        Path file= path.resolve("image.png");
        try (BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (byte[] part: source) {
                os.write(part);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

}
