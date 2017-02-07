
import java.util.Iterator;

/**
 * Created by ryan on 2/1/17.
 */

public class PermutationTester {
    public static void main(String[] args){
        unitTest("permutation4.txt");
    }

    public static void unitTest(String filename) {
        Deque<String> dq = new Deque<>();
        RandomizedQueue<Integer> rand = new RandomizedQueue<>();
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
        rand.enqueue(1);
        rand.enqueue(2);
        rand.enqueue(3);
        rand.enqueue(4);
        rand.enqueue(5);

        Iterator itr = rand.iterator();
        Iterator itr2 = rand.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }

        System.out.println();
        System.out.println(rand.sample());
        System.out.println(rand.sample());
        System.out.println(rand.sample());
        System.out.println(rand.sample());


    }

}
