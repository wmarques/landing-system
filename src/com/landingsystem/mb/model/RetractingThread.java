package com.landingsystem.mb.model;

public class RetractingThread extends CentralThread {
	public static int RETRACTING_TIME = 280;
	public static int MAX_RETRACTING_TIME = 10000;
	
	public int timing;
	public boolean done;
	public Element el;
	
	public RetractingThread(Element in){
		super(in);
		super.MAX_TIME = in.MAX_RETRACTING_TIME;
		super.USUAL_TIME = in.USUAL_RETRACTING_TIME;
	}
	
}
