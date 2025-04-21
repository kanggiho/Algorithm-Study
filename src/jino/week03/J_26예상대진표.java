package jino.week03;

public class J_26예상대진표 {
    class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 0;

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");
            for(answer= 0 ; a != b ; answer++){

                a = ((a+1)/2);
                b = ((b+1)/2);

            }

            return answer;
        }
    }
}
