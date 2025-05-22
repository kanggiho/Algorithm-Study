package jino.week07;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class J_호텔대실 {
    import java.util.*;
    class Solution {
        private static ArrayList<ArrayList<Integer>> room;
        private static int roomCount = 0;
        private static PriorityQueue<int[]> pq;
        private static int[][] book_timeInt;
        public int solution(String[][] book_time) {
            //초기화
            room = new ArrayList<>();
            pq = new PriorityQueue<>((o1,o2)->{
                return (o1[0] - o2[0]);
            });

            book_timeInt = new int[book_time.length][book_time[0].length];
            for(int i = 0 ; i < book_time.length ; i++){
                change(book_time[i], i);
            }


            for(int[] arr: book_timeInt){
                pq.add(arr);
            }
            room.add(new ArrayList<>());
            int[] firstBooking = pq.poll();
            room.get(0).add(firstBooking[0]);
            room.get(0).add(firstBooking[1]);
            roomCount++;

            while(!pq.isEmpty()){
                int[] now = pq.poll();
                for(int i = 0 ;i < roomCount ; i++){
                    int end = room.get(i).get(1);
                    if(end + 10  > now[0]){
                        roomCount++;
                        room.get(i).set(1, now[1]);



                    }

                    room.get().add(now);
                }


                return roomCount;
            }
            private static void change(String[] str, int i ){
                String[] start = str[0].split(":");
                String[] end = str[1].split(":");
                int intStart = (Integer.parseInt(start[0])*60) + Integer.parseInt(start[1]);
                int intend = (Integer.parseInt(end[0])*60) + Integer.parseInt(end[1]);
                book_timeInt[i][0]= intStart;
                book_timeInt[i][1]= intend;

            }


        }
}
