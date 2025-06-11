package jino.week6;

public class J_동영상재생기1 {
    class Solution {
        private static String answer = "";

        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            int intVoidLen = mToS(video_len);
            int intPos = mToS(pos);
            int intOpStart = mToS(op_start);
            int intOPEnd = mToS(op_end);
            for(int i = 0 ; i < commands.length ; i++){

                // System.out.println(intPos);
                //오프닝 범위 확인
                if(intPos >= intOpStart && intPos <= intOPEnd){
                    //스킵
                    intPos = intOPEnd;
                }
                if(commands[i].equals("next")){
                    intPos += 10;
                    if(intPos > intVoidLen){
                        intPos = intVoidLen;
                    }
                }
                else{
                    intPos -= 10;
                    if(intPos < 0){
                        intPos = 0;
                    }
                }
                if(intPos >= intOpStart && intPos <= intOPEnd){
                    //스킵
                    intPos = intOPEnd;
                }

            }
            sToM(intPos);
            return answer;
        }
        private static int mToS(String s){//분 > 초
            String[] str = s.split(":");
            return Integer.parseInt(str[0] )* 60 + Integer.parseInt(str[1]);
        }
        private static void sToM(int n){//초 - > 분
            String m = n/60+"";
            String s = n %60+"";
            if(m.length()<2){
                String temp = m;
                m = "";
                m +=0;
                m += temp;
            }
            answer = m+":";
            if(s.length()<2){
                String temp = s;
                s = "";
                s +=0;
                s += temp;
            }
            answer += s;

        }
    }
}
