import java.util.*;
import java.io.*;

class Solution
{
    public static String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            PriorityQueue<Student> pq = new PriorityQueue<>((s1, s2) -> Double.compare(s2.score, s1.score));
            
			for(int i = 0; i < N; i++){
            	st = new StringTokenizer(br.readLine());
                double mid = Integer.parseInt(st.nextToken());
                double last = Integer.parseInt(st.nextToken());
                double work = Integer.parseInt(st.nextToken());
                
                double score = mid * 0.35 + last * 0.45 + work * 0.2;
                pq.add(new Student(i, score));
            }
            
            Student[] list = new Student[N];
            for(int i = 0; i < N; i++){
            	list[i] = pq.poll();
            }
            
            for(int i = 0; i < N; i++){
            	Student current = list[i];
                if(current.id == K - 1){
                	System.out.println("#" + test_case + " " + grade[i / (N / 10)]);
                }
            }
        }
	}                                                            
    
    static class Student{
    	int id;
        double score;
        
        Student(int id, double score){
        	this.id = id;
            this.score = score;
        }
    }
}