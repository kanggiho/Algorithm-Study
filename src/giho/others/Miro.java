package giho.others;

public class Miro {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
        StringBuilder sb = new StringBuilder();
        String[] direction = {"d","l","r","u"};
        int[] rx = {1,0,0,-1};
        int[] ry = {0,-1,1,0};
        int[] goal = new int[4];
        boolean flag = false;

        int l_count=0;
        int r_count=0;

        int dx = r-x;
        int dy = c-y;
        if(dx>0) goal[0]+=dx;
        else if(dx<0) goal[3]+=(-dx);

        if(dy>0) goal[2]+=dy;
        else if(dy<0) goal[1]+=(-dy);

        int must = Math.abs(dx)+Math.abs(dy);
        int move = k-must;
        int mcount = 0;

        if(move<0||move%2!=0||must>k){
            return answer;
        }

        for(int i = 0 ; i < k ; i++){
            for(int j = 0 ;j < 4 ; j++){

                int nx = x+rx[j];
                int ny = y+ry[j];

                if(nx<1||nx>n||ny<1||ny>m){
                    continue;
                }


                if(goal[j]!=0){
                    sb.append(direction[j]);
                    goal[j]--;
                    x=nx;
                    y=ny;
                    break;
                }
                if(flag){
                    if(j==2){
                        if(l_count==r_count) continue;
                    }
                }

                if(j==0||j==1){
                    if(mcount==move/2){
                        flag=true;
                        continue;
                    }
                    mcount++;
                }

                if(j==1) l_count++;
                if(j==2) r_count++;


                sb.append(direction[j]);
                x=nx;
                y=ny;
                break;

            }
        }

        return sb.toString();
    }
}
