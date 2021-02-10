package week15.d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    List<Post> posts = new ArrayList<>();

    @BeforeEach
    void setUp() {
        posts.add(new Post("Cím", LocalDate.parse("2021-01-13"), "Mail", "Sanyi"));
        posts.add(new Post("Cím", LocalDate.parse("2027-02-13"), "Mail", "Sanyi"));
        posts.add(new Post("Cím", LocalDate.parse("2021-01-17"), "Mail", "Gyula"));
        posts.add(new Post("Cím", LocalDate.parse("2021-01-09"), "Mail", "Peti"));
        posts.add(new Post("Cím", LocalDate.parse("2021-01-03"), "Mail", "Sanyi"));
        posts.add(new Post("", LocalDate.parse("2021-01-04"), "Mail", "Sanyi"));
        posts.add(new Post("Cím", LocalDate.parse("2021-01-05"), "", "Sanyi"));
    }

    PostFinder pf = new PostFinder(posts);

    @Test
    void listTest() {
        assertEquals(7, pf.getPosts().size());
    }

    @Test
    void findPostsForTest() {
        assertEquals(2, pf.findPostsFor("Sanyi").size());
        assertEquals(LocalDate.of(2021, 1, 13), pf.findPostsFor("Sanyi").get(0).getPublishedAt());
        assertEquals(LocalDate.of(2021, 1, 3), pf.findPostsFor("Sanyi").get(1).getPublishedAt());
    }

    @Test
    void findPostsForNotFound() {
        assertEquals(0, pf.findPostsFor("Juli").size());
    }

    @Test
    void emptyListTest() {
        assertThrows(NullPointerException.class, () -> new PostFinder(null));
    }

    @Test
    void findPostsForTestEmpty() {
        assertThrows(NullPointerException.class, () -> pf.findPostsFor(null));
        assertThrows(NullPointerException.class, () -> pf.findPostsFor(""));
    }

    @Test
    void parameterIsNull() {
        assertThrows(NullPointerException.class, () -> posts.add(
                new Post("Cím", LocalDate.parse("2021-01-05"), null, "Sanyi")
        ));
    }

}
