import java.util.Scanner;

public class BookInventory {
    private String title;
    private String author;
    private int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.printf("%s by %s - %d copies available%n",
                title, author, copiesAvailable);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookInventory[] inventory = new BookInventory[4];

        for (int index = 0; index < inventory.length; index++) {
            String[] bookData = scanner.nextLine().split(",", 3);
            inventory[index] = new BookInventory(
                    bookData[0].trim(), bookData[1].trim(), Integer.parseInt(bookData[2].trim()));
        }

        for (BookInventory book : inventory) {
            book.printEntry();
        }
        scanner.close();
    }
}