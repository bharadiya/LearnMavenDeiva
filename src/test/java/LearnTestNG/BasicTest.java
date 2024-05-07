package LearnTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTest {
	@BeforeTest
	public void checkBeforeTest() {
		System.out.println("Login to FB");
	}

	@AfterTest
	public void checkAfterMethodTest() {
		System.out.println("After method for clean up activities");
	}

	@BeforeMethod
	public void checkBeforeMethodTest() {
		System.out.println("Before Method for creating prerequisite");
	}

	@AfterMethod
	public void checkAfterTest() {
		System.out.println("Logout to FB");
	}

	@Test
	public void B() {
		System.out.println("1");
	}

	@Test
	public void A() {
		System.out.println("2");
	}

	@Test
	public void CA() {
		System.out.println("3");
	}

	@Test(priority = 1)
	public void DB() {
		System.out.println("4");
	}

	@Test(priority = -1)
	public void B123() {
		System.out.println("5");
	}

	@Test
	public void A235() {
		System.out.println("6");
	}
}

//- in test-ng every method with @Test annotation is a test case
//- the thing I am writing on the top of method is called as annotation