import java.util.*;

class Solution {
    
    private List<String> answer;
    private boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, Comparator.comparing((String[] ticket) -> ticket[1]));
        dfs("ICN", "ICN", tickets, 0);
        

        return answer.get(0).split(" ");
        

    }
    
    private void dfs(String current, String path, String[][] tickets, int count){
        if(count == tickets.length){
            answer.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}