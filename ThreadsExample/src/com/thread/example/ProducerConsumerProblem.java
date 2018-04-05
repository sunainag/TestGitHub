package com.thread.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		BlockingQueue<Integer> ob = new LinkedBlockingQueue<>();
		Runnable cons = new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						System.out.println("Consumed:"+ob.take());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		};
		
		Runnable prod = new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					try {
						System.out.println("Produced:"+i);
						ob.put(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		};
		
		Thread t1 = new Thread(prod);
		Thread t2 = new Thread(cons);
		
		t1.start();
		t2.start();
	}

}
