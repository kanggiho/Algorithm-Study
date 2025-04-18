package jino.week02;

public class J17_카드뭉치 {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "No";
            int point1 = 0;
            int point2 = 0;

            for(String str: goal){
                if(point1 < cards1.length && str.equals(cards1[point1])){
                    point1++;
                }
                else if(point2 < cards2.length && str.equals(cards2[point2])){
                    point2++;
                }
                else{
                    return answer;
                }
            }
            answer = "Yes";
            return answer;
        }
    }
}
