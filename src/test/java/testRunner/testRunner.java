package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
				plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						,"listener.ListenerPlugin"}, 
				features = {"src/test/resources/AppFeatures" }, 
				glue = { "stepdefinitions", "AppHooks" }
//				tags = "@PlaceId"
//				
				)

public class testRunner extends AbstractTestNGCucumberTests{
		
/*
 * If require Parallel Execution uncomment the below line of code
 */
	
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}



}
