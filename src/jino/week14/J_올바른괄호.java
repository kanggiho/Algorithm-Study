package jino.week14;

import java.util.ArrayDeque;
import java.util.Deque;

public class J_올바른괄호 {

    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Deque<Character> dq = new ArrayDeque<>();
            for(int i = 0 ; i < s.length() ; i++){
                if(s.charAt(i) == '('){
                    dq.add('(');
                }
                else{
                    if(!dq.isEmpty() && dq.peek() == '('){
                        dq.pop();
                    }
                    else{
                        answer = false;
                        return answer;
                    }
                }
            }
            if(!dq.isEmpty()){
                answer = false;
            }

            return answer;
        }
    }
}
