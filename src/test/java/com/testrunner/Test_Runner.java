package com.testrunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.BaseClass.Base_class;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\user\\eclipse-workspace\\Cucumber\\LimeRoadProject\\src\\test\\java\\com\\feature\\LimeRoad.feature",
glue="com.stepdefination")
public class Test_Runner extends Base_class{

	public static WebDriver driver;
	
	@BeforeClass
	public static void browserlaunch() {
		driver = launchBrowser("Chrome");

	}
	
	
}
