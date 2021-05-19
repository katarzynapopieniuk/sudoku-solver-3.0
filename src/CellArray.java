import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class CellArray {
    private final ArrayList<Cell> cells;
    private final ListIterator<Cell> iterator;
    private Cell current;

    public CellArray(ArrayList<Cell> cells) {
        this.cells = cells;
        this.iterator = this.cells.listIterator();
    }

    public Cell getCurrent() {
        return current;
    }

    public ArrayList<Cell> getCellsInSameRow(Cell cell) {
        return (ArrayList<Cell>) cells.stream().filter(c -> c.isInSameRow(cell) && c != cell).collect(Collectors.toList());
    }

    public ArrayList<Cell> getCellsInSameColumn(Cell cell) {
        return (ArrayList<Cell>) cells.stream().filter(c -> c.isInSameColumn(cell) && c != cell).collect(Collectors.toList());
    }

    public ArrayList<Cell> getCellsInSameSquare(Cell cell) {
        return (ArrayList<Cell>) cells.stream().filter(c -> c.isInSameSquare(cell) && c != cell).collect(Collectors.toList());
    }

    public CellArray getCopy() {
        ArrayList<Cell> copiedCells = new ArrayList<>();
        for( Cell cell : cells) {
            copiedCells.add(cell.getCopy());
        }
        return new CellArray(copiedCells);
    }

    public CellReference getNextEmpty() {
        while (iterator.hasNext()) {
            current = iterator.next();
            if(current.isEmpty()) {
                return new CellReference(current);
            }
        }
        return new CellReference();
    }

    public CellReference getPreviousEmpty() {
        while (iterator.hasPrevious()) {
            current = iterator.previous();
            if(current.isEmpty()) {
                return new CellReference(current);
            }
        }
        return new CellReference();
    }

    public boolean doesValueMatchForCell(Cell cell) {
        current = cell;
        return ! doesValueAlreadyExistsInCurrentCellRange();
    }

    private boolean doesValueAlreadyExistsInCurrentCellRange() {
        return doesSetContainCellWithSameValue(getCellsInSameColumn(current), current) ||
                doesSetContainCellWithSameValue(getCellsInSameRow(current), current) ||
                doesSetContainCellWithSameValue(getCellsInSameSquare(current), current);
    }

    private boolean doesSetContainCellWithSameValue(ArrayList<Cell> set, Cell cell) {
        return set.stream().anyMatch(x -> x.isValueEqual(cell));
    }

    public Cell findCopy(Cell cell) throws InvalidAttributeValueException {
        for (Cell c : cells) {
            if(c.hasSameCoordinates(cell))
                return c;
        }
        throw new InvalidAttributeValueException("No matching cell in array");
    }

    public Cell getCellAtCoordinates(int row, int column) {
        return cells.stream().filter(c -> c.getRow() == row & c.getColumn() == column).findFirst().orElse(new Cell(Constants.NOVALUE, Constants.NOVALUE));
    }


}
