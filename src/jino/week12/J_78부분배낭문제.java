package jino.week12;

import java.util.Arrays;

public class J_78부분배낭문제 {

    // The main method must be in a class named "Main".
    class Main {
        public static void main(String[] args) {
            int items[][] = new int[][] {{10, 19}, {7, 10}, {6, 10}};
            double answer = solution(15, items);
            System.out.println(answer);

            items = new int[][] {{10, 60}, {20, 100}, {30, 120}};
            answer = solution(50, items);
            System.out.println(answer);
        }
        private static double solution(int weightLimt, int[][] items){
            Bag[] myBag = new Bag[items.length];
            for(int i = 0 ; i < items.length ; i++){

                double oneWeight = (double)items[i][1] / items[i][0];
                myBag[i] = new Bag(items[i][0] , items[i][1], oneWeight);
            }
            Arrays.sort(myBag, (o1, o2) -> {
                return Double.compare(o2.oneWeight, o1.oneWeight);
            });


            double answer = 0;
            int now = 0;
            while(now != weightLimt){
                for(int i = 0 ; i < myBag.length ; i++){
                    if(myBag[i].weight > 0 ){
                        myBag[i].weight--;
                        answer += myBag[i].oneWeight;
                        now++;

                        break;
                    }
                }
            }
            return answer;
        }
        private static class Bag{
            int weight;
            int value;
            double oneWeight;

            public Bag(int weight, int value, double oneWeight){
                this.weight = weight;
                this.value = value;
                this.oneWeight = oneWeight;
            }
        }
    }
}
