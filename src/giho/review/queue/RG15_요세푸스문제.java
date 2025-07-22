package giho.review.queue;

import java.util.*;

public class RG15_요세푸스문제 {
    public static void main(String[] args) {
        System.out.println(solution(5,2));
    }

    public static int solution(int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.addFirst(i + 1);
        }

        while(deque.size()>1){
            for (int i = 1; i < k; i++) {
                deque.addFirst(deque.pollLast());
            }
            deque.pollLast();

            List<Integer> temp = new ArrayList<>(deque);
            for (int i = 0; i < temp.size(); i++) {
                System.out.print(temp.get(i)+" ");
            }
            System.out.println();

        }

        return deque.pop();
    }
}
