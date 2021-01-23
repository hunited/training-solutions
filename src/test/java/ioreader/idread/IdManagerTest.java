package ioreader.idread;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdManagerTest {
    private final IdManager idManager = new IdManager();

    @Test
    void getIdsTest() {
        assertEquals(0, idManager.getIds().size());
        idManager.getIds().add("test");
        assertEquals(0, idManager.getIds().size());
    }

    @Test
    void readIdFromFileTest() {
        assertEquals(0, idManager.getIds().size());
        idManager.readIdsFromFile("idnumbers.txt");
        assertEquals(6, idManager.getIds().size());

    }

}
