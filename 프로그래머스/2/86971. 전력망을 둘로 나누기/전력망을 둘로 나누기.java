import java.util.*; 

class Solution {
    /*
        n : 송전탑의 개수
        wires : 전선 정보
        
        return 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때, 
                두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)
    */
    
    static int N; 
    static List<Integer>[] adjList;
    static boolean[][] isConnected;
    static boolean[] v;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        N = n;
        adjList = new ArrayList[n+1];       // 인접리스트
        isConnected = new boolean[101][101];    // 연결여부
        
        for(int i=0; i<n+1; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int a = wire[0]; 
            int b = wire[1]; 
            
            adjList[a].add(b);
            adjList[b].add(a);
            
            isConnected[a][b] = isConnected[b][a] = true; 
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            isConnected[a][b] = isConnected[b][a] = false;
            int diff = Math.abs(solve(a) - solve(b));
            // System.out.printf("%d - %d 연결 삭제 -> %d\n", a, b, diff);
            
            answer = Math.min(answer, diff);
            
            isConnected[a][b] = isConnected[b][a] = true; 
            
        }
        
        return answer;
    }
    
    static int solve(int a){
        Queue<Integer> q = new ArrayDeque<>();
        v = new boolean[N+1]; // 방문 배열
        
        q.add(a);
        v[a] = true; 
        
        int cnt = 1;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++; 
            
            for(int i=0; i<adjList[cur].size(); i++){
                int nxt = adjList[cur].get(i);
                
                if(v[nxt]) continue; // 방문체크
                if(!isConnected[cur][nxt]) continue; // 연결여부
                
                v[nxt] = true; 
                q.add(nxt);
            }
            
        }
        
        return cnt;
    }
    
}