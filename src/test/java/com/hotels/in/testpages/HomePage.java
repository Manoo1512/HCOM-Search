package com.hotels.in.testpages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hotels.in.config.Config;

public class HomePage extends BaseTestPage{
	
	WebDriver driver;
	
	@FindBy(name="q-destination")
	WebElement cityName;
	
	@FindBy(name="q-localised-check-in")
	WebElement checkInDate;
	
	@FindBy(name="q-localised-check-out")
	WebElement checkOutDate;
	
	@FindBy(xpath="//button[@class=’cta cta-strong’]")
	WebElement searchButton;
	
	public HomePage(WebDriver driver){
        this.driver = driver;
    }
	
	public void openHomePage() {
		driver.navigate().to(Config.url);
	}
	
	public void searchHotel(String location, Date checkin, Date checkout) throws Exception{
		SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
		wait(driver,10,cityName).sendKeys(location);
    	((JavascriptExecutor)driver).executeScript ("document.getElementById('qf-0q-localised-check-in').removeAttribute('readonly',0);"); 
    	wait(driver,100,checkInDate).clear();
    	wait(driver,100,checkInDate).sendKeys(dt1.format(checkin));
    	((JavascriptExecutor)driver).executeScript ("document.getElementById('qf-0q-localised-check-out').removeAttribute('readonly',0);");
    	wait(driver,100,checkOutDate).clear();
    	wait(driver,100,checkOutDate).sendKeys(dt1.format(checkout));
    	wait(driver,100,searchButton).click();
    	Thread.sleep(10000);
	}

}
