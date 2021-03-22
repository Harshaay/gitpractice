package com.crm.practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PracticeLaunchTest {
@Test
public void chromelaunch()
{
	System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com");
	driver.close();
}
@Test
public void geckolaunch() throws Throwable
{
	System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.naukri.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(2000);
	Set<String> wh = driver.getWindowHandles();
	for(String window:wh)
	{
		String title = driver.switchTo().window(window).getTitle();
		System.out.println(title);
		if(title.contains("amazon"))
		{
			driver.manage().window().maximize();
			break;
		}
	}
	String url = driver.getCurrentUrl();
	System.out.println(url);
	
}
}
