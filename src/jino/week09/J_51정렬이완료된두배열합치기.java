package jino.week09;

import java.util.Arrays;

public class J_51정렬이완료된두배열합치기 {

    // The main method must be in a class named "Main".
    class Main {

        public static void main(String[] args) {
            int[] result1 = solution(new int[]{1, 3, 5}, new int[]{2, 4, 6});
            int[] result2 = solution(new int[]{1, 2, 3}, new int[]{4, 5, 6});
            System.out.println(Arrays.toString(result1));
            System.out.println(Arrays.toString(result2));
        }
        private static int[] solution(int[] arr1, int[] arr2){
            int a1Length = arr1.length;
            int a2Length = arr2.length;
            int start1 = 0;
            int start2= 0;
            int totalLength = a1Length + a2Length;
            int[] answer = new int[totalLength];

            for(int i = 0 ; i < totalLength ; i++){
                if(start1 == a1Length  && start2 < a2Length ){
                    answer[i] = arr2[start2];
                    start2++;
                }
                else if(start2 == a2Length  && start1 < a1Length ){
                    answer[i] = arr1[start1];
                    start1++;
                }
                else if(arr1[start1] < arr2[start2] && start1 < a1Length  && start2 < a2Length ){
                    answer[i] = arr1[start1];
                    start1++;
                }
                else if(arr2[start2] < arr1[start1] && start1 < a1Length  && start2 < a2Length ){
                    answer[i] = arr2[start2];
                    start2++;
                }


            }
            return answer;
        }
    }
}
