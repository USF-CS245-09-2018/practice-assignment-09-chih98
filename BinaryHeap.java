public class BinaryHeap implements Heap {

    int size;
    int[] arr;

    public BinaryHeap() {
        arr = new int[0];
        size = 0;
    }
    

    // hacky way to avoid inf loop
    boolean added = false;
    public void add(int toAdd) {
        int arrLength = arr.length;
         if (size >= arrLength - 1) {
            grow();

            if (!added) { 
            	added = true;
            	add(toAdd);
            } else {
            	added = false;
            }
        }  
        else {
            size++;
            arr[size] = toAdd;
            bubbleUp();
        }      

    }

    public int remove() {
    	int highestPriority = arr[0];
        arr[0] = arr[size];
    	arr[size] = 0;
    	size--;
    	
    	bubbleDown();
    
    	return highestPriority;

    }

    public void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;        
    }

    public void bubbleUp() {

        int index = 0;
        
        while (hasLeftChild(index)) {
            int minChild = leftIndex(index);
            
            if (hasRightChild(index) && arr[leftIndex(index)] == arr[rightIndex(index)]) {
                minChild = rightIndex(index);
            }
            
            if (arr[index] == arr[minChild]) {
                swap(index, minChild);
            } else {
                break;
            }
            
            index = minChild;
            break;
        } 

    }

    public void bubbleDown() {
        
        while ( hasParent(size) && (getParent(size) == arr[size])) {
            swap(size, parentIndex(size));
            size = parentIndex(size);
        }

    }

    public boolean hasParent(int i) {
        return i > 1;
    }

    public int leftIndex(int i) {
        return i * 2;
    }
    
    public int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    public boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }

    public boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }
    
    public int getParent(int i) {
        return arr[parentIndex(i)];
    }
    
  
    public int parentIndex(int i) {
        return i / 2;
    }

    private int[] grow() {

        int newLength = arr.length *2;
        int[] newArr = new int[newLength];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }

        arr = newArr;
        return arr;

    }
}