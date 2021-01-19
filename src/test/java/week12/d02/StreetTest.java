package week12.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    Street street = new Street();

    void init() {
        Site site1 = new Site(0, 10, Fence.PERFECT);
        Site site2 = new Site(0, 7, Fence.NEED_UPGRADE);
        Site site3 = new Site(1, 12, Fence.NEED_UPGRADE);
        Site site4 = new Site(0, 9, Fence.PERFECT);
        Site site5 = new Site(0, 11, Fence.NO_FENCE);
        Site site6 = new Site(1, 13, Fence.PERFECT);
        street.sellSite(site1);
        street.sellSite(site2);
        street.sellSite(site3);
        street.sellSite(site4);
        street.sellSite(site5);
        street.sellSite(site6);
    }

    @Test
    void testStreetLastHouseNumber() {
        init();
        assertEquals(3, street.lastHouseNr());
    }

    @Test
    void testStreetFenceTypes() {
        init();
        assertEquals(3, street.fenceTypesCounter().size());
        assertEquals(Fence.PERFECT, street.fenceTypesCounter().get(0).getFence());
        assertEquals(3, street.fenceTypesCounter().get(0).getNumberOfSite());
        assertEquals(Fence.NEED_UPGRADE, street.fenceTypesCounter().get(1).getFence());
        assertEquals(2, street.fenceTypesCounter().get(1).getNumberOfSite());
        assertEquals(Fence.NO_FENCE, street.fenceTypesCounter().get(2).getFence());
        assertEquals(1, street.fenceTypesCounter().get(2).getNumberOfSite());
    }

    @Test
    void testStreetEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> street.lastHouseNr());
        assertThrows(IllegalArgumentException.class, () -> street.fenceTypesCounter());
    }

}
