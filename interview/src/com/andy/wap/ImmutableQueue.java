package com.andy.wap;

import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out(FIFO) queue of objects. 
 * Immutable queue can be implemented by two immutable stacks : enqueueStack and dequeueStack.
 * enqueueStack is used to enqueue element and dequeueStack is used to dequeue element.
 * 
 * @date May 26, 2014--9:26:48 AM
 * @author Andy
 * @param <E>
 */
public class ImmutableQueue<E> {
	
	private ImmutableStack<E> enqueueStack;
	private ImmutableStack<E> dequeueStack;
	
	/**
	 * requires default constructor.
	 */
	@SuppressWarnings("unchecked")
	public ImmutableQueue() {
		// modify this constructor if necessary, but do not remove default constructor
		this.enqueueStack = ImmutableStack.newStack();
		this.dequeueStack = ImmutableStack.newStack();
	}

	//add other constructors if necessary
	private ImmutableQueue(ImmutableStack<E> enqueueStack, ImmutableStack<E> dequeueStack) {
		this.enqueueStack = enqueueStack;
		this.dequeueStack = dequeueStack;
	}

	/**
	 * Returns the queue that adds an item into the tail of this queue without modifying this queue.
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (2,1,2,2,6) and we enqueue the value 4 into this queue,
	 * this method returns a new queue (2,1,2,2,6,4)
	 * and this object still represents the queue (2,1,2,2,6).
	 * </pre>
	 * If the element e is null, throws IllegalArgumentException.
	 * @param e
	 * @return
	 * @throws IllegalArgumentException
	 */
	public ImmutableQueue<E> enqueue(E e) {
		if (null == e)
			throw new IllegalArgumentException();
		return new ImmutableQueue<E>(this.enqueueStack.push(e), this.dequeueStack);
	}

	/**
	 * Returns the queue that removes the object at the head of this queue without modifying this queue.
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7,1,3,3,5,1),
	 * this method returns a new queue (1,3,3,5,1)
	 * and this object still represents the queue (7,1,3,3,5,1).
	 * </pre>
	 * If this queue is empty, throws java.util.NoSuchElementException.
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	@SuppressWarnings("unchecked")
	public ImmutableQueue<E> dequeue(){
		if (this.isEmpty())
			throw new NoSuchElementException();
		if (!this.dequeueStack.isEmpty()) {
			return new ImmutableQueue<E>(this.enqueueStack, this.dequeueStack.tail);
		} else {
			return new ImmutableQueue<E>(ImmutableStack.newStack(),
					this.enqueueStack.toDequeuStack().tail);
		}
	}
	
	/**
	 * Looks at the object which is the head of this queue without removing it from the queue.
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7,1,3,3,5,1),
	 * this method returns 7 and this object still represents the queue (7,1,3,3,5,1)
	 * </pre>
	 * If this queue is empty, throws java.util.NoSuchElementException.
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	@SuppressWarnings("unchecked")
	public E peek(){
		if (this.isEmpty())
			throw new NoSuchElementException();
		if (this.dequeueStack.isEmpty()){
			this.dequeueStack = this.enqueueStack.toDequeuStack();
		    this.enqueueStack = ImmutableStack.newStack();
		}
		return this.dequeueStack.head;
	}
	
	/**
	 * Returns the number of objects in this queue.
	 * @return
	 */
	public int size(){
		return this.enqueueStack.size + this.dequeueStack.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Internal class ImmutableStack to implement enqueueStack and dequeueStack.
	 * 
	 * @date May 27, 2014--11:01:11 AM
	 * @author Andy 
	 * @param <E>
	 */
	private static class ImmutableStack<E> {
		private E head;
		private ImmutableStack<E> tail;
		private int size;

		private ImmutableStack(E head, ImmutableStack<E> tail) {
			this.head = head;
			this.tail = tail;
			this.size = tail.size + 1;
		}

		/**
		 * Default constructor.
		 */
		private ImmutableStack() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}

		/**
		 * Reverse an nonempty enqueueStack to dequeueStack.
		 * 
		 * @return
		 */
		public ImmutableStack<E> toDequeuStack() {
			ImmutableStack<E> dequeueStack = new ImmutableStack<E>();
			ImmutableStack<E> enqueueStack = this; 
			while (!enqueueStack.isEmpty()) {
				dequeueStack = dequeueStack.push(enqueueStack.head);
				enqueueStack = enqueueStack.tail;
			}
			return dequeueStack;
		}
		
		public ImmutableStack<E> push(E e) {
			return new ImmutableStack<E>(e, this);
		}
		
		@SuppressWarnings("rawtypes")
		public static ImmutableStack newStack() {
			return new ImmutableStack();
		}

		public boolean isEmpty() {
			return this.size == 0;
		}
	
	}

}
