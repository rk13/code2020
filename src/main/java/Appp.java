import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Appp {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("b_read_on.txt"));

            String[] firstLine = scanner.nextLine().split(" ");
            Integer B = Integer.parseInt(firstLine[0]);
            Integer L = Integer.parseInt(firstLine[1]);
            Integer D = Integer.parseInt(firstLine[2]);

            Map<Integer, Book> bookStore = new HashMap<>();
            String[] scoreLineString = scanner.nextLine().split(" ");
            for (int i = 0; i < scoreLineString.length; i++) {
                bookStore.put(i, new Book(i, Integer.parseInt(scoreLineString[i])));
            }

            Map<Integer, Library> libraryInfoMap = new HashMap<>();
            for (int j = 0; j < L; j++) {
                libraryInfoMap.put(j, new Library());

                String[] libraryInfoString = scanner.nextLine().split(" ");
//                libraryInfoMap.get(j).put("NUMBOOKS", Integer.parseInt(libraryInfoString[0]));
                libraryInfoMap.get(j).signUp = Integer.parseInt(libraryInfoString[1]);
                libraryInfoMap.get(j).booksPerDay = Integer.parseInt(libraryInfoString[2]);

                String[] libraryBooks = scanner.nextLine().split(" ");
                for (String libraryBook : libraryBooks) {
                    libraryInfoMap.get(j).addBook(bookStore.get(Integer.parseInt(libraryBook)));
                }
            }

            Library currentBest = null;
            int currentBestScore = 0;
            for (Map.Entry<Integer, Library> library : libraryInfoMap.entrySet()) {
                int score = library.getValue().getBestBooks(D, bookStore).stream().map(i -> i.score).reduce(Integer::sum).get();
                if (currentBestScore < score) {
                    currentBestScore = score;
                    currentBest = library.getValue();
                }
            }

            // :)
            System.out.print(1);
            System.out.print(' ');
            System.out.println(currentBest.bookList.size());
            for (Book i : currentBest.getBestBooks(D, bookStore)) {
                System.out.print(i.index);
                System.out.print(' ');
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
