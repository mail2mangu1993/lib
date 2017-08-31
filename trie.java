import java.util.*;
import java.io.*;

public class trie {
	static myScanner s;
  static int trie[][];
  static int n;
  static String in[];
  static int find;
  static String[] findS;
  static int untilNow;
	public static void main(String[]args) {
		s = new myScanner();
    n = s.nextInt();
    in = new String[n];
    for(int c=0;c<n;c++) {
      in[c] = s.next();
    }
	  find = s.nextInt();
    findS = new String[find];
    
    for(int c=0;c<find;c++) {
      findS[c] = s.next();
    }

    size();
    for(int c=0;c<n;c++) {
      insert(in[c]);
    }

    for(int c=0;c<find;c++) {
       
       if(find(findS[c])) {
        System.out.println("YES");
       } else {
        System.out.println("NO");
       }
    }

	}

  static void size() {
    int size = 0;
    for(int c=0;c<n;c++) {
      size+=(in[c].length());
    }
    trie = new int[size][26];
    
    for(int c=0;c<size;c++) {
      for(int c1=0;c1<26;c1++) {
        trie[c][c1] = -1;
      }
    }
    untilNow = 0;
  }

  static void insert(String input) {

     int node = 0;
     for(int c=0;c<input.length();c++) {
        int index = input.charAt(c)-'a';
        if(trie[node][index]==-1){
          untilNow++;
          trie[node][index] = untilNow;
        }
        node = trie[node][index];
     }
  }

  static boolean find(String input) {
    int node = 0;
    for(int c=0;c<input.length();c++) {
      int index = input.charAt(c)-'a';
      if(trie[node][index] == -1) {
        return false;
      }
      node = trie[node][index];
    }
    return true;
  }
}

class myScanner {
    BufferedReader br;
    StringTokenizer st;
    
    public myScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
      while (st == null || !st.hasMoreElements()) {
          try {
              st = new StringTokenizer(br.readLine());
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      return st.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public String nextLine(){
      String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
   }
}