package stepDefinitions;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@After
	public void AfterScenario() {
//		testContextSetup.testBase.WebDriverManager().quit();
	}

}
