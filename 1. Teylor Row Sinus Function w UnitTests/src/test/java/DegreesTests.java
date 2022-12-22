import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

class DegreesTests {
    @Test
    void SinPI2() {
        assertEquals(Math.sin(Math.PI / 2), TeylorRow.Teylor(Math.PI / 2, 4), 0.0001);
    }

    @Test
    void MSinPI2() {
        assertEquals(Math.sin(-Math.PI / 2), TeylorRow.Teylor(-Math.PI / 2, 4), 0.0001);
    }

    @Test
    void Sin3PI2() {
        assertEquals(Math.sin((3 * Math.PI) / 2), TeylorRow.Teylor((3 * Math.PI) / 2, 4), 0.0001);
    }

    @Test
    void Sin5PI() {
        assertEquals(Math.sin((5 * Math.PI)), TeylorRow.Teylor((5 * Math.PI), 4), 0.0001);
    }

    @Test
    void Sin5PI2() {
        assertEquals(Math.sin((5 * Math.PI)/2), TeylorRow.Teylor((5 * Math.PI)/2, 4), 0.0001);
    }

    @Test
    void Sin33PI() {
        assertEquals(Math.sin((33 * Math.PI)), TeylorRow.Teylor((33 * Math.PI), 4), 0.0001);
    }

    @Test
    void Sin93PI2() {
        assertEquals(Math.sin((93 * Math.PI)/2), TeylorRow.Teylor((93 * Math.PI) / 2, 4), 0.0001);
    }

    @Test
    void Sin100PI() {
        assertEquals(Math.sin((100 * Math.PI)), TeylorRow.Teylor((100 * Math.PI), 3), 0.0001);
    }
}