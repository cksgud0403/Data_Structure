package tree;

import java.util.Arrays;

class BinaryTree {
	char[] arr;
	
	BinaryTree (char[] data) {
		this.arr = data.clone();
		System.out.println(Arrays.toString(data));

	}
	
	//전위 순회
	public void preOrder(int idx) {
		
		//현재 노드를 출력
		System.out.print(this.arr[idx] + " ");
		
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;
		
		if(left < arr.length) {
			this.preOrder(left);
		}
		
		if(right < arr.length) {
			this.preOrder(right);
		}
	}
	
	//중위 순회
	public void inOrder(int idx) {
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;
		
		
		if(left < this.arr.length) {
			inOrder(left);
		}
		
		
		System.out.print(this.arr[idx] + " ");

		
		if(right < this.arr.length) {
			inOrder(right);
		}
		
	}
	
	
	//후위 순회
	public void postOrder(int idx) {
		
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;
		
		if(left < this.arr.length) {
			postOrder(left);
		}
		
		if(right < this.arr.length) {
			postOrder(right);
		}
		
		System.out.print(this.arr[idx] + " ");
		
		
	}
	
	
	public void levelOrder(int idx) {
		for(int i = idx; i < this.arr.length; i++) {
			System.out.print(this.arr[i] + " ");
		}
		
		System.out.println();
	}
	
}

public class Practice1 {
	
	public static void main(String[] args) {
		char[] arr = new char[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (char)('A' + i);
		}
		
		BinaryTree bt = new BinaryTree(arr);
		
		
		System.out.println("== preOrder ==");
		
		bt.preOrder(0);
		System.out.println();
		
		
		System.out.println("== inOrder ==");
		
		bt.inOrder(0);
		System.out.println();

		
		System.out.println("== postOder ==");
		
		bt.postOrder(0);
		System.out.println();
		
		
		System.out.println("== levelOrder ==");
		
		bt.levelOrder(0);
		System.out.println();
		
	}
	
	
	
}
