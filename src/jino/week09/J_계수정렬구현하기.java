package jino.week09;

public class J_계수정렬구현하기 {


    // The main method must be in a class named "Main".
    class Main {
        private static String answer;

        public static void main(String[] args) {
            solution("hello");
            System.out.println(answer);
            solution("algorithm");
            System.out.println(answer);
        }

        private static void solution(String str){
            int[] arr = new int[26];
            //System.out.println((int)'a'); 97
            //System.out.println((int)'z'); 122
            answer ="";
            for(int i = 0 ; i < str.length() ; i++){
                char c = str.charAt(i);
                int num = (int)c - 97;
                arr[num]++;
            }
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] > 0){
                    for(int j = 0 ; j < arr[i] ; j++){
                        answer += (char)(i + 97) + "";
                    }
                }
            }

        }
    }
}
