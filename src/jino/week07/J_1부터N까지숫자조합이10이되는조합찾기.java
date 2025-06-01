package jino.week07;

import java.util.ArrayList;

public class J_1부터N까지숫자조합이10이되는조합찾기 {


    // The main method must be in a class named "Main".
    class Main {
        private static ArrayList<ArrayList<Integer>> answer;
        private static int n;
        public static void main(String[] args) {
            System.out.println(solution(5));
            System.out.println(solution(2));
            System.out.println(solution(7));
        }

        private static ArrayList< ArrayList<Integer> > solution(int N){
            //초기화
            n = N;
            answer = new ArrayList<>();
            findTen(1, new ArrayList<>(), 0);


            return answer;
        }

        private static void findTen(int start , ArrayList<Integer> myList, int sum){
            if(sum == 10){
                answer.add(myList);
                return;
            }
            else if(sum > 10){
                return;
            }
            for(int i = start ; i <= n ; i++){
                if(sum + i <= 10){
                    ArrayList<Integer> list = new ArrayList<>(myList);
                    list.add(i);
                    findTen(i+1, list, sum + i);
                }

            }
        }
    }
}
