public class CellReference {
    private Cell cell;
    private boolean exists;

    public CellReference(Cell cell) {
        this.cell = cell;
        this.exists = Constants.EXISTS;
    }

    public CellReference() {
        this.cell = new Cell(Constants.NOVALUE, Constants.NOVALUE);
        this.exists = Constants.DOESNTEXISTS;
    }

    public Cell getCell() {
        return cell;
    }

    public boolean exists() {
        return exists;
    }
}
