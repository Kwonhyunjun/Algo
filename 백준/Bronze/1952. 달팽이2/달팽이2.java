import java.util.Scanner;

public class Main {
	
	static int M, N;
	static boolean[][] map;
	static int[] dx = {0,1,0,-1}; // 우, 하, 좌, 상
	static int[] dy = {1,0,-1,0}; // 우, 하, 좌, 상
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new boolean[M][N];
		solution(0,0);
	}

	public static void solution(int x, int y) {
		int sum = 1;
		int cnt = 0;
		int dir = 0;
		map[x][y] = true;
		while(dir < 4) {
			
			if(sum == N*M) {
				System.out.println(cnt);
				return;
			}
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx >= 0 && nx < M && ny >= 0 && ny < N && !map[nx][ny]) {
				sum++; // 이동칸 수
				map[nx][ny] = true;
				x = nx;
				y = ny;
			} else { // 방향회전
				cnt++;
				dir++;
			}
			
			// 상 방향 까지 모두 이동했다면 다시 우 방향으로 가기 위함
			if(dir >= 4) {
				dir = 0;
			}
		}
	}
}