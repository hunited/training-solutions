package ioprintwriter.talentshow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VoteTest {

    private final Vote v = new Vote(1, 10);

    @Test
    void createVote() {
        assertEquals(1, v.getId());
        assertEquals(10, v.getNumber());
    }

    @Test
    void incNumberTest() {
        assertEquals(10, v.getNumber());
        v.incNum();
        assertEquals(11, v.getNumber());
    }

}
