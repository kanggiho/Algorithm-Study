package utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class U07_Queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 큐에 요소 추가 (enqueue)
        queue.add(1);         // 문제 상황(공간 부족 등)에서 예외 발생
        queue.offer(2);       // 문제 상황에서 false 반환

        // 큐에서 요소 제거 (dequeue)
        queue.remove();       // 문제 상황에서 예외 발생
        queue.poll();         // 문제 상황에서 null 반환

        // 큐 비우기
        queue.clear();

        // 큐의 최전방 요소 확인
        queue.element();      // 문제 상황에서 예외 발생
        queue.peek();         // 문제 상황에서 null 반환

        // 덱(Double-Ended Queue) - 양방향 큐
        // 덱은 앞뒤에서 추가,제거가 가능함
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);   // 앞에 추가
        deque.addLast(2);    // 뒤에 추가

        deque.pollFirst();   // 앞에서 제거
        deque.pollLast();    // 뒤에서 제거

    }
}
