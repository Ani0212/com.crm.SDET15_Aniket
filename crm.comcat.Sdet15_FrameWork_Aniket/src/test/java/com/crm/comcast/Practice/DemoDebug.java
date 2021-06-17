package com.crm.comcast.Practice;

import org.testng.annotations.Test;

public class DemoDebug {
	
	@Test
	public void sampleDebug() {
		int y = division(10,0);
		System.out.println(y);
	}

	public int division(int a, int b)
	{
		int z = a/b;
		return z;
	}
}
