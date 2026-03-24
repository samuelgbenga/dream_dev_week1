package mondayTwentyThreeAssessment.findzone;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeopoliticalFinderTest {


    @Test
    void testBenue() { assertEquals(Zone.NORTH_CENTRAL, GeopoliticalFinder.getZone("Benue")); }

    @Test
    void testFCT() { assertEquals(Zone.NORTH_CENTRAL, GeopoliticalFinder.getZone("FCT")); }

    @Test
    void testKogi() { assertEquals(Zone.NORTH_CENTRAL, GeopoliticalFinder.getZone("Kogi")); }

    @Test
    void testKwara() { assertEquals(Zone.NORTH_CENTRAL, GeopoliticalFinder.getZone("Kwara")); }

    @Test
    void testNasarawa() { assertEquals(Zone.NORTH_CENTRAL, GeopoliticalFinder.getZone("Nasarawa")); }

    @Test
    void testNiger() { assertEquals(Zone.NORTH_CENTRAL, GeopoliticalFinder.getZone("Niger")); }

    @Test
    void testPlateau() { assertEquals(Zone.NORTH_CENTRAL, GeopoliticalFinder.getZone("Plateau")); }

    // --- North East ---
    @Test
    void testAdamawa() { assertEquals(Zone.NORTH_EAST, GeopoliticalFinder.getZone("Adamawa")); }

    @Test
    void testBauchi() { assertEquals(Zone.NORTH_EAST, GeopoliticalFinder.getZone("Bauchi")); }

    @Test
    void testBorno() { assertEquals(Zone.NORTH_EAST, GeopoliticalFinder.getZone("Borno")); }

    @Test
    void testGombe() { assertEquals(Zone.NORTH_EAST, GeopoliticalFinder.getZone("Gombe")); }

    @Test
    void testTaraba() { assertEquals(Zone.NORTH_EAST, GeopoliticalFinder.getZone("Taraba")); }

    @Test
    void testYobe() { assertEquals(Zone.NORTH_EAST, GeopoliticalFinder.getZone("Yobe")); }


    @Test
    void testKaduna() { assertEquals(Zone.NORTH_WEST, GeopoliticalFinder.getZone("Kaduna")); }

    @Test
    void testKatsina() { assertEquals(Zone.NORTH_WEST, GeopoliticalFinder.getZone("Katsina")); }

    @Test
    void testKano() { assertEquals(Zone.NORTH_WEST, GeopoliticalFinder.getZone("Kano")); }

    @Test
    void testKebbi() { assertEquals(Zone.NORTH_WEST, GeopoliticalFinder.getZone("Kebbi")); }

    @Test
    void testSokoto() { assertEquals(Zone.NORTH_WEST, GeopoliticalFinder.getZone("Sokoto")); }

    @Test
    void testJigawa() { assertEquals(Zone.NORTH_WEST, GeopoliticalFinder.getZone("Jigawa")); }

    @Test
    void testZamfara() { assertEquals(Zone.NORTH_WEST, GeopoliticalFinder.getZone("Zamfara")); }

    // --- South East ---
    @Test
    void testAbia() { assertEquals(Zone.SOUTH_EAST, GeopoliticalFinder.getZone("Abia")); }

    @Test
    void testAnambra() { assertEquals(Zone.SOUTH_EAST, GeopoliticalFinder.getZone("Anambra")); }

    @Test
    void testEbonyi() { assertEquals(Zone.SOUTH_EAST, GeopoliticalFinder.getZone("Ebonyi")); }

    @Test
    void testEnugu() { assertEquals(Zone.SOUTH_EAST, GeopoliticalFinder.getZone("Enugu")); }

    @Test
    void testImo() { assertEquals(Zone.SOUTH_EAST, GeopoliticalFinder.getZone("Imo")); }


    @Test
    void testAkwaIbom() { assertEquals(Zone.SOUTH_SOUTH, GeopoliticalFinder.getZone("Akwa-Ibom")); }

    @Test
    void testBayelsa() { assertEquals(Zone.SOUTH_SOUTH, GeopoliticalFinder.getZone("Bayelsa")); }

    @Test
    void testCrossRiver() { assertEquals(Zone.SOUTH_SOUTH, GeopoliticalFinder.getZone("Cross-River")); }

    @Test
    void testDelta() { assertEquals(Zone.SOUTH_SOUTH, GeopoliticalFinder.getZone("Delta")); }

    @Test
    void testEdo() { assertEquals(Zone.SOUTH_SOUTH, GeopoliticalFinder.getZone("Edo")); }

    @Test
    void testRivers() { assertEquals(Zone.SOUTH_SOUTH, GeopoliticalFinder.getZone("Rivers")); }


    @Test
    void testEkiti() { assertEquals(Zone.SOUTH_WEST, GeopoliticalFinder.getZone("Ekiti")); }

    @Test
    void testLagos() { assertEquals(Zone.SOUTH_WEST, GeopoliticalFinder.getZone("Lagos")); }

    @Test
    void testOsun() { assertEquals(Zone.SOUTH_WEST, GeopoliticalFinder.getZone("Osun")); }

    @Test
    void testOndo() { assertEquals(Zone.SOUTH_WEST, GeopoliticalFinder.getZone("Ondo")); }

    @Test
    void testOgun() { assertEquals(Zone.SOUTH_WEST, GeopoliticalFinder.getZone("Ogun")); }

    @Test
    void testOyo() { assertEquals(Zone.SOUTH_WEST, GeopoliticalFinder.getZone("Oyo")); }

    // --- Unknown / Edge Cases ---
    @Test
    void testUnknownState() { assertEquals(Zone.UNKNOWN, GeopoliticalFinder.getZone("Abuja")); }

    @Test
    void testEmptyString() { assertEquals(Zone.UNKNOWN, GeopoliticalFinder.getZone("")); }

    @Test
    void testWhitespaceOnly() { assertEquals(Zone.UNKNOWN, GeopoliticalFinder.getZone("   ")); }

    @Test
    void testMixedCase() { assertEquals(Zone.SOUTH_WEST, GeopoliticalFinder.getZone("lAgOs")); }

    @Test
    void testLeadingTrailingSpaces() { assertEquals(Zone.NORTH_EAST, GeopoliticalFinder.getZone("  Borno  ")); }
}