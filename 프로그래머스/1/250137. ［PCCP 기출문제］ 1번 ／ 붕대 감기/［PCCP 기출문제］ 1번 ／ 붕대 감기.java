class Solution {
    // public static int maxHealCount;
    // public static int maxLifeCount;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        
        int maxHealCount = bandage[0];
        int maxLifeCount = attacks[attacks.length - 1][0];
        
        // 사용하고 반환할 체력
        int nowHealth = health;
        
        int maxHealth = health;
        int lifeCount = 0;
        int healCount = 0;
        int attacksFlag = 0;
        
        while(lifeCount < maxLifeCount) {
            lifeCount++;
            if(lifeCount == attacks[attacksFlag][0]){
                nowHealth = Math.max(nowHealth - attacks[attacksFlag][1], 0);
                    if(nowHealth <= 0){
                        return -1;
                    }
                healCount = 0;
                attacksFlag++;
            } else {
                nowHealth = Math.min(nowHealth + bandage[1], maxHealth);
                healCount++;
            }
            if(healCount == maxHealCount){
                nowHealth = Math.min(nowHealth + bandage[2], maxHealth);
                healCount = 0;
            }
            
        }
        
        
        return nowHealth;
    }
    
}