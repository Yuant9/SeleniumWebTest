package com.herokuapp.theinternet.basetest;

public class TestUtils extends BaseTest{

	
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
