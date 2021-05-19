import javax.management.InvalidAttributeValueException;

public class Main {

    static final int[][] board = {
            {0, 0, 0, 0, 5, 3, 6, 4, 9},
            {9, 4, 3, 6, 8, 2, 1, 7, 5},
            {6, 7, 5, 4, 9, 1, 2, 8, 3},
            {1, 5, 4, 2, 3, 7, 8, 9, 6},
            {3, 6, 9, 8, 4, 5, 7, 2, 1},
            {2, 8, 7, 1, 6, 9, 5, 3, 4},
            {5, 2, 1, 9, 7, 4, 3, 6, 8},
            {4, 3, 8, 5, 2, 6, 9, 1, 7},
            {7, 9, 6, 3, 1, 8, 4, 5, 2},
    };

    public static void main(String[] args) {
        Solver solver = new Solver(TypeChanger.ArrayToCellsArray(board));
        CellArray solution;
        try {
            solution = solver.solve();
        } catch (InvalidAttributeValueException e) {
            System.out.print("Exception");
            return;
        }
        Printer.printCellArray(solution);

    }
}
