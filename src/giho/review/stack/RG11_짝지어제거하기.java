package giho.review.stack;

import java.util.*;

public class RG11_짝지어제거하기 {
    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char temp;
            if(!stack.isEmpty()){
                temp = stack.pop();
                if(temp!=s.charAt(i)){
                    stack.push(temp);
                }else{
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }

        return stack.size()==0?1:0;
    }
}
