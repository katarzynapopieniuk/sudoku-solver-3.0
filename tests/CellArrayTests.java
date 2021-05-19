import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CellArrayTests {

    @Test
    void whenGetInSameRowIsCalledCorrectSetShouldBeReturned() {
        HashSet<Cell> cells = new HashSet<>();
        CellArray array = new CellArray(cells);
        HashSet<Cell> expectedSet = new HashSet<>();
        Cell c1 = new Cell(1, 1, 1);
        Cell c2 = new Cell(1, 2, 3);
        Cell c3 = new Cell(3, 3, 6);

        cells.add(c1);
        cells.add(c2);
        cells.add(c3);
        expectedSet.add(c2);

        assertEquals(expectedSet, array.getCellsInSameRow(c1));
    }

    @Test
    void whenGetInSameColumnIsCalledCorrectSetShouldBeReturned() {
        HashSet<Cell> cells = new HashSet<>();
        CellArray array = new CellArray(cells);
        HashSet<Cell> expectedSet = new HashSet<>();
        Cell c1 = new Cell(1, 3, 1);
        Cell c2 = new Cell(1, 2, 3);
        Cell c3 = new Cell(3, 3, 6);

        cells.add(c1);
        cells.add(c2);
        cells.add(c3);
        expectedSet.add(c3);

        assertEquals(expectedSet, array.getCellsInSameColumn(c1));
    }
}