package handlecontrol.tesstng;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AnnotationsPriorityDemo1 {
	@BeforeMethod
	void login() {
		System.out.println("Login...");
	}

	@Test(priority = 2)
	void search() {
		System.out.println("Search...");
	}

	@Test(priority = 1)
	void advacedsearch() {
		System.out.println("Advanced search...");
	}

	@Test(priority = 4)
	void advacedsearch2() {
		System.out.println("Advanced search...");
	}

	@Test(priority = 3)
	void advacedsearch3() {
		System.out.println("Advanced search...");
	}
	@AfterMethod
	void logout() {
		System.out.println("Logout...");
	}

}
