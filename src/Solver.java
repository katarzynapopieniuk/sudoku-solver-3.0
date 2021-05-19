import javax.management.InvalidAttributeValueException;

public class Solver {
    private final CellArray original;
    private final CellArray workSheet;
    private CellReference currentOriginalCellReference;

    public Solver(CellArray original) {
        this.original = original;
        this.workSheet = original.getCopy();
    }

    public CellArray solve() throws InvalidAttributeValueException {

        while (true) {

            currentOriginalCellReference = original.getNextEmpty();
            if(! currentOriginalCellReference.exists())     // solved
                return workSheet;

            while (!tryFillCell()) {
                workSheet.findCopy(original.getCurrent()).resetValue();
                currentOriginalCellReference = original.getPreviousEmpty();
                if(! currentOriginalCellReference.exists()) // solution doesn't exist
                    return original;
            }
        }
    }

    private boolean tryFillCell() throws InvalidAttributeValueException {
        Cell current = workSheet.findCopy(original.getCurrent());
        if(current.getValue() == Constants.MAXVALUE)
            return false;
        while (current.tryIncrementValue() && ! workSheet.doesValueMatchForCell(current))
            ;
        return workSheet.doesValueMatchForCell(current);
    }
}
