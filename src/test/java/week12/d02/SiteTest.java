package week12.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SiteTest {

    @Test
    void getSideOfStreet() {
        Site site1 = new Site(0, 10, Fence.PERFECT);
        Site site2 = new Site(1, 7, Fence.NEED_UPGRADE);
        assertEquals(0, site1.getSideOfStreet());
        assertEquals(1, site2.getSideOfStreet());
    }

    @Test
    void getLengthOfSide() {
        Site site1 = new Site(0, 10, Fence.PERFECT);
        Site site2 = new Site(1, 7, Fence.NEED_UPGRADE);
        assertEquals(10, site1.getLengthOfSide());
        assertEquals(7, site2.getLengthOfSide());
    }

    @Test
    void getFenceType() {
        Site site1 = new Site(0, 10, Fence.PERFECT);
        Site site2 = new Site(1, 7, Fence.NEED_UPGRADE);
        assertEquals(Fence.PERFECT, site1.getFenceType());
        assertEquals(Fence.NEED_UPGRADE, site2.getFenceType());
    }

}
