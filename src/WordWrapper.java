public class WordWrapper {
    public static String WrapText(String text, int columnWidth) {
        String wrappedText = text.substring(0,columnWidth).concat("\n");
        String remainingText = text.substring(columnWidth);
        return wrappedText.concat(remainingText);
    }
}
