package com.andy.wap;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class ImmutableQueueTest {
	
	@Test
	public void testComplexity(){
		ImmutableQueue<Integer> queue = new ImmutableQueue<Integer>();
		long start = System.currentTimeMillis();
		for(int i=0;i<1000;i++){
			queue.enqueue(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("The enqueue time is : "+(end-start));
	}

	@Test//(expected = NoSuchElementException.class)
	public void testImmutableQueue() {
		ImmutableQueue<Integer> p = new ImmutableQueue<Integer>();
		assertThat(p.size(), is(0));
		p = p.enqueue(2);
		assertThat(p.size(), is(1));
		p = p.enqueue(9);
		assertThat(p.peek(), is(2));
		assertThat(p.size(), is(2));
		p = p.dequeue();
		assertThat(p.peek(), is(9));
		p = p.enqueue(10);
		assertThat(p.peek(), is(9));
		p = p.dequeue();
		assertThat(p.peek(), is(10));
		p = p.dequeue();
		assertThat(p.size(), is(0));
		//p.peek();
	}

	@Test
	public void testImmutableQueuePerformance() {
		ImmutableQueue<Integer> p = new ImmutableQueue<Integer>();
		int num = 0;
		int max = 1000000;
		long current = System.currentTimeMillis();
		while (++num <= max) {
			int value = (int) (Math.random() * 100);
			p = p.enqueue(value);
		}
		System.out.println("enqueue time:"
		 + (System.currentTimeMillis() - current));
		current = System.currentTimeMillis();
		while (--num > 0) {
			p = p.dequeue();
		}
		 System.out.println("dequeue time:"
		+ (System.currentTimeMillis() - current));
	}
}
