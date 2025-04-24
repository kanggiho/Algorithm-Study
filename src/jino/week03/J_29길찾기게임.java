package jino.week03;

import java.util.*;

public class J_29길찾기게임 {


    class Solution {

        private static class Node{
            int value;//노드 값
            int x , y ;
            Node left;
            Node right;

            Node (int value , int x , int y){
                this.value = value;
                this.x = x;
                this.y = y;
            }


        }

        private static List<Node> Nodes = new ArrayList<>();//정렬을 위한 노드
        private static int index = 0; //정답 출력하기 위한 인덱스

        public int[][] solution(int[][] nodeinfo) {
            int size = nodeinfo.length;
            for(int i = 0 ; i < size ; i++){
                Nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
            }

            Collections.sort(Nodes,(o1, o2) ->{
                if(o1.y == o2.y){
                    return o1.x - o2.x;
                }
                return o2.y - o1.y;

            });

            Node root = Nodes.get(0);
            for(int i = 1 ; i < size ; i++){
                addNode(root , Nodes.get(i));
            }

            int [][] answer = new int [2][size];
            preOrder(answer, root);
            index = 0;
            postOrder(answer, root);
            return answer;
        }

        private static void addNode(Node parent,Node child){//자긱 배치
            if(parent.y > child.y && child.x < parent.x){
                if(parent.left == null){
                    parent.left = child;
                }
                else{
                    addNode(parent.left , child);
                }
            }
            else{
                if(parent.right == null){
                    parent.right = child;
                }
                else{
                    addNode(parent.right , child);
                }
            }
        }
        private static void preOrder(int[][]answer ,Node node){
            if(node == null) return;

            answer[0][index++] = node.value;
            preOrder(answer, node.left);
            preOrder(answer, node.right);
        }
        private static void postOrder(int[][]answer ,Node node){
            if(node == null) return;

            postOrder(answer, node.left);
            postOrder(answer, node.right);
            answer[1][index++] = node.value;
        }

    }

}
