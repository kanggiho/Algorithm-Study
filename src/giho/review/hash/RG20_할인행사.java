package giho.review.hash;

import java.util.*;

public class RG20_할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        HashMap<String,Integer> isSales = new HashMap<>();

        for(int i = 0 ; i < 10 ; i++){
            isSales.put(discount[i],isSales.getOrDefault(discount[i],0)+1);
        }


        for(int i = 0 ; i <= discount.length-10 ; i++){
            if(i!=0){
                isSales.put(discount[i-1],isSales.get(discount[i-1])-1);
                isSales.put(discount[i+9],isSales.getOrDefault(discount[i+9],0)+1);
            }

            boolean flag = true;

            for(int j = 0 ; j < want.length ; j++){
                if(isSales.getOrDefault(want[j],-1)-number[j]<0) flag = false;
            }
            if(flag) answer++;
        }


        return answer;
    }

}
