package algorithm;
/*
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2

------
YES
NO


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int V, E;
        boolean[] visit;
        int[] colors;
        List<List<Integer>> adjs;
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 0; i < K; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	V = Integer.parseInt(st.nextToken());
        	E = Integer.parseInt(st.nextToken());
        	
        	visit = new boolean[V + 1];
        	colors = new int[V + 1];
        	adjs = new ArrayList<>();
        	for (int j = 0; j < V; j++) {
				adjs.add(new ArrayList<>());
			}
        	
        	for (int j = 0; j < E; j++) {
        		st = new StringTokenizer(br.readLine());
        		adjs.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
			}
        	
        	for (int j = 0; j < visit.length; j++) {
				if(!visit[j]) {
					visit[j] = true;
					que.add(j);
				}
				
				while(!que.isEmpty()) {
					
				}
			}
        	
        	
		}
    }
}