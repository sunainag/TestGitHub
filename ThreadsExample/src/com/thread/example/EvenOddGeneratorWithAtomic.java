package com.thread.example;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddGeneratorWithAtomic {
	
	public static void main(String[] args) {
		AtomicInteger counter = new AtomicInteger(1);
		Thread evenThread = new Thread(new EvenOddGeneratorWithAtomic().new EvenOddPrinter(
				true, counter));
		Thread oddThread = new Thread(new EvenOddGeneratorWithAtomic().new EvenOddPrinter(
				false, counter));

		evenThread.start();
		oddThread.start();
	}
	
	class EvenOddPrinter implements Runnable {
		boolean isEven;
		AtomicInteger counter;
		private final int MAX = 20;

		public EvenOddPrinter(boolean isEven, AtomicInteger counter) {
			this.isEven = isEven;
			this.counter = counter;
		}

		@Override
		public void run() {
			synchronized (counter) {
				while(counter.get() < MAX) {
					if(isEven) {
						while(counter.get() % 2 !=0) {
							try {
								counter.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("Even -"+counter.get());
						
					} else {
						while(counter.get() % 2 == 0) {
							try {
								counter.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("Odd -"+counter.get());
						
					}
					counter.incrementAndGet();
					counter.notifyAll();
				}
			}
		}
	}

}
