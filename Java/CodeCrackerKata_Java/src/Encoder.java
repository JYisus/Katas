public class Encoder {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static final String encriptionKey = "!)\\\"(£*%&><@abcdefghijklmno";
    public static String encode(String plainText) throws IllegalArgumentException {
        if (plainText == "") return "";
        String encodedText = "";
        for (String letter: plainText.split("")) {
            try {
                int letterPositionInAlphabet = alphabet.indexOf(letter);
                encodedText+=encriptionKey.charAt(letterPositionInAlphabet);
            } catch (Exception e) {
                throw new IllegalArgumentException("El caracter " + letter + " no se encuentra en el alfabeto");
            }


        }
        return encodedText;
    }
}
