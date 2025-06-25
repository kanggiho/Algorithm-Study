package giho.week08;

import java.util.Arrays;

public class G78_부분배낭문제 {


    public static void main(String[] args) {
        int[][] item1 = {{10,19},{7,10},{6,10}};
        int[][] item2 = {{10,60},{20,100},{30,120}};

        System.out.println(solution(item1,15));
        System.out.println(solution(item2,50));

    }

    public static class Item{
        int value, weight;
        double rich;
        public Item(int value, int weight, double rich){
            this.value = value;
            this.weight = weight;
            this.rich = rich;
        }
    }


    public static double solution(int[][] items, int weight_limit){

        double answer = 0;

        Item[] item = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            item[i] = new Item(items[i][1],items[i][0],(double)items[i][1]/(double)items[i][0]);
        }

        Arrays.sort(item, ((o1, o2) -> Double.compare(o2.rich,o1.rich)));

        int iter = 0;

        while(true){
            int _value = item[iter].value;
            int _weight = item[iter].weight;

            if(weight_limit>=_weight){
                weight_limit-=(double)_weight;
                answer += (double)_value;
            }else{
                answer += (double)_value*((double)weight_limit/(double)_weight);
                break;
            }
            iter++;
        }

        return answer;

    }
}
