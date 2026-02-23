package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2 {
	
	@Parameters({"URL"})
	@Test
	public void method01(String url) {
		System.out.println("m01");
		System.out.println(url);

	}
	@Test
	public void method11() {
		System.out.println("m11");
	}
	
	@Test(groups= {"Smoke"})

	public void method22() {
		System.out.println("m22");
	}


}
