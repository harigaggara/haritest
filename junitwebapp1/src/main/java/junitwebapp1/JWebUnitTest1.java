package junitwebapp1;

/*import static net.sourceforge.jwebunit.junit.JWebUnit.*;*/

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.Test;

import org.junit.Before;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class JWebUnitTest1 {
	private WebTester tester;


	@Before
	public void prepare() {
		tester = new WebTester();
		tester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
		tester.setBaseUrl("http://localhost:8081/junitwebapp");
	}

	@Test
	public void testLoginPage() {
		tester.beginAt("index.jsp");
		tester.assertTitleEquals("Login");
		tester.assertLinkPresent("home");
		tester.clickLink("home");
		tester.assertTitleEquals("Home");
	}

	@Test
	public void testHomePage() {
		tester.beginAt("home.jsp");
		tester.assertTitleEquals("Home");
		tester.assertLinkPresent("login");
		tester.clickLink("login");
		tester.assertTitleEquals("Login");
	}

}
