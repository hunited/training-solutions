package lambdaintro;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OfficeDocumentReader {

    public List<File> listOfficeDocuments(File path) {
        List<File> files = Arrays.asList(
                Objects.requireNonNull(path.listFiles(
                        file -> file.isFile() && file.getName().toLowerCase().matches(".*\\.(docx|xlsx|pptx)$")
                ))
        );
        files.sort(Comparator.comparing(File::getName));
        return files;
    }

}
