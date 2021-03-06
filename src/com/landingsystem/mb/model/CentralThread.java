package com.landingsystem.mb.model;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
/**
 * 
 * @author grosalex
 * This is the basic element of an action
 */
public abstract class CentralThread extends Service<Integer> {

	protected int USUAL_TIME;
	protected int MAX_TIME;
	private int timing;
	private boolean done;
	public volatile boolean flag;

	/**
	 * Default constructor
	 * @param el the subject element of the action
	 */
	public CentralThread(Element el) {
		this.timing = 0;
		this.done = false;
		this.flag = true;
	}
	/**
	 * the action
	 */
	@Override
	protected Task<Integer> createTask() {
		return new Task<Integer>() {
			@Override
			protected Integer call() throws Exception {
				timing = 0;
				done = false;
				while (timing < MAX_TIME && !done && flag) {
					System.out.println(timing);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						if (isCancelled()) {

							return timing;
						}
						e.printStackTrace();
					}
					
					timing++;

					if (timing == USUAL_TIME) {
						done = true;
					}
					if (isCancelled()) {
						return timing;
					}
				}
				return timing;
			}
		};
	}

}
