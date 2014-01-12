package com.example.training.timer.event;

/**
 * Simple utilities class for benchmarking unit tests. Use is a follows:
 * TestTimer t = new TestTimer("My task"); // Do something t.done();
 */
public class TestTimer {

	private long startTime;
	private String message;

	/**
	 * Initiate a timer
	 */
	public TestTimer(String message) {
		startTime = System.currentTimeMillis();
		this.message = message;
	}

	/**
	 * Reset the timer for another timing session.
	 * 
	 */
	public void reset() {
		startTime = System.currentTimeMillis();
	}

	/**
	 * End the timing session and output the results.
	 */
	public void done() {

		System.out.println(message + " : " + (System.currentTimeMillis() - startTime) + " ms.");
	}
}
