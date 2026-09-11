public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier) {
            case "private":
                return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
            case "default":
                return "SAME_CLASS".equals(accessorContext)
                        || "SAME_PACKAGE".equals(accessorContext) ? "ALLOWED" : "DENIED";
            case "protected":
                return "SAME_CLASS".equals(accessorContext)
                        || "SAME_PACKAGE".equals(accessorContext)
                        || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)
                        ? "ALLOWED" : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        StringBuilder summary = new StringBuilder();

        for (String modifier : modifiers) {
            int allowed = 0;
            int denied = 0;
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2 && modifier.equals(attempt[0])) {
                    if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                        allowed++;
                    } else {
                        denied++;
                    }
                }
            }
            if (summary.length() > 0) {
                summary.append(" | ");
            }
            summary.append(modifier).append(": ")
                    .append(allowed).append(" allowed / ")
                    .append(denied).append(" denied");
        }
        return summary.toString();
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        for (int index = 0; index < attempts.length; index++) {
            String[] attempt = attempts[index];
            if (attempt == null || attempt.length < 2
                    || "DENIED".equals(classifyAccess(attempt[0], attempt[1]))) {
                if (attempt == null || attempt.length < 2) {
                    return "Invalid attempt (#" + (index + 1) + ")";
                }
                return attempt[0] + " via " + attempt[1] + " (attempt #" + (index + 1) + ")";
            }
        }
        return "None Denied";
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {
            if (attempt == null || attempt.length < 2) {
                denied++;
            } else if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                allowed++;
            } else {
                denied++;
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeBatch(attempts));
    }
}