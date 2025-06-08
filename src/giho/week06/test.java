package giho.week06;

import java.util.*;

public class test {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(1);

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }


    }

}
