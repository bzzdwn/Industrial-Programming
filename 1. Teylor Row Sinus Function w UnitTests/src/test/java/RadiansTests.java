import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadiansTests {
    @Test
    void MSin1() {
        assertEquals(Math.sin(-1), TeylorRow.Teylor(-1, 3), 0.0001);
    }
    @Test
    void Sin0() {
        assertEquals(Math.sin(0), TeylorRow.Teylor(0, 3));
    }

    @Test
    void Sin1() {
        assertEquals(Math.sin(1), TeylorRow.Teylor(1, 3),0.0001);
    }

    @Test
    void Sin2() {
        assertEquals(Math.sin(2), TeylorRow.Teylor(2, 4) ,0.0001);
    }

    @Test
    void Sin3() {
        assertEquals(Math.sin(3), TeylorRow.Teylor(3, 4), 0.0001);
    }

    @Test
    void Sin4() {
        assertEquals(Math.sin(4), TeylorRow.Teylor(4, 4), 0.0001);
    }
    @Test
    void Sin5() {
        assertEquals(Math.sin(5), TeylorRow.Teylor(5, 4), 0.0001);
    }
    @Test
    void Sin25() {
        assertEquals(Math.sin(25), TeylorRow.Teylor(25, 2), 0.001);
    }
    @Test
    void Sin69() {
        assertEquals(Math.sin(69), TeylorRow.Teylor(69, 2),0.001);
    }
    @Test
    void Sin1000() {
        assertEquals(Math.sin(1000), TeylorRow.Teylor(1000, 2), 0.01);
    }
    @Test
    void Sin10000() {
        assertEquals(Math.sin(10000), TeylorRow.Teylor(10000, 2), 0.01);
    }
    @Test
    void Sin100000() {
        assertEquals(Math.sin(100000), TeylorRow.Teylor(100000, 2), 0.01);
    }
    @Test
    void Sin1000000() {
        assertEquals(Math.sin(1000000), TeylorRow.Teylor(1000000, 2), 0.01);
    }
    @Test
    void Sin999999999() {
        assertEquals(Math.sin(999999999), TeylorRow.Teylor(999999999, 2), 0.01);
    }
    @Test
    void MSin10000() {
        assertEquals(Math.sin(-10000), TeylorRow.Teylor(-10000, 3), 0.0001);
    }
    @Test
    void MSin1000000() {
        assertEquals(Math.sin(-1000000), TeylorRow.Teylor(-1000000, 2), 0.0001);
    }
}
