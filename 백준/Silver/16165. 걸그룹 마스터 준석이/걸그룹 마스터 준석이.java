import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, List> map1 = new HashMap<>();
        HashMap<List, String> map2 = new HashMap<>();

        for(int i=0; i<N; i++){
            String name = br.readLine();

            List<String> group = new ArrayList<String>();
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++){
                group.add(br.readLine());
            }

            Collections.sort(group);

            map1.put(name, group);
            map2.put(group, name);
        }

        for(int i=0; i<M; i++){
            String str = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if(type == 1){ // 멤버 -> 팀

                for(Map.Entry<List, String> entry : map2.entrySet()){
                    if(entry.getKey().contains(str)){
                        sb.append(entry.getValue()).append("\n");
                    }
                }
            }else{ // 팀 -> 멤버
                List<String> li = map1.get(str);
                for(String s : li){
                    sb.append(s).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}