package library;
import java.util.*;
public class bfs {
    static int map[][];
    static int n;
    public static void main(String[]args) {
        Scanner s =new Scanner(System.in);
        n = s.nextInt();
        map = new int[n][n];
        for(int c=0;c<n;c++) {
            for(int c1=0;c1<n;c1++){
                map[c][c1] = s.nextInt();
            }
        }
        dfs(0);
        bfs(0);
    }
    static void dfs(int start){
        boolean visited[]=new boolean[n];
        Stack<Integer>st=new Stack<Integer>();
        st.push(start);
        List<Integer>dfsOrder = new ArrayList<Integer>(); 
        while(!st.isEmpty()) {
            int current = st.pop();
            visited[current] = true;
            dfsOrder.add(current);
            for(int c=0;c<n;c++){
                if(map[current][c] == 1 && !visited[c]) {
                    st.push(c);
                }
            }
        }
        System.out.print("dfs : ");
        for(int c=0;c<dfsOrder.size();c++){
            System.out.print(dfsOrder.get(c)+" ");
        }
        System.out.println("");
    }
    static void bfs(int start) {
        
        List<Integer>bfsOrder = new ArrayList<Integer>();
        boolean visited[] =new boolean[n];
        Queue<Integer>qt = new LinkedList<Integer>();
        qt.add(start);
        visited[start] = true;
        while(!qt.isEmpty()) {
            int current = qt.poll();
            visited[current] = true;
            bfsOrder.add(current);
            for(int c=0;c<n;c++) {
                if(!visited[c] && map[current][c] ==1) {
                    visited[c] = true;
                    qt.add(c);
                }
            }
        }
        System.out.print("bfs : ");
        for (int i = 0; i < bfsOrder.size(); i++) {
          System.out.print(bfsOrder.get(i)+" ");
        }
        System.out.println("");
    }
    static boolean isComplete(boolean visited[]) {
        for(int c=0;c<visited.length;c++){
            if(!visited[c]) {
                return false;
            }
        }
        return true;
    }
}
class node {
    int data;
    List<node>child;
    public node(int data){
        this.data = data;
        this.child = new ArrayList<node>();
    }
}
