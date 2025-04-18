package giho.week01;

import java.util.Arrays;
import java.util.Comparator;

public class G02_배열제어하기 {
    public int[] solution(int[] arr){
        return Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
