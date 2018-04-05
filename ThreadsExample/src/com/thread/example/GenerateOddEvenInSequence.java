package com.thread.example;

public class GenerateOddEvenInSequence {

	public static void main(String[] args) {
		GenerateOddEvenInSequence ob = new GenerateOddEvenInSequence();
		GenerateOddEvenInSequence.Monitor monitor = ob.new Monitor(true);

		GenerateOddEvenInSequence.Odd oddTask = ob.new Odd(monitor);
		GenerateOddEvenInSequence.Even evenTask = ob.new Even(monitor);
		Thread tOdd = new Thread(oddTask);
		Thread tEven = new Thread(evenTask);
		tOdd.start();
		tEven.start();
	}

	public class Odd implements Runnable {

		private final Monitor monitor;

		Odd(Monitor monitor) {
			this.monitor = monitor;
		}

		@Override
		public void run() {
			synchronized (monitor) {
				for (int i = 1; i <= 10; i += 2) {
					while (!monitor.isOdd) {
						try {
							monitor.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("Odd:" + i);
					monitor.setOdd(false);
					monitor.notifyAll();
				}
			}
		}

	}

	public class Even implements Runnable {

		private final Monitor monitor;

		Even(Monitor monitor) {
			this.monitor = monitor;
		}

		@Override
		public void run() {
			synchronized (monitor) {
				for (int i = 2; i <= 10; i += 2) {
					while (monitor.isOdd) {
						try {
							monitor.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("Even:" + i);
					monitor.setOdd(true);
					monitor.notifyAll();
				}
			}
		}

	}

	private class Monitor {
		private boolean isOdd;

		public Monitor(boolean isOdd) {
			this.isOdd=isOdd;
		}

		public boolean isOdd() {
			return isOdd;
		}

		public void setOdd(boolean isOdd) {
			this.isOdd = isOdd;
		}

	}

}
