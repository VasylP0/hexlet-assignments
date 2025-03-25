package exercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReversedSequenceTest {

    @Test
    void testToString() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals("fedcba", text.toString());
    }

    @Test
    void testCharAt() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals('e', text.charAt(1));
        assertEquals('f', text.charAt(0));
        assertEquals('d', text.charAt(2));
    }

    @Test
    void testLength() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals(6, text.length());
    }

    @Test
    void testSubSequence() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals("edc", text.subSequence(1, 4).toString());
    }
}
