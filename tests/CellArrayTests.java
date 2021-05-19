import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CellArrayTests {

    @Test
    void whenGetInSameRowIsCalledCorrectSetShouldBeReturned() {
        ArrayList<Cell> cells = new ArrayList<>();
        CellArray array = new CellArray(cells);
        ArrayList<Cell> expectedList = new ArrayList<>();
        Cell c1 = new Cell(1, 1);
        Cell c2 = new Cell(1, 2);
        Cell c3 = new Cell(3, 3);

        cells.add(c1);
        cells.add(c2);
        cells.add(c3);
        expectedList.add(c2);

        assertIterableEquals(expectedList, array.getCellsInSameRow(c1));
    }

    @Test
    void whenGetInSameColumnIsCalledCorrectSetShouldBeReturned() {
        ArrayList<Cell> cells = new ArrayList<>();
        CellArray array = new CellArray(cells);
        ArrayList<Cell> expectedList = new ArrayList<>();
        Cell c1 = new Cell(1, 3);
        Cell c2 = new Cell(1, 2);
        Cell c3 = new Cell(3, 3);

        cells.add(c1);
        cells.add(c2);
        cells.add(c3);
        expectedList.add(c3);

        assertIterableEquals(expectedList, array.getCellsInSameColumn(c1));
    }

    @Test
    void whenGetInSameSquareIsCalledCorrectSetShouldBeReturned() {
        ArrayList<Cell> cells = new ArrayList<>();
        CellArray array = new CellArray(cells);
        ArrayList<Cell> expectedList = new ArrayList<>();
        Cell c1 = new Cell(1, 3);
        Cell c2 = new Cell(1, 2);
        Cell c3 = new Cell(3, 3);
        Cell c4 = new Cell(7, 8);
        Cell c5 = new Cell(5, 5);

        cells.add(c1);
        cells.add(c2);
        cells.add(c3);
        cells.add(c4);
        cells.add(c5);
        expectedList.add(c2);
        expectedList.add(c3);

        assertIterableEquals(expectedList, array.getCellsInSameSquare(c1));
    }

    @Test
    void whenNextEmptyCellExistsItShouldBeReturned() {
        ArrayList<Cell> cells = new ArrayList<>();
        Cell c1 = new Cell(1, 3);
        cells.add(c1);
        CellArray array = new CellArray(cells);
        CellReference ref = array.getNextEmpty();
        assertTrue(ref.exists());
        assertSame(c1, ref.getCell());
    }

    @Test
    void whenNoNextEmptyCellFalseShouldBeReturned() {
        ArrayList<Cell> cells = new ArrayList<>();
        CellArray array = new CellArray(cells);
        CellReference ref = array.getNextEmpty();
        assertFalse(ref.exists());
    }

    @Test
    void whenPreviousEmptyCellExistsItShouldBeReturned() {
        ArrayList<Cell> cells = new ArrayList<>();
        Cell c1 = new Cell(1, 3);
        Cell c2 = new Cell(2, 3);
        cells.add(c1);
        cells.add(c2);
        CellArray array = new CellArray(cells);
        array.getNextEmpty();
        CellReference ref = array.getPreviousEmpty();
        assertTrue(ref.exists());
        assertSame(c1, ref.getCell());
    }

    @Test
    void whenNoPreviousEmptyCellFalseShouldBeReturned() {
        ArrayList<Cell> cells = new ArrayList<>();
        CellArray array = new CellArray(cells);
        CellReference ref = array.getPreviousEmpty();
        assertFalse(ref.exists());
    }
}