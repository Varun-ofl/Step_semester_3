import java.util.Arrays;

public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    static {
        System.out.println("Circulation ledger loaded");
    }

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] correctedBookIds = getBookIds();
        correctedBookIds[index] = newId;
        return new LoanReceipt(memberId, correctedBookIds);
    }

    public String getMemberId() {
        return memberId;
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
            } else {
                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) {
                    referenceOnly++;
                } else {
                    regular++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | " + regular + " regular";
    }

    public static void main(String[] args) {
        LoanReceipt receipt = new LoanReceipt("LIB-8841", new String[] {"BK-100", "BK-101"});
        String[] books = receipt.getBookIds();
        books[0] = "HACKED";
        System.out.println(receipt.getBookIds()[0]);

        LoanReceipt corrected = receipt.withCorrectedBookId(1, "BK-102");
        System.out.println(Arrays.toString(receipt.getBookIds()));
        System.out.println(Arrays.toString(corrected.getBookIds()));

        LoanReceipt[] receipts = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[] {"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[] {"BK-201"})
        };
        System.out.println(processNightlyCirculation(receipts));
    }
}