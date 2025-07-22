package jino.week15;

public class J_배열회전하기 {

    class Main {
        public static void main(String[] args) throws Exception{
            int[][] result = solution(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 1);
            for(int i = 0 ; i < result.length ; i++){
                for(int j = 0 ; j < result[i].length ; j++){
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("========================");
            System.out.println();
            result = solution(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 1);
            for(int i = 0 ; i < result.length ; i++){
                for(int j = 0 ; j < result[i].length ; j++){
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }

        }
        private static int[][] solution(int[][] arr,int n){


            for(int spin = 0 ; spin < n ; spin++){//회전수
                int[][] temp = new int[arr[0].length][arr.length]; // 새로운 배열 생성
                for(int j = 0 ; j < arr.length ; j++){
                    for(int i = 0 ; i < arr[j].length ; i++){
                        temp[j][arr.length - i - 1] = arr[i][j];
                    }
                }
                arr = temp;
            }
            return arr;
        }
    }

}
