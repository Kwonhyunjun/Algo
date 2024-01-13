import java.util.*;

class Solution {
    static List<Integer> list;
    static List<String> chk;
    static boolean[] v;
    static HashSet<String> set;
    static String[][] map;
    static int answer;
    
    
    public int solution(String[][] relation) {
        map = relation;

        list = new ArrayList<>();
        chk = new ArrayList<>();

//        for(int i=0; i<relation[0].length; i++){
//            set = new HashSet<>(); 
//            // System.out.println("i:"+i); 
//            boolean unique = true; 
//            for(int j=0; j<relation.length; j++){
//                String str = relation[j][i]; 
//                // System.out.println(str); 
//                if(set.contains(str)) {
//                    unique = false; 
//                    break; 
//                }
//                set.add(str);
//            }
//            if(unique){
//              answer++;   
//            } else{
//                list.add(i); 
//            }
//            // System.out.println(list); 
//        }

        v = new boolean[relation[0].length];
        dfs(0, 0, v);
        Collections.sort(chk, (String a, String b) -> a.length() - b.length());
        
        List<String> li = new ArrayList<>(); 
        
        for(int i=0; i< chk.size(); i++){ // s1
            String s1 = chk.get(i); //후보
            // System.out.println("s1: " + s1);
            
            boolean ccc = true; 
            for(int m = 0 ; m <li.size(); m++) { // s2
                String s2 = li.get(m); 
                // System.out.println("s2: " + s2);
                int cnt = 0;
                
                for(int k=0; k<s1.length(); k++){
                    for(int j=0; j<s2.length(); j++){
                        if(s1.charAt(k) == s2.charAt(j)) cnt++; 
                    }
                }
                
                // System.out.println(cnt + " " + s1.length());
                if(cnt == s2.length()){
                    ccc = false; 
                    break;
                }
                
            }
            
            if(ccc) li.add(s1); 
            // System.out.println(li);
        }
        
        
        answer = li.size(); 
        
        // chk : 후보군 
        return answer;
    }

    static void dfs(int cnt, int sel, boolean[] v) {
        if (cnt == v.length) {
            if (sel == 0)
                return;

            List<Integer> column = new ArrayList<>();
            
            String str = "";
            for (int i = 0; i < v.length; i++) {
                if (v[i]) {
                    column.add(i);
                    str += i;
                }
            }


            if (check(column)) {
                // System.out.println(column);

                answer++;
                chk.add(str);
            }

            return;
        }

        v[cnt] = false;
        dfs(cnt + 1, sel, v);

        v[cnt] = true;
        dfs(cnt + 1, sel + 1, v);

    }

    static boolean check(List<Integer> column) {
        // System.out.println(column);

        set = new HashSet<>();

        for (int i = 0; i < map.length; i++) {
            String str = "";

            for (int n : column) {
                str += map[i][n];
            }

            if (set.contains(str)) {
                return false;
            } else {
                set.add(str);
            }
        }
        return true;
    }

}