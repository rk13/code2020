import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Library {
    public int signUp;
    public int booksPerDay;
    public List<Book> bookList = new ArrayList<>(); //Desc

    public void addBook(Book book) {
        bookList.add(book);
    }

    public List<Book> getBestBooks(int deadLine, Map<Integer, Book> bookStore) {
        int scanBeforeDeadline = (deadLine - signUp) * booksPerDay;
        List<Book> unscannedBooks = bookList.stream()
                .filter(i -> !bookStore.get(i.index).isScanned).collect(Collectors.toList());

        Collections.sort(unscannedBooks);

        List<Book> bestBooks = unscannedBooks.subList(0, Math.min(scanBeforeDeadline, unscannedBooks.size()));
//        bestBooks.forEach((book) -> bookStore.get(book.index).isScanned = true);
        return bestBooks;
    }
}
