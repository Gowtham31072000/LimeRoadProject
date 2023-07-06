package com.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
	static WebDriver driver;
	static Actions a;

    // 1 Launch Browser
    public static WebDriver launchBrowser(String browsername) {    
    if (browsername.equalsIgnoreCase("chrome")) {
                
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    else if (browsername.equalsIgnoreCase("firefox")) {
                
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }    
    else if (browsername.equalsIgnoreCase("edge")) {
        
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }    
    driver.manage().window().maximize();
    return driver;
    }
	
	public static WebDriver launchUrl(String url) {
		driver.get(url);
		return driver;
	}

	public static void ClickOnElement (WebElement element) {
		element.click();
	}
	public static void inputToElement(WebElement element ,String value ) {
		element.sendKeys(value);
	}
	public static void screenshot(String fileName) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\user\\eclipse-workspace\\Maven\\Screenshot" +fileName+".png");
		FileHandler.copy(src, dest);
	}
	public static void dropdownforselect(WebElement element,String opt, String value) {
		Select s =new Select(element);
		if(opt.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		}
		else if (opt.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
		else if (opt.equalsIgnoreCase("index")) {
			int index=Integer.parseInt(value);
			s.selectByIndex(index);
		}
	}

	public static void SwitchToFrame(String opt,String value) {
		if(opt.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			driver.switchTo().frame(index);
		}
		else if(opt.equalsIgnoreCase("idOrName")) {
			driver.switchTo().frame(value);
		}
	}
	public static void SwtichToFrameUsingElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	public static void RightClickUsingMouse(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).build().perform();
	}
	public static void MouseOver (WebElement element) {
		a=new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	public static void dragdrop(WebElement src,WebElement dest) {
		a=new Actions(driver);
		a.dragAndDrop(src,dest).build().perform();
	}
	public static void implicityWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS)	;
	}
	public static void explicityWait(int sec,String condition, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		if(condition.equalsIgnoreCase("visibility")) {
		//	wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	}
	public static void switchFrameByElement(WebElement element) {
		driver.switchTo().frame(element);
    }


}
