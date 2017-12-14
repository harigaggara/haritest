package junitwebapp1;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.junit.Test;

import org.junit.Before;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class JWebUnitTest1 {

	@Before
	public void prepare() {

		setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
		setBaseUrl("http://localhost:8081/junitwebapp");
	}

	@Test
	public void testLoginPage() {
		beginAt("index.jsp");
		assertTitleEquals("Login");
		assertLinkPresent("home");
		clickLink("home");
		assertTitleEquals("Home");
	}

	@Test
	public void testHomePage() {
		beginAt("home.jsp");
		assertTitleEquals("Home");
		assertLinkPresent("login");
		clickLink("login");
		assertTitleEquals("Login");
	}

}
