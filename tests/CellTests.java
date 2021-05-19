import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTests {
    Cell c1 = new Cell(1, 1);
    Cell c2 = new Cell(2, 2);
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
}