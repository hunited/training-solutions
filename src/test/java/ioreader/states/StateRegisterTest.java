package ioreader.states;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StateRegisterTest {

    private final StateRegister stateRegister = new StateRegister();

    @Test
    void testGetStates() {
        assertEquals(0, stateRegister.getStates().size());
        stateRegister.getStates().add(new State("New York", "Albany"));
        assertEquals(0, stateRegister.getStates().size());
    }

    @Test
    void testWithWrongFileName() {
        Exception ex = assertThrows(IllegalStateException.class, () -> stateRegister.readStatesFromFile("myFile.txt"));
        assertEquals("Can't read file!", ex.getMessage());
    }

    @Test
    void testReadFile() {
        assertEquals(0, stateRegister.getStates().size());
        stateRegister.readStatesFromFile("stateregister.txt");
        assertEquals(50, stateRegister.getStates().size());
        assertEquals("Wyoming", stateRegister.getStates().get(49).getStateName());
    }

    @Test
    void wrongStateNameTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            stateRegister.readStatesFromFile("stateregister.txt");
            stateRegister.findCapitalByStateName("Canada");
        });
        assertEquals("No state with this name!", ex.getMessage());
    }

    @Test
    void findCapitalByStateNameTest() {
        stateRegister.readStatesFromFile("stateregister.txt");
        assertEquals("Albany", stateRegister.findCapitalByStateName("New York"));
        assertEquals("Juneau", stateRegister.findCapitalByStateName("Alaska"));
    }

}
