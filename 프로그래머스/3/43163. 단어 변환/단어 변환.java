import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        Queue<WordNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(new WordNode(begin, 0));
        
        while(!queue.isEmpty()){
            WordNode current = queue.poll();
            
            if(current.getWord().equals(target)){
                return current.getStep();
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && canTransform(current.getWord(), words[i])){
                    visited[i] = true;
                    queue.add(new WordNode(words[i], current.getStep() + 1));
                }
            }
        }
        return 0;
    }
    
    private boolean canTransform(String word1, String word2){
        int diffCount = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                diffCount++;
            }
            if(diffCount > 1){
                return false;
            }
        }
        return true;
    }
}
    
class WordNode {
    private String word;
    private int step;
    
    WordNode(String word, int step){
        this.word = word;
        this.step = step;
    }
    
    public String getWord(){
        return this.word;
    }
    
    public int getStep(){
        return this.step;
    }
}