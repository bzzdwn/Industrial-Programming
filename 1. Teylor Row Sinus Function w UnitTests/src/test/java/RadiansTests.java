import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadiansTests {
    @Test
    void MSin1() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin(-1)), formatter.format(TeylorRow.Teylor(-1, 3)));
    }
    @Test
    void Sin0() {
        assertEquals(Math.sin(0), TeylorRow.Teylor(0, 3));
    }

    @Test
    void Sin1() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin(1)), formatter.format(TeylorRow.Teylor(1, 3)));
    }

    @Test
    void Sin2() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin(2)), formatter.format(TeylorRow.Teylor(2, 4)));
    }

    @Test
    void Sin3() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin(3)), formatter.format(TeylorRow.Teylor(3, 4)));
    }

    @Test
    void Sin4() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin(4)), formatter.format(TeylorRow.Teylor(4, 4)));
    }
    @Test
    void Sin5() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin(5)), formatter.format(TeylorRow.Teylor(5, 4)));
    }
    @Test
    void Sin25() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        assertEquals(formatter.format(Math.sin(25)), formatter.format(TeylorRow.Teylor(25, 2)));
    }
    @Test
    void Sin69() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        assertEquals(formatter.format(Math.sin(69)), formatter.format(TeylorRow.Teylor(69, 2)));
    }
    @Test
    void Sin1000() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        assertEquals(formatter.format(Math.sin(1000)), formatter.format(TeylorRow.Teylor(1000, 2)));
    }
}
