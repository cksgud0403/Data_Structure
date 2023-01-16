package heap;

// Solution1
// 최소 힙에서 특정 값을 변경하는 코드를 작성하세요.

// 특정한 값이 여러개이면 모두 바꿔주세요.


public class Solution1 {
	
	
	public static void solution(MinHeap minheap, int oldValue, int newValue) {
		for(int i = 1; i < minheap.heap.size(); i++) { //레벨 순회를 한다.
			if(minheap.heap.get(i) == oldValue) {
				minheap.heap.set(i, newValue); //새로운 값으로 바꾼다.
				moveUp(minheap, i);
				moveDown(minheap, i);
				i = 0; //다시 1에서부터 oldValue를 찾기 위해서
			}
		}
	}
	
	
	public static void moveUp(MinHeap minheap, int idx) {
		
		//현재 변경된 노드 값이 부모 노드 값 보다 더 작다면 값을 바꾼다.
		while(idx > 1 && minheap.heap.get(idx) < minheap.heap.get(idx / 2)) {
			int parentValue = minheap.heap.get(idx / 2);
			minheap.heap.set(idx / 2, minheap.heap.get(idx));
			minheap.heap.set(idx, parentValue);
			idx /= 2;
		}
	}
	
	
	public static void moveDown(MinHeap minheap, int idx) {
		
		
		while(true) {
			
			int leftIdx = idx * 2;
			int rightIdx = idx * 2 + 1;
			int targetIdx = -1;
			
			if(rightIdx < minheap.heap.size()) {
				targetIdx  = minheap.heap.get(leftIdx) < minheap.heap.get(rightIdx) ? leftIdx : rightIdx;
			}else if(leftIdx < minheap.heap.size()) { //왼쪽 자식만 있다면
				targetIdx = leftIdx;
			}else { //자식이 없다면
				break;
			}
			
			if(minheap.heap.get(targetIdx) < minheap.heap.get(idx)) {
				int parentValue = minheap.heap.get(idx);
				minheap.heap.set(idx, minheap.heap.get(targetIdx));
				minheap.heap.set(targetIdx, parentValue);
			}else {
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
			
			MinHeap minheap = new MinHeap();
			
			minheap.insert(10);
			minheap.insert(20);
			minheap.insert(10);
			
			minheap.printTree();
			
			solution(minheap, 10, 50);
			
			minheap.printTree();
		}
	
	

}
