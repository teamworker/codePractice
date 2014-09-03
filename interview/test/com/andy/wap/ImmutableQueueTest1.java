package com.andy.wap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class ImmutableQueueTest1 {

	@Test(expected = IllegalArgumentException.class)
	public void testEnqueue() {
		ImmutableQueue<Integer> queue = new ImmutableQueue<Integer>();
		queue.enqueue(7).enqueue(12);
		/*
		 * enqueue() method would not change the original queue.
		 */
		assertThat(queue.size(), is(0));

		queue = queue.enqueue(12).enqueue(7);
		/*
		 * The returned queue has added the element.
		 */
		assertThat(queue.size(), is(2));
		/*
		 * If the element e is null, throws IllegalArgumentException.
		 */
		queue.enqueue(null);
	}

	@Test(expected = java.util.NoSuchElementException.class)
	public void testDequeue() {
		ImmutableQueue<Integer> queue = new ImmutableQueue<Integer>();
		queue = queue.enqueue(7).enqueue(12).enqueue(7);
		assertThat(queue.size(), is(3));

		queue.dequeue();
		/*
		 * dequeue() method would not change the original queue.
		 */
		assertThat(queue.size(), is(3));

		queue = queue.dequeue().dequeue();
		/*
		 * The returned queue has removed the element.
		 */
		assertThat(queue.size(), is(1));
		/*
		 * If this queue is empty, throws java.util.NoSuchElementException.
		 */
		queue = queue.dequeue();
		queue.dequeue();
	}

	@Test(expected = java.util.NoSuchElementException.class)
	public void testPeek() {
		ImmutableQueue<Integer> queue = new ImmutableQueue<Integer>();
		queue = queue.enqueue(7).enqueue(12);
		/*
		 * Looks at the object which is the head of this queue without removing
		 * it from the queue.
		 */
		assertThat(queue.peek(), is(7));
		assertThat(queue.size(), is(2));
		queue = queue.dequeue().dequeue();
		/*
		 * If this queue is empty, throws java.util.NoSuchElementException.
		 */
		queue.peek();
	}

	@Test
	public void testSize() {
		ImmutableQueue<Integer> queue = new ImmutableQueue<Integer>();
		for (int i = 0; i < 12; i++) {
			queue = queue.enqueue(i);
		}
		assertThat(queue.size(), is(12));
	}

	@Test
	public void testComplexity() {
		ImmutableQueue<Integer> queue = new ImmutableQueue<Integer>();
		/*
		 * Test time for 1 million times of single enqueue() method.
		 */
		long startEnqueue = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			queue.enqueue(i);
		}
		long endEnqueue = System.currentTimeMillis();
		//System.out.println("The time of 1 million times of enqueue is : "
		//		+ (endEnqueue - startEnqueue));
		queue = queue.enqueue(12);
		/*
		 * Test time for 1 million times for single dequeue() method.
		 */
		long startDequeue = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			queue.dequeue();
		}
		long endDequeue = System.currentTimeMillis();
		//System.out.println("The time of 1 million times of dequeue is : "
		//		+ (endDequeue - startDequeue));
		/*
		 * Test time for 1 million times of enqueue() method with pointing new
		 * queue.
		 */
		long startNewEnqueue = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			queue = queue.enqueue(i);
		}
		long endNewEnqueue = System.currentTimeMillis();
		//System.out
		//		.println("The time of 1 million times of enqueue with pointing new queue is : "
		//				+ (endNewEnqueue - startNewEnqueue));

		/*
		 * Test time for 1 million times of dequeue() method with pointing new
		 * queue.
		 */
		long startNewDequeue = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			queue = queue.dequeue();
		}
		long endNewDequeue = System.currentTimeMillis();
		//System.out
		//		.println("The time of 1 million times of dequeue with pointing new queue is : "
		//				+ (endNewDequeue - startNewDequeue));
	}

}
