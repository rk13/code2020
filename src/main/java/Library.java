import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Library {
    public int signup;
    public int booksperday;
    public ArrayList<Integer> bookList;

    public int calculateScore(int deadLine, Map<Integer, Integer> bookScore, List<Integer> scannedBooks) {
        int scanBeforDeadline = (deadLine-signup)*booksperday;
        List<Integer> scorelist = bookList.stream()
                .filter(i -> !scannedBooks.contains(i))
                .map(i -> bookScore.get(i))
                .collect(Collectors.toList());

        Collections.sort(scorelist);

    }
}
