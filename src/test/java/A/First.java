package A;

import org.testng.annotations.Test;

public class First {
	@Test(groups = { "regression" })	
	public void m1() {
		System.out.println("m1");
	}

	@Test(groups = { "regression" })
	public void m2() {
		System.out.println("m2");
	}

	@Test
	public void m3() {
		System.out.println("m3");
	}

	@Test
	public void m4() {
		System.out.println("m4");
	}
}
