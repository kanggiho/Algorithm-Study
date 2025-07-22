package jino.week14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class J_길찾기게임 {

    class Solution {
        private static int[][] answer;
        private static List<Node> node;
        private static int dept = 0;
        public int[][] solution(int[][] nodeinfo) {
            answer = new int[2][nodeinfo.length];
            node = new ArrayList<>();
            for(int i = 0 ; i < nodeinfo.length ; i++){
                node.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i +1));
            }

            Collections.sort(node, (o1, o2)->{
                if(o1.y == o2.y){
                    return o1.x - o2.x;
                }
                return o2.y - o1.y;
            });
            Node root = node.get(0);
            for(int i = 1; i < node.size() ; i++){
                makeTree(root, node.get(i));
            }
            preOrder(root);
            dept = 0;
            postOrder(root);
            return answer;
        }
        private static void makeTree(Node parnet, Node child){
            if(parnet.x > child.x){//왼자
                if(parnet.left == null){
                    parnet.left = child;
                }
                else{
                    makeTree(parnet.left, child);
                }
            }
            else{//오른자
                if(parnet.right == null){
                    parnet.right = child;
                }
                else{
                    makeTree(parnet.right, child);
                }
            }

        }
        private static void preOrder(Node now){//전위
            if(now == null ) return;
            answer[0][dept] = now.v;
            dept +=1;
            preOrder(now.left);
            preOrder(now.right);
        }
        private static void postOrder(Node now){
            if(now == null ) return;
            postOrder(now.left);
            postOrder(now.right);
            answer[1][dept++] = now.v;
        }


        private static class Node{
            int x;
            int y;
            int v;
            Node left;
            Node right;
            public Node(int x, int y, int v){
                this.x = x;
                this.y = y;
                this. v = v;
            }
        }
    }
}
