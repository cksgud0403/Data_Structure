package tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

class Node2 {
	char data;
	Node2 left;
	Node2 right;
	Node2 parent;
	
	public Node2(char data, Node2 left, Node2 right, Node2 parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}


class BinaryTree3 {
	Node2 head;
	
	BinaryTree3() {
		
	}
	
	BinaryTree3(char[] arr) {
		Node2[] nodes = new Node2[arr.length];
		
		
		for(int i = 0; i < arr.length; i++) {
			nodes[i] = new Node2(arr[i], null, null, null);
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			
			
			if(left < arr.length) {
				nodes[i].left = nodes[left];
				nodes[left].parent = nodes[i];
			}
			
			if(right  < arr.length) {
				nodes[i].right = nodes[right];
				nodes[right].parent = nodes[i];
			}
		}
		
		this.head = nodes[0];
	}
	
	
	
	public Node2 searchNode(char data) {
		
		
		//레벨 순회 방식으로 노드를 찾기
		
		Queue<Node2> queue = new LinkedList<Node2>();
		
		queue.add(head);
		
		
		while(!queue.isEmpty()) {
			Node2 node = queue.poll();
			
			
			if(node.data == data) {
				return node;
			}else {
				if(node.left != null) {
					queue.add(node.left);
				}
				
				if(node.right != null) {
					queue.add(node.right);
				}
			}
		}
		
		return null;
		
		//전위 순회 방식으로 노드를 찾기
//		Stack<Node2> stack = new Stack<>();
//		
//		
//		stack.add(head);
//		
//		
//		
//		while(!stack.isEmpty()) {
//			Node2 node = stack.pop();
//			
//			if(node.data == data) {
//				return node;
//			}else {
//				if(node.right != null) {
//					stack.add(node.right);
//				}
//				
//				if(node.left != null) {
//					stack.add(node.left);
//				}
//			}
//			
//		}
//		
//		
//		
//		return null;
		
		
		
		
		
		
		
	}
	
	
	
	public Integer checkSize(char data) {
		
		
		Node2 node = this.searchNode(data);
		
		Queue<Node2> queue = new LinkedList<>();
		
		queue.add(node);
		
		int size = 0;
		
		while(!queue.isEmpty()) {
			Node2 cur = queue.poll();
			
			if(cur.left != null) {
				queue.offer(cur.left);
				size++;
			}
			
			if(cur.right != null) {
				queue.offer(cur.right);
				size++;
			}
			
			
		}
		
		
		//자기 자신을 포함하니까 ++ 하면서 return
		
		return ++size;
		
	}
	
	
}


public class Practice3 {

	public static void main(String[] args) {
		
		char[] arr = new char[10];
		
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (char)('A' + i);
		}
		
		
		BinaryTree3 bt = new BinaryTree3(arr);
		
		// Root node
		System.out.println("Root: " + bt.head.data);
		
		
		// B's child node
		Node2 b = bt.searchNode('B');
		
		if(b.left != null) {
			System.out.println("B's left child node : " + b.left.data);
		}
		
		if(b.right != null) {
			System.out.println("B's right child node: " + b.right.data);
		}
		
		
		//F's parent node
		Node2 F = bt.searchNode('F');
		
		if(F.parent != null) {
			System.out.println("F -> parent: " + F.parent.data);

		}
		
		
		//leaf node
		
		System.out.println("Leaf node");
		
		
		for(int i = 0; i < arr.length; i++) {
			Node2 node = bt.searchNode((char)('A' + i));
			
			if(node.left == null && node.right == null) {
				System.out.print(node.data + " ");
			}
		}
		
		
		System.out.println();
		
		//E's Depth
		
		Node2 E = bt.searchNode('E');
		
		
		Node2 cur = E;
		
		
		int cnt = 0;
		
		while(cur.parent != null) {
			cur = cur.parent;
			cnt++;
		}
		
		
		System.out.println("E depath: " + cnt);
		
		
		
		
		// Level2 Node
		
		System.out.print("Level2 node: ");
		
		for(int i = 0; i < arr.length; i++) {
			Node2 target = bt.searchNode((char)('A' + i));
			
			cur = target;
			
			
			cnt = 0;
			while(cur.parent != null) {
				cur = cur.parent;
				cnt++;
			}
			
			if(cnt == 2) {
				System.out.print(target.data + " ");
			}
			
		}
		
		System.out.println();
		
		// Hieght
		int maxCnt = Integer.MIN_VALUE;
		
		for(int i = 0; i<arr.length; i++) {
			Node2 target = bt.searchNode((char)('A' + i));
			
			
			cur = target;
			cnt = 0;
			while(cur.parent != null) {
				cur = cur.parent;
				cnt++;
			}
			
			
			if(maxCnt < cnt) {
				maxCnt = cnt;
			}

		}
		
		
		System.out.println("Height: " + maxCnt);
		
		
		
		//B's size
		
		System.out.println("B's size: " + bt.checkSize('B'));
		
		
		
		
		
	}

}
