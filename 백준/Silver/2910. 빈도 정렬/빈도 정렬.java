import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;


public class Main {
    static class Data implements Comparable<Data> {
        long no;
        int idx = 0 ;
        int cnt = 0 ;

        public Data(int no){
            this.no = no;
        };

        public Data(long no, int idx, int cnt) {
            this.no = no;
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Data o) {
            if(o.cnt == this.cnt){
                return this.idx - o.idx;
            }else{
                return -(this.cnt - o.cnt);
            }
        }

        @Override
        public String toString() {
            return "Data{" +
                    "no=" + no +
                    ", idx=" + idx +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Data> map = new HashMap<>();
        List<Data> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int cur = Integer.parseInt(st.nextToken());

            if(!map.containsKey(cur)){
                Data tmp = new Data(cur, i, 0);
                map.put(cur, tmp);
                list.add(tmp);
            }
            map.get(cur).cnt++;
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            Data tmp = list.get(i);
            long num = tmp.no;
            int cnt = tmp.cnt;
            while (cnt-->0)
                sb.append(num).append(' ');
        }
        System.out.println(sb);
    }
}