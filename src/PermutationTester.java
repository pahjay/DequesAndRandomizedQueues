
import java.util.Iterator;

/**
 * Created by ryan on 2/1/17.
 */

public class PermutationTester {
    public static void main(String[] args){
        unitTest("permutation4.txt");
    }

    public static void unitTest(String filename) {
        Deque<String> rand = new Deque<>();
        int elements = 0;

//        try {
//            for (String line : Files.readAllLines(Paths.get(filename))){
//                for (String part : line.split("\\s+")){
//                    elements++;
//                    rand.addFirst(part);
//                }
//            }
//
//
//        } catch (Exception e) {
//
//        }

        rand.addFirst("0");
        rand.removeLast();

        Iterator itr = rand.iterator();
        System.out.println(rand.isEmpty());

    }

}
