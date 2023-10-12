class Solution {
	static int answer;
	public int solution(int[] numbers, int target) {
		answer = 0;
		dfs(0, 0, numbers, target); 
		return answer;
	}
	
	private void dfs(int cnt, int res, int[] numbers, int target) {
		if(cnt == numbers.length) {
			if(res == target) {
				answer++; 
			}
            return;
		}
		
		dfs(cnt+1, res + numbers[cnt], numbers, target);
		dfs(cnt+1, res - numbers[cnt], numbers, target);
		
	}
}