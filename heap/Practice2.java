//비선형 자료구조 - 힙
//ArrayList로 최소 힙 구현
package heap;

import java.util.ArrayList;

class MaxHeap {
	ArrayList<Integer> heap;
	
	public MaxHeap() {
		this.heap = new ArrayList<Integer>();
		this.heap.add(0); //인덱스 0번 위치에 0 데이터 삽입 이후 1번 인덱스부터 데이터를 삽입하기 위함.
	}
	
	
	public void insert(int data) {
		this.heap.add(data);
		
		int idx = this.heap.size()-1; //현재 십입된 노드의 위치 인덱스 값
		
		//현재 삽입된 노드의 값이 부모 노드 값보다 더 크다면 
		while(idx > 1 && data > this.heap.get(idx / 2)) {
			this.heap.set(idx, this.heap.get(idx / 2)); //현재 노드의 데이터 값을 부모 노드의 데이터로 변환시킨다.
			idx /=2;
		}
		
		this.heap.set(idx, data);
	}
	
	
	public Integer delete() {
		if(this.heap.size() == 1) {
			System.out.println("heap is empty");
			return null;
		}
		
		
		int target =  this.heap.get(1); //루트 노드를 꺼낸다.
		
		this.heap.set(1, this.heap.get(this.heap.size()-1)); //마지막 노드 데이터를 루트 노드 값으로 세팅
		this.heap.remove(this.heap.size()-1);
		
		int idx = 1;
		
		while(true) {
			int leftIdx =  idx * 2;
			int rightIdx =  idx * 2 + 1;
			
			int targetIdx = -1;
			
			
			if(rightIdx < this.heap.size()) { //왼쪽, 오른쪽 둘다 있다면
				targetIdx  = this.heap.get(leftIdx) < this.heap.get(rightIdx) ? rightIdx : leftIdx;
			}else if(leftIdx < this.heap.size()) { //왼쪽 자식만 있다면
				targetIdx = leftIdx;
			}else { //자식이 없다면
				break;
			}
			
			
			if(this.heap.get(idx) > this.heap.get(targetIdx)) {
				break;
			}else {
				int ParentVal = this.heap.get(idx);
				this.heap.set(idx, this.heap.get(targetIdx));
				this.heap.set(targetIdx, ParentVal);
				idx = targetIdx;
			}
			
		}
		
		return target;
		
	}
	
	
	public void printTree() {
		for(int i = 1; i < heap.size(); i++) {
			System.out.print(heap.get(i) + " ");
		}
		
		System.out.println();
	}
}

public class Practice2 {

	public static void main(String[] args) {
		MaxHeap maxheap = new MaxHeap();
		
		maxheap.insert(10);
		maxheap.insert(30);
		maxheap.insert(20);
		maxheap.insert(5);
		
		maxheap.printTree();
		
		maxheap.delete();
		
		maxheap.printTree();
	}

}
