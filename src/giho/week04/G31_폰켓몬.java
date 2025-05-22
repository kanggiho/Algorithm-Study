package giho.week04;

import java.util.*;

public class G31_폰켓몬 {
    public int solution(int[] nums) {
        int n = nums.length/2;
        HashSet hs = new HashSet();
        for(int num : nums){
            hs.add(num);
        }
        return Math.min(n,hs.size());
    }
}
