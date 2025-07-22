package giho.review.stack;

import java.util.*;

public class RG12_주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> idxs = new Stack<>();

        for(int i = 0 ; i < prices.length ; i++){

            while(!idxs.isEmpty()&&prices[i]<prices[idxs.peek()]){
                int top = idxs.pop();
                answer[top] = i-top;
            }

            idxs.push(i);
        }

        for(int i = 0 ; i < prices.length ; i++){
            if(answer[i]==0){
                answer[i]=prices.length-1-i;
            }
        }

        return answer;
    }
}
