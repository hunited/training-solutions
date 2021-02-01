package iofilestest.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private final Library library = new Library();
    private final Book book1 = new Book("Gárdonyi Géza", "Egri csillagok");
    private final Book book2 = new Book("Julius Verne", "Két évi vakáció");
    private final Book book3 = new Book("Berg Judit", "Rumini Zuzmaragyarmaton");

    @TempDir
    public File folder;

    @Test
    void addTest() {
        library.add(book1, book2, book3, book2);
        assertEquals(3, library.getLibrary().size());
    }

    @Test
    void addTestError() {
        assertThrows(IllegalArgumentException.class, library::add);
    }

    @Test
    void saveBooksTest() throws IOException {
        File file = new File(folder, "library.txt");
        library.add(book1, book2, book3, book2);
        library.saveBooks(file.toPath());
        List<String> lines = Files.readAllLines(file.toPath());
        assertEquals(3, lines.size());
        assertEquals("Gárdonyi Géza;Egri csillagok", lines.get(0));
    }

    @Test
    void loadBooksTest() {
        library.add(book1, book2, book3, book2);
        List<Book> readList = library.loadBooks(Path.of("library.txt"));
        assertEquals(book1.getAuthor(), readList.get(0).getAuthor());
        assertEquals(3, readList.size());
    }

}