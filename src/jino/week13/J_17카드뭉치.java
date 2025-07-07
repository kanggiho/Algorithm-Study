package jino.week13;

public class J_17카드뭉치 {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "";
            boolean flag = true;
            int point1 = 0;
            int point2 = 0;
            for(int i = 0 ; i < goal.length ; i++){
                if(point1 < cards1.length && cards1[point1].equals(goal[i])  ){
                    point1++;
                }else if(point2 < cards2.length && cards2[point2].equals(goal[i])){
                    point2++;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer = "Yes";
            }
            else{
                answer = "No";
            }
            return answer;
        }
    }
}
