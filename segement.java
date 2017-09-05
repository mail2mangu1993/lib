import java.util.*;
import java.math.*;
public class segement{
	
	static Scanner s;
	static int n;
	static long in[];
	static long seg[];
        static long lazy[];
	static int size;
	public static void main(String[]args) {
		s = new Scanner(System.in);
		n = s.nextInt();
		in = new long[n];
		for(int c=0;c<n;c++){
			in[c] = s.nextLong();
		}

		size();
		build(0,0,n-1);
                long result = search(0,0,n-1,0,2);
                System.out.println(result);
                change(0,0,n-1,0,2,25);
                result = search(0,0,n-1,0,2);
                System.out.println(result+" after change");

	}
        
        static void size() {
		double d1 = Math.log(n);
		d1 = Math.ceil(d1);
		d1+=(1.0);
		int pow = (int)(d1);
		double d2 = Math.pow(2,pow);
		size = (int)(d2)+1;
		seg = new long[size];
                lazy = new long[size];       
	}

	static void build(int index , int low ,int high) {

		if(low>high) {
			return;
		}

		if(low == high) {
			seg[index] = in[low];
			return;
		}

		int mid = low+ (high-low)/2;
		int indexOne  = 2*index+1;
		int indexTwo = 2*index+2;
		build(indexOne,low,mid);
		build(indexTwo,mid+1,high);
		seg[index] = seg[indexOne]+seg[indexTwo];
		return;
	}
        
        static void change(int index ,int low,int high , int intervalStart , int intervalEnd,long value) {
            if(low>high) {
                return;
            }
            
            if(low>intervalEnd || high < intervalStart) {
                return;
            }
            
            if(low == high) {
                seg[index] += value;
                return;
            }
            
            shift(index,low,high);  //this is lazy loading
            
            int mid = low+(high-low)/2;
            int indexOne = 2*index+1;
            int indexTwo = 2*index+2;
            change(indexOne,low,mid,intervalStart,intervalEnd,value);
            change(indexTwo,mid+1,high,intervalStart,intervalEnd,value);
            seg[index] = seg[indexOne]+seg[indexTwo];
            return;
            
        }
        
        static void lazyUpdate(int index , int intervalStart , int intervalEnd , long value) {
            if(intervalStart > intervalEnd) {
                return;
            }
            
            try{
                lazy[index] = value;
                seg[index]+=((intervalEnd-intervalStart+1)*value);
            } catch(Exception e) {
                System.out.println("Error : start :"+intervalStart+" End: "+ intervalEnd+" index : "+ index);
            }
            return;
        }
        
        static void shift(int index , int intervalStart,int intervalEnd) {
            if(intervalStart > intervalEnd) {
                return;
            }
            int mid = intervalStart + (intervalEnd - intervalStart)/2;
            lazyUpdate(2*index+1 , intervalStart , mid,lazy[index]);
            lazyUpdate(2*index+2,mid+1,intervalEnd,lazy[index]);
            lazy[index] = 0;
            return;
        }
        
	static long search(int index , int low,int high, int intervalStart,int intervalEnd) {

		if(low>high) {
			return 0;
		}

		if(high < intervalStart || low >intervalEnd) {
			return 0;
		}
                
                if(low<high)
                shift(index ,low,high);   // this is laoding lazy loads.
                
		if(low>=intervalStart && high <=intervalEnd) {
			return seg[index];
		}

		int mid = low+ (high-low)/2;

		long left = search(2*index+1,low,mid,intervalStart,intervalEnd);
		long right = search(2*index+2,mid+1,high,intervalStart,intervalEnd);

		return (left+right);
	}

}