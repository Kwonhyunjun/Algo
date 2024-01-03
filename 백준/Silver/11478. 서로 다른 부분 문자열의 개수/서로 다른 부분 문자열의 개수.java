import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> set = new HashSet<>();

        String str = br.readLine();

        for(int i=0; i<str.length(); i++){
            for(int j=i; j<str.length(); j++){
                String substr = str.substring(i,j+1);
//                System.out.printf("i : %d, j : %d, subStr : %s\n", i, j, substr);
                if(!set.contains(substr)){
                    set.add(substr);
                }
            }
        }

        System.out.println(set.size());
    }
}