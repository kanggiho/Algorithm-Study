package heonwoo.week03;

import java.util.*;

public class H22_베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> num = new HashMap<>(); // 장르별 총 개수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르에 속하는 노래 및 재생횟수
        for(int i = 0; i < plays.length; i++) {
            if(!num.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]); // music.get(genres[i])는 HashMap(Integer, Integer)
                num.put(genres[i], num.get(genres[i]) + plays[i]); // 같은장르의 플레이 횟수에 새로 들어온 같은 장르의 플레이 횟수 더하기
            }
        }

        List<String> keySet = new ArrayList(num.keySet());
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - (num.get(s1))); // 플레이횟수가 큰순서대로 내림차순

        for(String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());

            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));

            answer.add(genre_key.get(0));
            if(genre_key.size() > 1)
                answer.add(genre_key.get(1));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
