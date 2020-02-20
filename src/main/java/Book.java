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
}
