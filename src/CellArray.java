import java.util.HashSet;
import java.util.stream.Collectors;

public class CellArray {
    private HashSet<Cell> cells;

    public CellArray(HashSet<Cell> cells) {
        this.cells = cells;
    }

    public HashSet<Cell> getCellsInSameRow(Cell cell) {
        return (HashSet<Cell>) cells.stream().filter(c -> c.isInSameRow(cell) && c != cell).collect(Collectors.toSet());
    }

    public HashSet<Cell> getCellsInSameColumn(Cell cell) {
        return (HashSet<Cell>) cells.stream().filter(c -> c.isInSameColumn(cell) && c != cell).collect(Collectors.toSet());
    }
}
