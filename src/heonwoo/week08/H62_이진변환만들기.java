package heonwoo.week08;

public class H62_이진변환만들기 {
    public int[] solution(String s) {
        int count = 0;      // 변환 횟수
        int zeroCount = 0;  // 제거한 0의 총 개수

        while (!s.equals("1")) {
            int beforeLength = s.length();
            s = s.replace("0", "");
            int afterLength = s.length();

            zeroCount += (beforeLength - afterLength); // 제거된 0 개수 누적
            s = Integer.toBinaryString(afterLength);   // 2진수 변환
            count++;
        }

        return new int[]{count, zeroCount};
    }
}
