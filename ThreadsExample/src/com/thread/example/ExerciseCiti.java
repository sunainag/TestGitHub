package com.thread.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ExerciseCiti {

	public static void main(String[] args) {
		// to be shared between threads
		ThreadLocal<Integer> count = new ThreadLocal<>();
		count.set(1);
		//reset barrier
		CyclicBarrier barrier = new CyclicBarrier(3, () -> {
			count.get();
		});
		
		Thread t1Thread = new Thread(() -> {
			while(count.get()<4) {
				System.out.println(count.get());
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				
			}
		});

		Thread t2Thread = new Thread(() -> {
			while(count.get()<4) {
				System.out.println(count.get());
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t3Thread = new Thread(() -> {
			while(count.get()<4) {
				System.out.println(count.get());
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1Thread.start();
		t2Thread.start();
		t3Thread.start();
	}

}

