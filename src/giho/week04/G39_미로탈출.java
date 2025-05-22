package giho.week04;

import java.util.*;

public class G39_미로탈출 {

    private static int [] dx = {1,0,0,-1};
    private static int [] dy = {0,1,-1,0};


    private static char[][] location;
    private static int[][] dist;

    private static int N;
    private static int M;

    private static class Point{
        int nx;
        int ny;
        public Point(int nx, int ny){
            this.nx = nx;
            this.ny = ny;
        }
    }

    private static Point start,lever,exit;

    public int solution(String[] maps) {

        int answer = 0;

        // location 배열에 위치정보 저장

        N = maps.length;
        M = maps[0].length();

        location = new char[N][M];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M; j++){

                if(maps[i].charAt(j)=='S'){
                    start = new Point(i,j);
                }else if(maps[i].charAt(j)=='L'){
                    lever = new Point(i,j);
                }else if(maps[i].charAt(j)=='E'){
                    exit = new Point(i,j);
                }
                location[i][j] = maps[i].charAt(j);
            }
        }

        // S 부터 L 까지
        int c1 = bfs(start,lever);

        // L 부터 E 까지
        int c2 = bfs(lever,exit);

        answer = c1+c2;

        return (c1==-1||c2==-1)?-1:answer;
    }

    // 시작점과 끝점까지의 최단거리 리턴
    private int bfs(Point a, Point b){

        ArrayDeque<Point> deque = new ArrayDeque<>();
        deque.addLast(a);
        dist = new int[N][M];
        dist[a.nx][a.ny]=0;


        while(!deque.isEmpty()){

            Point temp = deque.pollFirst();

            for(int i = 0 ; i < 4 ; i++){
                int newX = temp.nx+dx[i];
                int newY = temp.ny+dy[i];


                if(newX<0||newX>=N||newY<0||newY>=M){
                    continue;
                }

                if(dist[newX][newY]>0){
                    continue;
                }

                if(location[newX][newY]=='X'){
                    continue;
                }

                dist[newX][newY] = dist[temp.nx][temp.ny]+1;

                deque.addLast(new Point(newX,newY));

                if(b.nx==newX&&b.ny==newY){
                    return dist[newX][newY];
                }


            }
        }
        return -1;
    }
}
