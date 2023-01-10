package tree;


// Solution1
// 종이접기

// 종이를 반으로 접었을 때 ,안으로 파인 부분은 0, 블록 튀어나온 부분은 1이라고 하자.
// 종이를 접었을 때는 오른쪽에서 왼쪽으로 접는다.
// 종이를 N번 접었을 때의 접힌 상태를 출력하는 문제를 작성하세요.

public class Solution1 {
	
	
	public static void solution(int N) {
		int[] binaryTree = new int[(int)Math.pow(2, N)];
		
		
		binaryTree[0] = 0; //루트
		
		
		for(int i = 0; i < 2 * (N-1) - 1; i++) {
			
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			
			
			binaryTree[left] = 0;
			binaryTree[right] = 1;
			
		}
		
		
		inOrder(binaryTree, 0);
		System.out.println();
	}
	
	public static void inOrder(int arr[], int idx) {
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;
		
		if(left < arr.length-1) {
			inOrder(arr, left);
		}
		
		System.out.print(arr[idx] + " ");
		
		if(left < arr.length-1) {
			inOrder(arr, right);
		}
		
	}

	public static void main(String[] args) {
		
		solution(1);
		solution(2);
		solution(3);

	}
	
	

}
