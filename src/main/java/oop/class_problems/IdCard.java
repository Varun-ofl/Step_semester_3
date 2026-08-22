import java.util.Scanner;

public class IdCard {
    private String name;
    private int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Ravi's name and books issued: ");
        IdCard ravi = new IdCard(scanner.next(), scanner.nextInt());
        IdCard duplicate = ravi;

        System.out.print("Enter separate card name and books issued: ");
        IdCard separate = new IdCard(scanner.next(), scanner.nextInt());

        duplicate.booksIssued = 3;
        System.out.printf("Ravi's booksIssued (via first variable): %d%n", ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi ? "true" : "false"));
        System.out.println("separate == ravi: " + (separate == ravi ? "true" : "false"));
        scanner.close();
    }
}