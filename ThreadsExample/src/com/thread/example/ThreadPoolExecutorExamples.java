package com.thread.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExamples {

	/*
	 * Schedule task with a delay
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
	executor.schedule(() -> {
	    System.out.println("Hello World");
	}, 500, TimeUnit.MILLISECONDS);}

}
