public class WordWrapper {
    public static String WrapText(String text, int columnWidth) {
        String wrappedText = ""; //text.substring(0,columnWidth);
        String remainingText = text;
        while(remainingText.length() > columnWidth) {
            wrappedText = wrappedText.concat(remainingText.substring(0, columnWidth)).concat("\n");
            remainingText = remainingText.substring(columnWidth);
        }

        return wrappedText.concat(remainingText);
    }
}
