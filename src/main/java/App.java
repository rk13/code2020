import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("b_read_on.txt"));

            String[] firstLine = scanner.nextLine().split(" ");
            Integer B = Integer.parseInt(firstLine[0]);
            Integer L = Integer.parseInt(firstLine[1]);
            Integer D = Integer.parseInt(firstLine[2]);

            Map<Integer, Integer> bookscores = new HashMap<>();
            String[] scoreLineString = scanner.nextLine().split(" ");
            for (int i = 0; i < scoreLineString.length; i++) {
                bookscores.put(i, Integer.parseInt(scoreLineString[i]));
            }

            Map<Integer, Map<String, Integer>> libraryInfoMap = new HashMap<>();
            Map<Integer, List<Integer>> libraryBooksMap = new HashMap<>();
            for (int j = 0; j < L; j++) {
                libraryInfoMap.put(j, new HashMap<>());
                libraryBooksMap.put(j, new ArrayList<>());

                String[] libraryInfoString = scanner.nextLine().split(" ");
                libraryInfoMap.get(j).put("NUMBOOKS", Integer.parseInt(libraryInfoString[0]));
                libraryInfoMap.get(j).put("SIGNUP", Integer.parseInt(libraryInfoString[1]));
                libraryInfoMap.get(j).put("SHIPPING", Integer.parseInt(libraryInfoString[2]));

                String[] libraryBooks = scanner.nextLine().split(" ");
                for (String libraryBook : libraryBooks) {
                    libraryBooksMap.get(j).add(Integer.parseInt(libraryBook));
                }
            }

            System.out.println(B);
            System.out.println(L);
            System.out.println(D);
            System.out.println(bookscores);
            System.out.println(libraryInfoMap);
            System.out.println(libraryBooksMap);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
