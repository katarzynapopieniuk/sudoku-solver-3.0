import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class CellArray {
    private ArrayList<Cell> cells;
    private ListIterator<Cell> iterator;

    public CellArray(ArrayList<Cell> cells) {
        this.cells = cells;
        this.iterator = this.cells.listIterator();
    }

    public HashSet<Cell> getCellsInSameRow(Cell cell) {
        return (HashSet<Cell>) cells.stream().filter(c -> c.isInSameRow(cell) && c != cell).collect(Collectors.toSet());
    }

    public HashSet<Cell> getCellsInSameColumn(Cell cell) {
        return (HashSet<Cell>) cells.stream().filter(c -> c.isInSameColumn(cell) && c != cell).collect(Collectors.toSet());
    }

    public HashSet<Cell> getCellsInSameSquare(Cell cell) {
        return (HashSet<Cell>) cells.stream().filter(c -> c.isInSameSquare(cell) && c != cell).collect(Collectors.toSet());
    }

    public CellArray getCopy() {
        ArrayList<Cell> copiedCells = new ArrayList<>();
        for( Cell cell : cells) {
            copiedCells.add(cell.getCopy());
        }
        return new CellArray(copiedCells);
    }

    public CellReference getNextEmpty() {
        Cell cell;
        while (iterator.hasNext()) {
            cell = iterator.next();
            if(cell.isEmpty()) {
                return new CellReference(cell);
            }
        }
        return new CellReference();
    }

    public CellReference getPreviousEmpty() {
        Cell cell;
        while (iterator.hasPrevious()) {
            cell = iterator.previous();
            if(cell.isEmpty()) {
                return new CellReference(cell);
            }
        }
        return new CellReference();
    }
}
