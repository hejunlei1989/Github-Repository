package net.hjl.DataStructure;

//最小值在根处
//capacity 二叉堆最大容量
//size 二叉堆实际大小
public class BinaryHeap {
	
	private int capacity;
	private int size;
	private int[] dataArray;
	
	public BinaryHeap(int capacity){
		this.capacity = capacity;
		this.size = 0;
		dataArray = new int[capacity+1];
	}
	
	public boolean isFull(){
		return size>=capacity;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void insert(int data){
		if(this.isFull()){
			if(dataArray[1] < data){
				this.deleteTop();
				this.insert(data);
			}
			return;
		}else{
			size++;
			int pos = size;
			while(pos>1){
				if(data < dataArray[pos/2]){
					dataArray[pos] = dataArray[pos/2];
					pos = pos/2;
				}else{
					break;
				}
			}
			dataArray[pos] = data;
		}
	}
	
	public void deleteTop(){
		if (this.isEmpty()) return;
		if(size==1){
			size--;
			return;
		}
		int pos=1;
		dataArray[1] = dataArray[size];
		size --;
		while(2*pos <= size){
			if(2*pos +1 <= size){
				if(dataArray[pos] < dataArray[2*pos] && dataArray[pos] < dataArray[2*pos+1]){
					break;
				}
				if(dataArray[2*pos] < dataArray[2*pos +1]){
					dataArray[pos] = dataArray[2*pos]^dataArray[pos];
					dataArray[2*pos] = dataArray[2*pos]^dataArray[pos];
					dataArray[pos] = dataArray[2*pos]^dataArray[pos];
					pos = 2*pos;
				}else{
					dataArray[pos] = dataArray[2*pos+1]^dataArray[pos];
					dataArray[2*pos+1] = dataArray[2*pos+1]^dataArray[pos];
					dataArray[pos] = dataArray[2*pos+1]^dataArray[pos];
					pos = 2*pos + 1;
				}
			}else{
				if(dataArray[pos] < dataArray[2*pos]){
					break;
				}else{
					dataArray[pos] = dataArray[2*pos]^dataArray[pos];
					dataArray[2*pos] = dataArray[2*pos]^dataArray[pos];
					dataArray[pos] = dataArray[2*pos]^dataArray[pos];
					pos = 2*pos;
				}
			}
		}
	}
	
	public void printHeap(){
		if(this.isEmpty()){
			System.out.println("NULL");
			return;
		}
		int line_num = 1;
		int count = 1;
		for(int i = 1; i<=size; i++){
			System.out.print(this.dataArray[i]);
			count--;
			if(count==0){
				System.out.println();
				line_num = line_num*2;
				count = line_num;
			}
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BinaryHeap test_heap = new BinaryHeap(10);
		test_heap.insert(10);
		//test_heap.printHeap();
		test_heap.insert(1);
		//test_heap.printHeap();
		test_heap.insert(9);
		//test_heap.printHeap();
		test_heap.insert(4);
		//test_heap.printHeap();
		test_heap.insert(7);
		//test_heap.printHeap();
		test_heap.insert(8);
		//test_heap.printHeap();
		test_heap.insert(3);
		//test_heap.printHeap();
		test_heap.insert(2);
		//test_heap.printHeap();
		test_heap.insert(6);
		//test_heap.printHeap();
		test_heap.insert(5);
		//test_heap.printHeap();
		test_heap.insert(0);
		test_heap.printHeap();
		
		//test_heap.deleteTop();
		//test_heap.printHeap();
	}

}
