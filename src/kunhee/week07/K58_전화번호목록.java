package kunhee.week07;

import java.util.Arrays;

public class K58_전화번호목록 {

    public static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        int n = phone_book.length;

        if (n != 1) {
            for (int i = 1; i <= phone_book.length - 1; i++) {
                if (phone_book[i].startsWith(phone_book[i - 1])) {
                    return false;
                }
            }
        }

        return true;
    }

    // 테스트
    public static void main(String[] args) {
        String[] s1 = {"119", "97674223", "1195524421"};
        String[] s2 = {"123", "456", "789"};
        String[] s3 = {"12", "123", "1235", "567", "88"};
        String[] s4 = {"819232312", "976", "119552", "2"};
        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }
}