import java.util.*; 

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;  
        int maxHealth = health; 
        int lastAttack = 0;
        
        for(int[] attack : attacks){
            int time = attack[0]; 
            int damage = attack[1]; 
            
            // 체력회복
            int diff = time - lastAttack -1; 
            // System.out.println(time + " : " + diff);
            
            int cure = diff * bandage[1] + (bandage[2] * (diff / bandage[0])); 
            
            health = ((health+cure) > maxHealth) ? maxHealth : health+cure; 
            // System.out.println("공격받기전 hp : " + health); 
            
            health -= damage; 
            
            if(health <= 0){
                break; 
            }
            
            lastAttack = time;
        }
        
        answer = health <= 0 ? -1 : health;
        
        
        return answer;
    }
}