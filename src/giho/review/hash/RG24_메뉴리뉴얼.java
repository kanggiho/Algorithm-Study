package giho.review.hash;

import java.util.*;

public class RG24_메뉴리뉴얼 {

    List<String> ansList;

    public String[] solution(String[] orders, int[] course) {
        List<String> real = new ArrayList<>();

        int[] maxValue = new int[course.length];


        ansList = new ArrayList<>();

        HashMap<String, Integer> merged = new HashMap<>();
        HashMap<Integer, Integer> maximum = new HashMap<>();


        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {

                char[] temp = orders[i].toCharArray();
                Arrays.sort(temp);


                combine(new String(temp), course[j], "", 0, 0);
            }
        }

        for (int i = 0; i < ansList.size(); i++) {
            merged.put(ansList.get(i), merged.getOrDefault(ansList.get(i), 0) + 1);
        }

        for (Map.Entry<String, Integer> temp : merged.entrySet()) {
            if (temp.getValue() > 1) {
                maximum.put(temp.getKey().length(), Math.max(maximum.getOrDefault(temp.getKey().length(), 0), temp.getValue()));

            }
        }

        for (Map.Entry<String, Integer> temp : merged.entrySet()) {
            if (maximum.get(temp.getKey().length()) == temp.getValue()) {
                real.add(temp.getKey());
            }
        }


        String[] an = real.stream().toArray(String[]::new);
        Arrays.sort(an);
        return an;
    }

    public void combine(String str, int goal, String make, int k, int gap) {

        if (k == goal) {
            ansList.add(make);
            return;
        }

        char[] temp = str.toCharArray();

        for (int i = gap; i < temp.length; i++) {
            combine(str, goal, make + temp[i], k + 1, i + 1);
        }
    }

}
