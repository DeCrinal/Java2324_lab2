package lab1;

public class MyLinkedListNode<T> {
	private T mValue;
	MyLinkedListNode<T> mPrev;
	MyLinkedListNode<T> mNext;
	
	public final T getData() {
		return mValue;
	}
	
	public final MyLinkedListNode<T> getNext(){
		return mNext;
	}
	
	public final MyLinkedListNode<T> getPrevious(){
		return mPrev;
	}
	
	public void setData(T newValue) {
		this.mValue = newValue;
	}
	
	public void setPreviousNode(MyLinkedListNode<T> node) {
		mPrev = node;
	}

	public void setNextNode (MyLinkedListNode<T> node) {
		mNext = node;
	}

	
}
