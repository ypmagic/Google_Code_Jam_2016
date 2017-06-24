import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by young on 6/24/17.
 */
public class PancakeFlipper {

    private ArrayList<Boolean> pancakeStatus;

    public PancakeFlipper(ArrayList<Boolean> pancakeStatus) {
        this.pancakeStatus = pancakeStatus;
    }

    private int howManyFlips() {
        checkBottom();
        if (this.pancakeStatus.isEmpty()) {
            return 0;
        }
        boolean changeOrientation = this.pancakeStatus.get(0);
        int counter = 1;
        for (int i = 0; i < this.pancakeStatus.size(); i++) {
            if (this.pancakeStatus.get(i) != changeOrientation) {
                counter++;
                changeOrientation = !changeOrientation;
            }
        }
        return counter;
    }

    private void checkBottom() {
        for (int i = this.pancakeStatus.size()-1; i >= 0; i--) {
            if (!this.pancakeStatus.get(i)) {
                break;
            }
            this.pancakeStatus.remove(i);
        }
    }

    public static void main(String[] args) {
        File input = new File("B-large-practice.in");
        try {
            Scanner sc = new Scanner(input);
            PrintWriter pw = new PrintWriter("output-large.out");
            int testCases = sc.nextInt();
            for (int i = 0; i < testCases; i++) {
                ArrayList<Boolean> pancakeStatus = new ArrayList<>();
                String s = sc.next();
                for (int j = 0; j < s.length(); j++) {
                    String temp = s.substring(j, j+1);
                    if (temp.equals("+")) {
                        pancakeStatus.add(true);
                    } else if (temp.equals("-")) {
                        pancakeStatus.add(false);
                    }
                }
                PancakeFlipper l = new PancakeFlipper(pancakeStatus);
                pw.println("Case #" + (i+1) + ": " + l.howManyFlips());
            }
            pw.close();
        } catch (FileNotFoundException a) {
            System.out.println("File not found.");
        }
    }
}
