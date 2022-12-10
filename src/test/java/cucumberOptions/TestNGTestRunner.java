package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/java/features", 
		glue = "stepDefinitions", 
		monochrome = true, 
		tags="@PlaceOrder or @OffersPage",
		plugin= {"html:target/cucumber-myreport.html", 
				"json:target/cucumber-myreport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	
}

/*
	Running tests from command line:
	
	mvn test   -> runs everything
	mvn test -Dcucumber.filter.tags="@PlaceOrder"   -> run tests with specified tags, overrides tags parameter in @CucumberOptions from this file
	mvn test -Dcucumber.features="src/test/java/features/productCart.feature"   -> run tests from specified feature file
	mvn test -Dbrowser=firefox   -> run tests with specified properties, e.g., browser in which the test will run	
	
*/
