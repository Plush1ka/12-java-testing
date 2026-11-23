
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerDecodeTest {

    @Test
    void testDecimal() {
        assertEquals(123, Integer.decode("123"));
    }

    @Test
    void testNegative() {
        assertEquals(-10, Integer.decode("-10"));
    }

    @Test
    void testPositiveSign() {
        assertEquals(10, Integer.decode("+10"));
    }

    @Test
    void testHexLowercase() {
        assertEquals(16, Integer.decode("0x10"));
    }

    @Test
    void testHexUppercase() {
        assertEquals(16, Integer.decode("0X10"));
    }

    @Test
    void testHexHash() {
        assertEquals(16, Integer.decode("#10"));
    }

    @Test
    void testOctal() {
        assertEquals(8, Integer.decode("010"));
    }

    @Test
    void testSingleZero() {
        assertEquals(0, Integer.decode("0"));
    }

    @Test
    void testNegativeHex() {
        assertEquals(-16, Integer.decode("-0x10"));
    }

    @Test
    void testMinValue() {
        assertEquals(Integer.MIN_VALUE,
                Integer.decode("-2147483648"));
    }

    @Test
    void testEmptyString() {
        assertThrows(NumberFormatException.class,
                () -> Integer.decode(""));
    }

    @Test
    void testWrongMinusPosition() {
        assertThrows(NumberFormatException.class,
                () -> Integer.decode("0x-10"));
    }

    @Test
    void testWrongPlusPosition() {
        assertThrows(NumberFormatException.class,
                () -> Integer.decode("0x+10"));
    }

    @Test
    void testInvalidString() {
        assertThrows(NumberFormatException.class,
                () -> Integer.decode("abc"));
    }

    @Test
    void testOverflow() {
        assertThrows(NumberFormatException.class,
                () -> Integer.decode("2147483648"));
    }

    @Test
    void testNull() {
        assertThrows(NullPointerException.class,
                () -> Integer.decode(null));
    }
}
