public class Printer {
    public static void printArray(int[][] sudokuBoard) {
        StringBuilder builder = new StringBuilder();
        builder.append("_".repeat(Constants.GRIDSIZE * 5));
        builder.append("\n");
        for(int[] row : sudokuBoard) {
            for(int i = Constants.MININDEX; i<=Constants.MAXINDEX; i++)
                builder.append(" | ").append(row[i]);
            builder.append(" |\n");
            builder.append("_".repeat(Constants.GRIDSIZE * 5));
            builder.append("\n");
        }
        System.out.print(builder);
    }

    public static void printCellArray(CellArray cellArray) {
        printArray(TypeChanger.CellsArrayToArray(cellArray));
    }
}
