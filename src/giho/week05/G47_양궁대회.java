package giho.week05;

import java.util.*;


public class G47_양궁대회 {

    public final int TARGET_NUM = 11;


    public static int[] result;
    public static int[] apeach;
    public static int max;

    public int[] solution(int n, int[] info) {
        result = new int[TARGET_NUM];
        apeach = info;
        max = Integer.MIN_VALUE;


        search(new int[TARGET_NUM],n,10);

        return max>0?result:new int[]{-1};

    }

    public void search(int[] lion, int remain, int tempScore){
        if(remain==0){
            int gap = scoreGap(apeach,lion);
            if(gap > max){
                max = gap;
                result = lion.clone();
            }else if(gap == max){
                result = findLow(lion.clone(),result).clone();
            }
            return;
        }

        int[] copyLion = lion.clone();
        int tempIndex = 10-tempScore;

        if(tempScore==0){
            copyLion[tempIndex] = remain;
            search(copyLion, 0, tempScore);
            return;
        }else{
            // 이길 때
            if(remain>apeach[tempIndex]){
                copyLion[tempIndex] = apeach[tempIndex]+1;
                search(copyLion, remain-apeach[tempIndex]-1, tempScore-1);
            }

            // 질 때
            copyLion[tempIndex] = 0;
            search(copyLion, remain, tempScore-1);

        }
    }




    // 라이언과 어피치의 점수차이 계산
    public int scoreGap(int[] apeach, int[] lion){
        int apeachScore = 0;
        int lionScore = 0;

        for(int i = 0 ; i<TARGET_NUM; i++){
            if(!(apeach[i]==0&&lion[i]==0)){
                if(apeach[i]>=lion[i]){
                    apeachScore+=10-i;
                }else{
                    lionScore+=10-i;
                }
            }
        }
        return lionScore-apeachScore;
    }

    //더 낮은 점수 많이 맞힌 경우찾기
    public int[] findLow(int[] arr1, int[] arr2){
        for(int i = TARGET_NUM-1 ; i >= 0 ; i--){
            if(arr1[i]<arr2[i]){
                return arr2.clone();
            }else if(arr1[i]>arr2[i]){
                return arr1.clone();
            }

        }

        return arr1.clone();

    }


}
