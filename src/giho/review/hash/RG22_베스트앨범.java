package giho.review.hash;

import java.util.*;

public class RG22_베스트앨범 {

    public class Song{
        String genre;
        int total;
        public Song(String genre, int total){
            this.genre = genre;
            this.total = total;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ansList = new ArrayList<>();

        HashMap<String, Integer> music = new HashMap<>();

        for(int i = 0 ; i < genres.length ; i++){
            music.put(genres[i],music.getOrDefault(genres[i],0)+plays[i]);
        }

        int iter = 0;
        Song[] songs = new Song[music.size()];

        for (Map.Entry<String, Integer> temp : music.entrySet()) {
            songs[iter] = new Song(temp.getKey(),temp.getValue());
            iter++;
        }

        Arrays.sort(songs, (s1, s2) -> s2.total - s1.total);

        for(int i = 0 ; i < songs.length ; i++){

            String genre = songs[i].genre;

            int first = -1;
            int second = -1;

            for(int j = 0 ; j < genres.length ; j++){

                if(genre.equals(genres[j])){
                    if(first == -1){
                        first = j;
                    }else if(second == -1){
                        if(plays[j]>plays[first]){
                            second = first;
                            first = j;
                        }else{
                            second = j;
                        }
                    }else{
                        if(plays[j]>plays[first]){
                            second = first;
                            first = j;
                        }else if(plays[j]>plays[second]){
                            second = j;
                        }
                    }
                }
            }
            ansList.add(first);
            if(second!=-1){
                ansList.add(second);
            }
        }

        return ansList.stream().mapToInt(i->i).toArray();
    }

}
