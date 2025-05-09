package utils;

import java.util.HashSet;
import java.util.Iterator;

public class U08_Set {
    public static void main(String[] args) {

        // HashSet : 중복 허용 X, 순서 X
        // LinkedHashSet : 중복 허용 X, 순서 O (삽입순)
        // TreeSet : 중복 허용 X, 이진탐색트리 형태로 데이터 저장, 정렬 O

        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        // 요소 추가
        hashSet.add(1);

        // 요소 삭제
        hashSet.remove(1);  // 값이 1인 요소 삭제

        // 차집합
        hashSet.removeAll(hashSet2);  // hashSet의 데이터 중 hashSet2와 중복된 데이터 모두 삭제

        // 교집합
        hashSet.retainAll(hashSet2); // hashSet의 데이터 중 hashSet2와 중복된 데이터만 남기고 나머지 삭제

        // 데이터 초기화
        hashSet.clear();

        // HashSet 사이즈 확인
        hashSet.size();

        // 특정 요소 포함 여부 확인
        hashSet.contains(1);

        // 요소 전체 출력 - Iterator 사용
        Iterator<Integer> tempIterator = hashSet.iterator();
        while (tempIterator.hasNext()) {
            System.out.println(tempIterator.next());
        }

        // 요소 전체 출력 - for-each문 사용
        for (Integer item : hashSet) {
            System.out.println(item);
        }
    }
}
