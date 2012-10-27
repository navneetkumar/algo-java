import com.sun.accessibility.internal.resources.accessibility;

public class Sorting {
	
	public Sorting(){
		
	}
	
	public int[] bubbleSort(int[] array){
		int[] sortedArray = copy(array);
		for(int i= 0; i < sortedArray.length-1 ; i++){
			for(int j = i+1; j < sortedArray.length; j++){
				if(sortedArray[i] > sortedArray[j]) swap(sortedArray, i, j);
			}
		}
		return sortedArray;
	}
	
	public int[] selectionSort(int[] array){
		int[] sortedArray = copy(array);
		for(int i= 0; i < sortedArray.length-1 ; i++){
			int minIndex = i;
			for(int j = i; j < sortedArray.length; j++){
				if(sortedArray[minIndex] > sortedArray[j]) minIndex = j;
			}
			swap(sortedArray,i,minIndex);
		}
		return sortedArray;
	}
	
	public int[] insertionSort(int[] array){
		int[] sortedArray = copy(array);
		for(int i=1;i< sortedArray.length; i++){
			int pivot = sortedArray[i];
			int j = i;
			while(j>0 && sortedArray[j-1] > pivot){
				sortedArray[j] = sortedArray[j-1];
				j--;
			}
			sortedArray[j] = pivot;
		}
		return sortedArray;
	}
	
	public int[] mergeSort(int[] array){
		int[] sortedArray = copy(array);
		return sortedArray;
		
	}
	
	
	public int[] generateArray(int size){
		int[] randomArray = new int[size];
		for(int i=0;i < randomArray.length; i++){
			randomArray[i] = (int)(Math.random() * 100);
		}
		return randomArray;
	}
	
	public void print(int[] array){
		for(int i=0; i < array.length ; i++){
			System.out.print(Integer.toString(array[i]) + " | ");
		}
	}
	
	private void swap(int[] array, int sourceIndex, int targetIndex){
		int tmp = array[targetIndex];
		array[targetIndex] = array[sourceIndex];
		array[sourceIndex] = tmp;
	}
	
	private int[] copy(int [] array){
		return (int[]) array.clone();
	}

}
