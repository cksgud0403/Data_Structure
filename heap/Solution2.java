package heap;

// Solution2
// 최소 힙과 최대힙을 이용해서 내림차순, 오름차순 하는 코드를 작성하세요.

public class Solution2 {
	
	
	public static void solution(MinHeap minheap) {
		
		MaxHeap maxheap = new MaxHeap();
		
		
		System.out.print("ascending order: ");
		while(minheap.heap.size() != 1) {
			int data = minheap.delete();
			System.out.print(data + " ");
			maxheap.insert(data);
			
		}
		
		System.out.println();
		
		System.out.print("descending order: ");
		while(maxheap.heap.size() != 1) {
			System.out.print(maxheap.delete() + " ");
		}
		
		System.out.println();
	}
	
	
	public static void main(String[] args) {
			
		MinHeap minheap = new MinHeap();
		
		minheap.insert(30);
		minheap.insert(40);
		minheap.insert(10);
		minheap.insert(50);
		minheap.insert(60);
		minheap.insert(70);
		minheap.insert(20);
		minheap.insert(30);
		
		solution(minheap);
	}

}