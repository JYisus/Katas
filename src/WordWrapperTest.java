import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordWrapperTest {
    @Test
    public void returnsTheSameStringIfSmallerThanColumnWidth() {
        String text = "h";
        assertEquals("h", WordWrapper.WrapText(text, 3));
    }

    @Test
    public void returnsTheSameStringIfSameLengthThanColumnWidth() {
        String text = "ho";
        assertEquals("ho", WordWrapper.WrapText(text, 2));
    }

    @Test
    public void aTextWithAFewBiggerThanColumnWidth() {
        String text = "hola";
        assertEquals("ho\nla", WordWrapper.WrapText(text, 2));
    }

    @Test
    public void aTextWithLengthMultipleOfColumnWidth() {
        String text = "hola qué tal";
        assertEquals("ho\nla\n q\nué\n t\nal", WordWrapper.WrapText(text, 2));
    }

    @Test
    public void aTextWithLengthNOMultipleOfColumnWidth() {
        String text = "hola qué tal?";
        assertEquals("ho\nla\n q\nué\n t\nal\n?", WordWrapper.WrapText(text, 2));
    }

    @Test
    public void columnWidthCantBe0OrNegative() {
        String text = "irrelevant";
        assertThrows(IllegalArgumentException.class, () -> WordWrapper.WrapText(text, 0));
    }

    @Test
    public void aNullStringIsWrappedLikeEmptyString() {
        assertEquals("", WordWrapper.WrapText(null, 3));
    }
}