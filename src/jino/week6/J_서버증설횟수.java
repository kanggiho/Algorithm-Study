package jino.week6;

import java.util.ArrayDeque;
import java.util.Deque;

public class J_서버증설횟수 {
    class Solution {
        private static Deque <Server> dq;
        private static int answer = 0;
        public int solution(int[] players, int m, int k) {//m명 , k시간
            //초기화
            dq =new ArrayDeque<>();
            for(int i = 0 ; i < players.length ; i++){
                if(players[i] >= m){//서버 증설 조건
                    if(dq.isEmpty()){//서버가 없다면
                        dq.add(new Server((int)players[i]/m, i+5));
                    }
                    else{
                        while(!dq.isEmpty()){
                            Server now = dq.peek();
                            if(i > now.endServer){
                                dq.pop();
                                answer += now.createSever;
                            }
                        }
                        int addPeople = (int)players[i]/m;//새로운 인원 만큼 증설해야한 서버
                        int sum = 0;
                        while(!dq.isEmpty()){
                            Deque <Server> myQue = new ArrayDeque<>();
                            Server now = myQue.pop();
                            sum += now.createSever;
                        }
                        if(addPeople > sum){
                            dq.add(new Server((addPeople - sum), i+5));
                        }
                    }
                    while(!dq.isEmpty()){
                        Server now = dq.pop();
                        answer += now.createSever;
                    }

                }
            }
            return answer;
        }

        private static class Server{
            int createSever;//몇대?
            int endServer;//종료시간


            public Server(int createSever,int endServer){
                this.createSever = createSever;
                this.endServer = endServer;

            }
        }
    }
}
