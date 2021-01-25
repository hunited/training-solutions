package iostringwriter.longwords;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public void writeWords(Writer writer, List<String> words) {
        PrintWriter printWriter = new PrintWriter(writer);
        for (String word : words) {
            printWriter.println(word + ":" + word.length());
        }
    }

    public String writeWithStringWriter(List<String> words) {
        try (StringWriter stringWriter = new StringWriter()) {
            writeWords(stringWriter, words);
            return stringWriter.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write", ioe);
        }
    }

}
