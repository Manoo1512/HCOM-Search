package com.hotels.in.testpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListingPage extends BaseTestPage{
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"filter-popular-contents\"]/ul/li")
	List<WebElement> popularFilter;
	
	@FindBy(xpath="//*[@id=\"enhanced-sort\"]/li")
	List<WebElement> sortByOptions;
	
	@FindBy(xpath="//*[@id=\"sort-submenu-price\"]/li/a")
	WebElement sortByPriceHighToLow;
	
	@FindBy(xpath="//*[@id=\"sort-submenu-price\"]/li[2]/a")
	WebElement sortByPriceLowToHigh;
	
	@FindBy(xpath="//*[@class='p-name']")
	List<WebElement> hotelNameList;
	
	@FindBy(xpath="//*[@class='price']")
	List<WebElement> hotelPriceList;
	
	public ListingPage(WebDriver driver){
		this.driver=driver;
	}
	
	 public void applyPopularFilter(String filterName) throws InterruptedException {
		 for (WebElement element : popularFilter){
			 if (element.getText().equals(filterName))
			    	element.click();
		 }
		 Thread.sleep(5000);
	    }

	public void sortByPrice(String option, String order) throws InterruptedException {
		for(WebElement element : sortByOptions){
			if (element.getText().equals(option))
				element.click();
		}
	    	//sortByPrice.click();
	    	if(order.equalsIgnoreCase("Price (high to low)"))
	    	wait(driver,10,sortByPriceHighToLow).click();
	    	else
	    		wait(driver,10,sortByPriceLowToHigh).click();
	    	Thread.sleep(5000);	
	    }

	public List<String> getHotelNameAndPriceList() {
    	List<String> hotels = new ArrayList<String>();
    	/*JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");*/
    	int i=0;
    	for (WebElement webElement1 : hotelPriceList) {
        		hotels.add(hotelNameList.get(i).getText() + "," + webElement1.getText().split(" ")[hotelPriceList.get(i).getText().split(" ").length-1]);
        		i++;
			}
		return hotels;
    }   
}
