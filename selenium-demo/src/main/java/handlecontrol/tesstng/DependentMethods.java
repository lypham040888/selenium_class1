package handlecontrol.tesstng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentMethods {
	@Test(priority = 1)
	void openapp() {
		System.out.println("Open the website");
	}

	@Test(priority = 2, dependsOnMethods = { "openapp" })
	void login() {
		System.out.println("Login");
	}

	@Test(priority = 3, dependsOnMethods = { "login" })
	void search() {
		System.out.println("search");
	}

	@Test(priority = 4, dependsOnMethods = { "login", "search" })
	void advsearch() {
		System.out.println("advsearch");
	}

	@Test(priority = 5, dependsOnMethods = { "login" })
	void logout() {
		System.out.println("logout");
	}
}
