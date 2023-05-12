import java.util.*;
import java.io.*;

public class cc3p5 {
	
	public static class railway{
		int start;
		int end;
		public railway(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        List<Integer>[] adj = new ArrayList[N];
        Queue<Integer> queue = new LinkedList<>();
        int[] step = new int[N];
        int[][] step2 = new int[N][N];
        railway[] depths;
        
       	for(int i = 0; i < N; i++) {
       		adj[i] = new ArrayList<>();
       		step[i] = Integer.MAX_VALUE;
       	}
        
        for(int i = 0; i < N-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken())-1;
        	int v = Integer.parseInt(st.nextToken())-1;
        	
        	adj[u].add(v);
        	adj[v].add(u);
        }
        
        
        int max = 0; //max depth
        
        step[0] = 0;
        queue.add(0);
        while(!queue.isEmpty()) {
        	int cur = queue.poll();
        	
        	for(int next : adj[cur]) {
        		if(step[cur]+1 < step[next]) {
        			queue.add(next);
        			step[next] = step[cur]+1;
        			max = Math.max(step[next], max);
        		}
        	}
        }
        
        depths = new railway[max+1];
        for(int next = 0; next < N; next++) {
        	if(depths[step[next]] == null) {
        		depths[step[next]] = new railway(next, next);
        	}else {
        		depths[step[next]] = new railway(depths[step[next]].start, next);
        	}
        }
        
        for (int i = 0; i <= 3; i++) {
        	System.out.println(depths[i].start + " " + depths[i].end);
        }
        	
        for(int i = 0; i < N; i++) {
        	int src = i, depth = step[i];
        	
        	
        	Arrays.fill(step2[i], Integer.MAX_VALUE);
        	queue.add(src);
        	step2[i][src] = 0;
        	
        	while(!queue.isEmpty()) {
        		int cur = queue.poll();
        		
        		for(int next : adj[cur]) {
        			if(step2[i][cur]+1 < step2[i][next]) {
        				queue.add(next);
        				step2[i][next] = step2[i][cur]+1;	
        			}
        		}
        		
        		if(depths[depth].start < cur+1 && cur+1 <= depths[depth].end && step2[i][cur]+1 < step2[i][cur+1]) {
        			queue.add(cur+1);
        			step2[i][cur+1] = step2[i][cur]+1;	
        		}
        		if(depths[depth].start <= cur-1 && cur-1 < depths[depth].end && step2[i][cur]+1 < step2[i][cur-1]) {
        			queue.add(cur-1);
        			step2[i][cur-1] = step2[i][cur]+1;
        		}
        	}
        }
        
    	for(int i = 0; i < Q; i++) {
        	st = new StringTokenizer(br.readLine());
        	int src = Integer.parseInt(st.nextToken())-1, dest = Integer.parseInt(st.nextToken())-1, depth = Integer.parseInt(st.nextToken());
        	
        	depth = depth <= max ? depth : 0;
        	
        	int ans = Integer.MAX_VALUE;
       
        	for(int next = depths[depth].start; next <= depths[depth].end; next++) {
        		ans = Math.min(ans, step2[next][src] + step2[next][dest]);
        	}
        	ans = Math.min(step2[0][src] + step2[0][dest], ans);
        	ans = Math.min(step[src]+step[dest], ans);
        	
        	out.println(ans);
    	}
    	
        out.flush();
    }

}
