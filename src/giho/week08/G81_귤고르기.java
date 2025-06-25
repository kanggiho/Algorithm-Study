package giho.week08;

import java.util.*;

public class G81_귤고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < tangerine.length ; i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }

        int[][] kind = new int[map.size()][2];

        int iter = 0;

        for(Map.Entry<Integer,Integer> temp : map.entrySet()){
            kind[iter][0]=temp.getKey();
            kind[iter][1]=temp.getValue();
            iter++;
        }

        Arrays.sort(kind, (o1,o2)->o2[1]-o1[1]);

        iter=0;
        while(k>0){
            answer++;
            k-=kind[iter][1];
            iter++;
        }

        return answer;
    }

}
