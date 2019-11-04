import java.util.Arrays;

public class BinaryHeap{
	private int size = 0;
	private int[] data = new int[10];

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

	public int remove(){
		int root = data[0];
		data[0] = data[--size];
		siftdown(0);
		return root;
	}

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

	private void swap(int[] data, int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

}