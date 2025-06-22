package jino.week12;

import java.util.ArrayList;
import java.util.List;

public class J_77거스름돈문제 {

    // The main method must be in a class named "Main".
    class Main {
        public static void main(String[] args) {
            int answer[] = solution(123);
            for(int i = 0 ; i < answer.length ; i++){
                System.out.print(answer[i] + " ");
            }
            answer = solution(350);
            System.out.println();
            for(int i = 0 ; i < answer.length ; i++){
                System.out.print(answer[i] + " ");
            }
        }
        private static int[] solution(int amount){
            List<Integer> coinList = new ArrayList<>();
            while(amount != 0){
                if(amount >= 100){
                    amount -= 100;
                    coinList.add(100);
                }
                else if(amount >= 50){
                    amount -= 50;
                    coinList.add(50);
                }
                else if(amount >= 10){
                    amount -=10;
                    coinList.add(10);
                }
                else if(amount >= 1){
                    amount --;
                    coinList.add(1);
                }
            }
            int[] answerArr = coinList.stream()
                    .mapToInt(i -> i)
                    .toArray();
            return answerArr;
        }
    }


}
