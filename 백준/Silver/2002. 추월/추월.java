import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> inMap = new HashMap<>();
        List<String> outList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            inMap.put(car, i);
        }
        
        for (int i = 0; i < N; i++) {
            outList.add(br.readLine());
        }
        
        int count = 0;
        
        for (int i = 0; i < outList.size(); i++) {
            for (int j = i + 1; j < outList.size(); j++) {
                if (inMap.get(outList.get(i)) > inMap.get(outList.get(j))) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}