package jino.week02;

import java.util.HashMap;
import java.util.Map;

public class J18_두개의수로특정값만들기 {


    // The main method must be in a class named "Main".
    class Main {
        public static void main(String[] args) {
            System.out.println("Hello world!");
            System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6));
            System.out.println(solution(new int[]{2, 3, 5, 9} , 10));//f
            System.out.println(solution(new int[]{1, 3, 3,5 } , 6));//t
            System.out.println(solution(new int[]{-3, -1, -5, -2}, -4)); //t
            System.out.println(solution(new int[]{}, 0));//f
        }

        public static boolean solution(int[] arr, int target){
            boolean answer = true;
            Map <Integer ,Integer> hash = new HashMap<>();

            for (int i = 0 ; i < arr.length ; i++){
                hash.put(arr[i] ,arr[i]);
            }

            for (int i = 0 ; i < arr.length ; i++){
                if(hash.containsKey(target - arr[i]) && hash.get(target - arr[i]) != arr[i]){
                    return answer;
                }
            }

            answer = false;
            return answer;
        }
    }
}
