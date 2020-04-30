public class WordWrapper {
    public static String WrapText(String text, int columnWidth) throws IllegalArgumentException {
        if (columnWidth < 1) {
            throw new IllegalArgumentException("The column width must be at least 1");
        }
        if(text == null) {
            return "";
        }
        String wrappedText = ""; //text.substring(0,columnWidth);
        String remainingText = text;
        while(remainingText.length() > columnWidth) {
            wrappedText = wrappedText.concat(remainingText.substring(0, columnWidth)).concat("\n");
            remainingText = remainingText.substring(columnWidth);
        }

        return wrappedText.concat(remainingText);
    }
}
