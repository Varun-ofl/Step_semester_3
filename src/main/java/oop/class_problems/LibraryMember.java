package oop.class_problems;

public class LibraryMember {
    private static int membersEnrolled;
    private static int nextMemberNumber = 100;

    protected final String memberId;
    protected final int borrowLimit;
    protected int booksBorrowed;
    private final int[] fineHistory = new int[10];
    private int fineCount;
    private String lastBorrowedGenre;
    public final String memberNumber;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("memberId must contain at least 4 non-whitespace characters");
        }
        if (borrowLimit <= 0) {
            throw new IllegalArgumentException("borrowLimit must be positive");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.memberNumber = String.format("LIB-%03d", ++nextMemberNumber);
        membersEnrolled++;
    }

    public LibraryMember(int borrowLimit) {
        this("MEM" + (nextMemberNumber + 1), borrowLimit);
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public void borrowBook(String genre) {
        lastBorrowedGenre = genre;
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getLastBorrowedGenre() {
        return lastBorrowedGenre;
    }

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        int[] history = new int[fineCount];
        System.arraycopy(fineHistory, 0, history, 0, fineCount);
        return history;
    }

    public int getTotalFine() {
        int total = 0;
        for (int index = 0; index < fineCount; index++) {
            total += fineHistory[index];
        }
        return total;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;
        for (String memberId : memberIds) {
            try {
                LibraryMember enrolledMember = new LibraryMember(memberId, borrowLimit);
                enrolled += enrolledMember.borrowLimit > 0 ? 1 : 0;
            } catch (IllegalArgumentException exception) {
                rejected++;
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        return "General member";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember member : members) {
            total += member.getBooksBorrowed();
        }
        return total;
    }

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder report = new StringBuilder();
        for (LibraryMember member : members) {
            report.append(member.displayInfo());
            if (member instanceof StudentMember studentMember) {
                report.append(" [Course via downcast: ")
                        .append(studentMember.getCourse())
                        .append("]");
            }
            report.append(" | ");
        }
        return report.toString();
    }

    public static boolean isValidRenewalCode(String code) {
        return code != null && code.matches("R\\d{2}[A-Z]");
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int skipped = 0;
        int faculty = 0;
        int regular = 0;
        for (LibraryMember member : members) {
            if (member == null) {
                skipped++;
            } else {
                processed++;
                if (member instanceof FacultyMember) {
                    faculty++;
                } else {
                    regular++;
                }
            }
        }
        return processed + " processed | " + skipped + " null skipped | "
                + faculty + " faculty | " + regular + " regular";
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}