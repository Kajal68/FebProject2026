package testng;

import org.testng.annotations.Test;

public class Day1 {
	
	@Test(groups= {"Smoke"})
	public void method() {
		System.out.println("m1");
	}
	
	@Test
	public void method2() {
		System.out.println("m2");
	}

}
