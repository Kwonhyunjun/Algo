import java.util.*;
import java.io.*;

class Solution {
    static int[][] user; 
    static int[] emoticon; 
    static int maxJoin, maxTotal; 
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        user = users; 
        emoticon = emoticons; 
        maxJoin = 0;
        maxTotal= 0; 
        
        System.out.println("이모티콘 개수 : " + emoticons.length);
        
        // 1. 이모티콘 할인률 측정
        int[] result = new int[emoticons.length];
        discountRate(0, emoticons.length, result); 
        
        answer = new int[]{maxJoin, maxTotal}; 
            
        return answer;
    }
    
    // 할인률 책정(백트레킹)
    static void discountRate(int cnt, int len, int[] result){
        if(cnt == len){
            // System.out.println("result : " + Arrays.toString(result));
            
            // 할인률 계산
            int[] disP = new int[len]; 
            for(int i=0; i<len; i++){
                int discount = emoticon[i] * result[i] / 100;
                disP[i] = emoticon[i] - discount;
            }
            // System.out.println("disP : " + Arrays.toString(disP));
            
            int curJoin = 0;
            int curTotal = 0; 
            
            for(int[] u : user){
                int criteria = u[0]; // 할인비율 
                
                int tempTotal = 0; 
                for(int i=0; i<len; i++){ // 이모티콘 사기 
                    if(criteria <= result[i]){
                        tempTotal += disP[i]; 
                    }
                }
                
                if(tempTotal >= u[1]){ // 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면
                    tempTotal = 0; 
                    curJoin++; 
                }
                
                curTotal += tempTotal;
            } // user순회
            
            if(curJoin > maxJoin){
                maxJoin = curJoin; 
                maxTotal = curTotal; 
            }else if(curJoin == maxJoin){
                if(curTotal > maxTotal){
                    maxJoin = curJoin; 
                    maxTotal = curTotal;
                }
            }
                
            
            return; 
        }
        
        result[cnt] = 10;
        discountRate(cnt+1, len, result);
        
        result[cnt] = 20;
        discountRate(cnt+1, len, result);
        
        result[cnt] = 30;
        discountRate(cnt+1, len, result);
        
        result[cnt] = 40;
        discountRate(cnt+1, len, result);
    }
}