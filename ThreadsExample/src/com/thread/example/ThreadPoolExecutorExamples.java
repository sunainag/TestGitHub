package com.thread.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExamples {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
		ScheduledFuture<?> future = executor.scheduleWithFixedDelay(() -> {
			System.out.println(
					" execute a task after 500 milliseconds delay and then repeat it every 100 milliseconds. After scheduling the task, we wait until it fires three times using the CountDownLatch lock, then cancel it using the Future.cancel() method");
			latch.countDown();
		}, 500, 100, TimeUnit.MILLISECONDS);

		latch.await(1000,TimeUnit.MILLISECONDS);
		future.cancel(true);
	}

}
