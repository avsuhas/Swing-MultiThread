package com.suhas;

public class MainClass {
	
	public static void main(String[] args) {
	
		MyThread1 t1 = new MyThread1(0,null,null,null);
		MyThread1 t2 = new MyThread1(0,null,null,null);
		MyThread1 t3 = new MyThread1(0,null,null,null);
		MyThread1 t4 = new MyThread1(0,null,null,null);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	
	}

}
