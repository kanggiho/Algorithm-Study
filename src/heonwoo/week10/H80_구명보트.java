package heonwoo.week10;

import java.util.Arrays;

public class H80_구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0; // 멸치
        int j = people.length - 1; // 돼지
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i += 1;
            }
            j -= 1;
            count += 1;
        }
        return count;
    }
}
