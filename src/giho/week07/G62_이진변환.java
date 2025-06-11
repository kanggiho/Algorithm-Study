package giho.week07;

import java.util.*;

public class G62_이진변환 {
    static int count = 0;
    static int remove = 0;


    public int[] solution(String s) {

        while(true){
            if(s.equals("1")) break;
            s = calc(s);
        }
        return new int[]{count,remove};
    }

    public String calc(String s){

        count++;

        int tempLen = s.length();
        int newLen=0;

        for(int i =0 ; i<tempLen ; i++){
            if(s.charAt(i)=='1'){
                newLen++;
            }
        }

        remove += (tempLen-newLen);
        return binary(newLen);
        //return Integer.toBinaryString(newLen);
    }

    public String binary(int len){
        StringBuilder sb = new StringBuilder();
        while(len!=1){
            if(len%2==0){
                sb.append(0);
            }else{
                sb.append(1);
            }
            len/=2;
        }
        sb.append(1);
        sb.reverse();
        return sb.toString();
    }
}
