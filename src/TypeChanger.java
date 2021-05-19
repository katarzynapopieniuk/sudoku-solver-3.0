import java.util.ArrayList;

public class TypeChanger {
    public static CellArray ArrayToCellsArray(int[][] board) {
        ArrayList<Cell> cells = new ArrayList<>();
        for(int i = Constants.MININDEX; i <= Constants.MAXINDEX; i++) {
            for( int j = Constants.MININDEX; j <= Constants.MAXINDEX; j++) {
                cells.add(new Cell(i+1, j+1, board[i][j]));
            }
        }
        return new CellArray(cells);
    }

    public static int[][] CellsArrayToArray(CellArray cellArray) {
        int[][] board = new int[Constants.GRIDSIZE][Constants.GRIDSIZE];
        for(int i = Constants.MININDEX; i<= Constants.MAXINDEX; i++){
            for( int j = Constants.MININDEX; j <= Constants.MAXINDEX; j++) {
                board[i][j] = cellArray.getCellAtCoordinates(i+1, j+1).getValue();
            }
        }
        return board;
    }
}
