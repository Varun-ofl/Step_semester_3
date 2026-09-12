package oop.class_problems;

public final class MembershipNumbersRenewalAudit {
    private MembershipNumbersRenewalAudit() {
    }

    public static boolean isValidRenewalCode(String code) {
        return LibraryMember.isValidRenewalCode(code);
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        return LibraryMember.processNightlyAudit(members);
    }

    public static int getMembersEnrolled() {
        return LibraryMember.getMembersEnrolled();
    }
}