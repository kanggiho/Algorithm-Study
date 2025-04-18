package heonwoo.week02;

import java.util.LinkedList;
import java.util.Queue;

public class H17_카드뭉치 {
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(cards1, cards2, goal));

    }

    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Queue<String> queue3 = new LinkedList<>();
        for (int i = 0; i < goal.length; i++) {
            queue.add(goal[i]);
        }
        for (int i = 0; i < cards1.length; i++) {
            queue2.add(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            queue3.add(cards2[i]);
        }
        for (int i = 0; i < goal.length; i++) {
            String data = queue.poll();
            if (data == queue2.peek()) {
                queue2.poll();
            } else if (data == queue3.peek()) {
                queue3.poll();
            }
        }
        if (queue2.isEmpty() && queue3.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
