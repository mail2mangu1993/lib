import java.util.*;
import java.io.*;
public class scc {

	static int n;
	static int graph[][];
	public static void main(String[]args) {

		Scanner s = new Scanner(System.in);
		n  = s.nextInt();
		in = new int[n][n];
		int edge = s.nextInt();
		for(int c=0;c<edge;c++) {
			int source = s.nextInt();
			int dest = s.nextInt();
			in[source-1][dest-1] = 1;
		}
		List<Integer>result = new ArrayList<Integer>();
		boolean visited[]=new boolean[n];
		dfs(0,visited,result);
		for(int c=0;c<result.size();c++) {
			System.out.print(result.get(c)+" ");
		}
	}

	static void dfs(int v , boolean visited[],List<Integer>order){

		visited[v] = true;
		order.add(v);
		for(int c=0,c<n;c++) {
			if(in[v][c]==1 && !visited[c]) {
				dfs(c,visited,order);
			}
		}
		return;
	}
}