import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

class DegreesTests {
    @Test
    void SinPI2() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin(Math.PI / 2)), formatter.format(TeylorRow.Teylor(Math.PI / 2, 4)));
    }

    @Test
    void MSinPI2() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin(-Math.PI / 2)), formatter.format(TeylorRow.Teylor(-Math.PI / 2, 4)));
    }

    @Test
    void Sin3PI2() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin((3 * Math.PI) / 2)), formatter.format(TeylorRow.Teylor((3 * Math.PI) / 2, 4)));
    }

    @Test
    void Sin5PI() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin((5 * Math.PI))), formatter.format(TeylorRow.Teylor((5 * Math.PI), 4)));
    }

    @Test
    void Sin5PI2() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin((5 * Math.PI)/2)), formatter.format(TeylorRow.Teylor((5 * Math.PI)/2, 4)));
    }

    @Test
    void Sin33PI() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin((33 * Math.PI))), formatter.format(TeylorRow.Teylor((33 * Math.PI), 4)));
    }

    @Test
    void Sin93PI2() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin((93 * Math.PI)/2)), formatter.format(TeylorRow.Teylor((93 * Math.PI) / 2, 4)));
    }

    @Test
    void Sin100PI() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);
        assertEquals(formatter.format(Math.sin((100 * Math.PI))), formatter.format(TeylorRow.Teylor((100 * Math.PI), 3)));
    }
}