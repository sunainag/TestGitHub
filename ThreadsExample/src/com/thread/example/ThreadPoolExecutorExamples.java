package com.thread.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorExamples {

	/*
	 * ThreadPoolExecutor is decorated with an immutable wrapper, so it cannot be
	 * reconfigured after creation. Note that also this is the reason we cannot cast
	 * it to a ThreadPoolExecutor.
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		AtomicInteger counter = new AtomicInteger();

		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		singleThreadExecutor.submit(() -> {
			counter.set(1);
		});
		singleThreadExecutor.submit(() -> {
			counter.compareAndSet(1, 2);
		});

		System.out.println(counter.get());
	}

}
