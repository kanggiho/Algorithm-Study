package giho.week05;

import java.util.*;
import java.util.stream.Collectors;

public class G48_외벽점검 {

    public static List<Integer> extend;
    public static List<Integer> distance;
    public static int N;
    public static int answer;


    public int solution(int n, int[] weak, int[] dist) {

        N = n;
        answer = Integer.MAX_VALUE;

        // 두배 확장시키기
        extend = new ArrayList<>();
        distance = new ArrayList<>();

        for (int i = 0; i < weak.length; i++) {
            extend.add(weak[i]);
            extend.add(weak[i] + n);
        }
        Collections.sort(extend);

        for (int i = 0; i < dist.length; i++) {
            distance.add(dist[i]);
        }


        search(new ArrayList<>(extend),new ArrayList<>(distance),0);

        return (answer == Integer.MAX_VALUE) ? -1 : answer;

    }

    public void search(List<Integer> tempList, List<Integer> distList, int count) {
        if (tempList.isEmpty()) {
            answer = Math.min(answer, count);
            return;
        }
        if (distList.isEmpty()) {
            return;
        }


        int ability = distList.get(distList.size()-1);


        for (int i = 0; i < tempList.size()/2; i++) {
            List<Integer> newList = new ArrayList<>(tempList);
            List<Integer> newDistList = new ArrayList<>(distList);

            deleteAll(newList, tempList.get(i), ability);
            newDistList.remove(newDistList.size()-1);

            search(newList, newDistList, count + 1);

        }
    }

    public void deleteAll(List<Integer> tempList, int start, int dist) {
        int end = start + dist;
        Iterator<Integer> iter = tempList.iterator();

        while (iter.hasNext()) {
            int temp = iter.next();
            if (start <= temp && temp <= end) {
                iter.remove();
            }
        }

    }


}