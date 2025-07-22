package giho.review.stack;

import java.util.*;

public class RG13_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int height = board.length;
        int width = board[0].length;
        int error = 0;

        int[] layer = new int[width];

        Stack<Integer> getItem = new Stack<>();

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(layer[j]==0&&board[i][j]!=0){
                    layer[j]=height-i;
                }
            }
        }

        for(int i = 0 ; i < moves.length ; i++){
            int temp = moves[i]-1;
            if(layer[temp]!=0){

                int c = board[height-layer[temp]][temp];

                if(!getItem.isEmpty()&&getItem.peek()==c){
                    getItem.pop();
                }else{
                    getItem.push(c);
                }
                layer[temp]--;

            }else{
                error++;
                continue;
            }
        }


        return moves.length-error-getItem.size();
    }
}
