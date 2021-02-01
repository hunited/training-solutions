package iofilestest.library;

import week13.d03.Teacher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Book> library = new ArrayList<>();

    public void add(Book... books) {
        if (books.length < 1) {
            throw new IllegalArgumentException("Empty library");
        }
        for (Book book : books) {
            if (!library.contains(book)) {
                library.add(book);
            }
        }
    }

    public void saveBooks(Path path) {
        try (Writer writer = new BufferedWriter(Files.newBufferedWriter(path))) {
            for (Book book : library) {
                writer.write(book.getAuthor() + ";" + book.getTitle() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File can not write", ioe);
        }
    }

    public List<Book> loadBooks(Path path) {
        List<Book> result = new ArrayList<>();
        try (InputStream is = Library.class.getResourceAsStream(path.toString());
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");
                result.add(new Book(row[0], row[1]));
            }
            return result;
        } catch (IOException ioe) {
            throw new IllegalStateException("File can not read", ioe);
        }
    }

    public List<Book> getLibrary() {
        return new ArrayList<>(library);
    }

}
