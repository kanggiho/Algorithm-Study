package giho.review.stack;

import java.util.*;

public class RG14_표편집 {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        int lastNum = n-1;

        Stack<Integer> deleted = new Stack<>();

        HashMap<Integer,Character> info = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            info.put(i,'O');
        }

        for(int i = 0 ; i < cmd.length ; i++){
            String[] temp = cmd[i].split(" ");
            if(temp[0].equals("U")){
                int up = Integer.parseInt(temp[1]);
                while(up!=0){
                    k--;
                    if(info.get(k)=='O') up--;
                }
            }
            if(temp[0].equals("D")){
                int down = Integer.parseInt(temp[1]);
                while(down!=0){
                    k++;
                    if(info.get(k)=='O') down--;
                }
            }
            if(cmd[i].equals("C")){

                info.put(k,'X');
                deleted.push(k);

                if(k==lastNum){
                    while(true){
                        k--;
                        if(info.get(k)=='O'){
                            break;
                        }
                    }
                    lastNum=k;
                }else{
                    while(true){
                        k++;
                        if(info.get(k)=='O'){
                            break;
                        }
                    }
                }
            }
            if(cmd[i].equals("Z")){
                int idx = deleted.pop();
                info.put(idx,'O');
                if(idx>lastNum) lastNum=idx;
            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            sb.append(info.get(i));
        }

        return sb.toString();
    }
}
