package giho.week02;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class G17_카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Deque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        Deque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        Deque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        while(!goalDeque.isEmpty()) {
            if(!cardsDeque1.isEmpty()&&cardsDeque1.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque1.removeFirst();
                goalDeque.removeFirst();
            } else if (!cardsDeque2.isEmpty()&&cardsDeque2.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque2.removeFirst();
                goalDeque.removeFirst();
            }else{
                break;
            }
        }
        return goalDeque.isEmpty()?"Yes":"No";
    }
}
