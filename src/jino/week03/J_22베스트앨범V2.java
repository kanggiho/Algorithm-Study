package jino.week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class J_22베스트앨범V2 {


    class Solution {
        private Map<String ,Integer> play; //장르별 노래 총합 해쉬
        private Map<String , List<int[]>> bestGenre; //배스트 장르

        public int[] solution(String[] genres, int[] plays) {
            play = new HashMap<>();
            //1.전체 해시맵
            for(int i = 0 ; i < genres.length ; i++){
                play.put(genres[i],play.getOrDefault(genres[i],0)+plays[i]);
            }
            // for(Map.Entry<String ,Integer> et : play.entrySet()){
            //     System.out.println(et.getValue());
            // }

            bestGenre = new HashMap<>();
            //장르별 배열
            for(int i = 0 ; i < genres.length ; i++){
                if(!bestGenre.containsKey(genres[i])){
                    bestGenre.put(genres[i],new ArrayList<>());
                }
                bestGenre.get(genres[i]).add(new int[]{i ,plays[i]});
            }

            List <Integer> answer = new ArrayList<>();

            Stream<Map.Entry<String,Integer>> sortPlay = play.entrySet()
                    .stream()
                    .sorted((o1 , o2) -> Integer.compare(o2.getValue(),o1.getValue()));

            sortPlay.forEach(entry ->{
                Stream<int[]> sortedSongs = bestGenre.get(entry.getKey()).stream()
                        .sorted((o1,o2) -> Integer.compare((o2[1]) ,(o1[1])))
                        .limit(2);
                sortedSongs.forEach(song -> answer.add(song[0]));

            });




            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
