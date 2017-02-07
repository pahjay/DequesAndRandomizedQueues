import edu.princeton.cs.algs4.*;

/**
 * Created by ryan on 2/1/17.
 */

public class Permutation {
    public static void main(String[] args){

        int cycles = Integer.parseInt(args[0]);
        RandomizedQueue rand = new RandomizedQueue<>();

        for (int i = 0; i < cycles; i++){
            rand.enqueue(StdIn.readString());
        }

        while(rand.iterator().hasNext()) {
            System.out.println(rand.iterator().next());
        }
    }
}

