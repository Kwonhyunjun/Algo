import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<Boolean> list = new ArrayList<>();

        for(int n = 0; n < N; n++){
            for(int l = 0; l < L; l++)
                list.add(true);

            if(n != N-1)
                for(int t = 0; t < 5; t++)
                    list.add(false);
        }

        int result = 0;


        while(result < list.size()){
            if(list.get(result) == false)
                break;
            result += D;
        }

        str.append(result);

        System.out.print(str);
    }
}