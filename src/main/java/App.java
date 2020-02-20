import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class App {

    static String[][] input;

    // test push
    public static void main(String[] args) throws Exception {
        File file = new File("/tmp/input.txt");
        Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
        int t = Integer.parseInt(in.nextLine());

        input = new String[t][];
        for (int i = 1; i <= t; i++) {
            input[i - 1] = in.nextLine().split(" ");
        }

    }
}
