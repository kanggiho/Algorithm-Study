package giho.review.stack;

public class RG08_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        int left = 0;
        int right = 0;

        char[] c = s.toCharArray();

        for(int i = 0 ; i < c.length ; i++){
            if(c[i]=='('){
                left++;
            }else{
                right++;
            }
            if(left<right) return false;
        }
        if(left!=right) return false;
        return answer;
    }
}
