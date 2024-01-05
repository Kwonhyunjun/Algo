import java.io.*;
import java.util.*;

class Point{
	int x, y, len; 
	String str; 

	public Point(int x, int y, int len, String str) {
		super();
		this.x = x;
		this.y = y;
		this.len = len;
		this.str = str;
	}
}

public class Main {
    static int N, M, K;
    static int maxLen = Integer.MIN_VALUE; 
    static char[][] map;
    static HashMap<String, Integer> m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();

            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        String[] keys = new String[K];
        m = new HashMap<>();

        for(int i=0; i<K; i++){
            String str = br.readLine();
            keys[i] = str; // 정답 출력을 위한 key값 저장
            maxLen = Math.max(maxLen, str.length()); 
            m.put(str, 0); 
        }

        char[] c = new char[5];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dfs(i, j);
            }
        }
        
        StringBuilder sb = new StringBuilder(); 
        for(String s : keys) {
        	sb.append(m.get(s)).append("\n"); 
        }
        System.out.println(sb); 

    }

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static void dfs(int x, int y){
    	Queue<Point> q = new ArrayDeque(); 
    	q.add(new Point(x, y, 1, map[x][y]+"")); 
    	
    	while(!q.isEmpty()) {
    		Point cur = q.poll(); 
    		
    		if(cur.len > maxLen) continue;
    		
    		if(m.containsKey(cur.str)) {
    			m.put(cur.str, m.get(cur.str)+1); 
    		}
    		
    		for(int idx = 0; idx < 8; idx++) {
    			int nr = (cur.x + dr[idx]) %N; 
    			int nc = (cur.y + dc[idx]) %M; 
    			
    			if(nr < 0) nr += N; 
    			if(nc < 0) nc += M; 
    			
    			q.add(new Point(nr, nc, cur.len+1, cur.str+map[nr][nc])); 
    		}
    	}
    }
}