package giho.week05;

import java.util.*;

public class G43_N까지10되는조합 {


    public static ArrayList<ArrayList<Integer>> answerList;
    public static int n;


    public static void main(String[] args) {
        solution(5);
        for (int i = 0; i < answerList.size(); i++) {
            Collections.sort(answerList.get(i));
            for (int j = 0; j < answerList.get(i).size(); j++) {
                System.out.print(answerList.get(i).get(j)+",");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> solution(int N) {
        answerList = new ArrayList<>();
        n = N;
        backtrack(0, new ArrayList<>(), 1);
        return answerList;
    }


    public static void backtrack(int sum, ArrayList<Integer> list, int start) {
        if (sum == 10) {
            answerList.add(list);
            return;
        }

        for (int i = start; i <= n; i++) {
            if(sum+i<=10){
                ArrayList<Integer> newList = new ArrayList<>(list);
                newList.add(i);
                backtrack(sum+i,newList,i+1);
            }
        }
    }
}
