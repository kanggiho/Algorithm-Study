package kunhee.week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class K22_베스트앨범 {

    public static int[] solution(String[] genres, int[] plays) {
        // 장르별 [index, play] 리스트
        Map<String, List<int[]>> genreMap = new HashMap<>();
        // 장르별 총 재생 수
        Map<String, Integer> genrePlays = new HashMap<>();

        // 장르별로 곡 정리 + 총 재생 수 계산
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreMap.putIfAbsent(genre, new ArrayList<>());
            genreMap.get(genre).add(new int[]{i, play});

            genrePlays.put(genre, genrePlays.getOrDefault(genre, 0) + play);
        }

        // 장르별 총 재생 수로 장르 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlays.keySet());
        sortedGenres.sort((g1, g2) -> genrePlays.get(g2) - genrePlays.get(g1));

        List<Integer> result = new ArrayList<>();

        // 각 장르 안에서 곡 정렬 후 최대 2개 추출
        for (String genre : sortedGenres) {
            List<int[]> songs = genreMap.get(genre); // genreMap의 value

            // 재생 수 내림차순,  재생 수 같으면 고유번호 오름차순
            songs.sort((a, b) -> {
                if (b[1] == a[1]) return a[0] - b[0]; // 고유번호 오름차순
                return b[1] - a[1]; // 재생수 내림차순
            });

            // 최대 2곡 수록
            for (int i = 0; i < songs.size() && i < 2; i++) {
                result.add(songs.get(i)[0]);
            }
        }

        // 리스트 -> 열 변환
        return result.stream().mapToInt(i -> i).toArray();
    }

}
