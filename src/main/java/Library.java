import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Library {
    public int signUp;
    public int booksPerDay;
    public Set<Book> bookList = new TreeSet<>(); //Desc

    public void addBook(Book book) {
        bookList.add(book);
    }

    public int calculateScore(int deadLine, Map<Integer, Book> bookStore) {
        int scanBeforeDeadline = (deadLine - signUp) * booksPerDay;
        List<Book> unscannedBooks = bookList.stream()
                .filter(i -> !bookStore.get(i.index).isScanned).collect(Collectors.toList());

        int score = 0;
        for (int i = 0; i < scanBeforeDeadline; i++) {
            score = score + unscannedBooks.get(i).score;
        }
        return score;
    }

    public List<Book> getBooks(int remainingDays, Map<Integer, Book> bookStore) {
        return Collections.emptyList();
    }
}
