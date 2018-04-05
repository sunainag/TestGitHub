package com.thread.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecutorExamples {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> System.out.println("Hello World"));

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<String> future = executorService.submit(() -> "Hello World");
		// some operations
		String result = future.get();
	}

}
