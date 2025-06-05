package jino.week09;

import java.util.Arrays;

public class J_K번째수 {


    class Solution {
        private static int[] answer;
        public int[] solution(int[] array, int[][] commands) {
            answer = new int[commands.length];
            for(int i = 0 ; i < commands.length ; i++){
                int start = commands[i][0] -1;
                int end = commands[i][1] -1;
                int number =commands[i][2] -1;
                int[] arr = new int[end - start + 1];
                int index = 0;
                while(true){
                    if(index == arr.length || start > end ){
                        break;
                    }
                    arr[index] = array[start];
                    index++;
                    start++;
                }
                for(int k = 0 ; k < arr.length ; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
                Arrays.sort(arr);
                answer[i] = arr[number];
            }
            return answer;
        }
    }
}
