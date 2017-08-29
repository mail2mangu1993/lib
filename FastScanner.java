import java.io.*;
import java.util.*;
 
 
public class FastScanner{

   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      // Start writing your solution here. -------------------------------------
   
      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */

      // Stop writing your solution here. -------------------------------------
      out.close();
   }

     

   //-----------PrintWriter for faster output---------------------------------
   
      
   //-----------MyScanner class for faster input----------
  
   //--------------------------------------------------------
 }

class io {
    BufferedReader br;
    StringTokenizer st;
    public static PrintWriter out;
    
    public io() {
       br = new BufferedReader(new InputStreamReader(System.in));
       out = new PrintWriter(new BufferedOutputStream(System.out));
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