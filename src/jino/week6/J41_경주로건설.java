package jino.week6;

import java.util.ArrayDeque;

public class J41_경주로건설 {


    class Solution {
        private static final int[] dx = new int[] {0, -1, 0, 1}; //서 북 동 남
        private static final int[] dy = new int[] {-1, 0, 1, 0}; //서 북 동 남
        private static int N;
        private static int[][][] visited; //가격 저장 할거임


        public int solution(int[][] board) {
            ArrayDeque<Node> dq = new ArrayDeque<>();
            dq.add(new Node(0, 0, -1, 0));
            N = board.length;

            visited = new int[N][N][4];
            int answer = Integer.MAX_VALUE;

            while(!dq.isEmpty()){
                Node now = dq.poll();

                for(int i = 0; i < 4; i++){
                    int newX = now.x + dx[i];
                    int newY = now.y + dy[i];

                    if(isBlocked(board, newX, newY)){
                        continue;
                    }
                    int newCost = calculateCost(i, now.direction, now.cost);
                    if(newX == N - 1 && newY == N - 1){
                        answer = Math.min(answer, newCost);
                    }
                    else if(isShouldUpdate(newX, newY, i, newCost)){
                        dq.add(new Node(newX, newY, i, newCost));
                        visited[newX][newY][i] = newCost;
                    }
                }
            }
            return answer;
        }

        private static class Node{
            int x;
            int y;
            int direction;
            int cost;

            public Node(int x, int y, int direction, int cost){
                this.x = x;
                this.y = y;
                this.direction = direction;
                this.cost = cost;
            }
        }

        private static boolean isValid(int x, int y){ //범위 내 있는지 확인
            return 0 <= x && x < N && 0 <= y && y < N;
        }

        private static boolean isBlocked(int[][] board, int x, int y){ //갈 수 있나 확인
            return (x == 0 && y == 0) || !isValid(x, y) || board[x][y] == 1;
        }

        private static int calculateCost(int direction, int prevDirection, int cost){
            if (prevDirection == -1 || (prevDirection - direction) % 2 == 0){
                return cost + 100;
            }
            return cost + 600;
        }

        //아직 방문 안하거나 더 작은 비용 발견
        private static boolean isShouldUpdate(int x, int y, int direction, int newCost){
            return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
        }
    }

}
