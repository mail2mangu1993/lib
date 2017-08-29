import java.util.*;
import java.math.*;
public class suffix {
	static String in;
	static int suffixArray[][];
	
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		in  = s.next();
		size();
		create();
	}
	static int[][] size() {
		int length = in.length();
		long temp = 1;
		int count = 0;
		while(temp<length) {
			long next = (long)(Math.pow(2,count));
			temp = next;
			count++;
		}
		System.out.println(temp+" "+count);
		suffixArray=new int [count][length];
		return suffixArray;
	}

	static void create() {
		int rank[] = initArray();
		for(int c=0;c<in.length();c++) {
			int index = in.charAt(c)-'a';
			suffixArray[0][c] = rank[index];
		}	

		int round = 1;
		int length = 1;
		while(length < in.length()) {
			List<suffixNode>tempList = new ArrayList<suffixNode>();
			for(int c=0;c<in.length();c++) {
				int one = suffixArray[round-1][c];
				int two = -1;
				if(c+length<in.length()) {
					two  = suffixArray[round-1][c+length];
				}
				suffixNode currentNode = new suffixNode();
                                currentNode.index = c;
                                currentNode.rankStart = one;
                                currentNode.rankAfterHalf = two;
				tempList.add(currentNode);
			}
			Collections.sort(tempList);
			suffixNode prev = null;
			int rankCurrent = 1;
			for(int c=0;c<tempList.size();c++) {
				suffixNode afterSort = tempList.get(c);
				if(c==0) {
					suffixArray[round][afterSort.index] = rankCurrent;
					prev = afterSort;
					continue;
				}
				if(afterSort.isEqual(prev)) {
					suffixArray[round][afterSort.index] = rankCurrent;
				}
				else {
					rankCurrent++;
					suffixArray[round][afterSort.index] = rankCurrent;
					prev = afterSort;
				}
			}
			round++;
			length*=(2);
		}

		for(int c=0;c<in.length();c++) {
		  System.out.print(suffixArray[round-1][c]+" "); // this is pring the data.
		}
                System.out.println("");

	}
	static int[] initArray() {
		char[] t = new char[in.length()];
		for(int c=0;c<in.length();c++) {
			t[c]= in.charAt(c);
		}
		Arrays.sort(t);
		int currentRank =0;
		char prev='!';
		int rank[]=new int [26];
		for(int c=0;c<t.length;c++) {
			if(c==0) {
				prev = t[c];
				int index = prev-'a';
				currentRank = 1;
				rank[index] = currentRank;
			} else {
				if(prev != t[c]) {
					currentRank++;
					prev = t[c];
					currentRank++;
					int index = prev-'a';
					rank[index] = currentRank;
				} 
			}
		 }
		 return rank;
	}
}

class suffixNode implements Comparable<suffixNode>{
	int index;
	int rankStart;
	int rankAfterHalf;

	public void suffixNode(int a ,int b,int c) {
		this.index = a;
		this.rankStart = b;
		this.rankAfterHalf = c;
	}
	public int compareTo(suffixNode b) {
		if(this.rankStart>b.rankStart) {
			return 1;
		} else if(this.rankStart <b.rankStart) {
			return -1;
		} else {
			if(this.rankAfterHalf > b.rankAfterHalf) {
				return 1;
			} else if(this.rankAfterHalf <b.rankAfterHalf) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public boolean isEqual(suffixNode b) {
		if(this.rankStart == b.rankStart && this.rankAfterHalf == b.rankAfterHalf){
			return true;
		}
		return false;
	}
}