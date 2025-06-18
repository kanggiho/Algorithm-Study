package giho.week07;

import java.lang.reflect.Array;
import java.util.*;

public class G68_LIS길이계산 {

    public static void main(String[] args) {
        int[] arr = {1,4,2,3,1,5,7,3};
        solution(arr);
    }

    public static int solution(int[] nums){

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+" ");
        }

        return Arrays.stream(dp).max().getAsInt();
    }

}
