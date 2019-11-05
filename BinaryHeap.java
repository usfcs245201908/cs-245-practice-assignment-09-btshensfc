import java.util.Arrays;

public class BinaryHeap{
	private int size = 0;
	private int[] data = new int[10];

	/**
	*add element to array, swap of parent greater than child until case no longer so.
	* @param ele
	*/
	public void add(int ele){       
		if (size == data.length){
			growArray();
		}
		data[size++] = ele;
		int child = size-1;
		int parent = (child - 1) / 2;
		while((data[parent] > data[child]) && parent >= 0){  
			swap(data, parent, child);
			child = parent;
			parent = (child-1)/2;
		}
	}

	/**
	* remove first element 
	* @return first element 
	*/
	public int remove(){
		int root = data[0];
		data[0] = data[--size];
		siftdown(0);
		return root;
	}

	/**
	* from index pos, iterate through array and swap parent and child 
	* @return pos 
	*/
	private void siftdown(int pos){
		int child = 2*pos+1;
		if (child < size){
			if((data[child] > data[child+1]) && ((child+1) < size)){
				++child;
			}
			if (data[pos] > data[child]){
				swap(data, pos, child);
				siftdown(child);
			}
		}
	}

	private void growArray(){
		int[] temp = new int[data.length*2];
		for (int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}

	/**
	* swap 2 elements 
	* @param data
	* @param a
	* @param b 
	*/
	private void swap(int[] data, int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

}
