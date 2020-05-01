import jdk.jshell.EvalException;

import java.util.Objects;

public class ColumnWidth {
    private final int columnWidth;

    private ColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    static ColumnWidth createColumnWidth(int columnWidth) throws IllegalArgumentException{
        if (columnWidth < 1) {
            throw new IllegalArgumentException("The column width must be at least 1");
        }
        return new ColumnWidth(columnWidth);
    }

    public int value() {
        return columnWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnWidth that = (ColumnWidth) o;
        return columnWidth == that.columnWidth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnWidth);
    }
}
