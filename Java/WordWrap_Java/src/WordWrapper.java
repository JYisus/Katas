public class WordWrapper {
    public static String WrapTextLoop(String auxText, int auxColumnWidth) throws IllegalArgumentException {
        Text text = Text.createText(auxText);
        ColumnWidth columnWidth = ColumnWidth.createColumnWidth(auxColumnWidth);

        Text wrappedText = Text.createText("");

        while(!text.fitsIn(columnWidth)) {
            wrappedText = wrappedText.concat(text.wrapLine(columnWidth));
            text = text.remainingText(columnWidth);
        }
        return wrappedText.concat(text).toString();
    }


    public static String WrapTextRecursive(String auxText, int auxColumnWidth) throws IllegalArgumentException {
        Text text = Text.createText(auxText);
        ColumnWidth columnWidth = ColumnWidth.createColumnWidth(auxColumnWidth);

        return text.wordWrap(columnWidth).toString();
    }
}
