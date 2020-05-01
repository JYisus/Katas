import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordWrapperTest {
    @Test
    public void returnsTheSameStringIfSmallerThanColumnWidth() {
        assertEquals("h", WordWrapper.WrapText("h", 3));
    }

    @Test
    public void returnsTheSameStringIfSameLengthThanColumnWidth() {
        assertEquals("ho", WordWrapper.WrapText("ho", 2));
    }

    @Test
    public void aTextWithAFewBiggerThanColumnWidth() {
        assertEquals("ho\nla", WordWrapper.WrapText("hola", 2));
    }

    @Test
    public void aTextWithLengthMultipleOfColumnWidth() {
        assertEquals("ho\nla\n q\nué\n t\nal", WordWrapper.WrapText("hola qué tal", 2));
    }

    @Test
    public void aTextWithLengthNOMultipleOfColumnWidth() {
        assertEquals("ho\nla\n q\nué\n t\nal\n?", WordWrapper.WrapText("hola qué tal?", 2));
    }

    @Test
    public void columnWidthCantBe0OrNegative() {
        assertThrows(IllegalArgumentException.class, () -> WordWrapper.WrapText("irrelevant", 0));
    }

    @Test
    public void aNullStringIsWrappedLikeEmptyString() {
        assertEquals("", WordWrapper.WrapText(null, 3));
    }
}