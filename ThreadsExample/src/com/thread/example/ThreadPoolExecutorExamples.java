package com.thread.example;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorExamples {

	public static void main(String[] args) {
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> System.out.println("Hello World"));

	}

}
