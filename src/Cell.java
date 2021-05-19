public class Cell {
    private final int row;
    private final int column;
    private final int squareNumber;
    private int value;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.value = Constants.NOVALUE;
        this.squareNumber = countSquareNumber();
    }

    public Cell(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.squareNumber = countSquareNumber();
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

    public int getSquareNumber() {
        return squareNumber;
    }

    private int countSquareNumber() {
        return getRowSector() + getColumnSector();
    }

    private int getRowSector() {
        if(row >= 1 && row <= 3)
            return Constants.UPPERROWS;
        if(row >= 4 && row <= 6)
            return Constants.MIDDLEROWS;
        return Constants.LOWERROWS;
    }

    private int getColumnSector() {
        if(column >= 1 && column <= 3)
            return Constants.LEFTCOLUMNS;
        if(column >= 4 && column <= 6)
            return Constants.MIDDLECOLUMNS;
        return Constants.RIGHTCOLUMNS;
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

    public Boolean isInSameSquare(Cell cell) {
        return this.squareNumber == cell.getSquareNumber();
    }

    public Cell getCopy() {
        return new Cell(this.row, this.column, this.value);
    }

    public Boolean isEmpty() {
        return value == Constants.NOVALUE;
    }

    public void resetValue() {
        value = Constants.NOVALUE;
    }

    public boolean tryIncrementValue() {
        if(value < Constants.MAXVALUE) {
            value ++;
            return true;
        }
        return false;
    }

    public boolean hasSameCoordinates(Cell cell) {
        return isInSameRow(cell) && isInSameColumn(cell);
    }
}
