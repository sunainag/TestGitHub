package com.thread.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample {

	/*
	 * When creating Phaser instance from the main thread, we’re passing 1 as an
	 * argument. This is equivalent to calling the register() method from the
	 * current thread. We’re doing this because, when we’re creating three worker
	 * threads, the main thread is a coordinator, and therefore the Phaser needs to
	 * have four threads registered to it. we need to call the arriveAndDeregister()
	 * method as the main thread is still registered in the Phaser. When the
	 * deregistration causes the number of registered parties to become zero, the
	 * Phaser is terminated. All calls to synchronization methods will not block
	 * anymore and will return immediately
	 */

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser(1);

		System.out.println("The phase after the initialization is equal to :" + ph.getPhase());

		System.out.println("Let’s say that three threads should conduct the first phase of processing. ");
		executorService.submit(new LongRunningAction("thread-1", ph));
		executorService.submit(new LongRunningAction("thread-2", ph));
		executorService.submit(new LongRunningAction("thread-3", ph));
		ph.arriveAndAwaitAdvance();
		System.out.println("The phase after the completion is equal to :" + ph.getPhase());

		System.out.println("Let’s say that two threads should conduct the next phase of processing. ");
		executorService.submit(new LongRunningAction("thread-4", ph));
		executorService.submit(new LongRunningAction("thread-5", ph));
		ph.arriveAndAwaitAdvance();
		System.out.println("The phase after the completion is equal to :" + ph.getPhase());

		ph.arriveAndDeregister();
	}

}

class LongRunningAction implements Runnable {

	/*
	 * The thread signals that it arrived at the barrier by calling the
	 * arriveAndAwaitAdvance(), which is a blocking method. When the number of
	 * arrived parties is equal to the number of registered parties, the execution
	 * of the program will continue, and the phase number will increase. We can get
	 * the current phase number by calling the getPhase() method.
	 * 
	 * When the thread finishes its job, we should call the arriveAndDeregister()
	 * method to signal that the current thread should no longer be accounted for in
	 * this particular phase.
	 */

	private String threadName;
	private Phaser ph;

	LongRunningAction(String threadName, Phaser ph) {
		this.threadName = threadName;
		this.ph = ph;
		ph.register();
	}

	@Override
	public void run() {
		System.out.println("Thread "+this.threadName+" before long running action");
		ph.arriveAndAwaitAdvance();
		System.out.println("Thread "+this.threadName+" going to sleep");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread "+this.threadName+" after long running action");
		ph.arriveAndDeregister();
	}
}
