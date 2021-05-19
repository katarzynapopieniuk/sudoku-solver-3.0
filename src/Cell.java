public class Cell {
    private final int row;
    private final int column;
    private int value;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.value = Constants.NOVALUE;
    }

    public Cell(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean isValueEqual(Cell cell) {
        return this.value == cell.getValue();
    }

    public Boolean isInSameRow(Cell cell) {
        return this.row == cell.getRow();
    }

    public Boolean isInSameColumn(Cell cell) {
        return this.column == cell.getColumn();
    }
}
