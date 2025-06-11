package jino.week07;

public class J_선입선출스캐줄링 {
    class Solution {
        private static int answer = 0;
        private static Core [] core;
        public int solution(int n, int[] cores) {
            core = new Core[cores.length];
            int time = 1;
            for(int i = 0 ; i < cores.length ;i++){
                core[i] = new Core(cores[i], i+1);
            }

            int nowWork = cores.length;//현재 일하는 번호

            while(true){
                time++;
                for(int i = 0 ; i < cores.length ;i++){
                    if(core[i].endTime == time){
                        core[i] =new Core(-1, -1);
                    }
                }//만료시간 탐색


                for(int i = 0 ; i < cores.length ;i++){
                    if(core[i].endTime == -1){
                        nowWork++;
                        core[i] =new Core(time + cores[i], nowWork);
                        if(nowWork == n){
                            return i+1;
                        }
                    }
                }//만료된 코어 작업 부여
            }

        }
        private static class Core{
            int endTime;
            int workNum;
            public Core(int endTime, int workNum){
                this.endTime = endTime;
                this.workNum = workNum;
            }

        }
    }
}
