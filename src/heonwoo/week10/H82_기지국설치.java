package heonwoo.week10;

public class H82_기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1;
        int idx = 0;

        while (location <= n) {
            if (idx < stations.length && location >= stations[idx] - w) {
                location = stations[idx] + w + 1;
                idx++;
            }
            else {
                location += 2 * w + 1;
                answer++;
            }
        }
        return answer;
    }
}
