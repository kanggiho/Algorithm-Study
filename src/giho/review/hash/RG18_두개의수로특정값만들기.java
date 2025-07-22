package giho.review.hash;

import java.util.*;

public class RG18_두개의수로특정값만들기 {


    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,8};
        int target1 = 6;

        int[] arr2 = {2,3,5,9};
        int target2 = 10;
        System.out.println(solution(arr1,target1));
    }

    public static boolean solution(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr){
            set.add(a);
        }

        for(int a : arr){
            if(set.contains(target-a)&&target!=2*a) return true;
        }
        return false;
    }
}
