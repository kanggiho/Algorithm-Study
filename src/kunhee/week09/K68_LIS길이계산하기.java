package kunhee.week09;

/*
문제 설명:
정수 배열 nums에서 LIS의 길이를 찾는 solution() 함수를 작성하세요.

제약조건:
- nums는 최대 길이 1,000의 정수 배열입니다.
- nums의 각 요소는 -1,000 이상 1,000 이하의 정수입니다.
*/

public class K68_LIS길이계산하기 {

    public static int solution(int[] nums) {

        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        int answer = 1;

        // 초기화: 모든 위치에서 최소 길이는 1
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        // dp[0] = 1;
        // 처음 초기화 방식 : 테스트 케이스 4번에서 오류

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 2, 3, 1, 5, 7, 3};
        System.out.println(solution(nums1));

        int[] nums2 = {3, 2, 1};
        System.out.println(solution(nums2));

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution(nums3));

        int[] nums4 = {5, 1, 2};
        System.out.println(solution(nums4));
    }
}