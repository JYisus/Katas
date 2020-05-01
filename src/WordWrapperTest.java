import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordWrapperTest {
    @Test
    public void returnsTheSameStringIfSmallerThanColumnWidth() {
        assertEquals("h", WordWrapper.WrapTextLoop("h", 3));
    }

    @Test
    public void returnsTheSameStringIfSameLengthThanColumnWidth() {
        assertEquals("ho", WordWrapper.WrapTextLoop("ho", 2));
    }

    @Test
    public void aTextWithAFewBiggerThanColumnWidth() {
        assertEquals("ho\nla", WordWrapper.WrapTextLoop("hola", 2));
    }

    @Test
    public void aTextWithLengthMultipleOfColumnWidth() {
        assertEquals("ho\nla\n q\nué\n t\nal", WordWrapper.WrapTextLoop("hola qué tal", 2));
    }

    @Test
    public void aTextWithLengthNOMultipleOfColumnWidth() {
        assertEquals("ho\nla\n q\nué\n t\nal\n?", WordWrapper.WrapTextLoop("hola qué tal?", 2));
    }

    @Test
    public void columnWidthCantBe0OrNegative() {
        assertThrows(IllegalArgumentException.class, () -> WordWrapper.WrapTextLoop("irrelevant", 0));
    }

    @Test
    public void aNullStringIsWrappedLikeEmptyString() {
        assertEquals("", WordWrapper.WrapTextLoop(null, 3));
    }


    @Test
    public void returnsTheSameStringIfSmallerThanColumnWidthRecursive() {
        assertEquals("h", WordWrapper.WrapTextRecursive("h", 3));
    }

    @Test
    public void returnsTheSameStringIfSameLengthThanColumnWidthRecursive() {
        assertEquals("ho", WordWrapper.WrapTextRecursive("ho", 2));
    }

    @Test
    public void aTextWithAFewBiggerThanColumnWidthRecursive() {
        assertEquals("ho\nla", WordWrapper.WrapTextRecursive("hola", 2));
    }

    @Test
    public void aTextWithLengthMultipleOfColumnWidthRecursive() {
        assertEquals("ho\nla\n q\nué\n t\nal", WordWrapper.WrapTextRecursive("hola qué tal", 2));
    }

    @Test
    public void aTextWithLengthNOMultipleOfColumnWidthRecursive() {
        assertEquals("ho\nla\n q\nué\n t\nal\n?", WordWrapper.WrapTextRecursive("hola qué tal?", 2));
    }

    @Test
    public void columnWidthCantBe0OrNegativeRecursive() {
        assertThrows(IllegalArgumentException.class, () -> WordWrapper.WrapTextRecursive("irrelevant", 0));
    }

    @Test
    public void aNullStringIsWrappedLikeEmptyStringRecursive() {
        assertEquals("", WordWrapper.WrapTextRecursive(null, 3));
    }
}