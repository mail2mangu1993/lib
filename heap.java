import java.util.*;
import java.io.*;

public class heap{
	static myScanner s;
  static int n;
  static int in[];
  static List<Integer>heap;
  public static void main(String[]args) {
		s = new myScanner();
	  n = s.nextInt();
    in = new int[n];
    heap = new ArrayList<Integer>();
    for(int c=0;c<n;c++) {
      in[c] = s.nextInt();
      insert(in[c]);
    }	
    printSorted();
	}

  static void printSorted(){
     for(int c=0;c<n;c++){
        System.out.print(pop()+" ");
     }
     System.out.println("");
  }

  static void insert(int data){
    heap.add(data);
    int lastIndex = heap.size()-1;
    int currentIndex = lastIndex;
    
    while(currentIndex>0) {
      int parentIndex = (currentIndex-1)/2;
      int valueParent = heap.get(parentIndex);
      if(valueParent > heap.get(currentIndex)){
        heap.set(parentIndex,data);
        heap.set(currentIndex,valueParent);
      } else{
        break;
      }
      currentIndex = parentIndex;       
    }
    //System.out.println("after the insert");
  }
  
  static int pop() {
    int result = heap.get(0); // lowest element;s
    int last = heap.get(heap.size()-1);
    heap.set(0,last);
    heap = heap.subList(0,heap.size()-1);
    int currentIndex = 0;
    int nextChildOne = 1;
    int nextChildTwo = 2;
   // System.out.println(heap.size()+" "+nextChildTwo+" "+nextChildOne);
    while(nextChildTwo<heap.size() || nextChildOne<heap.size()) {
        int currentValue = heap.get(currentIndex);
        int childNextOne = heap.get(nextChildOne);
        int childNextTwo = -1;
        if(nextChildTwo<heap.size())
        childNextTwo = heap.get(nextChildTwo);

        if(currentValue > childNextOne) {
          heap.set(currentIndex,childNextOne);
          heap.set(nextChildOne,currentValue);
          currentIndex = nextChildOne;
        } else if(nextChildTwo<heap.size() && currentValue>childNextTwo) {
          heap.set(currentIndex,childNextTwo);
          heap.set(nextChildTwo,currentValue);
          currentIndex = nextChildTwo;
        } else {
          break;
        }
        nextChildOne = 2*currentIndex+1;
        nextChildTwo = 2*currentIndex+2;
        //System.out.println(nextChildTwo+" "+ nextChildTwo);
    }
    return result;
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