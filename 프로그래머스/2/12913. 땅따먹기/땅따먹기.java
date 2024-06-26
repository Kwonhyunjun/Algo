import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int R = land.length;
        int C = land[0].length;
        
        int[][] map = new int[R][C];
        
        // 첫 번째 행 초기화
        for (int i = 0; i < 4; i++) {
            map[0][i] = land[0][i];
        }

        // 두 번째 행부터 처리
        for (int i = 1; i < R; i++) {
            int first = 0, second = 0, firstIdx = -1;
            
            // 이전 행의 최대값(first)과 두 번째로 큰 값(second) 찾기
            for (int j = 0; j < 4; j++) {
                if (map[i-1][j] > first) {
                    second = first;
                    first = map[i-1][j];
                    firstIdx = j;
                } else if (map[i-1][j] > second) {
                    second = map[i-1][j];
                }
            }

            // 현재 행 갱신
            for (int j = 0; j < 4; j++) {
                if (j == firstIdx) {
                    map[i][j] = land[i][j] + second;
                } else {
                    map[i][j] = land[i][j] + first;
                }
            }
        }
        
        // 마지막 행의 최대값 찾기
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, map[R-1][i]);
        }
        
        return answer;
    }
}
