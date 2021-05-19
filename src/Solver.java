public class Solver {
    private CellArray original;
    private CellArray workSheet;

    public Solver(CellArray original) {
        this.original = original;
        this.workSheet = original.getCopy();
    }

    public CellArray solve() {
        return workSheet;
    }


}
