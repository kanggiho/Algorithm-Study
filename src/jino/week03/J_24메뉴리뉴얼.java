package jino.week03;

import java.util.*;

public class J_24메뉴리뉴얼 {

    class Solution {
        List<String> answerList = new ArrayList<>();
        Map<String ,Integer> hash = new HashMap<>();
        public String[] solution(String[] orders, int[] course) {
            //정렬
            for(int i = 0 ; i < orders.length ; i++){
                char[] arr = orders[i].toCharArray();
                Arrays.sort(arr);
                orders[i] = "";
                for(char c:arr){
                    orders[i] += c +"";
                }
            }

            for(int courseL : course){
                for(String order : orders){
                    Combination("",order,courseL);
                }
                if(!hash.isEmpty()) {
                    List<Integer> list = new ArrayList<>(hash.values());
                    int max = Collections.max(list);

                    if(max > 1){
                        for(Map.Entry<String,Integer> entry : hash.entrySet()){
                            String key = entry.getKey();
                            if(entry.getValue() == max){
                                answerList.add(key);
                            }
                        }
                    }
                    hash.clear();

                }
            }


            String[] answer = answerList.stream()
                    .sorted()
                    .toArray(String[] :: new);
            return answer;
        }
        private void Combination(String order,String others , int count){
            if(count == 0 ){
                hash.put(order, hash.getOrDefault(order,0)+1);
                return;
            }
            for(int i = 0 ; i < others.length() ; i++){
                Combination(order + others.charAt(i), others.substring(i+1),count -1);
            }
        }
    }
}
