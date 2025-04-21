package giho.week03;

import java.util.*;

public class G22_베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();


        Set<String> set = new HashSet<>();
        for (String item : genres) {
            set.add(item);
        }
        String[] gen = set.toArray(new String[0]);

        ArrayList<song> songs = new ArrayList<>();

        for (int i = 0; i < gen.length; i++) {
            songs.add(new song(0, gen[i]));
        }

        for (int i = 0; i < genres.length; i++) {
            for (int j = 0; j < gen.length; j++) {
                if (genres[i].equals(gen[j])) {
                    songs.get(j).total_play += plays[i];
                    if (songs.get(j).top_rate < plays[i]) {
                        songs.get(j).second_rate = songs.get(j).top_rate;
                        songs.get(j).second_index = songs.get(j).top_index;

                        songs.get(j).top_rate = plays[i];
                        songs.get(j).top_index = i;

                    } else if (songs.get(j).second_rate < plays[i]) {
                        songs.get(j).second_rate = plays[i];
                        songs.get(j).second_index = i;
                    }
                }
            }
        }

        songs.sort(Comparator.comparingInt((song s) -> s.total_play).reversed());

        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).top_index != -1) {
                result.add(songs.get(i).top_index);
            }
            if (songs.get(i).second_index != -1) {
                result.add(songs.get(i).second_index);
            }
        }
        answer = result.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public class song {
        final public String genre;
        public int total_play;
        public int top_index = -1;
        public int second_index = -1;
        public int top_rate = 0;
        public int second_rate = 0;

        public song(int total_play, String genre) {
            this.total_play = total_play;
            this.genre = genre;
        }
    }
}
