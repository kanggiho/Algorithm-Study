package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class U04_ArrayListConversion {
    public static void main(String[] args) {

        // 문자열 타입 배열 -> List로 변환
        String[] arr1 = {"apple", "banana", "lemon"};
        List<String> list1 = new ArrayList<>(Arrays.asList(arr1));

        // List -> 문자열 배열로 변환
        List<String> list2 = new ArrayList<>();
        String[] arr2 = list2.toArray(new String[list2.size()]);

        // 정수 배열 -> List로 변환
        int[] intArr1 = {1, 2, 3, 4};
        List<Integer> intList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4)); // 직접 입력 방식

        // List -> 정수 배열로 변환
        List<Integer> intList2 = new ArrayList<>();
        int[] intArr2 = intList2.stream().mapToInt(x -> x).toArray();

        // ※주의사항
        List<String> list3 = Arrays.asList("a", "b", "c"); // 이렇게 하면 불변 리스트가 됨
        List<String> modifiableList3 = new ArrayList<>(Arrays.asList("a", "b", "c")); // 이렇게 하면 해결 됨
    }
}
