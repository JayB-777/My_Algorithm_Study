import java.util.*;
import java.io.*;

class Solution
{
    public static HashMap<Character, Character> hash;
                          
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hash = new HashMap<>();
        hash.put('(', ')');
        hash.put('{', '}');
        hash.put('<', '>');
        hash.put('[', ']');
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{   
			int N = Integer.parseInt(br.readLine());
            String line = br.readLine();
            
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");
			if(isValid(line)){
            	sb.append(1);
            }  else {
            	sb.append(0);
            }
            
            System.out.println(sb);
		}
	}
    
    private static boolean isValid(String line){
        Deque<Character> stack = new ArrayDeque<>();
        
    	for(char c : line.toCharArray()){
        	if(c == '(' || c == '{' || c == '[' || c == '<'){
            	stack.push(c);
            } else{
            	char current = stack.pop();
                if(c != hash.get(current)){
                	return false;
                }
            }
        }
        return true;
    }
}