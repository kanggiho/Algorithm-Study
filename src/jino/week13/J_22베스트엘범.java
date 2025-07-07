package jino.week13;

import java.util.*;

public class J_22베스트엘범 {

    class Solution {
        private static Map<String, Integer> best;
        private static Map<String, ArrayList<int[]> > genresMap;//고유번호,재생수
        private static PriorityQueue<Genre> bestPq;//장르, 재생수
        private static int[] answer;

        public int[] solution(String[] genres, int[] plays) {
            bestPq = new PriorityQueue<>((o1, o2) -> {

                return o2.count - o1.count;


            });
            best = new HashMap<>();


            for(int i = 0 ; i < plays.length ; i++){
                if(!best.containsKey(genres[i])){
                    best.put(genres[i]	, plays[i]);
                }
                else{
                    best.put(genres[i], best.get(genres[i]) + plays[i]);
                }
            }
            for(Map.Entry<String, Integer> et: best.entrySet()){
                String genre = et.getKey();
                int count = et.getValue();
                bestPq.add(new Genre(genre , count));
            }
            genresMap = new HashMap<>();
            for(int i = 0 ; i < plays.length ; i++){
                if(!genresMap.containsKey(genres[i])){
                    genresMap.put(genres[i], new ArrayList<>());
                }
                genresMap.get(genres[i]).add(new int[]{i, plays[i]});

            }
            for(Map.Entry<String,ArrayList<int[]>> et  :  genresMap.entrySet()){
                et.getValue().sort((a, b) -> {
                    if(a[1] != b[1]) return b[1] - a[1];
                    return a[0] - b[0];
                });
            }
            List<Integer> result = new ArrayList<>();
            while(!bestPq.isEmpty()){
                Genre genre = bestPq.poll();
                String nowGenre = genre.genre;
                ArrayList<int[]> songs = genresMap.get(nowGenre);
                // 수정된 코드
                for(int i = 0 ; i < Math.min(2, songs.size()) ; i++){
                    result.add(songs.get(i)[0]);
                }
            }
            answer = result.stream().
                    mapToInt(i -> i)
                    .toArray();

            return answer;
        }
        private static class Genre{
            String genre;
            int count;
            public Genre(String genre, int count){
                this.genre = genre;
                this.count = count;
            }
        }
    }
}
