package lab1;
import java.util.Iterator;
import java.util.NoSuchElementException;

import lab1.MyLinkedListNode;

public class MyLinkedList<T>  implements Iterable<T>{
	private int mSize;
	private MyLinkedListNode<T> mHead;
	private MyLinkedListNode<T> mTail;

	public MyLinkedList() {
		mSize = 0;
		//Creating block-nodes;
		mHead = new MyLinkedListNode<T>();
		mTail = new MyLinkedListNode<T>();
		mTail.setPreviousNode(mHead);
		mHead.setNextNode(mTail);
	}
	
	public final int size() {
		return mSize;
	}
	
	public void addLast(T value) {
		MyLinkedListNode<T> newNode = new MyLinkedListNode<T>();
		newNode.setData(value);
		MyLinkedListNode<T> preValue = mTail.getPrevious();
		preValue.setNextNode(newNode);
		newNode.setPreviousNode(preValue);
		newNode.setNextNode(mTail);
		mTail.setPreviousNode(newNode);
		mSize++;
	}
	
	public void addFirst(T value) {
		MyLinkedListNode<T> newNode = new MyLinkedListNode<T>();
		newNode.setData(value);
		MyLinkedListNode<T> preValue = mHead.getNext();
		preValue.setPreviousNode(newNode);
		newNode.setNextNode(preValue);
		newNode.setPreviousNode(mHead);
		mHead.setNextNode(newNode);
		mSize++;
	}
	
	public void removeFirst() {
		mHead.getNext().getNext().setPreviousNode(mHead);;
		mHead.setNextNode(mHead.getNext().getNext());
		mSize--;
	}
	
	public void removeLast() {
		mTail.getPrevious().getPrevious().setNextNode(mTail);
		mTail.setPreviousNode(mTail.getPrevious().getPrevious());
		mSize--;
	}
	
	public T getFirst() {
		if(mSize == 0) {
			throw new NoSuchElementException("Exception of accessing null element");
		}
		return mHead.getNext().getData();
	}
	
	public T getLast() {
		if(mSize == 0) {
			throw new NoSuchElementException("Exception of accessing null element");
		}
		return mTail.getPrevious().getData();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyListIterator();
	}
	
	public void remove(T value){
		MyLinkedListNode<T> currentNode = mHead.getNext();
		MyLinkedListNode<T> prevNode = mHead;
		while(currentNode != mTail) {
			if(currentNode.getData().equals(value)) {
				prevNode.setNextNode(currentNode.getNext());
				currentNode.getNext().setPreviousNode(prevNode);
				mSize--;
			}

			currentNode = currentNode.getNext();
			prevNode = currentNode.getPrevious();
		}
	}
	/**
	 * Class ListIterator implements Iterator interface with it's
	 * default methods*/
 	public class MyListIterator implements Iterator<T>{
		private MyLinkedListNode<T> mCurrentNode;
		public MyListIterator() {
			if(mHead == null) {
				throw new NoSuchElementException("Exception of accessing null element");
			}
			mCurrentNode =  MyLinkedList.this.mHead.getNext();
		}

		public final T value() {
			return mCurrentNode.getData();
		}
		@Override
		public final boolean hasNext() {
			return mCurrentNode != mTail;
		}

		public final boolean hasPrevious() {
			return mCurrentNode != mHead;
		}
		
		@Override
		public T next() {
			if (mCurrentNode == null) {
		        throw new NoSuchElementException("There are no more elements in the list");
		    }

		    T element = mCurrentNode.getData();
		    mCurrentNode = mCurrentNode.getNext();
		    return element;
		}
		
		public T previous() {
			if (mCurrentNode == null) {
		        throw new NoSuchElementException("There are no more elements in the list");
		    }

		    T element = mCurrentNode.getData();
		    mCurrentNode = mCurrentNode.getPrevious();
		    return element;
		}
	}
}
