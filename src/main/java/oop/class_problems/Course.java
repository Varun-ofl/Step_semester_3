import java.util.Scanner;

public class Course {
    private String code;
    private String title;
    private int credits;
    private int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter theory course code, title and credits: ");
        Course theoryCourse = new Course(scanner.next(), scanner.next(), scanner.nextInt());

        System.out.print("Enter lab course code, title, credits and lab credits: ");
        Course labCourse = new Course(
                scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt());

        System.out.printf("%s total credits: %d%n", theoryCourse.code, theoryCourse.totalCredits());
        System.out.printf("%s total credits: %d%n", labCourse.code, labCourse.totalCredits());
        scanner.close();
    }
}