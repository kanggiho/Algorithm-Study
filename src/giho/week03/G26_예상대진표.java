package giho.week03;

public class G26_예상대진표 {

    public int solution(int n, int a, int b) {
        int stage = 0;

        do {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            stage++;
        } while (a != b);

        return stage;
    }
}
