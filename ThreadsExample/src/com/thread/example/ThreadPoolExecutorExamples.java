package com.thread.example;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorExamples {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> System.out.println("Hello World"));

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<String> future = executorService.submit(() -> "Hello World");
		// some operations
		String result = future.get();
		
		Future future1 = executorService.submit(new Callable() {

            public Object call() {
                throw new RuntimeException("Unchecked exception");

            }
        });
		// some operations
		//Object result1 = future1.get();
		
		
		Integer age = -1;

		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
		    if(age < 0) {
		        throw new IllegalArgumentException("Age can not be negative");
		    }
		    if(age > 18) {
		        return "Adult";
		    } else {
		        return "Child";
		    }
		}).handle((res, ex) -> {
		    if(ex != null) {
		        System.out.println("Oops! We have an exception - " + ex.getMessage());
		        return "Unknown!";
		    }
		    return res;
		});

		System.out.println("Maturity : " + maturityFuture.get()); 
		
		
		ThreadPoolExecutor newFixedexecutor = 
				  (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
				newFixedexecutor.submit(() -> {
				    Thread.sleep(1000);
				    return null;
				});
				newFixedexecutor.submit(() -> {
				    Thread.sleep(1000);
				    return null;
				});
				newFixedexecutor.submit(() -> {
				    Thread.sleep(1000);
				    return null;
				});
				 
	}

}
