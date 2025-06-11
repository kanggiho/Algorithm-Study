package giho.week07;

public class G64_카펫 {
    public int[] solution(int brown, int yellow) {
        return new int[]{((brown+4)+(int)Math.sqrt((brown+4)*(brown+4)-16*(brown+yellow)))/4,((brown+4)-(int)Math.sqrt((brown+4)*(brown+4)-16*(brown+yellow)))/4};
    }
}