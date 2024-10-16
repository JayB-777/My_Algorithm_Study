import java.util.*;

class Solution {
    static List<String> dictionary = new ArrayList<>();
    static char[] letters = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        generateWords("", 0);
        
        Collections.sort(dictionary);
        
        return dictionary.indexOf(word) + 1;
    }
    
    public void generateWords(String currentWord, int length){
        if(length > 5){
            return;
        }
        
        if(!currentWord.equals("")){
            dictionary.add(currentWord);
        }
        
        for(char letter : letters){
            generateWords(currentWord + letter, length + 1);
        }
    }
}