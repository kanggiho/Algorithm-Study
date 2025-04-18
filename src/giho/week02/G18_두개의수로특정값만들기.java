package giho.week02;

import java.util.HashSet;

public class G18_두개의수로특정값만들기 {
    public boolean solution(int[] arr, int target){
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if(hashSet.contains(arr[i])){
                return true;
            }
            hashSet.add(arr[i]);
        }
        return false;
    }
}
