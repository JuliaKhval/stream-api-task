package NextTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book {
    private String title;
    private List<String> authors;
    private String genre;
    private int publishYear;
    private double rating;
    private double price;

    public Book(String title, List<String> authors, String genre,
                int publishYear, double rating, double price) {
        this.title = title;
        this.authors = authors;
        this.genre = genre;
        this.publishYear = publishYear;
        this.rating = rating;
        this.price = price;
    }


    public String getGenre() { return genre; }
    public int getPublishYear() { return publishYear; }
    public double getRating() { return rating; }
    public String getTitle() { return title; }
    public List<String> getAuthors() { return authors; }
    public double getPrice() { return price; }


    public String getDecade() {
        int decadeStart = (publishYear / 10) * 10;
        return decadeStart + "-" + (decadeStart + 9);
    }
}
public class Task8 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Книга 1", List.of("Автор 1"), "Фантастика", 2012, 4.5, 500),
                new Book("Книга 2", List.of("Автор 2"), "Фантастика", 2015, 4.8, 600),
                new Book("Книга 3", List.of("Автор 3"), "Фантастика", 2018, 3.9, 450),
                new Book("Книга 4", List.of("Автор 4"), "Фантастика", 2011, 4.2, 550),
                new Book("Книга 5", List.of("Автор 5"), "Фантастика", 2019, 4.7, 700),
                new Book("Книга 6", List.of("Автор 6"), "Детектив", 2005, 4.1, 300),
                new Book("Книга 7", List.of("Автор 7"), "Детектив", 2008, 4.6, 400),
                new Book("Книга 8", List.of("Автор 8"), "Детектив", 2003, 3.8, 250),
                new Book("Книга 9", List.of("Автор 9"), "Роман", 1995, 4.3, 350),
                new Book("Книга 10", List.of("Автор 10"), "Роман", 1998, 4.9, 450)
        );

        Map<String, Map<String, List<Book>>> result = books.stream()
                .filter(book -> book.getRating() > 4.0)

                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.groupingBy(
                                Book::getDecade,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                                                .limit(3)
                                                .collect(Collectors.toList())
                                )
                        )
                ));

    }
}
