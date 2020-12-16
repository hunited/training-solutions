package week08.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {

    StringList sl = new StringList();
    List<String> first = List.of("szó", "betű", "szám", "magánhangzó", "mássalhangzó", "agymenés", "utolsó");
    List<String> second = List.of("szó", "betű", "karakter", "írásjel", "pont", "vessző", "utolsó");

    @Test
    public void testList() {
        List<String> testlist = sl.stringListsUnion(first, second);
        assertEquals(11, testlist.size());
    }

    @Test
    public void testListNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> sl.stringListsUnion(first, null));
        assertEquals("Egyik lista sem lehet üres", ex.getMessage());
    }

    @Test
    public void testListEmpty() {
        Exception ex = assertThrows(NullPointerException.class, () -> sl.stringListsUnion(List.of(), second));
        assertEquals("Egyik lista sem lehet üres", ex.getMessage());
    }

}