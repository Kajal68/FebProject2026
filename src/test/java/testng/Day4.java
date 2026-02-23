package testng;

import org.testng.annotations.Test;

public class Day4 {
	
	@Test
	public void Cypress() {
		System.out.println("cypress");
	}
	
	@Test(timeOut = 2000)
	public void RESTAPI() {
		System.out.println("restapi");
	}

	@Test
	public void JMeter() {
		System.out.println("JMeter");
	}

	@Test(dependsOnMethods = {"RESTAPI"})
	public void APITest() {
		System.out.println("api testing");
	}
}
