package heonwoo.week05;

import java.util.ArrayList;

public class H_서버증설횟수 {
    // m<= 서버 1대 필요 < 2*m-1
    // k 서버 운영시간
//    public int solution(int[] players, int m, int k) {
//        int answer = 0;
//        int[] storage = new int[players.length];
//        int cnt = 0;
//        for (int i = 0; i < players.length; i++) {
//            int num = players[i];
//            int storageNum = num/m;
//            if (m <= num  && players[i] < storageNum*m){
//                for (int j = i; j < i + k; j++) {
//                    storage[j]+=storageNum;
//                }
//                if (storage[i] != 0) {
//                    answer += storage[i] - storageNum;
//                }else {
//                    answer += storageNum;
//                }
//            }
//
//        }
//        return answer;
//    }
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < 24 ; i++){
            // 남은시간 갱신
            for(int j = 0 ; j<list.size() ; j++){
                list.set(j,list.get(j)-1);
                if(list.get(j)<=0){
                    list.set(j,-1);
                }
            }
            // 필요한 서버 개수 구하기
            int needServer = players[i]/m;

            // 현재 서버의 개수 구하기
            int count = 0;
            for(int j = 0 ; j<list.size() ; j++){
                if(list.get(j)!=-1){
                    count++;
                }
            }
            for(int j = 0 ; j<needServer-count; j++){
                list.add(k);
                answer++;
            }
        }
        return answer;
    }
}
