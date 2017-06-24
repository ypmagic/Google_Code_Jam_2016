import java.io.File;
import java.io.FileNotFoundException;
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
        boolean changeOrientation = this.pancakeStatus.get(0);
        int counter = 0;
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
        String s = "++-++++---";
        ArrayList<Boolean> pancakeStatus = new ArrayList<Boolean>();
        for (int j = 0; j < s.length(); j++) {
            String temp = s.substring(j, j+1);
            System.out.println(temp);
            if (temp.equals("+")) {
                pancakeStatus.add(true);
            } else if (temp.equals("-")) {
                pancakeStatus.add(false);
            }
        }
        PancakeFlipper l = new PancakeFlipper(pancakeStatus);
        System.out.println(l.howManyFlips());
    }

    /*public static void main(String[] args) {
        File input = new File("B-small-practice.in");
        try {
            Scanner sc = new Scanner(input);
            int testCases = sc.nextInt();
            for (int i = 0; i < testCases; i++) {
                String s = sc.nextLine();
                ArrayList<Boolean> pancakeStatus = new ArrayList<Boolean>();
                for (int j = 0; j < s.length(); j++) {
                    String temp = s.substring(j, j+1);
                    if (temp.equals("+")) {
                        pancakeStatus.add(true);
                    } else if (temp.equals("-")) {
                        pancakeStatus.add(false);
                    }
                    PancakeFlipper l = new PancakeFlipper(pancakeStatus);
                }
            }
        } catch (FileNotFoundException a) {
            System.out.println("File not found.");
        }
    }*/
}
