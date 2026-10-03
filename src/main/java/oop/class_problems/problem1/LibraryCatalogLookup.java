package oop.class_problems.problem1;

import java.util.List;

public class LibraryCatalogLookup {
    public static String findBook(List<BookRecord> catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.size() - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            BookRecord book = catalog.get(middle);
            int comparison = book.isbn().compareTo(targetIsbn);

            if (comparison == 0) {
                return book.title();
            }
            if (comparison < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return "Not Found";
    }

    public record BookRecord(String isbn, String title) {
    }

    public static void main(String[] args) {
        List<BookRecord> catalog = List.of(
                new BookRecord("0001112223", "Introduction to Algebra"),
                new BookRecord("0002223334", "Beginning Python"),
                new BookRecord("0003334445", "Classic Mythology"),
                new BookRecord("0004445556", "Data and Society"),
                new BookRecord("0005556667", "European History"));

        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}
