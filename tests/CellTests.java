import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTests {
    Cell c1 = new Cell(1, 1);
    Cell c2 = new Cell(2, 2, 9);
    Cell c3 = new Cell(9, 9);
    Cell c4 = new Cell(7, 8);
    Cell c5 = new Cell(5, 5);
    Cell c6 = new Cell(6, 4);

    @Test
    void whenCellsAreInSameSectorShouldReturnTrue() {
        assertTrue(c1.isInSameSquare(c2));
        assertTrue(c3.isInSameSquare(c4));
        assertTrue(c5.isInSameSquare(c6));
    }

    @Test
    void whenCellsAreInSeparateSquaresShouldReturnFalse() {
        assertFalse(c1.isInSameSquare(c3));
        assertFalse(c1.isInSameSquare(c4));
        assertFalse(c5.isInSameSquare(c4));
    }

    @Test
    void whenValueCanBeIncrementedShouldIncrement() {
        assertTrue(c1.tryIncrementValue());
        assertEquals(1, c1.getValue());
    }

    @Test
    void whenCantIncrementValueShouldReturnFalse() {
        assertFalse(c2.tryIncrementValue());
        assertEquals(9, c2.getValue());
    }

    @Test
    void correctCellSectorShouldBeReturned() {
        assertEquals(Constants.UPPERROWS + Constants.LEFTCOLUMNS, c1.getSquareNumber());
        assertEquals(Constants.UPPERROWS + Constants.LEFTCOLUMNS, c2.getSquareNumber());
        assertEquals(Constants.LOWERROWS + Constants.RIGHTCOLUMNS, c3.getSquareNumber());
        assertEquals(Constants.LOWERROWS + Constants.RIGHTCOLUMNS, c4.getSquareNumber());
        assertEquals(Constants.MIDDLEROWS + Constants.MIDDLECOLUMNS, c5.getSquareNumber());
        assertEquals(Constants.MIDDLEROWS + Constants.MIDDLECOLUMNS, c6.getSquareNumber());
    }
}