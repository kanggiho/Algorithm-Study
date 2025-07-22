package giho.review.queue;

import java.util.*;

public class RG17_카드뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> card1 = new ArrayDeque<>();
        Deque<String> card2 = new ArrayDeque<>();

        for(int i = 0 ; i < cards1.length ; i++){
            card1.addLast(cards1[i]);
        }

        for(int i = 0 ; i < cards2.length ; i++){
            card2.addLast(cards2[i]);
        }

        for(int i = 0 ; i < goal.length ; i++){
            if(card1.peekFirst()!=null && card1.peekFirst().equals(goal[i])){
                card1.pollFirst();
            }else if(card2.peekFirst()!=null && card2.peekFirst().equals(goal[i])){
                card2.pollFirst();
            }else{
                return "No";
            }
        }
        return "Yes";
    }

}
