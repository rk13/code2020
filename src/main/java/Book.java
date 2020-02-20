import java.util.Objects;

public class Book implements Comparable {
    int index;
    int score;
    boolean isScanned;

    public Book(int index, int score) {
        this.index = index;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if (this.score == ((Book) o).score) {
            return 0;
        }
        return this.score > ((Book) o).score ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return index == book.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
