public class BookInventory {
    private final int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        if (copiesTotal <= 0 || copiesTotal > 500) {
            throw new IllegalArgumentException("copiesTotal must be between 1 and 500");
        }
        this.copiesTotal = copiesTotal;
        copiesAvailable = copiesTotal;
    }

    public void checkout() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }
}