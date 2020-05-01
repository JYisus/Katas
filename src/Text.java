import javax.swing.plaf.basic.BasicToolBarSeparatorUI;
import java.util.Objects;

public class Text {
    private final String text;

    private Text(String text) {
        this.text = text;
    }

    public static Text createText(String text) {
        if (text == null) {
            return new Text("");
        }
        return new Text(text);
    }

    public String value() {
        return text;
    }

    public boolean fitsIn(ColumnWidth columnWidth) {
        return text.length() <= columnWidth.value();
    }

    public Text concat(Text auxText) {
        return Text.createText(text + auxText.text);
    }

    public Text remainingText(ColumnWidth columnWidth) {
        return createText(text.substring(columnWidth.value()));
    }

    public Text wrapLine(ColumnWidth columnWidth) {
        return Text.createText(text.substring(0, columnWidth.value())+"\n");
    }

    public Text wordWrap(ColumnWidth columnWidth) {
        if(fitsIn(columnWidth)) {
            return this;
        }

        Text wrappedLine = wrapLine(columnWidth);
        Text remainingText = remainingText(columnWidth);

        System.out.println(wrappedLine);

        return wrappedLine.concat(remainingText.wordWrap(columnWidth));
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return Objects.equals(text, text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
