//package jino.week04;
//
//public class J지게차와크레인 {
//    class Solution {
//        private int[] dy = new int[]{0, 0, 1, -1}; // 동 서 남 북 열 행이동
//        private int[] dx = new int[]{1, -1, 0, 0}; // 동 서 남 북 행 열이동
//        private char[][] storages;
//        int answer = 0;
//
//        public int solution(String[] storage, String[] requests) {
//            storages = new char[storage.length][storage[0].length()];
//            for (int i = 0; i < storage.length; i++) {
//                for (int j = 0; j < storage[0].length(); j++) {
//                    storages[i][j] = storage[i].charAt(j);
//                }
//            } // 초기화
//
//            for (int r = 0; r < requests.length; r++) {
//                if (requests[r].length() == 0) {
//                    for (int i = 0; i < storage.length; i++) {
//                        for (int j = 0; j < storage[0].length(); j++) {
//                            for (int d = 0; d < 4; d++) {
//                                if (requests[r].equals(storages[i][j] + "")) {
//                                    int nowX = j + dx[d];
//                                    int nowY = i + dy[d];
//                                    if (nowY <= 0 || nowY >= storage.length && nowX <= 0 || nowX >= storage[0].length() && storages[nowY][nowX] == '-') {
//                                        // 방문 가능
//                                        storages[i][j] = '-';
//                                    }
//                                }
//                            }
//                        }
//                    }
//                } else { // 크래인
//                    char c = requests[r].charAt(0);
//                    for (int i = 0; i < storages.length; i++) {
//                        for (int j = 0; j < storages[0].length; j++) {
//                            if (c == storages[i][j]) {
//                                storages[i][j] = '-';
//                            }
//                        }
//                    }
//                }
//            } // for
//
//            for (int i = 0; i < storages.length; i++) {
//                for (int j = 0; j < storages[0].length; j++) {
//                    if (storages[i][j] != '-') {
//                        answer++;
//                    }
//                }
//            }
//
//            return answer;
//        }
//    }
//
//}
