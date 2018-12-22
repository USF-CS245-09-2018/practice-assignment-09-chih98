public interface Heap {


	public void add(int toAdd);
	public int remove();
	public void swap(int a, int b);
	public void bubbleUp();
	public void bubbleDown();
	public boolean hasParent(int i);
	public int leftIndex(int i);
	public int rightIndex(int i);
	public boolean hasLeftChild(int i);
	public boolean hasRightChild(int i);
	public int getParent(int i);
	public int parentIndex(int i);
	
}