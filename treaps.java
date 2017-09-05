import java.util.*;
public class treaps {
	
	public static void main(String[]args) {

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
	static node insert(node root , node current) {
		if(root == null) {
			root  = new node(current.data,current.heapValue);
			return root;
		}

		if(root.data >= current.data) {
			root.left = insert(root.left,current);
			if(root.left.heapValue > root.heapValue) {
				root = rightRotate(root);
			}

		} else {
			root.right = insert(root.right,current);
			if(root.right.heapValue > root.heapValue) {
				root = leftRotate(root);
			}
		}
		return root;
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
	long data;
	long heapValue;
	node left;
	node right;
	public node(int data , int heapValue){
		this.data = data;
		this.heapValue = heapValue;
		this.left = null;
		this.right = null;
	}

}