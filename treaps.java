import java.util.*;
public class treaps {
	static int n;
        static int in[];
        static List<Integer>sortedList;
	public static void main(String[]args) {
            
            Scanner s = new Scanner(System.in);
            n = s.nextInt();
            in = new int[n];
            for(int c=0;c<n;c++) {
                in[c] = s.nextInt();
            }
            sortedList = new ArrayList<Integer>();
            node root = null;
            root = insertArray(in,root);
            TraverseInOrder(root);
            for(int c=0;c<sortedList.size();c++) {
                 System.out.print(sortedList.get(c)+" ");
            }
            System.out.println("");
	}
        static node insertArray(int array[],node root) {
            for(int c=0;c<array.length;c++) {
                root=insert(root,array[c]);
            }
            return root;
        }
        static void TraverseInOrder(node root){
            if(root == null) {
                return;
            }
            TraverseInOrder(root.left);
            sortedList.add(root.data);
            TraverseInOrder(root.right);
            return;
        }
	static node search(int data,node root) {
		if(root == null || root.data == data) {
			return root;
		}
		int rootData = root.data;
		
		if(rootData  > data) {
			return search(data,root.left);
		} else {
			return search(data,root.right);
		} 
	}
	static node insert(node root , int data) {
		if(root == null) {
			root  = new node(data);
			return root;
		}

		if(root.data >= data) {
			root.left = insert(root.left,data);
			if(root.left.heapValue > root.heapValue) {
				root = rightRotate(root);
			}

		} else {
			root.right = insert(root.right,data);
			if(root.right.heapValue > root.heapValue) {
				root = leftRotate(root);
			}
		}
		return root;
	}
        
        static node delete(node root , int data){
            if(root == null){
                return root;
            } else if(root.data>data) {
                return delete(root.left,data);
            } else if(root.data<data) {
                return delete(root.right,data);
            } else if(root.left==null) {
                node temp = root.right;
                delete(root);
                root = temp;
            } else if(root.right==null) {
                node temp = root.left;
                delete(root);
                root = temp;
            } else if(root.left.heapValue >root.right.heapValue) {
                root = rightRotate(root);
                root.left = delete(root.left,data);
            } else {
                root = leftRotate(root);
                root.right = delete(root.right,data);
            }
            return root;
        }
        static node delete(node a) {
            a = null;
            return a;
        }
	static node leftRotate(node root) {
		node right = root.right;
		node rightLeft = right.left;
		right.left = root;
		root.right = rightLeft;
		return right;

	}
	static node rightRotate(node root) {
		node left = root.left;
		node leftRight = left.right;
		left.right = root;
		root.left = leftRight;
		return left;
	}
}

class node {
	int data;
	int heapValue;
	node left;
	node right;
	public node(int data){
		this.data = data;
		this.heapValue = (int)(Math.random()*100)%100;
		this.left = null;
		this.right = null;
	}

}