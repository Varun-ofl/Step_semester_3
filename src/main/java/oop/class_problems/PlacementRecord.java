import java.util.Scanner;

public class PlacementRecord {
    private String studentName;
    private String company;
    private double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.printf("%s -> %s @ %.1f LPA%n", studentName, company, packageLpa);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlacementRecord[] records = new PlacementRecord[3];

        for (int index = 0; index < records.length; index++) {
            System.out.print("Enter name, company and package: ");
            records[index] = new PlacementRecord(
                    scanner.next(), scanner.next(), scanner.nextDouble());
        }

        for (PlacementRecord record : records) {
            record.printRecord();
        }
        scanner.close();
    }
}