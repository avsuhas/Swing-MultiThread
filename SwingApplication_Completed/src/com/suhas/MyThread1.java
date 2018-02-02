package com.suhas;

import java.util.concurrent.atomic.AtomicLong;

import javax.swing.JEditorPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MyThread1 extends Thread {
	
	private int count = 0;
    private Object lock = new Object();
	private volatile static AtomicLong grandTotal = new AtomicLong(0);

	private int interval = 10;
	private JProgressBar progressBar = null;
	private JTextField grandTotalTxt = null;
	private JEditorPane progressTxt = null;
	public boolean isWorking = true;
	private Object monitor = new Object();
	
	public MyThread1(int interval, JProgressBar progressBar, JEditorPane progressTxt, JTextField grandTotalTxt){
		this.interval = interval;
		this.progressBar = progressBar;
		this.grandTotalTxt = grandTotalTxt;
		this.progressTxt = progressTxt;
	}
	
    public void incrementCount() {
	    count++;
	    criticalSection();	    
	    progressBar.setValue(count);
    	progressTxt.setText(String.valueOf(count));
    	grandTotalTxt.setText(String.valueOf(grandTotal.get()));
    	
    }
    
    public void setPause() {
    	isWorking = false;
    }
    
    public void setResume() {
    	isWorking = true;
    	synchronized(monitor) {
            monitor.notifyAll();
         }
    }
    
    public void criticalSection() {
    	synchronized(grandTotal) {
    		grandTotal.set(grandTotal.get() + 1);
    		try {
    			sleep(10);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}	
    	}
    	
    	
    }
    
    public void setStart(){
    	start();
    	synchronized(monitor) {
            monitor.notifyAll();
         }
    }

	public void run() {
		while(count<100) {
			if(!isWorking) {
				synchronized(monitor) {
					try {
			            monitor.wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
			}
			this.incrementCount();
			try {
				sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
}
