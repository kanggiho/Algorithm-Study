package heonwoo.week08;

public class H64_카펫 {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int h = 3; h <= total / 3; h++) {
            int w = total / h;

            if (total % h != 0) continue;

            int inner = (w - 2) * (h - 2);
            if (inner == yellow) {
                return new int[]{w, h};
            }
        }

        return new int[]{0, 0}; // 문제 조건상 이 경우는 발생하지 않음
    }
}
