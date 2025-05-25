package utils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class U10_Sort {
    public static void main(){
        int[] arr = {3, 1, 4, 2};

        // 오름차순 정렬
        Arrays.sort(arr);

        // 내림차순 정렬은 int형으로는 정렬이 안되므로 integer로 변환후 정렬해야함 (배열 -> 리스트)
        // int를 스트림 방식으로 integer 변환후 내림차순 정렬
        Integer[] sorted = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);

        // 리스트 정렬 (오름차순 / 내림차순)
        List<Integer> list = Arrays.asList(5, 3, 1, 4, 2);

        // 오름차순
        list.sort(Comparator.naturalOrder());

        // 내림차순
        list.sort(Comparator.reverseOrder());

        // 배열 -> 리스트 반환
        int[] arr2 = {1, 2, 3};
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());

        // 리스트 -> 배열 변환
        List<Integer> list3 = Arrays.asList(1, 2, 3);
        int[] arr3 = list3.stream().mapToInt(i -> i).toArray();
    }
}
