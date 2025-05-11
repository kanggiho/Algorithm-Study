package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class U05_Collections {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 20};
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 10, 20));
        // Arrays.asList(arr) 사용 시 주의: int[]를 직접 넣으면 List<int[]>가 됨 (오동작)
        // 해결책: 위처럼 박싱하여 직접 요소를 넣거나, IntStream 사용

        // 정수형 List 원소 중 최대값, 최소값
        Collections.max(list);
        Collections.min(list);

        // List 정렬
        Collections.sort(list);                                // 오름차순 (ASC)
        Collections.sort(list, Collections.reverseOrder());    // 내림차순 (DESC)

        // List 뒤집기
        Collections.reverse(list);

        // List 내 원소의 개수 반환
        Collections.frequency(list, 3); // 3의 개수 반환

        // List 내 원소를 이진탐색으로 찾기 (정렬되어 있어야 함!)
        Collections.binarySearch(list, 10); // 예: 3 (인덱스)

        // ======================== binarySearch 추가 설명 ========================
        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(10);
        al.add(20);

        // 리스트는 정렬되어 있으므로 이진 탐색 가능

        // ① 10은 리스트의 3번째 인덱스에 존재
        int index = Collections.binarySearch(al, 10);
        System.out.println(index); // 출력: 3

        // ② 13은 리스트에 없음
        //    하지만 만약 있다면 인덱스 4에 들어갈 위치였음
        //    따라서 반환값은 -(4) - 1 = -5
        index = Collections.binarySearch(al, 13);
        System.out.println(index); // 출력: -5
    }
}
