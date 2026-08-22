import java.util.Scanner;

public class Student {
    private String name;
    private int attendance;
    private static final String COLLEGE_NAME = "SRM Institute of Science and Technology";
    private static int studentCount;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(COLLEGE_NAME);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first student name and attendance: ");
        Student firstStudent = new Student(scanner.next(), scanner.nextInt());

        System.out.print("Enter second student name and attendance: ");
        Student secondStudent = new Student(scanner.next(), scanner.nextInt());

        Student.printCollegeInfo();
        scanner.close();
    }
}