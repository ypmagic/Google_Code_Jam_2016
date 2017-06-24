import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by young on 6/24/17.
 */
public class PancakeFlipper {

    private boolean[] pancakeStatus;

    public PancakeFlipper(boolean[] pancakeStatus) {
        this.pancakeStatus = pancakeStatus;
    }

    public static void main(String[] args) {
        File input = new File("B-small-practice.in");
        try {
            Scanner sc = new Scanner(input);
            int testCases = sc.nextInt();
            for (int i = 0; i < testCases; i++) {
                String s = sc.nextLine();
                boolean[] pancakeStatus = new boolean[s.length()];
                for (int j = 0; j < s.length(); j++) {
                    String temp = s.substring(j, j+1);
                    if (temp.equals("+")) {
                        pancakeStatus[j] = true;
                    } else if (temp.equals("-")) {
                        pancakeStatus[j] = false;
                    }
                    PancakeFlipper l = new PancakeFlipper(pancakeStatus);
                }
            }
        } catch (FileNotFoundException a) {
            System.out.println("File not found.");
        }
    }
}
