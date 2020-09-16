import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {
    @Test
    public void theTextIsCorrectlyEncoded() {
        assertEquals("m&gig", Encoder.encode("yisus"));
    }

    @Test
    public void aTextWithNotValidCharacterThrowsAnException() {
        assertThrows(IllegalArgumentException.class, ()->{
            Encoder.encode("yisus.");
        });
    }

    @Test
    public void anEmpyStringIsEncodedToEmptyString() {
        assertEquals("", Encoder.encode(""));
    }

}