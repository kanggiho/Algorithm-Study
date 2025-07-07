package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.*;

public class K22_2_베스트앨범 {

    public static int[] solution(String[] genres, int[] plays) {

        // gpt 도움

        Map<String, Integer> genreTotalMap = new HashMap<>();
        Map<String, List<int[]>> genreSongsMap = new HashMap<>();

        // 장르별 총 재생 수 계산
        for (int i = 0; i < genres.length; i++) {
            genreTotalMap.put(genres[i], genreTotalMap.getOrDefault(genres[i], 0) + plays[i]);

            // 장르별 곡 정보 저장 (index, play count)
            genreSongsMap.computeIfAbsent(genres[i], k -> new ArrayList<>())
                    .add(new int[]{i, plays[i]});
        }

        // 장르별 곡들을 재생 수 내림차순으로 정렬
        for (List<int[]> songList : genreSongsMap.values()) {
            songList.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1]; // 재생 수 내림차순
                return a[0] - b[0]; // 같으면 인덱스 오름차순
            });
        }

        // 장르를 총 재생 수 내림차순으로 정렬
        List<String> genreOrder = new ArrayList<>(genreTotalMap.keySet());
        genreOrder.sort((a, b) -> genreTotalMap.get(b) - genreTotalMap.get(a));

        // 장르별 상위 2곡씩 뽑아서 answer 작성
        List<Integer> result = new ArrayList<>();

        for (String genre : genreOrder) {
            List<int[]> songList = genreSongsMap.get(genre);
            for (int i = 0; i < songList.size() && i < 2; i++) {
                result.add(songList.get(i)[0]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays1 = {500, 600, 150, 800, 2500};
        int[] result1 = solution(genres1, plays1);
        System.out.println(Arrays.toString(result1));
        // 예상 출력: [4, 1, 3, 0]
    }
}
