package jino.week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class J22_베스트앨범 {
    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            HashMap<String,ArrayList<int[]> > genreMap = new HashMap<>();
            HashMap<String, Integer> playMap = new HashMap<>();

            for(int i = 0 ; i < genres.length ; i++){
                String genre = genres[i];
                int play = plays[i];

                if(!genreMap.containsKey(genre)){
                    genreMap.put(genre, new ArrayList<>());
                    playMap.put(genre,0);

                }
                genreMap.get(genre).add(new int[]{i,play});
                playMap.put(genre,playMap.getOrDefault(genre,0)+play);
            }
            List<Integer> answer = new ArrayList<>();

            Stream<Map.Entry<String ,Integer>> sortedGenre = playMap.entrySet()
                    .stream()
                    .sorted((o1,o2) -> Integer.compare(o2.getValue(), o1.getValue()));

            sortedGenre.forEach(entry ->{
                Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                        .sorted((o1,o2) -> Integer.compare(o2[1],o1[1]))
                        .limit(2);
                sortedSongs.forEach(song -> answer.add(song[0]));
            });
            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
