package heonwoo.week04;


public class H_지폐접기 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int max_bill = Math.max(bill[0], bill[1]);
        int min_bill = Math.min(bill[0], bill[1]);
        int max_wallet = Math.max(wallet[0], wallet[1]);
        int min_wallet = Math.min(wallet[0], wallet[1]);

        while (true) {
            if (max_wallet < max_bill || min_wallet < min_bill) {
                max_bill = max_bill / 2;
                answer++;
            }
            if (min_bill > max_bill) {
                int temp = min_bill;
                max_bill = temp;
                min_bill = max_bill;
            }
            if (max_wallet >= max_bill && min_wallet >= min_bill) {
                break;
            }
        }
        return answer;
    }
}

