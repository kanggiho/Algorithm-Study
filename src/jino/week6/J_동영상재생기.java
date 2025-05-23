package jino.week6;

public class J_동영상재생기 {
    class Solution {
        private static int videoLenSec;
        private static int posSec;
        private static int opStartSec;
        private static int opEndSec;
        private static String answer = "";
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            //초기화
            videoLenSec = changeSec(video_len);
            posSec =  changeSec(pos);
            opStartSec = changeSec(op_start);
            opEndSec = changeSec(op_end);

            for(int i  = 0 ; i < commands.length ; i++){
                //오프닝 검사 로직
                if(posSec >= opStartSec && posSec <= opEndSec){
                    posSec = opEndSec;
                }

                if(commands[i].equals("next")){
                    posSec = posSec + 10;

                    if(posSec >= videoLenSec ){
                        posSec = videoLenSec;
                    }
                }
                else{
                    posSec = posSec - 10;
                    if(posSec < 0 ){
                        posSec = 0;
                    }
                }


            }//커맨드를 받음

            if(posSec >= opStartSec && posSec <= opEndSec){
                posSec = opEndSec;
            }
            changeTime(posSec);


            return answer;
        }
        private static int changeSec(String str){
            String[] sArr = str.split(":");
            int sec  = 0;
            for(int i = 0 ; i < sArr.length ; i++){
                // System.out.println(sec);
                if(i == 0){
                    sec += (60 * Integer.parseInt(sArr[i]));
                }
                else {
                    sec +=  Integer.parseInt(sArr[i]);
                }
            }
            return sec;
        }

        private static void changeTime(int n){ //655
            String hour = n / 60+""; //8
            if(hour.length() < 2){
                String temp = hour;//8
                hour = "0";//0
                hour += temp;//08
            }
            n = n % 60;
            String sec = n+"";
            if(sec.length() < 2){//4
                String temp = sec;
                sec = "0";//0
                sec += temp;//04
            }
            answer += hour;
            answer += ":";
            answer += sec;
        }
    }
}
