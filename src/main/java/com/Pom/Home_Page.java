package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	public WebDriver driver;
	
	@FindBy(xpath ="//span[text()='SHOP MEN']")
	
	private WebElement login;
	
	public Home_Page(WebDriver driv) {
		driver=driv;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogin() {
		return login; 
	}

				

}
