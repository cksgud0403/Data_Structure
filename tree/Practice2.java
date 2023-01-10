package tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	char data;
	Node left;
	Node right;
	
	public Node(char data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}


class BinaryTree2 {
	Node head;
	
	BinaryTree2() {
		
	}
	
	BinaryTree2(char[] arr) {
		Node[] nodes = new Node[arr.length];
		
		
		for(int i = 0; i < arr.length; i++) {
			nodes[i] = new Node(arr[i], null, null);
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			
			
			if(left < arr.length) {
				nodes[i].left = nodes[left];
			}
			
			if(right  < arr.length) {
				nodes[i].right = nodes[right];
			}
		}
		
		this.head = nodes[0];
	}
	
	
	//전위 순회
	public void preOrder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
		
	}
	
	
	public void inOrder(Node node) {
		if(node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
		
	}
	
	
	public void postOrder(Node node) {
		if(node == null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
		
	}
	
	public void levelOrder(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			
			System.out.print(cur.data + " ");
			
			if(cur.left != null) {
				queue.add(cur.left);
			}
			
			if(cur.right != null) {
				queue.add(cur.right);
			}
			
			
		}
	}
}


public class Practice2 {

	public static void main(String[] args) {
		
		char[] arr = new char[10];
		
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (char)('A' + i);
		}
		
		
		BinaryTree2 bt = new BinaryTree2(arr);
		
		System.out.println("== preOrder ==");
		bt.preOrder(bt.head);
		System.out.println();
		
		
		System.out.println("== inOrder ==");
		bt.inOrder(bt.head);
		System.out.println();

		
		
		System.out.println("== postOrder ==");
		bt.postOrder(bt.head);
		System.out.println();
		
		
		System.out.println("== levelOrder ==");
		bt.levelOrder(bt.head);
		System.out.println();
		
		
	}

}
