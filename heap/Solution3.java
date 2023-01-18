package heap;

import java.util.ArrayList;

// Solution 3
// 정수들을 힙 자료구조에 추가하고 n번 삭제 후 절대 값이 큰 값부터 출력하세요.


//입력: 3, 0, -2, -5, 9, 6, -11, 20, -30

// 삭제 횟수 : 1

//출력: 20 -11 9 6 -5 3 -2 0 


class Num {
	int val;
	boolean isMinus;
	
	
	public Num(int val) {
		this.val = Math.abs(val);
		this.isMinus = val < 0 ? true : false; 
	}
}


class MaxHeap2 {
	ArrayList<Num> heap;
	
	public MaxHeap2() {
		this.heap = new ArrayList<Num>();
		this.heap.add(new Num(0)); //인덱스 0번 위치에 0 데이터 삽입 이후 1번 인덱스부터 데이터를 삽입하기 위함.
	}
	
	
	public void insert(Num data) {
		this.heap.add(data);
		
		int idx = this.heap.size()-1; //현재 십입된 노드의 위치 인덱스 값
		
		//현재 삽입된 노드의 값이 부모 노드 값보다 더 크다면 
		while(idx > 1 && data.val > this.heap.get(idx / 2).val) {
			this.heap.set(idx, this.heap.get(idx / 2)); //현재 노드의 데이터 값을 부모 노드의 데이터로 변환시킨다.
			idx /=2;
		}
		
		this.heap.set(idx, data);
	}
	
	
	public Num delete() {
		if(this.heap.size() == 1) {
			System.out.println("heap is empty");
			return null;
		}
		
		
		Num target =  this.heap.get(1); //루트 노드를 꺼낸다.
		
		this.heap.set(1, this.heap.get(this.heap.size()-1)); //마지막 노드 데이터를 루트 노드 값으로 세팅
		this.heap.remove(this.heap.size()-1);
		
		int idx = 1;
		
		while(true) {
			int leftIdx =  idx * 2;
			int rightIdx =  idx * 2 + 1;
			
			int targetIdx = -1;
			
			
			if(rightIdx < this.heap.size()) { //왼쪽, 오른쪽 둘다 있다면
				targetIdx  = this.heap.get(leftIdx).val < this.heap.get(rightIdx).val ? rightIdx : leftIdx;
			}else if(leftIdx < this.heap.size()) { //왼쪽 자식만 있다면
				targetIdx = leftIdx;
			}else { //자식이 없다면
				break;
			}
			
			
			if(this.heap.get(idx).val > this.heap.get(targetIdx).val) {
				break;
			}else {
				Num ParentVal = this.heap.get(idx);
				this.heap.set(idx, this.heap.get(targetIdx));
				this.heap.set(targetIdx, ParentVal);
				idx = targetIdx;
			}
			
		}
		
		return target;
		
	}
}

public class Solution3 {
	
	
	public static void solution(int[] nums, int deleteCnt) {
		
		MaxHeap2 maxheap = new MaxHeap2();
		
		for(int i = 0; i < nums.length; i++) {
			maxheap.insert(new Num(nums[i]));
		}
		
		
		for(int i = 0; i < deleteCnt; i++) {
			Num data = maxheap.delete();
		}
		
		
		for(int i = 0; i < nums.length-deleteCnt; i++) {
			Num data = maxheap.delete();
			
			
			if(data.isMinus == true) {
				System.out.print(-data.val + " ");
			}else {
				System.out.print(data.val + " ");
			}
			
		}
	}
	
	
	public static void main(String[] args) {
			
		int nums[] = {3, 0, -2, -5, 9, 6, -11, 20, -30};
		int deleteCnt = 1;
		
		solution(nums, deleteCnt);
		
	}

}
	